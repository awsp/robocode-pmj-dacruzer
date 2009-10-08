package pmj;

import robocode.Robot;
import robocode.ScannedRobotEvent;
import java.awt.Color;

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
    double fwidth = getBattleFieldWidth(); //Specifies battle field width
    double fheight = getBattleFieldHeight(); //Specifies battle field Height
    
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
    ahead(battleFieldHeight - rposY);
    turnLeft(90);
    ahead(rposX); 
    turnRight(360);
    
    // Move to bottom right corner
    turnLeft(180);
    ahead(battleFieldWidth);
    turnRight(90);
    ahead(battleFieldHeight);
    turnRight(360);
    
    // Move to top right corner
    turnLeft(180);
    ahead(battleFieldHeight);
    turnRight(360);
    
    // Move to bottom left corner
    turnLeft(180);
    ahead(battleFieldHeight);
    turnRight(90);
    ahead(battleFieldWidth);
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
