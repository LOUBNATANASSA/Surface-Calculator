package entities;

import java.sql.Date;

public class Reservation {
        private int id;
	private Date datedebut;
	private Date datefin;
	Chambre chambre;
	Client client;
        
        public Reservation() {
    // Constructeur par défaut vide
}

	public Reservation(int id,Date datedebut, Date datefin, Chambre chambre, Client client) {
		super();
                this.id = id;
		this.datedebut = datedebut;
		this.datefin = datefin;
		this.chambre = chambre;
		this.client = client;
	}
        public Reservation(Date datedebut, Date datefin, Chambre chambre, Client client) {
		super();
                this.id = id;
		this.datedebut = datedebut;
		this.datefin = datefin;
		this.chambre = chambre;
		this.client = client;
	}

	public Date getDatedebut() {
		return datedebut;
	}

	public void setDatedebut(Date datedebut) {
		this.datedebut = datedebut;
	}

	public Date getDatefin() {
		return datefin;
	}

	public void setDatefin(Date datefin) {
		this.datefin = datefin;
	}
        
        public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Chambre getChambre() {
		return chambre;
	}

	public void setChambre(Chambre chambre) {
		this.chambre = chambre;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	@Override
	public String toString() {
		return "Reservation [datedebut=" + datedebut + ", datefin=" + datefin + ", chambre=" + chambre + ", client="
				+ client + "]";
	}


}
