//Program to print the output as OUTPUT
#include <graphics.h>
#include <stdlib.h>
#include <stdio.h>
#include <conio.h>

int main(void)
{
   int gd= DETECT, gm;
   int left, top, right, bottom;
   initgraph(&gd, &gm, "");
   left = getmaxx() / 2 - 50;
   top = getmaxy() / 2 - 50;
   right = getmaxx() / 2 + 50;
   bottom = getmaxy() / 2 + 50;
   setcolor(5);
   line(left,top,right,bottom);
   setcolor(3);
   rectangle(left,top,right,bottom);
   setcolor(2);
    line(right,top,left,bottom);

   getch();
   closegraph();
   return 0;
}
