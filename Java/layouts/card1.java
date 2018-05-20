import java.awt.*;
import java.awt.event.*;
import java.applet.*;

/*
<applet code="card1" width="250" height="250">
</applet>
*/

public class card1 extends Applet implements ActionListener
	{	
	private CardLayout cm;
	private Panel deck;
	private Button bg1[]=new Button[3];
	

	public void init()
		{
		setLayout(new BorderLayout());
		deck=new Panel();
		cm=new CardLayout();
		deck.setLayout(cm);

		Label l1=new Label("Card One");
		Panel card1=new Panel();
		card1.add(l1);
		deck.add(card1,l1.getText());

		Label l2=new Label("Card Two");
		Panel card2=new Panel();
		card2.add(l2);
		deck.add(card1,l2.getText());

		Label l3=new Label("Card Three");
		Panel card3=new Panel();
		card3.add(l3);
		deck.add(card1,l3.getText());

		Panel panel1=new Panel();
		panel1.setLayout(new GridLayout(1,2));
	
		bg1[0]=new Button("First Card");
		bg1[0].addActionListener(this);
		panel1.add(bg1[0]);

		bg1[1]=new Button("Second Card");
		bg1[1].addActionListener(this);
		panel1.add(bg1[1]);

		bg1[2]=new Button("Third Card");
		bg1[2].addActionListener(this);
		panel1.add(bg1[2]);


		add(panel1,BorderLayout.NORTH);
		add(deck,BorderLayout.CENTER);	
		}
	public void actionPerformed(ActionEvent ae)
		{
		if(ae.getSource()==bg1[0])
			cm.first(deck);
		else if(ae.getSource()==bg1[1])
			cm.last(deck);
		else if(ae.getSource()==bg1[2])
			cm.next(deck);
				
		}

	}