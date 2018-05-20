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
using System.IO;
//using System.Windows.Forms;

public partial class Login : System.Web.UI.Page
{
    Connection cs = new Connection();
    DataSet ds = new DataSet();
    string tcode = "";
    CheckBox chbx = new CheckBox();
    int size, index, col2, cntId = 0, bdcFlag = 0;
    string description, datatype, col1, col3, col4, col5;
    //static int[] permissions = new int[100];
    static string[] pname = new string[100];
    static int[] seqno = new int[100];
    static string BDCName = "", BDCDesc = "";
   

    protected void Page_Load(object sender, EventArgs e)
    {
        // btnGenerate.Attributes.Add("onclick", "return validate()");
        if (!IsPostBack)
        {
            lblMsg.Visible = false;
            lblGridError.Visible = false;
            btnLoadD.Enabled = false;
            btnDelete.Enabled = false;
            Panel1.Enabled = false;

            if (Connection.username == "")
            {
                Response.Redirect("Index.aspx");
            }
            else
            {
                drdnBDCName.Items.Clear();
                drdnBDCName.Items.Add("-Select-");

                string prmsn1 = "Select PermissionId From UserPermission Where UserName='" + Connection.username + "'";
                DataSet dsprmsn1 = cs.getDataset(prmsn1);

                for (int l = 0; l < dsprmsn1.Tables[0].Rows.Count; l++)
                {
                    if (Convert.ToInt32(dsprmsn1.Tables[0].Rows[l][0]) == 2)
                    {
                        Panel1.Enabled = true;
                    }
                    if (Convert.ToInt32(dsprmsn1.Tables[0].Rows[l][0]) == 1)
                    {
                        Panel1.Enabled = true;
                        //btnDelete.Enabled = true;
                    }
                }

                if (Convert.ToInt32(dsprmsn1.Tables[0].Rows[0][0]) == 1)
                {
                    Panel1.Enabled = true;
                    
                    //LoadBDC();
                    drdnBDCName.Items.Clear();
                    drdnBDCName.Items.Add("Select");
                    string cmdstr = "Select BDCName from BDCMaster";
                    ds = cs.getDataset(cmdstr);

                    for (int i = 0; i < ds.Tables[0].Rows.Count; i++)
                    {
                        drdnBDCName.Items.Add(ds.Tables[0].Rows[i][0].ToString());
                    }
                }

                else
                {
                    //int cntId = dsprmsn1.Tables[0].Rows.Count;

                    for (int i = 0; i < dsprmsn1.Tables[0].Rows.Count; i++)
                    {
                        string prmsnm2 = "Select PermissionName From PermissionMaster Where PermissionId=" + Convert.ToInt32(dsprmsn1.Tables[0].Rows[i][0]).ToString() + "";
                        DataSet dsprmsnm2 = cs.getDataset(prmsnm2);
                        pname[i] = dsprmsnm2.Tables[0].Rows[0][0].ToString();
                        cntId = cntId + 1;
                    }

                    string prmsn3 = "Select GroupId From UserMaster Where UserName='" + Connection.username + "'";
                    DataSet dsprmsn3 = cs.getDataset(prmsn3);
                    int gid = Convert.ToInt32(dsprmsn3.Tables[0].Rows[0][0]);
                    //for (int i = 0; i < dsprmsn1.Tables[0].Rows.Count; i++)
                    //{
                    if (gid == 2)
                    {
                        Panel1.Enabled = true;
                    }
                    //}

                    for (int i = 0; i < dsprmsn3.Tables[0].Rows.Count; i++)
                    {
                        string prmsnm2 = "Select PermissionId From GroupPermission Where GroupId=" + dsprmsn3.Tables[0].Rows[0][0].ToString() + "";
                        DataSet dsprmsnm2 = cs.getDataset(prmsnm2);

                        for (int j = 1; j < dsprmsnm2.Tables[0].Rows.Count; j++)
                        {
                            string prmsnm12 = "Select PermissionName From PermissionMaster Where PermissionId=" + Convert.ToInt32(dsprmsnm2.Tables[0].Rows[i][0]).ToString() + "";
                            DataSet dsprmsnm12 = cs.getDataset(prmsnm12);
                            pname[cntId + j] = dsprmsnm12.Tables[0].Rows[0][0].ToString();
                            cntId = cntId + 1;
                        }

                        //for (int j = 0; j < pname.Length; j++)
                        //{
                        //    if (dsprmsn3.Tables[0].Rows[0][0].ToString() == pname[j])
                        //    { }
                        //    else
                        //    {
                        //        pname[i] = dsprmsnm2.Tables[0].Rows[0][0].ToString();
                        //    }
                        //}
                    }
                    //cntId = pname.Length;

                    for (int i = 1; i < dsprmsn3.Tables[0].Rows.Count; i++)
                    {
                        string prmsnm4 = "Select PermissionName From PermissionMaster Where PermissionId=" + Convert.ToInt32(dsprmsn3.Tables[0].Rows[i][0]).ToString() + "";
                        DataSet dsprmsnm4 = cs.getDataset(prmsnm4);
                        pname[cntId + i] = dsprmsnm4.Tables[0].Rows[0][0].ToString();
                        cntId = cntId + 1;
                    }

                    LoadBDC();
                    //string str = "Select BDCName from BDCMaster";
                    //ds = cs.getDataset(str);

                    //for (int i = 0; i < ds.Tables[0].Rows.Count; i++)
                    //{
                    //    for (int j = 0; j < cntId; j++)
                    //    {
                    //        if (ds.Tables[0].Rows[i][0].ToString() == pname[j].ToString())
                    //        {
                    //            drdnBDCName.Items.Add(ds.Tables[0].Rows[i][0].ToString());
                    //        }
                    //    }
                    //}
                }
            }
        }
    }

