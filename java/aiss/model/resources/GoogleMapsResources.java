package aiss.model.resources;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.restlet.resource.ClientResource;

import maps.Googlemaps;

public class GoogleMapsResources {

	private static final String MAPS_API_KEY = "AIzaSyCUBjtxTsQMupCfOSItrKkJG9XX9AKNtnw";  //Change this API KEY for your personal Key
	private static final Logger log = Logger.getLogger(GoogleMapsResources.class.getName());
	private static final String URL_BASE = "https://maps.googleapis.com/maps/api/directions/json?";
	
	public Googlemaps getRoutes11(String origen, String destino) throws UnsupportedEncodingException {
		GoogleMapsResources ruta = new GoogleMapsResources();
		Googlemaps res = ruta.getRoutes11(origen, destino);
		
		String origen1= res.getGeocodedWaypoints().get(0).getPlaceId();
		String destino1= res.getGeocodedWaypoints().get(0).getPlaceId();
		
		String searchO = URLEncoder.encode(origen1, "UTF-8");
		String searchD = URLEncoder.encode(destino1, "UTF-8");
		String uri = URL_BASE +"origin=" + searchO + "&destination=" + searchD + "&key=" + MAPS_API_KEY;
		log.log(Level.FINE, "OMBd URI: " + uri);
		
		ClientResource cr = new ClientResource(uri); //OBJETO EN JSON
		
		Googlemaps getRoutes = cr.get(Googlemaps.class); //OBJETO EN JAVA
		
	    return getRoutes;
	}
	

}
