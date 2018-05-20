using System;
using System.Collections;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Web;
using System.Web.SessionState;
using System.Web.UI;
using System.Data.SqlClient ;
using System.Web.UI.WebControls;
using System.Web.UI.HtmlControls;

namespace BestTours
{
	/// <summary>
	/// Summary description for WebForm1.
	/// </summary>
	public class WebForm1 : System.Web.UI.Page
	{
		protected System.Web.UI.WebControls.LinkButton LinkButton1;
		protected System.Web.UI.WebControls.LinkButton LinkButton2;
		protected System.Web.UI.WebControls.LinkButton LinkButton3;
		protected System.Web.UI.WebControls.LinkButton LinkButton4;
		protected System.Web.UI.WebControls.LinkButton LinkButton5;
		protected System.Web.UI.WebControls.LinkButton LinkButton6;
		protected System.Web.UI.WebControls.LinkButton LinkButton9;
		protected System.Web.UI.WebControls.LinkButton LinkButton7;
		protected System.Web.UI.WebControls.LinkButton LinkButton8;
		protected System.Web.UI.WebControls.DataGrid DataGrid1;
		protected System.Web.UI.WebControls.Button Button6;
		protected System.Web.UI.WebControls.Image Image1;
		protected System.Web.UI.WebControls.Button RegisterButton;
		protected System.Web.UI.WebControls.Button TourPlansButton;
		protected System.Web.UI.WebControls.Panel pnlHeader;
		protected System.Web.UI.WebControls.ImageButton VehicleImgButton;
		protected System.Web.UI.WebControls.ImageButton TouristImgButton;
		protected System.Web.UI.WebControls.Button VehicleDetailsButton;
		protected System.Web.UI.WebControls.Button TouristPlacesButton;
		protected System.Web.UI.WebControls.Panel Pnl7;
		protected System.Web.UI.WebControls.Panel Pnl8;
		protected System.Web.UI.WebControls.Panel Pnl5;
		protected System.Web.UI.WebControls.Label Lbl3;
		protected System.Web.UI.WebControls.Panel Pnl4;
		protected System.Web.UI.WebControls.Label Lbl1;
		protected System.Web.UI.WebControls.Panel Pnl3;
		protected System.Web.UI.WebControls.Panel Pnl6;
		protected System.Web.UI.WebControls.Label Lbl5;
		protected System.Web.UI.WebControls.Panel PnlSearch;
		protected System.Web.UI.WebControls.Button SearchButton;
		protected System.Web.UI.WebControls.TextBox TextBox1;
		protected System.Web.UI.HtmlControls.HtmlInputText Text1;
		protected System.Web.UI.HtmlControls.HtmlTextArea Tc1;
		protected System.Web.UI.HtmlControls.HtmlTextArea Tc3;
		protected System.Web.UI.HtmlControls.HtmlTextArea Tc2;
		protected System.Web.UI.WebControls.Label Label1;
		protected System.Web.UI.WebControls.Label Label2;
		protected System.Web.UI.WebControls.Label Label3;
		protected System.Web.UI.WebControls.TextBox TextBox2;
		protected System.Web.UI.WebControls.Label Label5;
		protected System.Web.UI.WebControls.LinkButton LinkButton10;
		protected System.Web.UI.WebControls.DropDownList DropDownList1;
		protected System.Web.UI.WebControls.DataGrid dtgVehicle;
	    static int SessionCounter;

