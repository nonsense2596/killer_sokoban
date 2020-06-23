/**A switch elemet kepviselo grafikus osztaly
 * @author Gergo
 */
import javax.swing.ImageIcon;

public class gSwitch implements Drawable{
	
	/** A gSwitch kiskepe. */
	private ImageIcon img= new ImageIcon("Kapcsolo30.png");
	
	/** A gSwitch altal megjelenitett Switch referenciaja */
	private Switch switchE;		// nem tudom miert van E a vegen...
	
	/** Parameteres konstruktor ami beallitja a tagvaltozot a parameterre.
     *  @param s 	A tagvaltozonak beallitando parameter
     */
	gSwitch(Switch s){
		switchE = s;
	}
	
	/** Visszaadja a switch-nek megfelelo ImageIcon-t.
     *  @return	Switch-nek megfelelo ImageIcon.
     */
	@Override
	public ImageIcon Draw() {
		// TODO Auto-generated method stub
		return img;
	}

	/** Visszaadja megegyezik e a tagvaltozo a parameterben kapottal
     *  @return	igazzal ter vissza ha megegyeznek, hamissal ha nem
     */
	@Override
	public boolean Compare(Visitable v) {
		if(v == switchE) {
			return true;
		}
		else return false;
	}

	/** Visszaadja megegyezik e a tagvaltozo a parameterben kapottal
     *  @return	mindig false, sosem lehet collidable visitable
     */
	@Override
	public boolean Compare(Collidable c) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
