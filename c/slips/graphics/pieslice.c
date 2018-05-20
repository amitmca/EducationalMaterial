#include<stdio.h>
#include<conio.h>
#include<graphics.h>
void main()
	{
	int gd=DETECT,gm,x,y,maxx,maxy,i;
	initgraph(&gd,&gm," ");
	maxx=getmaxx();
	x=getmaxx()/2;
	y=getmaxy()/2;
	for(i=50;i<maxx;i=i+5)
		{
		pieslice(x,y,0,i,100);
		delay(500);
		}
	getch();
	}