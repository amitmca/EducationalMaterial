
/*Program 3.15 :An example of function with prototype.*/
# include <stdio.h>
	float area(float height, float base);
	void main()
	{
			float h, b, A;
			printf("\n enter height and base :");
			scanf("%f %f", &h, &b);
			A = area(h, b);
			printf("\n %f", A);
	}
	float area(float height, float base)
	{
		float x;
		x = 0.5 * height * base;
		return(x);
	}
/*
        *** OUTPUT ***
 enter height and base :2 4

 4.000000
*/
