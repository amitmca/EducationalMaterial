//Program to move the circle left,right,up and down
#include<graphics.h>
#include<conio.h>
main()
	{
	int gd=DETECT,gm,y,i,x,c;
	clrscr();
	do
	{
		printf("\n ********* MENU **********\n\n");
		printf("\n 1. Move CIRCLE From LEFT To RIGHT\n");
		printf("\n 2. Move CIRCLE From RIGHT To LEFT\n");
		printf("\n 3. Move CIRCLE From UP To DOWN\n");
		printf("\n 4. Move CIRCLE From DOWN To UP\n");
		printf("\n 5. Exit\n");
		printf("\n SELECT YOUR CHOICE:==>");
		scanf("%d",&c);
		switch(c)
			{
			case 1:
			initgraph(&gd,&gm," ");
			while(!kbhit())
				{
				for(i=0;i<=600;i=i+20)
					{
					setcolor(RED);
					setbkcolor(BLUE);
					circle(i,20,20);
					delay(100);
					cleardevice();
					}
				}
			closegraph();
			break;

			case 2:
			initgraph(&gd,&gm," ");
			while(!kbhit())
				{
				for(i=600;i>=0;i=i-20)
					{
					setcolor(RED);
					setbkcolor(BLUE);
					circle(i,20,20);
					delay(100);
					cleardevice();
					}
				}
			closegraph();
			break;

			case 3:
			initgraph(&gd,&gm," ");
			while(!kbhit())
				{
				for(i=0;i<=400;i=i+20)
					{
					setcolor(RED);
					setbkcolor(BLUE);
					circle(20,i,20);
					delay(100);
					cleardevice();
					}
				}
			closegraph();
			break;

			case 4:
			initgraph(&gd,&gm," ");
			while(!kbhit())
				{
				for(i=400;i>=0;i=i-20)
					{
					setcolor(RED);
					setbkcolor(BLUE);
					circle(20,i,20);					circle(i,20,20);
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
	getch();
	return 0;
	}