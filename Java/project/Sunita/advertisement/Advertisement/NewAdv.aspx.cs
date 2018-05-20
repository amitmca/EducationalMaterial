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
	/// Summary description for NewAdv.
	/// </summary>
	public class NewAdv : System.Web.UI.Page
	{
		protected System.Web.UI.WebControls.TextBox txtAdName;
		protected System.Web.UI.WebControls.TextBox txtAdDuration;
		protected System.Web.UI.WebControls.TextBox txtStartDate;
		protected System.Web.UI.WebControls.TextBox txtEndDate;
		protected System.Web.UI.WebControls.Label lblAdName;
		protected System.Web.UI.WebControls.Label lblAdvName;
		protected System.Web.UI.WebControls.Label lblStartDate;
		protected System.Web.UI.WebControls.Label lblEndDate;
		protected System.Web.UI.WebControls.Label lblDuration;
		protected System.Web.UI.WebControls.Label lblRotations;
		protected System.Web.UI.WebControls.TextBox txtRotations;
		protected System.Web.UI.WebControls.TextBox txtTotAmt;
		protected System.Web.UI.WebControls.TextBox txtAmtPaid;
		protected System.Web.UI.WebControls.Label lblTotAmt;
		protected System.Web.UI.WebControls.Label lblAmtPaid;
		protected System.Web.UI.WebControls.Calendar calStartDate;
		protected System.Web.UI.WebControls.Calendar calEndDate;
		protected System.Web.UI.WebControls.Label lblNewHeader;
		protected System.Web.UI.WebControls.RequiredFieldValidator fldvldAdName;
		protected System.Web.UI.WebControls.RequiredFieldValidator fldvldAdvName;
		protected System.Web.UI.WebControls.ImageButton cmdStartDate;
		protected System.Web.UI.WebControls.ImageButton cmdEndDate;
		protected System.Web.UI.WebControls.Button cmdSubmit;
		protected System.Web.UI.WebControls.TextBox txtAdvName;
		protected SqlConnection sqlCon;
		protected SqlCommand sqlCmd;
		protected System.Web.UI.WebControls.Label lblDispMsg;
		protected System.Web.UI.WebControls.RegularExpressionValidator expvldDuration;
		protected System.Web.UI.WebControls.RegularExpressionValidator expvldRotations;
		protected System.Web.UI.WebControls.RegularExpressionValidator expvldTotAmt;
		protected System.Web.UI.WebControls.RegularExpressionValidator expvldAmtPaid;
		protected System.Web.UI.WebControls.Label lblTemp;
		protected System.Web.UI.WebControls.RegularExpressionValidator expvldAdName;
		protected System.Web.UI.WebControls.RegularExpressionValidator expvldAdvName;
		protected SqlDataReader sqlDataRdr;
		
		
	
		private void Page_Load(object sender, System.EventArgs e)
		{

			//Check for session , if session is not available then redirect to InvalidSession.aspx Page.
			if(Session["UserName"]==null)
			{
				Response.Redirect ("InvalidSession.aspx");
			}
			else
			{
				if(!Page.IsPostBack )
				{
					//Set Start Date And End Date to Todays Date by default.
					txtStartDate.Text=calStartDate.TodaysDate.ToShortDateString();
					txtEndDate.Text=calEndDate.TodaysDate.ToShortDateString();
				}
			}
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
			this.calStartDate.SelectionChanged += new System.EventHandler(this.calStartDate_SelectionChanged);
			this.calEndDate.SelectionChanged += new System.EventHandler(this.calEndDate_SelectionChanged);
			this.cmdSubmit.Click += new System.EventHandler(this.cmdSubmit_Click);
			this.cmdStartDate.Click += new System.Web.UI.ImageClickEventHandler(this.cmdStartDate_Click);
			this.cmdEndDate.Click += new System.Web.UI.ImageClickEventHandler(this.cmdEndDate_Click);
			this.Load += new System.EventHandler(this.Page_Load);

		}
		#endregion

		

		private void calStartDate_SelectionChanged(object sender, System.EventArgs e)
		{
			//Get selected Date from calender and assign to Textfield and Hide the Calender.
			txtStartDate.Text=calStartDate.SelectedDate.ToShortDateString().ToString();
			calStartDate.Visible=false;
		}

		private void calEndDate_SelectionChanged(object sender, System.EventArgs e)
		{
			//Get selected Date from calender and assign to Textfield and Hide the Calender.
			txtEndDate.Text=calEndDate.SelectedDate.ToShortDateString().ToString();
			calEndDate.Visible=false;
		}

		private void cmdStartDate_Click(object sender, System.Web.UI.ImageClickEventArgs e)
		{
				//Make Start Calender Visible.
				calStartDate.Visible=true;
		}

		private void cmdEndDate_Click(object sender, System.Web.UI.ImageClickEventArgs e)
		{
			//Make End Calender Visible.
			calEndDate.Visible=true;
		}

		private void cmdSubmit_Click(object sender, System.EventArgs e)
		{	
				//Establish Connection with Database , get a Query String from Web.config with key 'CONNECTION'.
			    sqlCon=new SqlConnection(ConfigurationSettings.AppSettings["CONNECTION"]);
			
			DateTime dtStart=Convert.ToDateTime (txtStartDate.Text);
			DateTime dtEnd=Convert.ToDateTime(txtEndDate.Text);
			int intDateRes =dtEnd.CompareTo(dtStart);

			if(intDateRes<0)
			{
				lblTemp .Text ="Start Date Cannot Be Greater ";
			}
			else
			{
			
				
			
				//Counting The No. Of Rows in The Table and adding count value to a fixed value ie 101 and incrementing the count value.
				lblTemp.Text ="";
				int intRowCount=101;
				//SqlDataAdapter sdaCount=new SqlDataAdapter("select count(*) from Ad_AdvDetails_TB",sqlCon);
				SqlDataAdapter sdaCount=new SqlDataAdapter("select max(Ad_Id) from Ad_AdvDetails_TB",sqlCon);
				DataSet DSCount=new DataSet();
				sdaCount.Fill(DSCount,"Ad_AdvDetails_TB");
				intRowCount=Convert.ToInt32(DSCount.Tables[0].Rows[0][0]);
				intRowCount++;
				//Inserting the Data into the Ad_AdvDetails_TB Table.
				string insertStr="insert into Ad_AdvDetails_TB values("+intRowCount+",'"+txtAdName.Text+"','"+txtAdvName.Text+"','"+txtStartDate.Text+"','"+txtEndDate.Text+"',"+txtAdDuration.Text+","+txtRotations.Text+","+txtTotAmt.Text+","+txtAmtPaid.Text+",0)";
				int status=-1;
				
				//Open Connection , Execute Query and Close Connection.
				sqlCmd=new SqlCommand(insertStr);
				sqlCmd.Connection=sqlCon;
				sqlCon.Open();
				status=sqlCmd.ExecuteNonQuery();
				sqlCon.Close();
				//If Success status=1 or else status=0.
				if(status==1)
				{
					lblDispMsg.Text="Inserted Successfully.....";
					txtAdName.Text ="";
					txtAdvName.Text ="";
					txtAdDuration.Text="";
					txtAmtPaid.Text="";
					txtRotations.Text="";
					txtTotAmt.Text="";
					txtStartDate.Text=DateTime.Now.ToShortDateString();
					txtEndDate.Text=DateTime.Now.ToShortDateString();
				}
				else
				{
					lblDispMsg.Text="Insertion Failed.....Insert Again";
				}
			}
		}

		
	
	}
}
