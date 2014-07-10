package parsers

import model.Person
import model.Team
import org.junit.Before
import org.junit.Test

/**
 * Unit tests for the <code>TeamParser</code> class.
 *
 * @author Peter Urbak
 * @version 2014-07-10
 */
class TeamParserTest extends GroovyTestCase {

    List<Team> teams = []

    @Before
    void setUp() {
        TeamParser teamParser = new TeamParser()
        teams = teamParser.parseCSV("test-data/Groups.txt")
    }

    @Test
    void testParseCSVLength() {
        assert teams.size() == 2
    }

    @Test
    void testParseCSVHold1() {
        Team hold1 = teams.get(0)
        assert hold1.getName() == "Hold 1"

        List<Integer> members = hold1.getMembers()
        assert members.size() == 2
        assert members.get(0) == 1
        assert members.get(1) == 2
    }

    @Test
    void testParseCSVHold2() {
        Team hold2 = teams.get(1)
        assert hold2.getName() == "Hold 2"

        List<Integer> members = hold2.getMembers()
        assert members.size() == 2
        assert members.get(0) == 3
        assert members.get(1) == 4
    }

}
