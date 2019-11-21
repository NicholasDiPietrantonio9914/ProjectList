/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projectlist.TagHandlers;

import com.mycompany.projectlist.Model.*;
import java.util.ArrayList;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author Nicholas Di Pietrantonio
 */
public class ProjectsHandler extends SimpleTagSupport {

    /**
     * Called by the container to invoke this tag. The implementation of this
     * method is provided by the tag library developer, and handles all tag
     * processing, body iteration, etc.
     */
    @Override
    public void doTag() throws JspException {
        JspWriter out = getJspContext().getOut();
        
        try {
            ArrayList <Projects> projects = ProjectsDb.getProjects();
            
            for (int i = 0 ; i < projects.size() ; i ++) {
                out.println("<h2>" + projects.get(i).getName() + "</h2>");
                out.println("<h3>" + projects.get(i).getAppLink() + "</h3>");
                out.println("<h3>" + projects.get(i).getCodeLink() + "</h3>");
                out.println("<p>" + projects.get(i).getDescription() + "</p><br>");
            }
            JspFragment f = getJspBody();
            if (f != null) {
                f.invoke(out);
            }
        } catch (java.io.IOException ex) {
            throw new JspException("Error in ProjectsHandler tag", ex);
        } catch (Exception ex) {
            throw new JspException("Error in ProjectsHandler tag", ex);
        }
    }
    
}
