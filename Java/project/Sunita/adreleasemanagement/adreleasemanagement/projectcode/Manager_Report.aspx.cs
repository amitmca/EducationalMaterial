using System;
using System.Collections;
using System.ComponentModel;
using System.Data;
using System.Data.SqlClient;
using System.Drawing;
using System.Web;
using System.Web.SessionState;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Web.UI.HtmlControls;
using System.Configuration;

namespace Group_17
{
	/// <summary>
	/// Summary description for WebForm2.
	/// </summary>
	public class WebForm2 : System.Web.UI.Page
	{
		protected System.Web.UI.WebControls.DataGrid dgView;
		protected System.Web.UI.WebControls.Label lblGridHead;
		protected System.Web.UI.WebControls.Button btnInsertRec;
		protected System.Web.UI.WebControls.Button btnBudget;
		protected System.Web.UI.WebControls.Button btnStrategy;
		protected System.Web.UI.WebControls.Button btnAddRec;
		protected System.Web.UI.WebControls.Button btnReset;
		protected System.Web.UI.HtmlControls.HtmlGenericControl grdInsert;
		protected System.Web.UI.WebControls.Label lblEndDate;
		protected System.Web.UI.WebControls.Label lblStartDate;
		protected System.Web.UI.WebControls.Label lblBudget;
		protected System.Web.UI.WebControls.TextBox txtBudget;
		protected System.Web.UI.WebControls.TextBox txtStartDate;
		protected System.Web.UI.WebControls.TextBox txtEndDate;
		protected System.Web.UI.WebControls.Label lblInsert;
		protected System.Web.UI.WebControls.Button btnLogout;
		protected System.Web.UI.WebControls.Label lblMessage;
		protected System.Web.UI.WebControls.RegularExpressionValidator rfvBudget;
		protected System.Web.UI.WebControls.Calendar clnStartDate;
		protected System.Web.UI.WebControls.Calendar clnEndDate;
		protected System.Web.UI.WebControls.Label lblHeader;
	
