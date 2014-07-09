package model

import java.text.SimpleDateFormat
/**
 * Specifies a <code>Person</code> object.
 *
 * @author Peter Urbak
 * @version 2014-07-09
 */
class Person {

    // --*-- Fields --*--

    String name = ""
    String id = 0
    Date born = new SimpleDateFormat("yyyy-MM-dd").parse("1970-01-01")

    // --*-- Methods --*--

    /**
     * Returns a <code>String</code> description of the <code>Person</code>.
     *
     * @return a <code>String</code> description of the <code>Person</code>.
     */
    String toString() {
        "model.Person{ name : ${name}, id : ${id}, born : ${born} }"
    }

}
