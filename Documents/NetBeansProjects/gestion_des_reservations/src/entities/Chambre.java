package entities;

public class Chambre {
	private int id;
	private String numero;
	private String telephone;
	Categorie categorie;
	//private static int ccham=6;
	

	public Chambre(String numero,String telephone, Categorie categorie) {
		super();
		this.id = id;
		this.numero=numero;
		this.telephone = telephone;
		this.categorie = categorie;
		
	}
	
	public Chambre(int id,String numero, String telephone, Categorie categorie) {
		super();
		this.id = id;
		this.numero=numero;
		this.telephone = telephone;
		this.categorie = categorie;
		
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public String getnumero() {
		return numero;
	}

	public void setnumero(String numero) {
		this.numero = numero;
	}




	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	@Override
	public String toString() {
		return "Chambre [id=" + id + ", telephone=" + telephone + ", categorie=" + categorie +"numero"+numero+ "]";
	}



}
