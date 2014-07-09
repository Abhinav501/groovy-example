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
     * Adds a new member to the <code>Team</code>.
     *
     * @param id - the ID of the <code>Person</code> to be added.
     */
    void addTeamMember(int id) {
        members.add(id)
    }

    /**
     * Removes a member from the <code>Team</code>.
     *
     * @param index - the index of the <code>Person</code> ID to be removed.
     */
    void removeTeamMember(int index) {
        members.remove(index)
    }

    /**
     * Returns the <code>Person</code> ID of the specified index.
     *
     * @param index - the index of the <code>Person</code> ID to be retrieved.
     * @return the <code>Person</code> ID of the specified index.
     */
     int getTeamMember(int index) {
        return members.get(index)
    }

    /**
     * Returns the <List> of <code>Person</code> IDs on the team.
     *
     * @return the <List> of <code>Person</code> IDs on the team.
     */
    List<Integer> getTeamMembers() {
        return members
    }

    /**
     * Returns a <code>String</code> description of the <code>Team</code>.
     *
     * @return a <code>String</code> description of the <code>Team</code>.
     */
    String toString() {
        "model.Team{ name : ${name}, members : ${members} }"
    }

}
