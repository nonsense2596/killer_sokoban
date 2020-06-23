/**A goal elemet kepviselo grafikus osztaly
 * @author Gergo
 */
import javax.swing.ImageIcon;

public class gGoal implements Drawable{
	
	/** A gGoal kiskepe. */
	private ImageIcon img= new ImageIcon("Cel30.png");
	
	/** A gGoal altal megjelenitett Goal referenciaja */
	protected Goal goal;

	/** Parameteres konstruktor ami beallitja a tagvaltozot a parameterre.
     *  @param g 	A tagvaltozonak beallitando parameter
     */
	gGoal(Goal g){
		goal = g;
	}
	
	/** Visszaadja az megfelelo ImageIcon-t.
     *  @return	Az osztálynak megfelelo ImageIcon.
     */
	@Override
	public ImageIcon Draw() {
		return img;
	}

	/** Visszaadja megegyezik e a tagvaltozo a parameterben kapottal
     *  @return	igazzal ter vissza ha megegyeznek, hamissal ha nem
     */
	@Override
	public boolean Compare(Visitable v) {
		if(v == goal) {
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
