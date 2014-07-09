package model
/**
 * Specifies a <code>Team</code> object.
 *
 * @author Peter Urbak
 * @version 2014-07-09
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
        "model.Team{ name : ${name}, members : ${members} }"
    }

}
