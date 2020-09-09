package vn.kase.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.kase.web.jdbc.AbstractJdbcServlet;
import vn.kase.web.pojo.News;

@WebServlet("")
public class HomeServlet extends AbstractJdbcServlet {
	private static final long serialVersionUID = 2301186982595091832L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer key = 1;
		if (req.getParameter("n") != null) {
			key = Integer.parseInt(req.getParameter("n"));
		}

		List<News> news = select(News.class, "SELECT * FROM tb_news WHERE id = ?", key);
		
		if (news.isEmpty()) {
			req.setAttribute("NEW_DETAILS", "There're no content");
		} else {
			req.setAttribute("NEW_DETAILS", news.get(0).getContent());
		}

		List<News> titles = select(News.class, "SELECT id, title FROM tb_news");
		req.setAttribute("NEW_TITLES", titles);

        RequestDispatcher dispatcher = req.getRequestDispatcher("index.jsp");
        dispatcher.forward(req, resp);
    }
}
