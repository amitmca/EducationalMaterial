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

public partial class UserPermission : System.Web.UI.Page
{
    Connection conn = new Connection();
    DataSet ds = new DataSet();
    static int cntChk = 0;
    static string usernm = "";
    static string adminUser = "admin";

    protected void Page_Load(object sender, EventArgs e)
    {
        try
        {
            if (!IsPostBack)
            {
                lblMsg.Visible = false;
                drdnUserName.Items.Add("Select");
                Users();
                Permissions();
                drdnUserName.SelectedIndex = 0;
                btnAssPermission.Enabled = false;
                btnDelete.Enabled = false;
            }
        }
        catch (Exception exc)
        {
            throw exc;
        }
    }
    protected void txtUserName_TextChanged(object sender, EventArgs e)
    {

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

    public void Users()
    {
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

    protected void btnCreateUser_Click(object sender, EventArgs e)
    {
        try
        {
            lblMsg.Visible = false;
            conn.openconn();
            string delstr = "Delete * From UserPermission Where UserName='" + drdnUserName.Text + "'";
            conn.executequery(delstr);

            for (int i = 0; i < CheckBoxList1.Items.Count; i++)
            {
                if (CheckBoxList1.Items[i].Selected == true)
                {
                    string permsn = CheckBoxList1.Items[i].ToString();

                    string cmdstr = "Select PermissionId From PermissionMaster where PermissionName='" + CheckBoxList1.Items[i].ToString() + "'";
                    ds = conn.getDataset(cmdstr);

                    string cmdstr1 = "Insert Into [UserPermission] Values('" + drdnUserName.Text + "','" + ds.Tables[0].Rows[0][0].ToString() + "')";
                    conn.executequery(cmdstr1);
                                        
                    lblMsg.Visible = true;
                    lblMsg.Text = "Permissions Assigned Successfully.";
                }
            }

            for (int i = 0; i < CheckBoxList1.Items.Count; i++)
            {
                CheckBoxList1.Items[i].Selected = false;
            }

            drdnUserName.SelectedIndex = 0;
            btnAssPermission.Enabled = false;
            conn.closeconn();
        }
        catch (Exception exc)
        {
            throw exc;
        }
    }

    protected void drdnUserName_SelectedIndexChanged(object sender, EventArgs e)
    {
        try
        {
            CheckBoxList1.Enabled = true;
            lblMsg.Visible = false;
            string chkstr = "Select PermissionName From PermissionMaster";
            ds = conn.getDataset(chkstr);
            if (ds.Tables[0].Rows.Count > 0)
            {
                for (int i = 0; i < ds.Tables[0].Rows.Count; i++)
                {
                    CheckBoxList1.Items[i].Selected = false;
                }
            }

            if (drdnUserName.SelectedIndex != 0)
            {
                usernm = drdnUserName.Text;
                string cmdstr = "Select PermissionId From PermissionMaster";
                DataSet dsPrmsn = conn.getDataset(cmdstr);

                string delstr = "Select PermissionId From UserPermission Where UserName='" + drdnUserName.Text + "'";
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

            if (drdnUserName.SelectedIndex == 0 || cntChk == 0)
            {
                usernm = "";
                btnAssPermission.Enabled = false;
                btnDelete.Enabled = false;

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
                if (drdnUserName.Text == adminUser)
                {
                    btnDelete.Enabled = false;
                    CheckBoxList1.Enabled = false;
                }
                else
                {
                    CheckBoxList1.Enabled = true;
                    btnAssPermission.Enabled = true;
                    btnDelete.Enabled = true;
                }
            }
        }
        catch (Exception exc)
        {
            throw exc;
        }
    }

    protected void CheckBoxList1_SelectedIndexChanged(object sender, EventArgs e)
    {
        try
        {
            lblMsg.Visible = false;
            cntChk = 0;
            for (int i = 0; i < CheckBoxList1.Items.Count; i++)
            {
                if (CheckBoxList1.Items[i].Selected == true)
                {
                    cntChk = cntChk + 1;
                }
            }

            if (drdnUserName.SelectedIndex == 0 || cntChk == 0)
            {
                btnAssPermission.Enabled = false;
            }
            else
            {
                btnAssPermission.Enabled = true;
            }
        }
        catch (Exception exc)
        {
            throw exc;
        }
    }
    protected void btnDelete_Click(object sender, EventArgs e)
    {
        conn.openconn();
        string cmdstr = "Delete * From UserMaster Where UserName='" + drdnUserName.Text + "'";
        conn.executequery(cmdstr);
        conn.closeconn();
        lblMsg.Text = "User Deleted Successfully.";

        btnAssPermission.Enabled = false;
        btnDelete.Enabled = false;

        for (int i = 0; i < CheckBoxList1.Items.Count; i++)
        {
            CheckBoxList1.Items[i].Selected = false;
        }

        drdnUserName.Items.Clear();
        drdnUserName.Items.Add("Select");
        Users();
    }
}
