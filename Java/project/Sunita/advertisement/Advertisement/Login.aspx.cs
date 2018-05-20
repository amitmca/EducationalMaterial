using System;
using System.Collections;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Web;
using System.Web.SessionState;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Web.UI.HtmlControls;
using System.Data.SqlClient;
using System.Configuration;

namespace Advertisement
{
	/// <summary>
	/// Summary description for WebForm1.
	/// </summary>
	/// 
	
	public class WebForm1 : System.Web.UI.Page
	{
		//This Webform is Used for Logging the User
		protected System.Web.UI.WebControls.RequiredFieldValidator fldvldUserId;
		protected System.Web.UI.WebControls.RequiredFieldValidator fldvldPassword;
		protected System.Web.UI.WebControls.Label lblTitle;
		protected DataSet DS;
		protected System.Web.UI.WebControls.Label lblError;
		protected SqlDataAdapter dataAdapter;
		protected System.Web.UI.WebControls.Panel Panel1;
		protected System.Web.UI.WebControls.TextBox txtUserId;
		protected System.Web.UI.WebControls.TextBox txtPassword;
		protected System.Web.UI.WebControls.Label lblPassword;
		protected System.Web.UI.WebControls.Button cmdLogin;
		protected System.Web.UI.WebControls.Label lblUserId;
		protected SqlConnection sqlConnection;
	
		private void Page_Load(object sender, System.EventArgs e)
		{
			// Put user code to initialize the page here.
		}

		#region Web Form Designer generated code
		override protected void OnInit(EventArgs e)
		{
			//
			// CODEGEN: This call is required by the ASP.NET Web Form Designer.
			//
			InitializeComponent();
			base.OnInit(e);
		}
		
		/// <summary>
		/// Required method for Designer support - do not modify
		/// the contents of this method with the code editor.
		/// </summary>
		private void InitializeComponent()
		{    
			this.cmdLogin.Click += new System.EventHandler(this.cmdLogin_Click);
			this.Load += new System.EventHandler(this.Page_Load);

		}
		#endregion

		private void cmdLogin_Click(object sender, System.EventArgs e)
		{
				string userName=txtUserId.Text;  //userName Stores UserId entered by User.
			    string password=txtPassword.Text; //password Stores Password entered by User.

				sqlConnection=new SqlConnection(ConfigurationSettings.AppSettings["CONNECTION"]);
				dataAdapter=new SqlDataAdapter("select * from Ad_Login_TB where User_Id='"+userName+"'",sqlConnection);
				
			    DS=new DataSet(); //DS Holds DataSet For Login Table.
			    dataAdapter.Fill(DS, "Ad_Login_TB");
				
			//Check For Valid User If so Create Session and Redirect to Actual Home Page.
			if( DS.Tables[0].Rows.Count==0 || password != DS.Tables[0].Rows[0][1].ToString())
			{
				lblError.Visible=true;
			}
			else
			{
				//Create Session For Each User And Redirect to Actual User Login Page.
				Session["UserName"]=userName;
				//Set Session TimeOut.
				Session.Timeout =30;
				Response.Redirect("Frame.htm");
			}
			    
		}
	}
}
