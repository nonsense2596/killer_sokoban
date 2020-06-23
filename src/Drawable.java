/**
 * A gXYZ osztalyok implementaljak.
 * @author Gergo
 */
import javax.swing.ImageIcon;


public interface Drawable {
	/** Visszaadja az megfelelo ImageIcon-t.
     *  @return	Az osztálynak megfelelo ImageIcon.
     */
	public ImageIcon Draw();
	
	/** Visszaadja megegyezik-e a tagvaltozo a parameterben kapottal
     *  @return	igazzal ter vissza ha megegyeznek, hamissal ha nem
     */
	public boolean Compare(Visitable v);
	
	/** Visszaadja megegyezik-e a tagvaltozo a parameterben kapottal
     *  @return	igazzal ter vissza ha megegyeznek, hamissal ha nem
     */
	public boolean Compare(Collidable c);
}