		private void Page_Load(object sender, System.EventArgs e)
		{
			if(!Page.IsPostBack)
			{
				lblGridHead.Visible=false;
				grdInsert.Visible=false;
				btnInsertRec.Visible=false;
				lblMessage.Visible=false;
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
			this.btnLogout.Click += new System.EventHandler(this.btnLogout_Click);
			this.btnStrategy.Click += new System.EventHandler(this.btnStrategy_Click);
			this.btnBudget.Click += new System.EventHandler(this.btnBudget_Click);
			this.btnAddRec.Click += new System.EventHandler(this.btnAddRec_Click);
			this.btnReset.Click += new System.EventHandler(this.btnReset_Click);
			this.clnStartDate.SelectionChanged += new System.EventHandler(this.clnStartDate_SelectionChanged);
			this.clnEndDate.SelectionChanged += new System.EventHandler(this.clnEndDate_SelectionChanged);
			this.dgView.PageIndexChanged += new System.Web.UI.WebControls.DataGridPageChangedEventHandler(this.dgView_PageIndexChanged);
			this.dgView.SelectedIndexChanged += new System.EventHandler(this.dgView_SelectedIndexChanged);
			this.btnInsertRec.Click += new System.EventHandler(this.btnInsertRec_Click);
			this.Load += new System.EventHandler(this.Page_Load);

		}
		#endregion

		private void btnStrategy_Click(object sender, System.EventArgs e)
		{	
			if(Session.Count>1)
			{		
				Session["temp"]=0;
				bind(0);
			}
			else
			{
				Server.Transfer("Login_Page.aspx");
			}
		}
		void bind(int x )
		{
			if(x==0)
			{
				string userid,role;
				role=Convert.ToString(Session["ROLE"]);
				userid=Convert.ToString(Session["PK_LOGIN_USER_NAME"]);
				SqlConnection con=new SqlConnection(ConfigurationSettings.AppSettings["DSN"]);
				string strQuery="";
				if(role=="mgr")
				{			
					strQuery= "select PK_AD_ID [AdvertisementId],CHANNEL_NAME[ChannelName],TIME_SLOT[TimeSlot],AD_DURATION[Ad Duration],APPLICABLE_RATE[Applicable Rate],DISCOUNT[Discount],NUM_TIMES[No oF Times],TOTAL_PRICE[Total Price],RECOMMENDATIONS[Recommendations] from ADMGT_AD_IDS_TB inner join ADMGT_DURATION_TB on ADMGT_AD_IDS_TB.FK_AD_IDS_DURATION=ADMGT_DURATION_TB.PK_DURA_DID inner join ADMGT_TIME_SLOT_TB on ADMGT_DURATION_TB.FK_DURATION_TIME_SLOT=ADMGT_TIME_SLOT_TB.PK_TID inner join ADMGT_CHANNEL_TB on ADMGT_TIME_SLOT_TB.FK_TIME_SLOT_CH=ADMGT_CHANNEL_TB.PK_CH_ID  order by APPLICABLE_RATE DESC";
				}
				else
				{
					strQuery="";
				}
				SqlDataAdapter da=new SqlDataAdapter(strQuery,con);
				DataSet ds=new DataSet();
				da.Fill(ds);
				dgView.DataSource=ds;
				dgView.DataBind();
				dgView.Visible=true;
				lblGridHead.Text="Strategy Report of the Staff";
				lblGridHead.Visible=true;	
				lblMessage.Visible=false;
			}
			else
			{
				string userid,role;
				role=Convert.ToString(Session["ROLE"]);
				userid=Convert.ToString(Session["PK_LOGIN_USER_NAME"]);
				SqlConnection con=new SqlConnection(ConfigurationSettings.AppSettings["DSN"]);
				string strQuery="";
				if(role=="mgr")
				{
					strQuery="select * from ADMGT_BUDGET_TB";
				}
				else
				{
					strQuery="";
				}
				SqlDataAdapter da=new SqlDataAdapter(strQuery,con);
				DataSet ds=new DataSet();
				da.Fill(ds);
				dgView.DataSource=ds;
				dgView.DataBind();
				dgView.Visible=true;
				lblGridHead.Text="Budget Allocation Report";
				lblGridHead.Visible=true;
				btnInsertRec.Visible=true;
				grdInsert.Visible=false;
				lblMessage.Visible=false;
			}
		}

				private void btnBudget_Click(object sender, System.EventArgs e)
				{	
					if(Session.Count>1)
					{		
						string userid,role;
						role=Convert.ToString(Session["ROLE"]);
						userid=Convert.ToString(Session["PK_LOGIN_USER_NAME"]);
						SqlConnection con=new SqlConnection(ConfigurationSettings.AppSettings["DSN"]);
						string strQuery="";
						if(role=="mgr")
						{
							strQuery="select * from ADMGT_BUDGET_TB";
						}
						else
						{
							strQuery="";
						}
						SqlDataAdapter da=new SqlDataAdapter(strQuery,con);
						dgView.CurrentPageIndex=0;
						DataSet ds=new DataSet();
						Session["temp"]=1;
						da.Fill(ds);
						dgView.DataSource=ds;
						dgView.DataBind();
						dgView.Visible=true;
						lblGridHead.Text="Budget Allocation Report";
						lblGridHead.Visible=true;
						btnInsertRec.Visible=true;
						grdInsert.Visible=false;
						lblMessage.Visible=false;
					}
					else
					{
						Server.Transfer("Login_Page.aspx");
					}
		}
		
				private void btnInsertRec_Click(object sender, System.EventArgs e)
				{
					txtBudget.Text="";
					txtStartDate.Text="";
					txtEndDate.Text="";
					grdInsert.Visible=true;
					dgView.Visible=false;
					btnInsertRec.Visible=false;
					lblMessage.Visible=false;
					clnEndDate.Visible=false;
					clnStartDate.Visible=true;
					
		            		
				}
		
				private void btnAddRec_Click(object sender, System.EventArgs e)
				{
					int flag=0;
					lblMessage.Text="";
					lblMessage.Visible=false;
					SqlConnection con=new SqlConnection(ConfigurationSettings.AppSettings["DSN"]);
					con.Open();
					string StrQuery="select PK_BUDGET_START_DATE,END_DATE from ADMGT_BUDGET_TB";
					SqlCommand cmd=new SqlCommand(StrQuery,con);
					SqlDataReader dr=cmd.ExecuteReader();
					if(txtStartDate.Text!="")
					 
					{
					
						DateTime  dt=DateTime.Parse(txtStartDate.Text); 
		
						while(dr.Read())
						{
							DateTime stdt=DateTime.Parse(Convert.ToString(dr.GetValue(0)));
							DateTime enddt=DateTime.Parse(Convert.ToString(dr.GetValue(1)));
						
							if(dt<=stdt || dt<=enddt )
							{
								flag=1;
							}
						}
						con.Close();
											 
					
						if(flag==1)
						{
							lblMessage.Visible=true;
							lblMessage.Text="Record cannot be inserted";
						}
						else
						{
						
							string insQuery="insert into ADMGT_BUDGET_TB values("+Convert.ToDouble (txtBudget.Text)+",'"+						txtStartDate.Text+"','"+txtEndDate.Text+"')";
							con.Open();
							SqlCommand cmd1=new SqlCommand(insQuery,con);
							int rowsret=cmd1.ExecuteNonQuery();
							if(rowsret<0)
							{
								lblMessage.Visible=true;
								lblMessage.Text="Record Insertion Failed";
							}
							else
							{
								lblMessage.Visible=true;
								lblMessage.Text="Record Successfully Inserted";
							}
							txtBudget.Text="";
							txtStartDate.Text="";
							txtEndDate.Text="";
							con.Close();
						}
					}
					else
					{
		
						lblMessage.Visible=true;
						lblMessage.Text="Enter valid Date";
					}
		
				}
		
				private void btnReset_Click(object sender, System.EventArgs e)
				{
					txtBudget.Text="";
					txtStartDate.Text="";
					txtEndDate.Text="";
					lblMessage.Visible=false;
					txtStartDate.Text="";
					txtEndDate.Text="";
					lblMessage.Text="";
					clnStartDate.Visible=true;
					clnEndDate.Visible=false;
		
				}
		
				private void btnLogout_Click(object sender, System.EventArgs e)
				{
					Server.Transfer("Logout_Page.aspx");
				}
		
				private void dgView_PageIndexChanged(object source, System.Web.UI.		           WebControls.DataGridPageChangedEventArgs e)
				{
				dgView.CurrentPageIndex=e.NewPageIndex;
					dgView.DataBind();
					int x=Convert.ToInt16(Session["temp"]);
					bind(x);
				}
		
				private void dgView_SelectedIndexChanged(object sender, System.EventArgs e)
				{
				
				}
		
				private void clnStartDate_SelectionChanged(object sender, System.EventArgs e)
				{
					clnEndDate.Visible=false;
					txtStartDate.Text=clnStartDate.SelectedDate.ToShortDateString();
					if(txtStartDate.Text!="")
					{
						clnStartDate.Visible=false;
						clnEndDate.Visible=true;
					}
					
				}
		
				private void clnEndDate_SelectionChanged(object sender, System.EventArgs e)
				{
					txtEndDate.Text=clnEndDate.SelectedDate.ToShortDateString();

	}
	
}
}
