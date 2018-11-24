package aiss.controller.facebook;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiss.model.facebook.FacebookFriends;
import aiss.model.resources.FacebookFriendsResource;

public class FacebookFriendsController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6818025976353856770L;
	private static final Logger log = Logger.getLogger(FacebookFriendsController.class.getName());

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException,ServletException {
		String accessToken = (String) req.getSession().getAttribute("Facebook-token");
		if(accessToken!=null && !"".equals(accessToken)) {
			FacebookFriendsResource fbResource=new FacebookFriendsResource(accessToken);
			FacebookFriends fbFriends = fbResource.getFriends();
			req.setAttribute("friends", fbFriends);
			req.getRequestDispatcher("/FacebookFriendsView.jsp").forward(req, resp);
			
		}else {
			log.info("Intendando acceder a Facebook sin un token de acceso, redirigiendo al OAuth servlet");
			req.getRequestDispatcher("/FacebookFriendsView.jsp").forward(req, resp);
		}
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		doGet(req,resp);
	}


}
