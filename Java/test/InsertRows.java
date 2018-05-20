import javax.swing.*;
import javax.swing.table.*;
import java.awt.event.*;



public class InsertRows implements ActionListener
  {
  DefaultTableModel model;	
  JTable table;
  JButton b,b1;
  JFrame frame;
  JPanel panel;
 
  public static void main(String[] args) 
    {
    new InsertRows();
    }

  public InsertRows()
   {
   frame = new JFrame("Inserting rows in the table!");
   panel = new JPanel();
   b=new JButton("+");	
   b1=new JButton("-");	
   model = new DefaultTableModel();
   model.addColumn("Col1");
   model.addColumn("Col2");
  
   b.setBounds(10,20,60,25);	
   b.addActionListener(this);
   panel.add(b);	
	
   b1.setBounds(10,50,60,25);	
   b1.addActionListener(this);
   panel.add(b1);		
	
   frame.add(panel);
   table = new JTable(model);
   panel.add(table);
   frame.setSize(300,300);
   frame.setVisible(true);
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }

public void actionPerformed(ActionEvent ae)
  {
  if(ae.getSource()==b)
	{
	JButton u;
	model.insertRow(0, new Object[]{" "});
	}
  if(ae.getSource()==b1)
	{
	model.removeRow(table.getRowCount()-1);
	if(table.getRowCount()==0)
	   {
           JOptionPane.showMessageDialog(null,"Row Ended","Row Ended",JOptionPane.INFORMATION_MESSAGE);
           }	
    	}			
  }		
} 
    
