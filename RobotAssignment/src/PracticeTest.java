import kareltherobot.Directions;
import kareltherobot.Robot;
import kareltherobot.World;




public class PracticeTest implements Directions{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		World.setVisible(true);
		
		Robot r = new Robot(1,1,North,9022);
        World.setDelay(4);
        World.setSize(15,15);
     
int size=7;
int movetocenter=size/2;
while(r.facingEast()==false){
	r.turnLeft();
}
r.move();
r.turnLeft();
r.turnLeft();
for(int move=0; move<size; move++){
	r.move();
	r.putBeeper();
}
r.turnLeft();
r.turnLeft();
int down=size/2;
r.move();






	}

}