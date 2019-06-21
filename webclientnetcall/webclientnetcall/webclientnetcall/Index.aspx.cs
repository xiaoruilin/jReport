using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Text;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace webclientnetcall
{
    public partial class Index : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }

        protected void Unnamed_Click(object sender, EventArgs e)
        {
            using (WebClient wc = new WebClient())
            {
                wc.Credentials = CredentialCache.DefaultCredentials;
                wc.Headers.Add("Content-Type", "application/x-www-form-urlencoded");
                wc.QueryString["systemId"] = "fffff";
                byte[] fileb = wc.DownloadData(new Uri("http://127.0.0.1:8080/hei"));

                //byte[] fileb = wc.UploadFile(new Uri("http://127.0.0.1:8080/hei"), "POST");
                string res = Encoding.GetEncoding("gb2312").GetString(fileb);
            }
        }
    }
}