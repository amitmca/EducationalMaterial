import java.awt.*;
import java.applet.*;
import java.awt.event.*;

public class CheckApplet extends Applet implements ActionListener
	{
	public String msg="";
	public Label l=null;
	public Button b=null;
	public int c=0;
	public void init()
		{
		l=new Label("My Label");
		this.add(l);
		b=new Button("Change");
		this.add(b);
		b.addActionListener(this);
		}
	public void actionPerformed(ActionEvent ae)
		{
		if(ae.getSource()==b)
			{
			c++;
			l.setText("Clicked"+c);
			}
		}
	}