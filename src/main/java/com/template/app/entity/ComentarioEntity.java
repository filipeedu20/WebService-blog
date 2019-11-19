package com.template.app.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrePersist;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name="COMENTARIO")
@SequenceGenerator(name = "COMENTARIO_ID_GENERATOR", sequenceName = "SE_COMENTARIO", allocationSize = 1)
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)

@NamedQueries({
    @NamedQuery(name="ComentarioEntity.retrieveAll", query="Select distinct c from ComentarioEntity c order by c.data desc")
}) 

public class ComentarioEntity implements IEntity<Long> {

	private static final long serialVersionUID = 1L;
	@Id 
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "COMENTARIO_ID_GENERATOR")	
	private Long id;
	
	@NotNull 
	@Size(min=2, max = 100)
	@Column
	private String comentario;
	
	@Temporal (TemporalType.TIMESTAMP)
	@Column
	private Date data;
	
	@NotNull 
	@Size(min=2, max = 50)
	@Column
	private String nome_pessoa;
	
	
    @ManyToOne (targetEntity = PostagemEntity.class)  
    @JoinColumn(name="POSTAGEM_ID", referencedColumnName="ID")
    @XmlTransient
	private PostagemEntity postagemEntity;

    
    @PrePersist
    protected void novaData() {
		data = new Date();
    }
    
	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	


	public ComentarioEntity(Long id, String comentario, Date data, Long postagemEntity, String nome_pessoa) {
		this.id 			= id;
		this.comentario 	= comentario;
		this.data 			= data;
		this.nome_pessoa	= nome_pessoa;	
	}


	public ComentarioEntity() {}
	
	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	
	public String getNome_pessoa() {
		return nome_pessoa;
	}

	public void setNome_pessoa(String nome_pessoa) {
		this.comentario = nome_pessoa;
	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;		
	}
}
