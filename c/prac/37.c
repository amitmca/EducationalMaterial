#include<stdio.h>
main()
	{
	int a,b,c=0,r;
	system("clear");
	printf("\n Upto which number do you want to display:");
	scanf("%d",&r);
	a=1;
	while(a<=r)
		{
		b=1;c=0;
		while(b<=a)
			{
			if(a%b==0)
			c=c+1;
			b++;
			}
		
		if(c==2)
			printf("\n %d",a);
			a++;
		}
	printf("\n");
	}
