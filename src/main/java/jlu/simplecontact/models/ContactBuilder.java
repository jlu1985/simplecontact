package jlu.simplecontact.models;

public class ContactBuilder {

	private long id = -1;
	private String personName ="";
	private String phoneNumber ="";
	private String email = "";
	
	public static ContactBuilder newInstance(){
		return new ContactBuilder();
	}
	
	public ContactBuilder id(long id){
		this.id=id;
		return this;
	}
	
	public ContactBuilder name(String name){
		this.personName=name;
		return this;
	}
	public ContactBuilder email(String email){
		this.email=email;
		return this;
	}
	
	public ContactBuilder phone(String number){
		this.phoneNumber=number;
		return this;
	}
	
	public Contact build(){
		Contact c = new Contact();
		c.setContactId(id);
		c.setEmail(email);
		c.setPersonName(personName);
		c.setPhoneNumber(phoneNumber);
		return c;
		
	}
	
}
