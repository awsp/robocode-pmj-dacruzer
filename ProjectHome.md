DaCruzer is a [Robocode](http://robocode.sourceforge.net/) robot implementing the following strategy:

**Movement:**  DaCruzer moves to each of the four corners of the battlefield. As each corner is reached, it spins 360 degrees. Once it completes this circuit, it remains in one location and spins around until the round is over.

**Targeting:** When spinning, it is scanning for other robots.

**Firing:**  Whenever it scans another robot, it immediately fires a bullet at that robot with full strength.

**Vulnerabilities:**  There are many opportunities for improvement of this robot. It does not attempt to avoid other robots and does nothing when colliding with another robot. It does not modify bullet strength based upon distance to the other robot, nor does it attempt to track another robot.  It does not save any information about other robots between rounds in order to improve its strategy.