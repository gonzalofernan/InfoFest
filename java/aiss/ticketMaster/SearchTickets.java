
package aiss.ticketMaster;

import javax.naming.spi.DirStateFactory.Result;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SearchTickets {

    private Result ticket;
   

    public Result getResult() {
        return ticket;
    }

    public void setResult(Result result) {
        this.ticket = result;
    }

}
