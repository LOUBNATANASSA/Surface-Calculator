package services;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connexion.Connexion;
import dao.IDAO;
import entities.Categorie;
import entities.Chambre;
import entities.Client;
import entities.Reservation;

public class reservationservice implements IDAO<Reservation> {
    @Override
	public boolean create(Reservation o) {
            String req="insert into reservation (id, datedebut, datefin, id_Chambre,id_Client) values(null,?,?,?,?)";
		try {
		
		PreparedStatement ps=Connexion.getCnx().prepareStatement(req);
                ps.setDate(1,o.getDatedebut());
		ps.setDate(2,o.getDatefin());
		ps.setInt(3,o.getChambre().getId());
                ps.setInt(4,o.getClient().getId());
		
		if(ps.executeUpdate()==1) {
			System.out.println("reservation CREE!");
			
		return true;
		}
		}catch(SQLException e) {
			System.out.println(" chambre ERREUR DE CREATE SQL" +e.getMessage());
		}
        return false;
        }
        
        
        @Override
	public boolean update(Reservation o) {
            String req = "UPDATE reservation SET date_debut=?, date_fin=?, id_client=?, id_chambre=? WHERE id=?";
    
    try {
        PreparedStatement ps = Connexion.getCnx().prepareStatement(req);
        
        // Remplir les paramètres de la requête
        ps.setDate(1, new java.sql.Date(o.getDatedebut().getTime()));
        ps.setDate(2, new java.sql.Date(o.getDatefin().getTime()));
        ps.setInt(3, o.getClient().getId());
        ps.setInt(4, o.getChambre().getId());
        ps.setInt(5, o.getId());

        // Exécuter la requête
        if (ps.executeUpdate() == 1) {
            System.out.println("Mise à jour de la réservation réussie !");
            return true;
        } else {
            System.out.println("Aucune réservation mise à jour. Vérifiez l'ID fourni.");
        }
    } catch (SQLException e) {
        System.out.println("ERREUR SQL lors de la mise à jour de la réservation : " + e.getMessage());
    }
    
        return false;
        }
        
        @Override
	public boolean delete(Reservation o) {
            String req="DELETE FROM reservation where id=?";
		try {
			
			PreparedStatement ps=Connexion.getCnx().prepareStatement(req);
			ps.setInt(1,o.getId());
			if(ps.executeUpdate()==1) {System.out.println("deletion reservation  AFFECTED!");
			return true;}else {System.out.println("AUCUN reservation SUPRESSION");}
		} catch (SQLException e) {
			
			System.out.println("ERREUR SQL "+ e.getMessage());
		}
            return false;
	}
        
        @Override
	public Reservation findById(int id) {
             String req = "SELECT r.id, r.datedebut, r.datefin, " +
	                 "c.id AS chambre_id, c.numero AS chambre_numero, c.telephone AS chambre_telephone, " +
	                 "cat.id AS categorie_id, cat.code AS categorie_code, cat.libelle AS categorie_libelle, " +
	                 "cl.id AS client_id, cl.nom AS client_nom, cl.prenom AS client_prenom, cl.telephone AS client_telephone, cl.email AS client_email, cl.cin AS client_cin " +
	                 "FROM reservation r " +
	                 "JOIN chambre c ON r.id_chambre = c.id " +
	                 "JOIN categorie cat ON c.id_categorie = cat.id " +
	                 "JOIN client cl ON r.id_client = cl.id " +
	                 "WHERE r.id = ?";

	    try (PreparedStatement ps = Connexion.getCnx().prepareStatement(req)) {
	        ps.setInt(1, id);
	        ResultSet rs = ps.executeQuery();

	        if (rs.next()) {
	            // Créer l'objet Categorie
	            Categorie categorie = new Categorie(
	                rs.getInt("categorie_id"),
	                rs.getString("categorie_code"),
	                rs.getString("categorie_libelle")
	            );

	            // Créer l'objet Chambre
	            Chambre chambre = new Chambre(
	                rs.getInt("chambre_id"),
	                rs.getString("chambre_numero"),
	                rs.getString("chambre_telephone"),
	                categorie
	            );

	            // Créer l'objet Client
	            Client client = new Client(
	                rs.getInt("client_id"),
	                rs.getString("client_nom"),
	                rs.getString("client_prenom"),
	                rs.getString("client_telephone"),
	                rs.getString("client_email"),
	                rs.getString("client_cin")
	            );

	            // Créer et retourner l'objet Reservation
	            Reservation reservation = new Reservation(
	                rs.getInt("id"),
	                rs.getDate("datedebut"),
	                rs.getDate("datefin"),
	                chambre,
	                client
	            );

	            System.out.println("Réservation trouvée : " + reservation);
	            return reservation;
	        } else {
	            System.out.println("Aucune réservation trouvée avec l'ID : " + id);
	        }
	    } catch (SQLException e) {
	        System.out.println("ERREUR SQL lors de findById : " + e.getMessage());
	    }

            return null;
	}
        
        @Override
	public List<Reservation> findAll() {
	    List<Reservation> reservations = new ArrayList<>();
	    String req = "SELECT r.id, r.datedebut, r.datefin, r.id_chambre, c.numero AS chambre_numero, c.telephone AS chambre_telephone, " +
	                 "cl.id AS client_id, cl.nom AS client_nom, cl.prenom AS client_prenom, cl.telephone AS client_telephone, " +
	                 "cl.email AS client_email, cl.cin AS client_cin " +
	                 "FROM reservation r " +
	                 "JOIN chambre c ON r.id_chambre = c.id " +
	                 "JOIN client cl ON r.id_client = cl.id";

	    try (PreparedStatement ps = Connexion.getCnx().prepareStatement(req)) {
	        ResultSet rs = ps.executeQuery();
	        while (rs.next()) {
	            // Créer l'objet Chambre
	            Chambre chambre = new Chambre(
	                rs.getInt("id_chambre"),
	                rs.getString("chambre_numero"),
	                rs.getString("chambre_telephone"),
	                null  // Assumons que la catégorie n'est pas nécessaire ici
	            );

	            // Créer l'objet Client
	            Client client = new Client(
	                rs.getInt("client_id"),
	                rs.getString("client_nom"),
	                rs.getString("client_prenom"),
	                rs.getString("client_telephone"),
	                rs.getString("client_email"),
	                rs.getString("client_cin")
	            );

	            // Créer l'objet Reservation
	            Reservation reservation = new Reservation(
	                rs.getInt("id"),
	                rs.getDate("datedebut"),
	                rs.getDate("datefin"),
	                chambre,
	                client
	            );

	            // Ajouter la réservation à la liste
	            reservations.add(reservation);
	        }
	        System.out.println("FINDALL reservations réussi!");
	    } catch (SQLException e) {
	        System.out.println("ERREUR SQL lors de FINDALL reservations: " + e.getMessage());
	    }

	    return reservations;
	}

}
