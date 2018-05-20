
/*PROGRAM FOR THE REGULA FALSY METHOD*/
#include<stdio.h>
#include<conio.h>
#include<math.h>

 float f(float x);
 float f(float x2);
   void main()
    {
	float x0,x1,x2,x;
	int cnt,i;
	clrscr();
	printf("\nenter x0");
	scanf("%f",  &x0);
	printf("\nenter x1");
	scanf("%f",  &x1);
	printf("\nenter number of iteration");
	scanf("%d",  &cnt);
	for(i=1;i<=cnt;i++)
	 {
	 x2=(x0*f(x1)-x1*f(x0))/(f(x1)-f(x0));
	 f(x2);
	  if(f(x2)>0)
	     x1=x2;
	 else
	   x0=x2;
	printf("\n\t %f\t%f\t%f\titeration=%d",x0,x1,x2,i);

	}
	printf("\n\n aproximate solution is=%.4f", x2);
	 getch();
   }
float f(float x)
  {
  return(x*x*x-3*x-7);
  }


       ***	output 	***

enter x0 2

enter x1 3

enter number of iteration  8

	 2.312500       3.000000        2.312500        iteration=1
	 2.398419       3.000000        2.398419        iteration=2
	 2.419454       3.000000        2.419454        iteration=3
	 2.424449       3.000000        2.424449        iteration=4
	 2.425627       3.000000        2.425627        iteration=5
	 2.425904       3.000000        2.425904        iteration=6
	 2.425969       3.000000        2.425969        iteration=7
	 2.425984       3.000000        2.425984        iteration=8

 aproximate solution is=2.4260




                                                                                
                                                                                
                                                                                
                                                                                
