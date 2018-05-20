#include<stdio.h>

void read_array(int a[],int n)
{
		int i;
		for(i=0;i<n;i++)
		{
			printf("\n\nEnter the [%d] element:",i);
			scanf("%d",&a[i]);
		}
}

void display_array(int a[],int n)
{
		int i;
		for(i=0;i<n;i++)
		printf("\n\nArray[%d]=%d\n",i,a[i]);
}

int max_digit(int a[],int n)
{
		int i,rem,max,count=0;
		max=a[0];
		for(i=0;i<n;i++)
		{
			if(max<a[i])
			max=a[i];
		}
		while(max>0)
		{
			rem=max%10;
			count++;
			max=max/10;
		}
		return(count);
}

void radix_sort(int a[],int n,int l)
{
		int i,j,k,temp[20],l1,num,x,rem;
		for(i=1;i<=l;i++)
		{
				
				x=0;
			for(j=0;j<=9;j++)
			{
				
				for(k=0;k<n;k++)
				{
		
					l1=i;;
					num=a[k];		
					while(l1>0)
					{
						
						rem=num%10;
						num=num/10;
						l1--;
					}
					if(rem==j)
					{
						temp[x]=a[k];
						x++;
					}
				}
			}
			for(j=0;j<n;j++)
			a[j]=temp[j];
		}
		for(i=0;i<n;i++)
		printf("\n\nArray[%d]=%d\n",i,temp[i]);
}
 int main()
{
		int n,a[20],d;
		printf("\n\nEnter the size of the array:");
		scanf("%d",&n);
		printf("\n\nEnter the array element:");
		read_array(a,n);
		printf("\n\nThe array element is:");
		display_array(a,n);
		d=max_digit(a,n);
		printf("\n\nD=%d",d);
		printf("\n\nThe radix sort element is");
		radix_sort(a,n,d);
}
