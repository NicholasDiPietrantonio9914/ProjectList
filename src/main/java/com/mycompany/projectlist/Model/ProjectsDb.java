package com.mycompany.projectlist.Model;

import com.mycompany.projectlist.Db.DbConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Contains methods to add and retrieve from the database
 *
 * @author Nicholas Di Pietrantonio
 */
public class ProjectsDb {

    /**
     * method is used to get a list of all the projects
     *
     * @return All the avengers in the database
     * @throws Exception
     */
    public static ArrayList<Projects> getProjects() throws Exception {

        //objects declared as here so they can be accessed anywhere in the method
        //though about putting them as data fields so they could be used in both methods
        //but decided against, just felt wrong
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;

        ArrayList<Projects> projects = new ArrayList();

        try {

            String driver = "org.postgresql.Driver";

            Class.forName(driver);

            String dbUrl = System.getenv("JDBC_DATABASE_URL");

            
            conn = DbConnector.getConnection(driver, dbUrl);

            String sql = "select * from projects";

            ps = conn.prepareStatement(sql);

            rs = ps.executeQuery();

            while (rs.next()) {
                String name = rs.getString("pname");
                String appLink = rs.getString("appLink");
                String codeLink = rs.getString("codeLink");
                String description = rs.getString("description");
                
                projects.add(new Projects(name, appLink, codeLink, description));
            }

        } catch (ClassNotFoundException ex) {
            throw new Exception(ex.toString());
        } catch (SQLException ex) {
            throw new Exception(ex.toString());
        } finally {
            //ensure that conn, ps, and rs are closed even if a error is caught
            DbConnector.closeJDBCObjects(conn, ps, rs);
        }
        return projects;

    }

    /**
     * method to add a project to the database
     * @param name name of the project
     * @param appLink link to the application
     * @param codeLink link to the github code
     * @param description description of the project
     */
    public static void addProject(String name, String appLink, String codeLink,
            String description) throws Exception {

        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;

        try {

            String driver = "org.postgresql.Driver";

            Class.forName(driver);

            String dbUrl = System.getenv("JDBC_DATABASE_URL");

            conn = DbConnector.getConnection(driver, dbUrl);

            String sql = "insert into projects(pname, appLink, codeLink, description)"
                    + "values(?, ?, ?, ?)";

            ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, appLink);
            ps.setString(3, codeLink);
            ps.setString(4, description);

            //use execute update because you are not pulling any information from
            //the database just updating
            ps.executeUpdate();

        } catch (ClassNotFoundException ex) {
            throw new Exception(ex.toString());
        } catch (SQLException ex) {
            throw new Exception(ex.toString());
        } finally {
            //ensure that conn, ps, and rs are closed even if a error is caught
            DbConnector.closeJDBCObjects(conn, ps, rs);
        }

    }
    
    /**
     * method used to remove a project from the database
     * @param name the name of the project to remove
     * @throws Exception 
     */
    public static void removeProject(String name) throws Exception {

        //objects declared as here so they can be accessed anywhere in the method
        //thought about putting them as data fields so they could be used in both methods
        //but decided against, just felt wrong
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;

        try {

            String driver = "org.postgresql.Driver";

            Class.forName(driver);

            String dbUrl = System.getenv("JDBC_DATABASE_URL");

            conn = DbConnector.getConnection(driver, dbUrl);
            
            String sql = "delete from projects where pname like ?";

            ps = conn.prepareStatement(sql);
            ps.setString(1, name);

            //use execute update because you are not pulling any information from
            //the database just updating
            ps.executeUpdate();

        } catch (ClassNotFoundException ex) {
            throw new Exception(ex.toString());
        } catch (SQLException ex) {
            throw new Exception(ex.toString());
        } finally {
            //ensure that conn, ps, and rs are closed even if a error is caught
            DbConnector.closeJDBCObjects(conn, ps, rs);
        }

    }
    
    
}
