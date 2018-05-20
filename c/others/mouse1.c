 
#include <dos.h>
union REGS in, out;
void detectmouse ()
{
 in.x.ax = 0;
 int86 (0X33,&in,&out);
 if (out.x.ax == 0)
 printf ("\nMouse Fail To Initialize");
 else
 printf ("\nMouse Succesfully Initialize");
}
void showmousetext ()


{
 in.x.ax = 1;
 int86 (0X33,&in,&out);
}

int main ()
{
 detectmouse ();
 showmousetext();
 getch ();
 return 0;

}

