package br.com.zup.dto;

import java.util.Map;

/**
 * Armazena os registros para retornar ao usuario em forma de JSON.
 * 
 * @author Leonardo Henrique Lages Pereira 14/01/2017
 *
 */
public class RegistroDto {

  private Long id;
  private Map<String, Object> atributos;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Map<String, Object> getAtributos() {
    return atributos;
  }

  public void setAtributos(Map<String, Object> atributos) {
    this.atributos = atributos;
  }

}
