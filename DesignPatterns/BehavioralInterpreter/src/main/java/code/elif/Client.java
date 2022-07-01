package code.elif;

public class Client {

	private static final User user = new User("Jane", "ADMIN");
	private static final Report report = new Report("Banking Report", "ADMIN");

	public static void main(String[] args) {

		ExpressionBuilder expressionBuilder =
				new ExpressionBuilder();
		boolean permission = expressionBuilder.build(report).interpret(user);

		System.out.println(permission ? "User has accessed the report..."
				: "Access is denied...");
	}

}
