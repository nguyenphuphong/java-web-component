package vn.kase.web.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.kase.web.jdbc.AbstractJdbcServlet;
import vn.kase.web.pojo.News;

@WebServlet(urlPatterns = "/admin/news/*")
public class NewsServlet extends AbstractJdbcServlet {
    private static final long serialVersionUID = 1L;
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        News news = new News();
        news.setId(0);
        switch(req.getRequestURI()) {
            case "/admin/news/edit":
                news = selectOne(News.class, "SELECT * FROM tb_news WHERE id = ?", Integer.parseInt(req.getParameter("n")));
                break;
        }
        
        req.setAttribute("NEWS", news);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/news.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title = req.getParameter("title");
        String content = req.getParameter("content");
        
        if ("0".equals(req.getParameter("id"))) {
            persist("INSERT INTO tb_news (title, content) VALUES (?, ?)", title, content);
        } else {
            persist("UPDATE tb_news SET title = ?, content = ? WHERE id = ?", title, content, Integer.parseInt(req.getParameter("id")));
        }

        resp.sendRedirect("/");
    }
}
