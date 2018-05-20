#include<stdio.h>
#define ALLOCATE (int *)malloc(n)
main()
	{
	int *p,n,c,r=0,sum=0,t,i,prime=1,sum1=0;
	system("clear");
	do
		{
		printf("\n 1) Prime Number:\n");
		printf("\n 2) Perfect Number:\n");
		printf("\n 3) Armstrong Number:\n");
		printf("\n 4) EXIT\n");
		printf("\n What Is Your Choice....?\t");
		scanf("%d",&c);
		switch(c)
			{
			case 1:
				printf("\n Enter Your Number:");
				scanf("%d",&n);
				p=ALLOCATE;
				printf("\n Memory is allocated now.....\n");
				for(i=2;i<n;i++)
					{	
					if(n%i==0)
						{
						prime=0;
						break;
						}
					}
				if(prime==0)
					printf("\n NOT PRIME\n");	
				else
					printf("\n PRIME\n");	
				free(p);
				printf("\n Memory is freed now.....\n\n");
				break;

			case 2:
				printf("\n Enter Your Number:");
				scanf("%d",&n);
				p=ALLOCATE;
				printf("\n Memory is allocated now.....\n");
				for(i=1;i<n;i++)
					{	
					if(n%i==0)
						{
						sum=sum+i;
						}
					}
				if(sum==n)
					printf("\n PERFECT\n");	
				else
					printf("\n NOT PERFECT\n");	
				free(p);
				printf("\n Memory is freed now.....\n\n");
				break;

			case 3:
				printf("\n Enter Your Number:");
				scanf("%d",&n);
				p=ALLOCATE;
				printf("\n Memory is allocated now.....\n");
				t=n;
				while(n>0)
					{
					r=n%10;
					sum1=sum1+r*r*r;
					n=n/10;
					}
				if(sum1==t)
					printf("\n ARMSTRONG\n");	
				else
					printf("\n NOT ARMSTRONG\n");	
				free(p);
				printf("\n Memory is freed now.....\n\n");
				break;

			case 4:
				printf("\n\t\t\t\tTHANK YOU\n\n");
				system("clear");
				break;
			}
		}while(c!=4);
	} 

