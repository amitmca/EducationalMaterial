import java.awt.*; 
import java.awt.event.*; 
import javax.swing.*; 
import javax.swing.table.*; 
import javax.swing.event.*; 

public class TestCheckBox extends JFrame 
{ Container cp = getContentPane(); 
JTable table = null; 
Object columnNames[] = {"Col1", "Col2", "Col3", "Col4"}; 
Object cell[][] = null; 
TestCheckBox() 
{ 
table = new JTable(); 
cell = new CheckboxRenderer[1][4]; 
for (int row=0; row < 1; ++row) 
{ 
for (int col=0; col < 4; ++col) 
{ 
cell[row][col] = new CheckboxRenderer(table, row, col); 
table.setDefaultRenderer(((JCheckBox)cell[row][col].getCheckBox()).getClass(),cell[row][col]); 
} 
} 
cp.setLayout(new BorderLayout()); 
cp.add( table = new JTable(cell, columnNames), BorderLayout.CENTER); 
pack(); 
setVisible(true); 
} 

public static void main(String args[]) { new Test(); } 
} 

class CheckboxRenderer extends JPanel implements TableCellRenderer 
{ 
public JCheckBox cb = new JCheckBox("",false); 
protected JTable table = null; 
protected int row = 0; 
protected int col = 0; 
public JCheckBox getCheckbox() { return cb; } 
CheckboxRenderer(JTable table, int row, int col) 
{ 
this.table = table; 
this.row = row; 
this.col = col; 
setLayout(new FlowLayout()); 
add(cb); 
} 
public Component getTableCellRendererComponent(JTable table, 
Object value, boolean isSelected, boolean hasFocus, 
int row, int column) 
{ 
return this; 
} 

} 
