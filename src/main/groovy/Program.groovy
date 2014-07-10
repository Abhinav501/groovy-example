import groovy.time.TimeCategory
import groovy.time.TimeDuration

import model.Person
import model.Team

import parsers.PersonParser
import parsers.TeamParser
/**
 * Prints the description of the team with the highest combined age.
 *
 * @author Peter Urbak
 * @version 2014-07-10
 */
class Program {

    // --*-- Fields --*--

    Map<Integer, Person> personMap = [:]

    // --*-- Methods --*--

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

        Program program = new Program()

        // Parse input files
        String xmlPath = args[0]
        String csvPath = args[1]
        TeamParser teamParser = new TeamParser()
        List<Team> teams = teamParser.parseCSV(csvPath)
        PersonParser personParser = new PersonParser()
        List<Person> persons = personParser.parseXML(xmlPath)
        persons.each { person ->
            program.getPersonMap().put(person.getId(), person)
        }

        // Calculate and print oldest team
        Team oldestTeam = program.calculateOldestTeam(teams)
        String teamDescription = program.composeTeamDescription(oldestTeam)
        println teamDescription

    }

    /**
     * Calculates the <code>Team</code> with the highest combined age across its
     * members.
     *
     * @return the <code>Team</code> with the highest combined age across its
     * members.
     */
    Team calculateOldestTeam(List<Team> teams) {

        int oldestTeamIndex = 0
        int oldestTeamAge = 0
        int teamIndex = 0
        Date now = new Date()

        teams.each { teamIt ->
            int teamAge = 0

            teamIt.getMembers().each { member ->
                Date memberBorn = getPersonMap().get(member).getBorn()
                TimeDuration age = TimeCategory.minus(now, memberBorn)
                teamAge += age.days
            }

            if (teamAge > oldestTeamAge) {
                oldestTeamAge = teamAge
                oldestTeamIndex = teamIndex
            }

            teamIndex++
        }

        return teams.get(oldestTeamIndex)
    }

    /**
     * Creates a description of the specified <code>Team</code> containing the
     * team name and the names of every member sorted alphabetically.
     *
     * @param team -
     * @param personMap -
     * @return a description of the specified team
     */
    String composeTeamDescription(Team team) {
        String teamDescription = team.getName()
        List<String> namesInTeam = team.getMembers().collect {
            member -> getPersonMap().get(member).getName()
        }
        namesInTeam.sort()

        namesInTeam.each { name ->
            teamDescription = teamDescription + ", ${name}"
        }
        return teamDescription
    }
}
