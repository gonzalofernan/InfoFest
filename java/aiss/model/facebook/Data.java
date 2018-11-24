
package aiss.model.facebook;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


 
@JsonIgnoreProperties(ignoreUnknown = true)
public class Data implements Serializable{
   	/**
	 * 
	 */
	private static final long serialVersionUID = 3820070247061889050L;
	private String id;
   	private String name;
    private Picture picture;
    
 	public String getId(){
		return this.id;
	}
	public void setId(String id){
		this.id = id;
	}
 	public String getName(){
		return this.name;
	}
	public void setName(String name){
		this.name = name;
	}
	public Picture getPicture() {
		return picture;
	}
	public void setPicture(Picture picture) {
		this.picture = picture;
	}
}
