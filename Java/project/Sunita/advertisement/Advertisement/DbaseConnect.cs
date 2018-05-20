using System;
using System.Data;
using System.Data.SqlClient;
using System.Configuration;

namespace Advertisement
{
	/// <summary>
	/// Summary description for DbaseConnect.
	/// </summary>
	public class DbaseConnect
	{
		public static  SqlConnection con=new SqlConnection (ConfigurationSettings.AppSettings["CONNECTION"]);
		public static  SqlDataAdapter sda;
		protected DataSet DS;

		public DbaseConnect()
		{
			//
			// TODO: Add constructor logic here
			//
		}

		public static SqlDataAdapter getDataAdapter(string cmdStr)
		{
			sda=new SqlDataAdapter (cmdStr,con);
			return sda;

		}
		public static SqlConnection getConnection()
		{
			con=new SqlConnection (ConfigurationSettings.AppSettings["CONNECTION"]);
			return con;
		}
	}
}
