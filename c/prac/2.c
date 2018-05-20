//Program for marquee scrolling a ball from top to bottom
#include<graphics.h>
main()
	{
	int gd=DETECT,gm,i,y;
	initgraph(&gd,&gm," ");
	while(!kbhit())
	{
	for(i=0;i<=400;i=i+20)
		{
		setbkcolor(BLUE);
		setcolor(RED);
		circle(20,i,20);
		delay(500);
		cleardevice();
		}
	}
	closegraph();
	}
