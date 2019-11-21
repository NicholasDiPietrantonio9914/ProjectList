
package com.mycompany.projectlist.Servlets;

import com.mycompany.projectlist.Model.*;
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
public class AddProject extends HttpServlet{
    
    /**
     * method uses POST and is called when a project is to be added to the database
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
            String name = request.getParameter("name");
            String appLink = request.getParameter("appLink");
            String codeLink = request.getParameter("codeLink");
            String description = request.getParameter("description");
            
            if(password.equals(PasswordDb.getPassword())) {
                ProjectsDb.addProject(name, appLink, codeLink, description);
            } else {
                throw new Exception("Password not correct");
            }
            
            
        } catch (Exception ex) {
            request.setAttribute("error", ex.toString());
        }
        
        RequestDispatcher rd = request.getRequestDispatcher("projectAdded.jsp");
        rd.forward(request, response);
    }

}
