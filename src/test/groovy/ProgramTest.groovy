import model.Person
import model.Team
import org.junit.Before
import org.junit.Test
import parsers.PersonParser
import parsers.TeamParser

/**
 * System tests of the whole program.
 *
 * @author Peter Urbak
 * @version 2014-07-10
 */
class ProgramTest extends GroovyTestCase {

    List<Team> teams = []
    Program program

    @Before
    void setUp() {
        program = new Program()
        Map<Integer, Person> personMap = [:]
        TeamParser teamParser = new TeamParser()
        teams = teamParser.parseCSV("test-data/Groups.txt")
        PersonParser personParser = new PersonParser()
        List<Person> persons = personParser.parseXML("test-data/Persons.XML")
        persons.each { person ->
            personMap.put(person.getId(), person)
        }
        program.setPersonMap(personMap)
    }

    @Test
    void testCalculateOldestTeam() {
        assert program.calculateOldestTeam(teams) == teams.get(1)
    }

    @Test
    void testComposeTeamDescription() {
        Team oldestTeam = teams.get(1)
        String teamDescription = "Hold 2, Niels Nielsen, Peter Hansen"
        assert program.composeTeamDescription(oldestTeam) == teamDescription
    }
}
