package entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Access;
import javax.persistence.AccessType;



@Entity
@Table(name = "TAB_CATEGORIA")
public class Categoria implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private Long idCategoria;
	private String descCategoria;
	private Set<Articolo> articoli;
		
	public Categoria() {
	}

	public Categoria(String nome) {
		this.descCategoria = nome;
	}
	
	@Id
	@GeneratedValue
	@Column(name = "ID_CATEGORIA", unique = true, nullable = false)
	public Long getIdCategoria() {
		return this.idCategoria;
	}
	
	public void setIdCategoria(Long idCategoria) {
		this.idCategoria = idCategoria;
	}

	@Column(name = "NOME_CATEGORIA", length = 50)
	public String getDescCategoria() {
		return this.descCategoria;
	}

	public void setDescCategoria(String nome) {
		this.descCategoria = nome;
	}

	@OneToMany(cascade={CascadeType.ALL})
	@JoinColumn(name="ID_CATEGORIA")
	public Set<Articolo> getArticoli() {
	    return articoli;
	}
	
	public void setArticoli(Set<Articolo> articoli) {
		this.articoli=articoli;
	}
}
