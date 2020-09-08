package vn.kase.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("")
public class HomeServlet extends HttpServlet {
    private static final long serialVersionUID = 2301186982595091832L;

    private Map<String, String> news = new HashMap<>();

    @Override
    public void init() throws ServletException {
        String new1 = "" +
            "<p><u>Why should choose Greenwich University?</u></p>" +
			"<p>" +
				"The United Kingdom's educational system is famous for it's strict standards which exist to ensure it's" +
				"professionality, practicality, and to help students adapt to the ever-demanding and changing needs of" +
				"many professions nowadays. When choosing to enroll at the Vietnam Greenwich University, students will" +
				"have the chance to get the best of what the UK's educational system has to offer; and when they" +
				"graduate, they will receive the Bachelor's degree issued by the Greenwich University" +
			"</p>" +
			"<p>" +
				"During their time studying at the University of Greenwich in Vietnam, the students will have the" +
				"opportunity to experience different educational environments outside of Vietnam through many student" +
				"exchange, internship, conference programs,… such as:" +
			"</p>" +
			"<ul>" +
				"<li>The English program in Philippines, Malaysia, Singapore,…</li>" +
				"<li>The chance to experience studying your major at the United Kingdom’s Greenwich University</li>" +
				"<li>The chance to experience the native life and culture of different countries</li>" +
            "</ul>";
		news.put("1", new1);
		
		String new2 = "" +
			"<p><u>Top 10 students in 09/2020.</u></p>" +
			"<ul>" +
				"<li><u>&nbsp;1:</u> Carl Friedrich Gauss</li>" +
				"<li><u>&nbsp;2:</u> Leonhard Euler</li>" +
				"<li><u>&nbsp;3:</u> Isaac Newton</li>" +
				"<li><u>&nbsp;4:</u> Srinivasa Ramanujan</li>" +
				"<li><u>&nbsp;5:</u> Pierre de Fermat</li>" +
				"<li><u>&nbsp;6:</u> Gottfried Wilhelm Leibniz</li>" +
				"<li><u>&nbsp;7:</u> Albert Einstein</li>" +
				"<li><u>&nbsp;8:</u> Pythagoras</li>" +
				"<li><u>&nbsp;9:</u> Rene Descartes</li>" +
				"<li><u>10:</u> Aryabhata</li>" +
			"</ul>";
		news.put("2", new2);

		String new3 = "" +
			"<p><u>The way to increase your English skill.</u></p>" +
			"<p>" +
				"If English isn't your first language, you might find you need to take an English language proficiency exam such" +
				"as the IELTS or the TOEFL as part of your application to study abroad. These tests may seem straightforward, but" +
				"learning to write and speak in a sophisticated and eloquent manner in a new language doesn't come easily. In" +
				"order to succeed, you'll need to put a lot of continuous effort into learning a new language, but there are some" +
				"quick fixes that can help to boost your test performance at short notice." +
			"</p>" +
			"<p>" +
				"If the exam is just a few weeks away, here are some ways to quickly improve your English language skills." +
			"</p>" +
			"<ul>" +
				"<li>Watch movies in English</li>" +
				"<li>Immerse yourself in English language news</li>" +
				"<li>Start a vocabulary book of useful words</li>" +
				"<li>Have conversations in English</li>" +
				"<li>Practice, practice, practice</li>" +
				"<li>Curiosity doesn’t always kill the cat</li>" +
				"<li>Don’t forget to have fun while you learn</li>" +
			"</ul>";
		news.put("3", new3);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String key = req.getParameter("n");
		if (key == null || !news.containsKey(key)) {
			key = "1";
		}

        req.setAttribute("NEW_DETAILS", news.get(key));

        RequestDispatcher dispatcher = req.getRequestDispatcher("index.jsp");
        dispatcher.forward(req, resp);
    }
}
