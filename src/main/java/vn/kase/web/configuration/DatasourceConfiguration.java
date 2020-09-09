package vn.kase.web.configuration;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.sql.DataSource;

@WebListener
public class DatasourceConfiguration implements ServletContextListener {
    public static final String KEY = "DATASOURCE";

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        try {
            Context context = new InitialContext();

            DataSource ds = (DataSource) context.lookup("java:comp/env/jdbc/junior");
            sce.getServletContext().setAttribute(KEY, ds);
        } catch (NamingException e) {
            throw new RuntimeException("Can't get DataSource", e);
        }
    }
}
