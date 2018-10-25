package pl.sdacademy.tweeter.web;

import pl.sdacademy.tweeter.model.LoginManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    private LoginManager loginManager;

    public LoginServlet(LoginManager loginManager) {
        this.loginManager = loginManager;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String loginParam = req.getParameter("login");
        String passParam = req.getParameter("password");
        if (loginManager.isValid(loginParam, passParam)) {
            req.getSession().setAttribute("user", loginParam);
            resp.sendRedirect("/tweeter");
        }else{
            resp.sendRedirect("/login");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("login.jsp").forward(req, resp);
    }
}
