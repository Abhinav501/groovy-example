package model

import org.junit.Test

/**
 * Unit tests for the <code>Person</code> class.
 *
 * @author Peter Urbak
 * @version 2014-07-10
 */
class PersonTest extends GroovyTestCase {

    // toString

    @Test
    void testToStringDefaultPerson() {
        Person person = new Person()
        assert person.toString() == "Person{ name : , " +
                "id : 0, born : 1970-01-01 }"
    }

    @Test
    void testToStringSpecificPerson() {
        String name = "John Doe"
        int id = 42
        Date born = Person.bornFormat.parse("1988-09-16")
        Person person = new Person(name: name, id: id, born: born)
        assert person.toString() == "Person{ name : John Doe, " +
                "id : 42, born : 1988-09-16 }"
    }

}
