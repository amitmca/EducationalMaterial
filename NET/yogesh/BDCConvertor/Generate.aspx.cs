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

public partial class Generate : System.Web.UI.Page
{
    public static string[] tbid = new string[100];
    public static string[] lbid = new string[100];
    public static TextBox[] tbx = new TextBox[100];
    public static RequiredFieldValidator[] rfvx = new RequiredFieldValidator[100];
    public static RegularExpressionValidator[] revx = new RegularExpressionValidator[100];
    
    Connection cs = new Connection();
    DataSet ds = new DataSet();

    protected void Page_Load(object sender, EventArgs e)
    {
        int flag = 0;
        
        if (!IsPostBack)
        {
            lblBDCName.Text = Connection.bdcname;
            string descrptn = "Select Description from BDCMaster Where BDCName='" + Connection.bdcname + "'";
            ds = cs.getDataset(descrptn);
            lblDscrptn.Text = ds.Tables[0].Rows[0][0].ToString();

            cs.openconn();
            DataTable dt = cs.conn.GetSchema("tables");

            if (dt != null)
            {
                for (int i = 0; i < dt.Rows.Count; i++)
                {
                    if ((dt.Rows[i]["TABLE_TYPE"].ToString() != "SYSTEM TABLE") && (dt.Rows[i]["TABLE_TYPE"].ToString() != "ACCESS TABLE"))
                    {
                        if (dt.Rows[i]["TABLE_NAME"].ToString() == Connection.bdcname)
                        {
                            flag = 1;
                            break;
                        }
                    }
                }
            }
            cs.closeconn();
            if (flag == 0)
            {
                string str = "create table " + Connection.bdcname + "(";
                for (int i = 0; i < Connection.count; i++)
                {
                    int a = Array.IndexOf(Connection.fieldseq, i + 1); ;

                    string FieldName = Connection.fieldname[a];
                    string[] FName = FieldName.Split("-".ToCharArray());
                    
                    if (Connection.dataType[a] == "Number")
                    {
                        str += FName[1] + " Number,";
                    }
                    else if (Connection.dataType[a] == "Text")
                    {
                        str += FName[1] + " Text,";
                    }
                    else if (Connection.dataType[a] == "Date/Time")
                    {
                        str += FName[1] + " Date,";
                    }
                }
                str = str.Remove(str.Length - 1);
                str += ");";
                cs.openconn();
                cs.executequery(str);
                cs.closeconn();
            }
            else if (flag == 1)
             {
                if (Connection.modifyFlag == 1)
                {
                    string delstr = "Drop table " + Connection.bdcname + "";
                    cs.openconn();
                    cs.executequery(delstr);
                    cs.closeconn();

                    string str = "create table " + Connection.bdcname + "(";
                    for (int i = 0; i < Connection.count; i++)
                    {
                        int a = Array.IndexOf(Connection.fieldseq, i + 1);
                        string FieldName = Connection.fieldname[a];
                        string[] FName = FieldName.Split("-".ToCharArray());

                        if (Connection.dataType[a] == "Number")
                        {
                            str += FName[1] + " Number,";
                        }
                        else if (Connection.dataType[a] == "Text")
                        {
                            str += FName[1] + " Text,";
                        }
                        else if (Connection.dataType[a] == "Date/Time")
                        {
                            str += FName[1] + " Date,";
                        }
                    }
                    str = str.Remove(str.Length - 1);
                    str += ");";
                    cs.openconn();
                    cs.executequery(str);
                    cs.closeconn();
                }
            }

            FillGrid();
        }

        ValidationSummary vs = new ValidationSummary();
        for (int a = 0; a < Connection.count; a++)
         {

             int i = Array.IndexOf(Connection.fieldseq, a + 1);
            TableRow tr = new TableRow();
            TableCell tc = new TableCell();
            TableCell tc1 = new TableCell();
            TableCell tc2 = new TableCell();
            TextBox tb = new TextBox();
            Label lb = new Label();
            RequiredFieldValidator rfv = new RequiredFieldValidator();
            RegularExpressionValidator rev = new RegularExpressionValidator();

            tb.Attributes.Add("runat", "Server");
            tb.EnableViewState = false;
            tb.MaxLength = Connection.size[i];
            tb.ID = "txt" + Connection.discription[i].Trim();
            tbx[a] = tb;

            lb.Attributes.Add("runat", "Server");
            lb.EnableViewState = false;
            lb.ID = "lbl" + Connection.discription[i].Trim();
            lb.Text = Connection.discription[i] + ":";

            rfv.Attributes.Add("runat", "Server");
            rfv.EnableViewState = false;
            rfv.ID = "rfv" + Connection.discription[i].Trim();
            rfv.ControlToValidate = tb.ID;
            rfv.Text = "*";
            rfv.ValidationGroup = "validater";
            rfv.ErrorMessage = Connection.discription[i] + " Field should not be Blank.";
            rfvx[i] = rfv;

            if (Connection.dataType[i] == "Number")
            {
                rev.Attributes.Add("runat", "Server");
                rev.EnableViewState = false;
                rev.ID = "rev" + Connection.discription[i];
                rev.ControlToValidate = tb.ID;
                rev.Text = "*";
                rev.ValidationExpression = "^[0-9]+$";
                rev.ValidationGroup = "validater";
                rev.ErrorMessage = "Invalid " + Connection.discription[i];
                revx[i] = rev;
            }

            else if (Connection.dataType[i] == "Text")
            {
                rev.Attributes.Add("runat", "Server");
                rev.EnableViewState = false;
                rev.ID = "rev" + Connection.discription[i];
                rev.ControlToValidate = tb.ID;
                rev.Text = "*";
                rev.ValidationGroup = "validater";
                rev.ValidationExpression = "^^[a-zA-Z0-9 _\\-\\.\\\\\\,\\(\\)\\/]+$";
                rev.ErrorMessage = "Invalid" + Connection.discription[i];
                revx[i] = rev;
            }

            else if (Connection.dataType[i] == "Date/time")
            {
                rev.Attributes.Add("runat", "Server");
                rev.EnableViewState = false;
                rev.ID = "rev" + Connection.discription[i];
                rev.ControlToValidate = tb.ID;
                rev.Text = "*";
                rev.ValidationExpression = "^(((0[1-9]|[12]\\d|3[01])\\/(0[13578]|1[02])\\/((1[6-9]|[2-9]\\d)\\d{2}))|((0[1-9]|[12]\\d|30)\\/(0[13456789]|1[012])\\/((1[6-9]|[2-9]\\d)\\d{2}))|((0[1-9]|1\\d|2[0-8])\\/02\\/((1[6-9]|[2-9]\\d)\\d{2}))|(29\\/02\\/((1[6-9]|[2-9]\\d)(0[48]|[2468][048]|[13579][26])|((16|[2468][048]|[3579][26])00))))$";
                rev.ValidationGroup = "validater";
                rev.ErrorMessage = "Invalid" + Connection.discription[i];
                revx[i] = rev;
            }

            tc.Controls.Add(lb);
            tc1.Controls.Add(tb);
            tc2.Controls.Add(rfv);
            tc2.Controls.Add(rev);
            tr.Cells.Add(tc);
            tr.Cells.Add(tc1);
            tr.Cells.Add(tc2);
            display1.Rows.Add(tr);
        }
        vs.Attributes.Add("runat", "Server");
        vs.EnableViewState = false;
        vs.ID = "ValidS";
        vs.ValidationGroup = "validater";
        vs.ShowMessageBox = true;
        vs.ShowSummary = false;
        display1.Rows[0].Cells[2].Controls.Add(vs);

        btnSave.ValidationGroup = "validater";

    }

