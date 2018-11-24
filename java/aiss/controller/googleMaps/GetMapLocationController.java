package aiss.controller.googleMaps;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SearchController
 */
public class GetMapLocationController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final Logger log = Logger.getLogger(GetMapLocationController.class.getName());

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetMapLocationController() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String origen = req.getParameter("origen");
		String destino = req.getParameter("destino");
		String modo = req.getParameter("modo");

		req.setAttribute("origen", origen);
		req.setAttribute("destino", destino);
		req.setAttribute("modo", modo);
		log.warning(origen);

		req.getRequestDispatcher("/successMaps.jsp").forward(req, resp);

	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
