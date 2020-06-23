import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
/**
 * A palya matrixat tartalmazo osztaly. A palya field es thing elemeit eltarolja a fields matrixban,
 * majd a szomszedos mezok kozott felepiti a GetNeighbour es SetNeighbour fuggvenyek altal a szomszedsagi
 * kapcsolatokat. A jatekmnenet ezen fuggvenyekre alapul, a fields matrix csupan ezen kapcsolatok letrehozasaban
 * es a grafikus felulet kiiratasaban segit.
 * Az initMap generalja le a palyat, majd hivja meg a TurnManager  init fuggvenyet, ami a jatek vezerleseert lesz felelos.
 * @author Peter
 */
public class Map {

	/** A palyat kepezo elemeket (fieldeket es az azokon levo thingeket) tartalmazo 2D tomb */
	private Field[][] fields;

	/**
	 * A Map osztaly konstruktora, merete es felepitese valtozhat, a tesztscenariok determinisztikus lefolyasa
	 * miatt most statikusan inicializaljuk a meretet.
	 */
    public Map() {
        fields = new Field[20][20];
    }
    
    /**
	 * Visszaadja az adott indexen levo fieldet.
	 * @param index1 A matrix elso indexe
	 * @param index2 A matrix masodik indexe
	 * @return A matrix adott indexen elhelyezkedo fieldje.
	 */
    public Field getField(int index1, int index2) {
    	return fields[index1][index2];
    }

