/**A character elemet kepviselo grafikus osztaly
 * @author Gergo
 */
import javax.swing.ImageIcon;

public class gChar implements Drawable{
	
	/** A gChar kiskepe inaktiv allapotban. */
	private ImageIcon img= new ImageIcon("Jatekos30.png");
	
	/** A gChar kiskepe aktiv allapotban. */
	private ImageIcon imgAct= new ImageIcon("JatekosActive30.png");
	
	/** A gChar altal megjelenitett Character referenciaja */
	protected Character character;

	/** Parameteres konstruktor ami beallitja a tagvaltozot a parameterre.
     *  @param c 	A tagvaltozonak beallitando parameter
     */
	gChar(Character c){
		character = c;
	}
	
	/** Visszaadja az megfelelo ImageIcon-t.
     *  @return	Az osztálynak megfelelo ImageIcon.
     */
	@Override
	public ImageIcon Draw() {
		if(character.isActive())
			return imgAct;
		//else
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
		return false;
	}
	
}
