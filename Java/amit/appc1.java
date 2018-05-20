import java.awt.*;
import java.applet.*;
import java.sql.*;
/*
<applet code="appc1" width=250 height=350>
</applet>
*/
public class appc1 extends Applet
	{
	String user=" ";
	 Label l1;
	Button b1=new Button("CONNECT");
	TextField t=new TextField(20);
	TextField t1=new TextField(100);
	public void init()
		{
		l1=new Label("User Name:");
		l1.setBounds(60,50,100,25);
		t.setBounds(180,50,100,25);
		user=t.getText();
		t1.setBounds(180,100,100,25);
		b1.setBounds(30,150,100,25);
		b1.addActionListener(this);
		}
	
	public void actionPerformed(ActionEvent e)
		{
		if(e.getSource()==b1)
			{
			t1.setText(t.getText());
			}
		}
		
	}
