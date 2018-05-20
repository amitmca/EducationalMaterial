/*Program 4.24 : Program to illustrate structure as function argument. */
/*(add two complex numbers)*/

struct complex
{
	int real;
	int imaginary;
};
struct complex add_complex(struct complex a,struct complex b);
void main()
{
	struct complex x,y,z;
	printf("\nEnter real and imaginary part of 1'st number :");
	scanf("%d %d",&x.real,&x.imaginary);
	printf("\nEnter real and imaginary part of 2'nd number :");
	scanf("%d %d",&y.real,&y.imaginary);
	z=add_complex(x,y);
	printf("\nSum = %d +%di",z.real,z.imaginary);
}
struct complex add_complex(struct complex a,struct complex b)
{
	struct complex temp;
	temp.real=a.real+b.real;
	temp.imaginary=a.imaginary+b.imaginary;
	return(temp);
}

/*
       *** OUTPUT ***
Enter real and imaginary part of 1'st number :5 3

Enter real and imaginary part of 2'nd number :4 8

Sum = 9 +11i
*/
