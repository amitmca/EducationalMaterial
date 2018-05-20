#include<stdio.h>
int max,count;
int arr[20];
void read_array(a,n)
int a[],n;
{
	int i;
	for(i=0;i<n;i++)
	{
			printf("\n\nEnter the [%d] element:",i);
			scanf("%d",&a[i]);
	}
}

void display_array(a,n)
int a[],n;
{
	int i;
	for(i=0;i<n;i++)
	printf("\n\nArrray[%d]=%d\n",i,a[i]);
}

int max_array(a,n)
int a[],n;
{
		int i,rem;
		max=a[0];
		count=0;
		for(i=0;i<n;i++)
		{
			if(a[i]>max)
			max=a[i];
		}
		return(max);
}

int digit(int m)
	{
		int count=0,rem;
		while(m>0)
		{
		rem=m%10;
		m=m/10;
		count++;
		}
	return(count);
	}

int  radix_sort(a,n,d)
int a[],n,d;
{
	int i,k,l,j,k1=0,rem;
	int temp[20],dummay[20];
	for(i=0;i<n;i++)
	{	
		dummay[i]=a[i];
	}
	for(l=1;l<=d;l++)
	{
		for(j=0;j<n;j++)
		{
			temp[j]=a[j]%10;
			a[j]=a[j]/10;
			printf("\nTemp[%d]=%d",j,temp[j]);
		}
		k=max_array(temp,n);
		printf("\n\nThe maximu is:%d",k);
		for(j=0;j<n;j++)
		{
			for(i=0;i<=k;i++)
			{
		
			if(temp[j]==i)
				{
				a[i]=dummay[j];
				printf("\n\narr[%d]=%d",i,a[i]);
				}
			}
		}
	}

}


void main()
{
	int a[20],n,m,d;
	printf("\n\nEnter the size of the array:");
	scanf("%d",&n);

	printf("\n\nEnter the array elemnt:");
	read_array(a,n);

	printf("\n\nThe array elemnt is:\n\n");
	display_array(a,n);

	printf("\n\nThe maximum array element is:");
	m=max_array(a,n);
	printf("\n\nThe maximu is=%d",m);
	
	d=digit(m);
	printf("\n\nThe digit is=%d",d);

	printf("\n\nThe array sorting using radix sort is:");
	radix_sort(a,n,d);

//	printf("\n\nThe sort arry is:");
//	display_array(arr,n);

}

