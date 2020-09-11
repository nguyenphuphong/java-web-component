package vn.kase.web.servlet;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

import vn.kase.web.jdbc.AbstractJdbcServlet;
import vn.kase.web.pojo.Attachment;

@WebServlet(urlPatterns = "/admin/attachments/*")
public class AttachmentServlet extends AbstractJdbcServlet {
    private static final long serialVersionUID = -5682612721675139883L;
    private static final Logger LOGGER = Logger.getLogger(AttachmentServlet.class.getName());
    private static final int MAX_FILE_SIZE = 5 * 1024 * 1000;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = 0;
        if (req.getAttribute("ATTACHMENT_NEW_ID") != null) {
            id = (Integer) req.getAttribute("ATTACHMENT_NEW_ID");
        } else {
            id = Integer.parseInt(req.getParameter("n"));
        }

        List<Attachment> attachments = select(Attachment.class, "SELECT id, path FROM tb_attachments WHERE new_id = ?", id);

        req.setAttribute("ATTACHMENTS", attachments);
        req.setAttribute("ATTACHMENT_NEW_ID", id);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/attachment.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DiskFileItemFactory factory = new DiskFileItemFactory();
        factory.setRepository(new File("attachments"));

        ServletFileUpload upload = new ServletFileUpload(factory);

        Integer id = 0;
        try {
            List<String> paths = new ArrayList<>();
            List<FileItem> items = upload.parseRequest(req);
            for (FileItem item : items) {
                if (item.isFormField()) {
                    if ("id".equals(item.getFieldName())) {
                        id = Integer.parseInt(item.getString());
                    }
                }
            }

            for (FileItem item : items) {
                if (!item.isFormField()) {
                    if (item.getSize() > MAX_FILE_SIZE) {
                        req.setAttribute("ATTACHMENT_MESSAGE", "Your size exceed 5MB, actual size ~" + item.getSize() / 1000000 + "MB");
                        throw new FileUploadBase.FileSizeLimitExceededException("Can't upload file", item.getSize(), MAX_FILE_SIZE);
                    }

                    String fileName = item.getName();

                    File attachment = new File("attachments");
                    attachment.mkdir();

                    System.out.println(attachment.getAbsolutePath());

                    File file = new File("attachments" + File.separator + FilenameUtils.getName(fileName));

                    item.write(file);

                    paths.add(file.getAbsolutePath());
                }
            }

            for (String path : paths) {
                persist("INSERT INTO tb_attachments (new_id, path) VALUES (?, ?)", id, path);
            }

            req.setAttribute("ATTACHMENT_MESSAGE", "Upload Successfully");
        } catch (Throwable e) {
            LOGGER.log(Level.SEVERE, "Can't upload file", e);
        }

        req.setAttribute("ATTACHMENT_NEW_ID", id);
        doGet(req, resp);
    }
}
