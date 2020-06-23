/**
 * A palyan megjeleno, a jatekos altal direkt modon mozgathato karakter objektumokert felelos osztaly.
 * @author	Peter
 */
public class Character extends Thing implements Collidable {
	
	/** Egy karakter megszerzett pontjai. */
    private int point;
    
	/** Egy karakter hatralevo ideje. */
    private int timer;
    
	/** Egy karakter ereje. */
    private int strength;
    
	/** Egy karakter hatralevo mezeinek szama. */
    private int oilCounter;
    
	/** Egy karakter hatralevo olajainak szama. */
    private int honeyCounter;
    
	/** Aktiv-e az adott karakter. */
    private boolean active;

    /** A karakter konstruktora, beallitja az alapertelmezett tulajdonsagait, mint
     *  pillanatnyilag megszerzett pontok szama, timer (parancssorban meg nem mukodik),
     *  a karakter eleje, hogy aktiv-e a karakter, es az adott karakter altal a palyara
     *  leteheto mezek vagy olajok szama. 
     */
    public Character()
    {
    	point = 0;
    	timer = 300;
    	strength = 5;
    	oilCounter = 2;
    	honeyCounter = 2;
    	active = false;
    }

    /** Ha a karakter egy celra tolt egy ladat, akkor kap erte egy pontot 
     */
    public void addPoint() {
        ++point;
    }

    /**Akkor hivodik meg, amikor egy Character osztalynak nekiutkozik egy masik
     * a Collidable interfacet megvalosito palyaelem.
     * Meghivja az utkozest kivalto elemre a collideWith fuggvenyt.
     * @param	collidable	Az az objektum, ami meglokte ezen dobozt.
     * @param	weightSum	Az utkozesi sorban szamolt pillanatnyi suly koefficiens.
     * @return				A collideWith fuggveny altal szamitott suly.
     */
    @Override
    public int hitBy(Collidable collidable,int weightSum) {
        return collidable.collideWith(this, weightSum);
    }

    /** Ez a karakter a tole currentDirection iranyba levo dobozzal utkozik.
     * @param	b			Az a doboz, amivel ez a doboz utkozik.
     * @param	weightSum		Az utkozesi lanc altal szamitott eddigi suly.
     * @return			Az utkozesi lanc altal szamitott suly.
     */
    @Override
    public int collideWith(Box b, int weightSum) {
    	if ( b == null ){						
            return weightSum;
        }
    	Direction cd = TurnManager.getCurrentDirection();   
    	
		Field bfield = b.getField();
		Field nextField = bfield.getNeighbour(cd); 
    	Thing th =  nextField.getThing();
    	if ( th == null ) {
    		return  weightSum + b.getWeight();
    	}

    	return th.hitBy(b, weightSum + b.getWeight());
    }

    /** Ez a doboz a tole currentDirection iranyba levo fallal utkozik.
     * Ha aktiv karakter utkozik a falnak, nem tortenik semmi.
     * @param	w			Az a fal, amivel ez a doboz utkozik.
     * @param	weightSum		Az utkozesi lanc altal szamitott eddigi suly.
     * @return			Az utkozesi lanc altal szamitott suly, vagy ha aktiv a jatekos akkor 999.
     */
    @Override
    public int collideWith(Wall w, int weightSum) {
    	boolean b = (this == TurnManager.getCurrentPlayer());
    	if ( b ) {										
            return 999;
        }
        else {
        	field.removeThing(this);
        	TurnManager.killPlayer(this);
            return weightSum;										
        }
    }

    /** Ez a doboz a tole currentDirection iranyba levo karakterrel utkozik.
     *  Karakter nem tud elmozditani masik karaktert
     * @param	c			Az a karakter, amivel ez a doboz utkozik.
     * @param	weightSum		Az utkozesi lanc altal szamitott eddigi suly.
     * @return			Az utkozesi lanc altal szamitott suly, ami mas karakter eseteben fixen a maskeppen elerhetetlen 999-es ertek.
     */
    public int collideWith(Character c, int weightSum) {
        return 999;
    }

    /** Lekerdezi, hogy aktiv-e az adott karakter
     * @return	Boolean ertek, ha true akkor aktiv, ha false akkor nem aktiv a lekerdezett karakter.
     */
    public boolean isActive() {
        return active;
    }

