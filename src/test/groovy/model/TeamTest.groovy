package model

import org.junit.Test

/**
 * Unit tests for the <code>Team</code> class.
 *
 * @author Peter Urbak
 * @version 2014-07-10
 */
class TeamTest extends GroovyTestCase {

    // toString

    @Test
    void testToStringDefaultTeam() {
        Team team = new Team()
        assert team.toString() == "Team{ name : , members : [] }"
    }

    @Test
    void testToStringSpecificTeam() {
        String name = "Hold 7"
        List<Integer> members = [1, 3, 8]
        Team team = new Team(name: name, members: members)
        assert team.toString() == "Team{ name : Hold 7, members : [1, 3, 8] }"
    }

}
