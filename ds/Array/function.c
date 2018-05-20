void bubble(int x[],int n)
	{
	int pass,j,switched=1,temp;
	for(pass=0;pass<n-1;pass++)
		{
		switched=0;
		for(j=0;j<n-pass-1;j++)
			{
			if(x[j] > x[j+1])
				{
				switched=1;
				temp=x[j];
				x[j]=x[j+1];
				x[j+1]=temp;
				}	
			}
		}
	}