    public void LoadBDC()
    {
        drdnBDCName.Items.Clear();
        drdnBDCName.Items.Add("Select");
        string str = "Select BDCName from BDCMaster";
        ds = cs.getDataset(str);

        for (int i = 0; i < ds.Tables[0].Rows.Count; i++)
        {
            for (int j = 0; j < cntId; j++)
            {
                if (ds.Tables[0].Rows[i][0].ToString() == pname[j].ToString())
                {
                    drdnBDCName.Items.Add(ds.Tables[0].Rows[i][0].ToString());
                }
            }
        } 
    }

    protected void Button1_Click(object sender, EventArgs e)
    {
        BDCDesc = txtDescription.Text;
        Connection.modifyFlag = 0;
        GridView1.Visible = true;
        GridView1.Enabled = true;
        
        lblMsg.Visible = false;
        lblGridError.Visible = false;
        string cmdstr = "Select BDCName From BDCMaster";
        ds = cs.getDataset(cmdstr);
        if (ds.Tables[0].Rows.Count > 0)
        {
            if (ds.Tables[0].Rows[0][0].ToString() != "")
            {
                for (int i = 0; i < ds.Tables[0].Rows.Count; i++)
                {
                    if (ds.Tables[0].Rows[i][0].ToString().ToLower() == txtName.Text.ToLower())
                    {
                        bdcFlag = 1;
                        lblMsg.Visible = true;
                        lblMsg.Text = "BDC Name already exists. Please enter different BDC Name.";                        
                    }
                }
            }
        }

        if (bdcFlag == 0)
        {
            Connection.loadflag = 1;
            string filename = Request.PhysicalApplicationPath + "File/"+File1.PostedFile.FileName ;
           File1.PostedFile.SaveAs(filename);
            
            //HttpPostedFile filenme = File1.PostedFile; // Files[0].FileName;
            ds = FillGrid(filename ); 
            GridView1.DataSource = ds.Tables[0];
            GridView1.DataBind();
            for (int i = 0; i < GridView1.Rows.Count; i++)
            {
                if (GridView1.Rows[i].Cells[3].Text.Trim() == "" || GridView1.Rows[i].Cells[3].Text.Contains("BDC_") || GridView1.Rows[i].Cells[3].Text.Trim() == " " || GridView1.Rows[i].Cells[4].Text.Trim() == "X")
                {
                    GridView1.Rows[i].Visible = false;
                }
                for (int j = 0; j < i; j++)
                {
                    if (GridView1.Rows[i].Cells[3].Text.Trim() == GridView1.Rows[j].Cells[3].Text.Trim())// || GridView1.Rows[i].Cells[4].Text.Trim() == GridView1.Rows[j].Cells[4].Text.Trim())
                    {
                        GridView1.Rows[i].Visible = false;
                    }
                }
            }

            btnGenerate.Visible = true;
            btnModifyBDC.Visible = false;

            //insertBDC();
            Connection.bdcname = txtName.Text;
            string str = "Select BDCName from BDCMaster";
            ds = cs.getDataset(str);
            if (ds.Tables[0].Rows.Count > 0)
            {
                drdnBDCName.Items.Clear();
                drdnBDCName.Items.Add("-Select-");
                for (int i = 0; i < ds.Tables[0].Rows.Count; i++)
                {
                    drdnBDCName.Items.Add(ds.Tables[0].Rows[i][0].ToString());
                }
            }
        }        
    }

