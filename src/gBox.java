/**A box elemet kepviselo grafikus osztaly
 * @author Gergo
 */
import javax.swing.ImageIcon;

public class gBox implements Drawable{
	
	/** A gBox kiskepe. */
	private ImageIcon img= new ImageIcon("Doboz30.png");
	
	/** A gBox altal megjelenitett Box referenciaja */
	protected Box box;
	
	/** Parameteres konstruktor ami beallitja a tagvaltozot a parameterre.
     *  @param b 	A tagvaltozonak beallitando parameter
     */
	gBox(Box b){
		box = b;
	}

	/** Visszaadja az megfelelo ImageIcon-t.
     *  @return	Az osztálynak megfelelo ImageIcon.
     */
	@Override
	public ImageIcon Draw() {
		return img;
	}

	/** Visszaadja megegyezik e a tagvaltozo a parameterben kapottal
     *  @return	mindig false, sosem lehet collidable visitable
     */
	@Override
	public boolean Compare(Visitable v) {
		return false;
	}

	/** Visszaadja megegyezik e a tagvaltozo a parameterben kapottal
     *  @return	igazzal ter vissza ha megegyeznek, hamissal ha nem
     */
	@Override
	public boolean Compare(Collidable c) {
		if(c == box) {
			return true;
		}
		else return false;
	}
	
}
