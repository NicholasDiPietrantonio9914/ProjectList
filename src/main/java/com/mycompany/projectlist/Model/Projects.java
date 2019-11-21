
package com.mycompany.projectlist.Model;

import java.io.Serializable;

/**
 * class used to represent projects from the database
 * @author Nicholas Di Pietrantonio
 */
public class Projects implements Serializable{
    
    private String name;
    private String appLink;
    private String codeLink;
    private String description;
    
    public Projects(){}

    public Projects(String name, String appLink, String codeLink, String description) {
        this.name = name;
        this.appLink = appLink;
        this.codeLink = codeLink;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAppLink() {
        return appLink;
    }

    public void setAppLink(String appLink) {
        this.appLink = appLink;
    }

    public String getCodeLink() {
        return codeLink;
    }

    public void setCodeLink(String codeLink) {
        this.codeLink = codeLink;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    

}
