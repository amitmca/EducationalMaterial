#include<stdio.h>
#include<stdlib.h>


int aval[10],max[10][10],alloc[10][10],need[10][10],nop=0,nor=0,work[10],finish[10],safe[10];
int req[10],pno;

void accept()
{
	int i,j;
	printf("\n Enter the nop and nor");
	scanf("%d%d",&nop,&nor);
	printf("\n Enter the Avialabe resource:");
	for(i=0;i<nor;i++)
	{
	scanf("%d",&aval[i]);
	}	
	printf(" \n Enter the max:\n");
	for(i=0;i<nop;i++)
	{
		for(j=0;j<nor;j++)
		{
			scanf("%d",&max[i][j]);
		}
	}
	printf("\n Enter the allocation:\n");
	for(i=0;i<nop;i++)
	{
		for(j=0;j<nor;j++)
		{
			scanf("%d",&alloc[i][j]);
		}
	}

}

void calneed()
{	
int i,j;
for(i=0;i<nop;i++)
	{
		for(j=0;j<nor;j++)
		{
			need[i][j]=max[i][j]-alloc[i][j];
		}
	}

}

void display()
{
	int i,j;
	printf("for displaying aval");	
	for(i=0;i<nop;i++)
	{
	printf("%d \t",aval[i]);
	}	
	printf(" \n  the max:\n");
	for(i=0;i<nop;i++)
	{
		for(j=0;j<nor;j++)
		{
			printf("%d \t", max[i][j]);
		}
		printf("\n");
	}
	printf("\n  the allocation:\n");
	for(i=0;i<nop;i++)
	{
		for(j=0;j<nor;j++)
		{
			printf("%d \t", alloc[i][j]);
		}
		printf("\n");
	}
	printf("\n  the need matrix \n ");
	for(i=0;i<nop;i++)
	{
		for(j=0;j<nor;j++)
		{
			printf("%d \t", need[i][j]);
		}
		printf("\n");
	}
	printf("\n  SAFE: \n");
	for(i=0;i<nop;i++)
	{
		printf("%d \n",safe[i]);
	}
}

int checkneed(int k)
{
	int c=0,l;
	for(l=0;l<nor;l++)
	{	
		if(need[k][l]<=work[l])
		c++;

	}
	if(c==nor)
	return(1);
	else
	return(0);
}
void safty()
{
	int i,j,m=0,k,l;
	for(i=0;i<nop;i++)
		finish[i]=0;
	for(i=0;i<nor;i++)
		work[i]=aval[i];
	i=0;
	j=0;
	while(j<nop)
	{
		if(finish[i]==0)
		{
			k=checkneed(i);
			if(k==1)
			{
				finish[i]=1;
				safe[m++]=i;
				for(l=0;l<nor;l++)
					work[l]+=alloc[i][l];
				
				i++;
				j++;

			}
			else 
				i++;
			
		}
		else 
			i++;
		if(i==nop)
			i=0;	
	
	}

}
void acceptreq()
{
	int i;
	printf("\n enter the process no:");
	scanf("%d",&pno);
	printf("\n Enter the Process of NOR method:");
	for(i=0;i<nor;i++)
	{
		scanf("%d",&req[i]);
		
	}

}


int checkreq(int k)
{
	int c=0,l;
	for(l=0;l<nor;l++)
	{	
		if(need[k][l]>=req[l])
		c++;

	}
	if(c==nor)
	return(1);
	else
	return(0);

}
int checkavail(int k)
{
	int c=0,l;
	for(l=0;l<nor;l++)
	{	
		if(aval[l]>=req[l])
		c++;

	}
	if(c==nor)
	return(1);
	else
	return(0);


}	
void reqest()
{
	int i,j,k;
	k=checkreq(pno);
	if(k==1)
	{
		j=checkavail(pno);
		if(j==1)
		{
			for(i=0;i<nor;i++)	
			{
				aval[i]=aval[i]-req[i];
				alloc[pno][i]=alloc[pno][i]+req[i];
				need[pno][i]=need[pno][i]-req[i];
		printf("\n avail=%d  allocat= %d  Need=%d \n",aval[i],alloc[pno][i],need[pno][i]);
			
			}
		}
		else
		{
			printf("\n Error Occured \n");
		}
	}
	else
	{
		printf("\n Error Occured \n");
	}
}
main()
{
	int i,j;
	int ch;
	while(1)
	{
		printf("\n 1.Accept \n 2.Calculate need \n 3.Display \n 4.Safty \n 5.Accept the req:\n 6.Request method.\n 7.Exit plz \n");
		printf("Please Enter the choice..");			
		scanf("%d",&ch);
		switch(ch)
		{
		case 1:
				 accept();
				break;
		case 2:
				 calneed();
				break;
		case 3:
				 display();
				break;
		case 4:
				safty();
				break;	
		
		case 5:
				acceptreq();
				break;
		case 6: 
				reqest();
				break;
		case 7:
				exit(0);

		}


	}
}
