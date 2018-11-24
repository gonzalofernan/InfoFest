package aiss.model.resources;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

import aiss.youtube.SearchVideos;

public class YoutubeResource {

	private static final Logger log = Logger.getLogger(YoutubeResource.class.getName());

	private static final String APIKEY = "AIzaSyCD0K8FoW6Mvd8wjNwaDQBXlf4ffO2Tq4c";
	private static final String URL_YOUTUBE = "https://www.googleapis.com/youtube/v3/search?part=id&maxResults=10&q=%QUERY&type=video&key=%APIKEY";

	public SearchVideos getQ(String q) throws UnsupportedEncodingException {
		String query = URLEncoder.encode(q, "UTF-8");
		ClientResource cr = null;
		SearchVideos res = null;
		try {
			cr = new ClientResource(URL_YOUTUBE.replace("%QUERY", query).replace("%APIKEY", APIKEY));
			res = cr.get(SearchVideos.class);
			log.log(Level.FINE, "Búsqueda de vídeos de " + query + " realizada correctamente.");
		} catch (ResourceException e) {
			log.log(Level.WARNING, "Error al obtener los vídeos: " + cr.getResponse().getStatus());
			throw e;
		}
		return res;
	}
}