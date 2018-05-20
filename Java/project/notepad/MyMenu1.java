import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.io.*;
import javax.swing.SwingUtilities;
import javax.swing.undo.*;
class MyMenu1 implements ActionListener
{
JFrame f;
JMenuBar menubar;
JMenu menu,submenu;
JMenuItem menuitem;
JRadioButtonMenuItem rbmt;
JCheckBoxMenuItem cbmt;
JTextArea ta;
DataInputStream dis;
JFileChooser fc,fc1;
String record=null;
JScrollPane sp;
protected UndoManager undo; 
MyMenu1()
{
f=new JFrame("my notepad");
f.setBounds(0,0,1200,1000);
menubar=new JMenuBar();
ta=new JTextArea();
ta.setEditable(true);
int v=JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED;
int h=JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED;
sp=new JScrollPane(ta,v,h);
sp.setVerticalScrollBarPolicy(v);
sp.setHorizontalScrollBarPolicy(h);
sp.setBounds(0,30,1130,750);
sp.setVisible(true);
f.add(sp);
undo=new UndoManager();

//file menu

menu=new JMenu("File");
menubar.add(menu);
menubar.setBounds(0,0,800,30);
f.add(menubar);
menu.setMnemonic(KeyEvent.VK_F);
menuitem=new JMenuItem("New",KeyEvent.VK_N);
menu.add(menuitem);
menuitem.addActionListener(this); 
menuitem=new JMenuItem("Open",KeyEvent.VK_O);
menu.add(menuitem);
menuitem.addActionListener(this);

menuitem=new JMenuItem("Save",KeyEvent.VK_S);
menu.add(menuitem);
menuitem.addActionListener(this);
//menuitem=new JMenuItem("SaveAs",KeyEvent.VK_A);
//menu.add(menuitem);
//menu.addSeparator();
//menuitem=new JMenuItem("PageSetup");
//menu.add(menuitem);
//menuitem=new JMenuItem("Print",KeyEvent.VK_P);
//menu.add(menuitem);
//menu.addSeparator();
menuitem=new JMenuItem("Exit",KeyEvent.VK_X);
menu.add(menuitem);
menuitem.addActionListener(this);
//edit menu

menu=new JMenu("Edit");
menubar.add(menu);
menu.setMnemonic(KeyEvent.VK_E);
menuitem=new JMenuItem("undo");
menuitem.setMnemonic(KeyEvent.VK_Z);
menuitem.addActionListener(this);
menu.add(menuitem);
menuitem=new JMenuItem("cut");
menuitem.setMnemonic(KeyEvent.VK_X);
menu.add(menuitem);
menuitem=new JMenuItem("copy");
menuitem.setMnemonic(KeyEvent.VK_C);
menu.add(menuitem);
menuitem=new JMenuItem("paste");
menuitem.setMnemonic(KeyEvent.VK_V);
menu.add(menuitem);
menuitem=new JMenuItem("delete");
menuitem.setMnemonic(KeyEvent.VK_D);
menu.add(menuitem);
menu.addSeparator();
menuitem=new JMenuItem("find");
menuitem.setMnemonic(KeyEvent.VK_F);
menu.add(menuitem);
menuitem=new JMenuItem("find next");
menuitem.setMnemonic(KeyEvent.VK_N);
menu.add(menuitem);
menuitem=new JMenuItem("replace");
menuitem.setMnemonic(KeyEvent.VK_R);
menu.add(menuitem);
menu.addSeparator();
menuitem=new JMenuItem("Select All");
menuitem.setMnemonic(KeyEvent.VK_A);
menu.add(menuitem);

//format menu

menu=new JMenu("Format");
menuitem.setMnemonic(KeyEvent.VK_F);
menubar.add(menu);
menuitem=new JMenuItem("Word Wrap");
menuitem.setMnemonic(KeyEvent.VK_W);
menu.add(menuitem);
menuitem=new JMenuItem("Font");
menuitem.setMnemonic(KeyEvent.VK_F);
menu.add(menuitem);

//view menu

menu=new JMenu("view");
menu.setMnemonic(KeyEvent.VK_V);
menubar.add(menu);
menuitem=new JMenuItem("Status Bar");
menuitem.setMnemonic(KeyEvent.VK_B);
menu.add(menuitem);

//help menu

menu=new JMenu("Help");
menu.setMnemonic(KeyEvent.VK_H);
menubar.add(menu);

f.setLayout(null);
f.setVisible(true); 
}
public void actionPerformed(ActionEvent ae)
{
String s=(String)ae.getActionCommand();
if(s.equals("New"))
ta.setText("");
else if(s.equals("Open"))
{
ta.setText("");
fc=new JFileChooser();
int returnval=fc.showOpenDialog(menuitem);
if(returnval==JFileChooser.APPROVE_OPTION)
{
try
{
File f1=fc.getSelectedFile();
FileInputStream fis = new FileInputStream(f1);
BufferedInputStream bis = new BufferedInputStream(fis); 
dis = new DataInputStream(bis);
while((record=dis.readLine())!=null)
{
ta.append(record+"\n");
}
}
catch(IOException e)
{
e.printStackTrace();
}
finally
{
if(dis !=null)
try
{
dis.close();
}
catch(IOException ioe)
{
ioe.printStackTrace();
}
} 
}
else
{
ta.append("Open command canceled by user"+"\n");
}
ta.setCaretPosition(ta.getDocument().getLength()); 
}
else if(s.equals("Save"))
{
try
{
fc1=new JFileChooser();
int returnval1=fc1.showSaveDialog(menuitem);
if(returnval1==JFileChooser.APPROVE_OPTION)
{
if(fc1.getSelectedFile() != null)
{
FileWriter fo = new FileWriter(fc1.getSelectedFile().getAbsolutePath()+".txt"); 
fo.write(this.ta.getText()); 
fo.close(); 
}
}
}
catch(Exception e2)
{
e2.printStackTrace();
}
}
else if(s.equals("Exit"))
{
System.exit(0); 
}
else if(s.equals("undo"))
{
try
{
undo.undo();
} 
catch (CannotUndoException ex)
{
System.out.println("Unable to undo: " + ex);
ex.printStackTrace();
}
//updateUndoState();
//redoAction.updateRedoState();

}
}
public static void main(String args[])
{
MyMenu1 m=new MyMenu1();

}
} 