    public DataSet FillGrid(string filename)
    {
        StreamReader s = new StreamReader(filename);
        string AllData = s.ReadToEnd();
        string[] rows = AllData.Split("\n".ToCharArray());

        DataSet result = new DataSet();

        result.Tables.Add();

        result.Tables[0].Columns.Add("ProgramName");
        result.Tables[0].Columns.Add("ScreenNo");
        result.Tables[0].Columns.Add("FieldType");
        result.Tables[0].Columns.Add("FieldName");
        result.Tables[0].Columns.Add("FieldValue");

        string[] items = new string[5];
        tcode = rows[0].Substring(48, 133);
        for (int i = 1; i < rows.Length - 1; i++)
        {
            {
                items[0] = rows[i].Substring(0, 40);
                items[1] = rows[i].Substring(41, 5);
                items[2] = rows[i].Substring(46, 1);
                items[3] = rows[i].Substring(48, 133);
                items[4] = rows[i].Substring(181);
                result.Tables[0].Rows.Add(items);
            }
        }
        return result;
    }
    protected void btnName_Click(object sender, EventArgs e)
    {
        int sno;
        string str = "select max(bdcCode) from BDCMaster";
        DataSet ds = cs.getDataset(str);
        if (ds.Tables[0].Rows[0][0].ToString() == "")
        {
            sno = 1;
        }
        else
        {
            sno = Convert.ToInt32(ds.Tables[0].Rows[0][0]) + 1;
        }

        try
        {
            cs.openconn();
            string str1 = "insert into BDCMaster values(" + sno + ",'" + txtName.Text + "','" + tcode + "','" + txtHotkey.Text + "','" + txtDescription.Text + "')";
            cs.executequery(str1);
            for (int i = 0; i < GridView1.Rows.Count; i++)
            {
                chbx = ((CheckBox)GridView1.Rows[i].FindControl("CheckBox1"));
                if (((TextBox)GridView1.Rows[i].FindControl("TextBox1")).Text != "")
                {
                    size = Convert.ToInt32(((TextBox)GridView1.Rows[i].FindControl("TextBox1")).Text);
                }
                else
                {
                    size = 0;
                }
                description = ((TextBox)GridView1.Rows[i].FindControl("TextBox2")).Text;
                if (((TextBox)GridView1.Rows[i].FindControl("TextBox3")).Text != "")
                {
                    index = Convert.ToInt32(((TextBox)GridView1.Rows[i].FindControl("TextBox3")).Text);
                }
                else
                {
                    index = 0;
                }
                if (GridView1.Rows[i].Cells[0].Text.Trim() == "&nbsp;")
                {
                    col1 = "";
                }
                else
                {
                    col1 = GridView1.Rows[i].Cells[0].Text.Trim();
                }
                if (GridView1.Rows[i].Cells[1].Text != "")
                {
                    col2 = Convert.ToInt32(GridView1.Rows[i].Cells[1].Text);
                }
                else
                {
                    col2 = 0;
                }

                if (GridView1.Rows[i].Cells[2].Text.Trim() == "&nbsp;")
                {
                    col3 = "";
                }
                else
                {
                    col3 = GridView1.Rows[i].Cells[2].Text.Trim();
                }
                if (GridView1.Rows[i].Cells[3].Text.Trim() == "&nbsp;")
                {
                    col4 = "";
                }
                else
                {
                    col4 = GridView1.Rows[i].Cells[3].Text.Trim();
                }
                if (GridView1.Rows[i].Cells[4].Text.Trim() == "&nbsp;")
                {
                    col5 = "";
                }
                else
                {
                    col5 = GridView1.Rows[i].Cells[4].Text.Trim();
                }

                string str2 = "insert into BDCDetails values(" + sno + "," + (i + 1) + ",'" + col1 + "'," + col2 + ",'" + col3 + "','" + col4 + "','" + col5 + "'," + chbx.Checked + ",'" + description + "'," + size + "," + index + ",'" + datatype + "')";
                cs.executequery(str2);
            }
            cs.closeconn();
        }
        catch (Exception ex)
        {
            throw ex;
        }
    }
   
