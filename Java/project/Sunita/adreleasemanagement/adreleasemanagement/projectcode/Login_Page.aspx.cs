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



namespace Group_17
{
	/// <summary>
	/// Summary description for WebForm1.
	/// </summary>
	public class WebForm1 : System.Web.UI.Page
	{
		protected System.Web.UI.WebControls.Label lblHeader;
		protected System.Web.UI.WebControls.Image imgSunrise;
		protected System.Web.UI.WebControls.Image imgSunset;
		protected System.Web.UI.HtmlControls.HtmlGenericControl grdLogin;
		protected System.Web.UI.WebControls.Label lblUsername;
		protected System.Web.UI.WebControls.Label lblPass;
		protected System.Web.UI.WebControls.TextBox txtUser;
		protected System.Web.UI.WebControls.Button btnLogin;
		protected System.Web.UI.WebControls.Button btnReset;
		protected System.Web.UI.WebControls.Label lblGridHead;
		protected System.Web.UI.WebControls.LinkButton lnkbtnForgotPass;
		protected System.Web.UI.WebControls.Label lblInvalidUser;
		protected System.Web.UI.WebControls.Label lblAdMessage;
		protected System.Web.UI.WebControls.TextBox txtPass;
		protected System.Web.UI.WebControls.RequiredFieldValidator rfvUsername;
		protected System.Web.UI.WebControls.RequiredFieldValidator rfvPassword;
		protected System.Web.UI.WebControls.Label lblMessage;
		protected System.Web.UI.HtmlControls.HtmlGenericControl grdImage;
	
		private void Page_Load(object sender, System.EventArgs e)
		{
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
			this.btnLogin.Click += new System.EventHandler(this.btnLogin_Click);
			this.btnReset.Click += new System.EventHandler(this.btnReset_Click);
			this.lnkbtnForgotPass.Click += new System.EventHandler(this.lnkbtnForgotPass_Click);
			this.Load += new System.EventHandler(this.Page_Load);

		}
		#endregion

		private void btnLogin_Click(object sender, System.EventArgs e)
		{
			
			
			SqlConnection con=new SqlConnection(ConfigurationSettings.AppSettings["DSN"]);
			
			con.Open();
			
			SqlCommand cmd=new SqlCommand("select ROLE from ADMGT_LOGIN_TB where PK_LOGIN_USER_NAME='"+					txtUser.Text+"' and	PASS_WORD='"+txtPass.Text+"'",con);

			string dr=Convert.ToString(cmd.ExecuteScalar());
			Session["ROLE"]=dr;
			Session["PK_LOGIN_USER_NAME"]=txtUser.Text;


			if(dr=="mgr")
			{
				
				Response.Redirect("Manager_Report.aspx");
			}
			else if(dr=="staff")
			{
				Response.Redirect("Staff_Report.aspx");
			}			
			else
			{
				
				lblInvalidUser.Text="Invalid User Name or Password";
				lblInvalidUser.Visible=true;
			}
		}
		
		private void btnReset_Click(object sender, System.EventArgs e)
		{
			
			
			lblInvalidUser.Visible=false;
			txtUser.Text="";
			txtPass.Text="";
			
		}

		private void lnkbtnForgotPass_Click(object sender, System.EventArgs e)
		{
			if(txtUser.Text=="")
			{
				lblInvalidUser.Text="Please enter user name";
				lblInvalidUser.Visible=true;
			}
			else
			{

				SqlConnection con=new SqlConnection(ConfigurationSettings.AppSettings["DSN"]);
				con.Open();
			
				SqlCommand cmd=new SqlCommand("select PK_LOGIN_USER_NAME from ADMGT_LOGIN_TB where							PK_LOGIN_USER_NAME='"+txtUser.Text+"'",con);

				int returnval=Convert.ToInt32(cmd.ExecuteScalar());
				if(returnval<=0)
				{
					lblInvalidUser.Text="Username InValid";
					lblInvalidUser.Visible=true;
				}
				else
				{
					lblInvalidUser.Visible=false;
					Server.Transfer("Forgot_Password.aspx");
				}
				con.Close();

			}

		
		}
		
	}
}
