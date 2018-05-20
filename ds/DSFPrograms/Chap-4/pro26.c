/*Program 4.26 : Program to read and display information using structures.*/
#include<stdio.h>
typedef struct details
{
	char name[50];
	char department[10];
	int age;
	int salary;
}details;
void main()
{
	details a[5],temp;
	int i,j,total;
	printf("\nEnter details of 5 employees : ");
	for(i=0;i<5;i++)
		scanf("%s%s%d%d",a[i].name,a[i].department,&a[i].age,&a[i].salary);
	// sorting of records on department
	for(i=1;i<5;i++)
		for(j=0;j<5-i;j++)
			if(strcmp(a[j].department,a[j+1].department) > 0)
			{
				temp=a[j];
				a[j]=a[j+1];
				a[j+1]=temp;
			}
	// printing department wise list
	for(i=0;i<5;i++)
	{
		temp=a[i];
		total=0;
		printf("\n Department = %s\n",temp.department);
		while(i<=5 && strcmp(temp.department,a[i].department)==0)
		{
			total=total+a[i].salary;
			printf("\n %s\t%d",a[i].name,a[i].salary);
			i++;
		}
		i--;
		printf("\nTotal salary = %d ",total);
	}
}

/*
     *** OUTPUT ***
Enter details of 5 employees :
abc	sales		1	1000    
pqr	marketing	2 		500
xyz 	sales 		1 	1500
lmn 	marketing 	2 	300
uvw 	marketing 	2 	1000

Department = marketing
pqr	500
mn	300
uvw     1000
Total salary = 1800

Department = sales
abc	1000
xyz	1500
Total salary = 2500
*/
