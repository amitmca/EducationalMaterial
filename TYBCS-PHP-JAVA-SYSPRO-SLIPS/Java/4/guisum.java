import  java.awt.*;
import  javax.swing.*;
import  java.awt.event.*;
import  java.io.FileWriter;
import  java.util.Random;

public class guisum implements ActionListener
{
      JFrame f;
      JTextArea t;
      JMenuBar mb;
      JMenu mfile,mcomp,mop;
      JMenuItem load,save,exit,sum,avg;
      int a[]=new int[5];
      public guisum()
      {
             f=new JFrame("my app");
             f.setVisible(true);
             f.setSize(500, 500);
             f.setLayout(new FlowLayout());
             t=new JTextArea(20, 50);
             mb=new JMenuBar();
             
             mfile=new JMenu("Operation");
             mb.add(mfile);
             
             load=new JMenuItem("Load");
             save=new JMenuItem("Save");
             exit=new JMenuItem("Exit");
             
mfile.add(load);
mfile.add(save);
mfile.add(exit);
load.addActionListener(this);
save.addActionListener(this);
exit.addActionListener(this);

mcomp=new JMenu("Compute");
mb.add(mcomp);

sum=new JMenuItem("SUM");
mcomp.add(sum);
sum.addActionListener(this);

avg=new JMenuItem("AVERAGE");
mcomp.add(avg);
avg.addActionListener(this);

f.setJMenuBar(mb);
      f.add(t);
      f.pack();
}
public static void main(String[] args)
{
      new guisum();
}
public void loadArray()
{
      t.setText("");
      for(int i=0;i<a.length;i++)
      {
      t.setText(t.getText()+" , "+a[i]);
      }
}
public void actionPerformed(ActionEvent ae)
{
      if(ae.getSource()==load)
      {
            for(int i=0;i<5;i++)
            {
                  Random r=new Random();
                  a[i]=r.nextInt(5);
                  loadArray();
            }
      }
      if(ae.getSource()==save)
      {
                  try{
                  FileWriter fw=new FileWriter("num.txt");
                  fw.write(t.getText());
                  fw.close();
                  }
                  catch(Exception e)
                  {
            }
}
if(ae.getSource()==sum)
{
      int sum=0;
      for(int i=0;i<a.length;i++)
      {
            sum=sum+a[i];
      }
      JOptionPane.showMessageDialog(f,"SUM ="+sum);
}
if(ae.getSource()==avg)
{
      int sum=0;
      for(int i=0;i<a.length;i++)
      {
            sum=sum+a[i];
      }
      JOptionPane.showMessageDialog(f,"AVERAGE ="+(sum/a.length));
}
  if(ae.getSource()==save)
  {
        System.exit(0);
  }
  if(ae.getSource()==exit)
  {
        System.exit(0);
  }
}
}

