

//PROJECT ON-:MEDICAL RECORD KEEPING SYSTEM
//ENVIORNMENT-C/C++
//COMPATIBLE WITH WINDOWS 95,98(NOT FOR XP)
#include<stdio.h>
#include<conio.h>
#include<dos.h>
#pragma warn -rvl
#define SE 112
#define US 7
union REGS i,o;

/**************************************************************/
	    /*STRUCTURE AND VARIABLES FOR EMPLOYEE ENTRY*/

/**************************************************************/
struct employee
{
char empname[100];
char empno[10];
char empdept[50];
char memname[100];
}e;
int member;
char names[100];


char name3[100];
char no[10];
char dept[50];

char id1[10];
char nameemp[100];
char dateemp[10];


/*******************************************************************/
	       /*STRUCTURE AND VARIABLES FOR OUTSIDERS ENTRY */


/*******************************************************************/
struct outsider
{
char patientno[10];
char date[12];
char patient[100];
int age;
char sex1[4];
char suffer[50];
char medicine[50];
}out;



int flag=0;
//Variables For Outsiders Record File Started
char name1[100];
char date1[40];
char id[10];
char another;
char another1;
char del[100];
char another2;
char update[100];
char updateno[100];
//Variables For Outsiders Record File Completed
/******************************************************************/

		   //STRUCTURE FOR NEW ENTRY FORM



/******************************************************************/
struct form
{
char empno2[10];
char date[10];
char patient[100];
char sex[8];
char age[10];
char medicine[100];
}s;
char del1[10];
char petname[100];
char dates[10];
/******************************************************************/
			 //To use keys
/******************************************************************/
//Taken from file save1.c
int get_file_attrib(char fname[40]);
void setattr(int,int,int);
char far *scr;
char far *mode1;
int r,c,w,x,y,attrib,flen=1;
char ch;//To use keys



char name[10];
char number[10];
int len,z;
int p,q;
int a,b;
int x,y,button;

FILE *fp,*ft,*fpt,*fs,*fps;
void main()
{

int i,j;
fp=fopen("medical1.dat","r+");//file open for read only
if(fp==NULL)
{
     fp=fopen("medical1.dat","w+");//file open for write only
	 if(fp==NULL)
	     {
	       printf("Cannot open file");
	     }
}

ft=fopen("medical2.dat","r+");
if(ft==NULL)
{
	 ft=fopen("medical2.dat","w+");
	     if(ft==NULL)
		{
		 printf("cannot open file");
		}
}

fs=fopen("medical3.dat","r+");
if(fs==NULL)
{
	fs=fopen("medical3.dat","w+");
	   if(fs==NULL)
	       {
		 printf("cannot open file");
	       }
}

 textmode(3);
 clrscr();
 TABLE();
 TABLE1();

if(initmouse()==0)
{
      printf("mouse driver not loaded");
      exit(1);
}

 showmouseptr();
 getmousepos(&button,&x,&y);

while(!kbhit())
{

	   getmousepos(&button,&x,&y);
	   MAINMENU();



//gotoxy(65,4);
//printf("x=%03d,y=%03d",x,y);

		     }//While loop ended
fclose(fp);
fclose(ft);
fclose(fs);
}//Void main ended




TABLE()
{
int i,j;
textbackground(BLACK);
//Taken from save1.c to use keys
/* _AH=0;
   _AL=3;
   geninterrupt(0x10);
   if((*mode1 &0x30)== 0x30)
      scr=(char far*) 0xb0000000;     //0xb0000000;
   else
      scr=(char far*) 0xb8000000;
   begin:
   r=4;
   c=20;//upto here */
clrscr();
_setcursortype(_NOCURSOR);
textcolor(WHITE);
textbackground(4);
highvideo();
gotoxy(1,2);
cprintf("É");
for(i=2;i<79;i++)
{
gotoxy(i,j=2);
cprintf("Í");
}
gotoxy(79,2);
cprintf("»");
for(j=3;j<25;j++)
{
gotoxy(i=1,j);
cprintf("º");
}
gotoxy(1,25);
cprintf("È");
for(i=2;i<79;i++)
{
gotoxy(i,j=25);
cprintf("Í");
}
gotoxy(79,25);
cprintf("¼");
for(j=3;j<25;j++)
{
gotoxy(i=79,j);
cprintf("º");
}
for(i=2;i<40;i++)
{
gotoxy(i,j=4);
delay(10);
cprintf("Ä");
gotoxy(i,j=23);
delay(1);
cprintf("Ä");
}
for(i=78;i>=40;i--)
{
gotoxy(i,j=4);
delay(10);
cprintf("Ä");
gotoxy(i,j=23);
delay(10);
cprintf("Ä");
}
for(i=2;i<79;i++)
{
for(j=3;j<=3;j++)
{
textcolor(4);
textbackground(8);
highvideo();
gotoxy(i,j);
cprintf("°");
}}
for(i=2;i<79;i++)
{
for(j=24;j<25;j++)
{
textcolor(4);
highvideo();
gotoxy(i,j);
cprintf("°");
}}
textcolor(4);
lowvideo();
gotoxy(5,8);
cprintf("      Ü   ");
gotoxy(5,9);
cprintf("   ÜÜÜÛÜÜÜ");
gotoxy(5,10);
cprintf("      Û   ");
gotoxy(64,8);
cprintf("   Ü      ");
gotoxy(64,9);
cprintf("ÜÜÜÛÜÜÜ   ");
gotoxy(64,10);
cprintf("   Û      ");
textcolor(10);
highvideo();
gotoxy(25,5);
cprintf("ÛßÜßÛ Ûßß ÛßÜ ßÛß Ûßß ÜßÜ Û");
delay(200);
gotoxy(25,6);
cprintf("Û   Û ÛÛ  Û  Û Û  Û   ÛÜÛ Û");
delay(200);
gotoxy(25,7);
cprintf("Û   Û ÛÜÜ ÛÜß ÜÛÜ ÛÜÜ Û Û ÛÜÜ");
delay(200);
gotoxy(25,9);
cprintf("ÛßÜ  Ûßß  Ûßß  ÛßÛ  ÛßÜ  ÛßÜ");
delay(200);
gotoxy(25,10);
cprintf("ÛÜß  ÛÛ   Û    Û Û  ÛÜß  Û  Û ");
delay(200);
gotoxy(25,11);
cprintf("Û ßÜ ÛÜÜ  ÛÜÜ  ÛÜÛ  Û ßÜ ÛÜß  ");
delay(200);
gotoxy(10,13);
cprintf("ÛßÜßÛ ÜßÜ ßÛß ÛßÜ  Û ßßÛßß ÜßÜ ßÛß ÛßÜ  Û ßÛß ÛßÜ  Û   Ûß ");
delay(200);
gotoxy(10,14);
cprintf("Û   Û ÛÜÛ  Û  Û  Û Û   Û   ÛÜÛ  Û  Û  Û Û  Û  Û  Û Û Ûß  ÜßßÜ");
delay(200);
gotoxy(10,15);
cprintf("Û   Û Û Û ÜÛÜ Û   ÛÛ   Û   Û Û ÜÛÜ Û   ÛÛ ÜÛÜ Û   ÛÛ  ßÜÜÜÛ Û");
delay(200);
gotoxy(21,17);
cprintf("Ûßß  ßÜ   Üß  Ûßß  ßßÛßß  Ûßß  ÛßÜßÛ");
delay(200);
gotoxy(21,18);
cprintf(" ßÜ     Û      ßÜ    Û    ÛÛ   Û   Û");
delay(200);
gotoxy(21,19);
cprintf("ÜÜÜÛ    Û     ÜÜÜÛ   Û    ÛÜÜ  Û   Û");
//Taken from save1.c
/*gotoxy(3,22);
   printf(" HELP ");
   gotoxy(73,22);
   printf(" NEXT ");
   while(ch!=13)
   {
      for(x=3;x<73;x++)
	 setattr(x,20,US);
      setattr(r,c,SE);
      gotoxy(36,11);
      ch=getch();
      if(ch=='H'||ch=='h')
      {
	 if(r==4)
	    r=4;
	 else
	    r--;
      }
      else if(ch=='P'||ch=='p')
      {
	 if(r==8)
	    r=8;
	 else
	    r++;
      }}
      ch=' ';
   y=r-3; */
textcolor(YELLOW+BLINK);
textbackground(1);
highvideo();
gotoxy(2,22);
cprintf("                     Press any key to continue......");
getch();
}






