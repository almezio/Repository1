package model;

import java.util.List;
import java.util.Set;

import entities.Articolo;
import entities.Categoria;

public interface CategoriaDao {
	public Categoria createCategoria(Categoria categoria);
	public Categoria createCategConArticoli(Categoria categoria,Set<Articolo> articoli);
	public int updateCategoria(Categoria categoria);
	public int deleteCategoria(int idCategoria);
	public List<Categoria> getCategoriaFromId(Long idArticolo);	
	public List<Categoria> getCategorie();
}
