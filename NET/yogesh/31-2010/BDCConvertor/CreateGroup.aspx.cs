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

public partial class CreateGroup : System.Web.UI.Page
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
                string cmdstr = "Select max(GroupId) From GroupMaster";
                ds = conn.getDataset(cmdstr);

                int grid = Convert.ToInt32(ds.Tables[0].Rows[0][0].ToString()) + 1;
                txtGroupId.Text = grid.ToString();
            }
        }
        catch (Exception exc)
        {
            throw exc;
        }
    }
    protected void btnCreateGroup_Click(object sender, EventArgs e)
    {
        try
        {
            int exists = 0;
            lblError.Text = "";
            string selgrp = "Select GroupName From GroupMaster";
            ds = conn.getDataset(selgrp);

            for (int i = 0; i < ds.Tables[0].Rows.Count; i++)
            {
                string usrnm = ds.Tables[0].Rows[i][0].ToString();
                if (txtGroupName.Text == usrnm)
                {
                    exists = 1;
                    lblError.Text = "Group Name already exists. " + "\n" + "Please enter different Group Name.";
                }
            }
            if (exists == 0)
            {
                conn.openconn();
                string cmdstr = "insert into [GroupMaster] values('" + txtGroupId.Text + "','" + txtGroupName.Text + "')";
                conn.executequery(cmdstr);
                string insrtstr = "insert into [GroupPermission] values('" + txtGroupId.Text + "','3')";
                conn.executequery(insrtstr);
                conn.closeconn();

                //txtGroupId.Text = "";
                txtGroupName.Text = "";
                string cmdstr1 = "Select max(GroupId) From GroupMaster";
                ds = conn.getDataset(cmdstr1);

                int grid = Convert.ToInt32(ds.Tables[0].Rows[0][0].ToString()) + 1;
                txtGroupId.Text = grid.ToString();

                lblMsg.Visible = true;
                lblMsg.Text = "Group Created successfully.";
            }

        }
        catch (Exception exc)
        {
            throw exc;
        }
    }
}
