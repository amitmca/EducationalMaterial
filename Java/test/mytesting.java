


class mytesting
	{
	public static void main(String args[])
		{
		Exercise1 instance = new Exercise1();
                instance.go();
		int a=20;
		int b=a>>>2;
		System.out.println(b);
		}
	}

class Exercise1
 {

    public void go()	
    {
        int sum=0;
        int i = 0;
        while (i<100)
        {
            if (i == 0) sum = 100;
            sum = sum + i;
            i++;
        }
        System.out.println(sum);
    }
}

