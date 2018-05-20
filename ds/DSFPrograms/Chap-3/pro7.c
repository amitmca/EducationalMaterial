/*Program 3.7 :	Program for finding sum of the first ten natural numbers*/
# include <stdio.h>
void main()
{
	int  i, sum = 0;
	i = 1;
	while(i<=10)
	{
			sum = sum + i;
			i++;
	}
	printf("\n sum = %d", sum);
}

/*
          *** OUTPUT ***
 sum = 55
*/
