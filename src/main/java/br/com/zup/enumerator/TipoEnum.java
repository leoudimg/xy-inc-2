package br.com.zup.enumerator;

/**
 * Enumerator que representa a tabela de dominio Tipo.
 * 
 * @author Leonardo Henrique Lages Pereira 14/01/2017
 *
 */
public enum TipoEnum {

  STRING(1L), TEXT(2L), DECIMAL(3L);

  private Long id;

  private TipoEnum(Long id) {
    this.id = id;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

}