    /** A vegleges verzioban remenyeink szerint vagy egy fix palya, vagy egy veletlen palyageneralo algoritmus lesz jelen, 
     * ezeknek a mar mukodo, de igencsak kezdetleges verzioja megtalalhato ezen fuggvenyben kikommentezve. Hogy a tesztesetek lefutasa
     * determinisztikus legyen, jelen verzioban az initMap automatikusan csak a fix 20x20-as meretu alappalyat, annak
     * alapjat a NormalField mezokkel, es a palyat hatarolo Wall objektumokat helyezi le. A tobbi elemet a teszter
     * helyezheti le igenyei szerint.
     * @param numberOfPlayers	Hany Character-rel inicializalodjon a jatek.
     * @throws IOException
     * @throws InterruptedException 
     */
    public void initMap( int numberOfPlayers ) throws IOException, InterruptedException {
    	
    	
        ArrayList<Character> charlist = new ArrayList<Character>();	
        for(int i=0;i<numberOfPlayers;i++){
        	charlist.add(new Character());
        }
        
    	for(int i=0;i<fields.length;i++){
            for(int j=0;j<fields.length;j++){
                if(i==0|| i==fields.length-1 || j==0 || j==fields[i].length-1){
                    fields[i][j]=new NormalField();
                    fields[i][j].addThing(new Wall());
                }
                else
                    fields[i][j]=new NormalField();
            }
        }

        fields[5][6]=new NormalField(); fields[5][6].addThing(new Wall());
        fields[5][7]=new NormalField(); fields[5][7].addThing(new Wall());
        fields[5][8]=new NormalField(); fields[5][8].addThing(new Wall());
        fields[5][9]=new NormalField(); fields[5][9].addThing(new Wall());
        fields[5][10]=new NormalField(); fields[5][10].addThing(new Wall());
        fields[5][11]=new NormalField(); fields[5][11].addThing(new Wall());
       
        fields[4][15]=new NormalField(); fields[4][15].addThing(new Wall());
        fields[5][15]=new NormalField(); fields[5][15].addThing(new Wall());
        fields[6][15]=new NormalField(); fields[6][15].addThing(new Wall());
       
        fields[8][5]=new NormalField(); fields[8][5].addThing(new Wall());
        fields[9][5]=new NormalField(); fields[9][5].addThing(new Wall());
        fields[10][5]=new NormalField(); fields[10][5].addThing(new Wall());
        fields[11][5]=new NormalField(); fields[11][5].addThing(new Wall());
        fields[12][5]=new NormalField(); fields[12][5].addThing(new Wall());
       
        fields[9][10]=new NormalField(); fields[9][10].addThing(new Wall());
        fields[9][11]=new NormalField(); fields[9][11].addThing(new Wall());
        fields[9][12]=new NormalField(); fields[9][12].addThing(new Wall());
        fields[9][13]=new NormalField(); fields[9][13].addThing(new Wall());
        fields[9][14]=new NormalField(); fields[9][14].addThing(new Wall());
       
        fields[15][8]=new NormalField(); fields[15][8].addThing(new Wall());
        fields[15][9]=new NormalField(); fields[15][9].addThing(new Wall());
        fields[15][10]=new NormalField(); fields[15][10].addThing(new Wall());
       
        fields[13][14]=new NormalField(); fields[13][14].addThing(new Wall());
        fields[14][14]=new NormalField(); fields[14][14].addThing(new Wall());
        fields[15][14]=new NormalField(); fields[15][14].addThing(new Wall());
        fields[16][14]=new NormalField(); fields[16][14].addThing(new Wall());
       
        fields[3][3]=new Hole();
        fields[1][10]=new Hole();
        fields[6][8]=new Hole();
        fields[6][14]=new Hole();
        fields[8][4]=new Hole();
        fields[8][18]=new Hole();
        fields[12][11]=new Hole();
        fields[15][5]=new Hole();
        fields[15][16]=new Hole();
        fields[16][1]=new Hole();      
        fields[18][11]=new Hole();
       
        fields[2][17]=new Goal();
        fields[3][13]=new Goal();
        fields[4][5]=new Goal();
        fields[4][9]=new Goal();
        fields[9][7]=new Goal();
        fields[9][18]=new Goal();
        fields[10][11]=new Goal();
        fields[12][1]=new Goal();
        fields[13][6]=new Goal();
        fields[13][15]=new Goal();
        fields[17][2]=new Goal();
        fields[17][9]=new Goal();
       
        fields[2][4].addThing(new Box());
        fields[2][11].addThing(new Box());
        fields[2][14].addThing(new Box());
        fields[2][12].addThing(new Box());
        fields[3][7].addThing(new Box());
        fields[5][3].addThing(new Box());
        fields[5][17].addThing(new Box());
        fields[6][1].addThing(new Box());
        fields[6][17].addThing(new Box());
        fields[7][12].addThing(new Box());
        fields[10][3].addThing(new Box());
        fields[10][8].addThing(new Box());
        fields[10][15].addThing(new Box());
        fields[11][9].addThing(new Box());
        fields[12][16].addThing(new Box());
        fields[13][4].addThing(new Box());
        fields[13][9].addThing(new Box());
        fields[15][3].addThing(new Box());
        fields[15][11].addThing(new Box());
        fields[16][6].addThing(new Box());
        fields[17][16].addThing(new Box());
        fields[18][13].addThing(new Box());
       
        Trap t1 = new Trap();
        Switch s1 = new Switch();
        s1.addTrap(t1);
        fields[2][5] = t1;
        fields[3][10] = s1;
       
        Trap t2 = new Trap();
        Switch s2 = new Switch();
        s2.addTrap(t2);
        fields[6][4] = t2;
        fields[7][5] = s2;
       
        Trap t3 = new Trap();
        Switch s3 = new Switch();
        s3.addTrap(t3);
        fields[7][15] = t3;
        fields[9][16] = s3;
       
        Trap t4 = new Trap();
        Switch s4 = new Switch();
        s4.addTrap(t4);
        fields[9][9] = t4;
        fields[13][10] = s4;
       
        Trap t5 = new Trap();
        Switch s5 = new Switch();
        s5.addTrap(t5);
        fields[15][4] = t5;
        fields[18][8] = s5;
       
        Trap t6 = new Trap();
        Switch s6 = new Switch();
        s6.addTrap(t6);
        fields[16][11] = t6;
        fields[18][8] = s6;
       
        Trap t7 = new Trap();
        Switch s7 = new Switch();
        s7.addTrap(t7);
        fields[14][15] = t7;
        fields[17][15] = s7;

        Random r = new Random();
        while(charlist.size()>0){
        	int i = r.nextInt(20);
        	int j = r.nextInt(20);
        	String s = " ";
        	if(fields[i][j].getThing()==null && fields[i][j].toString().equals(s)){
            	Character tempchar = charlist.remove(0);
        		fields[i][j].addThing(tempchar);
        		TurnManager.AddCharacter(tempchar);
        	}

        }
        
        for(int i=0;i<fields.length;i++)		
        {
        	for(int j=0;j<fields.length;j++) 	
        	{
        		if(i==0){						
        			if(j==0){
            			fields[i][j].setNeighbour(Direction.Right, fields[i][j+1]);
            			fields[i][j].setNeighbour(Direction.Down, fields[i+1][j]);
        			}
        			else if(j==fields.length-1){
        				fields[i][j].setNeighbour(Direction.Left, fields[i][j-1]);
        				fields[i][j].setNeighbour(Direction.Down, fields[i+1][j]);
        			}
        			else {
        				fields[i][j].setNeighbour(Direction.Right, fields[i][j+1]);
        				fields[i][j].setNeighbour(Direction.Left, fields[i][j-1]);
        				fields[i][j].setNeighbour(Direction.Down, fields[i+1][j]);
        			}
        		}
        		else if(i==fields.length-1){	
        			if(j==0){
        				fields[i][j].setNeighbour(Direction.Right, fields[i][j+1]);
        				fields[i][j].setNeighbour(Direction.Up, fields[i-1][j]);
        			}
        			else if(j==fields.length-1){
        				fields[i][j].setNeighbour(Direction.Left, fields[i][j-1]);
        				fields[i][j].setNeighbour(Direction.Up, fields[i-1][j]);
        			}
        			else{
        				fields[i][j].setNeighbour(Direction.Right, fields[i][j+1]);
        				fields[i][j].setNeighbour(Direction.Left, fields[i][j-1]);
        				fields[i][j].setNeighbour(Direction.Up, fields[i-1][j]);
        			}
        		}
        		else{							
        			if(j==0){
        				fields[i][j].setNeighbour(Direction.Right, fields[i][j+1]);
        				fields[i][j].setNeighbour(Direction.Up, fields[i-1][j]);
        				fields[i][j].setNeighbour(Direction.Down, fields[i+1][j]);
        			}
        			else if(j==fields.length-1){
        				fields[i][j].setNeighbour(Direction.Left, fields[i][j-1]);
        				fields[i][j].setNeighbour(Direction.Up, fields[i-1][j]);
        				fields[i][j].setNeighbour(Direction.Down, fields[i+1][j]);
        			}
        			else{
        				fields[i][j].setNeighbour(Direction.Right, fields[i][j+1]);
        				fields[i][j].setNeighbour(Direction.Left, fields[i][j-1]);
        				fields[i][j].setNeighbour(Direction.Up, fields[i-1][j]);
        				fields[i][j].setNeighbour(Direction.Down, fields[i+1][j]);
        			}
        		}
        	}
        }
       TurnManager.init(numberOfPlayers);	
    }
    

