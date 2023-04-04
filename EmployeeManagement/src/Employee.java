import java.sql.Connection;
		import java.sql.DriverManager;
		import java.sql.PreparedStatement;
		import java.sql.SQLException;
		import java.sql.Statement;
public class Employee {

	
		

private static final String query="insert into employee(id,name,email,dob,city,gender,Mobile)values(?,?,?,?,?,?,?)";
			public static void main(String[] args) throws ClassNotFoundException {
				
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection c=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system", "123456789");
					Statement smt=c.createStatement();
					smt.execute("create table Employee(eid number(3),ename varchar(20),DoB date,Gender char(1),Mobile varchar(10),City varchar(20))");
				smt.close();
				System.out.println("Table Created Successfully");
				c.close();
				}catch(Exception e) {
					System.out.println(e);
				}
				
			}
		


	}


