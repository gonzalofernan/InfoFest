package aiss.model.resources;

import org.restlet.resource.ClientResource;

public class FacebookPostResource {
	private String uri = "https://graph.facebook.com/me/feed";
	private String access_token = null;
	
	
	public FacebookPostResource(String access_token) {
		this.access_token = access_token;
	}
	
	public boolean publishPost(String message){
		String normalizedMessage=message.replace(' ', '+');
		ClientResource cr=new ClientResource(uri+"?access_token="+access_token);
		cr.post("message="+normalizedMessage);
		return true;
	}
}
