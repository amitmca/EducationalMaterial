//Program for changing the background color for every second
#include<graphics.h>
main()
	{
	int gd=DETECT,gm,i;
	initgraph(&gd,&gm," ");
	while(!kbhit())
	{
	for(i=0;i<=15;i++)
		{
		setbkcolor(i);
		delay(1000);
		cleardevice();
		}
	}
	closegraph();
	}
