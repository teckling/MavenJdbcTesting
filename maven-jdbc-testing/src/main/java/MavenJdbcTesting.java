import java.sql.*;

public class MavenJdbcTesting {

	public static void main(String[] args) throws SQLException {

		Connection myConnection = null;
		Statement myStatement = null;
		ResultSet myResultSet = null;
		
		String dbEndpoint = "jdbc:mysql://localhost:3306/demo?useTimezone=true&serverTimezone=UTC";
		String dbUser = "testuser1";
		String dbPassword = "N0rthropF!^Falcon";
		
		try {
			// 1. Get a connection to database demo
			myConnection = DriverManager.getConnection(dbEndpoint, dbUser , dbPassword);
			
			System.out.println("Database connection successful!\n");
			
			// 2. Create a statement
			myStatement = myConnection.createStatement();
			
			// 2a. Insert a new employee
			// System.out.println("Inserting a new employee");

			// int rowAffected = myStatement.executeUpdate(
			//		"insert into employees " +
			//		"(last_name, first_name, email, department, salary)" +
			//		"values " +
			//		"('Salah', 'Mohamed', 'mo.salah@liverpool.com', 'football', '1000000.00')"
			//		);

			// 2b. Update an employee
			// System.out.println("Update John Doe email");
			// displayEmployee(myConnection, "John", "Doe");
			
			// int rowAffected = myStatement.executeUpdate(
			//		"update employees " +
			//		"set email = 'john.doe@liverpool.com' " +
			//		"where last_name = 'Doe' and firt_name = 'John' ");
			
			// System.out.println("after the update");
			// displayEmployee(myConnection, "John", "Doe");

			// 2c. Delete an employee
			System.out.println("Delete Mo Salah");
			//displayEmployee(myConnection, "John", "Doe");
			
			int rowAffected = myStatement.executeUpdate(
			 	"delete from employees " +
					"where last_name = 'Salah' and first_name = 'Mohamed' ");
			
			System.out.println("after the delete");
			//displayEmployee(myConnection, "John", "Doe");			
			
			// 3. Execute SQL query
			myResultSet = myStatement.executeQuery("select * from employees order by last_name");
			
			// 4. Process the result set
			while (myResultSet.next()) {
				System.out.println(myResultSet.getString("last_name") + ", " + myResultSet.getString("first_name"));
			}
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
		finally {
			if (myResultSet != null) {
				myResultSet.close();
			}
			
			if (myStatement != null) {
				myStatement.close();
			}
			
			if (myConnection != null) {
				myConnection.close();
			}
		}
	}

}
