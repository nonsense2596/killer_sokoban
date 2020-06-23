/**A hole elemet kepviselo grafikus osztaly
 * @author Gergo
 */
import javax.swing.ImageIcon;

public class gHole implements Drawable{
	
	/** A gHole kiskepe */
	private ImageIcon img= new ImageIcon("Lyuk30.png");
	
	/** A gHole altal megjelenitett Hole referenciaja. */
	protected Hole hole;

	/** Parameteres konstruktor ami beallitja a tagvaltozot a parameterre.
     *  @param h 	A tagvaltozonak beallitando parameter
     */
	gHole(Hole h){
		hole = h;
	}
	
	/** Visszaadja az megfelelo ImageIcon-t.
     *  @return	Az osztálynak megfelelo ImageIcon.
     */
	@Override
	public ImageIcon Draw() {
		return img;
	}

	/** Visszaadja megegyezik-e a tagvaltozo a parameterben kapottal
     *  @return	igazzal ter vissza ha megegyeznek, hamissal ha nem
     */
	@Override
	public boolean Compare(Visitable v) {
		if(v == hole) {
			return true;
		}
		else return false;
	}

	/** Visszaadja megegyezik e a tagvaltozo a parameterben kapottal
     *  @return	mindig false, sosem lehet collidable visitable
     */
	@Override
	public boolean Compare(Collidable c) {
		return false;
	}
	
}
