
	/*PROGRAM FOR THE NEWTON RAPHSON METHOD*/
#include<stdio.h>
#include<conio.h>
#include<math.h>

 float f1(float x);
 float f(float x);
   void main()
    {
	float x0,x1,x2,x;
	int cnt,i;
	clrscr();
	printf("\nenter x0");
	scanf("%f",  &x0);
	printf("\nenter number of iteration");
	scanf("%d",  &cnt);
	for(i=1;i<=cnt;i++)
	 {
	 x1=x0-(f(x0)/f1(x0));
	f(x1);

	printf("\n\t iteration =%d",cnt);
	printf("\n\n\t\t\t %f\t%f\t%f",x0,x1,f(x1));

	}
	printf("\n\n\n aproximate solution is=%.4f", x1);
	getch();
   }
float f(float x)
  {
  return(x*x*x*x*x+5*x+1);
  }
  float f1(float x)
  {
  return(5*x*x*x*x+5);
  }



			*** output***


enter x0 3

enter number of iteration 3

	 iteration =3

			 3.000000       2.368293        87.344978
	 iteration =3

			 3.000000       2.368293        87.344978
	 iteration =3

			 3.000000       2.368293        87.344978


 aproximate solution is=2.3683







                                                                                
