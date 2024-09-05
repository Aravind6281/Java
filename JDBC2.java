package ex2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JDBC2 {
    public static void main(String[] args) 
    {
        try{  
                //step1 load the driver class  
                Class.forName("oracle.jdbc.driver.OracleDriver");  
                
                //step2 create  the connection object  
                Connection con=DriverManager.getConnection(  
                "jdbc:oracle:thin:@localhost:1521:xe","Aravind1","Aravind1");  

                String sql = "select * from emp";
                
                //step3 create the statement object  
                PreparedStatement stmt=con.prepareStatement(sql);
                
                //step4 execute query  
                ResultSet rs=stmt.executeQuery();  
                while(rs.next())  
                System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));  
                
                //step5 close the connection object  
                con.close();  
  
}catch(Exception e){ System.out.println(e);}  

        
}
}

