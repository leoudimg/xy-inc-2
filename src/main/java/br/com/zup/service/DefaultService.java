package br.com.zup.service;

import java.util.List;

/**
 * Contrato Padrao para operacoes na base de dados.
 * 
 * @author Leonardo Henrique Lages Pereira 14/01/2017
 *
 * @param <T>
 *          Modelo
 * @param <K>
 *          Tipo do id
 */
public interface DefaultService<T, K> {

  /**
   * Cria um objeto do tipo T.
   * 
   * @param objeto
   *          modelo a ser criado.
   */
  public T criar(T objeto);

  /**
   * Deleta um registro na base.
   * 
   * @param id
   *          identificador do registro a ser excluido.
   */
  public void deletar(K id);

  /**
   * Busca um registro na base.
   * 
   * @param id
   *          Identificador do registro a ser pesquisado.
   * @return Registro encontrado.
   */
  public T buscar(K id);

  /**
   * Busca todos os registros na base do tipo T.
   * 
   * @return Lista de registros armazenados na base de dados.
   */
  public List<T> listarTodos();

  /**
   * Atualiza um objeto do tipo T.
   * 
   * @param objeto
   *          modelo a ser atualizado.
   */
  public void atualizar(T objeto);

}
