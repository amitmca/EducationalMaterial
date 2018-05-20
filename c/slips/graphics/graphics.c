#include<graphics.h>
#include<conio.h>
main()
	{
	int gm,x,y,gd=DETECT;
	clrscr();
	initgraph(&gd,&gm," ");
	x=getmaxx();
	y=getmaxy();
	rectangle(100,50,200,100);
	setcolor(BLUE);
	circle(x/2,y/2,75);
	setcolor(RED);
	settextjustify(1,1);
	outtext("WELCOME");
	setcolor(YELLOW);
	ellipse(x/2,y/2,0,360,100,50);
	getch();
	closegraph();
	restorecrtmode();
	return 0;
	}
