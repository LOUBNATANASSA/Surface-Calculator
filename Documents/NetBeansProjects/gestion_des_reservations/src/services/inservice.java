
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import connexion.Connexion;
/**
 *
 * @author hp
 */
public class inservice {
    public boolean select(String em ,String p) {
		String req="select * from user where email=em and password=p";
		try {
			
		PreparedStatement ps=Connexion.getCnx().prepareStatement(req);
		
		
		if(ps.executeUpdate()==1) {
			System.out.println("selection cree!");
		return true;
		}
		}catch(SQLException e) {
			System.out.println("ERREUR DE CREATE SQL");
		}
		return false;
	}
    
}
