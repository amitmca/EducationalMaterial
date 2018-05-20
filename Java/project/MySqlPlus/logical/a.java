import java.awt.*; 

import javax.swing.*; 
import javax.swing.event.TableModelEvent;
import javax.swing.table.*; 

import java.awt.GridBagConstraints;
import java.awt.event.*; 
import java.io.ObjectInputStream.GetField;
import java.util.Vector;
import javax.swing.JTable;
import java.lang.*;

public class a 
{ 
Object colNames[] = {"", "Editable", "Non Editable"}; 
Object[][] data = {}; 
DefaultTableModel dtm; 
JTable table; 
JButton save=new JButton();
final JCheckBox check = new JCheckBox();
Vector selectedRowValues= new Vector();
Vector totalRowValues= new Vector();
Object value;
boolean checked ;
String x;
boolean isSelected;
boolean isselectedheader;
JTableHeader header;
public void buildGUI() 
{ 
dtm = new DefaultTableModel(data,colNames); 
table = new JTable(dtm){
public boolean isCellEditable(int row, int col) { 
if (col == 2) { 
return false; 
} else { 
return true; 
} 
} 
};
//for(int x = 0; x < 2; x++) 
//{ 
dtm.addRow(new Object[]{new Boolean(false), new String(""), new String("doc")}); 
dtm.addRow(new Object[]{new Boolean(false), new String(""), new String("doc")});
//int str=dtm.findColumn( "Editable");
// System.out.println(str);


//} 


JFrame frame = new JFrame(); 
frame.pack(); 
frame.setSize(800, 600);
frame.setLocationRelativeTo(null); 
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 


JPanel panel=new JPanel();
GridBagLayout gbPanel = new GridBagLayout();
GridBagConstraints gbcPanel = new GridBagConstraints();
panel.setLayout( gbPanel );

JPanel pane2=new JPanel();
GridBagLayout gbPane2 = new GridBagLayout();
GridBagConstraints gbcPane2 = new GridBagConstraints();
pane2.setLayout( gbPane2 );

JScrollPane sp = new JScrollPane(table);

JPanel pane3=new JPanel();
GridBagLayout gbPane3 = new GridBagLayout();
GridBagConstraints gbcPane3 = new GridBagConstraints();
pane3.setLayout( gbPane3 );

gbcPane3.anchor = GridBagConstraints.CENTER; 
gbcPane3.gridx = 0;
gbcPane3.gridy = 0;

setRowMinHeight(gbPane3, 1, 20);

gbcPane3.gridx = 0;
gbcPane3.gridy = 2;
pane3.add(sp);


gbcPane2.anchor = GridBagConstraints.CENTER; 
gbcPane2.gridx = 0;
gbcPane2.gridy = 0;

setRowMinHeight(gbPane2, 1, 20);

save.setText("Save");
gbcPane2.gridx = 0;
gbcPane2.gridy = 2;
//save.setEnabled(false);
save.addActionListener(new actionsave());
gbPane2.setConstraints(save, gbcPane2 );
pane2.add(save);

TableColumn tc = table.getColumnModel().getColumn(0); 
tc.setResizable(true);
tc.setHeaderRenderer(new CheckBoxHeader(new MyItemListener()));

tc.setCellEditor(new DefaultCellEditor(check));
tc.setCellRenderer(table.getDefaultRenderer(Boolean.class)); 

/* tc.setCellRenderer(new DefaultTableCellRenderer()
{
public Component getTableCellRendererComponent(JTable table,
Object value, boolean isSelected, boolean hasFocus, int row, int
column) 
{
check.setSelected(((Boolean)value).booleanValue()) ;
return check;
}
});*/

check.addActionListener(new actcheck());


gbcPanel.anchor = GridBagConstraints.CENTER; 
gbcPanel.gridx = 0;
gbcPanel.gridy = 0;
setRowMinHeight(gbPanel, 1, 20); 
gbcPanel.anchor = GridBagConstraints.CENTER; 
gbcPanel.gridx = 0;
gbcPanel.gridy = 2;
gbPanel.setConstraints(pane3, gbcPanel );
panel.add(pane3);

setRowMinHeight(gbPanel, 3, 20); 

setRowMinHeight(gbPanel, 4, 10);

gbcPanel.anchor = GridBagConstraints.CENTER; 
gbcPanel.gridx = 0;
gbcPanel.gridy = 5;
gbPanel.setConstraints(pane2, gbcPanel );
panel.add(pane2);

frame.getContentPane().add(panel); 
frame.setEnabled(true);
frame.setVisible(true);


} 
public boolean isCellEditable(int row, int col) { 
if (col == 2) { 
return true; 
} else { 
return false; 
} 
} 

public void tableChanged(TableModelEvent e2)
{
if (e2.getType() == TableModelEvent.UPDATE)
{
save.setEnabled(true);
}
}
class actionsave implements ActionListener 
{
public void actionPerformed(ActionEvent e1) 
{ 
if(e1.getSource() == save)
{
if(isSelected==true)
{
if(isselectedheader==false)
{
//System.out.println("check true,header false");
System.out.println(isSelected);
}
for(int i=0; i<selectedRowValues.size(); i++)
{
System.out.println(selectedRowValues.get(i));
}
}
else
{
System.out.println(isSelected);

}
if(isselectedheader==true)
{
System.out.println(isselectedheader);
System.out.println("header true");
for(int i=0; i<totalRowValues.size() ; i++)
{
System.out.println(totalRowValues.get(i));
}
}
else
{
System.out.println(isselectedheader);

}

if(isSelected==false)
{
isselectedheader = header.isShowing();
System.out.println(isselectedheader);
//System.out.println("h=t,c=f");
}

/*if(isselectedheader==false)
{
if(isSelected==false)
{
System.out.println(isselectedheader);
}
}*/
selectedRowValues.removeAllElements();
totalRowValues.removeAllElements();
//save.setEnabled(false);
}
}
}


class actcheck implements ActionListener 
{
public void actionPerformed(ActionEvent ee) 
{
totalRowValues.removeAllElements();
selectedRowValues.removeAllElements();
isSelected=check.isSelected();
if(check.isSelected()== true)
{
int selectedRow=table.getSelectedRow();
int selectedColumn=table.getSelectedColumn();

for(int col=1; col<=2; col++)
{
value=table.getValueAt(selectedRow, col); 
selectedRowValues.addElement(value);
}

}
}
}

class MyItemListener implements ItemListener 
{ 
public void itemStateChanged(ItemEvent e)
{ 
selectedRowValues.removeAllElements();
totalRowValues.removeAllElements();
Object source = e.getSource(); 
if (source instanceof AbstractButton == false) return; 
boolean checked = e.getStateChange() == ItemEvent.SELECTED; 
header = table.getTableHeader(); 
//isselectedheader=header.isShowing();
isselectedheader= e.getStateChange() == ItemEvent.SELECTED;

for(int x = 0, y = table.getRowCount(); x < y; x++) 
{ 
table.setValueAt(new Boolean(checked),x,0); 
checked = e.getStateChange() == ItemEvent.SELECTED; 
// System.out.println(y);

} 


for (int row=0; row<2; row++)
{
checked = e.getStateChange() == ItemEvent.SELECTED; 
if(checked == true){
for (int col=1 ; col<colNames.length ; col++){

x= (String) dtm.getValueAt(row, col);
totalRowValues.addElement(x);
}
}
}

} 
} 
public static void setRowMinHeight(GridBagLayout gb, int r, int h) 
{
int[] hs = gb.rowHeights;
if (hs == null) 
{
hs = new int[r+1];
} 
else if (hs.length < r+1)
{
hs = new int[r+1];
System.arraycopy(gb.rowHeights, 0, hs, 0, gb.rowHeights.length);
}
hs[r] = h;
gb.rowHeights = hs;

}
private static void setColumnMinWidth(GridBagLayout gb, int c, int w)
{

int[] ws = gb.columnWidths;
if (ws == null)
{
ws = new int[c+1];
} 
else if (ws.length < c+1)
{
ws = new int[c+1];
System.arraycopy(gb.columnWidths, 0, ws, 0, gb.columnWidths.length);
}
ws[c] = w;
gb.columnWidths = ws;
}
public static void main (String[] args) 
{ 
SwingUtilities.invokeLater(new Runnable()
{ 
public void run()
{ 
new a().buildGUI(); 
} 
}); 
} 
} 

