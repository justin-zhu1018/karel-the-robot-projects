import kareltherobot.Directions;
import kareltherobot.Robot;
import kareltherobot.World;
import kareltherobot.WorldBuilder;




public class Hurdling implements Directions{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		World.setVisible(true);
	    World.checkBeeper(infinity, infinity);
        World.setDelay(0);
        World.setSize(20,20);
        World.readWorld("thomas.wld");
        Robot rob = new Robot(1,1,East,0);
        
        new WorldBuilder(true);

        int steps =1;
        int steps2 =1;
        int steps3 =1;
        int height =1;
        int height2 =1;
        int height3 =1;
        
 

        //Hurdle1
        while(rob.frontIsClear()==true){
        rob.move();	
        }
        while(rob.frontIsClear()==false){
        rob.turnLeft();
        rob.move();
        if(rob.frontIsClear()==true)
        rob.turnLeft();
        rob.turnLeft();
        rob.turnLeft();
        }
        if(rob.frontIsClear()==true){
        rob.move();
        rob.turnLeft();
        rob.turnLeft();
        rob.turnLeft(); 
        }
        if(rob.frontIsClear()==false){
        rob.turnLeft();
        rob.move();
        rob.turnLeft();
        rob.turnLeft();
        rob.turnLeft();
        }
        while(rob.frontIsClear()==true){
        rob.move();
        steps++;
        height++;
        }
        if(rob.frontIsClear()==false){
        rob.turnLeft();
        } 
        if(rob.frontIsClear()==true){
        rob.move();
        }

     
        
        //Hurdle2
        while(rob.frontIsClear()==true){
        rob.move();	
        }
        while(rob.frontIsClear()==false){
        rob.turnLeft();
        rob.move();
        if(rob.frontIsClear()==true)
        rob.turnLeft();
        rob.turnLeft();
        rob.turnLeft();
        }
        if(rob.frontIsClear()==true){
        rob.move();
        rob.turnLeft();
        rob.turnLeft();
        rob.turnLeft(); 
        }
        if(rob.frontIsClear()==false){
        rob.turnLeft();
        rob.move();
        rob.turnLeft();
        rob.turnLeft();
        rob.turnLeft();
        }
        while(rob.frontIsClear()==true){
        rob.move();
        steps2++;
        height2++;
        }
        if(rob.frontIsClear()==false){
        rob.turnLeft();
        } 
        if(rob.frontIsClear()==true){
        rob.move();
        }

   
        
        //Hurdle3
        while(rob.frontIsClear()==true){
        rob.move();	
        }
        while(rob.frontIsClear()==false){
        rob.turnLeft();
        rob.move();
        if(rob.frontIsClear()==true)
        rob.turnLeft();
        rob.turnLeft();
        rob.turnLeft();
        }
        if(rob.frontIsClear()==true){
        rob.move();
        rob.turnLeft();
        rob.turnLeft();
        rob.turnLeft();
        }
        if(rob.frontIsClear()==false){
        rob.turnLeft();
        rob.move();
        rob.turnLeft();
        rob.turnLeft();
        rob.turnLeft();
        }
        while(rob.frontIsClear()==true){
        rob.move();
        steps3++;
        height3++;
        }
        if(rob.frontIsClear()==false){
        rob.turnLeft();
        }
        if(rob.frontIsClear()==true){
        rob.move();
        }
        while(rob.frontIsClear()==false){
        rob.turnLeft();
        rob.turnLeft();
        rob.turnLeft();
        }
        if(rob.frontIsClear()==false){
        rob.turnLeft();
        } 
        if(rob.frontIsClear()==true){
        rob.move();
        }
        
        int max =height;
        if(height2>max){
        max=height2;
        }
        if(height3>max){
        max=height3;
        }
    
    	
System.out.println("The height of Hurdle #1 is "+steps+" step(s) tall.");       
System.out.println("The height of Hurdle #2 is " +steps2+ " step(s) tall.");
System.out.println("The height of Hurdle #3 is " +steps3+ " step(s) tall.");
System.out.println("Please stand by...");
System.out.println(".......");
System.out.println("....");
System.out.println("Revealing greatest height...");



if(height==max && height2<max && height3<max){
System.out.println("The greatest hurdle is Hurdle #1 which is "+max+" steps tall!");
}
if(height<max && height2==max && height3<max){
System.out.println("The greatest hurdle is Hurdle #2 which is "+max+" steps tall!");
}
if(height<max && height2<max && height3==max){
System.out.println("The greatest hurdle is Hurdle #3 which is "+max+" steps tall!");
}
if(height==max && height2==max && height3==max){
System.out.println("All three hurdles are "+max+" steps tall.");
}

if(height==max && height2==max && height3<max){
System.out.println("Both Hurdle #1 and Hurdle #2 are the highest,they are both "+max+ " steps tall!");
}
if(height==max && height2<max && height3==max){
System.out.println("Both Hurdle #1 and Hurdle #3 are the highest,they are both "+max+ " steps tall!");
}
if(height<max && height2==max && height3==max){
System.out.println("Both Hurdle #2 and Hurdle #3 are the highest,they are both "+max+ " steps tall!");
}



   
        
        
        
        
         
   
 

 
               
       
           
        

            
            
            
      
        
        
     
        

	}

 {
	
		
	}

}