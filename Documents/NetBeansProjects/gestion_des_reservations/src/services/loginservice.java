/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import connexion.Connexion;
import dao.IDAO;
import entities.Login;
/**
 *
 * @author hp
 */
public class loginservice implements IDAO<Login> {
    @Override
	public boolean create(Login o) {
		String req="insert into user values(null,?,?,?)";
		try {
			
		PreparedStatement ps=Connexion.getCnx().prepareStatement(req);
		ps.setString(1,o.getNom());
		ps.setString(2,o.getEmail());
                ps.setString(3,o.getMotDePasse());
		
		if(ps.executeUpdate()==1) {
			System.out.println("user cree!");
		return true;
		}
		}catch(SQLException e) {
			System.out.println("ERREUR DE CREATE SQL");
		}
		return false;
	}

	@Override
	public boolean delete(Login o) {
		
		return false;
	}

	@Override
	public boolean update(Login o) {
		
		return false;
	}

	@Override
	public Login findById(int id) {
		
		return null;
	}

	@Override
	public List<Login> findAll() {
			
		return null;
	}


    
}
