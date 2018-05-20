
/*Program 4.25 : Program to add complex numbers.*/
struct complex
{
	int real;
	int imaginary;
};
struct complex add_complex(struct complex a[],int n);
void main()
{
	struct complex a[10], x;
	int n,i;
	printf("\n How many complex numbers ? :");
	scanf("\n%d",&n);
	printf("\nEnter complex numbers :");
	for(i=0;i<n;i++)
		scanf("%d %d",&a[i].real,&a[i].imaginary);
	x=add_complex(a,n);
	printf("\nSum = %d +%di",x.real,x.imaginary);
}
struct complex add_complex(struct complex a[],int n)
{
	struct complex temp;
	int i;
	temp.real=temp.imaginary=0;
	for(i=0;i<n;i++)
	{
	    temp.real=a[i].real+temp.real;
	    temp.imaginary=a[i].imaginary+temp.imaginary;

	}
	return(temp);
}

/*
     *** OUTPUT ***
 How many complex numbers ? :3

Enter complex numbers :5 3
6 4
7 5

Sum = 18 +12i
*/
