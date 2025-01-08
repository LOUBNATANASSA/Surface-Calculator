package connexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import entities.Client;

public class Connexion {
        private static final String url="jdbc:mysql://localhost:3306/reservation";
		private static final String user="root";
		private static final String password="";
		private static Connection cnx=null;
				static {
			try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("pilote charge!");			
			cnx=DriverManager.getConnection(url,"root","");
			System.out.println("Connected!");
			}catch(ClassNotFoundException e) {
				System.out.println("ERREUR DE CHARGEMENT DE PILOT");
			} catch (SQLException e) {
				System.out.println("erreur "+ e);
				e.printStackTrace();
			}
		}
		
		public static Connection getCnx() {
			return cnx;
		}


}
