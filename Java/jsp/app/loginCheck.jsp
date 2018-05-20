<HTML><HEAD><TITLE>JSP Checks Login Information Against Parameters</TITLE></HEAD><BODY>
<H1>Hello</H1>
<%
    String usernameFormParameterValue = request.getParameter("usernameFormParameter");
    String passwordFormParameterValue = request.getParameter("passwordFormParameter");
    if(usernameFormParameterValue!=null){
        String usernameInitParameterValue = config.getInitParameter("username");
        String passwordInitParameterValue = config.getInitParameter("password");
        if(usernameFormParameterValue.equals(usernameInitParameterValue)&&passwordFormParameterValue.equals(passwordInitParameterValue)){
            // login correct, greetings %>
            Welcome !!!
<%
        } else {
            // login incorrect, please try again %>
            Sorry but we dont know you <BR>
            Would you like to <A HREF=login.jsp>try again</A>
<%      }
    } else {
        // login incorrect, please try again %>
        Sorry but your login is incorrect <BR>
        Would you like to <A HREF=login.jsp>try again</A>
<%  }
%>
</BODY></HTML>
