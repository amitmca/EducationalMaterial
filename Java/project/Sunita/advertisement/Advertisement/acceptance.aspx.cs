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
	/// Summary description for acceptance.
	/// </summary>
	public class acceptance : System.Web.UI.Page
	{
		protected System.Web.UI.WebControls.DataGrid dgAccept;
		protected SqlDataAdapter sdaDetailsTB;
		protected SqlDataAdapter sdaAcceptTB;
		protected System.Web.UI.WebControls.Label Label1;
		protected System.Web.UI.WebControls.Button cmdAccept;
		protected DataSet DSDetails;
		protected DataSet DSAccept;
		protected SqlCommand sqlcmdProc;
		
	
		private void Page_Load(object sender, System.EventArgs e)
		{
			// Check for valid user with Session object.
			if(Session["UserName"]==null)
			{
				Response.Redirect ("InvalidSession.aspx");
			}
			else
			{
				//SQL Adapter for selecting rows which are not accepted by staff.
				sdaDetailsTB =new SqlDataAdapter("select * from Ad_AdvDetails_TB where Accpt_Cleared=0",ConfigurationSettings.AppSettings["CONNECTION"]);
				DSDetails=new DataSet();
				sdaDetailsTB.Fill(DSDetails,"Ad_AdvDetails_TB");
				
				//If PostBack dont bind .
				if(!Page.IsPostBack)
				{
					//Set Datasource to dataset and Bind th data.
					dgAccept.DataSource=DSDetails;
					dgAccept.DataMember="Ad_AdvDetails_TB";
					dgAccept.DataBind();
				
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
			this.dgAccept.SelectedIndexChanged += new System.EventHandler(this.dgAccept_SelectedIndexChanged);
			this.cmdAccept.Click += new System.EventHandler(this.cmdAccept_Click);
			this.Load += new System.EventHandler(this.Page_Load);

		}
		#endregion

		private void cmdAccept_Click(object sender, System.EventArgs e)
		{
			
			CheckBox chkCheck;
			
			//Create Parameter For Stored Procedures .
			SqlParameter paraAdID= new SqlParameter("@Vr_Ad_ID",SqlDbType.VarChar);
			SqlParameter paraAccept=new SqlParameter("@Vr_Accepted",SqlDbType.Bit);
			SqlParameter paraReason=new SqlParameter("@Vr_Reason",SqlDbType.VarChar);
			
			//Establish Connection and Set Procedure Name in SqlCommand.
			SqlConnection sqlCon=new SqlConnection(ConfigurationSettings.AppSettings["CONNECTION"]);
			sqlcmdProc=new SqlCommand("Ad_InsertAccept_PROC");
			sqlcmdProc.Connection=sqlCon;
			
			//Set Command Type as Procedure.
			sqlcmdProc.CommandType=CommandType.StoredProcedure;
			
			//Check Each Row in Data Grid whether checkbox is checked or not.
			int intRowCount=0;
			foreach(DataGridItem dgItem in dgAccept.Items)
			{
				//Find The CheckBox Control and get reference to that.
				chkCheck=((CheckBox)dgItem.FindControl("chkAccept"));
				
				//Check for whether CheckBox is checked.
				if(chkCheck.Checked)
				{
						//Assign Values to Stored procedure parameters.
					    paraAdID.Value=dgItem.Cells[2].Text.ToString(); ;
					    paraAccept.Value=1;
					    paraReason.Value="Accepted";
						
						//Add Parameters to Stored Procedures.
						sqlcmdProc.Parameters.Add(paraAdID);
						sqlcmdProc.Parameters.Add(paraAccept);
						sqlcmdProc.Parameters.Add(paraReason);
						
						//Open Connection,Execute Stored Procedure and Close connection.
						sqlCon.Open();
						sqlcmdProc.ExecuteNonQuery();
						sqlCon.Close();

						sqlcmdProc.Parameters.Remove(paraAdID);
						sqlcmdProc.Parameters.Remove(paraAccept);
						sqlcmdProc.Parameters.Remove(paraReason);
					
					    
				}
				intRowCount++;
			}
		//Redirect to same page so that user can see Ad's has been accepted .
		Response.Redirect("acceptance.aspx");
			
		}

		private void dgAccept_SelectedIndexChanged(object sender, System.EventArgs e)
		{
		
		}
		
	}
}
