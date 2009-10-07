package pmj;

import java.awt.Color;
import java.util.Random;
import robocode.Robot;
import robocode.ScannedRobotEvent;

/**
 * Implements the DaCruzer robot, which tries to stay away from other robots while firing on 
 * any it finds. 
 * 
 * @author Philip Johnson
 */
public class DaCruzer extends Robot {

  /**
   * Moves to successive corners. Code courtesy of Kimberly Heu. 
   */
  public void run() {
    
    // Get the field's dimensions.
    double fwidth = getBattleFieldWidth();
    double fheight = getBattleFieldHeight();
    Random r = new Random();
    int maxColor = (int)Math.pow(2, 32);
    
    setColors(new Color(r.nextInt(maxColor)), new Color(r.nextInt(maxColor)),
              new Color(r.nextInt(maxColor)));
    turnLeft(getHeading());
    
    // Get the robot's current location.
    double rposx = getX();
    double rposy = getY();
    
    // Move to top left corner.
    ahead(fheight - rposy);
    turnLeft(90);
    ahead(rposx); 
    turnRight(360);
    
    // Move to bottom right corner.
    turnLeft(180);
    ahead(fwidth);
    turnRight(90);
    ahead(fheight);
    turnRight(360);
    
    // Move to top right corner.
    turnLeft(180);
    ahead(fheight);
    turnRight(360);
    
    // Move to bottom left corner.
    turnLeft(180);
    ahead(fheight);
    turnRight(90);
    ahead(fwidth);
    turnRight(360);
    
    int counter = 0;
    
    // Scan for robots and fire after traversing the corners.
    while (true) {
      if (counter % 2 == 0) {
        this.turnLeft(48);
      }
      else {
        this.turnRight(90);
      }
      counter++;
    }
    
  }

  /**
   * Fires at any robots it finds at full power. Code courtesy of BJ Peter DeLaCruz.
   * 
   * @param e Contains information about the enemy robot, e.g. its location
   */
  public void onScannedRobot(ScannedRobotEvent e) {
    fire(3); // Fire at full power
  }

}
