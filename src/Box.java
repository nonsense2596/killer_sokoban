/**
 * A palyan megjeleno, a jatekos altal indirekt modon mozgathato doboz objektumokert felelos osztaly.
 * @author	Peter
 */
public class Box extends Thing {
	
	/**Egy doboz sulya. */
	private int weight = 2;

	/**Lekerdezi az adott dobott sulyat. Ez pillanatnyilag alapertelmezetten 3.
	 * @return			Visszaadja a doboz sulyat.	
	 */
    public int getWeight(){
        return weight;
    }
    /** Beallitja a doboz sulyat a parameterul kapott ertekre
     * @param w 		A parameterul kapott ertek, amire beallitod a doboz sulya.
     */
    public void setWeight(int w){
        weight = w;
    }

    /**Akkor hivodik meg, amikor egy Box osztalynak nekiutkozik egy masik
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

    /** Ez a doboz a tole currentDirection iranyba levo karakterrel utkozik.
     * @param	c			Az a karakter, amivel ez a doboz utkozik.
     * @param	weightSum		Az utkozesi lanc altal szamitott eddigi suly.
     * @return			Az utkozesi lanc altal szamitott suly.
     */
    @Override
    public int collideWith(Character c, int weightSum) {
    	if ( c == null ){											
    		return weightSum + this.weight;
    	}
    	Direction cd = TurnManager.getCurrentDirection(); 									
		Field bfield = c.getField();
		Field nextField = bfield.getNeighbour(cd); 
    	Thing th = nextField.getThing();
    	if ( th == null)
    		return weightSum;
    	return th.hitBy(c, weightSum + this.weight);
    }

    
    /** Ez a doboz a tole currentDirection iranyba levo dobozzal utkozik.
     * @param	b			Az a doboz, amivel ez a doboz utkozik.
     * @param	weightSum		Az utkozesi lanc altal szamitott eddigi suly.
     * @return			Az utkozesi lanc altal szamitott suly.
     */
    @Override
    public int collideWith(Box b, int weightSum) {
        if ( b == null ){										
            return weightSum + this.weight;
        }
    	 Direction cd = TurnManager.getCurrentDirection();
 		Field bfield = b.getField();
 		Field nextField = bfield.getNeighbour(cd); 
     	Thing th =  nextField.getThing();
     	if ( th == null )
     		return  weightSum + b.getWeight();					
        return th.hitBy(b, weightSum + this.weight);
    }

    /** Ez a doboz a tole currentDirection iranyba levo fallal utkozik.
     * @param	w			Az a fal, amivel ez a doboz utkozik.
     * @param	weightSum		Az utkozesi lanc altal szamitott eddigi suly.
     * @return			Az utkozesi lanc altal szamitott suly, ami fal eseteben fixen a maskeppen elerhetetlen 999-es ertek.
     */
    @Override
    public int collideWith(Wall w, int weightSum) {
        return 999;   								
    }

    /** Doboz mozog adott iranyba. Megnezi a kovetkezo mezot, megnezi, hogy lephet-e ra, azaz, hogy ures-e
     * ha nem ures, akkor rekurzivan megy vegig az utban levo elemeken, es sorba nezi, hogy esetlegesen milyen
     * dolgokat kell majd a sorban eltolnia, amennyiben talal a sorban egy ures mezot (vagy lyukat vagy csapdat)
     * es nem utkozik altala mozdithatatlan elembe, mint ket jatekos egymas utan vagy fal.
     * @param	d			Az az irany, amiben adott korben a Thing-ek mozognak.
     */
    public void move( Direction d ) {
        Field nextField = field.getNeighbour(d);

        if (nextField.isEmpty()) {
            field.removeThing(this);
            nextField.addThing(this);
            nextField.action(this);
        } else {
            Thing nextThing = nextField.getThing();

            int weightSum = nextThing.hitBy(this, weight);

            if (weightSum < 999) {
                nextThing.move(d);
                field.removeThing(this);
                nextField.addThing(this);
                nextField.action(this);
                
            }
        }
    }
    
    /** Feluldefinialt java.Object toString metodus, a teszteles parancssoros kiiratasahoz kell.
     * @return	"B" karakterrel ter vissza, mint [B]ox.
     */
    @Override
    public String toString(){
    	return "B";
    }
    /** Meghivja a GraphicsMain megfelelo (egyezo parameteru) Init fuggvenyet
     *  amely ezutan kirajzolja.
     *  @param	gm	GraphicsMain parameterkent atadva, meglegyen hivva annak az Init fuggvenye.
     */
    @Override
	public void callInit(Graphics gm) {
		gm.Init(this);
	}
}
// ryuujou best shipfu