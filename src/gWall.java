/**A wall elemet kepviselo grafikus osztaly
 * @author Gergo
 */
import javax.swing.ImageIcon;

public class gWall implements Drawable{
	
	/** A gWall kiskepe */
	private ImageIcon img = new ImageIcon("Fal230.png");
	
	/** A gWall altal megjelenitett Wall referenciaja */
	protected Wall wall;

	/** Parameteres konstruktor ami beallitja a tagvaltozot a parameterre.
     *  @param w 	A tagvaltozonak beallitando parameter
     */
	gWall(Wall w){
		wall = w;
	}
	
	/** Visszaadja a Wall-nak megfelelo ImageIcon-t.
     *  @return	Wall-nak megfelelo ImageIcon.
     */
	@Override
	public ImageIcon Draw() {
		return img;
	}

	/** Visszaadja megegyezik e a tagvaltozo a parameterben kapottal
     *  @return	mindenkepp false, visitable nem lehet wall
     */
	@Override
	public boolean Compare(Visitable v) {
		return false;
	}
	
	/** Visszaadja megegyezik e a tagvaltozo a parameterben kapottal
     *  @return	igaz ha megegyeznek, hamis ha nem
     */
	@Override
	public boolean Compare(Collidable c) {
		if(c == wall) {
			return true;
		}
		else return false;
	}
	
}
