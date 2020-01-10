package exo6;

import java.util.List;

import exo6.beans.Contact;
import exo6.beans.ContactHelper;
import exo6.flow.ContactPublisher;
import exo6.flow.ContactSubscriber;

public class AppMain {
	
	private static final ContactPublisher publisher= new ContactPublisher();;
	private static List<Contact> contacts;
	private static ContactSubscriber subscriber;
	

	public static void main(String[] args) throws InterruptedException {
		constructPipeLine();
		runPipeLine();
	}

	private static void runPipeLine() throws InterruptedException {
		try (publisher) {
			contacts.forEach(publisher::submit);
			while(subscriber.getLimit()>0) {
					Thread.sleep(500);
			}
		}

	}

	private static void constructPipeLine() {
		contacts = ContactHelper.getContacts();
		subscriber = new ContactSubscriber(3);
		publisher.subscribe(subscriber);
	}

}
