package vn.kase.web.servlet;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;

import vn.kase.web.jdbc.AbstractJdbcServlet;
import vn.kase.web.pojo.Attachment;

@WebServlet(urlPatterns = "/admin/attachment/download")
public class DownloadServlet extends AbstractJdbcServlet {
    private static final long serialVersionUID = -128797513427191375L;
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.parseInt(req.getParameter("a"));

        Attachment attachment = selectOne(Attachment.class, "SELECT id, path FROM tb_attachments WHERE id = ?", id);

        byte[] data = FileUtils.readFileToByteArray(new File(attachment.getPath()));
        
        resp.setContentType("application/octet-stream");
        resp.setHeader("Content-disposition", "attachment; filename=" + attachment.getFilename());
        resp.setContentLength(data.length);
        InputStream is = new BufferedInputStream(new ByteArrayInputStream(data));

        OutputStream os = resp.getOutputStream();
        byte[] buffer = new byte[4096];
        int bytesRead = -1;
        while ((bytesRead = is.read(buffer)) != -1) {
            os.write(buffer, 0, bytesRead);
        }
        is.close();
        os.close();
    }
}
