package servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.rmi.server.ServerCloneException;


public class Authenticate extends HttpServlet {

    protected void doGet(HttpServletResponse req, HttpServletResponse resp) throws ServletException, IOException{
        resp.getWriter ().println ("Hello");
        System.out.println ("get was called");
    }
    //@Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp,String username, String password){
        req.getAttribute (username);
        req.getAttribute (password);


    }

}

