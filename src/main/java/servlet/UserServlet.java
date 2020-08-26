package servlet;

import ejb.UserRepository;
import entity.User;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UserServlet", value = "/users")
public class UserServlet extends HttpServlet
{
    @Inject
    private UserRepository userRepo;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String role = request.getParameter("role");
        User user = new User(username, password, role);
        userRepo.add(user);
        response.sendRedirect(request.getContextPath());
    }
}
