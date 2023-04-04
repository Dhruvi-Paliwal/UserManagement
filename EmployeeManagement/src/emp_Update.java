import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class emp_Update {

	public static void main(String[] args) {
		String value,mobile; int eid; 
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection c=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system", "123456789");
            
			Statement s=c.createStatement();
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			
			System.out.println("Enter Eid:");
			value=br.readLine();
			eid=Integer.parseInt(value);
			
			System.out.println("enter new Mobile number: ");
		     mobile=br.readLine();
		     
		     int count= s.executeUpdate("update Employee set Mobile= "+ mobile+" where eid = "+ eid);
		     if(count==1) {
		    	 System.out.println(count + "record updated");
		     }
		     else {
		    	 System.out.println("no record updated");
		     }
	}catch(Exception e) {
		System.out.println(e);
	}

}
}