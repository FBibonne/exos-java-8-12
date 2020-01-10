package exo6.flow;

import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;
import java.util.logging.Logger;

import exo6.beans.Contact;

public class ContactSubscriber implements Subscriber<Contact> {
	
	private static Logger logger = Logger.getLogger(ContactSubscriber.class.getSimpleName());
	private Subscription subscription;
	private int limit;
	
	

	public ContactSubscriber(int limit) {
		this.limit = limit;
	}

	@Override
	public void onSubscribe(Subscription subscription) {
		this.subscription=subscription;
		logger.info("onSubscribe : abonné");
		subscription.request(1L);
		
	}

	@Override
	public void onNext(Contact item) {
		logger.info("onNext "+item);
		limit--;
		if (limit==0) {
			subscription.cancel();
		}else {
			subscription.request(1L);
		}
	}

	@Override
	public void onError(Throwable throwable) {
		logger.severe(throwable.getMessage());
	}

	@Override
	public void onComplete() {
		logger.info("onComplete");
		
	}

	public int getLimit() {
		return limit;
	}

}
