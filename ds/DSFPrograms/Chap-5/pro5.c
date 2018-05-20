/*Program 5.5 :	Program for string manipulation without pointers.*/
/* Program showing various operations on string(functions implemented
   without pointers).
   functions implemented:
   (1) Length of a string
   (2) Reversing a string
   (3) Palindrome
   (4) Copy
   (5) String comparison
   (6) String concatenations
   (7) Searching a string
   (8) Counting of Words,Characters and Special characters
 */
#include <stdio.h>
#include<conio.h>
#include<ctype.h>
#include<stdlib.h>
/*function prototypes*/
int length(char a[]);
void reverse(char a[]);
int palindrome(char a[]);
void copy(char a[],char b[]);
int compare(char a[],char b[]);
void concat(char a[],char b[]);
void search(char a[],char b[]);
void count(char a[]);

void main()
  { char a[100],b[100];
    int result,op;
    clrscr();
    do
      {               /* display the menu */
	 printf("\n1)length of a string");
	 printf("\n2)Reverse the Given String");
	 printf("\n3)Check for palindrome");
	 printf("\n4)Copy");
	 printf("\n5)String Comparison");
	 printf("\n6)String Concatenation");
	 printf("\n7)String Searching");
	 printf("\n8)Counting of Words,Characters & Special Characters");
	 printf("\n9)Quit");
	 printf("\n\nEnter Your Choice:");
	 scanf("%d",&op);
	 flushall();
	 switch(op)
	  { case 1: printf("\n Enter a String:");
		    gets(a);
		    result=length(a);
		    printf("\n Length of %s=%d",a,result);
		    printf("\n\n press a Character !!!!!!");
		    getch();
		    break;

	    case 2: printf("\n Enter a String:");
		    gets(a);
		    reverse(a);
		    printf("\n Result=%s",a);
		    printf("\n\n press a Character !!!!!!");
		    getch();
		    break;
	     case 3: printf("\n Enter a String:");
		    gets(a);
		    result=palindrome(a);
		    if(result==0)
		      printf("\nNot a palindrome");
		    else
		      printf("\nA palindrome");
		     printf("\n\n press a Character !!!!!!");
		    getch();
		    break;
	    case 4: printf("\n Enter a String:");
		    gets(a);
		    copy(b,a);
		    printf("\nResult=%s",b);
		    printf("\n\n press a Character !!!!!!");
		    getch();
		    break;
	    case 5: printf("\n Enter 1st string:");
		    gets(a);
		    printf("\n Enter 2nd string:");
		    gets(b);
		    result=compare(a,b);
		    if(result==0)
		      printf("\nboth are same");
		    else
		       if(result>0)
			 printf("\n1st>2nd");
			   else
			     printf("\n1st<2nd");
		    printf("\n\n press a Character !!!!!!");
		    getch();break;
	    case 6: printf("\n Enter 1st string:");
		    gets(a);
		    printf("\n Enter 2nd string:");
		    gets(b);
		    concat(a,b);
		    printf("\nresult=%s",a);
		    printf("\n\n press a Character !!!!!!");
		    getch();break;
	    case 7: printf("\n Enter 1st string:");
		    gets(a);
		    printf("\n Enter 2nd string:");
		    gets(b);
		    search(a,b);
		    printf("\n\n press a Character !!!!!!");
		    getch();break;
	    case 8: printf("\n Enter a string:");
		    gets(a);
		    count(a);
		    printf("\n\n press a Character !!!!!!");
		    getch();break;
	    default : printf("\n A wrong Choice:");break;
	  }

       }while(op!=9);
  }

int length(char a[])
  { int i=0;
    /* sting is scanned from beginning and until reaches the '\0'
       character
    i will give length of the string
    function returns length of the string
    */

    while(a[i] !='\0')
      i++;
    return(i);
  }
void reverse(char a[])
   { int i,j;
     char temp;
     /* Algorithm used is an inplace Algorithm
       1. j is postioned on the last character
       2. i is postioned on the first character
       3. a[i] is interchanged with a[j]
       4. i is increased by 1 and j is decremented by 1
       5. if i<j then goto step 3
      */
      i=j=0;
      while(a[j]!='\0')
       j++;
      /* j is on the null character*/
      j--;
      while(i<j)
       { temp=a[i]; a[i]=a[j];a[j]=temp;
	 i++;j--;
       }
     }
int palindrome(char a[])
  { int i,j;
   /* Algorith used
      1. j is positioned on the last character
      2. i is positioned on the first character
      3. if a[i] != a[j] then it is not a palindrome,return(0)
      4. i is increased by 1 and j is decremented by 1
      5. if i<j then goto step 3
      6. string is a palindrome , return(1)
  */

     i=j=0;
      while(a[j]!='\0')
       j++;
      /* j is on the null character*/
      j--;/*j is on the last character*/
      while(i<j)
       { if(a[i]!=a[j])
	  return(0);
	 i++;j--;
       }
      return(1);
     }
  void copy(char b[],char a[])
     { int i=0;
       while(a[i]!='\0')
	{ b[i]=a[i];
	  i++;
	}
       b[i]='\0';
     }

  int compare(char a[],char b[])
     { int i;
       /* Algorithm
	  1.both the strings are compared,character by character
	    from the beginning
	  2.on first point of mismatch:
	     a.if(a[i]>b[i]) then a>b
	     b.if(a[i]<b[i]) then a<b
	  3. if both the strings end together then they are eqaul
   */
     i=0;
     while(a[i]!='\0')
      { if(a[i] > b[i])
	 return(1);
	if(a[i] < b[i])
	 return(-1);
	i++;
      }
      return(0);
    }
 void concat(char a[],char b[])
   { int i,j;
    /* Algorithm:
       1. i is position on null character in string a[]
       2. string b[] is appended at the end of,variable j is used
     */
    i=0;
    while(a[i]!='\0')
     i++;
    for(j=0;b[j]!='\0';i++,j++)
      a[i]=b[j];
    a[i]='\0';
  }
