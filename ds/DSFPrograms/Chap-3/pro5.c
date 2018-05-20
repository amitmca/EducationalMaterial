/*Program 3.5 : Display a number between 0 to 9 in figure. Program accepts an input from the user and displays the same in figure.*/
#include<stdio.h>
void main()
{
	int x;
	printf("\nEnter the number :");
	scanf("%d",&x);
	switch(x)
	{
		case 0:printf("\nZero");	break;
		case 1:printf("\nOne");		break;
		case 2:printf("\nTwo");		break;
		case 3:printf("\nThree");	break;
		case 4:printf("\nFour");	break;
		case 5:printf("\nFive");	break;
		case 6:printf("\nSix");		break;
		case 7:printf("\nSeven");	break;
		case 8:printf("\nEight");	break;
		case 9:printf("\nNine");	break;
		default:printf("Unknown value");break;
	}
}

/*
         *** OUTPUT ***
---first run---
Enter the number :4
Four

---second run---
Enter the number :88
Unknown value
*/
