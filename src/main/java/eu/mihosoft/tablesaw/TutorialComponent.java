package eu.mihosoft.tablesaw;

import eu.mihosoft.vrl.annotation.ComponentInfo;
import tech.tablesaw.api.Row;
import tech.tablesaw.api.Table;
import tech.tablesaw.columns.Column;
import tech.tablesaw.io.csv.CsvReader;

import java.io.Serializable;

/**
 * A tutorial component.
 *
 * @author Michael Hoffer <info@michaelhoffer.de>
 */
@ComponentInfo(name="TutorialComponent", category="Tablesaw/")
public class TutorialComponent implements Serializable {

    // necessary for session serialization
    private static final long serialVersionUID = 1L;

    // -- custom code --
    public String doSomething() {
        return "Plugin works!";
    }


}