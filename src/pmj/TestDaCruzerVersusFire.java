package pmj;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import robocode.control.testing.RobotTestBed;
import robocode.BattleResults;
import robocode.control.events.BattleCompletedEvent;

/**
 * Tests whether DaCruzer can beat fire at least once in a 10 round battle.
 * 
 * @author Phillip Johnson, Joshua Antonio
 */
public class TestDaCruzerVersusFire extends RobotTestBed {

  /**
   * Specifies that Fire and DaCruzer are to be matched up in this test case.
   * 
   * @return The comma-delimited list of robots in this match.
   */
  @Override
  public String getRobotNames() {
    return "sample.Fire,pmj.DaCruzer";
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
   * The actual test, which asserts that DaCruzer has beaten Fire at least once.
   * 
   * @param event Details about the completed battle.
   */
  @Override
  public void onBattleCompleted(BattleCompletedEvent event) {
    // Return the results in order of getRobotNames.
    BattleResults[] battleResults = event.getIndexedResults();
    // Sanity check that results[1] is DaCruzer (not strictly necessary, but illustrative).
    BattleResults daCruzerResults = battleResults[1];
    String robotName = daCruzerResults.getTeamLeaderName();
    assertEquals("Check that results[1] is DaCruzer", "pmj.DaCruzer*", robotName);

    // Check to make sure DaCruzer has beaten Fire at least once.
    assertTrue(daCruzerResults.getFirsts() > 0);
  }
}
