import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * A jatek fo vezerleseert felelos "statikus" osztaly.
 * Szabalyozza a koroket, a lepeseket, iranyitja a karaktereket.
 * @author Peter
 *
 */
public class TurnManager {
	
	/** Az eppen aktiv jatekos referenciaja. */
    private static Character currentPlayer;
    
	/** Az aktualis korben hasznalatos mozgasi irany. */
    private static Direction currentDirection;
    
	/** A meg elo, jatekban levo karaktereket tartalmazo lista. */
    private static List<Character> players = new ArrayList<Character>();
    
	/** Az osszes jatekost tartalmazo lista. Innen nem kerul ki a jatekos, ha meghal.
	 *  Kiiratasokhoz hasznaljuk. */
    private static List<Character> displayPlayers = new ArrayList<Character>();
    
	/** A jatekosok szama. */
    public static volatile int numOfPlayers = 0;
    
	/** Az aktualisan aktiv jatekos sorszama a players tombben. */
    private static int currentindex = 0;
    
    /**
     * Megkapja a Map palya referenciajat, beallitja az players tomb elso 
     * elemet, azaz az elso jatekost aktivnak, majd elinditja a jatek 
     * futtatasaert felelos ciklust.
     * @param numberOfPlayers	Hany jatekos jatszik. // TODO: nem kell
     * @throws IOException		Ennek nem lenne szabad megtortennie.
     */
    public static void init(int numberOfPlayers) throws IOException {
        if ( players.size() > 0 ){
            currentPlayer = players.get(0);			
            currentPlayer.setActive(true);
        }
        displayPlayers = new ArrayList<Character>();
        for(Character c: players){
        	displayPlayers.add(c);
        }
        loop();															
    }


    /** Visszater az eppen aktiv karakter sorszamaval.
     * @return	Az az aktiv karakter indexe.
     */
    public static int getCurrentIndex(){ 
    	return currentindex; 
    }
    
    /**Beallit egy karaktert aktivnak.
     * @param i		Az ezen indexen talalhato karaktert allitja be aktivnak.
     */
    public static void setCurrentIndex(int i){ 
    	currentindex = i; 
    }
    
    /** A jatek fo futtatasi egysege, vegtelen ciklusban olvassa a felhasznaloi inputot, azaz, hogy
     * az aktiv Character milyen iranyba szeretne mozogni, esetleg mezet vagy olajat szeretne-e lehelyezni az aktualis mezojere elotte.
     * @throws IOException
     */
    public static void loop() throws IOException { 
        while (true) {
        	
        	if(currentPlayer.isDead()){

	        	if(players.size()==0){
	        		Game.endGame();
	            }
	            else if(currentindex+1<=players.size())
	            {							// nem csinalunk semmit lol, mert atrendezodott a tomb, es ez ilyenkor mar a jo index :D
	            }
	            else{
	            	currentindex=0;
	            }
	        	TurnManager.getCurrentPlayer().setActive(false);
	            TurnManager.setCurrentPlayer(TurnManager.getPlayers().get(TurnManager.getCurrentIndex())); 
	            TurnManager.getCurrentPlayer().setActive(true);
        	}

        	try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				System.out.println("Something happened that shouldn't have...");
				e.printStackTrace();
			}
        }
    }


    
    /**Az eppen aktualis jatekos (currentPlayer) hatralevo idejet csokenti a Timer hivasara.
     */
    public static void time() {
    	if(currentPlayer != null)
    		currentPlayer.reduceTimer();
    }

    /**Meghivodik, ha egy karakter egy celmezore tol egy dobozt.
     * Pontot ir jova a karakternek.
     */
    public static void goal() {
        currentPlayer.addPoint();
    }

    /**
     * Megoljuk az adott jatekost oly modon, hogy a hatralevo idejet 0-ra allitjuk, es
     * a players tombbol eltavolitjuk a referenciajat, ezaltal a TurnManager mar nem fog szamara
     * tobb lepest biztositani.
     * @param 	c	A legyilkolando jatekos Charactere.
     */
    public static void killPlayer( Character c ) {
        c.setTimer(0);
        c.getField().removeThing(c);
        players.remove(c);
    }

    /**Lekerdezi az adott kor mozgasi iranyat.
     * Egy korben egy iranyba lehet csak pontosan egy mezonyit mozogni.
     * A karakter altal mozgatott egyeb dolgok sem mozoghatnak mas iranyba.
     * @return		A kor mozgasi iranya.
     */
    public static Direction getCurrentDirection() {
        return currentDirection;
        
    }
    
    /** Beallitja a kor mozgasi iranyat a paramterekent kapott ertekre.
     * @param 	d	Beallitja a kor mozgasi iranyat erre a kapott parameterre.
     */
    public static void SetCurrentRoundDirection(Direction d){
    	currentDirection = d;
    }

    /**
     * Lekerdezi, hogy ki az adott korben az eppen aktiv Character.
     * @return		Az adott korben aktiv Character.
     */
    public static Character getCurrentPlayer() {

        return currentPlayer;
    }

    /**
     * Visszaadja az osszes jatekost tartalmazo listat - DEBUG CELOKRA
     * @return		Az osszes jatekost tartalmazo lista.
     */
    public static List<Character> getPlayers() {
        return players;
    }

    /**
     * Beallitja, hogy ki az adott korben az eppen aktiv Character.
     * @param	currentPlayer		Az adott korben aktivnak beallitando Character.
     */
    public static void setCurrentPlayer(Character currentPlayer) {
        TurnManager.currentPlayer = currentPlayer;
    }
    
    /**
     * Ezzel a fuggvennyel kapja meg a Map mapinit fuggvenyebol a Character-ek referenciait
     * a TurnManager,
     * ezen keresztul tarolja el oket a sajat lista tombjebe.
     * @param	c	Eltarolando Character referencia.
     */
    public static void AddCharacter(Character c){
    	players.add(c);
    }
    
    /**Visszater azzal a jatekos listaval, amit a timerek es a vegeredmeny kiirasahoz hasznalunk.
     * @return	A fixen minden jatekos tartalamzo listaa.
     */
    public static List<Character> getDisplayPlayers(){
    	return displayPlayers;
    }
}
