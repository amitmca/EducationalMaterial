/*program for bisection method*/
#include<stdio.h>
#include<math.h>
float f(float x);
void main(void)
{
int cn,i;
float x0,x1,x2;
clrscr();
printf("\n enter the value of x0");
scanf("%f",&x0);
printf("\n enter the value of x1");
scanf("%f",&x1);
printf("enter the number of iterations");
scanf("%d",&cn);
for(i=0;i<=cn;i++)
{
x2=(x0+x1)/2;
if(f(x2)>0)
x1=x2;
else
 x0=x2;
printf("the number of iteration=%d\n",cn);
printf("%f\t%f\t%f\t",x0,x1,x2);
}
printf("\nthe approximate root is %f",x2);
getch();
} //end of main
float f(float x)
{
return(x*x-5);
}


                                                                                
                                                                                
                                                                                
                                                                                
                                                                                
                                                                                
                                                                                

