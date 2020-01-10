package exo6.beans;

import java.util.List;

public interface ContactHelper {
	
	public static List<Contact> getContacts(){
		return List.of(
				new Contact(1, "Touille", "Sacha"),
				new Contact(2, "Homme", "Maxime"),
				new Contact(3, "Tartines", "Kimberlee"),
				new Contact(3, "Versaire", "Annie")
			);
	}
	

}
