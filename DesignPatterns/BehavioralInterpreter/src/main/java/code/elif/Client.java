package code.elif;

public class Client {

	public static void main(String[] args) {
		Report report = new Report("Banking Report", "ADMIN");
		User user = new User("Jane", "ADMIN");

		ExpressionBuilder expressionBuilder =
				new ExpressionBuilder();
		boolean permission = expressionBuilder.build(report).interpret(user);

		System.out.println(permission ? "User has accessed the report..."
				: "Access is denied...");
	}

}
