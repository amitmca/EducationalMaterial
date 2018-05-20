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

public partial class GroupPermission : System.Web.UI.Page
{
    Connection conn = new Connection();
    DataSet ds = new DataSet();
    static int cntChk = 0;

    protected void Page_Load(object sender, EventArgs e)
    {
        if (!IsPostBack)
        {
            lblMsg.Visible = false;
            drdnGroupName.Items.Add("Select");
            FillGroup();
            Permissions();
            drdnGroupName.SelectedIndex = 0;
            btnAssPermission.Enabled = false;
            btnDelete.Enabled = false;
        }
    }

    public void FillGroup()
    {
        string cmdstr = "Select GroupName From GroupMaster";
        ds = conn.getDataset(cmdstr);
        if (ds.Tables[0].Rows.Count > 0)
        {
            for (int i = 0; i < ds.Tables[0].Rows.Count; i++)
            {
                drdnGroupName.Items.Add(ds.Tables[0].Rows[i][0].ToString());
                drdnGroupName.SelectedIndex = 0;
            }
        }
    }

    public void Permissions()
    {
        string cmdstr = "Select PermissionName From PermissionMaster";
        ds = conn.getDataset(cmdstr);
        if (ds.Tables[0].Rows.Count > 0)
        {
            for (int i = 0; i < ds.Tables[0].Rows.Count; i++)
            {
                CheckBoxList1.Items.Add(ds.Tables[0].Rows[i][0].ToString());
            }
        }
    }

    protected void btnCreateUser_Click(object sender, EventArgs e)
    {
    }

    protected void btnAssPermission_Click(object sender, EventArgs e)
    {
        lblMsg.Visible = false;
        conn.openconn();
        string selstr = "Select GroupId From GroupMaster where GroupName='" + drdnGroupName.Text + "'";
        ds = conn.getDataset(selstr);
        string grpid = ds.Tables[0].Rows[0][0].ToString();

        string delstr = "Delete * From GroupPermission Where GroupId=" + grpid.ToString() + "";
        conn.executequery(delstr);

        for (int i = 0; i < CheckBoxList1.Items.Count; i++)
        {
            if (CheckBoxList1.Items[i].Selected == true)
            {
                string permsn = CheckBoxList1.Items[i].ToString();

                string cmdstr = "Select GroupId From GroupMaster where GroupName='" + CheckBoxList1.Items[i].ToString() + "'";
                ds = conn.getDataset(cmdstr);

                string cmdstr1 = "Insert Into [GroupPermission] Values('" + grpid.ToString() + "','" + ds.Tables[0].Rows[0][0].ToString() + "')";
                conn.executequery(cmdstr1);

                //drdnGroupName.Items.Add("Select");
                //FillGroup();
                //Permissions();

                lblMsg.Visible = true;
                lblMsg.Text = "Permission granted successfully.";
            }
        }

        for (int i = 0; i < CheckBoxList1.Items.Count; i++)
        {
            CheckBoxList1.Items[i].Selected = false;
        }

        drdnGroupName.SelectedIndex = 0;
        btnAssPermission.Enabled = false;
        conn.closeconn();
    }

    protected void drdnGroupName_SelectedIndexChanged(object sender, EventArgs e)
    {
        lblMsg.Visible = false;
        btnDelete.Enabled = false;
        string chkstr = "Select PermissionName From PermissionMaster";
        ds = conn.getDataset(chkstr);
        if (ds.Tables[0].Rows.Count > 0)
        {
            for (int i = 0; i < ds.Tables[0].Rows.Count; i++)
            {
                CheckBoxList1.Items[i].Selected = false;
            }
        }

        if (drdnGroupName.SelectedIndex != 0)
        {
            btnDelete.Enabled = true;
            if (drdnGroupName.Text == "Admin" || drdnGroupName.Text == "Import" || drdnGroupName.Text == "User")
            {
                btnDelete.Enabled = false;
            }
            string cmdstr = "Select PermissionId From PermissionMaster";
            DataSet dsPrmsn = conn.getDataset(cmdstr);

            string selstr = "Select GroupId From GroupMaster where GroupName='" + drdnGroupName.Text + "'";
            ds = conn.getDataset(selstr);
            string grpid = ds.Tables[0].Rows[0][0].ToString();

            string delstr = "Select PermissionId From GroupPermission Where GroupId=" + grpid.ToString() + "";
            ds = conn.getDataset(delstr);

            for (int i = 0; i < dsPrmsn.Tables[0].Rows.Count; i++)
            {
                for (int j = 0; j < ds.Tables[0].Rows.Count; j++)
                {
                    if (dsPrmsn.Tables[0].Rows[i][0].ToString() == ds.Tables[0].Rows[j][0].ToString())
                    {
                        CheckBoxList1.Items[i].Selected = true;
                        cntChk = cntChk + 1;
                    }
                }
            }
        }



        if (drdnGroupName.SelectedIndex == 0 || cntChk == 0)
        {
            btnAssPermission.Enabled = false;
            //btnDelete.Enabled = false;

            string chkstr1 = "Select PermissionName From PermissionMaster";
            ds = conn.getDataset(chkstr1);
            if (ds.Tables[0].Rows.Count > 0)
            {
                for (int i = 0; i < ds.Tables[0].Rows.Count; i++)
                {
                    CheckBoxList1.Items[i].Selected = false;
                }
            }
        }
        else
        {
            btnAssPermission.Enabled = true;
        }
    }
    protected void CheckBoxList1_SelectedIndexChanged(object sender, EventArgs e)
    {
        //string delstr = "Delete * From GroupPermission Where GroupId=" + grpid.ToString() + "";
        //conn.executequery(delstr);
        lblMsg.Visible = false;
        cntChk = 0;
        for (int i = 0; i < CheckBoxList1.Items.Count; i++)
        {
            if (CheckBoxList1.Items[i].Selected == true)
            {
                cntChk = cntChk + 1;
            }
        }

        if (drdnGroupName.SelectedIndex == 0 || cntChk == 0)
        {
            btnAssPermission.Enabled = false;
        }
        else
        {
            btnAssPermission.Enabled = true;
        }
    }
    protected void btnDelete_Click(object sender, EventArgs e)
    {
        string str = "Delete from groupmaster where groupname='" + drdnGroupName.Text + "'";
        conn.openconn();
        conn.executequery(str);
        conn.closeconn();

        lblMsg.Visible = false;
        drdnGroupName.Items.Clear();
        drdnGroupName.Items.Add("Select");
        FillGroup();

        for (int i = 0; i < CheckBoxList1.Items.Count; i++)
        {
            CheckBoxList1.Items[i].Selected = false;
        }
        //Permissions();
        drdnGroupName.SelectedIndex = 0;
        btnAssPermission.Enabled = false;
        btnDelete.Enabled = false;
    }
}
