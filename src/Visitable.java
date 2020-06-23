/**
 * A Field mezok implementaljak, amikre Thing-ek kerulhetnek.
 * @author Peter
 */
public interface Visitable {
	
      /** A mezore rakerul egy Character objektum, amit referenciakent megkap, beallitja azt a sajat maga thing mezojebe a Visitablet megvalosito osztaly.
      * @param	c	Az a Character, ami rakerul az adott Field-re.
      */
	  public void addThing(Character c);
	  
      /** A mezore rakerul egy Box objektum, amit referenciakent megkap, beallitja azt a sajat maga thing mezojebe a Visitablet megvalosito osztaly.
      * @param	b	Az a Box, ami rakerul az adott Field-re.
      */
	  public void addThing(Box b);
	  
      /** A mezore rakerul egy Wall objektum, amit referenciakent megkap, beallitja azt a sajat maga thing mezojebe a Visitablet megvalosito osztaly.
      * @param	w	Az a Wall, ami rakerul az adott Field-re.
      */
	  public void addThing(Wall w);
	  
      /** A mezorol lekerulo Character objektum. Eltavolitja a mezon levo elemet. 
      * @param	c	Eltavolitja a sajat thing referenciajat ha parameterul kap valamit.
      */
	  public void removeThing(Character c);
	  
      /** A mezorol lekerulo Box objektum. Eltavolitja a mezon levo elemet. 
      * @param	b	Eltavolitja a sajat thing referenciajat ha parameterul kap valamit.
      */
	  public void removeThing(Box b);
	  
      /** A mezorol lekerulo Wall	 objektum. Eltavolitja a mezon levo elemet. 
      * @param	w	Eltavolitja a sajat thing referenciajat ha parameterul kap valamit.
      */
	  public void removeThing(Wall w);
	  
}
