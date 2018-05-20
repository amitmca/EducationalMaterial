import java.awt.*;
import java.applet.*;
import java.applet.Applet.*;
/*
<applet code="frame" width=250 height=250>
</applet>
*/
class labelframe extends Frame
	{
	Label l;
	labelframe(String t)
		{
		super(t);
		setLayout(new FlowLayout());
		l=new Label("Hello from Java!");
		add(l);
		}
	}
public class frame extends Applet implements ActionListener
	{
	Button b1,b2;
	labelframe window;
	public void init()
		{
		b1=new Button("Connect.....");
		add(b1);
		b1.addActionListener(this);
		b2=new Button("Hide.....");
		add(b2);
		b2.addActionListener(this);
		window=new labelframe("Java Window");
		window.setSize(300,200);
		}
	public void actioPerformed(ActionEvent e)
		{
		if(e.getSource()==b1)
			{
			window.setVisible(true);
			}
		if(e.getSource()==b2)
			{
			window.setVisible(false);
			}
		}	
	}
