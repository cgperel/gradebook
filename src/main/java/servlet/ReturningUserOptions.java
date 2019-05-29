package servlet;

import database.DBConnector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ReturningUserOptions extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet (req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PreparedStatement statement=null;
        Connection conn = null;
        String selectTableSQL = "SELECT id, username from projecttrack.student";
        try{
            conn = new DBConnector ().getConn();
            statement=conn.prepareStatement (selectTableSQL);
            statement.execute ();
        } catch (SQLException e) {
                e.printStackTrace ( );
            }finally {
            if (conn != null){
                try{conn.close ();
            }catch (SQLException e){
                    e.printStackTrace ();
                }
        }if(statement != null){
                try {
                    statement.close ();
                } catch (SQLException e){
                    e.printStackTrace ();
                }
                }
            }

        //super.doPost (req, resp);
    }
}
