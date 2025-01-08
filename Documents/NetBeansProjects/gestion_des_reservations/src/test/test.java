package test;
import java.util.ArrayList;
import java.util.List;

import entities.Categorie;
import entities.Chambre;
import entities.Client;
import services.categorieservice;
import services.chambreservice;
import services.clientservice;

public class test {

	public static void main(String[] args) {
		chambreservice chambre=new chambreservice();
		Categorie cat=new Categorie("loubna","tanassa");
		Categorie cat2=new Categorie("iii","zzzz");
		
		//Chambre x=new Chambre("0989",cat2);
		//Chambre y=new Chambre("2003",cat);
		//x.setId(1);
		//Chambre g=chambre.findById(1);
		//System.out.println(g.toString());
		
		
		//chambre.create(x);
		//chambre.delete(x);
		//chambre.update(x);
		
		clientservice c=new clientservice();
		//Client cli=new Client("loubna","lounbna","9999","777");	
		//c.create(cli);
		//Client cli2=new Client("  ","  ","23467","2678@23");	
		//Client cli3=new Client("dd","eee","23467","2678@23");
		//cli.setId(1);
		//c.create(cli2);
		//c.create(cli3);
		//c.delete(cli);
		List a=c.findAll();
		a.forEach(nombre -> System.out.println(nombre));
		//c.findAll();
		//System.out.println(a.toString());
		//categorieservice categorie=new categorieservice();
		//Categorie cat=new Categorie("loubna","tanassa");
		//Categorie cat2=new Categorie("iii","zzzz");
	    //categorie.create(cat);
	    //categorie.create(cat2);
		//List a=categorie.findAll();
		//a.forEach(nombre -> System.out.println(nombre));
		//Categorie g=categorie.findById(1);
		//System.out.println(g.toString());
		//List a=categorie.findAll();
		//a.forEach(nombre -> System.out.println(nombre));
		
		
		
		
		
		
		

	}

}
