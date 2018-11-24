package aiss.model.facebook;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Picture implements Serializable{
	private PictureData data;

	public PictureData getData() {
		return data;
	}

	public void setData(PictureData data) {
		this.data = data;
	}
}
