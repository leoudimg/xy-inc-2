package br.com.zup.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Classe de persistencia que representa o registro do modelo de dados.
 * 
 * @author Leonardo Henrique Lages Pereira 14/01/2017
 *
 */
@Entity
@Table(name = "registro")
public class Registro implements Serializable {

  /**
   * Serial Version.
   */
  private static final long serialVersionUID = -6222642258807298386L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", unique = true, nullable = false)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "modelo", nullable = false)
  private Modelo modelo;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "registro")
  private List<RegistroTipoText> registroTipoText;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "registro")
  private List<RegistroTipoString> registroTipoString;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "registro")
  private List<RegistroTipoDecimal> registroTipoDecimal;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Modelo getModelo() {
    return modelo;
  }

  public void setModelo(Modelo modelo) {
    this.modelo = modelo;
  }

  public List<RegistroTipoText> getRegistroTipoText() {
    return registroTipoText;
  }

  public void setRegistroTipoText(List<RegistroTipoText> registroTipoText) {
    this.registroTipoText = registroTipoText;
  }

  public List<RegistroTipoString> getRegistroTipoString() {
    return registroTipoString;
  }

  public void setRegistroTipoString(List<RegistroTipoString> registroTipoString) {
    this.registroTipoString = registroTipoString;
  }

  public List<RegistroTipoDecimal> getRegistroTipoDecimal() {
    return registroTipoDecimal;
  }

  public void setRegistroTipoDecimal(List<RegistroTipoDecimal> registroTipoDecimal) {
    this.registroTipoDecimal = registroTipoDecimal;
  }

}
