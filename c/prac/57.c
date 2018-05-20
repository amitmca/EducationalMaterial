#include <stdio.h>
#include <conio.h>
void rev_str(char* s)
{
if(*s != '\0')
rev_str(s+1);
printf("%c",*s);
}
int main()
{
char *s;
clrscr();
printf("\nEnter the String here:");
scanf("%s",s);
rev_str(s);
getch();
return 0;
}