TABLE1()
{
 int i,j;
 textcolor(WHITE);
 textbackground(1);
 clrscr();
 highvideo();
 _setcursortype(_NOCURSOR);
 gotoxy(1,2);
 cprintf("Ú");
     for(i=2;i<79;i++)
       {
	gotoxy(i,j=2);
	cprintf("Ä");
       }

 gotoxy(79,2);
 cprintf("¿");
     for(j=3;j<25;j++)
       {
	gotoxy(i=1,j);
	cprintf("³");
       }
 gotoxy(1,25);
 cprintf("À");
      for(i=2;i<79;i++)
	{
	 gotoxy(i,j=25);
	 cprintf("Ä");
	}
 gotoxy(79,25);
 cprintf("Ù");
      for(j=3;j<25;j++)
	{
	 gotoxy(i=79,j);
	 cprintf("³");
	}
 gotoxy(1,4);
 cprintf("Ã");
 gotoxy(79,4);
 cprintf("´");

      for(i=2;i<79;i++)
	{
	 gotoxy(i,j=4);
	 cprintf("Ä");
	}
 gotoxy(1,6);
 cprintf("Ã");
 gotoxy(79,6);
 cprintf("´");

       for(i=2;i<79;i++)
	 {
	  gotoxy(i,j=6);
	  cprintf("Ä");
	 }
 gotoxy(2,5);
 cprintf("³");
 gotoxy(78,5);
 cprintf("³");

 textcolor(6+BLINK);
 textbackground(8);
 highvideo();
 gotoxy(1,1);
 cprintf("");
 gotoxy(33,1);
 textbackground(8);
 textcolor(10+BLINK);
 highvideo();
 cprintf(" MAIN____MENU ");

 highvideo();
 gotoxy(9,5);
 textcolor(BLACK);
 textbackground(4);
 cprintf(" FILE ");

 gotoxy(28,5);
 cprintf(" EDIT ");

 gotoxy(47,5);
 cprintf(" HELP ");

 gotoxy(66,5);
 cprintf(" EXIT ");

 }
/*************************************************************************
**/
 //FUNCTION TO INITALISE MOUSE
/*************************************************************************
**/
initmouse()
{
   i.x.ax=0;
   int86(0x33,&i,&o);
   return(o.x.ax);
}
/*************************************************************************
**/
 //FUNCTION TO SHOW MOUSE POINTER
/*************************************************************************
**/
showmouseptr()
{
   i.x.ax=1;
   int86(0x33,&i,&o);
}
/*************************************************************************
**/
 //FUNCTION TO GET CO-ORDINATES OF THE MOUSE POINTER
/*************************************************************************
**/
getmousepos(int *button,int *x,int *y)//function to get coordinates
{
      i.x.ax=3;
      int86(0x33,&i,&o);
      *button=o.x.bx;
      *x=o.x.cx;
      *y=o.x.dx;
}

/*************************************************************************
**/
 //FUNCTION TO RESTRICT MOUSE POINTER(row wise)
/*************************************************************************
**/
restrictmouseptr()
{

    i.x.ax=8;
    int86(0x33,&i,&o);
}

/*************************************************************************
**/
 //FUNCTION TO RESTRICT MOUSE POINTER(column wise)
/*************************************************************************
**/
restrictmouseptr1()
{
   i.x.ax=7;
   int86(0x33,&i,&o);
}

/*************************************************************************
**/
 //FUNCTION TO HIDE MOUSE POINTER
/*************************************************************************
**/
hidemouseptr()
{
    i.x.ax=2;
    int86(0x33,&i,&o);
}
/*************************************************************************
**/
 //FUNCTION TO RESTRICT MOUSE POINTER BETWEEN CERTAIN CO_ORDINATES
/*************************************************************************
**/
restrictmouseptr2(int a1,int a2,int b1,int b2)
{
   i.x.ax=7;
   i.x.cx=a1;
   i.x.dx=a2;
   int86(0x33,&i,&o);
   i.x.ax=8;
   i.x.cx=b1;
   i.x.dx=b2;
   int86(0x33,&i,&o);
}

/*************************************************************************
**/
 //FUNCTION FOR ARROW KEYS
/*************************************************************************
**/
void setattr(int row,int col,int attr)
{
   for(w=3;w<78;w++)
   {
      *(scr+row*160+col*2+1)=attr;
      col++;
   }
}

MAINMENU()
{

if((button &1)==1)         //Mouse click event
{
		 FILE1();
		 EDIT();
		 HELP();
		 EXIT1();
		 ADD();
		 NEW();
		 ENTRY();
		 SEARCHEMP();
		 DELETEEMP();
		 UPDATEEMP();
		 OUTENTRY();
		 SEARCHOUT();
		 UPDATEOUT();
		 DELETEOUT();
		 HELPTOPICS();
		 ABOUT();
}//MOUSE click event ended
}






/*************************************************************************
**/

			      /*FILE MENU*/

/*************************************************************************
**/

FILE1()
 {
if((x>=56&&y==32)&&(x<=104&&y==32))  //Coordinate for FILE menu started
{




gotoxy(28,5); //For EDIT menu
textcolor(BLACK);
textbackground(4);
cprintf(" EDIT ");
gotoxy(23,6);
highvideo();
textcolor(WHITE);
textbackground(1);
cprintf("ÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄ");
for(b=7;b<16;b++)
{
gotoxy(a=23,b);
textbackground(1);
cprintf("                      ");
} //EDIT MENU ENDED


//For HELP menu
gotoxy(47,5);
textcolor(BLACK);
textbackground(RED);
cprintf(" HELP ");
gotoxy(42,6);
highvideo();
textcolor(WHITE);
textbackground(1);
cprintf("ÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄ");
for(b=7;b<13;b++)
{
gotoxy(a=41,b);
textbackground(1);
cprintf("                        ");
}//HELP menu ended

//for About.. menu
for(a=24;a<=48;a++)
{
for(b=16;b<=23;b++)
{
textbackground(1);
gotoxy(a,b);
cprintf("                         ");
}
}
//For About.. menu completed


//For FILE menu started
gotoxy(9,5);
textcolor(7);
textbackground(8);
highvideo();
cprintf(" FILE ");
gotoxy(3,6);
textcolor(WHITE);
textbackground(WHITE);
cprintf("ÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄ");
gotoxy(3,7);
textcolor(WHITE);
textbackground(WHITE);
cprintf(" ÚÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄ¿ ");
for(b=8;b<12;b++)
{
delay(5);
gotoxy(a=3,b);
textcolor(WHITE);
textbackground(WHITE);
cprintf(" ³");
}
for(b=8;b<12;b++)
{
gotoxy(a=21,b);
textcolor(WHITE);
textbackground(WHITE);
cprintf("³ ");
}
gotoxy(3,12);
textcolor(WHITE);
textbackground(WHITE);
cprintf(" Ã");
gotoxy(21,12);
cprintf("´ ");
for(b=13;b<=16;b++)
{
gotoxy(a=3,b);
cprintf(" ³");
}
for(b=13;b<=16;b++)
{
gotoxy(a=21,b);
cprintf("³ ");
}
gotoxy(3,16);
cprintf(" À");
gotoxy(21,16);
cprintf("Ù ");
for(a=5;a<21;a++)
{
gotoxy(a,b=16);
cprintf("Ä");
}//for loop ended
for(a=5;a<21;a++)
{
gotoxy(a,b=12);
cprintf("Ä");
}//for loop ended
textcolor(RED+BLINK);
textbackground(7);
gotoxy(5,8);
cprintf("For Employee....");
textcolor(8);
textbackground(WHITE);
lowvideo();
gotoxy(5,9);
cprintf("ADD EMP. RECORD ");
gotoxy(5,10);
cprintf("   NEW ENTRY    ");
gotoxy(5,11);
cprintf(" SEARCH  ENTRY  ");
textcolor(5+BLINK);
textbackground(7);
gotoxy(5,13);
cprintf("For Outsiders...");
textcolor(8);
textbackground(7);
gotoxy(5,14);
lowvideo();
cprintf(" PATIENT ENTRY  ");
gotoxy(5,15);
cprintf(" SEARCH ENTRY   ");

for(a=6;a<=23;a++)
{
textbackground(8);
gotoxy(a,17);
delay(1);
cprintf(" ");
}
for(b=7;b<=17;b++)
{
textbackground(8);
textcolor(8);
gotoxy(23,b);
cprintf(" ");
}
}//If statement of FILE menu completed
}





/*************************************************************************
**/
			    /*EDIT MENU*/




/*************************************************************************
**/

