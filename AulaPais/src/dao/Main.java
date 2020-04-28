package dao;
import model.Pais;

public class Main {

	public static void main(String[] args) {
		PaisDAO dao = new PaisDAO(ConnectionBD.conectar());
		Pais pais = new Pais( 0 , "Bolsonaros", 1782764, 21.000);
		
		System.out.println(dao.selectPais(0));
		//dao.delete("Bolsonaros");
		//dao.insert(pais);
		//dao.upDateNomePais("America", 80);
		
	}
}
