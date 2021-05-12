package com.surveyData.Project04;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.sql.*;

@ManagedBean
@ApplicationScoped
public class Connect
{
    public Connection connect() throws Exception {
        Connection con = null;
        String url = "jdbc:sqlserver://localhost;instance=SQLEXPRESS; databaseName = surveyDB; user = admin; password = 1234";

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(url);
            System.out.println("Connection completed.");
            System.out.println(con);
            return con;
        }
        catch (SQLException sqlException) {
            System.out.println("error in connect method");
            throw new Exception ("Error in Connect.connect()", sqlException);
        }
    }
}