    /** Aktivva vagy inaktivva teszi az adott karaktert a paramterul megkapott ertek alapjan.
     * @param active	Aktiv vagy inaktiv legyen-e az adott karakter.
     */
    public void setActive( Boolean active ) {
        this.active = active;
    }

    /** Megnezi, hogy halott-e vagy sem az adott karakter. Akkor tekintunk egy karaktert
     * halottnak, ha a hatralevo ideje 0, mivel akkor a TurnManager osztaly nem ad neki kort.
     * Ha meghal a karakter, kinullazzuk az idejet.
     * @return	Boolean ertek, hogy halott-e a karakter vagy sem.
     */
    public boolean isDead() {
    	// omae wa mou shindeiru
        return ( timer <= 0 );
    }

    /** Csokkenti az aktualis karakter hatralevo idejet egy egyseggel 
     */
    public void reduceTimer() {
        timer--;
        if(this.isDead()){
        	TurnManager.killPlayer(TurnManager.getCurrentPlayer());
        }
    }

    /**jatek elejen inicializalja az osszes karakter idejet
     * ugyanazzal a kezdoertekkel. ezzel az idovel gazdalkodhat
     * a jatekos a teljes jatek alatt. ha lejar, a karakter meghal
     * es deaktivalodik
     * @param timeRemaining	A karakterek kezdoidejet ebben a parameterben megkapott ertekkel inicializalja.
     * */
    public void setTimer( int timeRemaining ) {
        timer = timeRemaining;
    }

    /** Lekerdezi az aktualis karakter pillanatnyilag megszerzett pontjainak szamat.
     */
    public int getPoint() {
        return point;
    }

    /** Jatekos mozog adott iranyba. Megnezi a kovetkezo mezot, megnezi, hogy lephet-e ra, azaz, hogy ures-e
     * ha nem ures, akkor rekurzivan megy vegig az utban levo elemeken, es sorba nezi, hogy esetlegesen milyen
     * dolgokat kell majd a sorban eltolnia, amennyiben talal a sorban egy ures mezot (vagy lyukat vagy csapdat)
     * es nem utkozik altala mozdithatatlan elembe, mint ket jatekos egymas utan vagy fal.
     * @param	d			Az az irany, amiben adott korben a Thing-ek mozognak.
     */
    public void move(Direction d ) {
    	
        Field nextField = field.getNeighbour(d);

        if ( nextField.isEmpty() ) {
            field.removeThing(this);
            nextField.addThing( this );
            nextField.action(this);
        } else {
            Thing nextThing = nextField.getThing();

            int weightSum = nextThing.hitBy(this, 0);
            if (weightSum <= this.strength || (!isActive() && weightSum < 999)) {
                nextThing.move(d);                
                field.removeThing(this);
                nextField.addThing(this);
                nextField.action(this); 
            }
        }
    }

    /** A jatekos olajat tesz le arra a mezore, amin eppen tartozkodik
     *  Az olaj csokkenti az adott mezo suly koefficiens weightModifier mezojenek erteket.
     */
    public void placeOil() {
    	if(oilCounter > 0) {
    		oilCounter--;
    		field.placeOil();
    	}
    }
    
    /** A jatekos mezet tesz le arra a mezore, amin eppen tartozkodik
     *  A mez noveli az adott mezo suly koefficiens weightModifier mezojenek erteket.
     */
    public void placeHoney() {
    	if(honeyCounter > 0) {
    		honeyCounter--;
    		field.placeHoney();
    	}
    }
    /** Feluldefinialt java.Object toString metodus, a teszteles parancssoros kiiratasahoz kell.
     * @return	"C" karakterrel ter vissza, mint [C]haracter.
     */
    @Override
    public String toString(){
    	return "C";
    }
    
    /** Meghivja a GraphicsMain megfelelo (egyezo parameteru) Init fuggvenyet
     *  amely ezutan kirajzolja.
     *  @param	gm	GraphicsMain parameterkent atadva, meglegyen hivva annak az Init fuggvenye.
     */
    @Override
	public void callInit(Graphics gm) {
		gm.Init(this);
	}
    
    
    /** Visszaadja a karakter hatralevo idejet.
     *  @return	Karakter hatralevo ideje.
     */
    public int getTimer() {
    	return timer;
    }
}


