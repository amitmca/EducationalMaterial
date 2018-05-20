#include<stdio.h>
int main()
	{
	int isprime(int);
	int n,count,number;
	printf("How many Prime Numbers:");
	scanf("%d",&n);
	printf("2");
	count=2;
	number=3;
	while(count<=n)
		{
		if(isprime(number))
			{
			printf("%d\t",number);
			count++;
			}
		number=number+1;
		printf("\n");
		}
	}
int isprime(int x)
	{
	int i;
	for(i=2;i<=x-1;i++)
		if(x%i==0)
		return 0;
	return 1;
	}

