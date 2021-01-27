package eu.mihosoft.tablesaw;

import com.google.common.base.Joiner;
import org.junit.Test;
import tech.tablesaw.api.ColumnType;
import tech.tablesaw.api.Table;
import tech.tablesaw.io.csv.CsvReadOptions;

import java.io.IOException;
import java.util.Arrays;

/**
 * Demonstrates that joining is broken for tables containing ColumnType.TEXT .
 */
public class JoinerTest {
    @Test
    public void joinTablesWithTextColumnsFailure() throws IOException {
        Table t1 = Table.read().usingOptions(CsvReadOptions.builderFromString(
                Joiner.on(System.lineSeparator())
                        .join(
                                "TIME,TEMP SENSOR 1",
                                "13:21:50.430,23.7",
                                "13:21:51,23.1",
                                "13:21:52.451,24.2"))

                .columnTypesToDetect(Arrays.asList(ColumnType.DOUBLE, ColumnType.TEXT))
        );

        Table t2 = Table.read().usingOptions(CsvReadOptions.builderFromString(
                Joiner.on(System.lineSeparator())
                        .join(
                                "TIME,TEMP SENSOR 2",
                                "13:21:50.430,24.9",
                                "13:21:51,25.2",
                                "13:21:52.451,26.1"))

                .columnTypesToDetect(Arrays.asList(ColumnType.DOUBLE, ColumnType.TEXT))
        );

        // fails with class-cast-exception: class tech.tablesaw.api.TextColumn cannot be cast to class tech.tablesaw.api.StringColumn
        String result = t1.joinOn("TIME").fullOuter(t2).printAll();
        System.out.println("RESULT:\n" + result);
    }

    @Test
    public void joinTablesWithTextColumnsSuccess() throws IOException {
        Table t1 = Table.read().usingOptions(CsvReadOptions.builderFromString(
                Joiner.on(System.lineSeparator())
                        .join(
                                "TIME,TEMP SENSOR 1",
                                "13:21:50.430,23.7",
                                "13:21:51,23.1",
                                "13:21:52.451,24.2"))

                .columnTypesToDetect(Arrays.asList(ColumnType.DOUBLE, ColumnType.STRING))
        );

        Table t2 = Table.read().usingOptions(CsvReadOptions.builderFromString(
                Joiner.on(System.lineSeparator())
                        .join(
                                "TIME,TEMP SENSOR 2",
                                "13:21:50.430,24.9",
                                "13:21:51,25.2",
                                "13:21:52.451,26.1"))

                .columnTypesToDetect(Arrays.asList(ColumnType.DOUBLE, ColumnType.STRING))
        );

        String result = t1.joinOn("TIME").fullOuter(t2).printAll();
        System.out.println("RESULT:\n" + result);
    }
}
