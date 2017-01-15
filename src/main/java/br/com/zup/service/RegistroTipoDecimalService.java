package br.com.zup.service;

import java.util.List;

/**
 * Contrato da camada Service para RegistroTipoDecimal.
 * 
 * @author Leonardo Henrique Lages Pereira 14/01/2017
 *
 */
public interface RegistroTipoDecimalService<T, ID> extends DefaultService<T, ID> {

  /**
   * Realiza uma pesquisa com base nos parametros informados.
   * 
   * @param exemplo
   *          objeto contendo os atributos a serem pesquisados
   * @return retorna o objeto caso exista na base de dados
   */
  public List<T> pesquisarPorExemplo(T exemplo);
}
