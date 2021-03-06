package br.com.zup.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Classe de persistencia que representa o registro do tipo Decimal.
 * 
 * @author Leonardo Henrique Lages Pereira 14/01/2017
 *
 */
@Entity
@Table(name = "registro_tipo_decimal")
public class RegistroTipoDecimal implements Serializable {

  /**
   * Serial Version.
   */
  private static final long serialVersionUID = -8058600265167810854L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", unique = true, nullable = false)
  private Long id;

  @Column(name = "valor")
  private Double valor;

  @ManyToOne
  @JoinColumn(name = "registro", nullable = false)
  private Registro registro;

  @ManyToOne
  @JoinColumn(name = "estrutura", nullable = false)
  private Estrutura estrutura;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Double getValor() {
    return valor;
  }

  public void setValor(Double valor) {
    this.valor = valor;
  }

  public Registro getRegistro() {
    return registro;
  }

  public void setRegistro(Registro registro) {
    this.registro = registro;
  }

  public Estrutura getEstrutura() {
    return estrutura;
  }

  public void setEstrutura(Estrutura estrutura) {
    this.estrutura = estrutura;
  }

  public static long getSerialversionuid() {
    return serialVersionUID;
  }

}
