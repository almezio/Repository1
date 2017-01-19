package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TAB_ARTICOLO")
public class Articolo implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	private Long idArticolo;
	private String descArticolo;
	private String prezzoArticolo;
	private Categoria categoria;
	
	public Articolo() {
	}

	public Articolo(String nome,String prezzo) {
		this.descArticolo=nome;
		this.prezzoArticolo=prezzo;
	}
	
	public Articolo(String nome,String prezzo,Categoria categoria) {
		this.descArticolo=nome;
		this.prezzoArticolo=prezzo;
		this.categoria=categoria;
	}
	
	@Id
	@GeneratedValue
	@Column(name = "ID_ARTICOLO", unique = true, nullable = false)
	public Long getIdArticolo() {
		return this.idArticolo;
	}

	public void setIdArticolo(Long idArticolo) {
		this.idArticolo = idArticolo;
	}

	@Column(name = "DESC_ARTICOLO", length = 50)
	public String getDescArticolo() {
		return this.descArticolo;
	}

	public void setDescArticolo(String nome) {
		this.descArticolo = nome;
	}

	@Column(name = "PREZZO_ARTICOLO", length = 5)
	public String getPrezzoArticolo() {
		return this.prezzoArticolo;
	}

	public void setPrezzoArticolo(String prezzo) {
		this.prezzoArticolo = prezzo;
	}
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ID_CATEGORIA", nullable = false)
	public Categoria getCategoria(){
		return this.categoria;
	}
	
	public void setCategoria(Categoria categoria){
		this.categoria=categoria;
	}
}
