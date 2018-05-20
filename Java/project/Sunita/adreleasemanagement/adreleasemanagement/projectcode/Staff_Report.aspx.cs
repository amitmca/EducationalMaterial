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
using System.IO;

namespace Group_17
{
	/// <summary>
	/// Summary description for WebForm3.
	/// </summary>
	public class WebForm3 : System.Web.UI.Page
	{
		protected System.Web.UI.WebControls.Button btnReset;
		protected System.Web.UI.WebControls.Button btnAddRec;
		protected System.Web.UI.WebControls.Label lblChannel;
		protected System.Web.UI.WebControls.Label lblTimeslot;
		protected System.Web.UI.WebControls.Label lblDuration;
		protected System.Web.UI.WebControls.Label lblDiscount;
		protected System.Web.UI.WebControls.Label lblApplicableRate;
		protected System.Web.UI.WebControls.Label lblRecommendations;
		protected System.Web.UI.WebControls.DropDownList ddlChannel;
		protected System.Web.UI.WebControls.DropDownList ddlTimeslot;
		protected System.Web.UI.WebControls.DropDownList ddlDuration;
		protected System.Web.UI.WebControls.Label lblDiscountPer;
		protected System.Web.UI.WebControls.Label lblAppRate;
		protected System.Web.UI.WebControls.TextBox txtRecommendations;
		protected System.Web.UI.HtmlControls.HtmlGenericControl grdInsertRec;
		protected System.Web.UI.WebControls.Button btnInsertNew;
		protected System.Web.UI.WebControls.Button btnLogout;
		protected System.Web.UI.WebControls.Label lblResponse;
		protected System.Web.UI.WebControls.DataGrid dgAdsView;
		protected System.Web.UI.WebControls.Label lblAdMessage;
		protected System.Web.UI.WebControls.Label lblReport;
		protected System.Web.UI.HtmlControls.HtmlGenericControl grdPrompt;
		protected System.Web.UI.WebControls.Label lblPrompt;
		protected System.Web.UI.WebControls.Button btnOk;
		protected System.Web.UI.WebControls.Button btnCancel;
		protected System.Web.UI.WebControls.Label lblTotal;
		protected System.Web.UI.WebControls.Label lblTotalPrice;
		protected System.Web.UI.WebControls.Label lblNumTimes;
		protected System.Web.UI.WebControls.TextBox txtNumTimes;
		protected System.Web.UI.WebControls.RequiredFieldValidator rfvTimes;
		protected System.Web.UI.WebControls.Button btnView;

		
	
		private void Page_Load(object sender, System.EventArgs e)
		{
			dgAdsView.Visible=true;
			StaffData();
			lblReport.Visible=true;
			grdPrompt.Visible=false;
			grdInsertRec.Visible=false;
		}

