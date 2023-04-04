import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class emp_Detail {

	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection c=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system", "123456789");
            
			Statement s=c.createStatement();
			ResultSet r=s.executeQuery("Select * from Employee");
			while(r.next()) {
				int eid = r.getInt(1);
				String ename = r.getString(2);
				String dob = r.getString(3);
				String gender =r.getString(4);
				String mobile = r.getString(5);
				String city=r.getString(6);
				System.out.println("Eid: "+eid+"\nEname: "+ename +"\nDob: " +dob + "\nGender: " +gender+ "\nCity: "+city+"\nMobile: "+ mobile);
			     System.out.println("");}
			
	}catch(Exception e) {
		System.out.println(e);
	}

}
}