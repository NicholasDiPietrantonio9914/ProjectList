
package com.mycompany.projectlist.Model;

import com.mycompany.projectlist.Db.DbConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * class contains method to retrieve password from database
 * @author Nicholas Di Pietrantonio
 */
public class PasswordDb {
    
    /**
     * method used to get the password from the database
     * @return db password
     * @throws Exception 
     */
    public static String getPassword() throws Exception {

        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        String password = null;

        ArrayList<Projects> projects = new ArrayList();

        try {

            String driver = "org.postgresql.Driver";

            Class.forName(driver);

            String dbUrl = System.getenv("JDBC_DATABASE_URL");

            
            conn = DbConnector.getConnection(driver, dbUrl);

            String sql = "select * from pass";

            ps = conn.prepareStatement(sql);

            rs = ps.executeQuery();

            if (rs.next()) {
                password = rs.getString("pass");
            }

        } catch (ClassNotFoundException ex) {
            throw new Exception(ex.toString());
        } catch (SQLException ex) {
            throw new Exception(ex.toString());
        } finally {
            //ensure that conn, ps, and rs are closed even if a error is caught
            DbConnector.closeJDBCObjects(conn, ps, rs);
        }
        return password;

    }

}
