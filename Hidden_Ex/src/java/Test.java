import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/Test"})
public class Test extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String roll = request.getParameter("roll");
            String name = request.getParameter("name");
            String age = request.getParameter("age");
            String dob = request.getParameter("dob");

            out.print("<h1>");
            out.append("<br> ROLL: "+roll);
            out.print("<br> NAME: "+name);
            out.print("<br> AGE: "+age);
            out.print("<br> DOB: "+dob);      
            out.print("<h1>");
            
            out.print("<form action='s1' method='get'>");
            
            out.println("<input type='hidden' name='roll' value="+roll+"></input>");
            out.println("<input type='hidden' name='name' value="+name+"></input>");
            out.println("<input type='hidden' name='age' value="+age+"></input>");
            out.println("<input type='hidde cv vc vn' name='dob' value="+dob+"></input>");
            
            out.println("Branch: <input type='text' name='branch'></input>");
            out.println("Address: <input type='text' name='address'></input>");
            out.println("<input type='submit' value='Next'></input>");
            out.print("</form>");
          //  out.print("<hr><a href='S1'>CLICK HERE FOR S1</a><hr>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
