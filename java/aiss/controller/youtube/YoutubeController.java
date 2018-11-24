package aiss.controller.youtube;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiss.model.resources.YoutubeResource;
import aiss.youtube.SearchVideos;

public class YoutubeController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private static final Logger log = Logger.getLogger(YoutubeController.class.getName());

	public YoutubeController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String query = request.getParameter("q");
		YoutubeResource youtube = new YoutubeResource();
		log.log(Level.INFO, "Buscando para YouTube vídeos de " + query);
		SearchVideos youtubeResults = youtube.getQ(query);
		request.setAttribute("videos", youtubeResults);
		request.getRequestDispatcher("/successYoutube.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
