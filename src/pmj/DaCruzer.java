package pmj;

import robocode.Robot;
import robocode.ScannedRobotEvent;

/**
 * Implements the DaCruzer robot, which tries to stay away from other robots while firing on 
 * any it finds. 
 * 
 * Source code adapted with gratitude from B.J. DeLaCruz, for which this robot is named. 
 * @author Philip Johnson
 */
public class DaCruzer extends Robot {
  /**
   * Distance between the enemy and the robot.
   */
  private int distance;

  /**
   * Creates a robot that, at each time, will find the closest enemy and then move in the opposite
   * direction by one hundred pixels.
   */
  public void run() {
    distance = Integer.MAX_VALUE;
    while (true) {
      turnRadarRight(10.0);
    }
  }

  /**
   * Makes the robot turn towards the enemy and move in the opposite direction by one hundred
   * pixels. If no other enemy is closer, then the robot will remain stationary for the remainder of
   * the battle. Then fires at the robot.
   * 
   * @param e contains information about the enemy robot, e.g. its location
   */
  public void onScannedRobot(ScannedRobotEvent e) {

    // getDistance() returns the distance between one robot's center to another robot's center. A
    // robot is 40 x 40 pixels by default, so get the distance between the two robots' edges. Note
    // that this is an approximation, so give or take a few pixels.
    int enemyDistance = (int) Math.floor(e.getDistance() - 40.0);

    if (enemyDistance < distance) {
      distance = enemyDistance;
      // Once radar contact is made, turn towards the enemy and then move back one hundred pixels.
      turnRight(e.getBearing());
      back(100.0);
      distance += 100;
    }
    fire(3);

  }

}
