package TY;
 
public class TyMarks
{
	int tm;
	int pm;
	
	public TyMarks()
	{

	}
	public TyMarks(int tm,int pm)
	{
		this.tm=tm;
		this.pm=pm;
	}
        public int cal()
	{
		return(tm+pm);

	}	
	
	public void display()
	{
		System.out.println("MARKSHEET OF TY:");
		System.out.println("MARKS OF THEORY:"+tm);
		System.out.println("MARKS OF PRACT:"+pm);
		
		
	}

}
