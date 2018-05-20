#include<conio.h>
#include<graphics.h>
main()
	{
	int gd=DETECT,gm,i,x,maxx;
	initgraph(&gd,&gm,"");
	maxx=getmaxx();
	for(x=0;x<maxx;x++)
	{
	for(i=0;i<15;i++)
		{
		setcolor(i);
		outtextxy(x,200,"AMIT");
		delay(1000);
		}
	}
	getch();
	closegraph();
	return 0;
	}