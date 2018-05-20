package gpl.fredy.datadrill;


import javax.swing.JTable;
import javax.swing.table.*;
import java.util.Vector;
import java.util.logging.*;



public class BetweenPanelTableModel extends AbstractTableModel {

    // Titel
    public String[] columnNames = { "between", 
				    "and"
    };

    private Logger logger = Logger.getLogger("gpl.fredy.datadrill");
    private Vector data   = new Vector();

    public void clearData() {
        data.removeAllElements(); 
        fireTableDataChanged();
    }


    public void addRow(Vector v) {

        data.addElement(v);
        fireTableChanged(null);
    }

    public void removeRow(int row) {
        data.removeElementAt(row);
	fireTableChanged(null);	
    }

    public String getColumnName(int i) {

        return columnNames[i];
    }

    
    public int getColumnCount() { return columnNames.length; }

    public int getRowCount() { return data.size(); }

    public Object getValueAt(int row, int col) {
        Vector rowData = (Vector)data.elementAt(row);
        return rowData.elementAt(col);
    }

    public boolean isCellEditable(int row, int col) { 
        boolean b = true;
        return b;
    }

    public void setValueAt(Object value, int row, int col) {
        Vector rowData = (Vector)data.elementAt(row);
        rowData.setElementAt(value,col);
        data.setElementAt(rowData,row);
	fireTableCellUpdated(row, col);
    }    
}

