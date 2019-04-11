package servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class Authenticate extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp,String username){
        req.getRequestDispatcher (username);

    }

}

