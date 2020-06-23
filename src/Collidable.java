/**
 * Collidable interface, az utkozesre kepes palyaelemek implementaljak.
 * @author Peter
 */
public interface Collidable {
	/**
	 * Egy Collidable egy mellette levo Character-rel utkozik.
	 * @param 	c			Character elemmel tortenik az utkozes.	
	 * @param 	weightSum	Az utkozesi sor pillanatnyi sulyainak szummaja.	
	 * @return				Az utkozesi sor sulyainak szummaja.
	 */
    public int collideWith(Character c , int weightSum);
	/**
	 * Egy Collidable egy mellette levo Box-szal utkozik.
	 * @param 	b			Box elemmel tortenik az utkozes.	
	 * @param 	weightSum	Az utkozesi sor pillanatnyi sulyainak szummaja.	
	 * @return				Az utkozesi sor sulyainak szummaja.
	 */
    public int collideWith(Box b , int weightSum);
	/**
	 * Egy Collidable egy mellette levo Wall-lal utkozik.
	 * @param 	w			Wall-lal tortenik az utkozes.	
	 * @param 	weightSum	Az utkozesi sor pillanatnyi sulyainak szummaja.	
	 * @return				Az utkozesi sor sulyainak szummaja.
	 */
    public int collideWith(Wall w , int weightSum);
}
