import java.util.HashMap;
import java.util.Map;

/**
 * A palyaelemek, a mezok kozos tulajdonsagaiert felelos absztrakt osztaly.
 * A tenylegesen is a palyan megjelenitheto, specialis tulajdonsagokkal es viselkedesekkel rendelkezo
 * mezo elemek a kovetkezoek: NormalField, Trap, Hole, Switch, Goal
 * @author	Peter
 */
public abstract class Field implements Visitable{
	
	/** Adott Field szomszedjait tarolja a negy egtaj iranyaban */
    private Map< Direction, Field > neighbours;
    
    /** A Field-en levo Thing referenciaja */
    protected Thing thing;

    /**
     * A Field mezo konstruktora, inicializalja a szomszedsagi osszerendeleseket tartalmazo HashMap adattagot.
     */
    public Field() {
        neighbours = new HashMap<>();
    }

    /** A mezore rakerul egy Character objektum, amit referenciakent megkap, beallitja azt a sajat maga thing mezojebe a Field.
     * @param	c	Az a Character, ami rakerul az adott Field-re.
     */
    public void addThing( Character c ) {
    	thing = c;
        c.setField(this);
    }
    
    /** A mezore rakerul egy Box objektum, amit referenciakent megkap, beallitja azt a sajat maga thing mezojebe a Field.
     * @param	b	Az a Box, ami rakerul az adott Field-re.
     */
    public void addThing( Box b ) {
        thing = b;
        b.setField(this);
    }
    
    /** A mezore rakerul egy Wall objektum, amit referenciakent megkap, beallitja azt a sajat maga thing mezojebe a Field.
     * @param	b	Az a Wall, ami rakerul az adott Field-re. Ez csak palyageneralaskor futhat le.
     */
    public void addThing( Wall w ) {
        thing = w;
        w.setField(this);
    }

    
    /** A mezorol lekerulo Character objektum. Eltavolitja a mezon levo elemet. 
     * @param	c	Eltavolitja a sajat thing referenciajat ha parameterul kap valamit.
     */
    public void removeThing(Character c) {
        thing = null;
    }
    
    /** A mezorol lekerulo Box objektum. Eltavolitja a mezon levo elemet. 
     * @param	b	Eltavolitja a sajat thing referenciajat ha parameterul kap valamit.
     */
    public void removeThing(Box b) {
        thing = null;
    }
    
    /** A mezorol lekerulo Wall objektum. Eltavolitja a mezon levo elemet. 
     * @param	w	Eltavolitja a sajat thing referenciajat ha parameterul kap valamit.
     */
    public void removeThing(Wall w) {
        thing = null;
    }

    /** Lekerdezi az adott mezo szomszedjait a Direction enumeracioban felsorolt egyik iranyban.
     * @param 	d	Az az irany, amerre a lekerdezes tortenik.
     * @return		Visszater a kivant szomszedos mezo referenciajaval.
     */
    public Field getNeighbour( Direction d ) {
        return neighbours.get(d);
    }

    /** Megnezi, hogy ures-e sajat maga.
     * @return	Boolean ertek, ha true akkor ures, ha false akkor nem ures a mezo.
     */
    public boolean isEmpty() {
        return ( thing == null );
    }

    /** Visszaadja a mezon levo dolgot. Egy mezon egyszerre csak
     * egy dolog lehet.
     * @return	A mezon levo dolog referenciaja.
     */
    public Thing getThing() {
        return thing;
    }

    /** Beallitja a szomszedjait a Direction enumeracioban felsorolt egyik iranyban.
     * @param 	d	Az az irany, amerre a lekerdezes tortenik.
     * @param	f	Az adott iranyban levo szomszedos mezo, amit szomszednak fog beallitani az adott iranyban.
     */
    public void setNeighbour( Direction d, Field f ) {
        neighbours.put(d,f);
    }

    /** Ha Field mezore kerul egy Character, akkor meghivodik ra az action fuggveny,
     *  ezt a Field absztrakt osztalyt megvalosito osztalyok a megfelelo modon definialjak felul.
     * @param c	A Field-re kerulo Character objektum.
     */
    public void action( Character c ) {}
    
    /** Ha Field mezore kerul egy Box, akkor meghivodik ra az action fuggveny,
     *  ezt a Field absztrakt osztalyt megvalosito osztalyok a megfelelo modon definialjak felul.
     * @param b	A Field-re kerulo Box objektum.
     */
    public void action( Box b ) {}
    
    /** Az adott Field allapotat valtoztatjuk.
     */
    public void switchState() {}
    
    /** Adott Field mezore olajat helyezunk le.
     */
    public void placeOil() {}
    
    /** Adott Field mezore mezet helyezunk le.
     */
    public void placeHoney() {}
    
    /** Feluldefinialt java.Object toString metodus, a teszteles parancssoros kiiratasahoz kell.
     * @return	"F" karakterrel ter vissza, mint [F]ield. Sosem hivodik meg, de a feluldefinialasi sor miatt biztos ami biztos. :)
     */
    @Override
    public String toString(){
    	return "F";
    }
    
    /** Feluldefinialando
     *  Meghivja a GraphicsMain megfelelo (egyezo parameteru) Init fuggvenyet
     *  amely ezutan kirajzolja.
     *  @param	gm	GraphicsMain parameterkent atadva, meglegyen hivva annak az Init fuggvenye.
     */
	public void callInit(Graphics gm) {}

}
