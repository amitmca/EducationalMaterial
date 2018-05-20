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

public partial class CreateUser : System.Web.UI.Page
{
    Connection conn = new Connection();
    DataSet ds = new DataSet();

    protected void Page_Load(object sender, EventArgs e)
    {
        try
        {
            if (!IsPostBack)
            {
                lblMsg.Visible = false;
                drdnGroup.Items.Add("Select");
                FillGroup();
                btnCreateUser.Enabled = false;
                lblError.Text = "";
            }
        }
        catch (Exception exc)
        {
            throw exc;
        }
    }

    protected void CreateUserWizard1_CreatedUser(object sender, EventArgs e)
    {

    }

    public void FillGroup()
    {
        string cmdstr = "Select GroupName From GroupMaster";
        ds = conn.getDataset(cmdstr);
        if (ds.Tables[0].Rows.Count > 0)
        {
            for (int i = 0; i < ds.Tables[0].Rows.Count; i++)
            {
                drdnGroup.Items.Add(ds.Tables[0].Rows[i][0].ToString());
                drdnGroup.SelectedIndex = 0;
            }
        }
    }

    //public void Permissions()
    //{
    //    string cmdstr = "Select PermissionName From PermissionMaster";
    //    ds = conn.getDataset(cmdstr);
    //    if (ds.Tables[0].Rows.Count > 0)
    //    {
    //        for (int i = 0; i < ds.Tables[0].Rows.Count; i++)
    //        {
    //            CheckBoxList1.Items.Add(ds.Tables[0].Rows[i][0].ToString());
    //            //drdnGroup.Items.Add(ds.Tables[0].Rows[i][0].ToString());
    //            //drdnGroup.SelectedIndex = 0;
    //        }
    //    }
    //}

    protected void drdnGroup_SelectedIndexChanged(object sender, EventArgs e)
    {
        lblMsg.Visible = false;

        if (drdnGroup.SelectedIndex == 0)
        {
            btnCreateUser.Enabled = false;
        }
        else
            btnCreateUser.Enabled = true;
    }

    protected void btnCreateUser_Click(object sender, EventArgs e)
    {
        try
        {
            lblMsg.Visible = false;
            int exists = 0;
            lblError.Text = "";
            string selusr = "Select UserName From UserMaster";
            ds = conn.getDataset(selusr);

            for (int i = 0; i < ds.Tables[0].Rows.Count; i++)
            {
                string usrnm = ds.Tables[0].Rows[i][0].ToString();
                if (txtUserName.Text.ToLower() == usrnm.ToLower())
                {
                    lblError.Text = "User Name already exists. Please enter different User Name.";
                    exists = 1;
                }
                //else if (txtPassword.Text != txtConfirmPass.Text)
                //{
                //    lblError.Text = "Passwords does not match.";
                //    exists = 1;
                //}
            }

            if (exists == 0)
            {
                if (txtPassword.Text != txtConfirmPass.Text)
                {
                    lblError.Text = "Passwords do not match.";
                }
                else
                {
                    string selstr = "Select GroupId From GroupMaster where GroupName='" + drdnGroup.SelectedItem + "'";
                    ds = conn.getDataset(selstr);

                    conn.openconn();
                    string cmdstr = "insert into [UserMaster] values('" + txtUserName.Text + "','" + txtPassword.Text + "','" + ds.Tables[0].Rows[0][0].ToString() + "')";
                    conn.executequery(cmdstr);

                    if (drdnGroup.Text == "Admin")
                    {
                        string cmdstr1 = "insert into [UserPermission] values('" + txtUserName.Text + "','1')";
                        conn.executequery(cmdstr1);
                    }
                    else if (drdnGroup.Text == "Import")
                    {
                        string cmdstr1 = "insert into [UserPermission] values('" + txtUserName.Text + "','2')";
                        conn.executequery(cmdstr1);
                    }
                    else
                    {
                        string cmdstr1 = "insert into [UserPermission] values('" + txtUserName.Text + "','3')";
                        conn.executequery(cmdstr1);
                    }

                    drdnGroup.SelectedIndex = 0;
                    //FillGroup();
                    btnCreateUser.Enabled = false;
                    txtUserName.Text = "";

                    lblMsg.Visible = true;
                    lblMsg.Text = "User Created successfully.";
                }
            }
        }
        catch (Exception exc)
        {
            throw exc;
        }
    }
}
