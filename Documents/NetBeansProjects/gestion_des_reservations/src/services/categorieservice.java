package services;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connexion.Connexion;
import dao.IDAO;
import entities.Categorie;
import entities.Client;

public class categorieservice implements IDAO<Categorie> {

	@Override
	public boolean create(Categorie o) {
		String req="insert into categorie values(null,?,?)";
		try {
			
		PreparedStatement ps=Connexion.getCnx().prepareStatement(req);
		ps.setString(1,o.getCode());
		ps.setString(2,o.getLibelle());
		
		if(ps.executeUpdate()==1) {
			System.out.println("categorie cree!");
		return true;
		}
		}catch(SQLException e) {
			System.out.println("ERREUR DE CREATE SQL");
		}
		return false;
	}

	@Override
	public boolean delete(Categorie o) {
		String req="DELETE FROM categorie where id=?";
		try {
			
			PreparedStatement ps=Connexion.getCnx().prepareStatement(req);
			ps.setLong(1,o.getId());
			if(ps.executeUpdate()==1) {System.out.println("deletion categorie AFFECTED!");
			return true;}else {System.out.println("AUCUN SUPRESSION categorie");}
		} catch (SQLException e) {
			
			System.out.println("ERREUR SQL "+ e.getMessage());
		}
		return false;
	}

	@Override
	public boolean update(Categorie o) {
		String req="UPDATE categorie  SET code=?,libelle=? where id=?";	
		try {
			
			PreparedStatement ps=Connexion.getCnx().prepareStatement(req);
			ps.setString(1,o.getCode());
			ps.setString(2,o.getLibelle());
			ps.setInt(3,o.getId());
			
			if(ps.executeUpdate()==1) {
				System.out.println("update categorie AFFECTED!");
			return true;
			}else {
	            System.out.println("Aucune ligne mise à jour a categorie . Vérifiez l'ID fourni.");}
			}catch(SQLException e) {
				System.out.println("ERREUR DE CREATE SQL + "+ e.getMessage());
			}
		return false;
	}

	@Override
	public Categorie findById(int id) {
		String req="SELECT * FROM categorie WHERE id=?";
		try {
			
			PreparedStatement ps=Connexion.getCnx().prepareStatement(req);
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				System.out.println("findbyid affected");
				return new Categorie(rs.getInt(1),rs.getString(2),rs.getString(3));
				
			}else { System.out.println("Aucun categorie trouvé pour l'ID : " + id);}
		} catch (SQLException e) {
			
			System.out.println("ERREUR SQL "+ e.getMessage());
		}
		return null;
	}

	@Override
	public List<Categorie> findAll() {
		List<Categorie> ls=new ArrayList<>();
		String req="SELECT * FROM categorie ";
		try {
			PreparedStatement ps=Connexion.getCnx().prepareStatement(req);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				ls.add(new Categorie(rs.getInt(1),rs.getString(2),rs.getString(3)));
			}
			System.out.println("FINDALL  categories est bien affecte!");
			return ls;
		} catch (SQLException e) {
			
			System.out.println(" ERREUR SQL "+ e.getMessage());
		}		
		return null;
	}

}