void search(char a[] ,char b[])
  { int i,j,lena,lenb;
    /*Algorithm
      1. lenb=length of string b[],lena=length of a[]
	string a[] is scanned using the variable i from location
	0 to length of a[]-lenb+1
      2. string b[] is matched in string a[] from the position i
    */
   for(lena=0;a[lena]!='\0';lena++);
   for(lenb=0;b[lenb]!='\0';lenb++);

   /* searching */
   for(i=0;i<=lena-lenb+1;i++)
    {
    for(j=0;a[i+j]==b[j]&&b[j]!='\0';j++);
	if(b[j]=='\0')
	  printf("\nstring found at location:%d",i+1);
    }
  }
 void count(char a[])
  { int words=0,characters=0,spchar=0,i;
    /*algorith
      1. function is isalnum() chaecks whether the current character
	 is an alphabet or a digit
      2. if the current character is an alphanumeric and previous
	 charater is not an alphanumeric then it is a word
      3. a word can start from beginning
     */
    for(i=0;a[i]!='\0';i++)
     { if(isalnum(a[i]) && (i==0 || !isalnum(a[i-1])))
	 words++;
       characters++;
       if(!isalnum(a[i]) && !isspace(a[i]))
	 spchar++;
    }
    printf("\n no of characters=%d",characters);
    printf("\n no of special characters=%d",spchar);
    printf("\n no of words=%d",words);
  }

/*
         *** OUTPUT ***
1)length of a string
2)Reverse the Given String
3)Check for palindrome
4)Copy
5)String Comparison
6)String Concatenation
7)String Searching
8)Counting of Words,Characters & Special Characters
9)Quit

Enter Your Choice:1

 Enter a String:maharastra

 Length of maharastra=10

 press a Character !!!!!!
1)length of a string
2)Reverse the Given String
3)Check for palindrome
4)Copy
5)String Comparison
6)String Concatenation
7)String Searching
8)Counting of Words,Characters & Special Characters
9)Quit

Enter Your Choice:2

 Enter a String:India

 Result=aidnI

 press a Character !!!!!!
1)length of a string
2)Reverse the Given String
3)Check for palindrome
4)Copy
5)String Comparison
6)String Concatenation
7)String Searching
8)Counting of Words,Characters & Special Characters
9)Quit

Enter Your Choice:3

 Enter a String:maharasta

Not a palindrome

 press a Character !!!!!!
1)length of a string
2)Reverse the Given String
3)Check for palindrome
4)Copy
5)String Comparison
6)String Concatenation
7)String Searching
8)Counting of Words,Characters & Special Characters
9)Quit

Enter Your Choice:4

 Enter a String:India

Result=India

 press a Character !!!!!!
1)length of a string
2)Reverse the Given String
3)Check for palindrome
4)Copy
5)String Comparison
6)String Concatenation
7)String Searching
8)Counting of Words,Characters & Special Characters
9)Quit

Enter Your Choice:5

 Enter 1st string:maharastra

 Enter 2nd string:shtra

1st<2nd

 press a Character !!!!!!
1)length of a string
2)Reverse the Given String
3)Check for palindrome
4)Copy
5)String Comparison
6)String Concatenation
7)String Searching
8)Counting of Words,Characters & Special Characters
9)Quit

Enter Your Choice:6

 Enter 1st string:maha

 Enter 2nd string:rastra

result=maharastra

 press a Character !!!!!!
1)length of a string
2)Reverse the Given String
3)Check for palindrome
4)Copy
5)String Comparison
6)String Concatenation
7)String Searching
8)Counting of Words,Characters & Special Characters
9)Quit

Enter Your Choice:7

 Enter 1st string:maharashtra

 Enter 2nd string:tra

string found at location:9

 press a Character !!!!!!
1)length of a string
2)Reverse the Given String
3)Check for palindrome
4)Copy
5)String Comparison
6)String Concatenation
7)String Searching
8)Counting of Words,Characters & Special Characters
9)Quit

Enter Your Choice:8

 Enter a string:"India is my country & I am proud to be an Indian."

 no of characters=51
 no of special characters=4
 no of words=11

 press a Character !!!!!!
1)length of a string
2)Reverse the Given String
3)Check for palindrome
4)Copy
5)String Comparison
6)String Concatenation
7)String Searching
8)Counting of Words,Characters & Special Characters
9)Quit

Enter Your Choice:9

*/


