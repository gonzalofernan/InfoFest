
package aiss.ticketMaster;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Product {

    private String name;
  
    public String getImageUrl() {
        return name;
    }

    public void setImageUrl(String imageUrl) {
        this.name = imageUrl;
    }

}
