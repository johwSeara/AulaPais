package service;

import dao.PaisDAO;
import model.Pais;

public class PaisService {
	
	PaisDAO dao = new PaisDAO();
	
	public long insert(Pais pais) {
		 
		 return dao.insert(pais);
	}
	public void atualizar(String pais, int id) {
		dao.upDateNomePais(pais,id);
	}
	
	public void delete(String pais){
		dao.delete(pais);
	}
	
	public Pais selectPais(int id){
		return dao.selectPais(id);
	}

}


