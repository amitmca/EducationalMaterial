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
	/// Summary description for dailydetails.
	/// </summary>
	public class dailydetails : System.Web.UI.Page
	{
		protected System.Web.UI.WebControls.DropDownList cboAdName;
		protected System.Web.UI.WebControls.Label lblAdName;
		protected System.Web.UI.WebControls.Label lblTimeSlot;
		protected System.Web.UI.WebControls.Label lblRotations;
		protected System.Web.UI.WebControls.TextBox txtRotations;
		protected System.Web.UI.WebControls.Label lblduration;
		protected System.Web.UI.WebControls.TextBox txtDuration;
		protected System.Web.UI.WebControls.Label lblAmt;
		protected System.Web.UI.WebControls.Button cmdSubmit;
		protected System.Web.UI.WebControls.DropDownList cboTimeSlot;
		protected System.Web.UI.WebControls.Label lblDailyDetails;
	    protected DataSet DS;
		protected SqlConnection sqlConnection;
		protected System.Web.UI.WebControls.TextBox txtAmt;
		protected System.Web.UI.WebControls.Label lblErrMsg;
		protected System.Web.UI.WebControls.DropDownList cboTime;
		protected System.Web.UI.WebControls.Label lblErrSlot;
		protected System.Web.UI.WebControls.Label lblErrTime;
		protected System.Web.UI.WebControls.Label lblMsg;
		protected System.Web.UI.WebControls.LinkButton lkcmdAvlb;
		protected System.Web.UI.WebControls.Label lblAvail;
		protected System.Web.UI.WebControls.Button cmdClear;
		protected System.Web.UI.WebControls.DataGrid dgDailyDetails;
		protected SqlDataAdapter sqlDataAdapter;
		protected DataSet DSDailyView;
		protected System.Web.UI.WebControls.Label lblGrid;
		protected System.Web.UI.WebControls.Label lblDate;
		protected SqlDataAdapter sdaDailyView;

		private void Page_Load(object sender, System.EventArgs e)
		{
			string strTodayDate=DateTime.Now.ToShortDateString();
			
			if(Session["UserName"]==null)
			{
				Response.Redirect ("InvalidSession.aspx");
			}
			else
			{
				lblDate.Text ="Date : "+DateTime.Now.ToShortDateString();
				sqlDataAdapter=new SqlDataAdapter("select DET.Ad_Name,DET.Ad_Id from Ad_AdvDetails_TB as DET ,Ad_Acceptence_TB as ACC where ACC.Accepted=1 and ACC.Ad_Id=DET.Ad_Id and '"+ strTodayDate +"' >= Start_Date and '"+strTodayDate+"' <= End_Date",ConfigurationSettings.AppSettings["CONNECTION"]);
				DS=new DataSet();
				sqlDataAdapter.Fill(DS,"Ad_AdvDetails_TB");
			
				sdaDailyView=new SqlDataAdapter ("select AD.Ad_Name,DD.Time_Slot,(DD.Ad_Duration * DD.No_Rotations) as Tot_Time from Ad_DailyDetails_TB as DD,Ad_AdvDetails_TB as AD where DD.Ad_Id=AD.Ad_Id and which_date='"+DateTime.Now.ToShortDateString()+"'",ConfigurationSettings.AppSettings ["CONNECTION"]);
				DSDailyView=new DataSet ();
				sdaDailyView.Fill (DSDailyView,"Ad_DailyDetails_TB");

				dgDailyDetails.DataSource =DSDailyView;
				dgDailyDetails.DataMember ="Ad_DailyDetails_TB";
				dgDailyDetails.DataBind ();

				if(!Page.IsPostBack)
				{
					cboAdName.DataSource=DS;
					cboAdName.DataMember="Ad_AdvDetails_TB";
					cboAdName.DataTextField="Ad_Name";
					cboAdName.DataValueField="Ad_Id";
					cboAdName.DataBind();
					cboAdName.Items.Insert(0,"Select AdName");
				}
			}
			
			// Put user code to initialize the page here
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
			this.cboAdName.SelectedIndexChanged += new System.EventHandler(this.cboAdName_SelectedIndexChanged);
			this.cmdSubmit.Click += new System.EventHandler(this.cmdSubmit_Click);
			this.lkcmdAvlb.Click += new System.EventHandler(this.lkcmdAvlb_Click);
			this.cmdClear.Click += new System.EventHandler(this.cmdClear_Click);
			this.Load += new System.EventHandler(this.Page_Load);

		}
		#endregion

		private void cboAdName_SelectedIndexChanged(object sender, System.EventArgs e)
		{
			string strCboValue=cboAdName.SelectedValue;
			
			//If first item is selected in Combo Box
			if(cboAdName.SelectedIndex ==0)
			{
				lblErrMsg.Text="* Select Ad Name";
				txtRotations.Text="";
				txtDuration.Text="";
				txtAmt.Text="";
				cboTimeSlot .Enabled =false;
				cboTime .Enabled =false;
				
			}
			else
			{
				//Else Populated Data into Controls
				lblErrMsg.Text="";
				lkcmdAvlb.Visible =true;
				cboTime .Enabled =true;
				cboTimeSlot .Enabled =true;
				cmdSubmit .Enabled =false;

				//Select Data for that particular Ad_Id
				sqlDataAdapter=new SqlDataAdapter("select * from Ad_AdvDetails_TB where Ad_Id="+cboAdName.SelectedValue,ConfigurationSettings.AppSettings["CONNECTION"]);
				DS=new DataSet();
				sqlDataAdapter.Fill(DS,"Ad_AdvDetails_TB");
		
				//Fill Data to controls
				txtRotations.Text=DS.Tables[0].Rows[0]["No_Rotations"].ToString();
				txtDuration.Text=DS.Tables[0].Rows[0]["Ad_Duration"].ToString();
				txtAmt.Text=DS.Tables[0].Rows[0]["Tot_Amount"].ToString();
			}
		}

		
		private void cmdSubmit_Click(object sender, System.EventArgs e)
		{
			int flag=0;
			string strInsert;
			SqlCommand sqlCmd;
			sqlConnection=new SqlConnection(ConfigurationSettings.AppSettings["CONNECTION"]);

			if(cboTimeSlot.SelectedIndex ==0)
			{
				lblErrSlot.Text="* Select Time Slot";
				flag=0;
			}
			else
			{
				lblErrSlot.Text="";
				flag=1;
			}

			if(cboTime.SelectedIndex ==0)
			{
				lblErrTime.Text="* Select AM/PM";
				flag=0;
			}
			else
			{
				lblErrTime.Text="";
				if(flag!=0)
				flag=1;
			}

			if(cboAdName.SelectedIndex ==0)
			{
				lblErrMsg.Text="* Select Ad Name";
				flag=0;
			}
			else
			{
				lblErrMsg.Text="";
				if(flag!=0)
				flag=1;
			}

			//Check if there is no Error

			if(flag==1)
			{
				strInsert="insert into Ad_DailyDetails_TB values('"+cboAdName.SelectedValue+"','"+cboTimeSlot.SelectedValue+" "+cboTime.SelectedValue+"',"+txtRotations.Text+","+txtDuration.Text+","+txtAmt.Text+",'"+DateTime.Now.ToShortDateString()+"')";	
				
				//Create Insert Command and Insert a row
				sqlCmd=new SqlCommand(strInsert,sqlConnection );
				sqlConnection.Open();
				sqlCmd.ExecuteNonQuery();
				sqlConnection.Close();
				lblMsg.Text="Slot Alloted Successfully....";
				
				//Create DataAdapter and DataSet for datagrid to hold All Filled Time Slots
				sdaDailyView=new SqlDataAdapter ("select AD.Ad_Name,DD.Time_Slot,(DD.Ad_Duration * DD.No_Rotations) as Tot_Time from Ad_DailyDetails_TB as DD,Ad_AdvDetails_TB as AD where DD.Ad_Id=AD.Ad_Id and which_date='"+DateTime.Now.ToShortDateString()+"'",ConfigurationSettings.AppSettings ["CONNECTION"]);
				DSDailyView=new DataSet ();
				sdaDailyView.Fill (DSDailyView,"Ad_DailyDetails_TB");
				
				//Set DataSource and Bind to DataGrid
				dgDailyDetails.DataSource =DSDailyView;
				dgDailyDetails.DataMember ="Ad_DailyDetails_TB";
				dgDailyDetails.DataBind ();
				
				//Reset all control
				txtRotations.Text ="";
				txtAmt.Text ="";
				txtDuration.Text ="";
				cmdSubmit .Enabled =false;

				cboAdName.SelectedIndex =0;
				cboTimeSlot .SelectedIndex =0;
				cboTime .SelectedIndex =0;
				lblAvail.Text ="";
			}

		}
	
		//Check For Availabilty of Time Slot
		private void lkcmdAvlb_Click(object sender, System.EventArgs e)
		{
			int flag=0;
			int intDuration,intRotations,intAvilTime;
			int intTotTime;
			lblMsg.Text="";

			//Check if there is any control is not filled properly
			if(cboTimeSlot.SelectedIndex ==0)
			{
				lblErrSlot.Text="* Select Time Slot";
				flag=0;
			}
			else
			{
				lblErrSlot.Text="";
				flag=1;
			}

			if(cboTime.SelectedIndex ==0)
			{
				lblErrTime.Text="* Select AM/PM";
				flag=0;
			}
			else
			{
				lblErrTime.Text="";
				if(flag!=0)
					flag=1;
			}

			if(cboAdName.SelectedIndex ==0)
			{
				lblErrMsg.Text="* Select Ad Name";
				flag=0;
			}
			else
			{
				lblErrMsg.Text="";
				if(flag!=0)
					flag=1;
			}

			//Check if there is no Error
			if(flag==1)
			{
				string strTodayDate=DateTime.Now.ToShortDateString();
				//Check if there is any row is there for the particular Time Slot
				sqlDataAdapter=new SqlDataAdapter("select * from Ad_DailyDetails_TB where which_date='"+strTodayDate+"' and Time_Slot='"+cboTimeSlot.SelectedValue+" "+cboTime.SelectedValue+"'",ConfigurationSettings.AppSettings["CONNECTION"]);
				DS=new DataSet();
				sqlDataAdapter.Fill(DS,"Ad_AdvDetails_TB");

				//Row Count=0 indicates Time Slot is Free else not Free

				if(DS.Tables[0].Rows.Count !=0)
				{
					//Some or Total Time Slot is alloted
					intDuration=Convert.ToInt32(DS.Tables[0].Rows[0]["Ad_Duration"]);
					intRotations=Convert.ToInt32(DS.Tables[0].Rows[0]["No_Rotations"]);
				
				
					intAvilTime=60-(intDuration*intRotations);
					intTotTime=Convert.ToInt32(txtDuration.Text)*Convert.ToInt32(txtRotations.Text);

					//Check if Time slot is available
					if(intTotTime <=intAvilTime)
					{
						lblAvail.Text="Slot Time Available";
						cmdSubmit.Enabled =true;
						cboTimeSlot.Enabled =false;
						cboTime .Enabled =false;
					}
					else
					{
						lblAvail.Text="Sorry! Slot Time Not Available";
					}
				}
				else
				{
						lblAvail.Text="Slot Time Available";
						cmdSubmit.Enabled =true;
					cboTimeSlot.Enabled =false;
					cboTime .Enabled =false;
				}
			}
			
		}

		private void cmdClear_Click(object sender, System.EventArgs e)
		{
			//Clear All Control

			txtAmt.Text ="";
			txtDuration .Text ="";
			txtRotations .Text ="";
			cboAdName .SelectedIndex =0;
			cboTimeSlot .SelectedIndex =0;
			cboTime .SelectedIndex =0;
			lblMsg.Text ="";
			lblAvail .Text ="";
			cmdSubmit .Enabled =false;
						  
		}
	
	}
}
