package vn.kase.web.servlet;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.kase.jee.ejb.ICourseStateful;
import vn.kase.jee.ejb.ICourseStateless;
import vn.kase.jee.ejb.exception.AuthenticationException;
import vn.kase.web.ejb.AbstractEjbServlet;
import vn.kase.web.pojo.Course;

@WebServlet(urlPatterns = { "/student/course" })
public class CourseServlet extends AbstractEjbServlet {
    private static final Logger LOGGER = Logger.getLogger(CourseServlet.class.getName());

    private static final long serialVersionUID = 3050623726398792594L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            ICourseStateless courseBean = getStatelessBean(ICourseStateless.class, "CourseStatelessBeanRemote");
            List<vn.kase.jee.ejb.pojo.Course> seniorCourses = courseBean.getAllCourses();
            for (vn.kase.jee.ejb.pojo.Course course : seniorCourses) {
                if (exist("SELECT 1 FROM tb_courses WHERE link_id = ?", course.getId())) {
                    persist("UPDATE tb_courses SET title = ?, description = ? WHERE link_id = ?", course.getTitle(),
                            course.getDescription(), course.getId());
                } else {
                    persist("INSERT INTO tb_courses (title, description, link_id) VALUES (?, ?, ?)", course.getTitle(),
                            course.getDescription(), course.getId());
                }
            }
        } catch (NamingException e) {
            LOGGER.log(Level.SEVERE, "Can't get bean with name CourseStatelessBean", e);
            req.setAttribute("ERROR_MESSAGE", "Can't get bean with name CourseStatelessBean");
        }

        List<Course> courses = select(Course.class, "SELECT * FROM tb_courses");

        int selected = courses.isEmpty() ? 0 : courses.get(0).getId();

        if (req.getParameter("n") != null) {
            selected = Integer.parseInt(req.getParameter("n"));
        }

        for (Course course : courses) {
            if (course.getId() == selected) {
                req.setAttribute("COURSE_DETAILS", course.getDescription());
                req.setAttribute("COURSE_LINK_ID", course.getLinkId());
            }
        }

        req.setAttribute("COURSES", courses);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/course.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(req.getParameter("id"));

            ICourseStateful course = getStatefulBean(ICourseStateful.class, "CourseStatefulBeanRemote");

            course.authen("nguyenphuphong@gmail.com", "112233");

            course.join(id);

            resp.sendRedirect("/student/course");
        } catch (NamingException | AuthenticationException e) {
            e.printStackTrace();
        }
    }
}
