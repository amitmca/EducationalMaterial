import java.awt.*;
import java.applet.*;
import java.awt.event.*;

/*
<applet code="dialogdemo" width="250" height="250">
</applet>
*/

class SampleDialog extends Dialog implements ActionListener
        {
        SampleDialog(Frame parent,String title)
                {
                super(parent,title,false);
                setLayout(new FlowLayout());
                setSize(300,200);
                add(new Label("Press this button"));
                Button b;
                add(b=new Button("Cancel"));
                b.addActionListener(this);
                }
        public void actionPerformed(ActionEvent ae)
                {
                dispose();
                }                
        public void paint(Graphics g)
                {
                g.drawString("This is in the dialog box",10,70);
                }                                
        }
        
class MenuFrame extends Frame
        {
        String msg="";
        CheckboxMenuItem debug,test;
        
        MenuFrame(String title)
                {
                super(title);
                
                MenuBar mbar=new MenuBar();
                setMenuBar(mbar);
                
                Menu file=new Menu("File");
                MenuItem item1,item2,item3,item4,item5;
                file.add(item1=new MenuItem("New..."));
                file.add(item2=new MenuItem("Open..."));
                file.add(item3=new MenuItem("Save..."));
                file.add(item4=new MenuItem("Save As..."));
                file.add(item5=new MenuItem("Close..."));
                mbar.add(file);
                
                Menu edit=new Menu("Edit");
                MenuItem item6,item7,item8,item9;
                edit.add(item6=new MenuItem("Cut"));                
                edit.add(item7=new MenuItem("Copy"));
                edit.add(item8=new MenuItem("Paste"));
                edit.add(item9=new MenuItem("-"));
                Menu sub=new Menu("Special");
                MenuItem item10,item11,item12;
                sub.add(item10=new MenuItem("First"));
                sub.add(item11=new MenuItem("Second"));
                sub.add(item12=new MenuItem("Third"));                
                edit.add(sub);
                debug=new CheckboxMenuItem("Debug");
                edit.add(debug);
                test=new CheckboxMenuItem("Test");
                edit.add(test);
                mbar.add(edit);
                
                MyMenuHandler handler=new MyMenuHandler(this);
                
                item1.addActionListener(handler);
                item2.addActionListener(handler);
                item3.addActionListener(handler);
                item4.addActionListener(handler);
                item5.addActionListener(handler);
                item6.addActionListener(handler);
                               
                item7.addActionListener(handler);
                item8.addActionListener(handler);
                item9.addActionListener(handler);
                item10.addActionListener(handler);
                item11.addActionListener(handler);
                item12.addActionListener(handler);
                
                debug.addItemListener(handler);                                             
                test.addItemListener(handler);
                
                MyWindowAdapter adapter=new MyWindowAdapter(this);
                addWindowListener(adapter);
                }
        public void paint(Graphics g)
                {
                g.drawString(msg,10,200);
                if(debug.getState())
                        g.drawString("Debug is on",10,220);
                else
                        g.drawString("Debug is off",10,220);
                            
               if(test.getState())
                        g.drawString("Test is on",10,240);
                else
                        g.drawString("Test is off",10,240);                                                 
                }                
        }
        
class MyWindowAdapter extends WindowAdapter
        {
        MenuFrame menuframe;
        public MyWindowAdapter(MenuFrame myframe)
                {
                this.menuframe=menuframe;
                }
        public void windowClosing(WindowEvent e)
                {
                menuframe.dispose();
                }                
        }

class MyMenuHandler implements ActionListener,ItemListener
        {
        MenuFrame menuframe;
        public MyMenuHandler(MenuFrame menuframe)
                {
                this.menuframe=menuframe;
                }
        public void actionPerformed(ActionEvent ae)
                {                
                String msg="You Selected  ";
                String arg=(String)ae.getActionCommand();
                if(arg.equals("New..."))
                        {
                        msg=msg+"New.";
                        SampleDialog d=new SampleDialog(menuframe,"New Dialog Box");
                        d.setVisible(true);
                        }
                else if(arg.equals("Open..."))
                        msg=msg+"Open.";
                else if(arg.equals("Save..."))
                        msg=msg+"Save.";
                else if(arg.equals("Save As..."))
                        msg=msg+"Save As.";
                else if(arg.equals("Close..."))
                        msg=msg+"Close.";
                else if(arg.equals("Edit"))
                        msg=msg+"Edit.";
                else if(arg.equals("Cut"))
                        msg=msg+"Cut.";
                else if(arg.equals("Copy"))
                        msg=msg+"Copy";
                else if(arg.equals("Paste"))
                        msg=msg+"Paste";
                else if(arg.equals("First"))
                        msg=msg+"First.";
                else if(arg.equals("Second"))
                        msg=msg+"Second.";
                else if(arg.equals("Third"))
                        msg=msg+"Third.";
                else if(arg.equals("Debug"))
                        msg=msg+"Debug.";
                else if(arg.equals("Test"))
                        msg=msg+"Test.";         
                menuframe.msg=msg;
                menuframe.repaint();                                                                                                                                                                                                                                                                                                                       
                }        
        public void itemStateChanged(ItemEvent e)
                {
                menuframe.repaint();
                }                
        }                  
public class dialogdemo extends Applet
        {
        Frame f;
        public void init()
                {
                f=new MenuFrame("Menu Demo");
                int width=Integer.parseInt(getParameter("width"));
                int height=Integer.parseInt(getParameter("height"));
                
                setSize(new Dimension(width,height));
                f.setSize(width,height);
                f.setVisible(true);
                }
        public void start()
                {
                f.setVisible(true);
                }                
       public void stop()
                {
                f.setVisible(false);
                }                          
        }        