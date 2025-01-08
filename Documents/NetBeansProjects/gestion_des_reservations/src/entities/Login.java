package entities;

public class Login {
	private int id;
	private String Nom;
	private String Email;
        private String MotDePasse;
	private static int ccat=1;
	
	public  Login() {}

	public Login(String nom, String email,String motdepasse) {
		super();
		this.id = ccat++;
		this.Nom = nom;
		this.Email = email;
                this.MotDePasse = motdepasse;
		
	}
	
	public Login(int id, String nom, String email,String motdepasse) {
		super();
		this.id =id;
		this.Nom = nom;
		this.Email = email;
                this.MotDePasse = motdepasse;
		
	}

	public int getId() {
		return id;}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return Nom;
	}

	public void setNom(String nom) {
		this.Nom = nom;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		this.Email = email;
	}
        
        public String getMotDePasse() {
		return MotDePasse;
	}

	public void setLibelle(String motpass) {
		this.MotDePasse= motpass;
	}

	@Override
	public String toString() {
		return "Login [id=" + id + ", nom=" + Nom + ", email=" + Email +", mot de passe=" + MotDePasse + "]";
	}
	
	
	

	
}
