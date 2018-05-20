//Program to move the text left,right,up and down
#include<graphics.h>
main()
	{
	int gd=DETECT,gm,y,i,x,c;
	do
	{
		printf("\n ********* MENU **********\n\n");
		printf("\n 1. Move Text From LEFT To RIGHT\n");
		printf("\n 2. Move Text From RIGHT To LEFT\n");
		printf("\n 3. Move Text From UP To DOWN\n");
		printf("\n 4. Move Text From DOWN To UP\n");
		printf("\n 5. Exit\n");
		printf("\n SELECT YOUR CHOICE:==>");
		scanf("%d",&c);
		switch(c)
			{
			case 1:
			initgraph(&gd,&gm,"c:\tc\bgi");
			y=getmaxy()/2;
			while(!kbhit())
				{
				for(i=0;i<=600;i=i+20)
					{
					setcolor(RED);
					setbkcolor(BLUE);
					outtextxy(i,y,"L TO R");
					delay(100);
					cleardevice();
					}
				}
			closegraph();
			break;

			case 2:
			initgraph(&gd,&gm," ");
			y=getmaxy()/2;
			while(!kbhit())
				{
				for(i=600;i>=0;i=i-20)
					{
					setcolor(RED);
					setbkcolor(BLUE);
					outtextxy(i,y,"R TO L");
					delay(100);
					cleardevice();
					}
				}
			closegraph();
			break;

			case 3:
			initgraph(&gd,&gm," ");
			x=getmaxx()/2;
			while(!kbhit())
				{
				for(i=0;i<=400;i=i+20)
					{
					setcolor(RED);
					setbkcolor(BLUE);
					outtextxy(x,i,"UP TO DOWN");
					delay(100);
					cleardevice();
					}
				}
			closegraph();
			break;

			case 4:
			initgraph(&gd,&gm," ");
			x=getmaxx()/2;
			while(!kbhit())
				{
				for(i=400;i>=0;i=i-20)
					{
					setcolor(RED);
					setbkcolor(BLUE);
					outtextxy(x,i,"DOWN TO UP");
					delay(100);
					cleardevice();
					}
				}
			closegraph();
			break;

			case 5:
			exit(0);
			break;
			}
		}while(c!=5);
	return 0;
	}