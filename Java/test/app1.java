import java.awt.*;
import java.awt.Frame;
import java.awt.event.*;
import java.awt.Font;


class app1 extends Frame implements ActionListener
{
Button mob1,mob2;
TextField mot1,mot2,mot3,mot4,mot5,mot6;
TextArea moa1,moa2;
Label cl0,tl11,mol1,mol2,mol3,mol4,mol5,mol6,mol7,mol8,mol9,mol10;
TextField t1,t2,t3,t4,tt2,tt02,tt3,tt03,tt4,tt04,tt5,tt05,tt6,tt06,tt7,tt07,tt8,tt08,tt001,tt002,tt003,tt004;
TextField tt005,tt006,tt007,st0,st1,st2,st3,st4,st5,st6,st7,st8,st9,st10,st11,ct1,ct2,ct3,ct4,ct5,ct6,ct7,ct8,ct9;
Button cb1,cb2,cb3,cb4,cb5,cb6,b1,b2,b3,b4,b5,b6,sb1,sb2,tb1,tb2,tb3,tb4,tb5,tb6,tb7,tb8,tb9,tb10,tb11,tb12,tb01,tb02;
TextField ft1,ft2,ft3,ft4;
Button fb1,fb2,b001,b002,b7,b8;
Label l1,l2,l3,l4,l5,l6,l7,sl0,sl1,l99,sl2,sl3,sl4,sl5,sl6,sl7,sl8,sl9,sl10,sl11,sl12,tl1,tl2,tl3,tl4,tl5,tl6,tl7,tl8,mult,cl1,cl2,cl3,fl1,fl2,fl3,fl4;
Button ob1,ob2;
TextField ot1,ot2,ot3,ot4;
TextArea oa1,oa2;
Choice oli1;
Label ol1,ol2,ol3,ol4,ol5,ol6,ol7,ol8,ol9,l100,l101,l102,l103,l104,l105,l106,l201,l202,l203,l204,l205,l206,l207,l208,l209,l210,l211,l212,l213,l214,l215,l216;
Checkbox r1,r2;
CheckboxGroup r;
Frame withdrawl=new Frame("WITHDRAWL FORM");
Frame ticket=new Frame("TICKET INFO");
Frame login=new Frame("LOGIN");
Frame saving=new Frame("SAVING FORM");
Frame task=new Frame("TASKS");
Frame card=new Frame("POSTCARD INFO");
Frame mo=new Frame("MONEY-ORDER");
Frame telephone=new Frame("TELEPHONE");
Frame op=new Frame("OPEN A NEW ACCOUNT");
Button nb1,nb2;
TextField nt1,nt2,nt3,nt4,nt5,nt6;
TextArea na1;
Label nl1,nl2,nl3,nl4,nl6,nl7,nl8,nl9,nl0;
GridLayout g;
//MAIN FUNCTION

void demo()
{

//FRAME OF WITHDRAWL

Font fnt=new Font("book antiqua",Font.BOLD,16);
withdrawl.setLayout(new FlowLayout());
withdrawl.setSize(400,400);
l7=new Label("WITHDRAWL FORM");
l7.setFont(fnt);
withdrawl.add(l7);
l201=new Label("                                                    ");
withdrawl.add(l201);
l1=new Label("PAYMENT ORDER");
withdrawl.add(l1);
l203=new Label("                                                                           ");
withdrawl.add(l203);
l2=new Label("Date");
withdrawl.add(l2);
t1=new TextField(40);
withdrawl.add(t1);
fl1=new Label("ACCOUNT NO.:");
withdrawl.add(fl1);
ft1=new TextField(30);
withdrawl.add(ft1);
l3=new Label("pay RS.");
withdrawl.add(l3);
t2=new TextField(40);
withdrawl.add(t2);
l4=new Label("(in figures)");
withdrawl.add(l4);
t3=new TextField(40);
withdrawl.add(t3);
l5=new Label("(in words)");
withdrawl.add(l5);
t4=new TextField(40);
withdrawl.add(t4);
l6=new Label("signature");
withdrawl.add(l6);
b001=new Button("SAVE");
withdrawl.add(b001);
b002=new Button("EXIT");
withdrawl.add(b002);
//withdrawl.setFont(fnt);
b002.addActionListener(this);


//FRAME OF TASKS

task.setSize(400,400);
task.setLayout(null);
task.setFont(fnt);
b7=new Button("OPEN AN ACCOUNT");
b7.setBounds(200,40,170,30);
task.add(b7);
b1=new Button("WITHDRAWL");
b1.setBounds(200,80,170,30);
task.add(b1);
b2=new Button("SAVINGS");
b2.setBounds(200,120,170,30);
task.add(b2);
b2.addActionListener(this);
b3=new Button("TICKETS");
b3.setBounds(200,160,170,30);
task.add(b3);
b4=new Button("LETTERS");
b4.setBounds(200,200,170,30);
task.add(b4);
b5=new Button("MONEY ORDER");
b5.setBounds(200,240,170,30);
task.add(b5);
b6=new Button("TELEPHONE BILL");
b6.setBounds(200,280,170,30);
task.add(b6);
b5.addActionListener(this);
b8=new Button("EXIT");
b8.setBounds(200,320,170,30);
task.add(b8);
b8.addActionListener(this);
b1.addActionListener(this);
b6.addActionListener(this);
b7.addActionListener(this);

//FRAME OF SAVING INFO

//saving.setBackground(Color.green);
saving.setLayout(new FlowLayout());
sl0=new Label("POST OFFICE SAVINGS BANK");
saving.add(sl0);
l204=new Label("                                                                                          ");
saving.add(l204);
sl1=new Label("POST OFFICE         ");
saving.add(sl1);
st0=new TextField(40);
saving.add(st0);
sl2=new Label("ACCOUNT NO.        ");
saving.add(sl2);
st1=new TextField(40);
saving.add(st1);
sl3=new Label("DATE                       ");
saving.add(sl3);
st2=new TextField(40);
saving.add(st2);
l206=new Label("           ");
saving.add(l206);
sl4=new Label("NAME           ");
saving.add(sl4);
st3=new TextField(40);
saving.add(st3);
l207=new Label(" ");
saving.add(l207);
sl5=new Label("RUPEES     ");
saving.add(sl5);
st4=new TextField(40);
saving.add(st4);
l208=new Label("      ");
saving.add(l208);
sl6=new Label("RUPEES IN WORDS");
saving.add(sl6);
st5=new TextField(40);
saving.add(st5);

sl7=new Label("BY CASH/CHEQUE NO.");
saving.add(sl7);
st6=new TextField(40);
saving.add(st6);

saving.add(l210);
sl8=new Label("DATE");
saving.add(sl8);
st7=new TextField(40);
saving.add(st7);
//saving.add(l211);
sl9=new Label("DRAWN ON");
saving.add(sl9);
st8=new TextField(40);
saving.add(st8);
saving.add(l212);
sl10=new Label("BANK NAME");
saving.add(sl10);
st9=new TextField(40);
saving.add(st9);
sl11=new Label("FINE AMOUNT");
saving.add(sl11);
st10=new TextField(40);
saving.add(st10);
sl12=new Label("BALANCE AFTER TRANSACTION");
saving.add(sl12);
st11=new TextField(40);
saving.add(st11);

sb1=new Button("SAVE");
saving.add(sb1);
sb2=new Button("EXIT");
saving.add(sb2);
sb2.addActionListener(this);
saving.setSize(500,500);
//saving.setFont(fnt);

//FRAME OF TICKET INFORMATION

ticket.setSize(500,500);
ticket.setLayout(new FlowLayout());
tl1=new Label("INFORMATION OF  TICKETS");
tl1.setFont(fnt);
ticket.add(tl1);
ticket.add(tl11);
tl3=new Label("TICKET OF RS 1");
ticket.add(tl3);
tt3=new TextField("1");
ticket.add(tt3);
mult=new Label("*");
ticket.add(mult);
tt03=new TextField(10);
ticket.add(tt03);
tb2=new Button("=");
ticket.add(tb2);
tb2.addActionListener(this);
tt002=new TextField(10);
ticket.add(tt002);
tl4=new Label("TICKET OF RS 2");
ticket.add(tl4);
tt4=new TextField("2");
ticket.add(tt4);
mult=new Label("*");
ticket.add(mult);
tt04=new TextField(10);
ticket.add(tt04);
tb3=new Button("=");
ticket.add(tb3);
tb3.addActionListener(this);
tt003=new TextField(10);
ticket.add(tt003);
tl5=new Label("TICKET OF RS 4");
ticket.add(tl5);
tt5=new TextField("4");
ticket.add(tt5);
mult=new Label("*");
ticket.add(mult);
tt05=new TextField(10);
ticket.add(tt05);
tb4=new Button("=");
ticket.add(tb4);
tb4.addActionListener(this);
tt004=new TextField(10);
ticket.add(tt004);
tl6=new Label("TICKET OF RS 5");
ticket.add(tl6);
tt6=new TextField("5");
ticket.add(tt6);
mult=new Label("*");
ticket.add(mult);
tt06=new TextField(10);
ticket.add(tt06);
tb5=new Button("=");
ticket.add(tb5);
tb5.addActionListener(this);
tt005=new TextField(10);
ticket.add(tt005);
tl7=new Label("TICKET OF RS 10");
ticket.add(tl7);
tt7=new TextField("10");
ticket.add(tt7);
mult=new Label("*");
ticket.add(mult);
tt07=new TextField(10);
ticket.add(tt07);
tb6=new Button("=");
ticket.add(tb6);
tb6.addActionListener(this);
tt006=new TextField(10);
ticket.add(tt006);
tl8=new Label("REVENUE STAMP");
ticket.add(tl8);
tt8=new TextField(10);
ticket.add(tt8);
mult=new Label("*");
ticket.add(mult);
tt08=new TextField(10);
ticket.add(tt08);
tb7=new Button("=");
ticket.add(tb7);
tb7.addActionListener(this);
tt007=new TextField(10);
ticket.add(tt007);
tb01=new Button("SAVE");
ticket.add(tb01);
tb02=new Button("EXIT");
ticket.add(tb02);
tb02.addActionListener(this);
b3.addActionListener(this);
//ticket.setFont(fnt);

//FRAME ABOUT INFORMATION OF CARDS

card.setSize(500,500);
cl0=new Label("INFORMATION ABOUT LETTERS                                                                                ");
card.add(cl0);
cl1=new Label("POSTCARD");
card.add(cl1);
ct1=new TextField("1");
card.add(ct1);
mult=new Label("*");
card.add(mult);
ct4=new TextField(10);
card.add(ct4);
cb1=new Button("=");
card.add(cb1);
cb1.addActionListener(this);

ct7=new TextField(10);
card.add(ct7);
l101=new Label("                          ");
card.add(l101);
cl2=new Label("INLAND");
card.add(cl2);
ct2=new TextField("2");
card.add(ct2);
mult=new Label("*");
card.add(mult);
ct5=new TextField(10);
card.add(ct5);
cb2=new Button("=");
card.add(cb2);
cb2.addActionListener(this);
ct8=new TextField(10);
card.add(ct8);
l102=new Label("                        ");
card.add(l102);
cl3=new Label("PACKET");
card.add(cl3);
ct3=new TextField("5");
card.add(ct3);
mult=new Label("*");
card.add(mult);
ct6=new TextField(10);
card.add(ct6);
cb3=new Button("=");
card.add(cb3);
cb3.addActionListener(this);
ct9=new TextField(10);
card.add(ct9);
l103=new Label("                                    ");
card.add(l103);
cb4=new Button("SAVE");
card.add(cb4);
cb5=new Button("EXIT");
b4.addActionListener(this);
card.setLayout(new FlowLayout());
card.add(cb5);
cb5.addActionListener(this);
//card.setFont(fnt);

//FRAME OF LOGIN
Font f=new Font("book antiqua",Font.BOLD,20);
login.setFont(f);
login.setSize(500,500);
login.setLayout(new FlowLayout());
fl1=new Label("WELCOME TO DEPARTMENT OF POST");
//fl1.setBounds(100,150,400,400);
login.add(fl1);
l203=new Label("                                                           ");
login.add(l203);
fb1=new Button("NEXT");
//fb1.setBounds(200,200,30,30);
login.add(fb1);
fb1.addActionListener(this);

login.setVisible(true);


//FRAME OF MONEY ORDER

mo.setSize(500,650);
mo.setLayout(new FlowLayout());
mol1=new Label("MONEY-ORDER");
mol2=new Label("ENTER THE NAME OF SENDER");
mol3=new Label("SENDERS ADDRESS");
mol4=new Label("ENTER THE NAME OF RECEIVERS");
mol5=new Label("RECEIVERS ADDRESS");
mol6=new Label("ENTER THE AMOUNT TO SEND");
mol7=new Label("RUPEES IN WORDS");
mol10=new Label("DATE");
mot1=new TextField(30);
mot2=new TextField(30);
mot3=new TextField(20);
mot4=new TextField(20);
mot5=new TextField(20);
mot6=new TextField(20);
moa1=new TextArea();
moa2=new TextArea();
mob1=new Button("SAVE");
mob2=new Button("EXIT");

mo.add(mol1);
l103=new Label("                                                                                                            ");
mo.add(l103);
mo.add(mol10);
mo.add(mot6);
l104=new Label("                                               ");
mo.add(l104);
mo.add(mol2);
mo.add(mot1);
mo.add(mol3);
mo.add(moa1);
mo.add(mol4);
mo.add(mot2);
mo.add(mol5);
mo.add(moa2);
mo.add(mol6);
mo.add(mot3);
l106=new Label("                                           ");
mo.add(l106);
mo.add(mol7);
mo.add(mot5);
l105=new Label("                                           ");
mo.add(l105);
mo.add(mob1);
mo.add(mob2);
mob2.addActionListener(this);
//mo.setFont(fnt);

//FRAME OF TELEPHONE BILL

telephone.setSize(500,550);
telephone.setLayout(new FlowLayout());
nl0=new Label("DATE");
nl1=new Label("TELEPHONE BILL");
nl2=new Label("ENTER THE NAME OF EMPLOYEE");
nl3=new Label("ADDRESS");
nl4=new Label("ENTER THE PHONE NUMBER");
nl6=new Label("ENTER THE AMOUNT OF BILL");
nl7=new Label("RUPEES");
nl8=new Label("IN WORDS");
nl9=new Label("SIGNATURE");
nt1=new TextField(30);
nt2=new TextField(20);
nt3=new TextField(20);
nt4=new TextField(20);
nt5=new TextField(30);
nt6=new TextField(20);
na1=new TextArea();
nb1=new Button("SAVE");
nb2=new Button("EXIT");
telephone.add(nl1);
telephone.add(nl0);
telephone.add(nt6);
telephone.add(nl2);
telephone.add(nt1);
telephone.add(nl3);
telephone.add(na1);
telephone.add(nl4);
telephone.add(nt2);
telephone.add(nl6);
telephone.add(nt3);
telephone.add(nl7);
telephone.add(nt4);
telephone.add(nl8);
telephone.add(nt5);
telephone.add(nl9);
telephone.add(nb1);
telephone.add(nb2);
//telephone.setFont(fnt);
nb2.addActionListener(this);

//OPEN AN ACCOUNT

op.setSize(500,650);
op.setLayout(new FlowLayout());
r=new CheckboxGroup();
ol1=new Label("OPEN AN ACCOUNT");
ol2=new Label("GENDER");
ol3=new Label("TYPE OF ACCOUNT");
ol4=new Label("RUPEES PER MONTH");
ol5=new Label("NAME");
ol6=new Label("ADRESS");
ol7=new Label("NOMINEE NAME");
ol9=new Label("ADRESS");
ol8=new Label("SIGNATURE");
ot1=new TextField(50);
ot2=new TextField(10);
ot3=new TextField(50);
ot4=new TextField(50);
oa1=new TextArea();
oa2=new TextArea();
oli1=new Choice();
l99=new Label("                                                                                                   ");
l100=new Label("                                                        ");
oli1.add("RD");
oli1.add("PLI");
oli1.add("RPLI");
oli1.add("");
r1=new Checkbox("Male",false,r);
r2=new Checkbox("Female",false,r);
ob1=new Button("CREATE AN ACCOUNT");
ob2=new Button("EXIT");
//ol1.setBounds(50,40,100,25);
op.add(ol1);
op.add(l99);
//ol5.setBounds(50,80,100,25);
op.add(ol5);
//ot1.setBounds(90,120,100,25);
op.add(ot1);
//ol6.setBounds(50,160,100,25);
op.add(ol6);
//oa1.setBounds(50,200,100,25);
op.add(oa1);
//ol2.setBounds(50,240,100,25);
op.add(ol2);
op.add(r1);
op.add(r2);
//ol3.setBounds(50,320,100,25);
op.add(ol3);
//oli1.setBounds(50,360,100,25);
op.add(oli1);
//ol4.setBounds(50,400,100,25);
op.add(ol4);
//ot2.setBounds(50,440,100,25);
op.add(ot2);
op.add(l100);
//ol7.setBounds(50,480,100,25);
op.add(ol7);
//ot3.setBounds(50,520,100,25);
op.add(ot3);
//ol9.setBounds(50,560,100,25);
op.add(ol9);
//oa2.setBounds(50,600,100,25);
op.add(oa2);
//ol8.setBounds(50,640,100,25);
op.add(ol8);
//ob1.setBounds(50,700,100,25);
op.add(ob1);
//ob2.setBounds(50,740,100,25);
op.add(ob2);
ob2.addActionListener(this);
}

public static void main(String args[])
	{
	app1 a=new app1();
	a.show();
	a.setSize(500,500);
	a.setVisible(true);
	}
public void actionPerformed(ActionEvent e)
{
if(e.getSource()==fb1)
{
login.setVisible(false);
task.setVisible(true);
}
if(e.getSource()==ob2)
{
op.setVisible(false);
task.setVisible(true);
}
if(e.getSource()==b7)
{
task.setVisible(false);
op.setVisible(true);
}
if(e.getSource()==b002)
{
withdrawl.setVisible(false);
task.setVisible(true);
}
if(e.getSource()==b5)
{
task.setVisible(false);
mo.setVisible(true);
}
if(e.getSource()==b6)
{
task.setVisible(false);
telephone.setVisible(true);
}
if(e.getSource()==nb2)
{
telephone.setVisible(false);
task.setVisible(true);
}
if(e.getSource()==sb2)
{
saving.setVisible(false);
task.setVisible(true);
}
if(e.getSource()==tb02)
{
ticket.setVisible(false);
task.setVisible(true);
}
if(e.getSource()==b2)
{
task.setVisible(false);
saving.setVisible(true);
}
if(e.getSource()==b3)
{
task.setVisible(false);
ticket.setVisible(true);
}
if(e.getSource()==b4)
{
task.setVisible(false);
card.setVisible(true);
}
if(e.getSource()==cb5)
{
card.setVisible(false);
task.setVisible(true);
}
if(e.getSource()==mob2)
{
mo.setVisible(false);
task.setVisible(true);
}
if(e.getSource()==b1)
{
task.setVisible(false);
withdrawl.setVisible(true);
}
if(e.getSource()==tb2)
{
int product=Integer.parseInt(tt3.getText())*Integer.parseInt(tt03.getText());
tt002.setText(String.valueOf(product));
}
if(e.getSource()==tb3)
{
int product=Integer.parseInt(tt4.getText())*Integer.parseInt(tt04.getText());
tt003.setText(String.valueOf(product));
}
if(e.getSource()==tb4)
{
int product=Integer.parseInt(tt5.getText())*Integer.parseInt(tt05.getText());
tt004.setText(String.valueOf(product));
}
if(e.getSource()==tb5)
{
int product=Integer.parseInt(tt6.getText())*Integer.parseInt(tt06.getText());
tt005.setText(String.valueOf(product));
}
if(e.getSource()==tb6)
{
int product=Integer.parseInt(tt7.getText())*Integer.parseInt(tt07.getText());
tt006.setText(String.valueOf(product));
}
if(e.getSource()==tb7)
{
int product=Integer.parseInt(tt8.getText())*Integer.parseInt(tt08.getText());
tt007.setText(String.valueOf(product));
}
if(e.getSource()==cb1)
{
int product=Integer.parseInt(ct1.getText())*Integer.parseInt(ct4.getText());
ct7.setText(String.valueOf(product));
}
if(e.getSource()==cb2)
{
int product=Integer.parseInt(ct2.getText())*Integer.parseInt(ct5.getText());
ct8.setText(String.valueOf(product));
}
if(e.getSource()==cb3)
{
int product=Integer.parseInt(ct3.getText())*Integer.parseInt(ct6.getText());
ct9.setText(String.valueOf(product));
}
if(e.getSource()==b8)
{
System.exit(0);
}
}
}




