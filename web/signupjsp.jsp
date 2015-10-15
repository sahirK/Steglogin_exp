<%-- 
    Document   : signupjsp
    Created on : 2 Sep, 2010, 8:14:53 PM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="java.sql.*"%>
<%@page import="java.io.IOException" %>
<%@page import="java.io.PrintWriter" %>


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>signup</title>
    </head>
    <body>
        
    <% 
    try
            {
        
    Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            Connection cn=DriverManager.getConnection("jdbc:odbc:sha","","");
            PreparedStatement st=cn.prepareStatement("insert into info(sname,mob,city,username,password) values(?,?,?,?,?)");

String s1=request.getParameter("name");
   String s2=request.getParameter("mob");
   String s3=request.getParameter("city");
   String s4=request.getParameter("uname");

   String s5=request.getParameter("pass");
   String s6=request.getParameter("rpass");
   int updateQuery=0;
     %>
     <form action="signupjsp.jsp">
      <% if(s1==null)
          {    %>
          <b><font color="red">name   </font> </b><input type="text" name="name" value="" />
      <%
          }
         else
             {
%>
                       <b>name    </b><input type="text" name="name" value="" />
                       <% }
   %>

         <br><b>mobile no.</b><input type="text" name="mob" value="" />
      <br><b>city</b><input type="text" name="city" value="" />
      <br><b>username</b><input type="text" name="uname" value="" />
      <br><b>password</b><input type="password" name="pass" value="" />
      <br><b>re-enter password</b><input type="password" name="rpass" value="" />
      <br><input type="submit" value="submit" />
      <input type="reset" value="cancel" />


     </form>


    </body>
</html>