		public void StaffData()
		{
			
			if(Session.Count>1)
			{		
				string userid,role;
				role=Convert.ToString(Session["ROLE"]);
				userid=Convert.ToString(Session["PK_LOGIN_USER_NAME"]);
				SqlConnection con=new SqlConnection(ConfigurationSettings.AppSettings["DSN"]);
				string strQuery="";
				if(role=="staff")
				{			
					strQuery= "select PK_AD_ID [AdvertisementId],CHANNEL_NAME[ChannelName],TIME_SLOT[TimeSlot],AD_DURATION[Ad Duration],APPLICABLE_RATE[Applicable Rate],DISCOUNT[Discount],NUM_TIMES[No oF Times],TOTAL_PRICE[Total Price],RECOMMENDATIONS[Recommendations] from ADMGT_AD_IDS_TB inner join ADMGT_DURATION_TB on ADMGT_AD_IDS_TB.FK_AD_IDS_DURATION=ADMGT_DURATION_TB.PK_DURA_DID inner join ADMGT_TIME_SLOT_TB on ADMGT_DURATION_TB.FK_DURATION_TIME_SLOT=ADMGT_TIME_SLOT_TB.PK_TID inner join ADMGT_CHANNEL_TB on ADMGT_TIME_SLOT_TB.FK_TIME_SLOT_CH=ADMGT_CHANNEL_TB.PK_CH_ID where ADMGT_AD_IDS_TB.FK_AD_IDS_LOGIN='"+userid+"' order by APPLICABLE_RATE DESC";
				}
				else
				{
					strQuery="";
				}
				SqlDataAdapter da=new SqlDataAdapter(strQuery,con);
				DataSet ds=new DataSet();
				da.Fill(ds);
				dgAdsView.DataSource=ds;
				dgAdsView.DataBind();
			}
			else
			{
				Server.Transfer("Login_Page.aspx");
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
			this.dgAdsView.PageIndexChanged += new System.Web.UI.WebControls.DataGridPageChangedEventHandler(this.dgAdsView_PageIndexChanged);
			this.btnOk.Click += new System.EventHandler(this.btnOk_Click);
			this.btnCancel.Click += new System.EventHandler(this.btnCancel_Click);
			this.btnLogout.Click += new System.EventHandler(this.btnLogout_Click);
			this.btnInsertNew.Click += new System.EventHandler(this.btnInsertNew_Click);
			this.ddlChannel.SelectedIndexChanged += new System.EventHandler(this.ddlChannel_SelectedIndexChanged);
			this.ddlTimeslot.SelectedIndexChanged += new System.EventHandler(this.ddlTimeslot_SelectedIndexChanged);
			this.ddlDuration.SelectedIndexChanged += new System.EventHandler(this.ddlDuration_SelectedIndexChanged);
			this.txtRecommendations.TextChanged += new System.EventHandler(this.txtRecommendations_TextChanged);
			this.btnAddRec.Click += new System.EventHandler(this.btnAddRec_Click);
			this.btnReset.Click += new System.EventHandler(this.btnReset_Click);
			this.btnView.Click += new System.EventHandler(this.btnView_Click);
			this.Load += new System.EventHandler(this.Page_Load);

		}
		#endregion

		private void dgAdsView_SelectedIndexChanged(object sender, System.EventArgs e)
		{
		
		}

		

		private void btnInsertNew_Click(object sender, System.EventArgs e)
		{
			
			dgAdsView.Visible=false;
			grdInsertRec.Visible=true;
			lblReport.Visible=false;
			grdPrompt.Visible=false;
			SqlConnection con=new SqlConnection(ConfigurationSettings.AppSettings["DSN"]);
			string strQuery="select CHANNEL_NAME from ADMGT_CHANNEL_TB";
			SqlDataAdapter da=new SqlDataAdapter(strQuery,con);
			DataSet ds=new DataSet();
			da.Fill(ds,"channel");
			ddlChannel.DataSource=ds;
			ddlChannel.DataTextField=ds.Tables[0].Columns[0].ColumnName;
			ddlChannel.DataBind();
			con.Close();
			
		}

		private void btnLogout_Click(object sender, System.EventArgs e)
		{
			Server.Transfer("Logout_Page.aspx");			
		}

		private void ddlChannel_SelectedIndexChanged(object sender, System.EventArgs e)
		{
			dgAdsView.Visible=false;
			grdInsertRec.Visible=true;
			lblReport.Visible=false;
			grdPrompt.Visible=false;
			SqlConnection con=new SqlConnection(ConfigurationSettings.AppSettings["DSN"]);
			string channelStr="select PK_CH_ID from ADMGT_CHANNEL_TB where CHANNEL_NAME='"+ddlChannel.SelectedValue+"'";
			con.Open();
			SqlCommand cmd=new SqlCommand(channelStr,con);
			string channelidStr=Convert.ToString(cmd.ExecuteScalar());
			string timeslotStr="select TIME_SLOT from ADMGT_TIME_SLOT_TB where FK_TIME_SLOT_CH='"+channelidStr+"'";
			SqlDataAdapter da=new SqlDataAdapter(timeslotStr,con);
			DataSet ds=new DataSet();
			da.Fill(ds);
			ddlTimeslot.DataSource=ds;
			ddlTimeslot.DataTextField=ds.Tables[0].Columns[0].ColumnName;
			ddlTimeslot.DataBind();
			con.Close();
	

		
		}

		private void ddlTimeslot_SelectedIndexChanged(object sender, System.EventArgs e)
		{
			dgAdsView.Visible=false;
			grdInsertRec.Visible=true;
			lblReport.Visible=false;
			grdPrompt.Visible=false;
			SqlConnection con=new SqlConnection(ConfigurationSettings.AppSettings["DSN"]);
			string timeStr="select PK_TID from ADMGT_TIME_SLOT_TB where TIME_SLOT='"+ddlTimeslot.SelectedValue+"'";
			con.Open();
			SqlCommand cmd=new SqlCommand(timeStr,con);
			string timeidStr=Convert.ToString(cmd.ExecuteScalar());
			string discountStr="select DISCOUNT from ADMGT_TIME_SLOT_TB where PK_TID='"+timeidStr+"'";
			string adDurationStr="select AD_DURATION from ADMGT_DURATION_TB where FK_DURATION_TIME_SLOT='"+timeidStr+"'";
			SqlDataAdapter da=new SqlDataAdapter(adDurationStr,con);
			DataSet ds=new DataSet();
			da.Fill(ds);
			ddlDuration.DataSource=ds;
			ddlDuration.DataTextField=ds.Tables[0].Columns[0].ColumnName;
			ddlDuration.DataBind();
			SqlCommand cmd1=new SqlCommand(discountStr,con);
			lblDiscountPer.Text=Convert.ToString(cmd1.ExecuteScalar());
			con.Close();
		
		}

		private void ddlDuration_SelectedIndexChanged(object sender, System.EventArgs e)
		{
			dgAdsView.Visible=false;
			grdInsertRec.Visible=true;
			lblReport.Visible=false;
			grdPrompt.Visible=false;
			int num=Convert.ToInt16(txtNumTimes.Text);
			SqlConnection con=new SqlConnection(ConfigurationSettings.AppSettings["DSN"]);
			con.Open();
			string apprateStr="select APPLICABLE_RATE from ADMGT_DURATION_TB where AD_DURATION='"+ddlDuration			.SelectedValue+"'";
			SqlCommand cmd=new SqlCommand(apprateStr,con);
			lblAppRate.Text=Convert.ToString(cmd.ExecuteScalar());
			
			double total=(num*(Convert.ToDouble(lblAppRate.Text)));
			double price=total-(total*(Convert.ToDouble((Convert.ToDouble(lblDiscountPer.Text))/100)));
			lblTotalPrice.Text=Convert.ToString(price);
			con.Close();
		}

		private void btnAddRec_Click(object sender, System.EventArgs e)
		{
			if(lblAppRate.Text!="")
			{
				int flag=0;
				dgAdsView.Visible=false;
				grdInsertRec.Visible=true;
				lblReport.Visible=false;
				grdPrompt.Visible=false;
				SqlConnection con=new SqlConnection(ConfigurationSettings.AppSettings["DSN"]);
				DateTime currdt=DateTime.Now;
				string dtStr="select * from ADMGT_BUDGET_TB";
				con.Open();
				SqlCommand dc=new SqlCommand(dtStr,con);
				SqlDataReader dr=dc.ExecuteReader();
				while(dr.Read())
				{
					DateTime stdt=DateTime.Parse(Convert.ToString(dr.GetValue(1)));
					DateTime enddt=DateTime.Parse(Convert.ToString(dr.GetValue(2)));
					if(currdt>=stdt && currdt<=enddt)
					{
						if(Convert.ToDouble(lblAppRate.Text)>Convert.ToDouble(dr.GetValue(0)))
						{
							
							grdPrompt.Visible=true;
							grdInsertRec.Visible=false;
							btnInsertNew.Visible=false;
							btnLogout.Visible=false;
							lblPrompt.Text="Ad Rate greater than Budget ! Do you still want to continue?";
							flag=1;
						}
						else
						{	
							flag=0;		
						}
					}
				}

				if(flag==0)
				{
					
					insert();

				}

				
				
				dr.Close();
				con.Close();
			}
		
			else
			{
				lblResponse.Text="Unable to Insert an empty record";
				dgAdsView.Visible=false;
				lblReport.Visible=false;
				grdPrompt.Visible=false;
				grdInsertRec.Visible=true;
				lblResponse.Visible=true;

			}

		}


		private void btnReset_Click(object sender, System.EventArgs e)
		{
			dgAdsView.Visible=false;
			grdInsertRec.Visible=true;
			lblReport.Visible=false;
			lblResponse.Visible=false;
			grdPrompt.Visible=false;
			txtRecommendations.Text="";
			lblAppRate.Text="";
			lblDiscountPer.Text="";
			txtNumTimes.Text="";
			lblTotalPrice.Text="";

		}

		private void btnView_Click(object sender, System.EventArgs e)
		{
			dgAdsView.Visible=true;
			lblResponse.Visible=false;
			StaffData();
			lblReport.Visible=true;
			grdInsertRec.Visible=false;
		
		}

		private void btnOk_Click(object sender, System.EventArgs e)
		{
			if(lblAppRate.Text!="")
			{
				dgAdsView.Visible=false;
				grdInsertRec.Visible=true;
				lblReport.Visible=false;
				grdPrompt.Visible=false;
				SqlConnection con=new SqlConnection(ConfigurationSettings.AppSettings["DSN"]);
				string tidQStr="select PK_TID from ADMGT_TIME_SLOT_TB where TIME_SLOT='"+ddlTimeslot.						SelectedValue+"'";
			
				string userid=Convert.ToString(Session["PK_LOGIN_USER_NAME"]);
				con.Open();
				SqlCommand cmd=new SqlCommand(tidQStr,con);
				string tidStr=Convert.ToString(cmd.ExecuteScalar());
				string didQStr="select PK_DURA_DID from ADMGT_DURATION_TB where AD_DURATION='"+ddlDuration.		                 SelectedValue+"'and	FK_DURATION_TIME_SLOT='"+tidStr+"'";
			
				SqlCommand cmd1=new SqlCommand(didQStr,con);
				string didStr=Convert.ToString(cmd1.ExecuteScalar());
				string insertQStr="Insert into ADMGT_AD_IDS_TB values('"+userid+"','"+didStr+"','"+							txtRecommendations.Text+"','"+txtNumTimes.Text+"',"+Convert.ToDouble(lblTotalPrice.Text)+")";
			
				SqlCommand cmd2=new SqlCommand(insertQStr,con);
				int i=cmd2.ExecuteNonQuery();
				if(i<0)
				{
					lblResponse.Text="The Record Insertion failed";
					lblResponse.Visible=true;
				}
				else
				{
					
					lblResponse.Text="The Record has been Successfully Inserted";
					lblResponse.Visible=true;
				}
				
				con.Close();
				
		
			}
				grdPrompt.Visible=false;
			dgAdsView.Visible=false;
			grdInsertRec.Visible=true;
			lblReport.Visible=false;
			txtRecommendations.Text="";
			lblAppRate.Text="";
			lblDiscountPer.Text="";

		
		
		}

		private void btnCancel_Click(object sender, System.EventArgs e)
		{
			dgAdsView.Visible=false;
			grdInsertRec.Visible=true;
			lblReport.Visible=false;
			lblResponse.Visible=true;
			txtRecommendations.Text="";
			lblAppRate.Text="";
			lblDiscountPer.Text="";
			grdPrompt.Visible=false;
			lblResponse.Text="Record Insert Cancelled";
	
		}
		void insert()
		{
			string tidQStr="select PK_TID from ADMGT_TIME_SLOT_TB where TIME_SLOT='"+ddlTimeslot.						SelectedValue+"'";
			
			string userid=Convert.ToString(Session["PK_LOGIN_USER_NAME"]);
			
				
			SqlConnection con1=new SqlConnection(ConfigurationSettings.AppSettings["DSN"]);
			con1.Open();
			SqlCommand cmd=new SqlCommand(tidQStr,con1);
			string tidStr=Convert.ToString(cmd.ExecuteScalar());
			string didQStr="select PK_DURA_DID from ADMGT_DURATION_TB where AD_DURATION='"+ddlDuration.						SelectedValue+"' and FK_DURATION_TIME_SLOT='"+tidStr+"'";
			
			SqlCommand cmd1=new SqlCommand(didQStr,con1);
			string didStr=Convert.ToString(cmd1.ExecuteScalar());
			string insertQStr="Insert into ADMGT_AD_IDS_TB values('"+userid+"','"+didStr+"','"+									txtRecommendations.Text+"','"+txtNumTimes.Text+"',"+Convert.ToDouble(lblTotalPrice.Text)+")";
			
			SqlCommand cmd2=new SqlCommand(insertQStr,con1);
			int i=cmd2.ExecuteNonQuery();
			if(i<0)
			{
				lblResponse.Text="The Record Insertion failed";
				lblResponse.Visible=true;
			}
			else
			{
				lblResponse.Text="The Record has been Successfully Inserted";
				lblResponse.Visible=true;
			}
							
		}

		private void dgAdsView_PageIndexChanged(object source, System.Web.UI.WebControls.DataGridPageChangedEventArgs e)
		{
			dgAdsView.CurrentPageIndex=e.NewPageIndex;
			//dgAdsView.DataSource=ds;
			dgAdsView.DataBind();
		}

		private void txtRecommendations_TextChanged(object sender, System.EventArgs e)
		{
		
		}
	}
}
