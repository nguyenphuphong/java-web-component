package vn.kase.web.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vn.kase.web.jdbc.AbstractJdbcServlet;
import vn.kase.web.pojo.Session;
import vn.kase.web.pojo.User;

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends AbstractJdbcServlet {
	private static final long serialVersionUID = 6104345014877799027L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		Integer roleId = Integer.parseInt(req.getParameter("role"));
		
		boolean authorized = false;
		User user = selectOne(User.class, "SELECT id, email FROM tb_users WHERE email = ? AND password = ?", email, password);
		if (user != null) {
			authorized = exist("SELECT 1 FROM tb_user_roles WHERE user_id = ? AND role_id = ?", user.getId(), roleId);
			
			if (authorized) {
				Session session = new Session();
				session.setEmail(email);
				session.setRoleId(roleId);
				
				HttpSession httpSession = req.getSession();
				httpSession.setAttribute("SESSION", session);
				
				resp.sendRedirect("/admin/news");
			}
		}
		
		if (authorized == false) {
			if (user == null) {
				req.setAttribute("LOGIN_MESSAGE", "Your username/password are not matching");
			} else {
				req.setAttribute("LOGIN_MESSAGE", "Your role are not matching");
			}
			RequestDispatcher dispatcher = req.getRequestDispatcher(req.getContextPath()+"/login.jsp");
			dispatcher.forward(req, resp);
		}
	}
}
