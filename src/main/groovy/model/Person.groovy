package model

import java.text.DateFormat
import java.text.SimpleDateFormat
/**
 * Encapsulates a <code>Person</code> object.
 *
 * @author Peter Urbak
 * @version 2014-07-10
 */
class Person {

    // --*-- Fields --*--

    static final DateFormat bornFormat = new SimpleDateFormat("yyyy-MM-dd")

    String name = ""
    Integer id = 0
    Date born = bornFormat.parse("1970-01-01")

    // --*-- Methods --*--

    /**
     * Returns a <code>String</code> description of the <code>Person</code>.
     *
     * @return a <code>String</code> description of the <code>Person</code>.
     */
    String toString() {
        "Person{ name : ${name}, id : ${id}, " +
                "born : ${bornFormat.format(born)} }"
    }

}
