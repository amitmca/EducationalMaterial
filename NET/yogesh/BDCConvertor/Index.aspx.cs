using System;
using System.Data;
using System.Configuration;
using System.Collections;
using System.Web;
using System.Web.Security;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Web.UI.WebControls.WebParts;
using System.Web.UI.HtmlControls;

public partial class HomePageH : System.Web.UI.Page
{
    Connection cnn = new Connection();
    DataSet ds = new DataSet();

    protected void Page_Load(object sender, EventArgs e)
    {        
        try
        {
            if (!IsPostBack)
            {
                lblMsg.Visible = false;
                Connection.username = "";
            }
            txtUsrNm.Focus();
        }
        catch (Exception exc)
        {
            throw exc;
        }

    }
    protected void Button1_Click(object sender, EventArgs e)
    {
        //Response.Redirect("HomePageBCD.aspx");
        try
        {
            Connection.username = txtUsrNm.Text;
            lblMsg.Text = "";
            cnn.openconn();
            int confirm = 0, check = 0;
            string cmdstr = "Select * from UserMaster";
            ds = cnn.getDataset(cmdstr);

            for (int i = 0; i < ds.Tables[0].Rows.Count; i++)
            {
                //drdnSeason.Items.Add(Convert.ToString(ds.Tables[0].Rows[i][0]));
                if (txtUsrNm.Text == Convert.ToString(ds.Tables[0].Rows[i][0]))
                {
                    if (txtPswd.Text == Convert.ToString(ds.Tables[0].Rows[i][1]))
                    {
                        
                        confirm = 1;

                        string group = "Select GroupId From UserMaster Where UserName='" + txtUsrNm.Text + "'";
                        DataSet dsuser = cnn.getDataset(group);

                        for (int j = 0; j < dsuser.Tables[0].Rows.Count; j++)
                        {
                            if (dsuser.Tables[0].Rows[j][0].ToString() == "1")
                            {
                                Session["luser"] = "Admin";
                                check = 1;
                                Connection.username = txtUsrNm.Text;
                            }
                        }

                        // Select user's permissions from database
                        string prmsn = "Select PermissionId From GroupPermission Where GroupId=" + dsuser.Tables[0].Rows[0][0].ToString() + "";
                        dsuser = cnn.getDataset(prmsn);

                        for (int j = 0; j < dsuser.Tables[0].Rows.Count; j++)
                        {
                            if (dsuser.Tables[0].Rows[j][0].ToString() == "1")
                            {
                                Session["luser"] = "Admin";
                                check = 1;
                                Connection.username = txtUsrNm.Text;
                            }
                        }
                        if (check == 1)
                        {
                            Response.Redirect("HomePageBCD.aspx");
                        }
                        if (check == 0)
                        {
                            Response.Redirect("Convert.aspx");
                        }
                    }
                }                
            }
            if (confirm == 0)
            {
                lblMsg.Visible = true;
                lblMsg.Text = "Username and password do not match.";
                txtPswd.Focus();
            }
            cnn.closeconn();
        }
        catch (Exception exc)
        {
            lblMsg.Text = exc.Message; 
            throw exc;
           
        }
    }
}
