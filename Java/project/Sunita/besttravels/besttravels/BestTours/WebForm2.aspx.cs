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
using System.Configuration ;
using System.Web.UI.HtmlControls;

namespace BestTours
{
	/// <summary>
	/// Summary description for WebForm2.
	/// </summary>
	public class WebForm2 : System.Web.UI.Page
	{
		protected System.Web.UI.WebControls.TextBox CompanyName;
		protected System.Web.UI.WebControls.TextBox TextBox2;
		protected System.Web.UI.WebControls.TextBox TextBox3;
		protected System.Web.UI.WebControls.DropDownList DDLP_VEHICLE_TYPE;
		protected System.Web.UI.WebControls.DropDownList DDLPeople;
		protected System.Web.UI.WebControls.Button Button4;
		protected System.Web.UI.WebControls.RequiredFieldValidator RequiredFieldValidator1;
		protected System.Web.UI.WebControls.RequiredFieldValidator RequiredFieldValidator2;
		protected System.Web.UI.WebControls.DropDownList DDLDestination;
		protected System.Web.UI.WebControls.DropDownList DDLVehicles;
		protected System.Web.UI.WebControls.Calendar Calendar1;
		protected System.Web.UI.WebControls.Calendar Calendar2;
		protected System.Web.UI.WebControls.TextBox StartDate;
		protected System.Web.UI.WebControls.Button BrowseCalendar1;
		protected System.Web.UI.WebControls.TextBox ReturnDate;
		protected System.Web.UI.WebControls.Button BrowseCalendar2;
		protected System.Web.UI.WebControls.Label ErrorDate;
		protected System.Web.UI.WebControls.Label ErrorReturnDate;
		protected System.Web.UI.WebControls.TextBox ReprName;
		protected System.Web.UI.WebControls.TextBox Telephone;
		protected System.Web.UI.WebControls.RegularExpressionValidator RegularExpressionValidator1;
		protected System.Web.UI.WebControls.RegularExpressionValidator RegularExpressionValidator2;
		protected System.Web.UI.WebControls.RegularExpressionValidator RegularExpressionValidator3;
		protected System.Web.UI.WebControls.Button Save;
		protected System.Web.UI.WebControls.Button Add;
		protected System.Web.UI.WebControls.Label Label1;
		protected System.Web.UI.WebControls.TextBox Total;
		protected System.Web.UI.WebControls.CompareValidator CompareValidator1;
		protected System.Web.UI.WebControls.CompareValidator CompareValidator4;
		protected System.Web.UI.WebControls.RequiredFieldValidator RequiredFieldValidator3;
		protected System.Web.UI.WebControls.Button AddMore;

	    static System.TimeSpan NumberOfDays;
		static int SessionCounter;

		protected System.Web.UI.WebControls.TextBox TextBox1;
		protected System.Web.UI.WebControls.ListBox ListBox1;
		protected System.Web.UI.WebControls.ListBox ListVehicles;
		protected System.Web.UI.WebControls.TextBox NumberOfPeople;
		protected System.Web.UI.WebControls.RegularExpressionValidator RegularExpressionValidator4;
		protected System.Web.UI.WebControls.RequiredFieldValidator RequiredFieldValidator4;
		protected System.Web.UI.WebControls.Label LblErrorCnt;
		protected System.Web.UI.WebControls.Label NoVehicleErr;
		protected System.Web.UI.WebControls.DropDownList DDLVehicleType;
		static int SaveCounter;

