// PROGRAM FOR THE RADIX SORT

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
		printf("\n\nArray[%d]=%d\n\n",i,a[i]);
}

int max(int a[],int n)
{
		int m,rem,count,i;
		m=a[0];
		count=0;
		for(i=0;i<n;i++)
		{
			if(m<a[i])
			m=a[i];
		}
		while(m>0)
		{
			rem=m%10;
			m=m/10;
			count++;
		}
		return(count);
}

void radix_sort(int a[],int n,int l)
{
		int i,j,k,temp[20],m,p,num;
		int rem;
		for(i=1;i<=l;i++)
		{
			k=0;
			for(j=0;j<=9;j++)
			{
					for(m=0;m<n;m++)
					{
						  p=i;
						num=a[m];
						while(p>0)
						{
							rem=num%10;
							num=num/10;
							p--;
						}
						if(rem==j)
						{
							temp[k]=a[m];
							k++;
						}
					}

			}

			for(j=0;j<n;j++)
			a[j]=temp[j];
		}
   //	for(i=0;i<n;i++)
	//printf("\n\nArray[%d]=%d",i,temp[i]);
	dis_array(temp,n);
}

void main()
{
		int n,a[20],d;
		clrscr();
		printf("\n\nEnter the size  of the array:");
		scanf("%d",&n);

		printf("\n\nEnter the array element:");
		read_array(a,n);
		clrscr();

		printf("\n\nThe array element is:\n");
		dis_array(a,n);

		d=max(a,n);

		printf("\n\nThe radix sort is:\n");
		radix_sort(a,n,d);
		getch();

}