class CheckBoxHeader extends JCheckBox 
implements TableCellRenderer, MouseListener 
{ 
protected CheckBoxHeader rendererComponent; 
protected int column; 
//JCheckBox jc1=new JCheckBox();
protected boolean mousePressed = false; 

public CheckBoxHeader(ItemListener itemListener) 
{ 
rendererComponent = this; 
rendererComponent.addItemListener(itemListener); 
} 
public Component getTableCellRendererComponent
( JTable table, Object value,boolean isSelected, boolean hasFocus, int row, int column)
{ 
if (table != null)
{ 
JTableHeader header = table.getTableHeader(); 
if (header != null) 
{ 

rendererComponent.setForeground(header.getForeground()); 
rendererComponent.setBackground(header.getBackground()); 
rendererComponent.setFont(header.getFont()); 
header.addMouseListener(rendererComponent); 
} 
} 
setColumn(column); 
rendererComponent.setText(""); 
setBorder(UIManager.getBorder("TableHeader.cellBorder")); 
return rendererComponent; 
} 
protected void setColumn(int column) 
{ 
this.column = column; 
} 
public int getColumn() 
{ 
return column; 

} 
protected void handleClickEvent(MouseEvent e)
{ 
if (mousePressed) 
{ 
mousePressed=false; 
JTableHeader header = (JTableHeader)(e.getSource()); 
JTable tableView = header.getTable(); 
TableColumnModel columnModel = tableView.getColumnModel(); 
int viewColumn = columnModel.getColumnIndexAtX(e.getX());
int column = tableView.convertColumnIndexToModel(viewColumn); 
if (viewColumn == this.column && e.getClickCount() == 1 && column != -1)
{ 
doClick(); 
} 
} 
} 
public void mouseClicked(MouseEvent e) 
{ 
handleClickEvent(e);
((JTableHeader)e.getSource()).repaint(); 

} 
public void mousePressed(MouseEvent e) { 
mousePressed = true; 
} 
public void mouseReleased(MouseEvent e) { 
} 
public void mouseEntered(MouseEvent e) { 
} 
public void mouseExited(MouseEvent e) { 
} 
}