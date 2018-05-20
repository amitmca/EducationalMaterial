import java.io.*;

class Data
	{
	private String data_str;
	Data(String s)
		{
		data_str=s;
		}
	public String getData()
		{
		return data_str;
		}
	public void print()
		{
		printer p=new printer();
		p.print(this);
		}
	}

class printer
	{	
	void print(Data d)
		{
		System.out.println(d.getData());
		}
	}

class this1	
	{
	public static void main(String args[])
		{
		Data obj=new Data("Amit");
		obj.print();
		}
	}