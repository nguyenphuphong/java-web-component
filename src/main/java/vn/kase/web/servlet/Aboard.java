package vn.kase.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.kase.ws.InformationException_Exception;
import vn.kase.ws.InformationFacade;
import vn.kase.ws.InformationFacadeService;
import vn.kase.ws.InformationListResponse;
import vn.kase.ws.InformationRequest;
import vn.kase.ws.InformationResponse;

@WebServlet(urlPatterns = "/aboard")
public class Aboard extends HttpServlet {
    private static final long serialVersionUID = 3089286192813692502L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        InformationFacadeService service = new InformationFacadeService();
        InformationFacade facade = service.getInformationFacadePort();
        InformationRequest request = new InformationRequest();
        request.setDestination("China");

        try {
            InformationListResponse response = facade.getInformation(request);
            List<InformationResponse> informations = response.getInformations();
            if (informations.isEmpty()) {
                req.setAttribute("INFORMATION_DETAIL", "No Aboarding Information");
            } else {
                if (req.getParameter("n") != null) {
                    int selected = Integer.parseInt(req.getParameter("n"));
                    req.setAttribute("INFORMATION_DETAIL", informations.stream().filter(i -> i.getId() == selected).findFirst().get().getDescription());
                } else {
                    req.setAttribute("INFORMATION_DETAIL", informations.get(0).getDescription());
                }
            }
            req.setAttribute("INFORMATIONS", informations);
        } catch (InformationException_Exception e) {
            e.printStackTrace();
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher("/aboard.jsp");
        dispatcher.forward(req, resp);
    }
}
