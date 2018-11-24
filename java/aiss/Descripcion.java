package aiss;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Descripcion
 */
public class Descripcion extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<!doctype html>");
        out.println("<html>");
        out.println("<head><title>Descripción</title></head>");
        out.println("<body>");
        out.println("<h1>Descripción del trabajo.</h1><p>");
        out.println("Lo que pretendemos con InfoFest es crea un MashUp sobre Festivales, que incluye: " +"<br>" );
        out.println("<br><br>"+"<strong>1.Spotify</strong>: proporciona listas de reproducción del festival y su estilo musical ");
        out.println("<br><br>"+"<strong>2.Ticketmaster</strong>: punto de venta oficial para entradas/abonos del festival");
        out.println("<br><br>"+"<strong>3.Google Maps</strong>: dar a los usuarios la localización del festival al que están interesados asistir.");
        
        out.println("</p></body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
