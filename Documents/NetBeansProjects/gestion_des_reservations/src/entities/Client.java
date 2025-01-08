package entities;

public class Client {
	private int id;
	private String nom;
	private String prenom;
	private String Telephone;
	private String email;
	private String CIN;
	private static int ccli=1;

	public Client(String nom, String prenom, String telephone, String email,String cin) {
		super();
		this.id = ccli++;
		this.nom = nom;
		this.prenom = prenom;
		this.Telephone = telephone;
		this.email = email;
		this.CIN=cin;
		
		
	}
	
	public Client(int id,String nom, String prenom, String telephone, String email,String cin) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.Telephone = telephone;
		this.email = email;
		this.CIN=cin;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getCIN() {
		return CIN;
	}

	public void setCIN(String cin) {
		this.CIN = cin;
	}

	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}



	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getTelephone() {
		return Telephone;
	}

	public void setTelephone(String telephone) {
		Telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", Telephone=" + Telephone + ", email="
				+ email +", CIN"+CIN+ "]";
	}

	
}
