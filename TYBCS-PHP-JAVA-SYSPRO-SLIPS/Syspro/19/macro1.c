#include<stdio.h>
#include<stdlib.h>
#include<string.h>

char fname[20],buffer[30],t1[20],t2[20],t3[20];
int n,i;
struct MNT
{
	char mname[20];
	int pp,kp,kpdtp,mdtp;
}mnt[10];
struct KPDT
{
	char kname[10],value[20];
}kpdt[20];
struct MDT
{
	char opcode[20];
	int value;
}mdt[30];
char PNT[10][20];
int mntp=0,pntp=0,kpdtp=0,mdtp=0;

void store()
{
	FILE *fp;
	fp=fopen(fname,"r");
	if(fp==NULL)
	{
		printf("error");
	}
	else
	{
		while(fgets(buffer,80,fp))
		{
			n=sscanf(buffer,"%s%s%s",t1,t2,t3);//buffer stores 1st line of macrocopy.txt file:MACRO
			if(strcmp(t1,"MACRO")==0 && n==1)
			{
				fgets(buffer,80,fp);
				sscanf(buffer,"%s%s",t1,t2);//Buffer stores 2nd line of macrocopy.txt file
				addmnt(t1);
				add_parameter(t2);
			}
		}
	}
	fclose(fp);
}
void addmnt(char *s)
{
	strcpy(mnt[mntp].mname,s);
	mnt[mntp].kpdtp=kpdtp;
	mnt[mntp].mdtp=mdtp;
}
void add_parameter(char *s)
{
	char temp[20],temp1[20];
	int k=0,j=0,l=0;
	strcat(s,",");
	while(*s)      //Positional parameters
	{	
		if(*s==',')
		{
			temp[j]='\0';
			strcpy(PNT[pntp],temp);
			pntp++;
			k++;
			j=0;
		}
		else if(*s=='=')
		{
			break;
		}
		else if(*s!='&')
		{
			temp[j]=*s;
			j++;
		}
		s++;
	}
	mnt[mntp].pp=k;
	k=0;
	while(*s)  //keyword parameter
	{	
		if(*s=='=')
		{
			s++;
			while(*s!=',')
			{
				temp1[l]=*s;
				l++;
				s++;
			}
			temp[l]='\0';
		}
		if(*s==',')
		{
			temp1[l]='\0';
			strcpy(PNT[pntp],temp);
			pntp++;
			k++;
			j=0;
			strcpy(kpdt[kpdtp].kname,temp);
			strcpy(kpdt[kpdtp].value,temp1);
			kpdtp++;
			l=0;
		}
		
		else if(*s!='&')
		{
			temp[j]=*s;
			j++;
		}
		s++;
	}
	
}
void display_mnt()
{
	printf("\nMacro Name Table");
	for(i=0;i<=mntp;i++)
	{
		printf("\n%s\t%d\t%d\n",mnt[i].mname,mnt[i].kpdtp,mnt[i].mdtp);
	}
}
void display_pnt()
{
	printf("\nParameter Name Table");
	for(i=0;i<=pntp;i++)
	{
		printf("\n%s",PNT[i]);
	}
}
void display_kp()
{
	printf("\nKeyword Parameter Tabel");
	for(i=0;i<=kpdtp;i++)
	{
		printf("\n%s\t%s\t",kpdt[i].kname,kpdt[i].value);
	}
}
main(int argc,char *argv[])
{
	if(argc>1)
	{
		strcpy(fname,argv[1]);
		store();
		display_mnt();
		display_pnt();
		display_kp();
	}
	else
	{
		printf("Enter name of macro file");
		exit(0);
	}
}
