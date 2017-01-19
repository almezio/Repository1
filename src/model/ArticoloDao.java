package model;

import java.util.List;

import entities.Articolo;

public interface ArticoloDao {
	public Articolo createArticolo(Articolo articolo);
	public int updateArticolo(Articolo articolo);
	public int deleteArticolo(int idarticolo);
	public List<Articolo> getArticoloFromId(Long idArticolo);	
	public List<Articolo> getArticoliFromCategoria(Long idArticolo);
}
