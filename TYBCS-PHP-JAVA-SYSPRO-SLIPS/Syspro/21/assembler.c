#include<stdio.h>
#include<string.h>
char *mne[15]={"STOP","ADD","SUB","MULT","MOVER","MOVEM","BC","COMP","DIV","READ","PRINT","DS","DC","START","END"};
char *reg[4]={"AREG","BREG","CREG","DREG"};
char *cc[6]={"LT","LE","EQ","GT","GE","ANY"};
struct symtab
{
	char sym[20];
	int add;
	int used;
	int defined;
}sym[50];
struct errtab
{
	int lineno;
	int errno;
	char msg[20];
}err[50];
char fname[20],state[30],t1[10],t2[10],t3[10],t4[10];
FILE *fp;
int lc,tscnt=0,tecnt=0;
void display()
{
 	printf("Enter the file name\n");
 	scanf("%s",fname);
 	fp=fopen(fname,"r");
 	while(!feof(fp))
 	{
 		fgets(state,30,fp);
 		sscanf(state,"%s%s%s%s",t1,t2,t3,t4);
 		if(strcmp(t1,"START")==0)
 		lc=atoi(t2)-1;
 		printf("\n%d  %s",lc,state);
 		lc++;
 	}
 fclose(fp);
 }
 int searchop(char s[])
 {
 	int k;
 	for(k=0;k<15;k++)
 	{
 		if(strcmp(s,mne[k])==0)
 		return(k);
 	}
 	return(-1);
 	
 }
 int searchsym(char s[])
 {	
 	int k;
 	for(k=0;k<tscnt;k++)
 	{
 		if(strcmp(t2,sym[k].sym)==0)
 		return(k);
 	}
 	return(-1);
 }
 int searchcond(char s[])
 {
 	int k;
 	for(k=0;k<6;k++)
 	{
 		if(strcmp(s,cc[k])==0)
 		return(k);
 	}
 	return(-1);
 }
 int searchreg(char s[])
 {
 	int k;
 	for(k=0;k<4;k++)
 	{
 		if(strcmp(s,reg[k])==0)
 		return(k);
 	}
 	return(-1);
 }	
 void passone()
 {	
 	int n,i,j;
 	printf("Enter the file name\n");
 	scanf("%s",fname);
 	fp=fopen(fname,"r");
 	while(!feof(fp))
 	{	
 		strcpy(t1,"\0");
 		strcpy(t2,"\0");
 		strcpy(t3,"\0");
 		strcpy(t4,"\0");
 		fgets(state,30,fp);
 		n=sscanf(state,"%s%s%s%s",t1,t2,t3,t4);
 		switch(n)
 		{
 			case 1:i=searchop(t1);
 				if(i==-1)
 				{
 					strcpy(err[tecnt].msg,"Invalid Opcode");
 					err[tecnt].errno=1;
 					err[tecnt].lineno=lc;
 					tecnt++;
 				}
 				break;
 			case 2:i=searchop(t1);
 				if(i==13 || i==14)
 				lc=atoi(t2)-1;
 				else if(i==9 || i==10)
	 			{
	 				j=searchsym(t2);
	 				if(j==-1)
	 				{
	 					strcpy(sym[tscnt].sym,t2);
	 					sym[tscnt].used=1;
	 					tscnt++;
	 				}
 				}
 				else
 				{ 
 					strcpy(err[tecnt].msg,"Invalid Opcode");
 					err[tecnt].errno=1;
 					err[tecnt].lineno=lc;
 					tecnt++;
 				}
 				break;
			case 3:i=searchop(t1);
				if(i>=1 && i<=8)
				{
					if(i==6)
					{
					 j=searchcond(t2);
					 if(j==-1)
					strcpy(err[tecnt].msg,"Wrong Statement");
 					err[tecnt].errno=2;
 					err[tecnt].lineno=lc;
 					tecnt++;
					 }
					else
					{
					j=searchreg(t2);
					if(j==-1)
					strcpy(err[tecnt].msg,"Wrong Statement");
 					err[tecnt].errno=2;
 					err[tecnt].lineno=lc;
 					tecnt++;
					}
					j=searchsym(t2);
	 				if(j==-1)
	 				{
	 				strcpy(sym[tscnt].sym,t2);
	 				sym[tscnt].used=1;
	 				tscnt++;
	 				}
				}
				else
				{
					i=searchop(t2);
					if(i==9 || i==10)
					{
						j=searchsym(t3);
						if(j==-1)
	 					{
	 						strcpy(sym[tscnt].sym,t3);
	 						sym[tscnt].used=1;
	 						tscnt++;
	 					}
	 					j=searchsym(t1);
						if(j==-1)
	 					{
	 						strcpy(sym[tscnt].sym,t1);
	 						sym[tscnt].used=1;
	 						tscnt++;
	 					}
							
					}
					else if(i==11 || i==12)
					{
						j=searchsym(t1);
						if(j==-1)
						{
							strcpy(sym[tscnt].sym,t1);
							sym[tscnt].defined=1;
							sym[tscnt].add=lc;
							tscnt++;
						}
						else
						{
							sym[j].defined=1;
							sym[j].add=lc;
						}
					}
					else
					{
						strcpy(err[tecnt].msg,"Invalid Opcode");
 						err[tecnt].errno=1;
 						err[tecnt].lineno=lc;
 						tecnt++;	
					}	
				}
				break;
			case 4:i=searchop(t2);
				if(i>=1 && i<=8)
				{
					if(i==6)
					{
					 j=searchcond(t3);
					 if(j==-1)
					strcpy(err[tecnt].msg,"Wrong Statement");
 					err[tecnt].errno=2;
 					err[tecnt].lineno=lc;
 					tecnt++;
					 }
					else
					{
					j=searchreg(t3);
					if(j==-1)
					strcpy(err[tecnt].msg,"Wrong Statement");
 					err[tecnt].errno=2;
 					err[tecnt].lineno=lc;
 					tecnt++;
					}
					j=searchsym(t4);
	 				if(j==-1)
	 				{
	 				strcpy(sym[tscnt].sym,t4);
	 				sym[tscnt].used=1;
	 				tscnt++;
	 				}
	 				j=searchsym(t1);
	 				if(j==-1)
	 				{
	 				strcpy(sym[tscnt].sym,t1);
	 				sym[tscnt].used=1;
	 				tscnt++;
	 				}
				}
				break;
		} lc++;
 	}
 	for(j=0;j<tscnt;j++)
 	{	
 		int i=0;int a[20];
 		if((sym[j].defined)!=1)
 		{
 			strcpy(err[tecnt].msg,"Used but not defined");
 		}
 	}
 fclose(fp);
 } 
 void displayerr()
 {
 	int k;
 	printf("\n Error Table \n");
 	printf("Line no\tError no\tError Messege\n");
 	for(k=0;k<tecnt;k++)
 	{
 		printf("%d\t%d\t%s",err[k].lineno,err[k].errno,err[k].msg);
 		printf("\n");
 	}
 }
 void displaysym()
 {
 	int k;
 	printf("\n Symbol Table \n");
 	printf("Symbol\taddress\tDefined\tused\n");
 	for(k=0;k<tecnt;k++)
 	{
 		printf("%s\t%d\t%d\t%d",sym[k].sym,sym[k].add,sym[k].used,sym[k].defined);
 		printf("\n");
 	}
 }		
main()
{
	display();
	passone();
	displayerr();
	displaysym();
}
