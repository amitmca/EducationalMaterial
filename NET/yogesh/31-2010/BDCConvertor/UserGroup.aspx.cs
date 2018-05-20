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

public partial class UserGroup : System.Web.UI.Page
{
    Connection conn = new Connection();
    DataSet ds = new DataSet();

    protected void Page_Load(object sender, EventArgs e)
    {
        if (!IsPostBack)
        {
            btnAssGroup.Enabled = false;
            lblMsg.Visible = false;
            Users();
            FillGroup();
        }
    }

    public void FillGroup()
    {
        drdnGroup.Items.Clear();
        drdnGroup.Items.Add("Select");
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

    public void Users()
    {
        drdnUserName.Items.Clear();
        drdnUserName.Items.Add("Select");
        string cmdstr = "Select UserName From UserMaster";
        ds = conn.getDataset(cmdstr);
        if (ds.Tables[0].Rows.Count > 0)
        {
            for (int i = 0; i < ds.Tables[0].Rows.Count; i++)
            {
                drdnUserName.Items.Add(ds.Tables[0].Rows[i][0].ToString());
            }
        }
    }

    protected void btnAssPermission_Click(object sender, EventArgs e)
    {
        lblMsg.Visible = false;
        string selstr = "Select GroupId From GroupMaster Where GroupName='" + drdnGroup.Text + "'";
        ds = conn.getDataset(selstr);

        conn.openconn();
        string updtstr = "Update [UserMaster] Set [GroupId]=" + Convert.ToInt32(ds.Tables[0].Rows[0][0]) + " Where UserName='" + drdnUserName.Text + "'";
        conn.executequery(updtstr);
        conn.closeconn();
        lblMsg.Visible = true;
        lblMsg.Text = "Group Undated Successfully";
    }

    protected void drdnGroupName_SelectedIndexChanged(object sender, EventArgs e)
    {
        lblMsg.Visible = false;
        if (drdnUserName.SelectedIndex == 0)
        {
            drdnGroup.SelectedIndex = 0;
        }
        else
        {
            string cmdstr = "Select GroupId From UserMaster Where UserName = '" + drdnUserName.Text + "'";
            ds = conn.getDataset(cmdstr);

            string selstr = "Select GroupName From GroupMaster Where GroupId=" + Convert.ToInt32(ds.Tables[0].Rows[0][0]) + "";
            ds = conn.getDataset(selstr);

            drdnGroup.SelectedValue = ds.Tables[0].Rows[0][0].ToString();
        }

        if (drdnGroup.SelectedIndex == 0 || drdnUserName.SelectedIndex == 0)
        {
            btnAssGroup.Enabled = false;
        }
        else
        {
            btnAssGroup.Enabled = true;
        }
    }

    protected void drdnGroup_SelectedIndexChanged(object sender, EventArgs e)
    {
        lblMsg.Visible = false;
        if (drdnGroup.SelectedIndex == 0 || drdnUserName.SelectedIndex == 0)
        {
            btnAssGroup.Enabled = false;
        }
        else
        {
            btnAssGroup.Enabled = true;
        }
    }
}