EDIT()
{
if((x>=208&&y==32)&&(x<=256&&y==32))//Coordinate for EDIT menu started
{



//For FILE MENU
gotoxy(9,5);
textcolor(BLACK);
textbackground(4);
cprintf(" FILE ");
gotoxy(3,6);
highvideo();
textcolor(WHITE);
textbackground(1);
cprintf("ÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄ");
for(b=7;b<11;b++)
{
gotoxy(a=3,b);
textbackground(1);
cprintf("                    ");
}
for(b=11;b<18;b++)
{
gotoxy(a=3,b);
textbackground(1);
cprintf("                      ");
}
//FILE MENU ENDED

//For HELP menu
gotoxy(47,5);
textcolor(BLACK);
textbackground(RED);
cprintf(" HELP ");
gotoxy(42,6);
highvideo();
textcolor(WHITE);
textbackground(1);
cprintf("ÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄ");
for(b=7;b<13;b++)
{
gotoxy(a=41,b);
textbackground(1);
cprintf("                        ");
}//HELP menu ended


//for About.. menu
for(a=24;a<=48;a++)
{
for(b=16;b<=23;b++)
{
textbackground(1);
gotoxy(a,b);
cprintf("                         ");
}}
//For About.. menu completed


gotoxy(28,5);
textcolor(7);
textbackground(8);
highvideo();
cprintf(" EDIT ");
gotoxy(23,6);
textcolor(WHITE);
textbackground(7);
cprintf("ÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄ");
gotoxy(23,7);
textcolor(WHITE);
textbackground(7);
cprintf(" ÚÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄ¿ ");
for(b=8;b<14;b++)
{
delay(5);
gotoxy(a=23,b);
textcolor(WHITE);
textbackground(7);
cprintf(" ³");
}
for(b=8;b<14;b++)
{
gotoxy(a=40,b);
textcolor(WHITE);
textbackground(7);
cprintf("³ ");
}
gotoxy(23,14);
textcolor(WHITE);
textbackground(7);
cprintf(" À");
gotoxy(40,14);
cprintf("Ù ");
for(a=25;a<40;a++)
{
gotoxy(a,b=14);
cprintf("Ä");
}//for loop ended
textcolor(4+BLINK);
textbackground(7);
gotoxy(25,8);
cprintf("For Employee...");
textcolor(5+BLINK);
textbackground(7);
gotoxy(25,11);
cprintf("For Outsiders..");
textcolor(8);
textbackground(7);
lowvideo();
gotoxy(25,9);
cprintf(" DELETE ENTRY  ");
gotoxy(25,10);
cprintf(" UPDATE ENTRY  ");
gotoxy(25,12);
cprintf(" DELETE ENTRY  ");
gotoxy(25,13);
cprintf(" UPDATE ENTRY  ");
for(b=7;b<=15;b++)
{
textbackground(8);
gotoxy(42,b);
cprintf(" ");
}
for(a=26;a<=40;a++)
{
textbackground(8);
gotoxy(a,15);
cprintf("  ");
}
}//If statement of EDIT menu completed

}





/*************************************************************************
**/
			     /*HELP MENU*/


/*************************************************************************
**/
HELP()
{
if((x>=368&&y==32)&&(x<=408&&y==32))//Coordinate of HELP menu started
{





//For EDIT menu
gotoxy(28,5);
textcolor(BLACK);
textbackground(4);
cprintf(" EDIT ");
gotoxy(23,6);
highvideo();
textcolor(WHITE);
textbackground(1);
cprintf("ÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄ");
for(b=7;b<16;b++)
{
gotoxy(a=23,b);
textbackground(1);
cprintf("                      ");
} //EDIT MENU ENDED

//For FILE MENU
gotoxy(9,5);
textcolor(BLACK);
textbackground(4);
cprintf(" FILE ");
gotoxy(3,6);
highvideo();
textcolor(WHITE);
textbackground(1);
cprintf("ÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄ");
for(b=7;b<11;b++)
{
gotoxy(a=3,b);
textbackground(1);
cprintf("                    ");
}
for(b=11;b<18;b++)
{
gotoxy(a=3,b);
textbackground(1);
cprintf("                      ");
}
//FILE MENU ENDED

//for About.. menu
for(a=24;a<=48;a++)
{
for(b=16;b<=23;b++)
{
textbackground(1);
gotoxy(a,b);
cprintf("                         ");
}}
//For About.. menu completed

//HELP menu started
textcolor(7);
textbackground(8);
highvideo();
gotoxy(47,5);
cprintf(" HELP ");
gotoxy(42,6);
textcolor(WHITE);
textbackground(7);
cprintf("ÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄ");
gotoxy(42,7);
textcolor(WHITE);
textbackground(7);
cprintf(" ÚÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄ¿ ");
for(b=8;b<10;b++)
{
delay(5);
gotoxy(a=42,b);
textcolor(WHITE);
textbackground(7);
cprintf(" ³");
}
for(b=8;b<10;b++)
{
gotoxy(a=59,b);
textcolor(WHITE);
textbackground(7);
cprintf("³ ");
}
gotoxy(42,10);
textcolor(WHITE);
textbackground(7);
cprintf(" À");
gotoxy(59,10);
cprintf("Ù ");
for(a=44;a<59;a++)
{
gotoxy(a,b=10);
cprintf("Ä");
}//for loop ended
textbackground(7);
textcolor(8);
lowvideo();
gotoxy(44,8);
cprintf("HELP TOPICS   ");
textbackground(7);
textcolor(8);
lowvideo();
gotoxy(44,9);
cprintf("About......    ");
textbackground(BLACK);
for(b=7;b<12;b++)
{
gotoxy(61,b);
cprintf(" ");
}
for(a=45;a<61;a++)
{
gotoxy(a,11);
cprintf("  ");
}
} //If statement of HELP menu completed
}




/*************************************************************************
**/

			    /*EXIT MENU*/


/*************************************************************************
**/
EXIT1()
{
//for About.. menu
for(a=24;a<=48;a++)
{
for(b=16;b<=23;b++)
{
textbackground(1);
gotoxy(a,b);
cprintf("                         ");
}}
//For About.. menu completed

//IF statement for EXIT menu started
if(x>=520&&y==32&&x<=560&&y==32)
{
delay(100);
exit(0);
}//If statement for EXIT menu completed
}





/*************************************************************************
**/



