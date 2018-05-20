import  java.awt.*;
import  javax.swing.*;
import  java.awt.event.*;
import  java.io.FileWriter;
import  java.util.Random;

public class gui implements ActionListener
{
      JFrame f;
      JTextArea t;
      JMenuBar mb;
      JMenu file,oper;
      JMenuItem load,save,exit,sort;

      int a[]=new int[5];
      
      public gui()
      {
             f=new JFrame("my app");
             f.setVisible(true);
             f.setSize(500, 500);
             f.setLayout(new FlowLayout());
             t=new JTextArea(20, 50);
             mb=new JMenuBar();
             file=new JMenu("File");
             
             mb.add(file);
             load=new JMenuItem("Load");
             save=new JMenuItem("Save");
             exit=new JMenuItem("Exit");

	file.add(load);
	file.add(save);
	file.add(exit);
	
	load.addActionListener(this);
	save.addActionListener(this);
	exit.addActionListener(this);
	

	oper=new JMenu("Operations");
	mb.add(oper);
	sort=new JMenuItem("SORT");
	oper.add(sort);
	sort.addActionListener(this);
	f.setJMenuBar(mb);
	      f.add(t);
	      f.pack();
	}
	public static void main(String[] args)
	{
		      new gui();
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
	                  a[i]=r.nextInt(10);
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
  		if(ae.getSource()==sort)
  		{
        	for(int i=0;i<a.length-1;i++)
        	{
        	      for(int j=i+1;j<a.length;j++)
        	      {
        	            if(a[i]>a[j])
        	            {
        	                  int temp=a[i];
        	                  a[i]=a[j];
        	                  a[j]=temp;
        	            }
        	      }
        	}
        	loadArray();
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

