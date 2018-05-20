//******************************************************************
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;
import java.lang.*;
import javax.swing.JTable;

public class Sans_titre1  extends JPanel  implements TableModelListener {
 private final String[] columnNames = { "Rayon", "Produit", "Quantit?",
"Achet?"};
 private JButton buttonSave;
 private JTable table;
 private DefaultTableModel tableModel;

//******************************************************************
  public Sans_titre1() {
   tableModel = new DefaultTableModel(columnNames, 0);

    tableModel.addTableModelListener(this);

    Object[] data = { new String("Frais"), new String("Pommes"), new
Integer(5), new Boolean(true)};
    tableModel.addRow(data);

    table = new JTable(tableModel);

    javax.swing.table.TableColumn var_col;
    var_col = table.getColumnModel().getColumn(3);
    JCheckBox check = new JCheckBox();
    var_col.setCellEditor(new DefaultCellEditor(check));

    JScrollPane scrollPane = new JScrollPane(table);

    setLayout(new BorderLayout());
    setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
    add(BorderLayout.NORTH, new JLabel("Mon panier", JLabel.CENTER));
    add(BorderLayout.CENTER, scrollPane);
    JButton buttonAdd = new JButton("Ajouter");
    buttonAdd.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ev) {
        Object[] data = {
            new String("Test"), new String("Test"), new Integer(0),
            new Boolean(false)};
        tableModel.addRow(data);
      }
    });
    buttonSave = new JButton("Sauver");
    buttonSave.setEnabled(false);
    buttonSave.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ev) {
        buttonSave.setEnabled(false);
      }
    });
    JPanel buttonsPanel = new JPanel();
    buttonsPanel.add(buttonAdd);
    buttonsPanel.add(buttonSave);

    add(BorderLayout.SOUTH, buttonsPanel);
    setPreferredSize(new Dimension(200, 250));
  }

   public void tableChanged(TableModelEvent e) {
     if (e.getType() == TableModelEvent.UPDATE) {
       buttonSave.setEnabled(true);
     }
   }
//******************************************************************
  public static void main(String[] args) {
    JFrame frame = new JFrame("Mon Panier");

    frame.getContentPane().setLayout(new BorderLayout());

    frame.getContentPane().add("Center", new Sans_titre1());

    WindowListener wndCloser = new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    };

    frame.addWindowListener(wndCloser);

    frame.pack();

    frame.show();
  }
}
//******************************************************************

