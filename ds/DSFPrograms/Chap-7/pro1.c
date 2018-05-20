
/*Program 7.1 : Various operations on polynomials.*/
#include<math.h>
#include<stdio.h>
#include<conio.h>
typedef struct term
{
	int power;
	float coeff;
}term;
typedef struct polynomial
{
	term a[20];
	int n;
}polynomial;
void init(polynomial *ptr);
void read(polynomial *ptr);
void print(polynomial *ptr);
polynomial add(polynomial *p1,polynomial *p2);
polynomial multiply(polynomial *p1,polynomial *p2);
float evaluate(polynomial *p1,float x);
void insert(polynomial *,term);
void main()
{
	polynomial P1,P2,P3;
	int option;
	float x,value;
	do
	{
		printf("\n1 : create 1'st polynomial");
		printf("\n2 : create 2'nd polynomial");
		printf("\n3 : Add polynomials");
		printf("\n4 : Multiply polynomials");
		printf("\n5 : Evaluate 1'st polynomial");
		printf("\n6 : Quit");
		printf("\nEnter your choice :");
		scanf("%d",&option);
		switch(option)
		{
			case 1:read(&P1);break;
			case 2:read(&P2);break;
			case 3:P3=add(&P1,&P2);
			       printf("\n1'st polynomial ->\n ");
			       print(&P1);
			       printf("\n2'nd polynomial ->\n ");
			       print(&P2);
			       printf("\n Sum = ");
			       print(&P3);
			       break;
			case 4:P3=multiply(&P1,&P2);
			       printf("\n1'st polynomial ->\n ");
			       print(&P1);
			       printf("\n2'nd polynomial ->\n ");
			       print(&P2);
			       printf("\n Product = ");
			       print(&P3);
			       break;
			case 5:printf("\nEnter the value of x:");
			       scanf("%f",&x);
			       value=evaluate(&P1,x);
			       printf("\nValue of Polynomial =%6.2f",value);
			       break;
		}
	}while(option!=6);
}
void read(polynomial *Ptr)
{
	int n, i, power;
	float coeff;
	term t;
	init(Ptr);
	printf("\n Enter number of terms :");
	scanf("%d",&n);
	/* read n terms */
	for (i=0;i<n;i++)
	{       printf("\nenter a term(power  coeff.)");
		scanf("%d%f",&power,&coeff);
		t.power=power;
		t.coeff=coeff;
		insert(Ptr,t);
	}
}
void print(polynomial *Ptr)
{
	int i;
	printf("\n");
	for(i=0;i<Ptr->n;i++)
	printf("%5.2fX^%d\t",(Ptr->a[i]).coeff,(Ptr->a[i]).power);
}
polynomial add(polynomial *P1, polynomial *P2)
{
	polynomial P3;
	term t;
	int i,j;
	i=j=0;
	init(&P3);
	while(i<P1->n && j<P2->n)
	{
		if(P1->a[i].power==P2->a[j].power)
		{
			t.power=P1->a[i].power;
			t.coeff=P1->a[i].coeff+P2->a[j].coeff;
			insert(&P3,t);
			i++;j++;
		}
		else
			if(P1->a[i].power < P2->a[j].power)
			{
				insert(&P3,P1->a[i]);
				i++;
			}
			else
			{
				insert(&P3,P2->a[j]);
				j++;
			}
	}
	while(i<P1->n)
	{
		 insert(&P3,P1->a[i]);
		 i++;
	}
	while(j<P2->n)
	{
		 insert(&P3,P2->a[j]);
		 j++;
	}
	return(P3);
}
polynomial multiply(polynomial *P1,polynomial *P2)
{
	polynomial P3, Ptemp;
	term t;
	int i,j;
	init(&P3);
	for(i=0;i<P2->n;i++)
	{
		init(&Ptemp);
		for(j=0;j<P1->n;j++)
		{
			t.power=P1->a[j].power+P2->a[i].power;
			t.coeff=P1->a[j].coeff*P2->a[i].coeff;										insert (&Ptemp, t);
		}
	P3=add(&P3,&Ptemp);
	}
	return(P3);
}
float evaluate(polynomial *P, float x)
{
	float value;
	int i,power;
	value=0.00;
	for(i=0;i<P->n;i++)
	 { power=P->a[i].power;
	value=value+(P->a[i].coeff)*pow(x,power);
	  }
	return(value);
}
void init(polynomial *Ptr)
{
	Ptr->n=0;
}
void insert(polynomial *Ptr,term t)
{
	int i;
	/* move all higher power term by 1 place.movement
	   should start with the last term */
	for(i=Ptr->n-1; (Ptr->a[i]).power > t.power && i>=0;i--)
		Ptr->a[i+1]=Ptr->a[i];
	/* insert the term t */
	Ptr->a[i+1]=t;
	(Ptr->n)++;
}

/*
        *** OUTPUT ***
1 : create 1'st polynomial
2 : create 2'nd polynomial
3 : Add polynomials
4 : Multiply polynomials
5 : Evaluate 1'st polynomial
6 : Quit
Enter your choice :1

 Enter number of terms :3

enter a term(power  coeff.)2 3

enter a term(power  coeff.)4 6

enter a term(power  coeff.)5 7
1 : create 1'st polynomial
2 : create 2'nd polynomial
3 : Add polynomials
4 : Multiply polynomials
5 : Evaluate 1'st polynomial
6 : Quit
Enter your choice :2

 Enter number of terms :2

enter a term(power  coeff.)2 3

enter a term(power  coeff.)6 8
1 : create 1'st polynomial
2 : create 2'nd polynomial
3 : Add polynomials
4 : Multiply polynomials
5 : Evaluate 1'st polynomial
6 : Quit
Enter your choice :3

1'st polynomial ->

 3.00X^2         6.00X^4         7.00X^5
2'nd polynomial ->

 3.00X^2         8.00X^6
 Sum =
 6.00X^2         6.00X^4         7.00X^5         8.00X^6
1 : create 1'st polynomial
2 : create 2'nd polynomial
3 : Add polynomials
4 : Multiply polynomials
5 : Evaluate 1'st polynomial
6 : Quit
Enter your choice :4

1'st polynomial ->

 3.00X^2         6.00X^4         7.00X^5
2'nd polynomial ->

 3.00X^2         8.00X^6
 Product =
 9.00X^4        18.00X^6        21.00X^7        24.00X^8        48.00X^10
56.00X^11
1 : create 1'st polynomial
2 : create 2'nd polynomial
3 : Add polynomials
4 : Multiply polynomials
5 : Evaluate 1'st polynomial
6 : Quit
Enter your choice :5

Enter the value of x:2

Value of Polynomial =332.00
1 : create 1'st polynomial
2 : create 2'nd polynomial
3 : Add polynomials
4 : Multiply polynomials
5 : Evaluate 1'st polynomial
6 : Quit
Enter your choice :6
*/
