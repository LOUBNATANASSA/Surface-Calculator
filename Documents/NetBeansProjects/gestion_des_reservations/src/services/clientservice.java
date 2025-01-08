package services;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connexion.Connexion;
import dao.IDAO;
import entities.Client;

public class clientservice implements IDAO<Client> {

	@Override
	public boolean create(Client o) {
		String req="insert into client values(null,?,?,?,?,?)";
		try {
			PreparedStatement ps=Connexion.getCnx().prepareStatement(req);
			ps.setString(1, o.getNom());
			ps.setString(2, o.getPrenom());
			ps.setString(3, o.getTelephone());
			ps.setString(4, o.getEmail());
			ps.setString(5, o.getCIN());
			if(ps.executeUpdate()==1) {
				return true;
			}
		} catch (SQLException e) {
			System.out.println("Erreur de create SQL");
		}
		return false;
	}

	@Override
	public boolean update(Client o) {
		String req="update client set nom=?,prenom=?,telephone=?,email=?,cin=? where id=?";
		try {
			PreparedStatement ps = Connexion.getCnx().prepareStatement(req);
			ps.setString(1,o.getNom());
			ps.setString(2, o.getPrenom());
			ps.setString(3, o.getTelephone());
			ps.setString(4, o.getEmail());
			ps.setString(4, o.getCIN());
			ps.setInt(5, o.getId());
			if(ps.executeUpdate()==1) {
				return true;
			}
			
		} catch (SQLException e) {
			System.out.println("Erreur update SQL");
		}
			return false;
	}

	@Override
	public boolean delete(Client o) {
			String req="DELETE FROM client where id=?";
		try {
			
			PreparedStatement ps=Connexion.getCnx().prepareStatement(req);
			ps.setInt(1,o.getId());
			if(ps.executeUpdate()==1) {System.out.println("deletion client  AFFECTED!");
			return true;}else {System.out.println("AUCUN client SUPRESSION");}
		} catch (SQLException e) {
			
			System.out.println("ERREUR SQL "+ e.getMessage());
		}
		return false;
	}

	@Override
	public Client findById(int id) {
		
		String req="SELECT * FROM client WHERE id=?";
		try {
			
			PreparedStatement ps=Connexion.getCnx().prepareStatement(req);
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				System.out.println("findbyid affected");
				return new Client(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));
				
			}else { System.out.println("Aucun client trouvé pour l'ID : " + id);}
		} catch (SQLException e) {
			
			System.out.println("ERREUR SQL "+ e.getMessage());
		}
		return null;
	}

	@Override
	public List<Client> findAll() {
		List<Client> ls=new ArrayList<>();
		String req="SELECT * FROM client ";
		try {
			PreparedStatement ps=Connexion.getCnx().prepareStatement(req);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				ls.add(new Client(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6)));
			}
			System.out.println("FINDALL est bien affecte en client!");
			return ls;
		} catch (SQLException e) {
			
			System.out.println(" ERREUR SQL "+ e.getMessage());
		}
		return null;
	}

	

	

}
