package pmj;

import robocode.Robot;
import robocode.ScannedRobotEvent;
import java.awt.Color;

/**
 * Implements the DaCruzer robot, which tries to stay away from other robots while firing on 
 * any it finds. 
 * 
 * @author Philip Johnson
 * @version 1.2
 */
public class DaCruzer extends Robot {

  /**
   * Moves to successive corners. Code courtesy of Kimberly Heu. 
   */
  public void run() {
    
    // Get the field's dimensions.
    //Specifies battle field width
    double fWidth = getBattleFieldWidth();
    //Specifies battle field Height
    double fHeight = getBattleFieldHeight(); 
    
    // Orient the robot so that it is facing upward.
    turnLeft(getHeading());
    
    //change bullet color to red.
    setBulletColor(Color.red);
    //change radar color to black.
    setRadarColor(Color.black);
      
    // Get the robot's current location.
    double rposX = getX();
    double rposY = getY();
    
    // Move to top left corner
    ahead(fHeight - rposY);
    turnLeft(90);
    ahead(rposX); 
    turnRight(360);
    
    // Move to bottom right corner
    turnLeft(180);
    ahead(fWidth);
    turnRight(90);
    ahead(fHeight);
    turnRight(360);
    
    // Move to top right corner
    turnLeft(180);
    ahead(fHeight);
    turnRight(360);
    
    // Move to bottom left corner
    turnLeft(180);
    ahead(fHeight);
    turnRight(90);
    ahead(fWidth);
    turnRight(360);
    
    // if finished traversing, scan for robots and fire.
    // spins the body of the robot to conduct scans.
    while (true) {
      this.turnLeft(90);
    }
  }

  /**
   * Fires at any robots it finds with a power that is based on distance from target. 
   * 
   * @param e contains information about the enemy robot, e.g. its location
   */
  public void onScannedRobot(ScannedRobotEvent e) {
    fire(Math.min(400 / e.getDistance(), 3));
  }


}
