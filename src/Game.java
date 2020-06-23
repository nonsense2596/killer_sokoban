import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
/**
 * A jatek elinditasaert felelos osztaly, ez tartalmazza a main blokkot is.
 * @author Peter
 */
public class Game {

	/** A jatek vegen hivodik meg, ha minden karakternek lejar az ideje, es / vagy
	 *  minden karakter meghalt. Kiirja az eredmenyeket egy dialogusablakban, majd
	 *  annak bezarasakor terminalja a programot.
	 */
    public static void endGame() {
    	System.out.println("Sayounara e sayonara");
    	String kiirtszoveg = new String();
    	for(int i=0;i<TurnManager.getDisplayPlayers().size();i++) 
    		kiirtszoveg += ("Player" + i + ":  " + TurnManager.getDisplayPlayers().get(i).getPoint() + "points\n");
     	JOptionPane.showMessageDialog(new JFrame(), kiirtszoveg); 
        System.exit(0);
    }
    
    /** A program belepesi pontja, elinditja a terkepet, a jatekot, es a GUI-t inicializalo 
     * fuggvenyeket es belep a futasi magba.
     * @param args			Nem hasznalatos.
     * @throws IOException	Nem hasznalatos.
     * @throws InterruptedException 
     */
    public static void main( String[] args ) throws IOException, InterruptedException {
    	
    	GraphicsMain gm = new GraphicsMain();
    	Map m = new Map();
    	GameFrame gf = new GameFrame(gm);
    	gm.InitMain(gf, m);
    	gf.run();
    	int temp = gf.getNumberOfPlayers();
    	m.initMap(temp);

    }

}