    public void FillGrid()
    {
        string cmdstr = "Select * From [" + Connection.bdcname + "]";
        ds = cs.getDataset(cmdstr);
        GridView1.DataSource = ds.Tables[0];
        GridView1.DataBind();
    }

    protected void btnSave_Click(object sender, EventArgs e)
    {
        lblMsg.Text = "";
        int i = 0;
        string[] values = new string[Connection.count];
        foreach (TextBox tx in tbx)
        {
            if (i < Connection.count)
            {
                values[i] = tx.Text;
            }
            else
            {
                break;
            }
            i++;
        }

        //string cmdstr = "Select * From [" + Connection.bdcname + "]";
        //ds = cs.getDataset(cmdstr);

        string str = "Insert into " + Connection.bdcname + " values(";

        for (i = 0; i < values.Length; i++)
        {
            // int a = Connection.fieldseq[i];
            if (Connection.dataType[i].Equals("Number"))
            {
                str += values[i] + ",";
            }
            else if (Connection.dataType[i].Equals("Text"))
            {
                str += "'" + values[i] + "',";
            }
            else if (Connection.dataType[i].Equals("Date"))
            {
                str += "" + values[i] + ",";
            }
        }
        str = str.Remove(str.Length - 1);
        str += ");";
        cs.openconn();
        cs.executequery(str);
        cs.closeconn();

        lblMsg.Text = "Record Inserted Successfully.";
        i = 0;
        foreach (TextBox tx in tbx)
        {
            if (i < Connection.count)
            {
                tx.Text = "";
            }
            else
            {
                break;
            }
            i++;
        }
        FillGrid();
    }
    protected void btnCancel_Click(object sender, EventArgs e)
    {
        Response.Redirect("Convert.aspx");
    }
}
