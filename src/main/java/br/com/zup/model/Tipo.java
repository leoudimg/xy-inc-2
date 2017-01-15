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
 * Classe de persistencia que representa o tipo de dados.
 * 
 * @author Leonardo Henrique Lages Pereira 14/01/2017
 *
 */
@Entity
@Table(name = "tipo")
public class Tipo implements Serializable {

  /**
   * Serial Version.
   */
  private static final long serialVersionUID = 5522489823228706602L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", unique = true, nullable = false)
  private long id;

  @Column(name = "nome")
  private String nome;

  @Column(name = "descricao")
  private String descricao;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "tipo")
  private List<Estrutura> estruturas;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public List<Estrutura> getEstruturas() {
    return estruturas;
  }

  public void setEstruturas(List<Estrutura> estruturas) {
    this.estruturas = estruturas;
  }

}
