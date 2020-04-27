package event;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.CompletionStage;
import java.util.logging.Logger;

import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.validation.constraints.Digits;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import lombok.Getter;
import lombok.Setter;


@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON )
@Getter
@Setter
@Path("payment")
public class PaymentRest {
	
	@Inject
    @Credit
    Event<PaymentEvent> creditEvent;

    @Inject
    @Debit
    Event<PaymentEvent> debitEvent;

    
    public static final int DEBIT = 1;
    public static final int CREDIT = 2;
    private int paymentOption = DEBIT;
    
    @Digits(integer = 10, fraction = 2, message = "Invalid value")
    private BigDecimal value;

    private Date datetime;
    
	@Inject
	Logger logger;
	
	@Path("{id}")
	@GET
	public Response  getTodo(@PathParam("id") int id) {
		paymentOption = id;
		pay();
		return Response.ok("Dummy " + id ).build() ;
	}
	
	@Logged
    public String pay() {
        this.setDatetime(Calendar.getInstance().getTime());
        switch (paymentOption) {
            case DEBIT:
                PaymentEvent debitPayload = new PaymentEvent();
                debitPayload.setPaymentType("Debit");
                debitPayload.setValue(value);
                debitPayload.setDatetime(datetime);
                debitEvent.fire(debitPayload);
                
                CompletionStage<PaymentEvent> fireAsync = debitEvent.fireAsync(debitPayload);
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
                System.out.println("Events were called..");
                
                break;
            case CREDIT:
                PaymentEvent creditPayload = new PaymentEvent();
                creditPayload.setPaymentType("Credit");
                creditPayload.setValue(value);
                creditPayload.setDatetime(datetime);
                creditEvent.fire(creditPayload);
                
               
                break;
            default:
                logger.severe("Invalid payment option!");
        }
        return "/response.xhtml";
    }
	
	
	
}
