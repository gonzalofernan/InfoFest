package aiss.model.resources;

import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

import aiss.model.facebook.FacebookFriends;



public class FacebookFriendsResource {

	private String uri = "https://graph.facebook.com/me/taggable_friends";
	private String access_token = null;
	
	
	public FacebookFriendsResource(String access_token) {
		this.access_token = access_token;
	}
		
	/**
	 * 
	 * @return FacebookFriends
	 */
	public FacebookFriends getFriends() {
		
		ClientResource cr = null;
		FacebookFriends list = null;
		String requestURI=uri + "?access_token=" + access_token;
		try {
			System.out.println(requestURI+ " *********************");			
			cr = new ClientResource(requestURI);
			list = cr.get(FacebookFriends.class);
			
		} catch (ResourceException re) {
			System.err.println("Error when retrieving friends: " + cr.getResponse().getStatus());
			System.err.println(uri + "?access_token=" + access_token);
		}
		
		return list;

	}
}
