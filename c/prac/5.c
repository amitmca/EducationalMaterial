#include<stdio.h>
#include<conio.h>
#include<graphics.h>
#include<dos.h>
void main()
{
	int gd=DETECT,gm,i,mt,hr;
	initgraph(&gd,&gm,"");
	cleardevice();
	i=90;
	mt=90;
	hr=90;
	while(!kbhit())
	{
		circle(200,200,75);
		pieslice(200, 200,i,i+1,50);
		pieslice(200, 200,mt,mt+1,50);
		pieslice(200, 200,hr,hr+1,40);
		i=i-6;
		if(i==90)
		{
			mt=mt-6;
			if(mt==90)
				hr=hr-6;
		}
		if(i<0)
			i=360;
			if(mt<0)
			mt=360;
		if(hr<0)
		hr=360;
		outtextxy(200-2,200-58,"12");
		outtextxy(200+58,200,"3");
		outtextxy(200-58,200,"9");
		outtextxy(200-2,200+58,"6");
		delay(100);
		cleardevice();
	}
	getch();
	closegraph();
}
