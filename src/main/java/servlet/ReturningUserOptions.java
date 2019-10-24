package servlet;

import database.DBConnector;
import database.Student;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReturningUserOptions extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PreparedStatement statement = null;
        Connection conn = null;
        String selectTableSQL = "SELECT id, username, average from projecttrack.student where id =?";
        try {
            conn = new DBConnector ( ).getConn ( );
            statement = conn.prepareStatement (selectTableSQL);
            statement.setString (1,"id");
            statement.setString (2,"username");
            statement.setString (3,"average");
            ResultSet rs = statement.executeQuery ();
            while (rs.next ()){
                String id = rs.getString ("id");
                String username = rs.getString ("username");
                String average = rs.getString ("average");

                System.out.println ("id:"+id);
                System.out.println ("user:"+ username);
                System.out.println ("Average:"+average);


            }
        } catch (SQLException e) {
            e.printStackTrace ( );
        } finally {
            if (conn != null) {
                try {
                    conn.close ( );
                } catch (SQLException e) {
                    e.printStackTrace ( );
                }
            }
            if (statement != null) {
                try {
                    statement.close ( );
                } catch (SQLException e) {
                    e.printStackTrace ( );
                }
            }
        }
    }
    // super.doGet (req, resp);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher ("/returningUserResults.jsp").forward (req,resp);
        //String sql="UPDATE projecttrack.Student SET average= WHERE id= ";
        String classname = req.getParameter ("classname");
        PreparedStatement statement=null;
        Connection conn = null;
        String sql="SELECT username, average, lettergrade, classname from projecttrack.student where classname like '"+ classname+"'";
        try{
            conn = new DBConnector ().getConn ();
            statement=conn.prepareStatement (sql);
            ResultSet rs=statement.executeQuery (sql);
            List students = new ArrayList<Student>();
            while (rs.next ( )) {
                Student student=new Student ();
                student.setUsername (rs.getString ("username"));
                student.setAverage (rs.getDouble ("average"));
                student.setLettergrade (rs.getString ("lettergrade"));
                student.setClassname (rs.getString ("classname"));
                students.add (student);



            }
            req.setAttribute ("students",students);
        } catch (SQLException e) {
            e.printStackTrace ( );
        }
    }
}

