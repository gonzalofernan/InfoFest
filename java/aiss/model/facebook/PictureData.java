package aiss.model.facebook;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



@JsonIgnoreProperties(ignoreUnknown=true)
public class PictureData implements Serializable{
	private Boolean is_silhouette;
	private String url;
	private int height;	
	private int width;
	
	public Boolean getIs_silhouette() {
		return is_silhouette;
	}
	public void setIs_silhouette(Boolean is_silhouette) {
		this.is_silhouette = is_silhouette;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	
}
