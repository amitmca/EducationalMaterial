#include<stdio.h>
#include<conio.h>
main()
       {
       int r=0,n,sum,digit;
       clrscr();
       printf("\nEnter the number:");
       scanf("%d",&n);
       while(n > 0)
	   {
	   r=r*10+n%10;
	   n=n/10;
	   }
	  while(r > 0)
	   {
	   digit=r%10;
	   r=r/10;
	   switch(digit)
		{
		case 1: printf("\nONE");	break;
		case 2: printf("\nTWO");	break;
		case 3: printf("\nTHREE");	break;
		case 4: printf("\nFOUR");	break;
		case 5: printf("\nFIVE");	break;
		case 6: printf("\nSIX");	break;
		case 7: printf("\nSEVEN");	break;
		case 8: printf("\nEIGHT");	break;
		case 9: printf("\nNINE");	break;
		case 0: printf("\nZERO");	break;
		}
	   }

       getch();
       return 0;
       }
