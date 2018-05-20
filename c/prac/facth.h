int non_rec(int x)
	{
	int f=1,i;
	for(i=1;i<=x;i++)
		{
		f=f*i;
		}
	return f;
	}
int rec(int x)
	{
	if(x==0)
		{
		return 1;
		}
	else
		{
		return (x*rec(x-1));
		}
	}