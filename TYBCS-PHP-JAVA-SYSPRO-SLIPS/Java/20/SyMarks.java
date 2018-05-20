package SY;

public class SyMarks
{
	int comp,math,elec;
	public SyMarks()
	{
		comp=math=elec=0;
	}
	public SyMarks(int comp,int math,int elec)
	{
		this.comp=comp;
		this.math=math;
		this.elec=elec;

	}
	public void display()
	{
	 	System.out.println("MARKSHEET OF SY:");
		System.out.println("MARKS OF COMP:"+comp);
		System.out.println("MARKS OF MATH:"+math);
		System.out.println("MARKS OF ELEC:"+elec);
	}
 	public int cal()
	{
		return(comp+math+elec);
	} 
	

}
