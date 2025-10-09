public class VotingSystem{
public void processVote(String voterId, String candidate) {
 class VoteValidator {
	 boolean validate(String id) {
		 if (id == null) return false;
		 int len = id.length();
		 if (len < 6 || len > 12) return false;
		 for (int i = 0; i < len; i++) {
			 char ch = id.charAt(i);
			 if (!Character.isLetterOrDigit(ch)) return false;
		 }
		 return true;
	 }
 }

 VoteValidator validator = new VoteValidator();
 boolean ok = validator.validate(voterId);
 if (ok) {
	 System.out.println("Vote accepted for candidate '" + candidate + "' by voter " + voterId);
 } else {
	 System.out.println("Invalid voter ID: " + voterId + ". Vote rejected.");
 }
}
public static void main(String[] args) {

 VotingSystem vs = new VotingSystem();
 vs.processVote("VTR123", "Alice");       
 vs.processVote("V@123", "Bob");          
 vs.processVote("12345", "Charlie");       
 vs.processVote("VALIDID9876", "Diana");  
}
}