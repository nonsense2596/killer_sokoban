/**
 * A palyan jelenlevo celmezokert felelos osztaly. Ha egy celmezore tol egy
 * Character egy Box-ot, akkor pontot kap erte.
 * @author Peter
 */
public class Goal extends Field {

	/**Character kerul egy Goal mezore, semmi sem tortenik.
	 * @param	c	Character kerul ra, a Goal csak Box-nal csinal barmit is, kulonben NormalField-kent viselkedik.
	 */
    @Override
    public void action(Character c) {
    }

    /** Ha Box kerul a celmezore, akkor az a Box lekerul a palyarol,
     * es a dobozt a lyukba tolo Character-nek pontot ir jova a TurnManager.
     * @param	b	Az a Box, ami rakerul a Goal mezore.
     */
    public void action(Box b) {
        removeThing(b);
        TurnManager.goal();
    }
    
    /** Feluldefinialt java.Object toString metodus, a teszteles parancssoros kiiratasahoz kell.
     * @return	"G" karakterrel ter vissza, mint [G]oal.
     */
    @Override
	public String toString(){
		return "G";				
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