    protected void btnLoadD_Click(object sender, EventArgs e)
    {
        BDCName = drdnBDCName.Text;
        Connection.bdcname = BDCName;
        Connection.loadflag = 2;
        if (drdnBDCName.SelectedIndex != 0)
        {
            string str2 = "Select * from BDCMaster where BDCName='" + drdnBDCName.Text + "'";
            DataSet ds2 = cs.getDataset(str2);
            if (ds2.Tables[0].Rows.Count != 0)
            {
                txtName.Text = "";
                txtHotkey.Text = "";
                string str = "Select [ProgramName],[ScreenNo],[FieldType],[FieldName],[FieldValue],[ScreenField],[Description],[Size],[FieldSequence],[DataType] from [BDCDetails] where [BDCCode]=" + Convert.ToInt32(ds2.Tables[0].Rows[0][0]) + "";
                ds = cs.getDataset(str);
                GridView1.DataSource = null;
                GridView1.DataSource = ds.Tables[0];
                GridView1.DataBind();

                for (int j = 0; j < GridView1.Rows.Count; j++)
                {
                    ((CheckBox)GridView1.Rows[j].FindControl("CheckBox1")).Checked = Convert.ToBoolean(ds.Tables[0].Rows[j][5]);
                    ((TextBox)GridView1.Rows[j].FindControl("TextBox1")).Text = ds.Tables[0].Rows[j][7].ToString();
                    ((TextBox)GridView1.Rows[j].FindControl("TextBox2")).Text = ds.Tables[0].Rows[j][6].ToString();
                    ((TextBox)GridView1.Rows[j].FindControl("TextBox3")).Text = ds.Tables[0].Rows[j][8].ToString();
                    ((DropDownList)GridView1.Rows[j].FindControl("DropDownList1")).Text = ds.Tables[0].Rows[j][9].ToString();
                }
                for (int i = 0; i < GridView1.Rows.Count; i++)
                {
                    if (GridView1.Rows[i].Cells[3].Text.Trim() == "" || GridView1.Rows[i].Cells[3].Text.Contains("BDC_") || GridView1.Rows[i].Cells[3].Text.Trim() == "&nbsp;" || GridView1.Rows[i].Cells[4].Text.Trim() == "X")
                    {
                        GridView1.Rows[i].Visible = false;
                    }
                    for (int j = 0; j < i; j++)
                    {
                        if (GridView1.Rows[i].Cells[3].Text.Trim() == GridView1.Rows[j].Cells[3].Text.Trim())// && GridView1.Rows[i].Cells[4].Text == GridView1.Rows[j].Cells[4].Text)
                        {
                            GridView1.Rows[i].Visible = false;
                        }
                    }
                }
                GridView1.Enabled = false;
                Connection.bdcname = drdnBDCName.Text;
                btnGenerate.Visible = true;
                btnModifyBDC.Visible = true;
                string str1= "Select BDCName from BDCMaster";
                ds = cs.getDataset(str1);
                if (ds.Tables[0].Rows.Count > 0)
                {
                    drdnBDCName.Items.Clear();
                    drdnBDCName.Items.Add("-Select-");
                    btnLoadD.Enabled = false;
                    for (int i = 0; i < ds.Tables[0].Rows.Count; i++)
                    {
                        drdnBDCName.Items.Add(ds.Tables[0].Rows[i][0].ToString());
                    }
                }
            }
        }
        drdnBDCName.Text = BDCName.ToString();
    }
    public void insertBDC(string bdcname,string tcode,string hotkey)
    {
        int sno, sno1;
        string str = "select max(bdcCode) from BDCMaster";
        DataSet ds = cs.getDataset(str);
        if (ds.Tables[0].Rows[0][0].ToString() == "")
        {
            sno = 1;
        }
        else
        {
            sno = Convert.ToInt32(ds.Tables[0].Rows[0][0]) + 1;
        }

        try
        {
            cs.openconn();
            string str1 = "insert into BDCMaster values(" + sno + ",'" + bdcname + "','" + tcode + "','" + hotkey + "','" + BDCDesc + "')";
            cs.executequery(str1);
            for (int i = 0; i < GridView1.Rows.Count; i++)
            {
                chbx = ((CheckBox)GridView1.Rows[i].FindControl("CheckBox1"));
                if (((TextBox)GridView1.Rows[i].FindControl("TextBox1")).Text != "")
                {
                    size = Convert.ToInt32(((TextBox)GridView1.Rows[i].FindControl("TextBox1")).Text.Trim());
                }
                else
                {
                    size = 0;
                }
                description = ((TextBox)GridView1.Rows[i].FindControl("TextBox2")).Text.Trim();
                if (((TextBox)GridView1.Rows[i].FindControl("TextBox3")).Text != "")
                {
                    index = Convert.ToInt32(((TextBox)GridView1.Rows[i].FindControl("TextBox3")).Text.Trim());
                }
                else
                {
                    index = 0;
                }
                if (((DropDownList)GridView1.Rows[i].FindControl("DropDownList1")).SelectedIndex != 0)
                {
                    datatype = ((DropDownList)GridView1.Rows[i].FindControl("DropDownList1")).Text.Trim();
                }

                if (GridView1.Rows[i].Cells[0].Text.TrimEnd() == "&nbsp;")
                {
                    col1 = "";
                }
                else
                {
                    col1 = GridView1.Rows[i].Cells[0].Text.TrimEnd();
                }
                if (GridView1.Rows[i].Cells[1].Text != "")
                {
                    col2 = Convert.ToInt32(GridView1.Rows[i].Cells[1].Text.Trim());
                }
                else
                {
                    col2 = 0;
                }

                if (GridView1.Rows[i].Cells[2].Text.Trim()== "&nbsp;")
                {
                    col3 = "";
                }
                else
                {
                    col3 = GridView1.Rows[i].Cells[2].Text.Trim();
                }
                if (GridView1.Rows[i].Cells[3].Text.Trim() == "&nbsp;")
                {
                    col4 = "";
                }
                else
                {
                    col4 = GridView1.Rows[i].Cells[3].Text.Trim();
                }
                if (GridView1.Rows[i].Cells[4].Text.Trim() == "&nbsp;")
                {
                    col5 = "";
                }
                else
                {
                    col5 = GridView1.Rows[i].Cells[4].Text.Trim();
                } 

                string str2 = "insert into BDCDetails values(" + sno + "," + (i + 1) + ",'" + col1 + "'," + col2 + ",'" + col3 + "','" + col4 + "','" + col5 + "'," + chbx.Checked + ",'" + description + "'," + size + "," + index + ",'" + datatype + "')";
                cs.executequery(str2);
            }

            if (Connection.modifyFlag != 1)
            {
                string selstr = "select max(PermissionId) from PermissionMaster";
                DataSet ds1 = cs.getDataset(selstr);
                if (ds1.Tables[0].Rows[0][0].ToString() == "")
                {
                    sno1 = 1;
                }
                else
                {
                    sno1 = Convert.ToInt32(ds1.Tables[0].Rows[0][0]) + 1;
                }

                string insrt = "insert into PermissionMaster values(" + sno1 + ",'" + txtName.Text + "')";
                cs.executequery(insrt);
            }
            cs.closeconn();

        }
        catch (Exception ex)
        {
            throw ex;
        }
    }
    protected void CheckBox1_CheckedChanged(object sender, EventArgs e)
    {
        foreach (GridViewRow rr in GridView1.Rows)
        {
            if (((CheckBox)rr.FindControl("CheckBox1")).Checked == true)
            {
                ((CheckBox)rr.FindControl("CheckBox2")).Enabled =true ;
                ((TextBox)rr.FindControl("TextBox1")).Enabled = true;
                ((TextBox)rr.FindControl("TextBox2")).Enabled = true;
                ((TextBox)rr.FindControl("TextBox3")).Enabled = true;
                ((DropDownList)rr.FindControl("DropDownList1")).Enabled = true;
            }
            else if (((CheckBox)rr.FindControl("CheckBox1")).Checked == false)
            {
                ((CheckBox)rr.FindControl("CheckBox2")).Enabled = false;
                ((TextBox)rr.FindControl("TextBox1")).Text = "";
                ((TextBox)rr.FindControl("TextBox2")).Text = "";
                ((TextBox)rr.FindControl("TextBox3")).Text = "";
               
                ((TextBox)rr.FindControl("TextBox1")).Enabled = false;
                ((TextBox)rr.FindControl("TextBox2")).Enabled = false;
                ((TextBox)rr.FindControl("TextBox3")).Enabled = false;
                ((DropDownList)rr.FindControl("DropDownList1")).Enabled = false;
            }
        }
    }
    protected void btnGenerate_Click(object sender, EventArgs e)
    {
        lblGridError.Visible = false;
        int[] fieldseq1 = new int[100];
        int compto1 = 0, compto2 = 0;
        Connection.count = 0;
        Array.Clear(seqno, 0, 100);
        Array.Clear(Connection.fieldname, 0, 100);
        Array.Clear(Connection.discription, 0, 100);
        Array.Clear(Connection.size, 0, 100);
        Array.Clear(Connection.fieldseq, 0, 100);
        Array.Clear(Connection.dataType, 0, 100);
       

        foreach (GridViewRow rr in GridView1.Rows)
        {
            if (((CheckBox)rr.FindControl("CheckBox1")).Checked == true)
            {
                Connection.fieldname[Connection.count] = rr.Cells[3].Text;                
                Connection.discription[Connection.count] = ((TextBox)rr.FindControl("TextBox2")).Text;
                Connection.size[Connection.count] = Convert.ToInt32(((TextBox)rr.FindControl("TextBox1")).Text);
                Connection.fieldseq[Connection.count] = Convert.ToInt32(((TextBox)rr.FindControl("TextBox3")).Text);
                fieldseq1[Connection.count] = Convert.ToInt32(((TextBox)rr.FindControl("TextBox3")).Text);
                Connection.dataType[Connection.count] = ((DropDownList)rr.FindControl("DropDownList1")).Text;
                Connection.count++;
            }
        }
        //fieldseq1 = Connection.fieldseq;

        Array.Sort(fieldseq1, 0, Connection.count);

        for (int p = 0; p < Connection.count; p++)
        {
            seqno[p] = p + 1;
            compto1++;
        }
        Array.Sort(seqno, 0, Connection.count);


        if (Array.Equals(seqno, fieldseq1))        
        {
            compto1 = 1;
        }               

        if (compto1 == Connection.count)
        {
            for (int i = 0; i < compto1; i++)
            {
                if (seqno[i] == fieldseq1[i])
                {
                    compto2++;
                }
            }
        }

        if (compto1 == compto2)
        {
            for (int p = 0; p < Connection.count; p++)
            {
                if (Connection.fieldseq[p] > Connection.count)
                {

                }
                if (Connection.loadflag == 1)
                {
                    insertBDC(txtName.Text, tcode, txtHotkey.Text);
                }
                else if (Connection.loadflag == 2)
                {
                    if (Connection.modifyFlag == 1)
                    {
                        string str = "Select * from BDCMaster where bdcName='" + Connection.bdcname + "'";
                        DataSet ds1 = cs.getDataset(str);

                        string delstr = "delete from BDCMaster where bdcName='" + Connection.bdcname + "'";
                        cs.openconn();
                        cs.executequery(delstr);
                        cs.closeconn();

                        insertBDC(Connection.bdcname, ds1.Tables[0].Rows[0][2].ToString(), ds1.Tables[0].Rows[0][3].ToString());
                    }

                }
                Response.Redirect("Generate.aspx");
            }
        }
        else
        {
            lblGridError.Visible = true;
            lblGridError.Text = "Please select proper Field Sequence.";
        }
    }

