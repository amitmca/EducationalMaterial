#include <dos.h>
#include <graphics.h>
union REGS in, out;
void detectmouse ()


{
 in.x.ax = 0;
 int86 (0X33,&in,&out);
 if (out.x.ax == 0)
 printf ("\nMouse Fail To Initialize");
 else
 printf ("\nMouse Succesfully Initialize");
}void showmousetext ()


{
  in.x.ax = 1;
  int86 (0X33,&in,&out);
}
void showmousegraphics ()


{
  int gdriver = DETECT, gmode, errorcode;
  initgraph(&gdriver, &gmode, "c:\\tc\\bgi");
  in.x.ax = 1;
  int86 (0X33,&in,&out);
  getch ();
  closegraph ();
}
void hidemouse ()


{
 in.x.ax = 2;
 int86 (0X33,&in,&out);
}
void detect ()


{
 while (!kbhit () )
  {
   in.x.ax = 3;
   int86 (0X33,&in,&out);
   if (out.x.bx == 1) printf ("Left");
   if (out.x.bx == 2) printf ("Right");
   if (out.x.bx == 3) printf ("Middle");
   delay (100); // Otherwise due to quick computer response 100s of words will get print
  }
}

int main ()
{
  detectmouse ();
  showmousetext ();
  detect ();
  hidemouse ();
  getch ();
  return 0;
}