#include<stdio.h>
void mystrcpy(char *src,char *dest);
void mystrcat(char *src,char *dest);
void mysubstr(char *src,int from,int to); 
void mystrrev(char *str);
int mystrlen(char *str);
int mystrcmp(char *str1,char *str2);
void mystrlwr(char *str);
void mystrupr(char *str);
void main()
	{
	char str1[20],str2[20];
	int ch,len,from,to,c;
	clrscr();
	do
		{
		printf("\n***** String Functions ******\n");
		printf("\n 1) Copy the one string into another\n");
		printf("\n 2) Concatenate the two strings:\n");
		printf("\n 3) Finding the substring from a string:\n");
		printf("\n 4) String Reverse:\n");
		printf("\n 5) String Length:\n");
		printf("\n 6) String Compare:\n");
		printf("\n 7) Convert string to lowercase :\n");
		printf("\n 8) Convert string to uppercase :\n");
		printf("\n 9) Exit\n");
		printf("\n Select Your Choice....\t");
		scanf("%d",&ch);
		switch(ch)
			{
			case 1:
				printf("\n Enter First String here:= ");
				scanf("%s",str1);
				printf("\n Enter Second String here:= ");
				scanf("%s",str2); 		
				printf("\nThe Original string before is:%s\n",str2);	
				mystrcpy(str1,str2);
				printf("\nThe String after copy is:%s\n",str2);	 					break;
			case 2:
				printf("\n Enter First String here:= ");
				scanf("%s",str1);
				printf("\n Enter Second String here:= ");
				scanf("%s",str2); 		
				mystrcat(str1,str2);
				printf("\nThe Concatenation is:%s\n",str1);
				break;
			case 3:
				printf("\nEnter the String:");
				scanf("%s",str1);
				printf("\n Enter the substring parameters:\n");
				printf("\n From : ");
				scanf("%d",&from);
				printf("\n To : ");
				scanf("%d",&to);
				mysubstr(str1,from,to);
				break;
			case 4:
				printf("\nEnter the String:");
				scanf("%s",str1);
				mystrrev(str1);
				break;
			case 5:
				printf("\n Enter the String here:= ");
				scanf("%s",str1); 			
				len=mystrlen(str1);
				printf("\n Length of %s is : %d\n\n",str1,len);	
				break;
			case 6:
				printf("\n Enter First String here:= ");
				scanf("%s",str1);
				printf("\n Enter Second String here:= ");
				scanf("%s",str2); 		
				c=mystrcmp(str1,str2);
				if(c>0)
					{
					printf("\nEqual\n");
					}
				else
					{
					printf("\nNot Equal\n");
					}
			
				break;
			case 7:
				printf("\n Enter the String here:= ");
				scanf("%s",str1); 			
				mystrlwr(str1);
				break;
			case 8:
				printf("\n Enter the String here:= ");
				scanf("%s",str1); 			
				mystrupr(str1);
				break;
			}
		}while(ch!=9);
	getch();
	clrscr();
	}
void mystrcpy(char *src,char *dest)
	{
	char *p,*q;
	p=src;
	q=dest;
	while(*p!='\0')
		{
		*q=*p;
		p++;
		q++;	
		}
	*q='\0';		
	} 

void mystrcat(char *src,char *dest)
	{
	char *p,*q;
	p=src;
	q=dest;
	while(*p!='\0')
		{
		p++;
		}
	while(*q!='\0')
		{
		*p=*q;
		p++;
		q++;	
		}
	} 

void mysubstr(char *src,int from,int to)
	{
	int i;
	printf("\nThe substring from %d to %d is:\t",from,to);
	for(i=from;i<=to;i++)
		{
		printf("%c",src[i]);
		}
	printf("\n");
	}

void mystrrev(char *str)
	{
	int c=0,i;
	while(*str!='\0')
		{
		++str;
		c++;
		}
	printf("\nThe reverse is:\t");
	for(i=0;i<c;i++)
		{
		str--;
		printf("%c",*str);
		}
	printf("\n");
	}
int mystrlen(char *str)
	{
	char *p;
	int l;	
	p=str;
	l=0;
	while(*p!='\0')
		{
		p++;
		l++;
		}	
	return l;
	}
int mystrcmp(char *str1,char *str2)
	{
	int c;
	c=0;
	while(*str1!='\0' && *str2!='\0')
		{
		if(*str1==*str2)
			{
			c++;
			str1++;
			str2++;
			}
		else
			{
			c=0;
			}
		}
	return c;
	}
void mystrlwr(char *str)
	{
	printf("\nThe String in lower case is:\t");
	while(*str!='\0')
		{
		if((*str > 64) && (*str < 92))
			{
			*str=*str+32;
			printf("%c",*str);
			}
		str++;
		}
	printf("\n");
	}
void mystrupr(char *str)
	{
	printf("\nThe String in Upper case is:\t");
	while(*str!='\0')
		{
		if((*str > 96) && (*str < 123))
			{
			*str=*str-32;
			printf("%c",*str);
			}
		str++;
		}
	printf("\n");
	}
