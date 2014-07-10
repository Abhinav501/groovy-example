package parsers

import model.Team
/**
 * Parses CSV files containing team descriptions.
 * Expects properly formatted and consistent input where there are no commas
 * in the team name.
 *
 * @author Peter Urbak
 * @version 2014-07-10
 */
class TeamParser {

    // --*-- Methods --*--

    /**
     * Parses a CSV file containing team descriptions and returns a
     * <code>List</code> of <code>Team</code> objects.
     *
     * @param filename - the path of the CSV file to be parsed.
     * @return a <code>List</code> of <code>Person</code> objects.
     */
    List<Team> parseCSV(String filename) {
        List<Team> teams = []

        def csvFile = new File(filename)
        csvFile.eachLine { lineIt ->
            String[] columns = lineIt.split(",")

            if (columns.length > 0) {
                String name = columns[0]
                Team team = new Team(name: name)
                columns = columns.drop(1)

                columns.each { colIt ->
                    team.getMembers().add(colIt.toInteger())
                }
                teams.add(team)
            }
        }

        return teams
    }

}