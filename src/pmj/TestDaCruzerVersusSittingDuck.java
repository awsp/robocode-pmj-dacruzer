package pmj;

import static org.junit.Assert.assertEquals;
import pmj.test.RobotTestBed;
import robocode.BattleResults;
import robocode.control.events.BattleCompletedEvent;

/**
 * Illustrates JUnit testing of Robocode robots. This test simply verifies that DaCruzer always
 * beats SittingDuck.
 * 
 * @author Philip Johnson
 * 
 */
public class TestDaCruzerVersusSittingDuck extends RobotTestBed {

  /**
   * Specifies that SittingDuck and DaCruzer are to be matched up in this test case.
   * 
   * @return The comma-delimited list of robots in this match.
   */
  @Override
  public String getRobotNames() {
    return "sample.SittingDuck,pmj.DaCruzer";
  }

  /**
   * This test runs for 10 rounds.
   * 
   * @return The number of rounds.
   */
  @Override
  public int getNumRounds() {
    return 10;
  }

  /**
   * The actual test, which asserts that DaCruzer has won every round against SittingDuck.
   * 
   * @param event Details about the completed battle.
   */
  @Override
  public void onBattleCompleted(BattleCompletedEvent event) {
    // Return the results in order of getRobotNames.
    BattleResults[] results = event.getIndexedResults();
    // Sanity check that results[1] is DaCruzer (not strictly necessary, but illustrative).
    assertEquals("Check results[1]", results[1].getTeamLeaderName(), "pmj.DaCruzer");

    // Check to make sure DaCruzer won every round.
    assertEquals("Check DaCruzer winner", results[1].getFirsts(), getNumRounds());
  }
}
