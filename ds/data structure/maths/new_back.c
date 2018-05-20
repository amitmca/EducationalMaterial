/*Program for NEWTON'S BACKWARD INTERPOLUTION TECHNIQUE*/

#include<stdio.h>
#include<conio.h>
#include<math.h>
#include<stdlib.h>

void main()
{
double y[20][20],x[20],xr,yr,h,r,sum,fy,facto;
int i,j,k,n,m,t;
clrscr();
printf("------NEWTON'S BACKWARD TECHNIQUE-------\n");
printf("\n Enter the no. of entries(max 20):=");
scanf("%d",&n);
for(i=0;i<n;i++)
	{
	printf("x%d=",i);
	scanf("%lf",&x[i]);
	printf("        y%d=",i);
	scanf("%lf",&y[i][0]);
	}
printf("Enter the value of xr at which y=f(x)\nis to be"
	"interpolated,xr=");
scanf("%lf",&xr);
h=x[1]-x[0];
r=(xr-x[n-1])/h;
printf("\n Enter the value of h:=%lf  and value of r=%lf\n",h,r);
k=0;
for(j=1;j<n;j++)
	{
	k++;
	for(i=n-1;i>=k;i--)
	   {
	   y[i][j]=y[i][j-1]-y[i-1][j-1];
	   }
	}
sum=0;
for(t=1;t<n;t++)
	{
	fy=1;
	facto=1;
	for(m=0;m<t;m++)
		{
		fy=fy*(r+m);
		facto=facto*(m+1);
		}
	fy=fy*(y[n-1][t]/facto);
	sum=sum+fy;
	}
yr=sum+y[n-1][0];
printf("\n The value of y=f(x)at xr=%lf is yr=%lf",xr,yr);
}

	    ***OUTPUT***

------NEWTON'S BACKWARD TECHNIQUE-------

 Enter the no. of entries(max 20):=4
x0=1
        y0=1                                                                    
x1=2                                                                            
        y1=4                                                                    
x2=3                                                                            
        y2=9                                                                    
x3=4                                                                            
        y3=16                                                                   
Enter the value of xr at which y=f(x)                                           
is to beinterpolated,xr=5                                                       
                                                                                
 Enter the value of h:=1.000000  and value of r=1.000000                        
                                                                                
 The value of y=f(x)at xr=5.000000 is yr=25.000000                              
                                                                                
                                                                                
                                                                                
                                                                                
                                                                                
                                                                                
                                                                                
                                                                                

