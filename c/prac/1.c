//Program for marquee scrolling text from left to right

int main()
	{
	int gd=DETECT,gm,i,y;
	initgraph(&gd,&gm,"/usr/local/lib/");
	y=getmaxy()/2;
	while(!kbhit())
	{
	for(i=0;i<=600;i=i+20)
		{
		setbkcolor(BLUE);
		setcolor(RED);
		outtextxy(i,y,"Your text goes here");
		delay(800);
		cleardevice();
		}
	}
	closegraph();
	}
