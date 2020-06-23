/**A normalfield elemet kepviselo grafikus osztaly
 * @author Gergo
 */
import javax.swing.ImageIcon;

public class gNormalField implements Drawable{
	
	/** A gNormalField kiskepe */
	private ImageIcon img= new ImageIcon("NormalField1.png");
	
	/** A gNormalField kiskepe ha olaj van rajta */
	private ImageIcon oil= new ImageIcon("Olajosmezo30.png");
	
	/** A gNormalField kiskepe ha mez van rajta */
	private ImageIcon honey= new ImageIcon("Mezesmezo30.png");
	
	/** A gNormalField altal megjelenitett NormalField referenciaja */
	protected NormalField normalfield;
	
	/** Parameteres konstruktor ami beallitja a tagvaltozot a parameterre.
     *  @param nf 	A tagvaltozonak beallitando parameter
     */
	gNormalField(NormalField nf){
		normalfield = nf;
	}

	/** Visszaadja az megfelelo ImageIcon-t.
     *  @return	Az osztálynak megfelelo ImageIcon.
     */
	@Override
	public ImageIcon Draw() {
		if(normalfield.getWeightModifier() == 0) {
			return img;
		}
		else if(normalfield.getWeightModifier() > 0) {
			return honey;
		}
		else if(normalfield.getWeightModifier() < 0) {
			return oil;
		}
		return img;
	}

	/** Visszaadja megegyezik-e a tagvaltozo a parameterben kapottal
     *  @return	igazzal ter vissza ha megegyeznek, hamissal ha nem
     */
	@Override
	public boolean Compare(Visitable v) {
		if(v == normalfield) {
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
