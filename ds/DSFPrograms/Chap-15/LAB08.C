/*sorting using bubble sort, insertion sort and quicksort*/
#include <stdio.h>
#include <conio.h>
#include <string.h>

void bubble(char a[][20],int n);
void insertion(char a[][20],int n);
void quicksort(char a[][20],int i,int j);
int partition(char a[][20],int i,int j);
void print(char a[][20],int n);
void main()
 { char a[20][20],b[20][20];
   int n,i,op;
   clrscr();
   do {
       printf("\n\n1)read words to be sorted");
       printf("\n2)Bubble Sort\n3)Insertion Sort\n4)Quicksort\n5)Quit");
       printf("\nEnter Your choice : ");
       scanf("%d",&op);
       switch(op)
	{ case 1: printf("\n No of words : ");
		  scanf("%d",&n);
		  printf("\n Enter words :\n\n");
		  flushall();
		  for(i=0;i<n;i++)
		   { printf("\n Next Word : ");
		      gets(a[i]);
		   }
		 break;
	 case 2: for(i=0;i<n;i++) /*copy data in a temporary array */
		   strcpy(b[i],a[i]);
		 bubble(b,n);
		 print(b,n);
		 break;
	 case 3: for(i=0;i<n;i++) /*copy data in a temporary array */
		   strcpy(b[i],a[i]);
		 insertion(b,n);
		 print(b,n);
		 break;
	 case 4: for(i=0;i<n;i++) /*copy data in a temporary array */
		   strcpy(b[i],a[i]);
		 quicksort(b,0,n-1);
		 print(b,n);
		 break;
	}
      }while(op!=5);
 }
void bubble(char b[][20],int n)
{int i,j;
 char temp[20];
 for(i=1;i<n;i++)
   for(j=0;j<n-i;j++)
     if(strcmp(b[j],b[j+1])>0)
      { strcpy(temp,b[j]);
	strcpy(b[j],b[j+1]);
	strcpy(b[j+1],temp);
      }
}
void insertion(char b[][20],int n)
{ int i,j;
 char temp[20];
 for(i=1;i<n;i++)
  { strcpy(temp,b[i]);
    for(j=i-1;j>=0 && strcmp(b[j],temp)>0;j--)
       strcpy(b[j+1],b[j]);
    strcpy(b[j+1],temp);
  }
}
void quicksort(char b[][20],int i,int j)
{  int p;
   if(i<j)
    { p=partition(b,i,j);
      quicksort(b,i,p-1);
      quicksort(b,p+1,j);
    }
}
int partition(char b[][20],int l,int u)
{ int i,j;
  char temp[20],v[20];
  strcpy(v,b[l]);
  j=u+1;
  do {
      do
	i++;
      while(i<=u &&  strcmp(b[i],v)<0);
	do
	j--;
      while(strcmp(b[j],v)>0);
     if(i<j)
       { strcpy(temp,b[i]);
	 strcpy(b[i],b[j]);
	 strcpy(b[j],temp);
       }
    } while(i<j);
  strcpy(b[l],b[j]);
  strcpy(b[j],v);
  return(j);
}
void print(char b[][20],int n)
{ int i;
  printf("\n\nSorted Names:\n");
    for(i=0;i<n;i++)
     printf("%s   ",b[i]);
}

/*
                *** OUTPUT ***
1)read words to be sorted
2)Bubble Sort
3)Insertion Sort
4)Quicksort
5)Quit
Enter Your choice : 1

 No of words : 3

 Enter words :


 Next Word : Megha

 Next Word : Geeta

 Next Word : Smita

1)read words to be sorted
2)Bubble Sort
4)Quicksort
5)Quit
Enter Your choice : 2


Sorted Names:
Geeta   Megha   Smita

1)read words to be sorted
2)Bubble Sort
3)Insertion Sort
4)Quicksort
5)Quit
Enter Your choice : 3

1)read words to be sorted
2)Bubble Sort
3)Insertion Sort
4)Quicksort
5)Quit
Enter Your choice : 4


Sorted Names:
Geeta   Megha   Smita

1)read words to be sorted
2)Bubble Sort
3)Insertion Sort
4)Quicksort
5)Quit
Enter Your choice : 5


Sorted Names:
Geeta   Megha   Smita
*/
