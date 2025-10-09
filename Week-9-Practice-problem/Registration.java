class ContactInfo implements Cloneable { // has String email, String phone
	private String email;
	private String phone;

	public ContactInfo(String email, String phone) {
		this.email = email;
		this.phone = phone;
	}

	public String getEmail() { return email; }
	public void setEmail(String email) { this.email = email; }

	public String getPhone() { return phone; }
	public void setPhone(String phone) { this.phone = phone; }

	@Override
	protected ContactInfo clone() throws CloneNotSupportedException {
		return (ContactInfo) super.clone(); // Strings are immutable; field-by-field copy is fine
	}

	@Override
	public String toString() {
		return "ContactInfo[email=" + email + ", phone=" + phone + "]";
	}
}

class Student implements Cloneable {
	// fields: String id, String name, ContactInfo contact
	private String id;
	private String name;
	private ContactInfo contact;

	public Student(String id, String name, ContactInfo contact) {
		this.id = id;
		this.name = name;
		this.contact = contact;
	}

	public String getId() { return id; }
	public String getName() { return name; }
	public ContactInfo getContact() { return contact; }

	public void setId(String id) { this.id = id; }
	public void setName(String name) { this.name = name; }
	public void setContact(ContactInfo contact) { this.contact = contact; }

	// TODO: Implement shallow and deep copies
	// Shallow copy: copies references as-is (contact reference is shared)
	@Override
	protected Student clone() throws CloneNotSupportedException {
		return (Student) super.clone();
	}

	// Deep copy: also clones nested ContactInfo so copies are independent
	public Student deepClone() throws CloneNotSupportedException {
		Student copy = (Student) super.clone();
		copy.contact = (this.contact != null) ? this.contact.clone() : null;
		return copy;
	}

	@Override
	public String toString() {
		return "Student[id=" + id + ", name=" + name + ", " + contact + "]";
	}
}
public class Registration{
	public static void main(String[] args) throws CloneNotSupportedException {
		// 1. Register student, clone (shallow and deep), change contact, observe results
		Student s1 = new Student(
			"STU001",
			"Anita",
			new ContactInfo("anita@example.com", "+91-9999999999")
		);

		Student shallowCopy = s1.clone();      // shares the same ContactInfo
		Student deepCopy = s1.deepClone();      // has a cloned ContactInfo

		System.out.println("Before change:");
		System.out.println("original    -> " + s1);
		System.out.println("shallowCopy -> " + shallowCopy);
		System.out.println("deepCopy    -> " + deepCopy);

		// Change nested object through original reference
		s1.getContact().setEmail("anita.new@example.com");
		s1.getContact().setPhone("+91-8888888888");

		System.out.println("\nAfter changing original's contact:");
		System.out.println("original    -> " + s1);
		System.out.println("shallowCopy -> " + shallowCopy + "  (changes reflect: shared ContactInfo)");
		System.out.println("deepCopy    -> " + deepCopy + "      (unchanged: independent ContactInfo)");
	}
}