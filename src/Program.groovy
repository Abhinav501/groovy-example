import groovy.time.TimeCategory
import groovy.time.TimeDuration
import model.Person
import model.Team
import parsers.PersonParser
import parsers.TeamParser

/**
 * Captures the main script of the program.
 *
 * @author Peter Urbak
 * @version 2014-07-09
 */
class Program {

    /**
     * Executes the program.
     */
    static void main(String[] args) {

        // Sanity check
        if (args.length < 2) {
            println "The script takes two inputs:\n" +
                    "1. An XML file containing person descriptions, and\n" +
                    "2. A CSV file containing team descriptions."
        }

        // Parse input files
        String xmlPath = args[0]
        String csvPath = args[1]
        List<Team> teams = TeamParser.parseCSV(csvPath)
        List<Person> persons = PersonParser.parseXML(xmlPath)
        Map<Integer, Person> personMap = new HashMap<>();
        persons.each { person ->
            personMap.put(person.getId(), person)
        }

        // Calculate "oldest" team
        int oldestTeamIndex = 0
        int oldestTeamAge = 0
        int teamIndex = 0
        Date now = new Date()

        teams.each { teamIt ->
            int teamAge = 0

            teamIt.getMembers().each { member ->
                Date memberBorn = personMap.get(member).getBorn()
                TimeDuration age = TimeCategory.minus(now, memberBorn)
                teamAge += age.days
            }

            if (teamAge > oldestTeamAge) {
                oldestTeamAge = teamAge
                oldestTeamIndex = teamIndex
            }

            teamIndex++
        }

        // Print oldest team
        Team oldestTeam = teams.get(oldestTeamIndex)
        String teamDescription = oldestTeam.getName()
        List<String> namesInTeam = oldestTeam.getMembers().collect { member ->
            personMap.get(member).getName()
        }
        namesInTeam.sort()

        namesInTeam.each { name ->
            teamDescription = teamDescription + ", ${name}"
        }
        println teamDescription

    }
}
