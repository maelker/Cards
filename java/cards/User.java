package Model;
	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;

	//On ajoute l'anotation @Entity pour indiquer que cette classe repr�sente une entit�
	//Elle sera donc li�e � une table dans la base de donn�e et chacune de ses instances repr�sentera
	//une ligne de cette table.
	@Entity //permet d'encapsuler les donn�es d'une occurrence d'une ou plusieurs tables
	public class User {
		
		// On d�finit l'attribut id comme �tant la cl� primaire de cette entit�
	    // De plus, on d�l�gue � ObjectDB l'initialisation de cet attribut
		@Id 
		@GeneratedValue(strategy=GenerationType.AUTO) //permet de mapper une cl� primaire sur un champ unique.
	    private Integer id;
		private String name;
		private String surname;
		private String password;
		private Integer solde;

		//On cr�� un constructeur vide qui est obligatoire pour une entit�
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


		public String getName() { // r�cuperer le nom
			return name;
		}

		public void setName(String name) { // insertion name
			this.name = name;	
		}
		
		public String getSurname() { // //r�cuperer le prenom
			return surname;
		}

		public void setSurname(String surname) { // insertion prenom
			this.surname = surname;	
		}

		public Integer getId() { //r�cuperer id
			return id;
		}

		public void setId(Integer id) { // insertion id
			this.id = id;
		}
		
		public String getPassword() { //r�cuperer id
			return password;
		}

		public void setPassword(String password) { // insertion id
			this.password = password;
		}
		public int getsolde() { // r�cuperer le solde
			return solde;
		}
		public void setsolde(int solde) { // r�cuperer le solde
			this.solde=solde;
		}

	}


