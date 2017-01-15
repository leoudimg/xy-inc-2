package br.com.zup.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Classe de persistencia que representa o modelo de dados.
 * 
 * @author Leonardo Henrique Lages Pereira 14/01/2017
 *
 */
@Entity
@Table(name = "modelo")
public class Modelo implements Serializable {

  /**
   * Serial Version.
   */
  private static final long serialVersionUID = 8435571647000610028L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", unique = true, nullable = false)
  private Long id;

  @Column(name = "nome")
  private String nome;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "modelo")
  private List<Registro> registros;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "modelo")
  private List<Estrutura> estruturas;

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

  public List<Registro> getRegistros() {
    return registros;
  }

  public void setRegistros(List<Registro> registros) {
    this.registros = registros;
  }

  public List<Estrutura> getEstruturas() {
    return estruturas;
  }

  public void setEstruturas(List<Estrutura> estruturas) {
    this.estruturas = estruturas;
  }

}
