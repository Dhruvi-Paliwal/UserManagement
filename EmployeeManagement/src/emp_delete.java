import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class emp_delete {

	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection c=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system", "123456789");
            
			Statement s=c.createStatement();
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			while(true)
			{
			System.out.println("enter deletion eid: ");
			int eid=Integer.parseInt(br.readLine());
			int count= s.executeUpdate("delete from Employee where eid="+ eid);
			
			if(count==1) {
				System.out.println(count +" record deleted.");
			}
			
			
			else {
				System.out.println("no record deleted.");
			} 
			
			System.out.println("Do you wanna enter more data[Y/N]: ");
            String ch =br.readLine();
            if(ch.equalsIgnoreCase("N")) {
            	break;
            }
			
			}
	}catch(Exception e) {
		System.out.println(e);
	}

}
}