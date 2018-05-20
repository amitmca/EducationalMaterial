#include<stdio.h>
#include "conio.h"
main()
	{
	int n,x[20],i,sf=0,choice,choice1,f[20],xf[20],sxf=0,m[20],A,h,l,u,t;
	float mean;
	clrscr();
	do
		{
		printf("\n1) Ungrouped Data:\n");	
		printf("\n2) Grouped Data:\n");	
		printf("\n3) Exit:\n");	
		printf("\n Select the option:");
		scanf("%d",&choice);
		switch(choice)
			{
			case 1:
				printf("\nHow many Observations:");
				scanf("%d",&n);
				printf("\nEnter the Obsertions...\n");
				for(i=0;i<n;i++)
				{
				scanf("%d",&x[i]);
				sf=sf+x[i];
				}
				mean=sf/n;
				printf("\nArithmetic Mean = %f\n",mean);
				break;

			case 2:
				do
				{
				printf("\n 1) Discrete :");
				printf("\n 2) Continuous :");
				printf("\n 3) Exit :");
				printf("\n Select the option:");
				scanf("%d",&choice1);
				switch(choice1)
					{
					case 1:
						printf("\nHow many Observations:");
						scanf("%d",&n);
						printf("\nEnter the Obsertions...\n");
						for(i=0;i<n;i++)
						{
						scanf("%d",&x[i]);
						}
						printf("\nEnter the frequencies...\n");
						for(i=0;i<n;i++)
						{
						scanf("%d",&f[i]);
						sf=sf+f[i];
						}
						clrscr();
						printf("---------------------------");
						printf("\nX\t\t\tF\n");
						printf("---------------------------\n");
						for(i=0;i<n;i++)
						{
						printf("%d\t\t\t%d\n",x[i],f[i]);
						}
						printf("---------------------------\n");
						for(i=0;i<n;i++)
						{
						xf[i]=x[i]*f[i];
						sxf=sxf+xf[i];	
						}
					mean=sxf/sf;
					printf("\nArithmetic Mean = %f\n",mean);
					break;

					case 2:
						printf("\nEnter the Lower Limit:");
						scanf("%d",&l);
						printf("\nEnter the Upper Limit:");
						scanf("%d",&u);
						printf("\nClass Interval:");
						scanf("%d",&h);
						clrscr();
						printf("\nClass\n");
						i=0;
						while(l<u)
							{
							printf("\n%d-%d",l,l+h);
							t=l+h;
							getch();
							m[i]=(l+t)/2;
							i++;
							l=l+h;
							}
						for(i=0;i<n;i++)
						{
						printf("%d\n",m[i]);
						}
	//					printf("\nEnter the frequencies...\n");
						/*for(i=0;i<n;i++)
						{
						scanf("%d",&f[i]);
						sf=sf+f[i];
						}*/

					break;
					}
				}while(choice1!=3);

			case 3:
				exit(0);
				break;
			}
		}while(choice!=3);

	
	getch();
	}
