import java.awt.*;
import java.awt.event.*;

class Colors extends Frame implements ItemListener, ActionListener{
 Label lblTxt = new Label("Choose a color:");
 Label lblInform = new Label();
 CheckboxGroup cbg = new CheckboxGroup();
 Checkbox cbRed = new Checkbox("Red", cbg, false);
 Checkbox cbGreen = new Checkbox("Green", cbg, false);
 Checkbox cbBlue = new Checkbox("Blue", cbg, false);
 Button btnExit = new Button("Exit");
 Panel pn = new Panel();
 Colors(String title){
  super(title);
  add(pn);
  pn.setLayout(new GridLayout(5, 1));
  pn.add(lblTxt);
  pn.add(cbRed);
  pn.add(cbGreen);
  pn.add(cbBlue);
  pn.add(lblInform);
  add(btnExit, BorderLayout.PAGE_END);
  btnExit.addActionListener(this);
  cbRed.addItemListener(this);
  cbGreen.addItemListener(this);
  cbBlue.addItemListener(this);  
 } 
 public void actionPerformed(ActionEvent ae){
  System.exit(0);
 }
 public void itemStateChanged(ItemEvent e){
   	
   if(cbRed.getState() == true){     
     lblInform.setText("You've chosen red color!");
     this.setBackground(Color.red);      
   }
   if(cbGreen.getState() == true){ 
     lblInform.setText("You've chosen green color!");
     this.setBackground(Color.green);
   } 
   if(cbBlue.getState() == true){
     lblInform.setText("You've chosen blue color!");
     this.setBackground(Color.green);
   } 
 }    
}


class ChooseColors{
 public static void main(String args[]){
   Colors objColor = new Colors("List of colors");
   objColor.setBackground(Color.yellow);
   objColor.setSize(300, 500);
   objColor.show();
 }

}import <strong class="highlight">java</strong>.awt.*;
import <strong class="highlight">java</strong>.awt.event.*;

class Colors extends Frame implements ItemListener, ActionListener{
 Label lblTxt = new Label("Choose a color:");
 Label lblInform = new Label();
 CheckboxGroup cbg = new CheckboxGroup();
 Checkbox cbRed = new Checkbox("Red", cbg, false);
 Checkbox cbGreen = new Checkbox("Green", cbg, false);
 Checkbox cbBlue = new Checkbox("Blue", cbg, false);
 Button btnExit = new Button("Exit");
 Panel pn = new Panel();
 Colors(String title){
  super(title);
  add(pn);
  pn.setLayout(new GridLayout(5, 1));
  pn.add(lblTxt);
  pn.add(cbRed);
  pn.add(cbGreen);
  pn.add(cbBlue);
  pn.add(lblInform);
  add(btnExit, BorderLayout.PAGE_END);
  btnExit.addActionListener(this);
  cbRed.addItemListener(this);
  cbGreen.addItemListener(this);
  cbBlue.addItemListener(this);  
 } 
 public void actionPerformed(ActionEvent ae){
  System.exit(0);
 }
 public void itemStateChanged(ItemEvent e){
   	
   if(cbRed.getState() == true){     
     lblInform.setText("You've chosen red color!");
     this.setBackground(Color.red);      
   }
   if(cbGreen.getState() == true){ 
     lblInform.setText("You've chosen green color!");
     this.setBackground(Color.green);
   } 
   if(cbBlue.getState() == true){
     lblInform.setText("You've chosen blue color!");
     this.setBackground(Color.green);
   } 
 }    
}


class ChooseColors{
 public static void main(String args[]){
   Colors objColor = new Colors("List of colors");
   objColor.setBackground(Color.yellow);
   objColor.setSize(300, 500);
   objColor.show();
 }

}
