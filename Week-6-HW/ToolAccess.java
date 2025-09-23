class Tool {
	private String privateField = "Private";
	protected String protectedField = "Protected";
	public String publicField = "Public";

	public String getPrivateField() {
		return privateField;
	}
}

class Hammer extends Tool {
	public void testAccess() {
		System.out.println("Protected: " + protectedField);
		System.out.println("Public: " + publicField);
		System.out.println("Private: " + getPrivateField());
	}
}

public class ToolAccess {
	public static void main(String[] args) {
		Hammer hammer = new Hammer();
		hammer.testAccess();
	}
}
