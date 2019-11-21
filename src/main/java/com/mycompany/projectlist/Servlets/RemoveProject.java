
package com.mycompany.projectlist.Servlets;

import com.mycompany.projectlist.Model.PasswordDb;
import com.mycompany.projectlist.Model.ProjectsDb;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Nicholas Di Pietrantonio
 */
public class RemoveProject extends HttpServlet {
    
    /**
     * method uses POST and is called when a project is to be removed from the database
     * @param request servlet request object
     * @param response servlet response object
     * @throws ServletException
     * @throws IOException 
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try {
            String password = request.getParameter("password");
            String name = request.getParameter("avengerName");
            
            if(password.equals(PasswordDb.getPassword())) {
                ProjectsDb.removeProject(name);
            } else {
                throw new Exception("Password not correct");
            }
            
            
        } catch (Exception ex) {
            request.setAttribute("error", ex.toString());
        }
        
        RequestDispatcher rd = request.getRequestDispatcher("projectRemoved.jsp");
        rd.forward(request, response);
    }

}
