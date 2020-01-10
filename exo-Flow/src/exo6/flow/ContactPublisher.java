package exo6.flow;

import java.util.concurrent.SubmissionPublisher;
import java.util.concurrent.Flow.Subscriber;
import java.util.logging.Logger;

import exo6.beans.Contact;

public class ContactPublisher extends SubmissionPublisher<Contact> {
	
	private static Logger logger = Logger.getLogger(ContactPublisher.class.getSimpleName());
	
	@Override
	public void subscribe(Subscriber<? super Contact> subscriber) {
		super.subscribe(subscriber);
		logger.info("1 abonné de plus");
	}

}
