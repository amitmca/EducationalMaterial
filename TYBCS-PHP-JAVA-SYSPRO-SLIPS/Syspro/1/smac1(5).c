#include<stdio.h>
#include<stdlib.h>

long int mem[1000];
int lc,reg[4];

void load()
{
	FILE *fp;
	char fname[20];
	printf("Enter file name:");
	scanf("%s",fname);
	fp=fopen(fname,"r");
	while(!feof(fp))
	{
		fscanf(fp,"%ld",&mem[lc]);
		lc++;
	}
	fclose(fp);
}

void print()
{
	int i;
	for(i=100;i<lc-1;i++)
	{
	printf("%ld\n",mem[i]);
	}
}

void run()
{
	int opcode,i,r,add;
	for(i=100;i<lc-1;i++)
	{
	opcode=mem[i]/10000;
	r=(mem[i]%10000)/1000;
	add=(mem[i]%10000)%1000;
	switch(opcode)
	{
		case 0:
			break;
		case 1:
			reg[r]=reg[r]+mem[add];
			break;
		case 2:
			reg[r]=reg[r]-mem[add];
			break;
		case 3:
			reg[r]=reg[r]*mem[add];
			break;
		case 4:
			reg[r]=mem[add];
			break;
		case 5:
			mem[add]=reg[r];
			break;
		case 8:
			reg[r]=reg[r]/mem[add];
			break;
		case 9:
			printf("\nEnter number:");
			scanf("%d",&mem[add]);
			break;
		case 10:
			printf("Result:%d\n",mem[add]);
			break;
		
		}
	}
}

main()
{
	
	int ch;
	while(1)
	{
		printf("1 :load\n");
		printf("2 :print\n");
		printf("3 :run\n");
		printf("4 :exit\n");
		printf("Enter the choice:\n");
		scanf("%d",&ch);
		switch(ch)
		{
			case 1:	lc=100;
				load();
				break;
			case 2:
				print();
				break;
			case 3:
				run();
				break;
			case 4:
				exit(0);
		}
	}
}
