package model
/**
 * Encapsulates a <code>Team</code> object.
 *
 * @author Peter Urbak
 * @version 2014-07-10
 */
class Team {

    // --*-- Fields --*--

    String name = ""
    List<Integer> members = []

    // --*-- Methods --*--

    /**
     * Returns a <code>String</code> description of the <code>Team</code>.
     *
     * @return a <code>String</code> description of the <code>Team</code>.
     */
    String toString() {
        "Team{ name : ${name}, members : ${members} }"
    }

}
