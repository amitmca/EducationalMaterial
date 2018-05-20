import SY.*;
import TY.*;
import java.lang.*;

class StudentClass
{
	int rn;
	String name;
	int tot;
	float per;
	SY.SyMarks sy;
	TY.TyMarks ty;
	 
	
	StudentClass()
	{

	}
	StudentClass(int rn,String name,int comp,int math,int elec,int tm,int pm)
	{
		this.rn=rn;
		this.name=name;
		sy= new SY.SyMarks(comp,math,elec);
		ty= new TY.TyMarks(tm,pm);		
	
	}
	void cal()
	{	int x = sy.cal();
		int y = ty.cal();
		per = (x+y)/5;
		if(per>=75)
		{
			System.out.println("STUDENT GOT A GRADE");
		}
		else if(per<75 && per>=60)
		{
			System.out.println("STUDENT GOT B GRADE");
		}
		else if(per<60 && per>=40)
		{
			System.out.println("STUDENT GOT C GRADE");
		}
		else if(per<40 && per>=20)
		{
			System.out.println("STUDENT FAILS....!!!");
		}


	}	
	


	void display()
	{
		System.out.println("Student info...");
		System.out.println("Roll No:"+rn);
		System.out.println("Name:"+name);
			
		sy.display();
		ty.display();	
	}

}
class details
{
	public static void main(String args[])throws Exception
	{
		StudentClass s=new StudentClass(101,"ABCD",50,50,50,50,50);
		s.display();
		s.cal();


	}



}
