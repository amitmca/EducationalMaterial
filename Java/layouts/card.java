import java.awt.*;
import java.awt.event.*;
import java.applet.*;

/*
<applet code="card" width="250" height="250">
</applet>
*/

public class card extends Applet implements ActionListener
	{	
	private CardLayout cm;
	private Panel deck;
	private Button bg1[]=new Button[3];
	private Button bg2[]=new Button[2];

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

		Label l2=new Label("Name");
		TextField t1=new TextField(10);
		Panel card2=new Panel();
		card2.add(l2);
		card2.add(t1);
		deck.add(card2,l2.getText());	

		Panel card3=new Panel();
		TextArea ta=new TextArea("",10,30);
		card3.add(ta);
		deck.add(card3,"");	

		Panel panel1=new Panel();
		Panel panel2=new Panel();
		Panel panel3=new Panel();

		panel1.setLayout(new GridLayout(1,2));
		panel2.setLayout(new GridLayout(1,2));
		

		bg1[0]=new Button("First Card");
		bg1[0].addActionListener(this);
		panel1.add(bg1[0]);


		bg1[1]=new Button("Second Card");
		bg1[1].addActionListener(this);
		panel1.add(bg1[1]);

		bg1[2]=new Button("Third Card");
		bg1[2].addActionListener(this);
		panel1.add(bg1[2]);


		bg2[0]=new Button("Next Card");
		bg2[0].addActionListener(this);
		panel2.add(bg2[0]);


		bg2[1]=new Button("Previous Card");
		bg2[1].addActionListener(this);
		panel2.add(bg2[1]);


		add(panel1,BorderLayout.NORTH);
		add(panel2,BorderLayout.SOUTH);
		add(panel3,BorderLayout.WEST);
		add(deck,BorderLayout.CENTER);	
		}
	public void actionPerformed(ActionEvent ae)
		{
		if(ae.getSource()==bg1[0])
			cm.first(deck);
		else if(ae.getSource()==bg1[1])
			cm.last(deck);
		else if(ae.getSource()==bg2[0])
			cm.next(deck);
		else if(ae.getSource()==bg2[1])
			cm.previous(deck);
		
		}

	}