		private void Page_Load(object sender, System.EventArgs e)
		{
		// Put user code to initialize the page here
			if(!Page.IsPostBack)
			{
				Tc2.Value = "BEST Tours & Travels is a one stop shop for those looking for the best tour and travel services around the country.";
				Tc2.Value += "\n\nIn Travel trade since 1984, the company holds recognition from Department of Tourism & Government of India.";
				Tc2.Value += "\n\nWhether it is for business purposes or for casual outing, the company provides complete travel services.";
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
			this.VehicleDetailsButton.Click += new System.EventHandler(this.VehicleDetailsButton_Click);
			this.TouristPlacesButton.Click += new System.EventHandler(this.TouristPlacesButton_Click);
			this.RegisterButton.Click += new System.EventHandler(this.RegisterButton_Click);
			this.TourPlansButton.Click += new System.EventHandler(this.TourPlansButton_Click);
			this.SearchButton.Click += new System.EventHandler(this.SearchButton_Click);
			this.VehicleImgButton.Click += new System.Web.UI.ImageClickEventHandler(this.VehicleImgButton_Click);
			this.TouristImgButton.Click += new System.Web.UI.ImageClickEventHandler(this.TouristImgButton_Click);
			this.LinkButton9.Click += new System.EventHandler(this.LinkButton9_Click);
			this.LinkButton8.Click += new System.EventHandler(this.LinkButton8_Click);
			this.LinkButton7.Click += new System.EventHandler(this.LinkButton7_Click);
			this.LinkButton6.Click += new System.EventHandler(this.LinkButton6_Click);
			this.LinkButton5.Click += new System.EventHandler(this.LinkButton5_Click);
			this.LinkButton4.Click += new System.EventHandler(this.LinkButton4_Click);
			this.LinkButton1.Click += new System.EventHandler(this.LinkButton1_Click);
			this.LinkButton2.Click += new System.EventHandler(this.LinkButton2_Click);
			this.LinkButton3.Click += new System.EventHandler(this.LinkButton3_Click);
			this.DropDownList1.SelectedIndexChanged += new System.EventHandler(this.DropDownList1_SelectedIndexChanged);
			this.Tc1.ServerChange += new System.EventHandler(this.Tc1_ServerChange);
			this.Load += new System.EventHandler(this.Page_Load);

		}
		#endregion

		private void SearchButton_Click(object sender, System.EventArgs e)
		{
			PnlSearch.Visible = true;
		}

		private void LinkButton5_Click(object sender, System.EventArgs e)
		{
			Pnl3.Visible = true;
			Pnl5.Visible = false;
			Pnl4.Visible = false;

			Tc2.Value = "BEST Tours & Travels is a one stop shop for those looking for the best tour and travel services around the country.";
			Tc2.Value += "\n\nIn Travel trade since 1984, the company holds recognition from Department of Tourism & Government of India.";
			Tc2.Value += "\n\nWhether it is for business purposes or for casual outing, the company provides complete travel services.";
			
		}

		private void LinkButton2_Click(object sender, System.EventArgs e)
		{
			Pnl3.Visible = false;
			Pnl5.Visible = true;
			Pnl4.Visible = false;

			Tc3.Value = "\nThe Home Page has 3 features.\n";
			Tc3.Value += "\n 1. Viewing Vehicle Details.\n";
			Tc3.Value += "\n 2. Viewing Tourist Location Details.\n";
			Tc3.Value += "\n 3. Registering for the Vehicles.\n";
			Tc3.Value += "\n Click on Register Button to view the Form.";
			Tc3.Value += "\n\nYou can see 3 plans and choose the best one.";

		}

		private void LinkButton8_Click(object sender, System.EventArgs e)
		{
			Pnl5.Visible = false;
			Pnl4.Visible = false;
			Pnl3.Visible = true;
			Tc2.Value = "BEST Tours & Travels is a one stop shop for those looking for the best tour and travel services around the country.";
			Tc2.Value += "\n\nIn Travel trade since 1984, the company holds recognition from Department of Tourism & Government of India.";
			Tc2.Value += "\n\nWhether it is for business purposes or for casual outing, the company provides complete travel services.";
		}

		private void LinkButton1_Click(object sender, System.EventArgs e)
		{
			Pnl3.Visible = true;
			Pnl5.Visible = false;
			Pnl4.Visible = false;
			
			Tc2.Value = "BEST Tours & Travels is a one stop shop for those looking for the best tour and travel services around the country.";
			Tc2.Value += "\n\nIn Travel trade since 1984, the company holds recognition from Department of Tourism & Government of India.";
			Tc2.Value += "\n\nWhether it is for business purposes or for casual outing, the company provides complete travel services.";
		


		}

		private void LinkButton9_Click(object sender, System.EventArgs e)
		{
			Pnl3.Visible = false;
			Pnl5.Visible = true;
			Pnl4.Visible = false;
			
			Tc3.Value = "\nThe Home Page has 3 features.\n";
			Tc3.Value += "\n 1. Viewing Vehicle Details.\n";
			Tc3.Value += "\n 2. Viewing Tourist Location Details.\n";
			Tc3.Value += "\n 3. Registering for the Vehicles.\n";
			Tc3.Value += "\n Click on Register Button to view the Form.";
			Tc3.Value += "\n\nYou can see 3 plans and choose the best one.";

		}

		private void LinkButton4_Click(object sender, System.EventArgs e)
		{
			Pnl3.Visible = false;
			Pnl5.Visible = true;
			Pnl4.Visible = false;
			
			Tc3.Value = "\nThe Home Page has 3 features.\n";
			Tc3.Value += "\n 1. Viewing Vehicle Details.\n";
			Tc3.Value += "\n 2. Viewing Tourist Location Details.\n";
			Tc3.Value += "\n 3. Registering for the Vehicles.\n";
			Tc3.Value += "\n Click on Register Button to view the Form.";
			Tc3.Value += "\n\nYou can see 3 plans and choose the best one.";

		}

		private void LinkButton3_Click(object sender, System.EventArgs e)
		{
			Pnl3.Visible = false;
			Pnl5.Visible = false;
			Pnl4.Visible = true;
			
			Tc1.Value  = "1.For security reasons, you can select only 4 vehicles at a time.\n";

			Tc1.Value  += "\n2.A Vehicle can be booked for maximum of 7 days.\n";

			Tc1.Value += "\n3.You can select Multiple vehicles for a single trip but only of one particular type.\ni.e. Either Cars or Vans.\n";

			Tc1.Value += "\n4.Number of People travelling MUST BE less than the capacity of the chosen vehicles.";



			
		}

		private void LinkButton7_Click(object sender, System.EventArgs e)
		{
			Pnl3.Visible = false;
			Pnl5.Visible = false;
			Pnl4.Visible = true;

			Tc1.Value  = "1.For security reasons, you can select only 4 vehicles at a time.\n";

			Tc1.Value  += "\n2.A Vehicle can be booked for maximum of 7 days.\n";

			Tc1.Value += "\n3.You can select Multiple vehicles for a single trip but only of one particular type.\ni.e. Either Cars or Vans.\n";

			Tc1.Value += "\n4.Number of People travelling MUST BE less than the capacity of the chosen vehicles.";
		}

		private void LinkButton6_Click(object sender, System.EventArgs e)
		{
			Pnl3.Visible = false;
			Pnl5.Visible = false;
			Pnl4.Visible = true;

			Tc1.Value  = "1.For security reasons, you can select only 4 vehicles at a time.\n";

			Tc1.Value  += "\n2.A Vehicle can be booked for maximum of 7 days.\n";

			Tc1.Value += "\n3.You can select Multiple vehicles for a single trip but only of one particular type.\ni.e. Either Cars or Vans.\n";

			Tc1.Value += "\n4.Number of People travelling MUST BE less than the capacity of the chosen vehicles.";
		}
		public void GetTouristInfo()
		{   
			DataGrid1.Visible=true;
			SqlConnection con = new SqlConnection ("server=.;database=BestTravels;uid=sa;pwd=sa");
			string query = "select * from BST_TVL_DESTINATION_TB";
			SqlCommand com = new SqlCommand (query,con);
			SqlDataAdapter Adapter = new SqlDataAdapter (com);
			DataSet Ds = new DataSet ();
			Adapter.Fill(Ds,"BST_TVL_DESTINATION_TB");
			DataGrid1.DataSource = Ds;
			DataGrid1.DataBind ();
			Lbl5.Text = " Places to Visit...";
			Image1.Visible = false;
			dtgVehicle.Visible=false;
	
		}
		private void TouristImgButton_Click(object sender, System.Web.UI.ImageClickEventArgs e)
		{
			GetTouristInfo();
			
		}
		public void GetVehicleInfo()
		{
			dtgVehicle.Visible=true;
			SqlConnection con = new SqlConnection ("server=.;database=BestTravels;uid=sa;pwd=sa");
			string query = "select * from BST_TVL_VEHICLEINFO_TB";
			SqlCommand com = new SqlCommand (query,con);
			SqlDataAdapter Adapter = new SqlDataAdapter (com);
			DataSet Ds = new DataSet ();
			Adapter.Fill(Ds,"BST_TVL_VEHICLEINFO_TB");
			dtgVehicle.DataSource = Ds;
			dtgVehicle.DataBind ();
			Lbl5.Text = "Vehicle Information...";
			Image1.Visible = false;
			DataGrid1.Visible=false;

		}

		private void VehicleImgButton_Click(object sender, System.Web.UI.ImageClickEventArgs e)
		{
			GetVehicleInfo();
		}

		private void VehicleDetailsButton_Click(object sender, System.EventArgs e)
		{
			GetVehicleInfo();

		}

		private void TouristPlacesButton_Click(object sender, System.EventArgs e)
		{
			GetTouristInfo();
		}

		private void RegisterButton_Click(object sender, System.EventArgs e)
		{
			Server.Transfer("WebForm2.aspx");
		}

		private void TourPlansButton_Click(object sender, System.EventArgs e)
		{
		
		}

		private void Text1_ServerChange(object sender, System.EventArgs e)
		{
			
		}

		private void Tc1_ServerChange(object sender, System.EventArgs e)
		{
		
		}

		private void DropDownList1_SelectedIndexChanged(object sender, System.EventArgs e)
		{
		
		}

		

		

		
		

		

	}
}
