       
import java.awt.*;   
import javax.swing.*;   
import javax.swing.table.*;   
class Testing extends JFrame   
{   
  public Testing()   
  {   
    setLocation(200,100);   
    setSize(400,150);   
    setDefaultCloseOperation(EXIT_ON_CLOSE);   
    String[] colNames = {"Column 1", "Col2", "Column 3","Column 4", "Column 5", "Column 6"};   
    String[][] data = {{"Str","Str","long String","long String","long String","long String"},   
                       {"Str","Str","longggggggggggg String","long String","long String","long String"}};   
    DefaultTableModel dtm = new DefaultTableModel(data,colNames);   
    JTable table = new JTable(dtm);   
    JScrollPane sp = new JScrollPane(table);   
    table.setDefaultRenderer(Object.class, new WidthRenderer());   
    getContentPane().add(sp);   
    table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);   
    setVisible(true);   
  }   
  class WidthRenderer extends DefaultTableCellRenderer   
  {   
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)   
    {   
      Component comp = super.getTableCellRendererComponent(table,value,isSelected,hasFocus,row,column);   
      int width = comp.getPreferredSize().width+4;//4=inset?   
      int tcWidth = table.getColumnModel().getColumn(column).getWidth();   
      if(width > tcWidth) table.getColumnModel().getColumn(column).setPreferredWidth(width);   
      return comp;   
    }   
  }   
  public static void main (String[] args){new Testing();}   
}  