    /** TESZTFUGGVENY. Minden Character lepese utan meghivodik, kirajzolva a teljes palya allapotat
     * a rajta levo Field-ek es Thing-ek tipusaval; sokkal szemleletesebb es kozerthetobb visszajelzest
     * adva ezzel a teszternek egy szoveges kimenetnel.
     * Az egyes osztalyok toString metodusa altal minden osztaly objektuma egy ra jellemzo [ASCII charactert]
     * ir ki. 
     * Ezek a kovetkezok: 
     * " " [space] 	- NormalField
     * "W"			- Wall
     * "G"			- Goal
     * "X"			- current Character (eppen aktiv Character)
     * "C"			- other Character	(nem aktiv Character)
     * "H"			- Hole
     * "T"			- Trap
     * "S"			- Switch
     * "B"			- Box
     */
    public void DrawMapTest(){

    	for(int i=0;i<fields.length;i++)
    	{
    		for(int j=0;j<fields.length;j++)
    		{	
    			if(fields[i][j].getThing() != null){
    				String s = fields[i][j].getThing().toString();
    				if(s.equals("C")){
    					Character c = (Character)fields[i][j].getThing();
    					if(c.equals(TurnManager.getCurrentPlayer()))
    						System.out.print("X");
    					else
    						System.out.print(fields[i][j].getThing().toString());
    				}
    				else
    					System.out.print(s);
    			}
    			else{
    				System.out.print(fields[i][j].toString());
    			}

    		}
    		System.out.println();
    	}
    }
}