    protected void TextBox2_TextChanged(object sender, EventArgs e)
    {
        //TextBox tb = (TextBox)sender;
        //if
    }

    protected void GridView1_PreRender(object sender, EventArgs e)
    {
        ClientScriptManager cs = Page.ClientScript;
        foreach (GridViewRow grdrow in GridView1.Rows)
        {
            if (grdrow.Visible != false)
            {
                CheckBox chk1 = (CheckBox)grdrow.FindControl("CheckBox1");
                TextBox txtdescri = (TextBox)grdrow.FindControl("TextBox2");
                TextBox txtsiz = (TextBox)grdrow.FindControl("TextBox1");
                TextBox txtindex = (TextBox)grdrow.FindControl("TextBox3");
                DropDownList drdntype = (DropDownList)grdrow.FindControl("DropDownList1");
                cs.RegisterArrayDeclaration("grd_cb", "'" + chk1.ClientID + "'");
                cs.RegisterArrayDeclaration("grddes_txt", "'" + txtdescri.ClientID + "'");
                cs.RegisterArrayDeclaration("grdsiz_txt", "'" + txtsiz.ClientID + "'");
                cs.RegisterArrayDeclaration("grdindex_txt", "'" + txtindex.ClientID + "'");
                cs.RegisterArrayDeclaration("grddtype_txt", "'" + drdntype.ClientID + "'");
            }
        }
    }
    protected void drdnBDCName_SelectedIndexChanged(object sender, EventArgs e)
    {
        BDCName = drdnBDCName.Text;
        if (drdnBDCName.SelectedIndex == 0)
        {
            btnLoadD.Enabled = false;
            btnDelete.Enabled = false;
        }
        else
        {
            btnLoadD.Enabled = true;
            btnDelete.Enabled = true;
        }
    }
    protected void Button1_Click1(object sender, EventArgs e)
    {
        cs.openconn();
        string cmdstr = "Drop Table " + BDCName.ToString() + "";
        cs.executequery(cmdstr);

        string delstr = "Delete * From BDCMaster Where BDCName='" + BDCName.ToString() + "'";
        cs.executequery(delstr);

        string delstr1 = "Delete * From PermissionMaster Where PermissionName='" + BDCName.ToString() + "'";
        cs.executequery(delstr1);
        cs.closeconn();
        
        drdnBDCName.SelectedIndex = 0;
        btnDelete.Enabled = false;
        btnLoadD.Enabled = false;
        GridView1.Visible = false;
        btnGenerate.Visible = false;
        btnModifyBDC.Visible = false;
        LoadBDC();
    }
    protected void btnModifyBDC_Click(object sender, EventArgs e)
    {
        btnModifyBDC.Enabled = false;
        Connection.modifyFlag = 1;
        GridView1.Enabled = true;
    }
     
}