/****************************ADD EMP.
RECORDS********************************/
ADD()
{
//If statement for ADD EMP. RECORDS
if(x>=32&&y==64&&x<=152&&y==64)
{
fp=fopen("medical1.dat","r+");
if(fp==NULL)
{
     fp=fopen("medical1.dat","w+");//file open for write only
	 if(fp==NULL)
	     {
	       printf("Cannot open file");
	     }
}

do
{
textcolor(WHITE);
textbackground(BLACK);
clrscr();
restrictmouseptr();
hidemouseptr();
_setcursortype(_SOLIDCURSOR);
textcolor(8+BLINK);
textbackground(7);
lowvideo();
gotoxy(3,1);
cprintf("                           NEW EMPLOYEE RECORD");
textcolor(7);
highvideo();
for(a=3;a<79;a++)
{
gotoxy(a,13);
cprintf("Û");
}
for(b=2;b<13;b++)
{
gotoxy(2,b);
cprintf("Û");
}
for(b=2;b<13;b++)
{
gotoxy(79,b);
cprintf("Û");
}
textcolor(10);
textbackground(BLACK);
highvideo();
gotoxy(3,2);
cprintf("Ú");
for(a=4;a<79;a++)
{
gotoxy(a,2);
cprintf("Ä");
}
gotoxy(78,2);
cprintf("¿");
for(b=3;b<12;b++)
{
gotoxy(3,b);
cprintf("³");
}
gotoxy(3,12);
cprintf("À");
for(a=4;a<78;a++)
{
gotoxy(a,12);
cprintf("Ä");
}
gotoxy(78,12);
cprintf("Ù");
for(b=3;b<12;b++)
{
gotoxy(78,b);
cprintf("³");
}

fseek(fp,0,SEEK_END);
gotoxy(4,4);
cprintf("Employee Name->");
gotoxy(4,6);
cprintf("Employee No.->");
gotoxy(4,8);
cprintf("Employee Dept.->");
gotoxy(4,10);
cprintf("Number of Members");
gotoxy(21,10);
textcolor(5);
cprintf("(Max. 5)->");

do
{
gotoxy(22,21);
textbackground(8);
cprintf("                                                 ");
textcolor(7);
gotoxy(19,4);
highvideo();
cprintf("                                                           ");
flag=1;
gotoxy(19,4);
fflush(stdin);
gets(e.empname);
if(strlen(e.empname)==0 || strlen(e.empname)>25)
{
flag=0;
gotoxy(22,21);
cprintf("THE NAME CAN NOT BE SET BLANK OR >25");
getch();
}
}while(!flag);

do
{
gotoxy(22,21);
textbackground(8);
cprintf("                                                 ");
flag=1;
gotoxy(18,6);
fflush(stdin);
gets(e.empno);
if(strlen(e.empno)==0)
{
flag=0;
gotoxy(22,21);
cprintf("THIS FIELD CANNOT BE LEFT BLANK");
getch();
}
}while(!flag);


do
{
gotoxy(22,21);
textbackground(8);
cprintf("                                                 ");
gotoxy(20,8);
cprintf("                                                          ");
flag=1;
gotoxy(20,8);
fflush(stdin);
gets(e.empdept);
if(strlen(e.empdept)==0 || strlen(e.empdept)>25)
{
flag=0;
gotoxy(22,21);
cprintf("EMP. DEPT. CAN NOT LEFT BLANK OR >25");
getch();
}
}while(!flag);

gotoxy(31,10);
scanf("%d",&member);

textcolor(YELLOW+BLINK);
textbackground(RED);
gotoxy(24,15);
cprintf("    MEMBERS  NAME    ");
/**textcolor(YELLOW);
textbackground(RED);
gotoxy(35,15);
cprintf(" Sex ");
textcolor(YELLOW);
textbackground(RED);
gotoxy(44,15);
cprintf(" Allergic To ");*/
gotoxy(1,16);
cprintf("");
for(a=0;a<member;a++)
{
fflush(stdin);
printf("			%d:",a+1);
scanf("%s",names[a]);
fflush(stdin);
strcpy(e.memname,names[a]);
fwrite(&e,sizeof(e),1,fp);
}
fclose(fp);
gotoxy(18,23);
textcolor(10);
textbackground(8);
highvideo();
cprintf("WANT TO ENTER MORE RECORDS(y/n)->");
another=getche();
}while(another=='y' || another=='Y');
gotoxy(15,25);
textcolor(10);
textbackground(4);
highvideo();
cprintf("  Press Esc to EXIT or M to Return to MAIN MENU.... ");
a=getch();
if(a==109)
{
main();
}
else
{
exit(0);
}
} //If statement of ADD EMP.records completed
}




/*************************************************************************
**/





/****************************NEW
ENTRY***************************************/
NEW()
{

//If statement for NEW ENTRY started
if(x>=32&&y==72&&x<=152&&y==72)
{
fp=fopen("medical1.dat","r+");
if(fp==NULL)
{
     fp=fopen("medical1.dat","w+");//file open for write only
	 if(fp==NULL)
	     {
	       printf("Cannot open file");
	     }
}
/*_AH=0;
   _AL=3;
   geninterrupt(0x10);
   if((*mode1 &0x30)== 0x30)
      scr=(char far*) 0xb0000000;     //0xb0000000;
   else
      scr=(char far*) 0xb8000000;
   begin:
   r=15;
   c=20;//upto here */

textcolor(WHITE);
textbackground(BLACK);
clrscr();
_setcursortype(_SOLIDCURSOR);
textcolor(8+BLINK);
textbackground(7);
lowvideo();
gotoxy(1,1);
cprintf("                             NEW ENTRY FOR EMPLOYEE");
restrictmouseptr2(112,456,128,168);
textcolor(5);
textbackground(BLACK);
highvideo();
gotoxy(1,2);
cprintf("Ú");
for(a=2;a<79;a++)
{
gotoxy(a,2);
cprintf("Ä");
}
gotoxy(79,2);
cprintf("¿");
for(b=3;b<13;b++)
{
gotoxy(1,b);
cprintf("³");
}
gotoxy(1,13);
cprintf("À");
for(a=2;a<79;a++)
{
gotoxy(a,13);
cprintf("Ä");
}
gotoxy(79,13);
cprintf("Ù");
for(b=3;b<13;b++)
{
gotoxy(79,b);
cprintf("³");
}
textcolor(10);
highvideo();
gotoxy(2,3);
cprintf("Employee Name->");
gotoxy(2,5);
cprintf("Employee No.->");
gotoxy(2,7);
cprintf("Employee Dept.->");

do
{
gotoxy(22,11);
textbackground(8);
cprintf("                                          ");
textcolor(7);
highvideo();
gotoxy(17,3);
cprintf("");                                           

fflush(stdin);
flag=1;
gotoxy(17,3);
gets(name3);
if(strlen(name3)==0 || strlen(name3)>25)
{
flag=0;
gotoxy(22,11);
cprintf("THE NAME CAN NOT BE LEFT BLANK OR >25");
getch();
}
}while(!flag);


do
{
gotoxy(22,11);
textbackground(8);
cprintf("                                            ");
fflush(stdin);
flag=1;
gotoxy(16,5);
gets(no);
if(strlen(no)==0)
{
flag=0;
gotoxy(22,11);
cprintf("THE EMP. No. FIELD CAN NOT BE LEFT BLANK");
getch();
}
}
while(!flag);

do
{
gotoxy(22,11);
textbackground(8);
cprintf("                                          ");
flag=1;
gotoxy(18,7);
gets(dept);
if(strlen(dept)==0)
{
flag=0;
gotoxy(22,11);
cprintf("THE EMP. DEPT. FIELD CAN NOT BE LEFT BLANK");
getch();
}
}while(!flag);
textcolor(6+BLINK);
textbackground(4);
highvideo();
gotoxy(14,15);
cprintf("               MEMBERS____NAME                ");
gotoxy(14,16);
printf("ÉÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍ»");
_setcursortype(_NOCURSOR);

rewind(fp);
while(fread(&e,sizeof(e),1,fp)==1)
{
if(strcmp(e.empno,no)==0)
{
len=strlen(e.memname);
for(a=0;a<=len;a++)
{
e.memname[a]=toupper(e.memname[a]);
}
printf("%s",e.memname);
}
}
fclose(fp);
for(b=17;b<=22;b++)
{
gotoxy(14,b);
printf("º");
}
for(b=17;b<=22;b++)
{
gotoxy(59,b);
printf("º");
}
gotoxy(14,23);
printf("ÈÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍÍ¼");
gotoxy(19,25);
textcolor(6);
textbackground(8);
highvideo();
cprintf(" Click on Member's name For Entry Form ");

/*while(ch!=13)
   {
      for(x=15;x<21;x++)
	 setattr(x,20,US);
      setattr(r,c,SE);
      gotoxy(36,21);
      ch=getch();
      if(ch=='H'||ch=='h')
      {
	 if(r==15)
	    r=15;
	 else
	    r--;
      }
      else if(ch=='P'||ch=='p')
      {
	 if(r==19)
	    r=19;
	 else
	    r++;
      }
      else if(ch=='1')
      {
	 r=4;
      }
      else if(ch=='2')
      {
	 r=5;
      }
      else if(ch=='3')
      {
	 r=6;
      }
      else if(ch=='4')
      {
	 r=7;
      }
      else if(ch=='5')
      {
	 r=8;
      }

   }

   ch=' ';
   y=r-14;*/

}//If statement for NEW RECORDS completed

}





/*************************************************************************
**/




