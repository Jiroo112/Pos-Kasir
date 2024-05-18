package koneksi;

//import com.mysql.cj.jdbc.Driver;
import com.mysql.cj.jdbc.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class konek {
    private static Connection koneksi;
    
    public static Connection GetConnection()throws SQLException{
        if(koneksi==null){
            new Driver();
            
            koneksi=DriverManager.getConnection("jdbc:mysql://localhost:3306/aplikasi_warung", "root", "");
        }
        return koneksi;
    }
}