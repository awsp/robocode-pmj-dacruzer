package pmj;

import robocode.Robot;
import robocode.ScannedRobotEvent;
import robocode.WinEvent;
import java.awt.Color;
import robocode.HitByBulletEvent;

/**
 * Implements the DaCruzer robot, which completes a circuit around the arena, then spins to scan for
 * other robots.
 * 
 * @author Philip Johnson
 */
public class DaCruzer extends Robot {

  /**
   * Moves to successive corners and rotates the robot to maximize the chances of scanning another
   * robot. Code courtesy of Kimberly Heu.
   */
  @Override
  public void run() {

    // Customize tank colors.
    // Gun Color = Purple.
    this.setGunColor(new Color(102, 0, 102));
    // Radar Scan Color = White.
    this.setScanColor(Color.pink);
    // Body Color = Black.
    this.setBodyColor(new Color(0, 0, 0));
    // body = red, gun = white, radar = blue
    this.setColors(Color.red, Color.white, Color.blue);

    // Get the field's dimensions.
    // Specifies battle field width.
    double fieldWidth = getBattleFieldWidth();
    // Specifies battle field Height.
    double fieldHeight = getBattleFieldHeight();

    // Orient the robot so that it is facing upward.
    turnLeft(getHeading());

    // Late color changes once tank is ready to move.
    setBulletColor(Color.pink);
    setRadarColor(Color.pink);

    // Get the robot's current location.
    double robotX = getX();
    double robotY = getY();

    // Move to top left corner.
    ahead(fieldHeight - robotY);
    turnLeft(90);
    ahead(robotX);
    turnRight(360);

    // Move to bottom right corner.
    turnLeft(180);
    ahead(fieldWidth);
    turnRight(90);
    ahead(fieldHeight);
    turnRight(360);

    // Move to top right corner.
    turnLeft(180);
    ahead(fieldHeight);
    turnRight(360);

    // Move to bottom left corner.
    turnLeft(180);
    ahead(fieldHeight);
    turnRight(90);
    ahead(fieldWidth);
    turnRight(360);

    // If finished traversing, scan for robots and fire.
    // Spins the gun of the robot 90 degrees to conduct scans.
    while (true) {
      this.turnGunLeft(90);
    }
  }

  /**
   * Fires at any robot it finds with a power that is based on distance from target.
   * 
   * @param e contains information about the enemy robot, e.g. its location.
   */
  @Override
  public void onScannedRobot(ScannedRobotEvent e) {

    // Calculate the power level of the bullet based on event distance.
    double firePower = Math.min(400 / e.getDistance(), 3);

    // To avoid potentially wasting a turn, fire only if the gun heat is 0.
    if (getGunHeat() == 0.0) {
      this.fire(firePower);
    }
  }

  /**
   * Victory Dance once the robot has won.
   * 
   * @param win takes place when robot wins.
   */
  @Override
  public void onWin(WinEvent win) {
    // This was a triumph.
    while (true) {
      turnRight(20);
      ahead(100);
      back(100);
      turnLeft(20);
      turnGunRight(360);
    }
    // I'm making a note here: HUGE SUCCESS.
    // It's hard to overstate my satisfaction.
  }
  
  /**
   * Changes direction based on enemies bearing and moves away from fire.
   * 
   * @param event contains information about enemy
   */
  @Override
  public void onHitByBullet(HitByBulletEvent event) {
    if (event.getBearing() + 90 > 180) {
      turnRight(event.getBearing() - 90);
    }
    else {
      turnRight(event.getBearing() + 90);
    }
    ahead(50);
  }
}