		private void Page_Load(object sender, System.EventArgs e)
		{
			if(!Page.IsPostBack)
			{
				
				string ConDetails = ConfigurationSettings.AppSettings ["BT"];
				SqlConnection con = new SqlConnection (ConDetails);
				con.Open ();
				
				SqlCommand comm = new SqlCommand ("select PK_D_DESTINATION_NAME from BST_TVL_DESTINATION_TB",con);
				SqlDataReader Reader = comm.ExecuteReader ();
				while(Reader.Read ())
				{
					DDLDestination.Items.Add (Reader.GetString (0));
				}
				Reader.Close ();
				con.Close ();
				SaveCounter = 0;
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
			this.BrowseCalendar2.Click += new System.EventHandler(this.Button5_Click);
			this.ReturnDate.TextChanged += new System.EventHandler(this.ReturnDate_TextChanged);
			this.Button4.Click += new System.EventHandler(this.Button4_Click);
			this.Save.Click += new System.EventHandler(this.Save_Click);
			this.CompanyName.TextChanged += new System.EventHandler(this.CompanyName_TextChanged);
			this.DDLVehicleType.SelectedIndexChanged += new System.EventHandler(this.DDLVehicleType_SelectedIndexChanged);
			this.Calendar1.SelectionChanged += new System.EventHandler(this.Calendar1_SelectionChanged);
			this.StartDate.TextChanged += new System.EventHandler(this.StartDate_TextChanged);
			this.BrowseCalendar1.Click += new System.EventHandler(this.Button3_Click);
			this.Calendar2.SelectionChanged += new System.EventHandler(this.Calendar2_SelectionChanged);
			this.AddMore.Click += new System.EventHandler(this.AddMore_Click);
			this.ListVehicles.SelectedIndexChanged += new System.EventHandler(this.ListVehicles_SelectedIndexChanged);
			this.NumberOfPeople.TextChanged += new System.EventHandler(this.NumberOfPeople_TextChanged);
			this.Load += new System.EventHandler(this.Page_Load);

		}
		#endregion
		private void Button1_Click(object sender, System.EventArgs e)
		{
				
		}

		

		private void Button4_Click(object sender, System.EventArgs e)
		{
			
			SessionCounter++;
			string StrSaveCounter = SessionCounter.ToString ();
			Server.Transfer ("WebForm3.aspx?"+StrSaveCounter);
			//Server.Transfer("WegForm3.aspx");
		}

		
		private void PopulateVehicleList()
		{	

			string RequiredVehicleType = DDLVehicleType.SelectedValue;		
		
            string Command = "select BST_TVL_VEHICLE_TB.FK_VEHICLE_VEHICLEINFO,BST_TVL_VEHICLE_TB.PK_V_VEHICLE_ID from BST_TVL_VEHICLE_TB INNER JOIN BST_TVL_VEHICLEINFO_TB on BST_TVL_VEHICLE_TB.FK_VEHICLE_VEHICLEINFO=BST_TVL_VEHICLEINFO_TB.PK_VI_VEHICLE_NAME and BST_TVL_VEHICLEINFO_TB.VI_VEHICLE_TYPE=@RequiredVehicleType where BST_TVL_VEHICLE_TB.PK_V_VEHICLE_ID not in (Select b.FK_BOKD_VEHICLES_VEHICLE from BST_TVL_BOOKED_VEHICLES_TB as b inner join BST_TVL_REGISTRATION_TB as r on b.FK_BOKD_VEHICLE_REGISTRATION = r.PK_R_REGISTRATION_ID where (( r.R_START_DATE <= @SD and @SD <= r.R_RETURN_DATE) or ( r.R_START_DATE <= @RD and @RD <= r.R_RETURN_DATE))or (@SD < r.R_START_DATE and @RD >r.R_RETURN_DATE))";
			string ConDetails = ConfigurationSettings.AppSettings ["BT"];
			SqlConnection con = new SqlConnection (ConDetails);
			con.Open ();
			
			SqlCommand comm = new SqlCommand (Command,con);

			comm.Parameters.Add ("@RequiredVehicleType",SqlDbType.Char,10);
			comm.Parameters["@RequiredVehicleType"].Value = RequiredVehicleType;
			
			comm.Parameters.Add ("@SD",SqlDbType.DateTime);
			comm.Parameters["@SD"].Value = Calendar1.SelectedDate.Date;
			
			comm.Parameters.Add ("@RD",SqlDbType.DateTime);
			comm.Parameters["@RD"].Value = Calendar2.SelectedDate.Date;
            
			SqlDataReader Reader = comm.ExecuteReader ();
			if(!Reader.HasRows)
			{
				NoVehicleErr.Text = "No vehicles available on the specified period";
				NoVehicleErr.Visible = true;
				ListVehicles.Items.Clear();
				return;
			}


			ListVehicles.Items.Clear();
         
			while(Reader.Read ())
			{
				ListVehicles.Items.Add (Reader.GetString (0) + "-" + Reader.GetString (1));
			}
			Reader.Close ();
			con.Close ();

			

			 
		}
		private void DDLVehicleType_SelectedIndexChanged(object sender, System.EventArgs e)
		{
			if(StartDate.Text == "")
			{
				ErrorDate.Text = "Please Specify Start Date";
				ErrorDate.Visible = true;
				return;
			}
			if(ReturnDate.Text == "")
			{
				ErrorReturnDate.Text = "Please Return Start Date";
				ErrorReturnDate.Visible = true;
				return;
			}  
			
			   Calendar2.Visible = false;
			   Calendar1.Visible = false;
               NoVehicleErr.Visible = false;	
				
			   PopulateVehicleList();	
			
		}

		private void CompanyName_TextChanged(object sender, System.EventArgs e)
		{
		
		}

		private void Calendar1_SelectionChanged(object sender, System.EventArgs e)
		{
			StartDate.Text = Calendar1.SelectedDate.Date.ToString ("dd-MM-yy");
			if(ReturnDate.Text != "")
			{
				if(Calendar2.SelectedDate.Date.ToUniversalTime () < Calendar1.SelectedDate.Date.ToUniversalTime ())
				{
					ErrorReturnDate.Text = "Return Date Can not be before Start Date";
					ErrorReturnDate.Visible = true;
					ReturnDate.Text = "";
					Calendar2.Visible = false;
					Calendar1.Visible = false;
					
				}
				else
					Calendar1.Visible = true;
			}
			
				if(Calendar1.SelectedDate.Date.ToUniversalTime () <= System.DateTime.Now.ToUniversalTime ())
				{
					ErrorDate.Text = "Start Date Cannot be before tommorrow";
					ErrorDate.Visible = true;
					StartDate.Text = "";
					Calendar1.Visible = false;
				}
				else
				{
					ErrorDate.Visible = false;
				
				}
			
			Calendar1.Visible = false;
		}

		private void Button3_Click(object sender, System.EventArgs e)
		{
			    NoVehicleErr.Visible = false;
				ErrorDate.Text = "Start Date Cannot be before tommorrow";
				Calendar1.Visible = true;
				Calendar2.Visible = false;
				ErrorDate.Visible = false;
				ErrorReturnDate.Visible = false;
			

		}

		private void Button5_Click(object sender, System.EventArgs e)
		{
			NoVehicleErr.Visible = false;
			Calendar2.Visible = true;
			Calendar1.Visible = false;
			ErrorReturnDate.Text = "Return Date Cannot be before Start Date";
			ErrorReturnDate.Visible = false;
			ErrorDate.Visible = false;
		}

		private void Calendar2_SelectionChanged(object sender, System.EventArgs e)
		{
			ReturnDate.Text = Calendar2.SelectedDate.Date.ToString ("dd-MM-yy");
			if(Calendar2.SelectedDate.Date.ToUniversalTime () < Calendar1.SelectedDate.Date.ToUniversalTime ())
			{
				ErrorReturnDate.Visible = true;
				ReturnDate.Text = "";
				Calendar2.Visible = false;
			}
			else
			{
				ErrorReturnDate.Visible = false;
				
			}
			NumberOfDays = Calendar2.SelectedDate.Date.ToUniversalTime() - Calendar1.SelectedDate.Date.ToUniversalTime();
			if(NumberOfDays.Days > 7)
			{
				ErrorReturnDate.Text = "Vehicle Can not be hired for more than 7 days";
				ErrorReturnDate.Visible = true;
				ReturnDate.Text = "";
				Calendar2.Visible = false;
			}
			Calendar2.Visible = false;
		}

		private void Save_Click(object sender, System.EventArgs e)
		{
			
			SaveCounter++;
			if(SaveCounter >= 3)
				AddMore.Enabled=false; 
			else
				AddMore.Enabled=true;

			int cnt = Convert.ToInt16 (NumberOfPeople.Text);
			int NumberOfVehicles = 0;
			for(int i = 0;i< ListVehicles.Items.Count ;i++)
			{
				if(ListVehicles.Items[i].Selected )
					NumberOfVehicles++;
		
			}

			if(NumberOfVehicles > 4)
			{
				LblErrorCnt.Text = "Sorry We do not lend more \n than 4 vehicles at a time";
				LblErrorCnt.Visible = true;
				SaveCounter--;
				return;
			}
			

			if(DDLVehicleType.SelectedValue == "VAN")
			{
				if(cnt > NumberOfVehicles * 7 )
				{
					LblErrorCnt.Text = "Number of People more than the capacity of the chosen vehicles.";
					LblErrorCnt.Visible = true;
					
					SaveCounter--;
					return;
                 }
				LblErrorCnt.Visible = false;
			}
			else if(DDLVehicleType.SelectedValue == "CAR" )
			{
				          if(cnt > NumberOfVehicles * 4)
				              {
					               LblErrorCnt.Visible = true;
					              SaveCounter--;
					                return;
				              }
				            LblErrorCnt.Visible = false;
			}
					
				

				Calendar1.Visible = false;
				Calendar2.Visible = false;
			

				if(ReturnDate.Text == "")
				{
					ErrorReturnDate.Text = "Please Specify Return Date";
					ErrorReturnDate.Visible = true;
					Calendar2.Visible = false;
					Calendar1.Visible = false;
				}
				else
				{
					ErrorReturnDate.Text = "Return Date Cannot be Before Start Date";
					ErrorReturnDate.Visible = false;
		
				}

				string ConDetails = ConfigurationSettings.AppSettings ["BT"];
				SqlConnection con = new SqlConnection (ConDetails);
				double Cost = 0,Tot=0;
			string RequiredVehicleName="";
			string VehicleList = "";

			for(int j=0;j<ListVehicles.Items.Count;j++)
			{
		
				//con.Open ();
				if(ListVehicles.Items[j].Selected )
				{
								
					string temp = ListVehicles.Items[j].Value;
					string[] ReqdVehicleName = temp.Split ('-');
					RequiredVehicleName = ReqdVehicleName[0];
					if(VehicleList == "")
						VehicleList = RequiredVehicleName;
					else
						VehicleList = VehicleList + "," + RequiredVehicleName;
					string com = "select * from BST_TVL_VEHICLEINFO_TB where PK_VI_VEHICLE_NAME = @RequiredVehicleName";
                   
					con.Open ();

					SqlCommand comm = new SqlCommand (com,con);
					comm.Parameters.Add ("@RequiredVehicleName",SqlDbType.VarChar,20);
					comm.Parameters[0].Value = RequiredVehicleName;
					SqlDataReader Reader = comm.ExecuteReader();
					string RentPerDay="",RentPerKm="";

					if(Reader.HasRows)
					{
						Reader.Read ();
						RentPerDay = Reader["VI_RENT_PER_DAY"].ToString (); 
						RentPerKm = Reader["VI_RATE_PER_KM"].ToString (); 
					}
					con.Close ();   //First Connection is Closed
			
					con.Open ();
					string Location = DDLDestination.SelectedValue.ToString ();
					string query = "select D_DISTANCE from BST_TVL_DESTINATION_TB where PK_D_DESTINATION_NAME = @Location";

					SqlCommand command = new SqlCommand (query,con);
					command.Parameters.Add ("@Location",SqlDbType.VarChar,30);
					command.Parameters[0].Value = Location;
					int Distance = (int)command.ExecuteScalar ();
			
					con.Close ();  //Second Connection is Closed
					
					if(Distance <= 180)
					{
						Cost += float.Parse (RentPerDay) * (NumberOfDays.Days+1);
						Total.Text = Cost.ToString ();
					}
					else
					{
						int intDays = NumberOfDays.Days+1;
			
						double BasicCost = float.Parse(RentPerDay) * intDays;
						double ExtraCost = (Distance-180)*float.Parse(RentPerKm);
						Tot += ExtraCost + BasicCost;
						Total.Text = Tot.ToString ();
					}
				
					
				}
			
					
			}// End of for loop


					//Saving data to temp table
					//=====================================

				con.Open ();
					SqlCommand cmd = new SqlCommand("insert into BST_TVL_PLANS_TB values(@RepresentativeName,@CompanyName,@Tel,@Destination,@StartDate,@ReturnDate,@VehicleType,@NumberOfPeople,@SelectedVehicle,@TotalAmount)",con);
					cmd.Parameters.Add("@RepresentativeName",SqlDbType.Char, 20);
					cmd.Parameters.Add("@CompanyName",SqlDbType.Char, 15);
					cmd.Parameters.Add("@Tel",SqlDbType.Char, 12);
					cmd.Parameters.Add("@Destination",SqlDbType.VarChar,30);
					cmd.Parameters.Add("@StartDate",SqlDbType.DateTime);
					cmd.Parameters.Add("@ReturnDate",SqlDbType.DateTime);
					cmd.Parameters.Add("@VehicleType",SqlDbType.Char, 10);
					cmd.Parameters.Add("@NumberOfPeople",SqlDbType.TinyInt);
					cmd.Parameters.Add("@SelectedVehicle",SqlDbType.VarChar, 70);
					cmd.Parameters.Add("@TotalAmount",SqlDbType.Int);


					cmd.Parameters["@RepresentativeName"].Value=ReprName.Text;
					cmd.Parameters["@CompanyName"].Value=CompanyName.Text;
					cmd.Parameters["@Tel"].Value=Telephone.Text;
					cmd.Parameters["@Destination"].Value=DDLDestination.SelectedValue;
					cmd.Parameters["@StartDate"].Value=Calendar1.SelectedDate.Date ; 
					cmd.Parameters["@ReturnDate"].Value=Calendar2.SelectedDate.Date; 
					cmd.Parameters["@VehicleType"].Value=DDLVehicleType.SelectedValue;
					cmd.Parameters["@NumberOfPeople"].Value= Convert.ToInt16(NumberOfPeople.Text);
					cmd.Parameters["@SelectedVehicle"].Value=VehicleList;

					cmd.Parameters["@TotalAmount"].Value=Total.Text;


					cmd.ExecuteNonQuery();
			
				     con.Close();
				
			     Save.Enabled = false;
				//AddMore.Enabled = true;
		
				
			
			
		}

		private void DDLPeople_SelectedIndexChanged(object sender, System.EventArgs e)
		{
		
		}

		private void AddMore_Click(object sender, System.EventArgs e)
		{
			NumberOfPeople.Text = "";

			CompanyName.ReadOnly = true;
			ReprName.ReadOnly = true;
			Telephone.ReadOnly = true;
			StartDate.ReadOnly = true;
			ReturnDate.ReadOnly = true;
			BrowseCalendar1.Enabled = false;
			BrowseCalendar2.Enabled = false;
			Total.Text="";
			
			DDLDestination.EnableViewState = true;
			DDLDestination.Enabled = false;
		
			DDLVehicleType.ClearSelection ();
			ListVehicles.ClearSelection ();
			
			
			Save.Enabled = true;
			AddMore.Enabled = false;
		}

		private void DDLVehicles_SelectedIndexChanged(object sender, System.EventArgs e)
		{
			if(StartDate.Text == "")
			{
				ErrorDate.Text = "Please Specify Start Date";
				ErrorDate.Visible = true;
			}
			if(ReturnDate.Text == "")
			{
				ErrorReturnDate.Text = "Please Return Start Date";
				ErrorReturnDate.Visible = true;
			}


		}

		private void Select1_ServerChange(object sender, System.EventArgs e)
		{
		
		}

		private void NumberOfPeople_TextChanged(object sender, System.EventArgs e)
		{
			
		}

		private void ListVehicles_SelectedIndexChanged(object sender, System.EventArgs e)
		{
			LblErrorCnt.Visible = false;
		}

		private void StartDate_TextChanged(object sender, System.EventArgs e)
		{
			
		}

		private void ReturnDate_TextChanged(object sender, System.EventArgs e)
		{
			     		
		}

		


		

		

		

		
	}
}