/*****************************NEW ENTRY
FORM********************************/
ENTRY()
{
if((x>=112&&y==128&&x<=456&&y==128) || (x>=112&&y==136&&x<=456&&y==136) 
||
(x>=112&&y==144&&x<=456&&y==144) || (x>=112&&y==152&&x<=456&&y==152) ||
(x>=112&&y==160&&x<=456&&y==160) || (x>=112&&y==168&&x<=456&&y==168))
{
fs=fopen("medical3.dat","r+");
if(fs==NULL)
{
	fs=fopen("medical3.dat","w+");
	   if(fs==NULL)
	       {
		 printf("cannot open file");
	       }
}
textcolor(WHITE);
textbackground(8);
clrscr();
restrictmouseptr();
hidemouseptr();
_setcursortype(_SOLIDCURSOR);
textcolor(7);
textbackground(BLACK);
highvideo();
gotoxy(1,1);
cprintf("Ú");
for(a=2;a<79;a++)
{
gotoxy(a,1);
cprintf("Ä");
}
gotoxy(79,1);
cprintf("¿");
for(b=2;b<25;b++)
{
gotoxy(1,b);
cprintf("³");
}
gotoxy(1,25);
cprintf("À");
for(a=2;a<79;a++)
{
gotoxy(a,25);
cprintf("Ä");
}
gotoxy(79,25);
cprintf("Ù");
for(b=2;b<25;b++)
{
gotoxy(79,b);
cprintf("³");
}
gotoxy(2,2);
textcolor(BLACK+BLINK);
textbackground(WHITE);
lowvideo();
cprintf("                            PATIENT ENTRY FORM");
textcolor(10);
textbackground(8);
highvideo();
gotoxy(3,3);
cprintf("Ú");
gotoxy(4,2);
cprintf("ÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄ");
gotoxy(77,3);
cprintf("¿");
for(a=4;a<20;a++)
{
gotoxy(3,a);
cprintf("³");
}
for(b=4;b<20;b++)
{
gotoxy(77,b);
cprintf("³");
}
gotoxy(3,20);
cprintf("À");
gotoxy(77,20);
cprintf("Ù");
gotoxy(4,20);
cprintf("ÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄ");
for(a=3;a<21;a++)
{
gotoxy(2,a);
textcolor(7);
cprintf("Û");
}
for(a=3;a<21;a++)
{
gotoxy(78,a);
textcolor(7);
cprintf("Û");
}
for(a=2;a<79;a++)
{
gotoxy(a,21);
textcolor(7);
cprintf("Û");
}
fseek(fs,0,SEEK_END);
textcolor(10);
gotoxy(6,4);
cprintf("Employee Number #");
gotoxy(6,6);
cprintf("Date->");
gotoxy(6,8);
cprintf("Patient Name(if Emp. enter Emp.name)->");
gotoxy(6,10);
cprintf("Age->");
gotoxy(6,12);
cprintf("Sex(M/F)->");
gotoxy(6,14);
cprintf("");
gotoxy(6,16);
cprintf("Medicine Desc.->");
do
{
gotoxy(22,22);
textbackground(8);
cprintf("                                    ");
gotoxy(24,4);
flag=1;
fflush(stdin);
gets(s.empno2);
if(strlen(s.empno2)==0)
{
flag=0;
sound(2500);
delay(300);
nosound();
gotoxy(22,22);
cprintf("EMPLOYEE NO. CANNOT BE LEFT BLANK");
getch();}
}while(!flag);

do
{
gotoxy(22,22);
textbackground(8);
cprintf("                                       ");
gotoxy(12,6);
flag=1;
fflush(stdin);
gets(s.date);
if(strlen(s.date)==0)
{
flag=0;
sound(2500);
delay(300);
nosound();
gotoxy(22,22);
cprintf("DATE CAN NOT BE LEFT BLANK");
getch();
}
}while(!flag);


do
{
gotoxy(22,22);
textbackground(8);
cprintf("                                         ");
textcolor(7);
highvideo();
gotoxy(44,8);
cprintf("                                 ");
flag=1;
gotoxy(44,8);
fflush(stdin);
gets(s.patient);
if(strlen(s.patient)==0 || strlen(s.patient)>25)
{
flag=0;
sound(2500);
delay(300);
nosound();
gotoxy(22,22);
cprintf("PATIENT NAME CAN NOT BE LEFT BLANK OR >25");
getch();
}
}while(!flag);


gotoxy(11,10);
fflush(stdin);
scanf("%d",&s.age);


gotoxy(16,12);
fflush(stdin);
gets(s.sex);

do
{
gotoxy(22,22);
textbackground(8);
cprintf("                                         ");
flag=1;
gotoxy(22,16);
fflush(stdin);
gets(s.medicine);
if(strlen(s.medicine)==0)
{
flag=0;
sound(2500);
delay(300);
nosound();
gotoxy(22,22);
textcolor(10);
highvideo();
cprintf("THIS FIELD CAN NOT BE LEFT BLANK");
getch();
}
}while(!flag);
fwrite(&s,sizeof(s),1,fs);
fclose(fs);
textcolor(10);
highvideo();
textbackground(6);
gotoxy(12,24);
cprintf(" Press M to Return to "MAIN MENU" or Esc to "EXIT".....");
a=getch();
//a=getch();
if(a==109)
{
main();
}
else
{
exit(0);
}
}
}




/*************************************************************************
**/




