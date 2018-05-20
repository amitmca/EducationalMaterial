//Program for drawing 3 concentric circles in a Rectangle
#include<graphics.h>
#include <stdlib.h>
#include <stdio.h>
#include <conio.h>
int main(void)
	{
	int gd=DETECT,gm;
	initgraph(&gd,&gm," ");
	rectangle(200,200,50,50);
	circle(125,125,55);
	circle(125,125,35);
	circle(125,125,15);
	getch();
	closegraph();
	return 0;
	}
	kbhit()