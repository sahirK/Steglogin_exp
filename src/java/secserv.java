/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import sa2.imagehandle;
import steg.ende;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sa2.shadigest;
import java.util.UUID;

/**
 *
 * @author user
 */
@WebServlet(name="secserv", urlPatterns={"/secserv"})
public class secserv extends HttpServlet {
    //private Object HttpServletResponse;
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException, ClassNotFoundException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        try
        {


        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            Connection cn=DriverManager.getConnection("jdbc:odbc:sha","","");
            PreparedStatement st=cn.prepareStatement("insert into info(sname,mob,city,username,password,sid) values(?,?,?,?,?,?)");
   //ResultSet res=st.executeQuery("Select * from info");
   
   String s1=request.getParameter("name");
   String s2=request.getParameter("mob");
   String s3=request.getParameter("city");
   String s4=request.getParameter("uname");
  
   String s5=request.getParameter("pass");
   String s6=request.getParameter("rpass");
   String s7=request.getParameter("rpass1");

   //String path=request.getParameter("path");
   int updateQuery=0;
   if((s6.equals(s7)) && s5.length()<25)
   {


       String fsthash=shadigest.getDigestedPassword(s5);
       String scndhash=shadigest.getDigestedPassword(fsthash);
       String sid=shadigest.getDigestedPassword(s6);
       String sid2=shadigest.getDigestedPassword(sid);


   st.setString(1, s1); 
   st.setString(2, s2); 
   st.setString(3, s3); 
   st.setString(4, s4); 
   st.setString(5, scndhash);
   st.setString(6, sid2);

   ende.hideTextDataInsideImage(s5,s4);
   updateQuery = st.executeUpdate();
   if(updateQuery != 0) 
   {
       imagehandle s=new imagehandle();

   String path=s.imagepath("C:/Users/user/Documents/id",s4,"jpg");
  out.println("<html><head><h1> Register Successful</h1></head><body>");
  out.println("<img src=id/android.jpg>");
  out.println("<a href=file:///"+path+">click here to download image id </a>");
out.println("<h1>successfully done!!</h1>");
  out.println("</body></html>");
   }
   else
   {
       out.println("check the path");
   }

   }
   else{
       out.println("<h1> error!! check the PASSWORD + SECURE ID</h1>");
   }
           
    
        }
        catch(Exception e)
        {
            out.println("<h1>check the path and all fields"+e+"</h1>");
        }

        
}
     @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        try {
// <editor-fold defaultstate="collapsed" desc="comment">
            processRequest(request, response);
        } catch (Exception ex) {
            
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
            }
         catch (Exception ex) {
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
   
  
