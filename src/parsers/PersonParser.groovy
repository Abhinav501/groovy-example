package parsers

import model.Person

import java.text.DateFormat
import java.text.SimpleDateFormat

/**
 * Parses XML files containing person descriptions.
 *
 * @author Peter Urbak
 * @version 2014-07-09
 */
class PersonParser {

    // --*-- Methods --*--

    /**
     * Parses an XML file containing person descriptions and returns a <code>List</code>
     * of <code>Person</code> objects.
     *
     * @param filename -
     * @return a <code>List</code> of <code>Person</code> objects.
     */
    List<Person> parseXML(String filename) {
        List<Person> personList = []
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd")

        Node persons = new XmlParser().parse(filename)
        persons.person.each {
            Person person = new Person(name: it.name,id: it.id, born: dateFormat.parse(it.born))
            personList.add(person)
        }

        return personList
    }

}
