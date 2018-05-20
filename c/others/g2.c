#include<conio.h>
#include<graphics.h>
main()
	{
	int gd=DETECT,gm,i;
	initgraph(&gd,&gm,"");
	setcolor(4);
	for(i=0;i<15;i++)
		{
		setbkcolor(i);
		outtextxy(100,200,"AMIT");
		delay(1000);
		}
	getch();
	closegraph();
	return 0;
	}