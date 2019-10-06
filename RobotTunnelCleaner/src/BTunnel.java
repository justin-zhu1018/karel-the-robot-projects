//import java.awt.Robot;
//import java.util.Scanner;
import kareltherobot.WorldBuilder;
import javax.swing.JOptionPane;

import kareltherobot.Robot;
import kareltherobot.Directions;
import kareltherobot.World;


public class BTunnel implements Directions {

	 Robot fizz;
	 Robot bobo;
	 int total;
	 float average;
	 int max;
	 int one;
	 int two;
	 int move;
	 int qmax;
	 int street;
	 int avenue;
	 int st;
	 int ave;
	 int pile;
	 int BPD;
	 
	 
	public static void main(String[] args) {
		new BTunnel().start();
	}
	
	private void start() {
		setUpRoom();
		cleanRoom();
		reportStats();
	}
	
	private void setUpRoom() {
		// input the world from user.  Input the robot location and direction
		World.setVisible(true);
		new WorldBuilder(true);
	
		String name=JOptionPane.showInputDialog("Please enter the name of the world.");
		System.out.println("You have entered "+name+".");
	
		World.readWorld(name);
		
		String answer = JOptionPane.showInputDialog("Enter the street for the robot.");
		street = Integer.parseInt(answer);
	    
		String answer2 = JOptionPane.showInputDialog("Enter the avenue for the robot.");
		avenue = Integer.parseInt(answer2);
			
		String answer3 = JOptionPane.showInputDialog("Now enter the direction. North=1 East=2 South=3 West=4");
		int direction = Integer.parseInt(answer3);
	   
		if(direction==1){
			fizz = new Robot(street,avenue,North,0);
		}
		else if(direction==2){
			fizz = new Robot(street,avenue,East,0);
		}
		else if(direction==3){
			fizz = new Robot(street,avenue,South,0);
		}
		else if(direction==4){
			fizz = new Robot(street,avenue,West,0);
		}
	
	}
		
	//	World.readWorld("MessOfAWorld.wld");
	
	private void cleanRoom() {
		// Assuming the Robot has been placed in the room, pick up all
		// Beepers in the room, counting the following:  total number of beeps,
		// biggest pile of beeps, number of beeper piles, dimensions of the room
	
		World.setDelay(1);

		max=0;
		qmax=0;
		total=0;
		one=0;
		two=0;
		move=1;
		st=1;
		ave=1;
		pile=1;
		
		
		while(fizz.facingSouth()==false){
			fizz.turnLeft();
		}
		while(fizz.frontIsClear()==true){
			fizz.move();
		}
		while(fizz.facingWest()==false){
			fizz.turnLeft();
		}
		while(fizz.frontIsClear()==true){
			fizz.move();
		}
		while(fizz.facingEast()==false){
			fizz.turnLeft();
		}
		while(fizz.frontIsClear()==true){
			fizz.move();
			ave++;
		}
		if(fizz.frontIsClear()==false){
			while(fizz.facingWest()==false){
				fizz.turnLeft();
			}
			fizz.move();
		if(fizz.frontIsClear()==true){
			System.out.println("Ave:"+ave+" street: "+st);
			street=st;
			avenue=ave;
			bobo= new Robot(street,avenue,West,0);
			while(fizz.facingEast()==false){
				fizz.turnLeft();
			}
			Start();
			}
//			if(fizz.frontIsClear()==false){
//				fizz.turnLeft();
//			}
//			if(fizz.frontIsClear()==true){
//				fizz.move();
//				st++;
//			}
		}
	}

	
	private void Start() {
		// TODO Auto-generated method stub
		while(fizz.frontIsClear()==true){
			if(fizz.nextToABeeper()==true){
				qmax=0;
				pile++;
			}
			while(fizz.nextToABeeper()==true){
				fizz.pickBeeper();
				total++;
				qmax++;
			}	
			if(max<qmax){
				max=qmax;
				BPD=move;
			}	
			if(fizz.nextToABeeper()==false){
				if(fizz.frontIsClear()==true){
					fizz.move();
					move++;
				}
			}
			if(fizz.frontIsClear()==false){
				if(fizz.frontIsClear()==false){
					turnRight();
				}
				if(fizz.frontIsClear()==false){
					fizz.turnLeft();
					fizz.turnLeft();
				}
				if(fizz.frontIsClear()==false){
					reset();
				}
			}
		}
	}
	

	private void reset() {
		// TODO Auto-generated method stub
		while(fizz.frontIsClear()==false){
			fizz.turnLeft();
		}	
		while(fizz.nextToABeeper()==true){
			if(fizz.nextToABeeper()==true){
				qmax=0;
			}
			while(fizz.nextToABeeper()==true){
				fizz.pickBeeper();
				total++;
				qmax++;
			}	
			if(max<qmax){
				max=qmax;
				BPD=move;
			}	
		}
		while(fizz.nextToARobot()==false){
			if(fizz.nextToABeeper()==false){
				if(fizz.frontIsClear()==true){
					fizz.move();
				}
			}
			while(fizz.nextToARobot()==true){
				while(fizz.facingWest()==false){
					fizz.turnLeft();
				}
				while(fizz.anyBeepersInBeeperBag()){
					fizz.putBeeper();
				}
				if(fizz.anyBeepersInBeeperBag()==false){
					while(fizz.frontIsClear()==true){
						oneMove();
					}
				}
			}
			if(fizz.frontIsClear()==false){
				if(fizz.frontIsClear()==false){
					turnRight();
				}
				if(fizz.frontIsClear()==false){
					fizz.turnLeft();
					fizz.turnLeft();
				}
			}
		}
	}

	private void oneMove() {
		// TODO Auto-generated method stub
		bobo.move();
		fizz.move();
		reportStats();
	}

	private void turnRight() {
	// TODO Auto-generated method stub
	    fizz.turnLeft();
	   	fizz.turnLeft();
	   	fizz.turnLeft();
	}

	
	private void reportStats() {
        //Location of entrance, # of piles, total beeps, avg pile size,
		//biggest pile, location of biggest pile, depth of tunnel
    	double average;
    	average=Math.ceil((double)total/move);
    	
    	System.out.println("The location of the entrance is... Street:"+ st+" and Avenue:"+ave);
    	System.out.println("Number of Piles:"+pile);
    	System.out.println("The total number of beepers is "+total+ ".");
      	System.out.println("The average pile is "+average+ " beepers rounded up.");
    	System.out.println("The largest pile of beepers is "+max+ ".");
    	System.out.println("The location of the biggest pile is "+BPD+".");
    	System.out.println("The tunnel is "+move+ " steps deep.");

    	
	}
}
