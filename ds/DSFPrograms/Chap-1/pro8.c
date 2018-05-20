
/*Program 1.8 : Program to illustrate 'while' loop.*/
#include<stdio.h>
// An example of while loop
main()
{
       int i,n; // i is looping variable
       printf("How many times do you want to see 'hello' ?");
       scanf("%d",&n);
       /* Display the greeting n times by verying value
	  of i from 1 to n , in step of one */
       i=1;
       while(i<=n)
       {
		printf("\nHello");
		i=i+1; // increnment i by 1
       }
       }

/*
         *** OUTPUT ***
How many times do you want to see 'hello' ?
3

Hello
Hello
Hello
*/
