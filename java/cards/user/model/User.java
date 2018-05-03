package Model;
	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;

	//On ajoute l'anotation @Entity pour indiquer que cette classe représente une entité
	//Elle sera donc liée à une table dans la base de donnée et chacune de ses instances représentera
	//une ligne de cette table.
	@Entity //permet d'encapsuler les données d'une occurrence d'une ou plusieurs tables
	public class User {
		
		// On définit l'attribut id comme étant la clé primaire de cette entité
	    // De plus, on délègue à ObjectDB l'initialisation de cet attribut
		@Id 
		@GeneratedValue(strategy=GenerationType.AUTO) //permet de mapper une clé primaire sur un champ unique.
	    private Integer id;
		private String name;
		private String surname;
		private String password;
		private Integer solde;

		//On créé un constructeur vide qui est obligatoire pour une entité
		public void user() {
			this.name = "";
			this.surname = "";
			this.password="";
			this.solde=0;
		}
		
		public void user( String name,String surname,String password,int solde) {
			this.name = name;
			this.surname=surname;
			this.password=password;
			this.solde=solde;
		}


		public String getName() { // récuperer le nom
			return name;
		}

		public void setName(String name) { // insertion name
			this.name = name;	
		}
		
		public String getSurname() { // //récuperer le prenom
			return surname;
		}

		public void setSurname(String surname) { // insertion prenom
			this.surname = surname;	
		}

		public Integer getId() { //récuperer id
			return id;
		}

		public void setId(Integer id) { // insertion id
			this.id = id;
		}
		
		public String getPassword() { //récuperer id
			return password;
		}

		public void setPassword(String password) { // insertion id
			this.password = password;
		}
		public int getsolde() { // récuperer le solde
			return solde;
		}
		public void setsolde(int solde) { // récuperer le solde
			this.solde=solde;
		}

	}


