/**A grafikus megjelenites alapja.
 * @author Gergo
 */
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;

import java.util.concurrent.CountDownLatch;


@SuppressWarnings("serial")
public class GameFrame extends JFrame {
	
	/** A kirajzolasokert felelos GraphicsMain referenciaja */
	private GraphicsMain graphicsmain;
	
	/** A jatekosok szama */
	private int numOfPlayers;
	
	/** Thread varakoztato cuccoska, hogy ne inicializalodjon olyan dolog olyankor, amikor
	 * meg nem tud inicializalodni effektiven a jatek elejen. */
	private CountDownLatch cdl = new CountDownLatch(1);
	
	/** A jatekosok ideje ezen a labelen jelenik meg. */
	private JLabel times = new JLabel();
	
	/** Megmondja, hogy mikor mukodjenek a billentyulenyomasok */
	private static final int IFW = JComponent.WHEN_IN_FOCUSED_WINDOW;
	
	/** Felfele torteno mozgas stringje. */
	private static final String MOVE_UP = "move up";
	/** Lefele torteno mozgas stringje. */
	private static final String MOVE_DOWN = "move down";
	/** Balra torteno mozgas stringje. */
	private static final String MOVE_LEFT = "move left";
	/** Jobbra torteno mozgas stringje. */
	private static final String MOVE_RIGHT = "move right";
	/** Olaj lehelyezese stringje. */
	private static final String PLACE_OIL = "place oil";
	/** Mez lehelyezese stringje. */
	private static final String PLACE_HONEY = "place honey";

	/** doodad, nem jelenik meg, nem lehet vele interakcioba lepni, de o fogadja a billentyuesemenyeket */
	static JLabel obj1 = new JLabel();
	
	/**Parameteres konstruktor, inicializalja a jatekmenetert felelos valtozokat,
	 * es keybindingeket.
	 * @param gm 	A mar letrehozott GraphicsMain peldany, hogy a GameFrame ismerje
	 */
	GameFrame(GraphicsMain gm) {
		obj1.getInputMap(IFW).put(KeyStroke.getKeyStroke("W"), MOVE_UP);
		obj1.getInputMap(IFW).put(KeyStroke.getKeyStroke("A"), MOVE_LEFT);
		obj1.getInputMap(IFW).put(KeyStroke.getKeyStroke("S"), MOVE_DOWN);
		obj1.getInputMap(IFW).put(KeyStroke.getKeyStroke("D"), MOVE_RIGHT);

		obj1.getActionMap().put(MOVE_UP, new MoveAction(Direction.Up));
		obj1.getActionMap().put(MOVE_LEFT, new MoveAction(Direction.Left));
		obj1.getActionMap().put(MOVE_RIGHT, new MoveAction(Direction.Right));
		obj1.getActionMap().put(MOVE_DOWN, new MoveAction(Direction.Down));
		
		
		obj1.getInputMap(IFW).put(KeyStroke.getKeyStroke("H"), PLACE_HONEY);
		obj1.getInputMap(IFW).put(KeyStroke.getKeyStroke("O"), PLACE_OIL);
		
		obj1.getActionMap().put(PLACE_HONEY, new PlaceAction(PLACE_HONEY));
		obj1.getActionMap().put(PLACE_OIL, new PlaceAction(PLACE_OIL));
		
		add(obj1);
		
		graphicsmain = gm;
	}
	
	
	/** A karakterek mozgasaert felelos esemenykezelo osztaly.
	 * @author Peter
	 */
	private class MoveAction extends AbstractAction {
			Direction dir;
			/** A karakterek mozgasaert felelos esemenykezelo osztaly konstruktora. Az esemenykezelo
			 * osztaly megkapja parameterul a mozgas iranyat.
			 * @param dir	Az adott kort jellemzo mozgasi irany.
			 */
	        MoveAction(Direction dir) {
	            this.dir = dir;
	        }

