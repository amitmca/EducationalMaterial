import java.util.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;

public class TableTest extends JFrame
  {
    public TableTest()
      {
         super("Test");
         this.getContentPane().setLayout(new BorderLayout());

         Vector col1 = new Vector();
         col1.add("red");
         col1.add("white");
         col1.add("blue");

         Object[][] data = { { "terry", "red" }, { "sara", "white" } };


         MyDataModel myData = new MyDataModel(data, new Object[] { "Name",
"Colour" } );
         JTable t = new JTable(myData);
         JScrollPane sp = new JScrollPane(t);

         TableColumnModel model = t.getColumnModel();
         TableColumn col = model.getColumn(1);
         col.setCellEditor(new DefaultCellEditor(new JComboBox(col1)));

         this.getContentPane().add(sp, BorderLayout.CENTER);
      }

    public class MyDataModel extends DefaultTableModel
      {
         public MyDataModel(Object[][] obj, Object[] names)
           {
             super(obj, names);

                // this should have your proprly implement TableModel here
           }
      }

    public static void main(String args[])
      {
         TableTest test = new TableTest();
         test.setSize(400,400);
         test.setVisible(true);
      }
  }
