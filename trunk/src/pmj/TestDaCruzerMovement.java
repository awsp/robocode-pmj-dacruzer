package pmj;

import static org.junit.Assert.assertTrue;
import pmj.test.RobotTestBed;
import robocode.control.events.BattleCompletedEvent;
import robocode.control.events.TurnEndedEvent;
import robocode.control.snapshot.IRobotSnapshot;

/**
 * Tests that DaCruzer moves to all four corners per its specified strategy.
 * @author Philip Johnson
 *
 */
public class TestDaCruzerMovement extends RobotTestBed {
  /** True if the robot visited this corner during the test case. */
  boolean visitedUpperLeft = false;
  /** True if the robot visited this corner during the test case. */
  boolean visitedUpperRight = false;
  /** True if the robot visited this corner during the test case. */
  boolean visitedLowerLeft = false;
  /** True if the robot visited this corner during the test case. */
  boolean visitedLowerRight = false;
  
  /**
   * Specifies that SittingDuck and DaCruzer are to be matched up in this test case.
   * @return The comma-delimited list of robots in this match.
   */
  @Override
  public String getRobotNames() {
    return "sample.SittingDuck,pmj.DaCruzer";
  }
  
  /**
   * This test runs for 10 rounds.
   * @return The number of rounds. 
   */
  @Override
  public int getNumRounds() {
    return 10;
  }
  
  /**
   * After each turn, check to see if we're at a corner.  If so, set the corresponding flag.
   * @param event Info about the current state of the battle.
   */
  @Override 
  public void onTurnEnded(TurnEndedEvent event) {
    IRobotSnapshot robot = event.getTurnSnapshot().getRobots()[1];
    double xPos = robot.getX();
    double yPos = robot.getY();
    if ((xPos < 40) && (yPos < 40)) {
      visitedUpperLeft = true;
    }
    if ((xPos < 40 && (yPos > (height - 40)))) {
      visitedLowerLeft = true;
    }
    if ((xPos > (width - 40)) && (yPos < 40)) {
      visitedUpperRight = true;
    }
    if ((xPos > (width - 40) && (yPos > (height - 40)))) {
      visitedLowerRight = true;
    }

  }
  
  
  /**
   * After the battle, check to see that we've visited the corners. 
   * @param event Details about the completed battle.
   */
  @Override
  public void onBattleCompleted(BattleCompletedEvent event) {
    assertTrue("Check UpperLeft", visitedUpperLeft);
    assertTrue("Check LowerLeft", visitedLowerLeft);
    assertTrue("Check UpperRight", visitedUpperRight);
    assertTrue("Check LowerRight", visitedLowerRight);
    
  }

}
