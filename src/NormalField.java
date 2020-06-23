/**
 * Egy ures mezot jelkepezo osztaly.
 * Nincsenek specialis tulajdonsagai, nem tortenik semmi, ha Box vagy Character lep ra.
 * Erre a mezore tudnak a Character-ek mezet vagy olajat lepakolni, novelve vagy csokkentve
 * ezzel a weightModifier koefficiens erteket.
 * @author	Peter
 */
public class NormalField extends Field {
	
	/** Az adott NormalField "sulya". A karakterek altal esetlegesen ratett
	 * mez vagy olaj noveli vagy csokkenti ennek erteket. Alapbol nincs "sulya" egy mezonek */
	private int weightModifier = 0;
    
	/**A NormalField-re ralepo Box sulyat modositjuk a weightModifier ertekevel.
	 * @param 	b	Az a Box, ami rakerult a NormalField-re. 
	 */
    public void modifyWeight(Box b) {
    	int currentWeight = b.getWeight();
    	b.setWeight(currentWeight + weightModifier);
    }
    
	/**A NormalField-re ralepo Characternek nincsen sulya, ezert nem adunk hozza semmit.
	 * @param 	c	Az a Character, ami rakerult a NormalField-re. 
	 */
    // 
    public void modifyWeight(Character c) {}
    
	/**A NormalField-rol lelepo Box sulyat visszaallitjuk a ralepes elotti ertekre.
	 * @param 	b	Az a Box, ami lekerul a NormalField-rol. 
	 */
    public void restoreWeight(Box b) {
    	int currentWeight = b.getWeight();
    	b.setWeight(currentWeight - weightModifier);
    }

	/**A NormalField-re ralepeskor sem valtozott a Character sulya, ezert nincs is mit visszaallitani.
	 * @param 	c	Az a Character, ami lekerul a NormalField-rol. 
	 */
    public void restoreWeight(Character c) {}
    
    /**Rakerul a mezore egy Box, ezert meghivjuk ra a modifyWeight sulymodosito fuggvenyt
     * es beallitjuk a Box poziciojaul ezt a mezot.
     * @param	b	Az a Box, ami rakerul a mezore.
     */
    @Override
    public void addThing( Box b ) {
        thing = b;
        b.setField(this);
        modifyWeight(b);
    }
    
    /** Lekerul a mezorol egy Box, ezert a tarolasi pozicios linkjet eldobjuk,
     * de elott a sulyat is visszaallitjuk az eredetire.
     * @param	b	Az a Box, ami lekerul a mezorol.
     */
    @Override
    public void removeThing(Box b) {
    	restoreWeight(b);
        thing = null;
    }
    
	/** Ha Character lep NormalField-re, nem tortenik semmi extra.
	 * @param	c	A Character ami ralepett a NormalField mezore.
	 */
	@Override
    public void action(Character c) {
    }
	
    /** Olaj kerul a mezore, negativ iranyba billenti el egyel a
     * weightModifier valtozonak az erteket.
     */
	@Override
    public void placeOil() {
    	weightModifier--;
    }
	
    /** Mez kerul a mezore, negativ iranyba billenti el egyel a
     * weightModifier valtozonak az erteket.
     */
	@Override
    public void placeHoney() {
    	weightModifier++;
    }
    /** Feluldefinialt java.Object toString metodus, a teszteles parancssoros kiiratasahoz kell.
     * @return	" " karakterrel ter vissza, ami a NormalField "ures mezo" tulajdonsagat hivatott vizualizalni.
     */
	@Override
	public String toString(){
		return " ";	
	}
	
	/** Visszaadja a NormalField sulymodosito erteket.
     * @return	A NormalField sulymodosito erteke.
     */
	public int getWeightModifier() {
		return weightModifier;
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
