/**
 * A GraphicsMain implementalja
 * @author Gergo
 */
public interface Graphics {
	/**
	 * NormalField parameterezesevel meghivott Init fuggveny amely kirajzolja
	 * az annak megfelelo kepet ha mar nem az van az adott helyen.
	 * Ha meg az van, nem rajzolja ki ujra
	 */
	public void Init(NormalField nf);
	
	/**
	 * Trap parameterezesevel meghivott Init fuggveny amely kirajzolja
	 * az annak megfelelo kepet ha mar nem az van az adott helyen.
	 * Ha meg az van, akkor is kirajzolja, mert lehet valtozott az allapota
	 */
	public void Init(Trap t);
	
	/**
	 * Hole parameterezesevel meghivott Init fuggveny amely kirajzolja
	 * az annak megfelelo kepet ha mar nem az van az adott helyen.
	 * Ha meg az van, nem rajzolja ki ujra
	 */
	public void Init(Hole h);
	
	/**
	 * Goal parameterezesevel meghivott Init fuggveny amely kirajzolja
	 * az annak megfelelo kepet ha mar nem az van az adott helyen.
	 * Ha meg az van, nem rajzolja ki ujra
	 */
	public void Init(Goal g);
	
	/**
	 * Switch parameterezesevel meghivott Init fuggveny amely kirajzolja
	 * az annak megfelelo kepet ha mar nem az van az adott helyen.
	 * Ha meg az van, nem rajzolja ki ujra
	 */
	public void Init(Switch s);
	
	/**
	 * Character parameterezesevel meghivott Init fuggveny amely kirajzolja
	 * az annak megfelelo kepet ha mar nem az van az adott helyen.
	 * Ha meg az van, akkor is kirajzolja, mert lehet mar nem aktiv
	 */
	public void Init(Character c);
	
	/**
	 * Box parameterezesevel meghivott Init fuggveny amely kirajzolja
	 * az annak megfelelo kepet ha mar nem az van az adott helyen.
	 * Ha meg az van, nem rajzolja ki ujra
	 */
	public void Init(Box b);
	
	/**
	 * Wall parameterezesevel meghivott Init fuggveny amely kirajzolja
	 * az annak megfelelo kepet ha mar nem az van az adott helyen.
	 * Ha meg az van, nem rajzolja ki ujra
	 */
	public void Init(Wall w);
}
