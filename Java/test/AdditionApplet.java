import java.awt.*;
import javax.swing.*;
import java.applet.*;

/*
<applet code="AdditionApplet.class" width="300" height="65">
</applet>
*/


public class AdditionApplet extends JApplet
{
	double sum;

	public void init()
	{
		String firstNumber;
		String secondNumber;
		double number1;
		double number2;

		firstNumber=JOptionPane.showInputDialog("Enter the first floating point value");
		secondNumber=JOptionPane.showInputDialog("Enter the second floating point value");
		
		number1=Double.parseDouble(firstNumber);
		number2=Double.parseDouble(secondNumber);

		sum=number1+number2;
	}
		public void paint(Graphics g)
		{
			g.drawRect(15,10,270,20);
			g.drawString("The sum is "+ sum,25,25);
		}
	}
