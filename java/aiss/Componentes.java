package aiss;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.ImageIcon;

import com.google.appengine.api.images.Image;

/**
 * Servlet implementation class Componentes
 */
public class Componentes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Componentes() {
        super();
        // TODO Auto-generated constructor stub
     
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<!doctype html>");
        out.println("<html>");
        out.println("<head><title>Componentes</title></head>");
        out.println("<body>");
        out.println("<h1>Componentes del grupo.</h1><p>");
        out.println("<strong><h3>1.Antonio Jesús Díaz Ponce</strong></h3>");
        out.println("<strong><h3>2.Marcelino González Valle</strong></h3>");
        out.println("<strong><h3>3.Fernando López Morato</strong></h3>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
