package servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.rmi.server.ServerCloneException;


public class Authenticate extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doGet (req, resp);
        resp.getWriter ().println ("Hello");
        System.out.println ("get was called");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doPost (req, resp);
        req.getAttribute ("username");
        req.getAttribute ("password");
        System.out.println ("got the post");
        req.getRequestDispatcher ("/calculator").forward (req, resp);
    }
}

