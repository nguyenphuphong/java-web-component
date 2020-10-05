package vn.kase.web.ejb;

import java.util.Properties;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import vn.kase.web.jdbc.AbstractJdbcServlet;

public class AbstractEjbServlet extends AbstractJdbcServlet {
    private static final long serialVersionUID = -4667550786380523991L;

    protected <B> B getStatelessBean(Class<B> clazz, String name) throws NamingException {
        Properties properties = new Properties();
        properties.put("java.naming.factory.initial", "org.apache.openejb.client.RemoteInitialContextFactory");
        properties.put("java.naming.provider.url", "http://127.0.0.1:9090/tomee/ejb");

        InitialContext context = new InitialContext(properties);
        return (B) context.lookup(name);
    }

    protected <B> B getStatefulBean(Class<B> clazz, String name) throws NamingException {
        B mem = (B) getServletContext().getAttribute(name);
        if (mem != null) {
            return mem;
        }

        Properties properties = new Properties();
        properties.put("java.naming.factory.initial", "org.apache.openejb.client.RemoteInitialContextFactory");
        properties.put("java.naming.provider.url", "http://127.0.0.1:9090/tomee/ejb");

        InitialContext context = new InitialContext(properties);
        B lookup = (B) context.lookup(name);

        getServletContext().setAttribute(name, lookup);

        return lookup;
    }
}
