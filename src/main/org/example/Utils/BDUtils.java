package org.example.Utils;

import java.sql.*;

import static org.example.Utils.Constanc.*;

public class BDUtils {

    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, NAME, PSW);
            System.out.println("Sucsesfull");
        }catch (ClassNotFoundException ex1){
            System.err.println(ex1);
        }
        catch (SQLException ex) {
            System.err.println(ex);
        }
            return connection;
        }



    public static void release(Connection connection, Statement st,PreparedStatement ps,ResultSet rs) {
        try {
            if (connection != null) connection.close();
            if (st != null) st.close();
            if (ps != null) ps.close();
            if (rs != null) rs.close();

        } catch (SQLException es) {
            System.err.println(es);
        }
    }


}
