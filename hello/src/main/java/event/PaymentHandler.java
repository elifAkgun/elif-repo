package event;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.enterprise.event.Observes;
import javax.inject.Inject;

public class PaymentHandler implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	@Inject
	Logger logger;
	
	
	public void creditPayment(@Observes @Credit PaymentEvent event) {
        logger.log(Level.INFO, "PaymentHandler - Credit Handler: {0}",
                event.toString());

        // call a specific Credit handler class...
    }

    public void debitPayment(@Observes @Debit PaymentEvent event) {
        logger.log(Level.INFO, "PaymentHandler - Debit Handler: {0}",
                event.toString());
 
        // call a specific Debit handler class...
    }
	
}
