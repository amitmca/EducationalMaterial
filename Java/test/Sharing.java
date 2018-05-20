
 

import javax.swing.table.*;
import javax.swing.*;
import java.awt.*;
import java.util.*;

public class Sharing extends JDialog {
JScrollPane scroll1;
JScrollPane scroll2;
JTable userTable;
JTable accessTable;
JButton add;
JButton remove;
JButton ok;
JButton cancel;
JPanel pan1;
JPanel pan2;
JPanel pan3;
JPanel pan4;
Vector row1,row2,row3;
Container container;
JCheckBox fCheck;
JCheckBox rCheck;
JCheckBox wCheck;
Vector userRow,userCol,accessRow,accessCol;

public Sharing(Vector v, Vector r) {

userCol = v;
userRow = r;
fCheck = new JCheckBox();
rCheck = new JCheckBox();
wCheck = new JCheckBox();
accessRow = new Vector();
accessCol = new Vector();
accessCol.add("Rights");
accessCol.add("Allow/Deny"); 

row1 = new Vector();
row2 = new Vector();
row3 = new Vector();

row1.add("Full Control");
row1.add(Boolean.TRUE);
row2.add("Read");
row2.add("");
row3.add("Write");
row3.add("");


accessRow.add(row1);
accessRow.add(row2);
accessRow.add(row3);

userTable = new JTable(userRow,userCol);
accessTable = new JTable(accessRow,accessCol);
userTable.setShowGrid(false);
accessTable.setShowGrid(false);
//accessTable.setDefaultRenderer(Boolean.class,new MyCheckboxRenderer());
add = new JButton("Add");
remove = new JButton("Remove");
ok = new JButton("Ok");
cancel = new JButton("Cancel");

pan1 = new JPanel();
pan2 = new JPanel();
pan3 = new JPanel();
pan4 = new JPanel();
container = getContentPane();
container.setLayout(new GridLayout(4,1,0,0));

scroll1 = new JScrollPane(userTable, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
scroll2 = new JScrollPane(accessTable, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
scroll1.setPreferredSize(new Dimension(350, 100));
scroll2.setPreferredSize(new Dimension(350, 100));
pan1.add(scroll1);
pan2.add(add);
pan2.add(remove);
pan3.add(scroll2);
pan4.add(ok);
pan4.add(cancel);
setSize(400,480);
container.add(pan1);
container.add(pan2);
container.add(pan3);
container.add(pan4);
setVisible(true);

}

public static void main(String [] args) {
Vector v1 = new Vector();
Vector v2 = new Vector();
Vector v3 =new Vector();
Vector vCol = new Vector();
Vector vRow = new Vector();
v1.add("User1");
v2.add("User2");
v3.add("User3");
vCol.add("User Names");
vRow.add(v1);
vRow.add(v2);
vRow.add(v3);

Sharing share = new Sharing(vCol,vRow);

}

// public class MyCheckboxRenderer extends JCheckBox implements TableCellRenderer {
// public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
// }
// }

}

        
