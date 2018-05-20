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
	/// Summary description for endcontract.
	/// </summary>
	public class endcontract : System.Web.UI.Page
	{
		protected System.Web.UI.WebControls.Label lblRefund;
		protected System.Web.UI.WebControls.RadioButton chkYes;
		protected System.Web.UI.WebControls.RadioButton chkNo;
		protected System.Web.UI.WebControls.Label lblEnd;
		protected System.Web.UI.WebControls.Button cmdEnd;
		protected System.Web.UI.WebControls.TextBox txtRefund;
		protected SqlDataAdapter sdaEndCont;
		protected DataSet DSEndCont;
		protected System.Web.UI.WebControls.Button cmdBack;
		protected System.Web.UI.WebControls.Label lblMsg;
		protected SqlConnection sqlCon;

	
		private void Page_Load(object sender, System.EventArgs e)
		{
			//Check For a Valid User using Session Object
			if(Session["UserName"]==null)
			{
				Response.Redirect ("InvalidSession.aspx");
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
			this.chkNo.CheckedChanged += new System.EventHandler(this.chkNo_CheckedChanged);
			this.cmdEnd.Click += new System.EventHandler(this.cmdEnd_Click);
			this.cmdBack.Click += new System.EventHandler(this.cmdBack_Click);
			this.Load += new System.EventHandler(this.Page_Load);

		}
		#endregion

		private void cmdEnd_Click(object sender, System.EventArgs e)
		{
			//Check whether user has clicked on Yes 
			if(!chkYes.Checked)
			{
				Response.Write("Please Check The Options");
			}
			else
			{
				int intTotDays,intRemDays;
				double dblAmtPaid;
				
				//Get The AD_ID from Session Object
				string strAdId=Session["Ad_Id"].ToString();
				
				//Set End Date to Todays Date
				string strEndDate=DateTime.Now.ToShortDateString();
				
				//Create DataSet for End Contract
				DSEndCont=new DataSet();
				
				//Establish Connection
				sqlCon=new SqlConnection(ConfigurationSettings.AppSettings["CONNECTION"]);
				
				//Get row for selected Ad_Id
				sdaEndCont=new SqlDataAdapter("select * from Ad_AdvDetails_TB where Ad_Id='"+strAdId+"'",sqlCon );
				sdaEndCont.Fill(DSEndCont,"Ad_AdvDetails_TB");
				
				//Assign Command Builder for SqlDataAdapter
				SqlCommandBuilder sqlCmdBld=new SqlCommandBuilder(sdaEndCont);
			
				//Get Start Date and End Date from Database for particular Ad_Id
				DateTime dtStart=(DateTime)DSEndCont.Tables[0].Rows[0]["Start_Date"];
				DateTime dtEnd=(DateTime)DSEndCont.Tables[0].Rows[0]["End_Date"];
				dblAmtPaid=Convert.ToDouble (DSEndCont.Tables[0].Rows[0]["Amount_Paid"]);

				//Call Stored Procedures For Calculating The Date Diffrences

				string commandString="ad_calcDate_proc";
				SqlCommand command =new SqlCommand (commandString,sqlCon);
				command .CommandType =CommandType .StoredProcedure ;
				SqlParameter param=new SqlParameter ("@Dt_StartDate" ,SqlDbType.DateTime );
				param.Value =dtStart.ToShortDateString();
				command.Parameters .Add (param);
				param=new SqlParameter ("@Dt_EndDate" ,SqlDbType.DateTime );
				param.Value =dtEnd.ToShortDateString();
				command.Parameters .Add (param);
				param=new SqlParameter ("@Res" ,SqlDbType.Int  );
				param.Direction =ParameterDirection .Output ;
				command.Parameters .Add (param);
				sqlCon.Open();
				command .ExecuteNonQuery ();
				sqlCon.Close();
		
				//Get Total Days for Contract
				intTotDays=int.Parse (command.Parameters [2].Value.ToString ());
			
				//Call One again stored procedure

				commandString="ad_calcDate_proc";
				command =new SqlCommand (commandString,sqlCon);
				command .CommandType =CommandType .StoredProcedure ;
				param=new SqlParameter ("@Dt_StartDate" ,SqlDbType.DateTime );
				param.Value =DateTime.Now.ToShortDateString();
				command.Parameters .Add (param);
				param=new SqlParameter ("@Dt_EndDate" ,SqlDbType.DateTime );
				param.Value =dtEnd.ToShortDateString();
				command.Parameters .Add (param);
				param=new SqlParameter ("@Res" ,SqlDbType.Int  );
				param.Direction =ParameterDirection .Output ;
				command.Parameters .Add (param);
				sqlCon.Open();
				command .ExecuteNonQuery ();
				sqlCon.Close();
				
				//Calculate Remaining days left for ending the contract
				intRemDays=int.Parse (command.Parameters [2].Value.ToString ());

					
				if(intTotDays <intRemDays)
				{
					lblMsg.Text ="Your Contract Has Been Cancelled....";	
					cmdBack .Visible=true;
				}
				else if(intRemDays<0)
				{
					lblMsg.Text ="Your Contract Has Already Been Ended.....";	
					txtRefund.Visible =false;
					lblRefund .Visible =false;
				}
				else
				{
					//Calculate Refundable Amount
					double dblRefun=((double)(intRemDays/(double)intTotDays))*dblAmtPaid;
					txtRefund.Text=dblRefun.ToString();

					txtRefund.Visible =true;
					lblRefund .Visible =true;
					lblEnd.Visible =false;
					chkYes .Visible =false;
					chkNo .Visible =false;
					cmdEnd .Visible=false;
					cmdBack .Visible=true;

					//Set End To Todays date and populate changes to Database
					DSEndCont.Tables[0].Rows[0]["End_Date"]=DateTime.Now.ToShortDateString();
					sqlCon.Open();
					sdaEndCont.Update(DSEndCont,"Ad_AdvDetails_TB");
					sqlCon.Close();
					lblMsg.Text ="Your Contract Has Been Cancelled....";	
				}
			}
			
		}

		private void chkNo_CheckedChanged(object sender, System.EventArgs e)
		{
			//Redirect to Update Form when user clicks on NO radio button
			Response.Redirect("updateForm.aspx");
		}

		private void cmdBack_Click(object sender, System.EventArgs e)
		{
			//Redirect to Update Form when user clicks on Back Button
			Response.Redirect("updateForm.aspx");
		}

	}
}
