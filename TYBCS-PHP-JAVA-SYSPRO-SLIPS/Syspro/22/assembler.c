#include<stdio.h>
#include<string.h>
char *mne[15]={"STOP","ADD","SUB","MULT","MOVER","MOVEM","BC","COMP","DIV","READ","PRINT","DS","DC","START","END"};
char *reg[4]={"AREG","BREG","CREG","DREG"};
char *cc[6]={"LT","LE","EQ","GT","GE","ANY"};
struct symtab
{
	char symbol[20];
	int add;
	int used;
	int defined;
}sym[50];
struct errtab
{
	int lineno;
	int errno;
	char errmsg[30];
}err[50];
struct ictab
{
	int address;
	int opcode;
	int regop;
	char optype;
	int value;
}ic[50];
FILE *fp;
char fname[30];
char state[40];
char t1[10],t2[10],t3[10],t4[10];
int lc,tscnt=0,tecnt=0;tcnt=0;
void display()
{
	printf("Enter file name:");
	scanf("%s",fname);
	fp=fopen(fname,"r");
	while(!feof(fp))
	{
		fgets(state,40,fp);
		sscanf(state,"%s%s%s%s",t1,t2,t3,t4);
		if(strcmp(t1,"START")==0)
		lc=atoi(t2)-1;
                printf("\n%d %s",lc,state);
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
		return (k);
	}
	return (-1);
}
int searchsym(char s[])
{
	int k;
	for(k=0;k<tscnt;k++)
	{
		if(strcmp(s,sym[k].symbol)==0)
		return k;
	}
	return (-1);
}
int searchcond(char s[])
{
	int k;
	for(k=0;k<6;k++)
	{
		if(strcmp(s,cc[k])==0)
		return k;
	}
	return (-1);
}
int searchreg(char s[])
{
	int k;
	for(k=0;k<4;k++)
	{
		if(strcmp(s,reg[k])==0)
		return k;
	}
	return (-1);
}
void passone()
{
	int i,n,j;
        printf("Enter file name:");
	scanf("%s",fname);
	fp=fopen(fname,"r");
	while(!feof(fp))
	{
		strcpy(t1,"\0");
		strcpy(t2,"\0");
		strcpy(t3,"\0");
		strcpy(t4,"\0");
		fgets(state,40,fp);
		n=sscanf(state,"%s%s%s%s",t1,t2,t3,t4);
		switch(n)
		{
			case 1:i=searchop(t1);
				if(i==-1)
				{
					strcpy(err[tecnt].errmsg,"Invalid opcode");
					err[tecnt].errno=1;
					err[tecnt].lineno=lc;
					tecnt++;
				}
				break;
			case 2:i=searchop(t1);
				if(i==13||i==14)
				lc=atoi(t2)-1;
				else if(i==9||i==10)
				{
					j=searchsym(t2);
					if(j==-1)
					{
						strcpy(sym[tscnt].symbol,t2);
						sym[tscnt].used=1;
						tscnt++;
					}
				}
				else
				{
					strcpy(err[tecnt].errmsg,"Invalid opcode");
					err[tecnt].errno=1;
					err[tecnt].lineno=lc;
					tecnt++;	
				}
				break;
			case 3:i=searchop(t1);
				if(i>=1 && i<=8)
				{
					if(i==7)
					{
						j=searchcond(t2);
						if(j==-1)
						{
				strcpy(err[tecnt].errmsg,"wrong statement format");
							err[tecnt].errno=2;
							err[tecnt].lineno=lc;
							tecnt++;		
						}
					}
					else
					{
						j=searchreg(t2);
						if(j==-1)
						{
				strcpy(err[tecnt].errmsg,"wrong statement format");
							err[tecnt].errno=2;
							err[tecnt].lineno=lc;
							tecnt++;		
						}
					}
				}
				else
				{
					i=searchop(t2);
					if(i==9||i==10)
					{
						j=searchsym(t3);
						if(j==-1)
						{	
							strcpy(sym[tscnt].symbol,t3);
							sym[tscnt].used=1;
							tscnt++;
						}
						j=searchsym(t1);
						if(j==-1)
						{	
							strcpy(sym[tscnt].symbol,t1);
							sym[tscnt].used=1;
							tscnt++;
						}
					}
					else if(i==11||i==12)
					{
						j=searchsym(t1);
						if(j==-1)
						{
							strcpy(sym[tscnt].symbol,t1);
							j=searchsym(t3);
							if(j==-1)
							{	
							strcpy(sym[tscnt].symbol,t3);
							sym[tscnt].used=1;
							tscnt++;
							}
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
				strcpy(err[tecnt].errmsg,"wrong statement format");
				err[tecnt].errno=2;
				err[tecnt].lineno=lc;
				tecnt++;		
					}
				}
				break;
		
			case 4:i=searchop(t2);
					if(i>=1 && i<=8)
					{
						if(i==7)
						{
			j=searchcond(t3);
			if(j==-1)
			{
			strcpy(err[tecnt].errmsg,"wrong statement format");
			err[tecnt].errno=2;
			err[tecnt].lineno=lc;
			tecnt++;		
			}
			}
			else
						
			{
			j=searchreg(t3);
			if(j==-1)
			{
				strcpy(err[tecnt].errmsg,"wrong statement format");
				err[tecnt].errno=2;
				err[tecnt].lineno=lc;
				tecnt++;		
			}
		}
					
						
			j=searchsym(t4);
			if(j==-1)
			{	
				strcpy(sym[tscnt].symbol,t4);
				sym[tscnt].used=1;
				tscnt++;
			}
						
												
			j=searchsym(t1);
			if(j==-1)
			{	
				strcpy(sym[tscnt].symbol,t1);
				sym[tscnt].used=1;
				tscnt++;
			}
						
		}
		break;
		}
		lc++;
	}
	for(j=0;j<tscnt;j++)
	{
		if((sym[j].defined)!=1)
		{
			strcpy(err[tecnt].errmsg,"used but not defined");
		}
		
	}
	fclose(fp);
}
void displayerror()
{
	int k;
	printf("\nError Table\n");
	printf("Lineno\tErrorno\t\tErrormsg\n");
	for(k=0;k<tecnt;k++)
	{
		printf("%d\t%d\t\t%s\n",err[k].lineno,err[k].errno,err[k].errmsg);
	}
}
void displaysym()
{
	int k;
	printf("\nSymbol Table\n");
	printf("Symbol\tAddress\tUsed\tDefined\n");
	for(k=0;k<tscnt;k++)
	{
		printf("%s\t%d\t%d\t%d\n",sym[k].symbol,sym[k].add,sym[k].used,sym[k].defined);
	}
}
void passtwo()
{
	int i,n,j;
        printf("Enter file name:");
	scanf("%s",fname);
	fp=fopen(fname,"r");
	while(!feof(fp))
	{
		strcpy(t1,"\0");
		strcpy(t2,"\0");
		strcpy(t3,"\0");
		strcpy(t4,"\0");
		fgets(state,40,fp);
		n=sscanf(state,"%s%s%s%s",t1,t2,t3,t4);
		switch(n)
		{
		case 1:i=searchop(t1);
			if(i==0||i==14)
			{
				ic[tcnt].address=lc;
				ic[tcnt].opcode=i;
				ic[tcnt].regop=0;
				tcnt++;
			}
			break;
		case 2:i=searchop(t1);
			if(i==13)
			lc=atoi(t2)-1;
			else if(i==9||i==10)
			{
				ic[tcnt].address=lc;
				ic[tcnt].opcode=i;
				ic[tcnt].regop=0;
				ic[tcnt].optype='s';
				ic[tcnt].value=0;
				tcnt++;
			}
			break;

		case 3:i=searchop(t1);
			if(i>=1&&i<=8)
			{
				if(i==7)
				{
					j=searchcond(t2);
					ic[tcnt].address=lc;
					ic[tcnt].opcode=i;
					ic[tcnt].regop=j;
				}
				else
				{
					j=searchreg(t2);
					ic[tcnt].address=lc;
					ic[tcnt].opcode=i;
					ic[tcnt].regop=j;
				}
				j=searchsym(t3);
				ic[tcnt].optype='s';
				ic[tcnt].value=0;
				tcnt++;
			}
			else
			{
				j=searchop(t2);
				if(j==9||j==10)
				{
				ic[tcnt].address=lc;
				ic[tcnt].opcode=i;
				ic[tcnt].regop=0;
				ic[tcnt].optype='s';
				ic[tcnt].value=0;
				tcnt++;
				}
				else if(i==11||i==12)
				{
				ic[tcnt].address=0;
				ic[tcnt].opcode=0;
				ic[tcnt].regop=0;
				ic[tcnt].optype=0;
				ic[tcnt].value=0;
				tcnt++;
				}
			case 4:	i=searchop(t2);
			if(i>=1&&i<=8)
			{
				if(i==7)
				{
					j=searchcond(t3);
					ic[tcnt].address=lc;
					ic[tcnt].opcode=i;
					ic[tcnt].regop=j;
				}
				else
				{
					j=searchreg(t3);
					ic[tcnt].address=lc;
					ic[tcnt].opcode=i;
					ic[tcnt].regop=j;
				}
				j=searchsym(t4);
				ic[tcnt].optype='s';
				ic[tcnt].value=0;
				tcnt++;
			}
			
				
			}
			break;
		}lc++; 
	}fclose(fp); //closing of while loop
}
void displayic()
{
	int k;
	printf("\nIntermediate Code Table\n");
	printf("Address\tOpcode\tRegop\tOptype\tValue\n");
	for(k=0;k<tcnt;k++)
	{
		printf("%d\t%d\t%d\t%c\t%d\n",ic[k].address,ic[k].opcode,ic[k].regop,ic[k].optype,ic[k].value);
	}
}			
		
main()
{
        display();
	passone();
	if(tecnt==0)
	{
		displaysym();
		passtwo();
		displayic();
	}
	else
	{
		displayerror();
		exit(0);
	}

}
