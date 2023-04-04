import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.io.BufferedReader;
public class EmpData {
private static final String query="insert into Employee values(?,?,?,?,?,?)";
	public static void main(String[] args) {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection c=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system", "123456789");
            PreparedStatement smt=c.prepareStatement(query);
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            
            while(true) {
            	System.out.println("Enter emp id: ");
            	int eno=Integer.parseInt(br.readLine());
            	
            	System.out.println("Enter emp name: ");
            	String ename=br.readLine();
            	
            	System.out.println("Enter emp DoB: ");
            	String dob=br.readLine();
            	
            	System.out.println("Enter emp gender: ");
            	String gender=br.readLine();
            	
            	System.out.println("Enter emp mobile: ");
            	String Mobile=br.readLine();
            	
            	System.out.println("Enter emp city: ");
            	String City=br.readLine();
            	smt.setInt(1, eno);
                smt.setString(2, ename);  
                smt.setString(3, dob);  
                smt.setString(4,gender);  
                smt.setString(5, Mobile);  
                smt.setString(6, City); 
                
                int count = smt.executeUpdate();
                if(count>0) {
                	System.out.println(count + " record inserted.");
                }
                else {
                	System.out.println( "record insertion failed.");
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