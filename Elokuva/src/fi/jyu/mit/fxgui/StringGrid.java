package fi.jyu.mit.fxgui;

import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;
import java.util.ArrayList;
import java.util.List;

/**
 * StringGrid replacement for fxgui compatibility
 * Provides the same interface as the original StringGrid
 */
public class StringGrid<T> extends TableView<T> {
    
    private List<TableColumn<T, String>> columns = new ArrayList<>();
    private ObservableList<T> data = FXCollections.observableArrayList();
    
    public StringGrid() {
        super();
        setItems(data);
    }
    
    /**
     * Initialize table with column headings
     */
    public void initTable(String[] headings) {
        getColumns().clear();
        columns.clear();
        
        for (String heading : headings) {
            TableColumn<T, String> column = new TableColumn<>(heading);
            column.setCellValueFactory(new PropertyValueFactory<>("value" + columns.size()));
            columns.add(column);
            getColumns().add(column);
        }
    }
    
    /**
     * Add a row with string values
     */
    public void add(String... values) {
        if (values.length != columns.size()) {
            throw new IllegalArgumentException("Number of values must match number of columns");
        }
        
        // Create a simple data object to hold the values
        GridRow row = new GridRow(values);
        data.add((T) row);
    }
    
    /**
     * Clear all data
     */
    public void clear() {
        data.clear();
    }
    
    /**
     * Get selected row number
     */
    public int getRowNr() {
        return getSelectionModel().getSelectedIndex();
    }
    
    /**
     * Simple data class to hold grid row values
     */
    public static class GridRow {
        private String[] values;
        
        public GridRow(String[] values) {
            this.values = values;
        }
        
        // Property methods for TableColumn binding
        public String getValue0() { return values.length > 0 ? values[0] : ""; }
        public String getValue1() { return values.length > 1 ? values[1] : ""; }
        public String getValue2() { return values.length > 2 ? values[2] : ""; }
        public String getValue3() { return values.length > 3 ? values[3] : ""; }
        public String getValue4() { return values.length > 4 ? values[4] : ""; }
        public String getValue5() { return values.length > 5 ? values[5] : ""; }
    }
}
