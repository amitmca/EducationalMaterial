

  #include<stdio.h>
  #include<conio.h>
  void insort (int a[],int,int);
  int i;
  void main()
  {
  int a[8],n=5,m=5;
  clrscr();
  printf("enter the matrix");
  for(i=0;i<5;i++)
  {
  scanf("%d",&a[i]);
  }
  insort(a,n,m);
  for (i=0;i<5;i++)
  {
  printf("%d\n",a[i]);
  }
  getch();
  }

  void insort(int a[],int n,int m)
  {
  int j;
  for(i=1;i<n;i++)
  {
  m=a[i];
  for(j=i-1;j>=0&&a[j]>m;j--)
  {
  printf("%d\n",a[j]);
  }
  }
  }