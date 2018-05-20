using System;
using System.Collections;
using System.ComponentModel;
using System.Data;
using System.Data.SqlClient ;
using System.Drawing;
using System.Web;
using System.Web.SessionState;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Web.UI.HtmlControls;
using System.Configuration ;

namespace BestTours
{
	/// <summary>
	/// Summary description for WebForm3.
	/// </summary>
	public class WebForm3 : System.Web.UI.Page
	{
		protected System.Web.UI.WebControls.DataGrid RecordGrid;
		protected System.Web.UI.WebControls.Label Message;
		protected System.Web.UI.WebControls.Label Label1;
		protected System.Web.UI.WebControls.LinkButton LinkButton1;
		protected System.Web.UI.WebControls.DataGrid VehiclesGrid;

	
		private void Page_Load(object sender, System.EventArgs e)
		{
			
			if(!Page.IsPostBack)
			{
				string ConDetails = ConfigurationSettings.AppSettings ["BT"];
				SqlConnection con = new SqlConnection (ConDetails);
		
				
				SqlCommand com = new SqlCommand ("select top 1 P_COMPANY_REPRESENTATIVE_NAME,P_COMPANY_NAME,P_TELEPHONE,P_DESTINATION_NAME,P_START_DATE,P_RETURN_DATE from BST_TVL_PLANS_TB",con);
				SqlDataAdapter Adapter = new SqlDataAdapter (com);
				DataSet Ds = new DataSet ();
				Adapter.Fill(Ds,"BST_TVL_PLANS_TB");
				RecordGrid.DataSource = Ds;
				if(Ds.Tables [0].Rows.Count ==0)
				{
					//Message.Text = "No Vehicles Booked!!!";
					Label1.Visible = true;
					RecordGrid.Visible = false;
					VehiclesGrid.Visible = false;

				}


				RecordGrid.DataBind ();

				SqlCommand com1 = new SqlCommand ("select P_SELECTED_VEHICLE,P_VEHICLE_TYPE,P_NUMBER_OF_PEOPLE,P_TOTAL_AMOUNT from BST_TVL_PLANS_TB",con);
				SqlDataAdapter Adapter1 = new SqlDataAdapter (com1);
				DataSet Ds1 = new DataSet ();
				Adapter1.Fill(Ds1,"BST_TVL_PLANS_TB");
				VehiclesGrid.DataSource = Ds1;
				VehiclesGrid.DataBind ();

				
		
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
			this.RecordGrid.SelectedIndexChanged += new System.EventHandler(this.RecordGrid_SelectedIndexChanged);
			this.VehiclesGrid.ItemCommand += new System.Web.UI.WebControls.DataGridCommandEventHandler(this.VehiclesGrid_ItemCommand);
			this.VehiclesGrid.EditCommand += new System.Web.UI.WebControls.DataGridCommandEventHandler(this.VehiclesGrid_EditCommand);
			this.VehiclesGrid.UpdateCommand += new System.Web.UI.WebControls.DataGridCommandEventHandler(this.VehiclesGrid_UpdateCommand);
			this.VehiclesGrid.SelectedIndexChanged += new System.EventHandler(this.VehiclesGrid_SelectedIndexChanged);
			this.LinkButton1.Click += new System.EventHandler(this.LinkButton1_Click);
			this.Load += new System.EventHandler(this.Page_Load);

		}
		#endregion

		
		private void RecordGrid_SelectedIndexChanged(object sender, System.EventArgs e)
		{
		
		}

		private void VehiclesGrid_SelectedIndexChanged(object sender, System.EventArgs e)
		{
			                                            
		}

		private void VehiclesGrid_UpdateCommand(object source, System.Web.UI.WebControls.DataGridCommandEventArgs e)
		{
		
		}

		private void VehiclesGrid_EditCommand(object source, System.Web.UI.WebControls.DataGridCommandEventArgs e)
		{
			string ConDetails = ConfigurationSettings.AppSettings ["BT"];
			
			SqlConnection con1 = new SqlConnection (ConDetails);
			SqlConnection con2 = new SqlConnection (ConDetails);
			SqlConnection con3 = new SqlConnection (ConDetails);
			SqlConnection con4 = new SqlConnection (ConDetails);
			SqlConnection con5 = new SqlConnection (ConDetails);

			SqlCommand cmd1 = new SqlCommand ("select * from BST_TVL_PLANS_TB",con1);
			SqlCommand cmd2 = new SqlCommand("insert into BST_TVL_REGISTRATION_TB values(@RegistrationId,@RepresentativeName,@CompanyName,@Tel,@Destination,@StartDate,@ReturnDate,@NumberOfPeople,@TotalAmount)",con2);
			
			con1.Open ();
			con2.Open ();
			con3.Open ();
			
			
			


			SqlDataReader Reader = cmd1.ExecuteReader ();
		
			
			cmd2.Parameters.Add("@RegistrationId",SqlDbType.VarChar, 30);
			cmd2.Parameters.Add("@RepresentativeName",SqlDbType.Char, 20);
			cmd2.Parameters.Add("@CompanyName",SqlDbType.Char, 15);
			cmd2.Parameters.Add("@Tel",SqlDbType.Char, 12);
			cmd2.Parameters.Add("@Destination",SqlDbType.VarChar,30);
			cmd2.Parameters.Add("@StartDate",SqlDbType.DateTime);
			cmd2.Parameters.Add("@ReturnDate",SqlDbType.DateTime);
			cmd2.Parameters.Add("@NumberOfPeople",SqlDbType.TinyInt);

			cmd2.Parameters.Add("@TotalAmount",SqlDbType.Int);
			
			string VehicleId = "";
			string[] VehicleArray;
			ArrayList VidArray = new ArrayList ();
			
			if(e.Item.ItemIndex == 0)
			{
		
				Reader.Read ();
				string VA = Reader.GetString (8);

				VehicleArray = VA.Split(',');

				for(int i=0;i<VehicleArray.Length;i++)
				{
		
				   
					SqlCommand cmd3 = new SqlCommand ("select PK_V_VEHICLE_ID from BST_TVL_VEHICLE_TB,BST_TVL_PLANS_TB where BST_TVL_VEHICLE_TB.FK_VEHICLE_VEHICLEINFO=@SelectedVehicle and V_STATUS=0",con3);			

					cmd3.Parameters.Add("@SelectedVehicle",SqlDbType.VarChar, 20);
					cmd3.Parameters ["@SelectedVehicle"].Value = VehicleArray[i];
				
					VehicleId =Convert.ToString(cmd3.ExecuteScalar ());
					
					con5.Open();
					SqlCommand cmd5 = new SqlCommand ("update BST_TVL_VEHICLE_TB set V_STATUS = 1 where PK_V_VEHICLE_ID = @id",con5);
					cmd5.Parameters.Add ("@id",SqlDbType.VarChar,9);
					cmd5.Parameters ["@id"].Value = VehicleId;
					cmd5.ExecuteNonQuery ();
					con5.Close();
				
					if(i==0)
					{

						cmd2.Parameters["@RegistrationId"].Value = Session.SessionID + Request.QueryString [0];
                        					
						
						//int cnt = Convert.ToInt32 (Request.QueryString[0]);
						//cnt++;
						//Request.QueryString[0] = cnt.ToString ();


						cmd2.Parameters["@RepresentativeName"].Value= Reader.GetString (0);
						cmd2.Parameters["@CompanyName"].Value = Reader.GetString (1);
						cmd2.Parameters["@Tel"].Value=Reader.GetString (2);
						cmd2.Parameters["@Destination"].Value=Reader.GetString (3);
						cmd2.Parameters["@StartDate"].Value=Reader.GetValue (4);
						cmd2.Parameters["@ReturnDate"].Value=Reader.GetValue (5);
				
						cmd2.Parameters["@NumberOfPeople"].Value=Reader.GetValue(7);
						
						cmd2.Parameters["@TotalAmount"].Value=Reader.GetValue (9);

						cmd2.ExecuteNonQuery ();
					}

	
					con4.Open ();				
					SqlCommand cmd4 = new SqlCommand ("insert into BST_TVL_BOOKED_VEHICLES_TB values (@RegId,@Vid,@Name)",con4);			

					cmd4.Parameters.Add("@RegId",SqlDbType.VarChar, 30);
					cmd4.Parameters.Add ("@Vid",SqlDbType.VarChar, 9);
					cmd4.Parameters.Add("@Name",SqlDbType.VarChar, 20);

					cmd4.Parameters["@RegId"].Value=Session.SessionID + Request.QueryString [0];
					cmd4.Parameters["@Vid"].Value=VehicleId;
					string v = VehicleArray[i].ToString ();
		
					cmd4.Parameters ["@Name"].Value = v;
					cmd4.ExecuteNonQuery ();
					con4.Close ();

					VidArray.Add(VehicleId);
				}
				
			}
			else if(e.Item.ItemIndex  == 1)
			{
				Reader.Read ();
				Reader.Read ();
				string VA = Reader.GetString (8);

				VehicleArray = VA.Split(',');

				for(int i=0;i<VehicleArray.Length;i++)
				{
		
				
					SqlCommand cmd3 = new SqlCommand ("select PK_V_VEHICLE_ID from BST_TVL_VEHICLE_TB,BST_TVL_PLANS_TB where BST_TVL_VEHICLE_TB.FK_VEHICLE_VEHICLEINFO=@SelectedVehicle and V_STATUS=0",con3);			

					cmd3.Parameters.Add("@SelectedVehicle",SqlDbType.VarChar, 20);
					cmd3.Parameters ["@SelectedVehicle"].Value = VehicleArray[i];
				
					VehicleId =Convert.ToString(cmd3.ExecuteScalar ());
				
					con5.Open();
					SqlCommand cmd5 = new SqlCommand ("update BST_TVL_VEHICLE_TB set V_STATUS = 1 where PK_V_VEHICLE_ID = @id",con5);
					cmd5.Parameters.Add ("@id",SqlDbType.VarChar,9);
					cmd5.Parameters ["@id"].Value = VehicleId;
					cmd5.ExecuteNonQuery ();
					con5.Close();


					if(i==0)
					{
						cmd2.Parameters["@RegistrationId"].Value=Session.SessionID + Request.QueryString [0];
						cmd2.Parameters["@RepresentativeName"].Value= Reader.GetString (0);
						cmd2.Parameters["@CompanyName"].Value = Reader.GetString (1);
						cmd2.Parameters["@Tel"].Value=Reader.GetString (2);
						cmd2.Parameters["@Destination"].Value=Reader.GetString (3);
						cmd2.Parameters["@StartDate"].Value=Reader.GetValue(4);
						cmd2.Parameters["@ReturnDate"].Value=Reader.GetValue (5);
				
						cmd2.Parameters["@NumberOfPeople"].Value=Reader.GetValue(7);
						
						cmd2.Parameters["@TotalAmount"].Value=Reader.GetValue (9);

						cmd2.ExecuteNonQuery ();
					}

	
					con4.Open ();				
					SqlCommand cmd4 = new SqlCommand ("insert into BST_TVL_BOOKED_VEHICLES_TB values (@RegId,@Vid,@Name)",con4);			

					cmd4.Parameters.Add("@RegId",SqlDbType.VarChar, 30);
					cmd4.Parameters.Add ("@Vid",SqlDbType.VarChar, 9);
					cmd4.Parameters.Add("@Name",SqlDbType.VarChar, 20);

					cmd4.Parameters["@RegId"].Value=Session.SessionID + Request.QueryString [0];
					cmd4.Parameters["@Vid"].Value=VehicleId;
					string v = VehicleArray[i].ToString ();
		
					cmd4.Parameters ["@Name"].Value = v;
					cmd4.ExecuteNonQuery ();
					con4.Close ();

					VidArray.Add(VehicleId);
				}
			}
			else if(e.Item.ItemIndex  == 2)
			{
				Reader.Read ();
				Reader.Read ();
				Reader.Read ();
				string VA = Reader.GetString (8);

				VehicleArray = VA.Split(',');

				for(int i=0;i<VehicleArray.Length;i++)
				{
		
				
					SqlCommand cmd3 = new SqlCommand ("select PK_V_VEHICLE_ID from BST_TVL_VEHICLE_TB,BST_TVL_PLANS_TB where BST_TVL_VEHICLE_TB.FK_VEHICLE_VEHICLEINFO=@SelectedVehicle and V_STATUS=0",con3);			

					cmd3.Parameters.Add("@SelectedVehicle",SqlDbType.VarChar, 20);
					cmd3.Parameters ["@SelectedVehicle"].Value = VehicleArray[i];
				
					VehicleId =Convert.ToString(cmd3.ExecuteScalar ());

					con5.Open();
					SqlCommand cmd5 = new SqlCommand ("update BST_TVL_VEHICLE_TB set V_STATUS = 1 where PK_V_VEHICLE_ID = @id",con5);
					cmd5.Parameters.Add ("@id",SqlDbType.VarChar,9);
					cmd5.Parameters ["@id"].Value = VehicleId;
					cmd5.ExecuteNonQuery ();
					con5.Close();
				
					if(i==0)
					{
						cmd2.Parameters["@RegistrationId"].Value=Session.SessionID + Request.QueryString [0];
						cmd2.Parameters["@RepresentativeName"].Value= Reader.GetString (0);
						cmd2.Parameters["@CompanyName"].Value = Reader.GetString (1);
						cmd2.Parameters["@Tel"].Value=Reader.GetString (2);
						cmd2.Parameters["@Destination"].Value=Reader.GetString (3);
						cmd2.Parameters["@StartDate"].Value=Reader.GetValue (4);
						cmd2.Parameters["@ReturnDate"].Value=Reader.GetValue (5);
				
						cmd2.Parameters["@NumberOfPeople"].Value=Reader.GetValue(7);
						
						cmd2.Parameters["@TotalAmount"].Value=Reader.GetValue (9);

						cmd2.ExecuteNonQuery ();
					}

	
					con4.Open ();				
					SqlCommand cmd4 = new SqlCommand ("insert into BST_TVL_BOOKED_VEHICLES_TB values (@RegId,@Vid,@Name)",con4);			

					cmd4.Parameters.Add("@RegId",SqlDbType.VarChar, 30);
					cmd4.Parameters.Add ("@Vid",SqlDbType.VarChar, 9);
					cmd4.Parameters.Add("@Name",SqlDbType.VarChar, 20);

					cmd4.Parameters["@RegId"].Value=Session.SessionID+ Request.QueryString[0];
					cmd4.Parameters["@Vid"].Value=VehicleId;
					string v = VehicleArray[i].ToString ();
		
					cmd4.Parameters ["@Name"].Value = v;
					cmd4.ExecuteNonQuery ();
					con4.Close ();

					VidArray.Add(VehicleId);
					Message.Text += VidArray[i];
				}
			}
			Message.Visible = true;

			con1.Close ();
			con2.Close ();
			con3.Close ();
			
			con1.Open ();
			SqlCommand ChangeStatus = new SqlCommand ("update BST_TVL_VEHICLE_TB set V_STATUS = 0",con1);
			ChangeStatus.ExecuteNonQuery ();
			con1.Close ();
			Message.Text = "Vehicle BOOKED Successfully...";													
		
	
			con1.Open ();
			SqlCommand TruncateTable = new SqlCommand ("truncate table BST_TVL_PLANS_TB",con1);
			TruncateTable.ExecuteNonQuery ();
			con1.Close ();

			//e.Item.Cells[4].Enabled = false;
			VehiclesGrid.Enabled = false;
			//Session.Clear ();
			//Message.Text = Session.SessionID ;
			//Message.Visible = true;

		
		}

		private void VehiclesGrid_ItemCommand(object source, System.Web.UI.WebControls.DataGridCommandEventArgs e)
		{
		
		}

		private void LinkButton1_Click(object sender, System.EventArgs e)
		{
			Response.Redirect ("WebForm1.aspx");
		}
	}
}
