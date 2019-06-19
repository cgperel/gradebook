package servlet;

import database.DBConnector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Calculator extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String username;
        String returningUsername;
        String checkReturningUser = null;
        returningUsername = req.getParameter ("returningUsername");
        username = req.getParameter ("username");
        session.setAttribute("username", username);
        String numberOfTestGrades = (String) req.getParameter ("numberOfTestGrades");
        //System.out.println (numberOfTestGrades);
        if(numberOfTestGrades != null) {
            req.setAttribute ("numberOfTestGrades", numberOfTestGrades);
            req.getRequestDispatcher ("/calculator.jsp").forward (req, resp);
        } else if(returningUsername != null){
            PreparedStatement statement=null;
            Connection conn = null;
            String selectTableSQL = "SELECT username, average from projecttrack.student where username like '" + returningUsername+"'";
            try{
                conn = new DBConnector ().getConn();
                statement=conn.prepareStatement (selectTableSQL);
                ResultSet rs = statement.executeQuery (selectTableSQL);
                if (rs.next ()){
                   returningUsername=rs.getString ("username");
                   String average=rs.getString ("average");
                    req.setAttribute ("returningUsername", returningUsername);
                    req.setAttribute ("average",average);
                    req.getRequestDispatcher ("/returningUserOptions.jsp").forward (req,resp);
                    //checkReturningUser = rs.getString ("username");
                }else{
                    req.getRequestDispatcher ("/nouser.jsp").forward (req,resp);
                }
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
       // }else if(returningUsername ==  ){
        }
            // req.setAttribute ("numberOfTestGrades", numberOfTestGrades);
    }


    protected void doPost (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String[]grades =req.getParameterValues ("testGrade");//only want to get list of grades once
        //for (int i=0; i<arr)
        Double testGradeTotals=0.0;

        for (int i=0; i<grades.length;i++){
            //String grade =grades [i];//get each grade as a string
            //Double testGrade =Double.valueOf (req.getParameter ("testGrade"));//taking each string and making it a double and turning it into test grade
            //use above to save grade as double
           testGradeTotals +=Double.valueOf(grades[i]);}

        /**Double testGrade1 = Double.valueOf (req.getParameter ("testGrade1"));
        //Double testGrade2 = Double.valueOf (req.getParameter ("testGrade2"));
        //Double testGrade3 = Double.valueOf (req.getParameter ("testGrade3"));
        //Double testGrade4 = Double.valueOf (req.getParameter ("testGrade4"));
        //Double testGrade5 = Double.valueOf (req.getParameter ("testGrade5"));
        //Double testGrade6 = Double.valueOf (req.getParameter ("testGrade6"));
        //Double testGradeTotals = testGrade1+testGrade2+testGrade3+testGrade4+testGrade5+testGrade6;**/
        Double gradeAverage = testGradeTotals/grades.length;

        DecimalFormat df2 = new DecimalFormat ("##.##");
        req.setAttribute ("gradeAverage",df2.format (gradeAverage));
        String letterGrade = null;
        if(gradeAverage<65){
            letterGrade="Fail";
        }else if(gradeAverage>65 && gradeAverage<70){
            letterGrade="D";
        }else if(gradeAverage>69&&gradeAverage<80){
            letterGrade="C";
        }else if(gradeAverage>79&&gradeAverage<90){
            letterGrade="B";
        }else if(gradeAverage>89){
            letterGrade="A";
        }
        req.setAttribute ("lettergrade", letterGrade);

        //req.getSession().getAttribute ("username");


        PrintWriter writer = resp.getWriter ();
        PreparedStatement statement = null;
        Connection conn =null;
        String sql = "INSERT INTO projecttrack.student (username, average, lettergrade) values (?,?,?)";
        String username = (String) req.getSession ().getAttribute ("username");
        //String average = (String)req.getSession ().getAttribute ("average");
        try {
            conn = new DBConnector ().getConn();
            statement=conn.prepareStatement (sql);
            statement.setString(1, username);
            statement.setDouble (2,gradeAverage);
            statement.setString (3,letterGrade);
            statement.executeUpdate ();

        } catch (SQLException e){
            e.printStackTrace ();
        }finally {
            if (conn != null){
                try {
                    conn.close ();
                } catch (SQLException e) {
                    e.printStackTrace ( );
                }
            }if(statement != null){
                try {
                    statement.close ();
                } catch (SQLException e) {
                    e.printStackTrace ( );
                }
            }
        }
        req.getRequestDispatcher ("/calculatorResults.jsp").forward (req,resp);
    }
}
