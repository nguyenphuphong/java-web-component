package vn.kase.web.jdbc;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.sql.DataSource;

import vn.kase.web.configuration.DatasourceConfiguration;

public abstract class AbstractJdbcServlet extends HttpServlet {
    private static final long serialVersionUID = 945966288415022623L;
    private static final Logger LOGGER = Logger.getLogger(AbstractJdbcServlet.class.getName());

    protected Connection con;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        ServletContext context = config.getServletContext();
        DataSource ds = (DataSource) context.getAttribute(DatasourceConfiguration.KEY);

        try {
            con = ds.getConnection();
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Can't open connection", e);
        }
    }

    @Override
    public void destroy() {
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                LOGGER.log(Level.SEVERE, "Can't close connection", e);
            }
        }
    }

    protected <T> List<T> select(Class<T> clazz, String query, Object... params) {
        try {
            PreparedStatement stmt = buildPreparedStatement(query, params);

            ResultSet rs = stmt.executeQuery();

            return convertResultSet(rs, clazz);
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Can't execute query: " + query, e);
            throw new RuntimeException("Can't execute query: " + query, e);
        }
    }

    private <T> List<T> convertResultSet(ResultSet rs, Class<T> clazz) {
        try {
            Map<String, Field> fieldMap = new HashMap<>();

            ResultSetMetaData md = rs.getMetaData();
            for (int i = 0; i < md.getColumnCount(); i++) {
                String name = md.getColumnName(i + 1).toLowerCase();
                
                Field field = clazz.getDeclaredField(name);
                field.setAccessible(true);
                fieldMap.put(name, field);
            }

            List<T> result = new ArrayList<>();
            while (rs.next()) {
                T t = clazz.getDeclaredConstructor().newInstance();
                for (Entry<String, Field> entry : fieldMap.entrySet()) {
                    Field field = entry.getValue();
                    field.set(t, rs.getObject(entry.getKey()));
                }

                result.add(t);
            }

            return result;
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
                | NoSuchMethodException | SecurityException | SQLException | NoSuchFieldException e) {
            LOGGER.log(Level.SEVERE, "Can't mapping result set", e);
            throw new RuntimeException("Can't mapping result set", e);
        }
    }

    private PreparedStatement buildPreparedStatement(String query, Object... params) throws SQLException {
        PreparedStatement stmt = con.prepareStatement(query);

        if (params != null && params.length > 0) {
            for (int i = 0; i < params.length; i++) {
                if (params[i] instanceof Integer) {
                    stmt.setInt(i + 1, (Integer) params[i]);
                } else if (params[i] instanceof String) {
                    stmt.setString(i + 1, (String) params[i]);
                }
            }
        }

        return stmt;
    }
}
