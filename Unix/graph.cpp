#include<stdio.h>
#include<graphics.h>

int main(void)
{
int gd=DETECT, gm=VGAMAX;
//initgraph(&gd,&amp;amp;amp;amp;amp;amp;amp;gm,NULL);
initgraph(&gd,&gm," ");
//moveto(0, 0);
closegraph();
return 0;
}
