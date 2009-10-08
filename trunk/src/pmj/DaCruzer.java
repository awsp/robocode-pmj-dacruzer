package pmj;

import robocode.Robot;
import robocode.ScannedRobotEvent;

/**
 * Implements the DaCruzer robot, which tries to stay away from other robots while firing on 
 * any it finds. 
 * 
 * 
 * @author Philip Johnson
 */
public class DaCruzer extends Robot {

  /**
   * Moves to successive corners. Code courtesy of Kimberly Heu. 
   */
  public void run() {
    
    // Get the field's dimensions.
    double battleFieldWidth = getBattleFieldWidth();
    double battleFieldHeight = getBattleFieldHeight();
    
    // Orient the robot so that it is facing upward.
    turnLeft(getHeading());
    
    //change bullet color to red.
    setBulletColor(Color.red);
      
    // Get the robot's current location.
    double rposX = getX();
    double rposY = getY();
    
    // Move to top left corner
    ahead(fheight - rposY);
    turnLeft(90);
    ahead(rposX); 
    turnRight(360);
    
    // Move to bottom right corner
    turnLeft(180);
    ahead(fwidth);
    turnRight(90);
    ahead(fheight);
    turnRight(360);
    
    // Move to top right corner
    turnLeft(180);
    ahead(fheight);
    turnRight(360);
    
    // Move to bottom left corner
    turnLeft(180);
    ahead(fheight);
    turnRight(90);
    ahead(fwidth);
    turnRight(360);
    
    // if finished traversing, scan for robots and fire.
    // spins the body of the robot to conduct scans.
    while (true) {
      this.turnLeft(90);
    }
  }

  /**
   * Fires at any robots it finds. 
   * 
   * @param e contains information about the enemy robot, e.g. its location
   */
  public void onScannedRobot(ScannedRobotEvent e) {
    fire(3);

  }

}
