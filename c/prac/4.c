//Program to blink the text on screen
#include<graphics.h>
#include<stdio.h>
#include<conio.h>
main()
	{
	int gd=DETECT,gm;
	initgraph(&gd,&gm," ");
	cleardevice();
	while(!kbhit())
		{
		cleardevice();
		outtextxy(100,100,"Amit");
		delay(500);
		cleardevice();
		delay(200);
		}
	return 0;
	}