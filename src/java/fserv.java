
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import sa2.pathhandle;
import steg.ende;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sa2.shadigest;
import javax.servlet.http.HttpSession;




//import java.util.Random;
/**
 *
 * @author user
 */
@WebServlet(name="fserv", urlPatterns={"/fserv"})
public class fserv extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        int c=0;
        int x=0;

       String pss=null,ps=null;
        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            Connection cn=DriverManager.getConnection("jdbc:odbc:sha","","");
            java.sql.Statement st=cn.createStatement();
   ResultSet res=st.executeQuery("Select * from info");
  String un=request.getParameter("username");
  ps=request.getParameter("password");
  String sid=request.getParameter("sid");
  String sid1=shadigest.getDigestedPassword(sid);
  String sid2=shadigest.getDigestedPassword(sid1);


    // pss=pathhandle.slashcon(ps);


String dp=ende.getHiddenDataFromImage(ps);
String againhash=shadigest.getDigestedPassword(dp);


   while(res.next())
   {
       if((un.compareTo(res.getString(4))==0)&&(againhash.compareTo(res.getString(5))==0) && (sid2.compareTo(res.getString(6))==0))
       {

            // response.sendRedirect("li1.jsp");
//


    
           HttpSession s1=request.getSession(true);
           UUID idOne = UUID.randomUUID();
        String fs=new String(idOne.toString());

        String ns=null;
        try {
            MessageDigest md5 = MessageDigest.getInstance("SHA-256");
            //String saltedPassword = "let's-add-some-salt-to-go-with-it-and-make-it-more-secure-"+password;
             byte[] digest = md5.digest(fs.getBytes("UTF-8"));
              ns =(Base64.encode(digest));
         } catch (NoSuchAlgorithmException nsaex) {
             System.err.println("Could not create MessageDigest for SHA-256 ???");
         } catch (UnsupportedEncodingException ueex) {
            System.err.println("Unsupported encoding US-ASCII ???");
         }





           

           s1.setAttribute("sessVar",ns);
//           out.println("<h1> yo!!! welcome to my page homie.<br>sessionVar=</h1>");
            response.sendRedirect("li1.jsp");
  //         out.println(s1.getAttribute("sessVar")+"<br><br><br><a href=lo><font color=blue size=18>logout</font></a>");

      x=0;
      c=0;
       break;
       }

       else
       {
          c++;
          x=0;

       }

        }

  if(c!=x)
  {
      out.println("<h1>check username n password</h1>");
  }




}
        catch(Exception e)
        {
            out.println("<h1>original"+ps+"</h1>");
            out.println("<h1>please enter the path correctly"+pss+"</h1>");

        }
    }



    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        try {
// <editor-fold defaultstate="collapsed" desc="comment">
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(fserv.class.getName()).log(Level.SEVERE, null, ex);
        }// </editor-fold>
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(fserv.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>


}