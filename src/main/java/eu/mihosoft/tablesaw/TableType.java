package eu.mihosoft.tablesaw;

import eu.mihosoft.vrl.annotation.TypeInfo;
import eu.mihosoft.vrl.reflection.TypeTemplate;
import tech.tablesaw.api.Table;


@TypeInfo(type=Table.class, input = true, output = true, style="default")
public class TableType extends TypeTemplate {

    private static final long serialVersionUID = 1L;

    /**
     * Constructor.
     */
    public TableType() {
        setValueName("Table:");
    }

    @Override
    public boolean noSerialization() {
        return true;
    }
}