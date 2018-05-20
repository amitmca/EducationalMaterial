//Program to implement queue using array

#include<stdio.h>
#include<conio.h>

int que[20],i,size,ele,first,last;

int Insert(int last)
	{
	first=last=0;
	printf("\n size of the queue:");
	scanf("%d",&size);
	i=1;
	while(i<=size)
		{
		printf("\nEnter the elemenet to add:");
		scanf("%d",&ele);
		if(first==0)
			que[first]=que[last]=que[ele];
		else
			{
			que[++last]=que[ele];
			que[last]=que[ele];
			}
		i++;
		}
	return(first);
	}

int Delete(int first)
	{
	int tmp=first;
	first=first+1;
	return(que[first]);
	}
void Display(int first)
	{
	while(first<=last)
		{
		printf("\n%d\n",que[first]);
		first++;
		}
	}
void main()
	{
	int choice;
	char ch='y';
	clrscr();
	do
		{
		printf("\n\1.Insert\n");
		printf("\n2.Delete\n");
		printf("\n3.Display\n");
		printf("\n4.Exit\n");
		printf("\n Select your choice:");
		scanf("%d",&choice);
		switch(choice)
		{
		case 1:
				first=Insert(last);
			break;

		case 2:
			while(ch=='y')
				{
				first=Delete(ele);
				printf("\n\nDelete another(y/n):");
				ch=getche();
				}
			break;

		case 3:
			Display(first);
			break;

		case 4:
			exit(0);
			break;
		}

		}while(choice!=4);
	getch();
	}