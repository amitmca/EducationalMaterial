#include<stdio.h>
#include<conio.h>

void read_array(int a[],int n)
{
		int i;
		for(i=0;i<n;i++)
		{
			printf("\n\nEnter the [%d] elment:",i);
			scanf("%d",&a[i]);
		}
}

void dis_array(int a[],int n)
{
		int i;
		for(i=0;i<n;i++)
		printf("\n\nArray[%d]=%d",i,a[i]);
}

void bubble_sort(int a[],int n)
{
		int i,temp,j,s=0,c=0;
		for(i=1;i<n;i++)
		{
			for(j=0;j<i;j++)
			{
				c++;
					if(a[j]>a[j+1])
					{
							s++;
							temp=a[j];
							a[j]=a[j+1];
							a[j+1]=temp;
					}
			}
		}
		printf("\n\nCompe count=%d  Swap count=%d",c,s);
		dis_array(a,n);
}


void main()
{
		int n,a[20];
		clrscr();
		printf("\n\nEnter the size of the array:");
		scanf("%d",&n);

		printf("\n\nEnter the array elemnt:\n");
		read_array(a,n);

		printf("\n\nThe array  elment is:");
		dis_array(a,n);

		printf("\n\nThe element after bubble sort:");
		bubble_sort(a,n);
		getch();

}