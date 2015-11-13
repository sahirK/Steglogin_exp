<%-- 
    Document   : li1
    Created on : 21 Mar, 2011, 2:15:39 AM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
    </head>
    <body>
    <%     HttpSession s1=request.getSession();
    if(s1==null)
        {
        RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
    rd.forward(request, response);
    }
    //String loggedIn = (String) session.getAttribute("loggedIn");
      //if (!loggedIn.equals("true"))
        //response.sendRedirect("index.jsp");


           //String s1id=session.getId();
           //s1.setAttribute("sessVar",1);
          // out.println("");
         %>  
<h1> Welcome to project ISAWA .</h1><br><br><br><br><a href=lo><font color=blue size=18>logout</font></a>


                                                       </body>
</html>
