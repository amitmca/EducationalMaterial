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

public partial class LoginMaster : System.Web.UI.MasterPage
{
    protected void Page_Load(object sender, EventArgs e)
    {
        if (!IsPostBack)
        {
            if (Session["luser"] != "Admin")
            {
                Response.Redirect("index.aspx");
            }
        }
    }

    protected void btnLogOut_Click(object sender, EventArgs e)
    {
        Connection.bdcname = "";
        Connection.count = 0;
        Connection.loadflag = 0;
        Connection.username = "";
        Session["luser"] = "";
        Response.Redirect("Index.aspx?logout=1");
    }
}
