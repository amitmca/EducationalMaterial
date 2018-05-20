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
	/// Summary description for view.
	/// </summary>
	public class view : System.Web.UI.Page
	{
		protected System.Web.UI.WebControls.Label lblEndDate;
		protected System.Web.UI.WebControls.TextBox txtstartDate;
		protected System.Web.UI.WebControls.TextBox txtEndDate;
		protected System.Web.UI.WebControls.ImageButton cmdStartDate;
		protected System.Web.UI.WebControls.ImageButton cmdEndDate;
		protected System.Web.UI.WebControls.Button cmdView;
		protected System.Web.UI.WebControls.Calendar calStartDate;
		protected System.Web.UI.WebControls.Calendar calEndDate;
		protected System.Web.UI.WebControls.TextBox txtStartDate;
		protected System.Web.UI.WebControls.DataGrid dgView;
		protected System.Web.UI.WebControls.Label lblView;
		protected DataSet DSView;
		protected DataSet DSTot;
		protected SqlDataAdapter sdaView;
		protected System.Web.UI.WebControls.Label lblStartDate;
		protected System.Web.UI.WebControls.LinkButton cmdGoBack;
		protected System.Web.UI.WebControls.DataGrid dgBottom;
		protected System.Web.UI.WebControls.Label lblDates;
		protected SqlConnection sqlCon;
	
		private void Page_Load(object sender, System.EventArgs e)
		{
			// Put user code to initialize the page here.
			if(Session["UserName"]==null)
			{
				Response.Redirect ("InvalidSession.aspx");
			}
			else
			{ // Checking for postback.
				if(!Page.IsPostBack )
				{
					txtStartDate.Text=DateTime.Now.ToShortDateString();
					txtEndDate.Text=DateTime.Now.ToShortDateString();
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
			this.cmdStartDate.Click += new System.Web.UI.ImageClickEventHandler(this.cmdStartDate_Click);
			this.cmdEndDate.Click += new System.Web.UI.ImageClickEventHandler(this.cmdEndDate_Click);
			this.cmdView.Click += new System.EventHandler(this.cmdView_Click);
			this.cmdGoBack.Click += new System.EventHandler(this.cmdGoBack_Click);
			this.Load += new System.EventHandler(this.Page_Load);

		}
		#endregion

		
		private void cmdStartDate_Click(object sender, System.Web.UI.ImageClickEventArgs e)
		{// Make the calender visible in select.
			calStartDate.Visible=true;
		}

		private void cmdEndDate_Click(object sender, System.Web.UI.ImageClickEventArgs e)
		{
			// Make the calender visible in select.
			calEndDate.Visible=true;
		}

		private void calStartDate_SelectionChanged(object sender, System.EventArgs e)
		{  //Directing the selected start date to the textfield.
			txtStartDate.Text=calStartDate.SelectedDate.ToShortDateString();
			calStartDate.Visible=false;

		}

		private void calEndDate_SelectionChanged(object sender, System.EventArgs e)
		
		{  //Directing the selected start date to the textfield.
			txtEndDate.Text=calEndDate.SelectedDate.ToShortDateString();
			calEndDate.Visible=false;
		}

		private void cmdView_Click(object sender, System.EventArgs e)
		{
			// Establish Connection with Database , get a Query String from Web.config with key 'CONNECTION'.
			sqlCon=new SqlConnection(ConfigurationSettings.AppSettings["CONNECTION"]);
			sdaView=new SqlDataAdapter("select * from Ad_AdvDetails_TB where Accpt_Cleared=1 and Start_Date>='"+txtStartDate.Text+"' and end_Date>='"+txtEndDate.Text+"'",sqlCon);
			DSView=new DataSet();
             //Open connection.
			sqlCon.Open();
			sdaView.Fill(DSView,"Ad_AdvDetails_TB");
			sqlCon.Close();

			dgView.DataSource=DSView;
			dgView.DataMember ="Ad_AdvDetails_TB";
			dgView.DataBind();

			//Biniding Data To Other DataGrid

			sdaView=new SqlDataAdapter("select sum(Tot_amount) as Tot_Amt,sum(No_rotations*Ad_Duration) as Tot_Time from Ad_AdvDetails_TB where Accpt_Cleared=1 and Start_Date>='"+txtStartDate.Text+"' and end_Date>='"+txtEndDate.Text+"'",sqlCon);
			DSTot=new DataSet();

			sqlCon.Open();
			sdaView.Fill(DSTot,"Ad_AdvDetails_TB");
			sqlCon.Close();

			dgBottom.DataSource=DSTot;
			dgBottom.DataMember ="Ad_AdvDetails_TB";
			dgBottom.DataBind();

			txtStartDate.Visible=false;
			txtEndDate.Visible=false;

			lblStartDate.Visible=false;
			lblEndDate.Visible=false;

			calStartDate.Visible=false;
			calEndDate.Visible=false;

			cmdStartDate.Visible=false;
			cmdEndDate.Visible=false;
			cmdView.Visible=false;
			cmdGoBack.Visible=true;
			
			dgView.Visible=true;
			dgBottom.Visible =true;
			lblDates.Text="(MM/DD/YYYY) From : "+txtStartDate.Text +" To : "+txtEndDate.Text ;

		}

		private void cmdGoBack_Click(object sender, System.EventArgs e)
		{
			lblDates.Visible =false;
			txtStartDate.Visible=true;
			txtEndDate.Visible=true;
			//txtStartDate.Text="";
			//txtEndDate.Text="";

			lblStartDate.Visible=true;
			lblEndDate.Visible=true;
			
			cmdStartDate.Visible=true;
			cmdEndDate.Visible=true;
			cmdView.Visible=true;

			dgView.Visible=false;
			dgBottom.Visible =false;
			cmdGoBack.Visible=false;

		}
	}
}
