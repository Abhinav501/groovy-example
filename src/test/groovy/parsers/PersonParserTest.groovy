package parsers

import model.Person
import org.junit.Before
import org.junit.Test

/**
 * Unit tests for the <code>PersonParser</code> class.
 *
 * @author Peter Urbak
 * @version 2014-07-10
 */
class PersonParserTest extends GroovyTestCase {

    List<Person> persons = []

    @Before
    void setUp() {
        PersonParser personParser = new PersonParser()
        persons = personParser.parseXML("test-data/Persons.XML")
    }

    @Test
    void testParseXMLLength() {
        assert persons.size() == 4
    }

    @Test
    void testParseXMLCarl() {
        Person carl = persons.get(0)
        assert carl.getName() == "Carl Poulsen"
        assert carl.getId() == 1
        assert Person.bornFormat.format(carl.getBorn()) == "1977-02-09"
    }

    @Test
    void testParseXMLNiels() {
        Person niels = persons.get(3)
        assert niels.getName() == "Niels Nielsen"
        assert niels.getId() == 4
        assert Person.bornFormat.format(niels.getBorn()) == "1989-04-12"
    }

}
