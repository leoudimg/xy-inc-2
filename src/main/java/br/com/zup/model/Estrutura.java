package br.com.zup.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Classe de persistencia que representa a estrutura do modelo de dados.
 * 
 * @author Leonardo Henrique Lages Pereira 14/01/2017
 *
 */
@Entity
@Table(name = "estrutura")
public class Estrutura implements Serializable {

  /**
   * Serial Version.
   */
  private static final long serialVersionUID = 379006736344778997L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", unique = true, nullable = false)
  private Long id;

  @Column(name = "nome")
  private String nome;

  @ManyToOne
  @JoinColumn(name = "tipo", nullable = false)
  private Tipo tipo;

  @ManyToOne
  @JoinColumn(name = "modelo", nullable = false)
  private Modelo modelo;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public Tipo getTipo() {
    return tipo;
  }

  public void setTipo(Tipo tipo) {
    this.tipo = tipo;
  }

  public Modelo getModelo() {
    return modelo;
  }

  public void setModelo(Modelo modelo) {
    this.modelo = modelo;
  }

}
