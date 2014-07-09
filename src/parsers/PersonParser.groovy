package parsers

import model.Person

/**
 * Parses XML files containing person descriptions.
 * Expects properly formatted and consistent input.
 *
 * @author Peter Urbak
 * @version 2014-07-09
 */
class PersonParser {

    // --*-- Methods --*--

    /**
     * Parses an XML file containing person descriptions and returns a
     * <code>List</code> of <code>Person</code> objects.
     *
     * @param filename - the path of the XML file to be parsed.
     * @return a <code>List</code> of <code>Person</code> objects.
     */
    static List<Person> parseXML(String filename) {
        List<Person> personList = []

        Node persons = new XmlParser().parse(filename)
        persons.person.each {
            String name = it.name.text()
            int id = it.id.text().toInteger()
            Date born = Person.bornFormat.parse(it.born.text())
            Person person = new Person(name: name, id: id, born: born)
            personList.add(person)
        }

        return personList
    }

}
