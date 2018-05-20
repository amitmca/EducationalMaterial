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
	/// Summary description for updateForm.
	/// </summary>
	public class updateForm : System.Web.UI.Page
	{
		protected System.Web.UI.WebControls.Label lblAdId;
		protected System.Web.UI.WebControls.Label lblAdName;
		protected System.Web.UI.WebControls.TextBox txtAdId;
		protected System.Web.UI.WebControls.TextBox txtAdName;
		protected System.Web.UI.WebControls.Label lblAdvName;
		protected System.Web.UI.WebControls.Label lblStartDate;
		protected System.Web.UI.WebControls.TextBox txtStartDate;
		protected System.Web.UI.WebControls.Label lblEndDate;
		protected System.Web.UI.WebControls.TextBox txtEndDate;
		protected System.Web.UI.WebControls.Label lblRotations;
		protected System.Web.UI.WebControls.Label lblTotAmt;
		protected System.Web.UI.WebControls.TextBox txtDuration;
		protected System.Web.UI.WebControls.TextBox txtRotations;
		protected System.Web.UI.WebControls.TextBox txtTotAmt;
		protected System.Web.UI.WebControls.Label lblAmtPaid;
		protected System.Web.UI.WebControls.TextBox txtAmtPaid;
		protected System.Web.UI.WebControls.Calendar calStartDate;
		protected System.Web.UI.WebControls.Calendar calEndDate;
		protected System.Web.UI.WebControls.Button cmdUpdate;
		protected System.Web.UI.WebControls.RequiredFieldValidator fldvldAdName;
		protected System.Web.UI.WebControls.RequiredFieldValidator fldvldAdvName;
		protected System.Web.UI.WebControls.TextBox txtAdvName;
		protected System.Web.UI.WebControls.DropDownList cboAdName;
		protected System.Web.UI.WebControls.Label lblUpdate;
		protected SqlConnection sqlConnection;
		protected SqlDataAdapter sqlDataAdapter;
		protected System.Web.UI.WebControls.Label lblDuration;
		protected System.Web.UI.WebControls.ImageButton cmdStartDate;
		protected System.Web.UI.WebControls.ImageButton cmdEndDate;
		protected System.Web.UI.WebControls.Label lblAdNameSlc;
		protected System.Web.UI.WebControls.Label lblDispMsg;
		protected System.Web.UI.WebControls.RegularExpressionValidator expvldDuration;
		protected System.Web.UI.WebControls.RegularExpressionValidator expvldRotations;
		protected System.Web.UI.WebControls.RegularExpressionValidator expvldTotAmt;
		protected System.Web.UI.WebControls.RegularExpressionValidator expvldAmtPaid;
		protected System.Web.UI.WebControls.LinkButton lnkcmdEndContract;
		protected System.Web.UI.WebControls.Label lblTemp;
		protected DataSet DS;

	
		private void Page_Load(object sender, System.EventArgs e)
		{
			// Put user code to initialize the page here.
			if(Session["UserName"]==null)
			{
				Response.Redirect ("InvalidSession.aspx");
			}
			else
			{
				// Selecting Accepted Ads.
				sqlDataAdapter=new SqlDataAdapter("select DET.Ad_Name,DET.Ad_Id from Ad_AdvDetails_TB as DET ,Ad_Acceptence_TB as ACC where ACC.Accepted=1 and ACC.Ad_Id=DET.Ad_Id",ConfigurationSettings.AppSettings["CONNECTION"]);
				DS=new DataSet();
				sqlDataAdapter.Fill(DS,"Ad_AdvDetails_TB");
			
               //Checking for page postback.
				if(!Page.IsPostBack)
				{
					cboAdName.DataSource=DS;
					cboAdName.DataMember="Ad_AdvDetails_TB";
					cboAdName.DataTextField="Ad_Name";
					cboAdName.DataValueField="Ad_Id";
					cboAdName.DataBind();
				}
				cboAdName.Items.Insert(0,"Select AdName");
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
			this.cmdUpdate.Click += new System.EventHandler(this.cmdUpdate_Click);
			this.cboAdName.SelectedIndexChanged += new System.EventHandler(this.cboAdName_SelectedIndexChanged);
			this.cmdStartDate.Click += new System.Web.UI.ImageClickEventHandler(this.cmdStartDate_Click);
			this.cmdEndDate.Click += new System.Web.UI.ImageClickEventHandler(this.cmdEndDate_Click);
			this.lnkcmdEndContract.Click += new System.EventHandler(this.lnkcmdEndContract_Click);
			this.Load += new System.EventHandler(this.Page_Load);

		}
		#endregion

		private void calStartDate_SelectionChanged(object sender, System.EventArgs e)
		{
		
            //Displaying start date in the text field that has been selected by the user.
			txtStartDate.Text=calStartDate.SelectedDate.ToShortDateString().ToString();
           	//Making the calender invisible.
			calStartDate.Visible=false;

		}

		private void calEndDate_SelectionChanged(object sender, System.EventArgs e)
		{  //Displaying End date in the text field that has been selected by the user.
			txtEndDate.Text=calEndDate.SelectedDate.ToShortDateString().ToString();
		//Making the calender invisible.
			calEndDate.Visible=false;
		}

		private void lbStartDate_Click(object sender, System.EventArgs e)
		{
			
		}

		private void lbEndDate_Click(object sender, System.EventArgs e)
		{// On Selecting the imgbutton making the calender visible.
			calEndDate.Visible=true;
		}

		private void cboAdName_SelectedIndexChanged(object sender, System.EventArgs e)
		{
			ViewState["AdID"]=cboAdName.SelectedValue;

			sqlDataAdapter=new SqlDataAdapter("select * from Ad_AdvDetails_TB where Ad_Id="+cboAdName.SelectedValue,ConfigurationSettings.AppSettings["CONNECTION"]);
			DS=new DataSet();
     		sqlDataAdapter.Fill(DS,"Ad_AdvDetails_TB");
		
           //Making the textboxes visible.    
			txtAdId.Visible=true;
			txtAdName.Visible=true;
			txtAdvName.Visible=true;
			txtStartDate.Visible=true;
			txtEndDate.Visible=true;
			txtDuration.Visible=true;
			txtRotations.Visible=true;
			txtTotAmt.Visible=true;
			txtAmtPaid.Visible=true;
			lnkcmdEndContract .Visible =true;
            //Making the lables visible.
			lblAdId.Visible=true;
			lblAdName.Visible=true;
			lblAdvName.Visible=true;
			lblStartDate.Visible=true;
			lblEndDate.Visible=true;
			lblDuration.Visible=true;
			lblRotations.Visible=true;
			lblTotAmt.Visible=true;
			lblAmtPaid.Visible=true;

			cmdStartDate.Visible=true;
			cmdEndDate.Visible=true;

			cmdUpdate.Visible=true;

			cboAdName.Visible=false;
			lblAdNameSlc.Visible=false;
             //Retrieving the data from the database to display the data in the form.
			txtAdId.Text=DS.Tables[0].Rows[0][0].ToString();
			txtAdName.Text=DS.Tables[0].Rows[0][1].ToString();
			txtAdvName.Text=DS.Tables[0].Rows[0][2].ToString();
            //Dispaying the start date that the the user entered in NewAd form.
			DateTime dt=(DateTime)(DS.Tables[0].Rows[0][3]);
			txtStartDate.Text=dt.ToShortDateString();
             //Dispaying the End date that the the user entered in NewAd form. 
			dt=(DateTime)(DS.Tables[0].Rows[0][4]);
			txtEndDate.Text=dt.ToShortDateString();
			
			txtDuration.Text=DS.Tables[0].Rows[0][5].ToString();
			txtRotations.Text=DS.Tables[0].Rows[0][6].ToString();
			txtTotAmt.Text=DS.Tables[0].Rows[0][7].ToString();
			txtAmtPaid.Text=DS.Tables[0].Rows[0][8].ToString();
			
		}

		private void cmdStartDate_Click(object sender, System.Web.UI.ImageClickEventArgs e)
		{
			//Show Start Calender When user clicks.
			calStartDate.Visible=true;
		}

		private void cmdEndDate_Click(object sender, System.Web.UI.ImageClickEventArgs e)
		{
			//Show Start Calender When user clicks.
			calEndDate.Visible=true;
		}

		private void cmdUpdate_Click(object sender, System.EventArgs e)
		{
			string strAdId=ViewState["AdID"].ToString();
			DateTime dtStart=Convert.ToDateTime (txtStartDate.Text);
			DateTime dtEnd=Convert.ToDateTime(txtEndDate.Text);
			int intDateRes =dtEnd.CompareTo(dtStart);

			if(intDateRes<0)
			{
				lblTemp .Text ="Start Date Cannot Be Greater ";
			}
			else
			{
				lblTemp.Text ="";
				// Establish Connection with Database , get a Query String from Web.config with key 'CONNECTION'.
				sqlConnection =new SqlConnection(ConfigurationSettings.AppSettings["CONNECTION"]);
			
				string updateStr="update Ad_AdvDetails_TB set Ad_Name='"+txtAdName.Text+"',Advertiser_Name='"+txtAdvName.Text+"',Start_Date='"+txtStartDate.Text+"',End_Date='"+txtEndDate.Text+"',Ad_Duration="+txtDuration.Text+",No_Rotations="+txtRotations.Text+",Tot_Amount="+txtTotAmt.Text+",Amount_Paid="+txtAmtPaid.Text+" where Ad_Id="+strAdId;
				int status=-1;
				//Open Connection , Execute Query and Close Connection.	
				
				SqlCommand sqlCmd=new SqlCommand(updateStr);
				sqlCmd.Connection=sqlConnection ;
				sqlConnection .Open();
				status=sqlCmd.ExecuteNonQuery();
				sqlConnection .Close();
				// Displaying appropriate message for the the status of execution of query.
				if(status==1)
				{
					lblDispMsg.Text="Updated Successfully.....";
				}
				else
				{
					lblDispMsg.Text="Updation Failed.....Update Again";
				}
			}
		
		}

		

		private void lnkcmdEndContract_Click(object sender, System.EventArgs e)
		{
			//Set Ad_Id in Session Object and Redirect to endContract Form.
			//When user clicks on End Contract Link.
			Session["Ad_Id"]=txtAdId.Text;
			Response.Redirect("endcontract.aspx");
		}
	}
}