/****************************SEARCH
RECORDS**********************************/
SEARCHEMP()
{
//If statement for SEARCH RECORDS started
if(x>=32&&y==80&&x<=152&&y==80)
{
fp=fopen("medical1.dat","r+");//file open for read only
if(fp==NULL)
{
     fp=fopen("medical1.dat","w+");//file open for write only
	 if(fp==NULL)
	     {
	       printf("Cannot open file");
	     }
}
fs=fopen("medical3.dat","r+");
if(fs==NULL)
{
	fs=fopen("medical3.dat","w+");
	   if(fs==NULL)
	       {
		 printf("cannot open file");
	       }
}
do
{
textcolor(WHITE);
textbackground(8);
clrscr();
restrictmouseptr();
hidemouseptr();
_setcursortype(_SOLIDCURSOR);
textcolor(BLACK+BLINK);
textbackground(7);
gotoxy(3,2);
cprintf("                    SEARCH PATIENT RECORD(For Emp. only)");
textcolor(10);
textbackground(BLACK);
gotoxy(3,3);
cprintf("ÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄ");
gotoxy(3,3);
cprintf("Ú");
gotoxy(77,3);
cprintf("¿");
for(a=4;a<20;a++)
{
gotoxy(3,a);
cprintf("³");
}
for(a=4;a<20;a++)
{
gotoxy(77,a);
cprintf("³");
}
gotoxy(3,20);
cprintf("À");
gotoxy(77,20);
cprintf("Ù");
gotoxy(4,20);
cprintf("ÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄ");

for(a=3;a<21;a++)
{
gotoxy(2,a);
textcolor(7);
cprintf("Û");
}
for(a=3;a<21;a++)
{
gotoxy(78,a);
textcolor(7);
cprintf("Û");
}
for(a=3;a<78;a++)
{
gotoxy(a,21);
textcolor(7);
cprintf("Û");
}
textcolor(10);
textbackground(BLACK);
highvideo();

do
{
gotoxy(21,21);
textbackground(8);
cprintf("                                        ");
flag=1;
gotoxy(4,4);
cprintf("Enter Emp. No.->");
fflush(stdin);
gets(id1);
if(strlen(id1)==0)
{
flag=0;
sound(2500);
delay(300);
nosound();
gotoxy(25,21);
cprintf("THIS FIELD CAN NOT BE LEFT BLANK");
getch();
}
}while(!flag);

do
{
gotoxy(21,21);
textbackground(8);
cprintf("                                        ");
flag=1;
gotoxy(4,5);
cprintf("Enter Date->");
fflush(stdin);
gets(dateemp);
if(strlen(dateemp)==0)
{
flag=0;
sound(2500);
delay(300);
nosound();
gotoxy(25,21);
cprintf("ENTER DATE OF RECORD ENTRY");
getch();
}
}while(!flag);

gotoxy(4,7);
cprintf("Enter Patient Name->");
fflush(stdin);
gets(nameemp);
textcolor(4);
gotoxy(4,9);
cprintf("ÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄ");
rewind(fp);
rewind(fs);
while((fread(&e,sizeof(e),1,fp)==1) && (fread(&s,sizeof(s),1,fs)==1))
{
if(strcmp(id1,s.empno2)==0 && strcmp(dateemp,s.date)==0 &&
strcmp(id1,e.empno)==0)
{
textcolor(6);
highvideo();
gotoxy(24,10);
cprintf("Employee Name->%s",e.empname);
gotoxy(24,11);
cprintf("Employee No.->%s",e.empno);
gotoxy(24,13);
textcolor(10);
cprintf("Patient Name->%s",s.patient);
gotoxy(24,14);
cprintf("Patient Age->%d",s.age);
gotoxy(24,15);
cprintf("Patient Sex->%s",s.sex);
gotoxy(24,16);
cprintf("Medicine given->%s",s.medicine);
//printf("ÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄ");
break;
}
}
fclose(fp);
fclose(fs);
textcolor(10);
highvideo();
if(strcmp(id1,s.empno2)!=0 && strcmp(dateemp,s.date)!=0 )
{
textcolor(10);
gotoxy(6,10);
cprintf("

 SORRY,RECORD NOT PRESENT");
}
gotoxy(22,21);
cprintf("

WANT TO SEARCH ANOTHER RECORD(y/n)->");
fflush(stdin);
another=getche();
}while((another=='y')||(another=='Y'));
textbackground(6);
textcolor(10+BLINK);
gotoxy(17,23);
cprintf("

 Press M to Return to Main Menu and Esc to Exit....");
a=getch();
if(a==109)
{
main();
}
else
{
exit(0);
}
}//If statement for SEARCH RECORDS completed
}





/*************************************************************************
**/





/***************************DELETE
RECORDS***********************************/
DELETEEMP()
{
//If statement for DELETE RECORDS started
if(x>=192&&y==64&&x<=304&&y==64)
{
fs=fopen("medical3.dat","r+");
if(fs==NULL)
{
	fs=fopen("medical3.dat","w+");
	   if(fs==NULL)
	       {
		 printf("cannot open file");
	       }
}
do
 {
 textbackground(8);
 textcolor(7);
 highvideo();
 clrscr();
 restrictmouseptr1();
 hidemouseptr();
 _setcursortype(_SOLIDCURSOR);
 textcolor(10);
 gotoxy(4,7);
 cprintf("Ú");
 gotoxy(77,7);
 cprintf("¿");
 for(a=8;a<20;a++)
 {
 gotoxy(4,a);
 cprintf("³");
 }
 for(a=8;a<20;a++)
 {
 gotoxy(77,a);
 cprintf("³");
 }
 gotoxy(4,20);
 cprintf("À");
 gotoxy(77,20);
 cprintf("Ù");
 textcolor(8+BLINK);
 textbackground(7);
 lowvideo();
 gotoxy(4,6);
 cprintf("                          DELETE  PATIENT  ENTRY
");
 textcolor(7);
 textbackground(8);
 highvideo();
 for(a=3;a<79;a++)
 {
 for(b=5;b<6;b++)
 {
 gotoxy(a,b);
 cprintf("Û");
 }}

 for(a=3;a<79;a++)
 {
 for(b=21;b<23;b++)
 {
 gotoxy(a,b);
 cprintf("Û");
 }}
 for(b=6;b<22;b++)
 {
 gotoxy(3,b);
 cprintf("Û");
 }
 for(b=6;b<22;b++)
 {
 gotoxy(78,b);
 cprintf("Û");
 }
 textcolor(10);
 highvideo();
 gotoxy(5,7);

cprintf("ÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄ
ÄÄÄÄÄÄÄ");
 gotoxy(5,20);

cprintf("ÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄ
ÄÄÄÄÄÄÄ");
 textcolor(10);
 highvideo();
 gotoxy(6,9);
 cprintf("Enter Employee No.->");
 fflush(stdin);
 gets(del1);
 gotoxy(6,10);
 cprintf("Enter Patient Name->");
 fflush(stdin);
 gets(petname);
 gotoxy(6,11);
 cprintf("Enter Date->");
 fflush(stdin);
 gets(dates);
 fps=fopen("medical4.dat","w+");
 rewind(fs);
 while(fread(&s,sizeof(s),1,fs)==1)
 {
 if(strcmp(s.empno2,del1)!=0 && strcmp(s.date,dates)!=0 &&
strcmp(s.patient,petname)!=0)
 fwrite(&s,sizeof(s),1,fps);
 }
 fclose(fs);
 fclose(fps);
 remove("medical3.dat");
 rename("medical4.dat","medical3.dat");
 fs=fopen("medical3.dat","r+");
 gotoxy(24,12);
 cprintf("RECORD DELETED SUCCESSFULY");
 gotoxy(18,14);
 cprintf("WANT TO DELETE ANOTHER RECORD(y/n)->");
 fflush(stdin);
 another2=getche();
 }while((another2=='y')||(another2=='Y'));
 gotoxy(16,19);
 textbackground(6);
 cprintf(" Press M to Return to Main Menu or Esc to Exit.... ");
 a=getch();
if(a==109)
{
main();
}
else
{
exit(0);
}
}//If statement for DELETE RECORDS completed
}




/*************************************************************************
**/






/**************************UPDATE
RECORDS************************************/
UPDATEEMP()
{
//If statement for UPDATE RECORDS started
if(x>=192&&y==72&&x<=304&&y==72)
{
textcolor(1);
textbackground(6);
clrscr();

}//If statement for UPDATE RECORDS completed


}



/*************************************************************************
***/





/***********************For outsiders PATIENT
ENTRY*************************/
OUTENTRY()
{
if(x>=32&&y==104&&x<=152&&y==104)
{
ft=fopen("medical2.dat","r+");
if(ft==NULL)
{
	 ft=fopen("medical2.dat","w+");
	     if(ft==NULL)
		{
		 printf("cannot open file");
		}
}
do
{
textcolor(WHITE);
textbackground(8);
clrscr();
restrictmouseptr();
hidemouseptr();
_setcursortype(_SOLIDCURSOR);
textcolor(7);
textbackground(BLACK);
highvideo();
gotoxy(1,1);
cprintf("Ú");
for(a=2;a<79;a++)
{
gotoxy(a,1);
cprintf("Ä");
}
gotoxy(79,1);
cprintf("¿");
for(b=2;b<25;b++)
{
gotoxy(1,b);
cprintf("³");
}
gotoxy(1,25);
cprintf("À");
for(a=2;a<79;a++)
{
gotoxy(a,25);
cprintf("Ä");
}
gotoxy(79,25);
cprintf("Ù");
for(b=2;b<25;b++)
{
gotoxy(79,b);
cprintf("³");
}
gotoxy(2,2);
textcolor(BLACK+BLINK);
textbackground(WHITE);
lowvideo();
cprintf("                            OUTSIDER PATIENT ENTRY
");
textcolor(10);
textbackground(8);
highvideo();
gotoxy(3,3);
cprintf("Ú");
gotoxy(4,2);
cprintf("
ÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄ
ÄÄÄÄÄÄÄÄÄÄ");
gotoxy(77,3);
cprintf("¿");
for(a=4;a<20;a++)
{
gotoxy(3,a);
cprintf("³");
}
for(a=4;a<20;a++)
{
gotoxy(77,a);
cprintf("³");
}
gotoxy(3,20);
cprintf("À");
gotoxy(77,20);
cprintf("Ù");
gotoxy(4,20);
cprintf("ÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄ
ÄÄÄÄÄÄÄÄ");
for(a=3;a<21;a++)
{
gotoxy(2,a);
textcolor(7);
cprintf("Û");
}
for(a=3;a<21;a++)
{
gotoxy(78,a);
textcolor(7);
cprintf("Û");
}
for(a=2;a<79;a++)
{
gotoxy(a,21);
textcolor(7);
cprintf("Û");
}
textcolor(10);
fseek(ft,0,SEEK_END);
gotoxy(6,4);
cprintf("Patient Number #");
gotoxy(6,6);
cprintf("Date->");
gotoxy(6,8);
cprintf("Patient Name->");
gotoxy(6,10);
cprintf("Age->");
gotoxy(6,12);
cprintf("Sex(M/F)->");
gotoxy(6,14);
cprintf("");
gotoxy(6,16);
cprintf("Medicine Desc.->");
do
{
gotoxy(22,22);
textbackground(8);
cprintf("                                    ");
gotoxy(22,4);
flag=1;
fflush(stdin);
gets(out.patientno);
if(strlen(out.patientno)==0)
{
flag=0;
sound(2500);
delay(300);
nosound();
gotoxy(22,22);
cprintf("PATIENT NO. CANNOT BE LEFT BLANK");
getch();}
}while(!flag);

do
{
gotoxy(22,22);
textbackground(8);
cprintf("                                       ");
gotoxy(12,6);
flag=1;
fflush(stdin);
gets(out.date);
if(strlen(out.date)==0)
{
flag=0;
sound(2500);
delay(300);
nosound();
gotoxy(22,22);
cprintf("DATE CAN NOT SET BLANK");
getch();
}
}while(!flag);


do
{
gotoxy(22,22);
textbackground(8);
cprintf("                                         ");
textcolor(7);
highvideo();
gotoxy(20,8);
cprintf("                                                         ");
flag=1;
gotoxy(20,8);
fflush(stdin);
gets(out.patient);
if(strlen(out.patient)==0 || strlen(out.patient)>25)
{
flag=0;
sound(2500);
delay(300);
nosound();
gotoxy(22,22);
cprintf("PATIENT NAME CAN NOT SET BLANK OR >25");
getch();
}
}while(!flag);


gotoxy(11,10);
fflush(stdin);
scanf("%d",&out.age);


gotoxy(16,12);
fflush(stdin);
gets(out.sex1);

do
{
gotoxy(22,22);
textbackground(8);
cprintf("                                         ");
flag=1;
gotoxy(22,16);
fflush(stdin);
gets(out.medicine);
if(strlen(out.medicine)==0)
{
flag=0;
sound(2500);
delay(300);
nosound();
gotoxy(22,22);
textcolor(10);
highvideo();
cprintf("THIS FIELD CAN NOT BE SET BLANK");
getch();
}
}while(!flag);
fwrite(&out,sizeof(out),1,ft);
fclose(ft);
textcolor(10);
highvideo();
gotoxy(22,22);
cprintf("WANT TO ENTER ANOTHER RECORD->");
fflush(stdin);
another1=getche();
}while((another1=='y')||(another1=='Y'));
textbackground(6);
gotoxy(12,24);
cprintf(" Press M to Return to "MAIN MENU" or Esc to "EXIT".....
");
a=getch();
if(a==109)
{
main();
}
else
{
exit(0);
}
}//If statement for Outsiders Patient entry completed
}

/*************************************************************************
**/




/************************SEARCH RECORDS For
Outsiders***********************/
SEARCHOUT()
{
if(x>=32&&y==112&&x<=152&&y==112)
{
ft=fopen("medical2.dat","r+");
if(ft==NULL)
{
	 ft=fopen("medical2.dat","w+");
	     if(ft==NULL)
		{
		 printf("cannot open file");
		}
}
do
{
textcolor(WHITE);
textbackground(8);
clrscr();
restrictmouseptr();
hidemouseptr();
_setcursortype(_SOLIDCURSOR);
textcolor(BLACK+BLINK);
textbackground(7);
gotoxy(3,2);
cprintf("                          SEARCH OUTSIDER PATIENT RECORD
");
textcolor(10);
textbackground(BLACK);
gotoxy(3,3);
cprintf("ÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄ
ÄÄÄÄÄÄÄÄÄ");
gotoxy(3,3);
cprintf("Ú");
gotoxy(77,3);
cprintf("¿");
for(a=4;a<20;a++)
{
gotoxy(3,a);
cprintf("³");
}
for(a=4;a<20;a++)
{
gotoxy(77,a);
cprintf("³");
}
gotoxy(3,20);
cprintf("À");
gotoxy(77,20);
cprintf("Ù");
gotoxy(4,20);
cprintf("ÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄ
ÄÄÄÄÄÄÄÄ");

for(a=3;a<21;a++)
{
gotoxy(2,a);
textcolor(7);
cprintf("Û");
}
for(a=3;a<21;a++)
{
gotoxy(78,a);
textcolor(7);
cprintf("Û");
}
for(a=3;a<78;a++)
{
gotoxy(a,21);
textcolor(7);
cprintf("Û");
}
textcolor(10);
textbackground(BLACK);
highvideo();

do
{
gotoxy(21,21);
textbackground(8);
cprintf("                                        ");
flag=1;
gotoxy(4,4);
cprintf("Enter Patient No.->");
fflush(stdin);
gets(id);
if(strlen(id)==0)
{
flag=0;
sound(2500);
delay(300);
nosound();
gotoxy(25,21);
cprintf("THIS FIELD CAN NOT BE LEFT BLANK");
getch();
}
}while(!flag);

do
{
gotoxy(21,21);
textbackground(8);
cprintf("                                        ");
flag=1;
gotoxy(4,5);
cprintf("
Enter Date->");
fflush(stdin);
gets(date1);
if(strlen(date1)==0)
{
flag=0;
sound(2500);
delay(300);
nosound();
gotoxy(25,21);
cprintf("ENTER DATE OF RECORD ENTRY");
getch();
}
}while(!flag);

gotoxy(4,7);
cprintf("
Enter Patient Name->");
fflush(stdin);
gets(name1);
textcolor(4);
gotoxy(4,9);
cprintf("ÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄ
ÄÄÄÄÄÄÄÄ");
rewind(ft);
while(fread(&out,sizeof(out),1,ft)==1)
{
if(strcmp(id,out.patientno)==0)
{
textcolor(10);
textbackground(8);
highvideo();
gotoxy(6,8);
fflush(stdin);
cprintf("

Patient Name->%s",out.patient);
gotoxy(6,10);
cprintf("

Patient Age->%d",out.age);
gotoxy(6,12);
fflush(stdin);
cprintf("

Patient Sex->%s",out.sex1);
gotoxy(6,14);
fflush(stdin);
cprintf("

Medicine given->%s",out.medicine);
}
}
textcolor(10);
highvideo();
if(strcmp(id,out.patientno)!=0)
{
textcolor(10);
gotoxy(6,10);
cprintf("

 SORRY,RECORD NOT PRESENT");
}

fclose(ft);
gotoxy(22,21);
cprintf("

WANT TO SEARCH ANOTHER RECORD(y/n)->");
fflush(stdin);
another=getche();
}while((another=='y')||(another=='Y'));
textbackground(6);
textcolor(10+BLINK);
gotoxy(17,23);
cprintf("

 Press M to Return to Main Menu and Esc to Exit....");
a=getch();
if(a==109)
{
main();
}
else
{
exit(0);
}
}
}




/*************************************************************************
**/




/*****************************UPDATE RECORD FOR
Outsiders********************/
 UPDATEOUT()
{
 if(x>=192&&y==96&&x<=304&&y==96)
 {
 ft=fopen("medical2.dat","r+");
if(ft==NULL)
{
	 ft=fopen("medical2.dat","w+");
	     if(ft==NULL)
		{
		 printf("cannot open file");
		}
}
 do
 {
 textcolor(7);
 textbackground(8);
 clrscr();
 restrictmouseptr();
 hidemouseptr();
 _setcursortype(_SOLIDCURSOR);
 textcolor(7);
 highvideo();
 printf("Enter Patient No to Modify->");
 fflush(stdin);
 gets(updateno);
 printf("

Enter Patient Name->");
 fflush(stdin);
 gets(update);
 clrscr();
 rewind(ft);
while(fread(&out,sizeof(out),1,ft)==1)
{
 if(strcmp(updateno,out.patientno)==0)
 {
gotoxy(2,2);
textcolor(BLACK+BLINK);
textbackground(WHITE);
lowvideo();
cprintf("                            UPDATE PATIENT ENTRY
");
textcolor(10);
textbackground(8);
highvideo();
gotoxy(3,3);
cprintf("Ú");
gotoxy(4,2);
cprintf("
ÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄ
ÄÄÄÄÄÄÄÄÄÄ");
gotoxy(77,3);
cprintf("¿");
for(a=4;a<20;a++)
{
gotoxy(3,a);
cprintf("³");
}
for(a=4;a<20;a++)
{
gotoxy(77,a);
cprintf("³");
}
gotoxy(3,20);
cprintf("À");
gotoxy(77,20);
cprintf("Ù");
gotoxy(4,20);
cprintf("ÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄ
ÄÄÄÄÄÄÄÄ");
for(a=3;a<21;a++)
{
gotoxy(2,a);
textcolor(7);
cprintf("Û");
}
for(a=3;a<21;a++)
{
gotoxy(78,a);
textcolor(7);
cprintf("Û");
}
for(a=2;a<79;a++)
{
gotoxy(a,21);
textcolor(7);
cprintf("Û");
}
//textcolor(10);
//textbackground(8);
gotoxy(6,4);
cprintf("Patient Number #");
gotoxy(6,6);
cprintf("Date->");
gotoxy(6,8);
cprintf("Patient Name->");
gotoxy(6,10);
cprintf("Age->");
gotoxy(6,12);
cprintf("Sex(M/F)->");
gotoxy(6,14);
cprintf("");
gotoxy(6,16);
cprintf("Medicine Desc.->");
do
{
gotoxy(22,22);
textbackground(8);
cprintf("                                    ");
gotoxy(22,4);
flag=1;
fflush(stdin);
gets(out.patientno);
if(strlen(out.patientno)==0)
{
flag=0;
sound(2500);
delay(300);
nosound();
gotoxy(22,22);
cprintf("PATIENT NO. CANNOT BE LEFT BLANK");
getch();}
}while(!flag);

do
{
gotoxy(22,22);
textbackground(8);
cprintf("                                       ");
gotoxy(12,6);
flag=1;
fflush(stdin);
gets(out.date);
if(strlen(out.date)==0)
{
flag=0;
sound(2500);
delay(300);
nosound();
gotoxy(22,22);
cprintf("DATE CAN NOT SET BLANK");
getch();
}
}while(!flag);


do
{
gotoxy(22,22);
textbackground(8);
cprintf("                                         ");
textcolor(7);
highvideo();
gotoxy(20,8);
cprintf("                                                         ");
flag=1;
gotoxy(20,8);
fflush(stdin);
gets(out.patient);
if(strlen(out.patient)==0 || strlen(out.patient)>25)
{
flag=0;
sound(2500);
delay(300);
nosound();
gotoxy(22,22);
cprintf("PATIENT NAME CAN NOT SET BLANK OR >25");
getch();
}
}while(!flag);


gotoxy(11,10);
fflush(stdin);
scanf("%d",&out.age);


gotoxy(16,12);
fflush(stdin);
gets(out.sex1);

do
{
gotoxy(22,22);
textbackground(8);
cprintf("                                         ");
flag=1;
gotoxy(22,16);
fflush(stdin);
gets(out.medicine);
if(strlen(out.medicine)==0)
{
flag=0;
sound(2500);
delay(300);
nosound();
gotoxy(22,22);
textcolor(10);
highvideo();
cprintf("THIS FIELD CAN NOT BE SET BLANK");
getch();
}
}while(!flag);
fseek(ft,sizeof(out),SEEK_CUR);
fwrite(&out,sizeof(out),1,ft);
break;
     }
}
fclose(ft);
textcolor(10);
highvideo();
gotoxy(22,22);
cprintf("WANT TO MODIFY ANOTHER RECORD->");
fflush(stdin);
another1=getche();
}while((another1=='y')||(another1=='Y'));
textbackground(6);
gotoxy(12,24);
cprintf(" Press M to Return to "MAIN MENU" or Esc to "EXIT".....
");
a=getch();
if(a==109)
{
main();
}
else
{
exit(0);
}
}//If statement for Outsiders Patient entry completed
}







/*************************************************************************
**/




/***************************Delete records Form For
outsiders***************/
 DELETEOUT()
{
 if(x>=192&&y==88&&x<=304&&y==88)
 {
 ft=fopen("medical2.dat","r+");
if(ft==NULL)
{
	 ft=fopen("medical2.dat","w+");
	     if(ft==NULL)
		{
		 printf("cannot open file");
		}
}
 do
 {
 textbackground(8);
 textcolor(7);
 highvideo();
 clrscr();
 restrictmouseptr1();
 hidemouseptr();
 _setcursortype(_SOLIDCURSOR);
 textcolor(10);
 gotoxy(4,7);
 cprintf("Ú");
 gotoxy(77,7);
 cprintf("¿");
 for(a=8;a<20;a++)
 {
 gotoxy(4,a);
 cprintf("³");
 }
 for(a=8;a<20;a++)
 {
 gotoxy(77,a);
 cprintf("³");
 }
 gotoxy(4,20);
 cprintf("À");
 gotoxy(77,20);
 cprintf("Ù");
 textcolor(8+BLINK);
 textbackground(7);
 lowvideo();
 gotoxy(4,6);
 cprintf("                      DELETE OUTSIDER PATIENT RECORD
");
 textcolor(7);
 textbackground(8);
 highvideo();
 for(a=3;a<79;a++)
 {
 for(b=5;b<6;b++)
 {
 gotoxy(a,b);
 cprintf("Û");
 }}

 for(a=3;a<79;a++)
 {
 for(b=21;b<23;b++)
 {
 gotoxy(a,b);
 cprintf("Û");
 }}
 for(b=6;b<22;b++)
 {
 gotoxy(3,b);
 cprintf("Û");
 }
 for(b=6;b<22;b++)
 {
 gotoxy(78,b);
 cprintf("Û");
 }
 textcolor(10);
 highvideo();
 gotoxy(5,7);

cprintf("ÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄ
ÄÄÄÄÄÄÄ");
 gotoxy(5,20);

cprintf("ÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄ
ÄÄÄÄÄÄÄ");
 textcolor(10);
 highvideo();
 gotoxy(6,9);
 cprintf("Enter Patient No. to Delete->");
 fflush(stdin);
 gets(del);
 fpt=fopen("medical6.dat","w+");
 rewind(ft);
 while(fread(&out,sizeof(out),1,ft)==1)
 {
 if(strcmp(out.patientno,del)!=0)
 fwrite(&out,sizeof(out),1,fpt);
 }
 fclose(ft);
 fclose(fpt);
 remove("medical2.dat");
 rename("medical6.dat","medical2.dat");
 ft=fopen("medical2.dat","r+");
 fclose(ft);
 //fclose(fpt);
 gotoxy(24,12);
 cprintf("RECORD DELETED SUCCESSFULY");
 gotoxy(18,14);
 cprintf("WANT TO DELETE ANOTHER RECORD(y/n)->");
 fflush(stdin);
 another2=getche();
 }while((another2=='y')||(another2=='Y'));
 gotoxy(16,19);
 textbackground(6);
 cprintf(" Press M to Return to Main Menu or Esc to Exit.... ");
 a=getch();
if(a==109)
{
main();
}
else
{
exit(0);
}
}
}




/*************************************************************************
**/






/****************************HELP
TOPICS*************************************/
HELPTOPICS()
{
//IF statement for HELP TOPICS started
if(x>=344&&y==56&&x<=456&&y==56)
{
textbackground(1);
textcolor(10);
clrscr();
restrictmouseptr();
hidemouseptr();
lowvideo();
_setcursortype(_NOCURSOR);
textcolor(YELLOW+BLINK);
textbackground(4);
gotoxy(1,1);
cprintf("              WELCOME TO MEDICAL RECORD KEEPING SYSTEM " 
HELP
"                 ");
textcolor(10);
textbackground(1);
highvideo();
gotoxy(2,3);
cprintf("This system is built using mouse programming and drop down
menus.");
gotoxy(2,4);
cprintf("In this system you can Enter 'n' No. of Records.");
gotoxy(2,6);
cprintf("1First option "FILE" can be selected by clicking on 
it.Click
event will show a drop down menu,in which you can select any one of the
options.First       option is " ADD EMP .RECORD " which is used to 
add
details about employee.The   second option is" NEW ENTRY "which is
used to enter the new record about        patient.The third option is
"SEARCH RECORD" which is used to search the record  of any 
patient.");
gotoxy(2,13);
cprintf("2Second menu is "EDIT",can be selected by clicking on 
it.the
First option in   drop down menu is"DELETE RECORD"which is used to
delete a particular record of  any patient.The second option 
is"SEARCH
RECORD" which is used to search the     record of a particular 
patient.
");
gotoxy(2,18);
cprintf("3Third menu is "HELP",which provide you information about
using the system.");
gotoxy(2,20);
cprintf("4Fourth menu is "EXIT", used to quit from the system");
textcolor(YELLOW);
textbackground(RED);
highvideo();
gotoxy(2,25);
cprintf("              Press Esc key to quit or M to return to Main
Menu...            ");
a=getch();
if(a==109)
{
for(a=25;a>0;a--)
{
delay(10);
textbackground(8);
gotoxy(1,a);
cprintf("
");
}
main();
}
else
{
for(a=25;a>0;a--)
{
delay(10);
textbackground(8);
gotoxy(1,a);
cprintf("
");
}
exit(0);
}
}
}



/*************************************************************************
**/




/********************************About....********************************
***/
ABOUT()
{
if(x>=344&&y==64&&x<=456&&y==64)
{
//For HELP menu
gotoxy(47,5);
textcolor(BLACK);
textbackground(RED);
cprintf(" HELP ");
gotoxy(42,6);
highvideo();
textcolor(WHITE);
textbackground(1);
cprintf("ÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄÄ");
for(b=7;b<13;b++)
{
gotoxy(41,b);
textbackground(1);
cprintf("                        ");
}//HELP menu ended

textcolor(10);
textbackground(RED);
highvideo();
for(a=25;a<=47;a++)
{
gotoxy(a,17);
cprintf("Ä");
}
gotoxy(39,48);
cprintf("¿");
gotoxy(24,17);
cprintf("Ú");

for(b=18;b<23;b++)
{
gotoxy(24,b);
cprintf("³");
}
gotoxy(24,23);
cprintf("À");
for(a=25;a<48;a++)
{
gotoxy(a,b=23);
cprintf("Ä");
}
gotoxy(48,23);
cprintf("Ù");
for(b=18;b<23;b++)
{
gotoxy(a=48,b);
cprintf("³");
}
gotoxy(25,18);
cprintf("      CREATED BY-:     ");
gotoxy(25,19);
cprintf("                       ");
gotoxy(25,20);
cprintf("    ABCDEF   ");
gotoxy(25,21);
cprintf("      INDIA     ");
gotoxy(25,22);
cprintf("    BANGLORE     ");
}
}
