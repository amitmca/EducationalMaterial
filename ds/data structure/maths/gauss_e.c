	  /*Program to solve system of linear equations using
	    Gauss Elimination Method.*/
#include<stdio.h>
#include<conio.h>
#include<stdlib.h>
#include<math.h>

void main()
{
    double a[10][10],x[10],ratio,coefsum;
    int i,j,n,k;
    clrscr();
    printf("\n        GAUSS ELIMINATION METHOD TO SOLVE LINEAR EQUATIONS");
    printf("\n\n       The form of equation is as follows\n"
		       "   a11x1+a12x2+....+a1nxn=b1\n"
		       "   a21x1+a22x2+....+a2nxn=b2\n"
		       "   ..........................."
		       "   an1x1+an2x2+....+annxn=bn\n"
		       "\n\nHere a11,a12...etc.should not be zero\n");
   printf("\nEnter number of variables(max 10)=");
   scanf("%d",&n);
   for(i=1;i<=n;i++)
      {
	 for(j=1;j<=n;j++)
	    {
	       printf("a%d%d=",i,j);
	       scanf("%lf",&a[i][j]);
	       x[i]=0;
	    }
	    printf("b%d=",i);
	    scanf("%lf",&a[i][j]);
	    x[i]=0;
      }
   for(k=1;k<=n-1;k++)
      {
	 for(i=k+1;i<=n;i++)
	    {
	       ratio=a[i][k]/a[k][k];
	       for(j=k+1;j<=n+1;j++)
		  {
		     a[i][j]=a[i][j]-ratio*a[k][j];
		  }
	    }
	 for(i=k+1;i<=n;i++)
	    a[i][k]=0;
      }
      x[n]=a[n][n+1]/a[n][n];
      for(i=n-1;i>=1;i--)
	 {
	    coefsum=0;
	    for(j=i+1;j<=n;j++)
	       x[i]=(a[i][n+1]-coefsum)/a[i][i];
	 }
     printf("\n\nThe value of variables in the givenequations are"
		"as follows....\n");
     for(i=1;i<=n;i++)
	 printf("\n   x%d=%lf   ",i,x[i]);
     getch();
}


/*		     ***  output ***

	GAUSS ELIMINATION METHOD TO SOLVE LINEAR EQUATIONS

       The form of equation is as follows
   a11x1+a12x2+....+a1nxn=b1
   a21x1+a22x2+....+a2nxn=b2
   ...........................   an1x1+an2x2+....+annxn=bn


Here a11,a12...etc.should not be zero

Enter number of variables(max 10)=2
a11=1
a12=2
b1=3
a21=4
a22=5
b2=6


The value of variables in the givenequations areas follows....

   x1=3.000000
   x2=2.000000




  */