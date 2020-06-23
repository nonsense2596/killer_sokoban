/**
 * A palyan talalhato Switch kapcsolo objektumok osztalya. Feladatuk, hogy amennyiben
 * Box kerul egy Switch-re, akkor a Switch-ben referenciakent tarolt Trap csapda objektum
 * nyitottsagi allapotat invertaljak, ezzel aktivalva vagy deaktivalva azt.
 * @author Peter
 */
public class Switch extends Field {
	
	/** Azon Trap referenciaja, amit az adott Switch aktival, deaktival */
    private Trap trap;

    /**Character kerult a Switch-re, semmit sem csinal, mivel
     * Switch-et csak Box hoz mukodesbe.
     * @param	c	A Character ami a Switch-re kerult.
     */
    @Override
    public void action(Character c) {
    }

    /**Linkelunk egy Switch peldanyhoz egy Trap-et. Letrejon a csapda-kapcsolo kapcsolat.
     * @param 	trap	Az a Trap peldany, aminek az adott Switch lesz a kapcsoloja.
     */
    public void addTrap(Trap trap){
        this.trap=trap;
    }

    /**Box kerult a Switch-re, megvaltoztatja ezen Switch-hez
     * tarsitott Trap allapotat.
     * @param	b	A Box ami a Switch-re kerult.
     */
    public void action(Box b ) {
        trap.switchTrapState();		// fix this gonosz crashing code - FIXD
    }
   
    
    /** Lekerul a mezorol egy Box, ezert a tarolasi pozicios linkjet eldobjuk,
     *  de elotte az action fuggvenyt meghivjuk, mert a Switch-et ki kell kapcsolni, miutan
     *  a Box mar nem tartja mukodesbe.
     * @param	b	Az a Box, ami lekerul a mezorol.
     */
    @Override
    public void removeThing(Box b) {
    	action(b);
        thing = null;
    }
    
    /** Feluldefinialt java.Object toString metodus, a teszteles parancssoros kiiratasahoz kell.
     * @return	"S" karakterrel ter vissza, mint [S]witch.
     */
	public String toString(){
		return "S";				
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
