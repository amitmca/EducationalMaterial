import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;

// This program allows a list of Products to be maintained i.e.
// added, deleted and sorted. The products are displayed in
// a JTable and also maintained in an ArrayList.

// Some criticisms of the code:

// 1. Quite a lot of the code seems concerned with keeping the
// JTable and the ArrayList contents in step. Perhaps there
// is a better way to do this by writing my own
// TableModel.

// 2. No data validation is implmented

// 3. The design does not conform to the MVC pattern

// 4. Only one sort order (by product name) is possible.
// To make it possible to sort into other orders e.g.
// by price it would be necessary to use a Comparator object.

// 5. The ArrayList used does not use generics

class StockEnquiries implements Comparable {
private String name;
private int phone;
private String branch;

public StockEnquiries(String n, int p, String b) {
name = n;
phone = p; 
branch = b;
}
public StockEnquiries() {

}
public String getName() {
return name;
}
public int getPhone() {
return phone;
}
public String getBranch() {
return branch;
}
// compareTo() allows Product instances in a container
// (e.g. an ArrayList) to be sorted by Collections.sort().

// It can only sort things in one order (e.g. ascending order of
// name). Need to investigate the use of Comparator objects to
// allow different sort orders to be defined.

public int compareTo(Object o) {
StockEnquiries temp = (StockEnquiries) o;

// Strings already implement compareTo() so just use that
return (name.compareTo(temp.name));
}
}
public class GUI1 extends JFrame {

// A container for the Product instances
ArrayList enquiries = new ArrayList();

// GUI bits and bobs
JPanel panInput = new JPanel(new GridLayout(2,1)),
panAdd = new JPanel(),
panDelSort = new JPanel();

JTextField txtName = new JTextField(10),
txtPhone = new JTextField(5);
JTextField txtBranch = new JTextField(100);
JButton btnAdd = new JButton("Add"),
btnDelete = new JButton("Delete"),
btnSort = new JButton("Sort Products");

JTable tab = new JTable();

// The DefaultTableModel will allow the contents of the
// JTable to be manipulated.
DefaultTableModel tabMod = new DefaultTableModel();

StockEnquiries [] initialEnquiries = {new StockEnquiries(),
new StockEnquiries(),
new StockEnquiries()};

public GUI1() {
super("stock enquiries list");
tab.setModel(tabMod);
tabMod.addColumn("Name");
tabMod.addColumn("Phone");
tabMod.addColumn("Branch");
tabMod.addColumn("time");
tabMod.addColumn("enquiry");
tabMod.addColumn("dealt with");



btnAdd.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent ae) {
addStockEnquiries();
}
});

btnDelete.setToolTipText("Select the records to delete first");
btnDelete.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent ae) {
deleteStockEnquiries();
}
});
btnSort.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent ae) {
sortEnquiries();
}
});

panAdd.add(btnAdd);
panAdd.add(new JLabel("Product name:"));
panAdd.add(txtName);
panAdd.add(new JLabel("Phone Number:"));
panAdd.add(txtPhone);
panDelSort.add(btnDelete);
panDelSort.add(btnSort);
panInput.add(panAdd);
panInput.add(panDelSort);
getContentPane().add(panInput, BorderLayout.SOUTH);
getContentPane().add(new JScrollPane(tab));
loadInitialEnquiries();
}
// Delete a product from the ArrayList and from the JTable
public void deleteStockEnquiries() {
int [] rows = tab.getSelectedRows();
for (int i = 0; i < rows.length; i++) {
tabMod.removeRow(rows[i] - i); // delete from JTable
enquiries.remove(rows[i] - i); // delete from ArrayList
}
}

// Sort the products in the ArrayList and then
// reload them into the JTable in the sorted order

public void sortEnquiries() {
Collections.sort(enquiries); // sorts into name order
loadEnquiriesIntoTable();
}

// Add a new products to the ArrayList and the JTable
public void addStockEnquiries() {
String [] row = new String [4];
StockEnquiries newEnquiry = new StockEnquiries(txtName.getText(), Integer.parseInt(txtPhone.getText()), txtBranch.getText());

enquiries.add(newEnquiry); // add to the ArrayList
row[0] = newEnquiry.getName();
row[1] = Integer.toString(newEnquiry.getPhone());
row[2] = newEnquiry.getBranch();
tabMod.addRow(row); // add to the JTable
}
public void loadInitialEnquiries() {
BufferedReader br = null;
try {
br = new BufferedReader(
new FileReader("stockEnquiryLog.txt"));

String s;
String name = "";
String phone = "";
String branch = "";
String enquiry ="";
String time = "";
int colCount = tab.getColumnCount();
String[] row = new String[colCount];

while ((s = br.readLine()) != null) {
if(s.equals("<stock_enquiry>")) {

row[0] = br.readLine(); // name
row[1] = br.readLine(); // phone
row[2] = br.readLine(); // branch
row[3] = br.readLine(); // time
row[4] = br.readLine(); // enquiry

time = br.readLine();


tabMod.addRow(row);
}
// Premature closing of InputStream by
// this misplaced line:
// br.close();
}
// Close the Reader after we are done with it.
br.close();
} catch(IOException e) {
System.out.println("loadInitialEnquiries i/o error: " +
e.getMessage());
}
}





public void loadEnquiriesIntoTable() {
tabMod.setRowCount(0);

String [] row = new String [3];
for (Iterator i = enquiries.iterator(); i.hasNext() {
StockEnquiries temp = (StockEnquiries) i.next();
row[0] = temp.getName();
row[1] = Integer.toString(temp.getPhone());
row[2] = temp.getBranch();
tabMod.addRow(row);
}
}


public static void main(String [] a) throws FileNotFoundException, IOException{
GUI1 me = new GUI1();
me.addWindowListener(new WindowAdapter() {
public void windowClosing(WindowEvent e) {
System.exit(0) ;
} 
});
me.pack();
me.setVisible(true);
}
}
