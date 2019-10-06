
import kareltherobot.WorldBuilder;
import javax.swing.JOptionPane;

import kareltherobot.Robot;
import kareltherobot.Directions;
import kareltherobot.World;


public class RoomCleaner implements Directions {

	 Robot fizz;
	 int area;
	 int length;
	 int width;
	 int total;
	 float average;
	 int max;
	 int one;
	 int two;
	 int percent;
	 int finalpercent;
	 int move;
	 int qmax;
	 
	public static void main(String[] args) {
		new RoomCleaner().start();
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
		int street = Integer.parseInt(answer);
	    
		String answer2 = JOptionPane.showInputDialog("Enter the avenue for the robot.");
		int avenue = Integer.parseInt(answer2);
			
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
		length=1;
		width=1;
		area=0;
		one=0;
		two=0;
		move=1;
 
		while(fizz.facingSouth()==false){
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
		}
		while(fizz.facingNorth()==false){
			fizz.turnLeft();
        }
       
		while(fizz.frontIsClear()==true){
			length++;
			fizz.move();
		}
		while(fizz.frontIsClear()==false){
			fizz.turnLeft();
		}
		while(fizz.frontIsClear()==true){
			width++;
			fizz.move();
		}
		
        
		
    
	StartAtBottomLeftCorner();
	//ONE ROW
	if(fizz.frontIsClear()==true){
		while(fizz.nextToABeeper()==true){
			fizz.pickBeeper();
			total++;
			max++;
		}
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
		}
		if(qmax<max){
			qmax=0;
		}
		while(fizz.frontIsClear()==true){
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
			}
			if(qmax<max){
				qmax=0;
			}
			if(fizz.frontIsClear()==true){
			   	fizz.move();
			    move++;
			}
		}
	}	

    
    
			//ALL
    
		for(int x=1; x<width; x++){
			while(fizz.facingNorth()==true){
				turnfromthetop();
			}
			while(fizz.frontIsClear()==true){
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
				}
				if(fizz.frontIsClear()==true){
					fizz.move();
					move++;
				}
				if(fizz.frontIsClear()==false){
				reset();
				}
			}
		}
	}	



	
	
	private void reset() {
	// TODO Auto-generated method stub
		while(fizz.nextToABeeper()==true){
			qmax=0;
			fizz.pickBeeper();
			total++;
			qmax++;
		}	
		if(max<qmax){
			max=qmax;
		}
		while(fizz.facingNorth()==false){
			fizz.turnLeft();
		}
		while(fizz.frontIsClear()==true){
			fizz.move();
		}
	}
	
	//	private void turnfromthebottom() {
			// TODO Auto-generated method stub
	//		if(fizz.frontIsClear()==false){
	//			fizz.turnLeft();
	//			fizz.move();
	//			move++;
	//		}
	//		if(fizz.nextToABeeper()==true){
	//			qmax=0;
	//		}
	//		while(fizz.nextToABeeper()==true){
	//			fizz.pickBeeper();
	//			total++;
	//			qmax++;
	//		}
	//		if(max<qmax){
	//			max=qmax;
	//		}
	//		if(qmax<max){
	//			qmax=0;
	//		}
	//		fizz.turnLeft();
	//		}
	//	

	private void turnfromthetop() {
		// TODO Auto-generated method stub
	    if(fizz.frontIsClear()==false){
	    	turnRight();
	    }
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
		}
		if(qmax<max){
			qmax=0;
		}
		if(fizz.frontIsClear()==true){
    	fizz.move();
    	move++;
    	turnRight();
		}
	}
	

	private void turnRight() {
	// TODO Auto-generated method stub
	    fizz.turnLeft();
	   	fizz.turnLeft();
	   	fizz.turnLeft();
	}

	private void StartAtBottomLeftCorner() {
	// TODO Auto-generated method stub
		while(fizz.frontIsClear()==false){
			fizz.turnLeft();
		}
		while(fizz.frontIsClear()==true){
			fizz.move();
		}
		while(fizz.facingNorth()==false){
			fizz.turnLeft();
		}
		while(fizz.frontIsClear()==false){
			fizz.turnLeft();
		}
		if(fizz.facingSouth()==true){
			while(fizz.frontIsClear()==true){
				fizz.move();
			}	
		}	
		while(fizz.facingNorth()==false){
			fizz.turnLeft();
		}
	}
	
	private void reportStats() {
		// Prints out total beeps✓, highest pile, average pile size✓, 
		// percent clean✓ (number of clean locations divided by area of room)
    	area=length*width;
    	double average;
    	average=Math.ceil((double)total/area);
    	double finalpercent;
    	finalpercent=(float)((move*100/area));

    	System.out.println("It is "+finalpercent+"% clean.");
    	System.out.println("The total number of beepers is "+total+ ".");
    	System.out.println("The average pile is "+average+ " beepers rounded up.");
    	System.out.println("The area of the room is "+area+".");
    	System.out.println("The largest pile of beepers is "+max+ ".");
    	
	}
}
