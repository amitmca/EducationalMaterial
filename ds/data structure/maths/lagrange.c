	  /*Program-LAGRANGE'S INTERPOLATION TECHNIQUE*/
	  
#include<stdio.h>
#include<conio.h>
#include<stdlib.h>
#include<math.h>

void main()
{
    double y[20],x[20],xr,num,fy,den;
    int i,n,j;

    clrscr();
    printf("\n    LAGRANGE'S INTERPOLATION TECHNIQUE");

    printf("\n\nEnter the number of entries(max 20)=");
    scanf("%d",&n);
    for(i=0;i<n;i++)
       {
	  printf("x%d = ",i);
	  scanf("%lf",&x[i]);
	  printf("y%d = ",i);
	  scanf("%lf",&y[i]);
      }
      printf("\nEnter the value of xr at which y=f(x)\n\t\t"
		"is to be interpolated,xr = ");
      scanf("%lf",&xr);

      fy=0;
      for(j=0;j<n;j++)
	 {
	    num=den=1;
	    for(i=0;i<n;i++)
	       {
		  if(i==j)
		     continue;
		  num=num * (xr - x[i]);
		  den=den * (x[j] -x[i]);
	       }
	       fy=fy + ((num/den) * y[j]);
	  }
	  printf("\nThe value of y=f(x)at xr=%lf is yr =%lf",xr,fy);
	  getch();
}

		 ***output***

    LAGRANGE'S INTERPOLATION TECHNIQUE

 Enter the number of entries(max 20)=3
x0 = 1
y0 = 1
x1 = 2
y1 = 4
x2 = 5
y2 = 25

Enter the value of xr at which y=f(x)
		is to be interpolated,xr = 8

The value of y=f(x)at xr=8.000000 is yr =64.000000










