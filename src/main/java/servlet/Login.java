package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter ().println ("Hello");
        System.out.println ("get was called");
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp, String username, String password, Integer numberOfTestGrades) throws ServletException, IOException {
        req.getAttribute (username);
        req.getAttribute (password);

        System.out.println ("Post was called");
    }
}