import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/*
<applet code="Form" width="250" height="300">
</applet>
*/

public class Form extends JApplet implements ActionListener
{
    JLabel ltitle,lsubt1,lname,ladd,lstt,lpin,lmail,ldob,ldd,lmm,lyy,lsubt2,lbr,lamt,lac,loc,ldu,lln,lrt,ldt,l,llt;
    JTextField tname,tadd,tpin,tmail,tamt,tac,tln,tdt;
    JComboBox cstt,cdob1,cdob2,cdob3,cbr,coc,cdu,crt,clt;
    JButton submit,cancel;
    String stt[]={"Maharashtra","Karnataka","Kerala","Madhya Pradesh","Undhra P","Haidrabad","Gujrat","Panjab","Rajsthan","Ranchi"};
    String dd[]={"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
    String  mm[]={"Jan","Feb","Mar","Apr","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
    String yy[]={"1950","1951","1952","1953","1954","1955","1956","1957","1958","1959","1960","1961","1962","1963","1964","1965","1966","1967","1968","1969","1970","1971","1972","1973","1974","1975","1976","1977","1978","1979","1980","1981","1982","1983","1984","1985","1986","1987","1988","1989","1990","1991","1992","1993","1994","1995","1996","1997","1998","1999","2000","2001","2002","2003","2004","2005","2006","2007","2008","2009","2010","2011","2012","2013","2014","2015","2016","2017","2018","2019","2020","2021","2022","2023","2024","2025","2026","2027","2028","2029","2030"};
    String br[]={"Baramati","Pune","Mumbai","Satara","Solapur","A.Nagar","Nashik","Dhule","Belgawn","Sagli","Phaltan","Karad"};
    String lt[]={"Home","Education","Vahicle","Farm"};
    String oc[]={"-","Self Employee","Salaroid"};
    String du[]={"2 Year","3 Year","5 Year"};
    String rt[]={"5","7","10","12","15"};
    public void init()
    {
        setLayout(null);
        ltitle =new JLabel("FORM");
        add(ltitle);
        ltitle.setBounds(230,1,40,10);
        l =new JLabel("-------------------------------------------------------------------------------------------------------------------------");
        add(l);
        l.setBounds(4,6,540,10);
        lsubt1 =new JLabel("I-Personal Information");
        add(lsubt1);
        lsubt1.setBounds(20,20,200,60);
        lname =new JLabel("NAME");
        add(lname);
        lname.setBounds(50,40,40,80);
        tname=new JTextField(30);
        add(tname);
        tname.setBounds(120,70,300,20);

        ladd =new JLabel("ADDRESS");
        add(ladd);
        ladd.setBounds(50,100,100,20);
        tadd=new JTextField(30);
        add(tadd);
        tadd.setBounds(120,100,300,50);

        lstt =new JLabel("STATE");
        add(lstt);
        lstt.setBounds(50,155,100,20);
        cstt=new JComboBox(stt);
        add(cstt);
        cstt.setBounds(120,155,130,20);

        lpin =new JLabel("PIN CODE");
        add(lpin);
        lpin.setBounds(50,190,100,20);
        tpin=new JTextField(30);
        add(tpin);
        tpin.setBounds(120,190,100,20);

        lmail =new JLabel("E-mail");
        add(lmail);
        lmail.setBounds(50,230,100,20);
        tmail=new JTextField(30);
        add(tmail);
        tmail.setBounds(120,230,200,20);

        ldob =new JLabel("DATE OF BRITH");
        add(ldob);
        ldob.setBounds(50,260,100,20);

        ldd =new JLabel("DD");
        add(ldd);
        ldd.setBounds(120,278,100,20);
        cdob1=new JComboBox(dd);
        add(cdob1);
        cdob1.setBounds(140,278,50,20);

        lmm =new JLabel("MM");
        add(lmm);
        lmm.setBounds(210,278,100,20);
        cdob2=new JComboBox(mm);
        add(cdob2);
        cdob2.setBounds(235,278,70,20);

         lyy =new JLabel("YY");
        add(lyy);
        lyy.setBounds(320,278,100,20);
       cdob3=new JComboBox(yy);
        add(cdob3);
        cdob3.setBounds(335,278,80,20);
       //SUB TITLE 2
        l =new JLabel("-------------------------------------------------------------------------------------------------------------------------");
        add(l);
        l.setBounds(4,299,540,10);
        lsubt2=new JLabel("II-Bank Information");
        add(lsubt2);
        lsubt2.setBounds(20,300,200,60);

        lbr=new JLabel("BRANCH");
        add(lbr);
        lbr.setBounds(50,320,60,80);
        cbr=new JComboBox(br);
        add(cbr);
        cbr.setBounds(120,350,90,20);

        llt=new JLabel("LOAN TYPE");
        add(llt);
        llt.setBounds(250,320,80,80);
        clt=new JComboBox(lt);
        add(clt);
        clt.setBounds(320,350,90,20);

        lamt =new JLabel("AMOUNT");
        add(lamt);
        lamt.setBounds(50,390,100,20);
        tamt=new JTextField(30);
        add(tamt);
        tamt.setBounds(120,390,100,20);

        lac =new JLabel("A/C No. ");
        add(lac);
        lac.setBounds(50,430,100,20);
        tac=new JTextField(30);
        add(tac);
        tac.setBounds(120,430,100,20);



        lamt =new JLabel("OCCUPTION");
        add(lamt);
        lamt.setBounds(50,460,100,20);
        coc=new JComboBox(oc);
        add(coc);
        coc.setBounds(120,460,90,20);

        ldu =new JLabel("DURATION");
        add(ldu);
        ldu.setBounds(50,490,100,20);
        cdu=new JComboBox(du);
        add(cdu);
        cdu.setBounds(120,490,90,20);

        //For OFFICE
        l =new JLabel("-------------------------------------------------------------------------------------------------------------------------");
        add(l);
        l.setBounds(4,513,540,10);
        lsubt2=new JLabel("III-For Office");
        add(lsubt2);
        lsubt2.setBounds(20,514,200,60);

         lln =new JLabel("Loan No.");
        add(lln);
        lln.setBounds(50,560,100,20);
        tln=new JTextField(30);
        add(tln);
        tln.setBounds(120,560,100,20);

        lrt=new JLabel("RENT");
        add(lrt);
        lrt.setBounds(50,590,100,20);
        crt=new JComboBox(rt);
        add(crt);
        crt.setBounds(120,590,90,20);

        //Buttons
        submit=new JButton("Submit");
        add(submit);
        submit.setBounds(80,630,100,20);
        cancel=new JButton("Cancel");
        add(cancel);
        cancel.setBounds(280,630,100,20);

        ldt =new JLabel("DATE");
        add(ldt);
        ldt.setBounds(250,560,100,20);
        tdt=new JTextField(30);
        add(tdt);
        tdt.setBounds(290,560,100,20);
    }


    public void actionPerformed(ActionEvent e)
    {

    }
}