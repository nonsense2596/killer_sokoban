/**A palya elemeinek megfelelo grafikus kepek kirajzolasaert felelos,
 * illetve frissiti a jatekosok idejet.
 * @author Gergo
 */
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GraphicsMain implements Graphics {
	
	/** A jatekot megjelenito JPanel */
	protected JPanel panel = new JPanel();
	
	/** A kirajzolando gXYZ elemeket tartalmazo 2D tomb */
	protected Drawable[][] drawables = new Drawable[20][20];
	
	/** A grafikus megjelenites alapjat kepezo GameFrame referenciaja. */
	private GameFrame gf;
	
	/** A terkepet, annak zonait, es az azokon talalhato dolgokat tarolo terkep referenciaja */
	private Map map;
	
	int heigth = 20;
	int width = 20;
	JToggleButton[][] blocks = new JToggleButton[heigth][width];
	
	private int index1;			
	private int index2;
	
	/**Beallitja a palyat kirajzolo panel-t GridLayout-ra, es letrehozza a
	 * 2 idozitot amelyek kozul az egyik 5/sec alkalommal hivja a DrawAll() és UpdateTimers()
	 * fuggvenyt, illetve amelyik masodpercenkent csokkenti az aktualis jatekos idejet.
	 * @param gamef		a mar letrehozott GameFrame peldany, hogy a GraphicsMain ismerje
	 * @param map 		a mar letrehozott Map peldany, hogy a GraphicsMain ismerje
	 */
	public void InitMain(GameFrame gamef, Map map){
		
		this.map = map;
		gf = gamef;
		
		panel.setLayout(new GridLayout(heigth,width));

		Timer drawTimer = new Timer(200, new ActionListener() {			
			
			/**A grafikus felulet ujrarajzolasaert felelos esemenyzekezelo, timer
			 * hivja meg fix idointervallumonkent, ami jelen esetben 5 (centimeter) frame per second.
			 * @param e		Az esemenyt kivalto ActionEvent, nem hasznaljuk.
			 */
		      @Override
		      public void actionPerformed(ActionEvent e) {					
		        panel.revalidate();
		        DrawAll();
		        UpdateTimers();
		      }
		    });
			drawTimer.setRepeats(true);
			drawTimer.start();
		    
		    Timer TimeUpdateTimer = new Timer(1000, new ActionListener() {	
		    	
				/**Az eppen aktiv jatekos hatralevo idejet dekrementalja masodpercenkent.
				 * @param e		Az esemenyt kivalto ActionEvent, nem hasznaljuk.
				 */
			      @Override
			      public void actionPerformed(ActionEvent e) {
			    	  TurnManager.time();									
			      }
			    });
		    TimeUpdateTimer.setRepeats(true);
		    TimeUpdateTimer.start();
	}
	
	/**
	 * Visszaadja a panel-t amire a palya van kirajzolva.
	 * @return A panel amin a palya van
	 */
	public JPanel getPanel() {
		return panel;
	}

	/**
	 * Kirajzolja a megfelelo objektumokat, illetve felveszi a JToggleButton-t a panelre.
	 */
	public void DrawAll() {

		panel.removeAll();
		panel.revalidate();
		panel.repaint();
		
		for(index1 = 0; index1 < heigth; index1++) {
			for(index2 = 0; index2 < width; index2++) {
				Field test = map.getField(index1, index2);	// Lekerdezzuk index1 index2 elemet a palyanak
				if(test != null && test.isEmpty()) {		// Ha ures, callInit-tel meghivatjuk a megfelelo Init-et
					test.callInit(this);
					
				}
				else if(test != null){						// Ha nem ures, callInit-tel meghivatjuk a megfelelo Init-et
					test.getThing().callInit(this);
					
				}
				if(blocks[index1][index2] == null) {		// Ha azelott futna a DrawAll hogy ne lenne semmi Field
					blocks[index1][index2] = new JToggleButton();
				}
				panel.add(blocks[index1][index2]);
				
			}
		}

	}

	/**
	 * NormalField parameterezesevel meghivott Init fuggveny amely kirajzolja
	 * az annak megfelelo kepet ha mar nem az van az adott helyen.
	 * Ha meg az van, nem rajzolja ki ujra.
	 * @param nf	NormalField, amit kirajzol.
	 */
	@Override
	public void Init(NormalField nf) {
		if(drawables[index1][index2] == null || !drawables[index1][index2].Compare(nf)) {	// Ha drawables eleme null vagy masik elem
			drawables[index1][index2] = null;												// van az adott helyen, akkor lecsereljuk
			drawables[index1][index2] = new gNormalField(nf);
			ImageIcon ico = drawables[index1][index2].Draw();								// Draw visszaadja a megfelelo icont
			blocks[index1][index2] = new JToggleButton();
			blocks[index1][index2].setIcon(ico);
		}
	}
	
	/**
	 * Trap parameterezesevel meghivott Init fuggveny amely kirajzolja
	 * az annak megfelelo kepet ha mar nem az van az adott helyen.
	 * Ha meg az van, akkor is kirajzolja, mert lehet valtozott az allapota.
	 * @param t		Trap, amit kirajzol.
	 */
	@Override
	public void Init(Trap t) {
		if(drawables[index1][index2] == null || !drawables[index1][index2].Compare(t)) {
			drawables[index1][index2] = null;
			drawables[index1][index2] = new gTrap(t);
			ImageIcon ico = drawables[index1][index2].Draw();
			blocks[index1][index2] = new JToggleButton();
			blocks[index1][index2].setIcon(ico);
		}
	}
	
	/**
	 * Hole parameterezesevel meghivott Init fuggveny amely kirajzolja
	 * az annak megfelelo kepet ha mar nem az van az adott helyen.
	 * Ha meg az van, nem rajzolja ki ujra.
	 * @param h		Hole, amit kirajzol.
	 */
	@Override
	public void Init(Hole h) {
		if(drawables[index1][index2] == null || !drawables[index1][index2].Compare(h)) {
			drawables[index1][index2] = null;
			drawables[index1][index2] = new gHole(h);
			ImageIcon ico = drawables[index1][index2].Draw();
			blocks[index1][index2] = new JToggleButton();
			blocks[index1][index2].setIcon(ico);
		}
	}
	
	/**
	 * Switch parameterezesevel meghivott Init fuggveny amely kirajzolja
	 * az annak megfelelo kepet ha mar nem az van az adott helyen.
	 * Ha meg az van, nem rajzolja ki ujra.
	 * 	 * @param s		Switch, amit kirajzol.
	 */
	@Override
	public void Init(Switch s) {
		if(drawables[index1][index2] == null || !drawables[index1][index2].Compare(s)) {
			drawables[index1][index2] = null;
			drawables[index1][index2] = new gSwitch(s);
			ImageIcon ico = drawables[index1][index2].Draw();
			blocks[index1][index2] = new JToggleButton();
			blocks[index1][index2].setIcon(ico);
		}
	}
	
	/**
	 * Goal parameterezesevel meghivott Init fuggveny amely kirajzolja
	 * az annak megfelelo kepet ha mar nem az van az adott helyen.
	 * Ha meg az van, nem rajzolja ki ujra.
	 * @param g		Goal, amit kirajzol.
	 */
	@Override
	public void Init(Goal g) {
		if(drawables[index1][index2] == null || !drawables[index1][index2].Compare(g)) {
			drawables[index1][index2] = null;
			drawables[index1][index2] = new gGoal(g);
			ImageIcon ico = drawables[index1][index2].Draw();
			blocks[index1][index2] = new JToggleButton();
			blocks[index1][index2].setIcon(ico);
		}
	}

	/**
	 * Character parameterezesevel meghivott Init fuggveny amely kirajzolja
	 * az annak megfelelo kepet ha mar nem az van az adott helyen.
	 * Ha meg az van, akkor is kirajzolja, mert lehet mar nem aktiv.
	 * @param c		Character, amit kirajzol.
	 */
	@Override
	public void Init(Character c) {
		if(drawables[index1][index2] == null || !drawables[index1][index2].Compare(c)) {
			drawables[index1][index2] = null;
			drawables[index1][index2] = new gChar(c);
			ImageIcon ico = drawables[index1][index2].Draw();
			blocks[index1][index2] = new JToggleButton();
			blocks[index1][index2].setIcon(ico);
		}
	}

	/**
	 * Box parameterezesevel meghivott Init fuggveny amely kirajzolja
	 * az annak megfelelo kepet ha mar nem az van az adott helyen.
	 * Ha meg az van, nem rajzolja ki ujra.
	 * @param b		Box, amit kirajzol.
	 */
	@Override
	public void Init(Box b) {
		if(drawables[index1][index2] == null || !drawables[index1][index2].Compare(b)) {
			drawables[index1][index2] = null;
			drawables[index1][index2] = new gBox(b);
			ImageIcon ico = drawables[index1][index2].Draw();
			blocks[index1][index2] = new JToggleButton();
			blocks[index1][index2].setIcon(ico);
		}
	}

	/**
	 * Wall parameterezesevel meghivott Init fuggveny amely kirajzolja
	 * az annak megfelelo kepet ha mar nem az van az adott helyen.
	 * Ha meg az van, nem rajzolja ki ujra.
	 * @param w		Wall, amit kirajzol.
	 */
	@Override
	public void Init(Wall w) {
		if(drawables[index1][index2] == null || !drawables[index1][index2].Compare(w)) {
			drawables[index1][index2] = null;
			drawables[index1][index2] = new gWall(w);
			ImageIcon ico = drawables[index1][index2].Draw();
			blocks[index1][index2] = new JToggleButton();
			blocks[index1][index2].setIcon(ico);
		}
	}
	
	/** Frissiti a jatekosok idejet, miutan torolt mindent a label-rol.
	 */
	public void UpdateTimers() {
		JLabel times = gf.getTimes();
		times.removeAll();
		times.revalidate();
		times.repaint();
		times.setText("");
		for(int i = 0; i < TurnManager.getDisplayPlayers().size(); i++) {
			times.setText(times.getText() + "Jatekos" + (i+1) + ": " + TurnManager.getDisplayPlayers().get(i).getTimer() + "      ");
		}
	}
	
}
