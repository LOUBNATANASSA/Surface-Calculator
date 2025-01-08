package services;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import connexion.Connexion;
import dao.IDAO;
import entities.Categorie;
import entities.Chambre;
import entities.Client;
import java.util.ArrayList;

public class chambreservice implements IDAO<Chambre> {

	@Override
	public boolean create(Chambre o) {
		String req="insert into chambre (id, numero, telephone, id_categorie) values(null,?,?,?)";
		try {
		
		PreparedStatement ps=Connexion.getCnx().prepareStatement(req);
                ps.setString(1,o.getnumero());
		ps.setString(2,o.getTelephone());
		ps.setInt(3,o.getCategorie().getId());
		
		if(ps.executeUpdate()==1) {
			System.out.println("CHAMBRE CREE!");
			
		return true;
		}
		}catch(SQLException e) {
			System.out.println(" chambre ERREUR DE CREATE SQL" +e.getMessage());
		}
		return false;
	}

	@Override
	public boolean delete(Chambre o) {
		String req="DELETE FROM chambre where id=?";
		try {
			
			PreparedStatement ps=Connexion.getCnx().prepareStatement(req);
			ps.setInt(1,o.getId());
			if(ps.executeUpdate()==1) {System.out.println("deletion chambre  AFFECTED!");
			return true;}else {System.out.println("AUCUN chambre SUPRESSION");}
		} catch (SQLException e) {
			
			System.out.println("ERREUR SQL "+ e.getMessage());
		}
		
		return false;
	}

	@Override
	public boolean update(Chambre o) {
	    String req = "UPDATE chambre SET numero=?, telephone=?, id_categorie=? WHERE id=?";
	    try {
	        PreparedStatement ps = Connexion.getCnx().prepareStatement(req);
	        ps.setString(1, o.getnumero());
	        ps.setString(2, o.getTelephone());
	        ps.setInt(3, o.getCategorie().getId());
	        ps.setInt(4, o.getId());

	        if (ps.executeUpdate() == 1) {
	            System.out.println("update chambre AFFECTED!");
	            return true;
	        } else {
	            System.out.println("Aucune ligne chambre mise à jour. Vérifiez l'ID fourni.");
	        }
	    } catch (SQLException e) {
	        System.out.println("chambre ERREUR DE update SQL + " + e.getMessage());
	    }
	    return false;
	}
	@Override
	public Chambre findById(int id) {
		    String req = "SELECT c.id, c.numero, c.telephone, cat.id AS cat_id, cat.code, cat.libelle " +
                 "FROM chambre c JOIN categorie cat ON c.id_categorie = cat.id WHERE c.id = ?";

    try (PreparedStatement ps = Connexion.getCnx().prepareStatement(req)) {
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            // Créer l'objet Categorie
            Categorie categorie = new Categorie(
                rs.getInt("cat_id"),
                rs.getString("code"),
                rs.getString("libelle")
            );

            // Créer et retourner l'objet Chambre
            Chambre chambre = new Chambre(
                rs.getInt("id"),
                rs.getString("numero"),
                rs.getString("telephone"),
                categorie
            );

            System.out.println("Chambre trouvée : " + chambre);
            return chambre;
        } else {
            System.out.println("Aucune chambre trouvée avec l'ID : " + id);
        }
    } catch (SQLException e) {
        System.out.println("ERREUR SQL lors de findById : " + e.getMessage());
    }
		
		return null;
	}

	@Override
	public List<Chambre> findAll() {
		    List<Chambre> chambres = new ArrayList<>();
                 String req = "SELECT c.id, c.numero, c.telephone, cat.id AS cat_id, cat.code, cat.libelle " +
                 "FROM chambre c JOIN categorie cat ON c.id_categorie = cat.id";

             try (PreparedStatement ps = Connexion.getCnx().prepareStatement(req)) {
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            // Créer l'objet Categorie
            Categorie categorie = new Categorie(
                rs.getInt("cat_id"),
                rs.getString("code"),
                rs.getString("libelle")
            );

            // Créer l'objet Chambre
            Chambre chambre = new Chambre(
                rs.getInt("id"),
                rs.getString("numero"),
                rs.getString("telephone"),
                categorie
            );

            // Ajouter la chambre à la liste
            chambres.add(chambre);
        }
        System.out.println("FINDALL chambres réussi!");
    } catch (SQLException e) {
        System.out.println("ERREUR SQL lors de FINDALL chambres: " + e.getMessage());
    }

    return chambres;
	}

}
