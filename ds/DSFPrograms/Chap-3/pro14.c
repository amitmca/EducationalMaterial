/*Program 3.14 :An example of function declared before it is called.*/
# include <stdio.h>
	float area(float height, float base)
	{
		float x;
		x = 0.5 * height * base;
		return(x);
	}
	void main()
	{
		float h, b, A;
		clrscr();
		printf("\n enter height and base :");
		scanf("%f%f", &h, &b
		);
		A = area(h, b); /* calling the function */
		printf("\n %f", A);
	}
