package parsers

import model.Team

/**
 * Parses CSV files containing team descriptions.
 *
 * @author Peter Urbak
 * @version 2014-07-09
 */
class TeamParser {

    // --*-- Methods --*--

    /**
     * Parses a CSV file containing team descriptions and returns a
     * <code>List</code> of <code>Team</code> objects.
     *
     * @param filename -
     * @return a <code>List</code> of <code>Person</code> objects.
     */
    static List<Team> parseCSV(String filename) {
        List<Team> teams = []

        def csvFile = new File(filename)
        csvFile.eachLine { lineIt ->
            String[] columns = lineIt.split(",")

            if (columns.length > 0) {
                String name = columns[0]
                Team team = new Team(name: name)
                columns = columns.drop(1)

                columns.each { colIt ->
                    team.addTeamMember(colIt.toInteger())
                }
                teams.add(team)
            }
        }

        return teams
    }

}