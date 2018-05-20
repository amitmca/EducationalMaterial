using System;
using System.Data;
using System.Configuration;
using System.Collections;
using System.Web;
using System.Web.Security;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Web.UI.WebControls.WebParts;
using System.Web.UI.HtmlControls;
using System.Data.Odbc;
using System.IO;
using System.Data.OleDb;

/// <summary>
/// Summary description for Connection
/// </summary>
public class Connection
{
    public OleDbConnection conn;
    public OleDbCommand command;
    public OleDbDataAdapter myAdapter;
    public OleDbDataReader myreader;
    public DataSet ds;

    public static string[] discription = new string[100];
    public static string[] fieldname = new string[100];    
    public static string[] dataType = new string[100];
    public static int[] fieldseq = new int[100];
    public static int[] size = new int[100];

    public static string username = "";
    public static string bdcname = "";
    public static int count = 0, loadflag = 0, modifyFlag = 0;

    public Connection()
    {
        //Creating new connection
        string connectionString = @"Provider=Microsoft.Jet.OLEDB.4.0;Data Source=D:\Programs\yogesh\BDCConvertor\App_Data\bdcConvertor.mdb;Persist Security Info=True";
        conn = new OleDbConnection(connectionString);
         
    }

    public void openconn()
    {
        //Opening of the connection
        conn.Open();
    }

    public void executequery(string cmdstr)
    {
        {
            command = new OleDbCommand(cmdstr, conn);
            command.ExecuteNonQuery();
        }
    }
    public DataSet getDataset(string cmdstr)
    {
        ds = new DataSet();
        myAdapter = new OleDbDataAdapter(cmdstr, conn);

        myAdapter.Fill(ds);
        return ds;
    }
    public OleDbDataReader getDatareader(string cmdstr)
    {
        command = new OleDbCommand(cmdstr, conn);
        myreader = command.ExecuteReader();
        return myreader;
    }
    public void closeconn()
    {
        //Closing of the connection
        conn.Close();
    }
}


