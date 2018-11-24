package aiss.model.resources;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.restlet.resource.ClientResource;

import aiss.ticketMaster.Event;



public class TicketMasterResource  {
	
	private static final String TICKETS_API_KEY = "yx0JugapAvOHzlTM15qnYozKmg2Uk2gi";  //Change this API KEY for your personal Key
	private static final String URL_BASE = "https://app.ticketmaster.com/discovery/v2/events.json?";
	private static final Logger log = Logger.getLogger(TicketMasterResource.class.getName());

//	private String uri = "https://app.ticketmaster.com/discovery/v2/events.json?apikey=yx0JugapAvOHzlTM15qnYozKmg2Uk2gi";
	
	
	public Event getName(String name) throws UnsupportedEncodingException {
//		TicketMasterResource name = new TicketMasterResource();	
//		Event res= name.getName(keyword);
		
//		String keyword1=res.getName();
		
		String searchO = URLEncoder.encode(name, "UTF-8");
		
		String uri = URL_BASE+"apikey="+ TICKETS_API_KEY +"&keyword=" + searchO ;
		log.log(Level.FINE, "OMBd URI: " + uri);
		
		ClientResource cr = new ClientResource(uri); //OBJETO EN JSON
		
		Event getName = cr.get(Event.class); //OBJETO EN JAVA
		
	    return getName;
	}
	
	

	

	

}
