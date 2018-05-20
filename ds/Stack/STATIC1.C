#include<stdio.h>

#define MAX 100

int stack[MAX];
int top=0,c=0;

void push(int n)
	{
		if(top==MAX-1)
			printf("Stack Is Full");
		else
			{	
			stack[top++]=n;			
			c++;
			}
	}
int pop()
	{
		int t;
		if(top==0)
			printf("Stack Is Empty");
		else	
			{
			t=stack[top];
			top--;
			c--;
			return(t);			
			}
	}
	int main()
	{
		int value,i,p,c;
		do
			{

				printf("\n 1) PUSH:");
				printf("\n 2) POP");
				printf("\n 3) DISPLAY");
				printf("\n 4) EXIT");
				printf("\n Your Choice:");
				scanf("%d",&c);
				switch(c)
					{
						case 1:
							printf("\n\nEnter the number to pushed:");
							scanf("%d",&value);
							push(value);
							break;
							
						case 2:
							p=pop();
							break;
							
						case 3:
							for(i=0;i<c;i++)
							printf("\n\n%d\t",stack[i]);			
							printf("\n");
							break;											
							
						case 4:
							exit(0);
							break;							
					}
			}while(c!=4);
	return 0;
	}
