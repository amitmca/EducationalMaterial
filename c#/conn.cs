	using System;
	using System.Data;
	using System.Data.ADO;
	
	public class conn
	{
	public static void Main(string[] args)
		{
		try
			{
			string d=
				"Provider=Microsoft.jet.OLEDB.4.0;Data Source="+args[0];
			ADOConnection c=new ADOConnection(d);
			System.Console.WriteLine("Connected Successfully");
			}
		catch(Exception e)
			{
			}
		}
	}	