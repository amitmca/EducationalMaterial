package myprojects.addressbook;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
//import address.*;
public class Start {
public Start() throws Exception{

Button b1,b2;
JFrame jf;

jf=new JFrame("START");
jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
jf.setSize(800,800);
jf.setLayout(null);


Font f1 = new Font("sansserif",Font.BOLD,24);
Label l3 = new Label("SHEKHAR'S ADDRESS BOOK");
l3.setBounds(150,10,800,40);
l3.setFont(f1);
jf.add(l3);

b1 = new Button("ADD");
b1.setBounds(250,150,100,40);
b1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                try{
                Add a = new Add();
                }
                catch(Exception e2){}
                }
                });

b2 = new Button("SEARCH");
b2.setBounds(250,100,100,40);
b2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e1) {
                try{
                Search b = new Search();
            }
                catch(Exception e3){}
                }
                });

jf.add(b1);
jf.add(b2);
jf.show();
}
}