	        /** A karakterek mozgasaert felelos esemenykezelo osztaly belso fuggvenye. Megkapja a 
	         * mozgas iranyat, annak megfeleloen elinditja az adott korben torteno mozgasok
	         * fuggvenyeit, tovabba beallitja aktiv karakternek a soron kovetkezot, amennyiben tudja.
	         * @param e		A mozgast kivalto ActionEvent, nem hasznaljuk.
	         */
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	if(TurnManager.getCurrentPlayer().isDead())
	        	{}
	        	else{
		        	TurnManager.SetCurrentRoundDirection(dir);
		        	TurnManager.getCurrentPlayer().move(dir);
	        	}
	        	if(TurnManager.getPlayers().size()==0){
	             	Game.endGame();
	            }
	            else if(TurnManager.getCurrentIndex()+1<TurnManager.getPlayers().size())
	            {
	            	TurnManager.setCurrentIndex(TurnManager.getCurrentIndex()+1);
	            }
	            else{
	            	TurnManager.setCurrentIndex(0);
	            }
	        	TurnManager.getCurrentPlayer().setActive(false);
	            TurnManager.setCurrentPlayer(TurnManager.getPlayers().get(TurnManager.getCurrentIndex())); 
	            TurnManager.getCurrentPlayer().setActive(true);
	        	//map.DrawMapTest();	// parancssoros kiiratas teszt
	        }
	}
	
	/** A hasznalati targyak lehelyezeseert felelos esemenykezelo osztaly.
	 * @author Peter
	 */
	private class PlaceAction extends AbstractAction {
        String placeable;
		/** A hasznalati targyak lehelyezeseert felelos esemenykezelo osztaly konstruktora. Az esemenykezelo
		 * osztaly megkapja parameterul, hogy milyen dolgot helyezne le az adott karakter a Field-re.
		 * @param placeable		Amilyen dolgot lehelyezne az adott karatker a foldre.
		 */
        PlaceAction(String placeable) {
            this.placeable = placeable;
        }
        /** A hasznalati targyak lehelyezeseert felelos esemenykezelo osztaly belso fuggvenye. Megkapja a 
         * lehelyezendo targyat parameterul, annak megfeleloen elinditja az adott korben torteno
         * targy lehelyezesenek procedurajat.
         * @param e		A mozgast kivalto ActionEvent, nem hasznaljuk.
         */
        @Override
        public void actionPerformed(ActionEvent e) {
        	if(placeable.equals(PLACE_HONEY)){
        		TurnManager.getCurrentPlayer().placeHoney();
        	}
        	if(placeable.equals(PLACE_OIL)){
        		TurnManager.getCurrentPlayer().placeOil();
        	}
        }
	}
	
	/**Visszaadja a label-t amin a jatekosok ideje van.
	 * @return label Label, amin a jatekosok ideje van.
	 */
	public JLabel getTimes() {				
		return times;
	}
	
	/** Letrehozza a grafikus feluletet, a gombokra listener-t ad,
	 * 	beallitja a jatekos szamot a TurnManager-ben ami utan a
	 *  Map initMap fuggvenye tovabbhalad a jatekos szamot ismerve.
	 *  Jatek inditasa utan a palya kirajzolodik.
     *  @throws IOException
     */
	public void run() throws IOException {
		JPanel kozep = new JPanel();
		JButton jatek= new JButton("Jatek inditasa");
		jatek.setVisible(false);
		JButton kilepes=new JButton("Kilepes");
		JLabel toplista= new JLabel("Jatekosok szama:");
		JTextArea text = new JTextArea();
		JButton beallit= new JButton("Beallit");
		
		
		jatek.addActionListener(new ActionListener() {		

			/** Esemenykezelo, elinditja a jateknak a feluletet, es a jatekmenetet, ha a jatekosok 
			 *  megnyomjak a Jatek inditasa feliratu gombot.
			 * @param e		Az esemenyt kivalto ActionEvent, nem hasznaljuk.
			 */
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	
		    	remove(jatek);								
		    	remove(kilepes);
		    	kozep.removeAll();
		    	kozep.revalidate();
		    	remove(kozep);
		    	
		    	setLayout(new BorderLayout());
				JPanel p1 = new JPanel();   						
		    	
				add(p1,BorderLayout.NORTH);							
				add(graphicsmain.getPanel(),BorderLayout.CENTER);	
			    
				p1.add(times);										
		        
				setSize(660, 710);
				setResizable(false);
				setDefaultCloseOperation(EXIT_ON_CLOSE);
				
				setVisible(true);

				TurnManager.numOfPlayers = numOfPlayers;
				
				revalidate();
		    	repaint();

		    }
		    
		});
		
		
		kilepes.addActionListener(new ActionListener() {

			/** Esemenykezelo, bezarja a programot, ha a jatekosok 
			 *  megnyomjak a Kilepes feliratu gombot.
			 * @param e		Az esemenyt kivalto ActionEvent, nem hasznaljuk.
			 */
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	System.exit(0);
		    }
		    
		});
		
		
		beallit.addActionListener(new ActionListener() {
			/** Esemenykezelo, beallitja a textboxba megadott szamot a jatek
			 *  jatekosainak szamanak, ha megnyomjak a jatekosok a Beallit feliratu gombot.
			 * @param e		Az esemenyt kivalto ActionEvent, nem hasznaljuk.
			 */
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	int playerNum;
		    	try {												
		    		playerNum = Integer.parseInt(text.getText());
		    		if(playerNum > 0) {
		    			text.setEditable(false);
				    	jatek.setVisible(true);			
				    	beallit.setVisible(false);
				    	revalidate();
				    	repaint();
				    	numOfPlayers = playerNum;
				    	cdl.countDown();
		    		}
		    	} catch (NumberFormatException ex) {
		    	}
		    }
		    
		});
		
		text.setPreferredSize(new Dimension(30, 16));
		text.setEditable(true);
		kozep.add(toplista);
		kozep.add(text);
		kozep.add(beallit);
		add(jatek, BorderLayout.NORTH);
		add(kozep,BorderLayout.CENTER);
		add(kilepes, BorderLayout.SOUTH);
		setSize(270,120);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}
	
	/** Getter fuggveny a map inicializalo parameterehez.
	 * @return	Visszater a jatekosok szamaival.
	 * @throws InterruptedException
	 */
	public int getNumberOfPlayers() throws InterruptedException{
			cdl.await();
			return numOfPlayers;
	}
}
	
