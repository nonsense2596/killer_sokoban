/**
 * Fal objektum, eltolhatatlan, ha nekitolnak jatekost doboz altal,
 * akkor a nekitolt jatekos meghal.
 * @author Peter
 *
 */
public class Wall extends Thing {

    /**Akkor hivodik meg, amikor egy Wall osztalynak nekiutkozik egy masik
     * a Collidable interfacet megvalosito palyaelem.
     * Meghivja az utkozest kivalto elemre a collideWith fuggvenyt.
     * @param	collidable	Az az objektum, ami meglokte ezen dobozt.
     * @param	weightSum	Az utkozesi sorban szamolt pillanatnyi suly koefficiens.
     * @return				A collideWith fuggveny altal szamitott suly.
     */
    public int hitBy(Collidable collidable, int weightSum) {
        return collidable.collideWith(this, weightSum);
    }
    
    /** Ez a Wall mas elemmel utkozik. A Wall mozdithatatlan, ezert mindig 999-el ter vissza.
     * @param	c			Az a Character, amivel ez a Wall utkozik.
     * @param	weightSum	Az utkozesi lanc altal szamitott eddigi suly. Eldobjuk, mivel ez Wall, es nem fog mozgas tortenni.
     * @return				999, mert a Wall mozdithatatlan.
     */
    public int collideWith(Character c, int weightSum) {
        return 999;
    }
    
    /** Ez a Wall mas elemmel utkozik. A Wall mozdithatatlan, ezert mindig 999-el ter vissza.
     * @param	b			Az a Box, amivel ez a Wall utkozik.
     * @param	weightSum	Az utkozesi lanc altal szamitott eddigi suly. Eldobjuk, mivel ez Wall, es nem fog mozgas tortenni.
     * @return				999, mert a Wall mozdithatatlan.
     */
    public int collideWith(Box b, int weightSum) {
        return 999;
    }
    
    /** Ez a Wall mas elemmel utkozik. A Wall mozdithatatlan, ezert mindig 999-el ter vissza.
     * @param	w			Az a Wall, amivel ez a Wall utkozik.
     * @param	weightSum	Az utkozesi lanc altal szamitott eddigi suly. Eldobjuk, mivel ez Wall, es nem fog mozgas tortenni.
     * @return				999, mert a Wall mozdithatatlan.
     */
    public int collideWith(Wall w, int weightSum) {
        return 999;
    }
    
    /** Feluldefinialt java.Object toString metodus, a teszteles parancssoros kiiratasahoz kell.
     * @return	"W" karakterrel ter vissza, mint [W]all.
     */
    @Override
    public String toString(){
    	return "W";
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