/**
 * Thing absztrakt osztaly, minden a palyan megtalalhato dolog, mint
 * Character, Box, vagy Wall, amik egy Field mezore kerulhetnek ose.
 * @author Peter
 */
public abstract class Thing implements Collidable {
	
	/** Annak a Field-nek a referenciaja, ami az adott Thing-et tartalmazza. */
    protected Field field;
    
    /**Akkor hivodik meg, amikor egy Thing osztalynak nekiutkozik egy masik
     * a Collidable interfacet megvalosito palyaelem.
     * @param	collidable	Az az objektum, ami meglokte ezen Thing-et.
     * @param	weightSum	Az utkozesi sorban szamolt pillanatnyi suly koefficiens.
     * @return				A collideWith fuggveny altal szamitott suly.
     */
    public abstract int hitBy(Collidable collidable, int weightSum);

    /**Eltarolja referenciakent a Thing, hogy o melyik Field mezon van eppen.
     * @param 	field	Az a Field, amin eppen tartozkodik ez a Thing.
     */
    public void setField(Field field) {
        this.field = field;
    }

    /**Lekerdezi azt a Field mezot, amin eppen tartozkodik.
     * @return	Az a Field, amin eppen tartozkodik ez a Thing.
     */
    public Field getField() {
        return field;
    }

    /** A palyan levo Thing dolog valamilyen a Direction enumeracio iranyaba mozgasra tesz kiserletet.
     * @param 	d	Az az irany, amerre a Thing mozogni probal.
     */
    public void move( Direction d ) {}
    
    /** Feluldefinialando
     *  Meghivja a GraphicsMain megfelelo (egyezo parameteru) Init fuggvenyet
     *  amely ezutan kirajzolja.
     *  @param	gm	GraphicsMain parameterkent atadva, meglegyen hivva annak az Init fuggvenye.
     */
	public void callInit(Graphics gm) {}

}