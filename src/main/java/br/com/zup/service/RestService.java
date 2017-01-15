package br.com.zup.service;

import br.com.zup.dto.RegistroDto;

import java.util.List;
import java.util.Map;

/**
 * Contrato da camada Service .
 * 
 * @author Leonardo Henrique Lages Pereira 14/01/2017
 *
 */
public interface RestService {

  /**
   * insere o Registro com base no nome do Modelo.
   * 
   * @param nomeModelo
   *          nome do modelo
   * @param entrada
   *          registro a ser inserido
   */
  public void inserirRegistro(String nomeModelo, Map<String, Object> entrada);

  /**
   * Recupera todos os registros do modelo informado.
   * 
   * @param nomeModelo
   *          nome do Modelo.
   * @return mapa de registros
   */
  public List<RegistroDto> buscarTodosRegistros(String nomeModelo);

  /**
   * Recupera um registro com base no id informado e nome do modelo.
   * 
   * @param nomeModelo
   *          nome do Modelo.
   * @param id
   *          id do Registro
   * @return retorna o registro caso exista
   */
  public RegistroDto buscarRegistroPorId(String nomeModelo, Long id);

  /**
   * Deleta um registro com base no id informado e nome do modelo.
   * 
   * @param nomeModelo
   *          nome do Modelo.
   * @param id
   *          id do Registro
   */
  public void deletarRegistroPorId(String nomeModelo, Long id);

  /**
   * Deleta um registro com base no id informado e nome do modelo.
   * 
   * @param nomeModelo
   *          nome do Modelo.
   * @param id
   *          id do Registro
   * 
   * @param entrada
   *          registro a ser inserido
   */
  public void editarRegistroPorId(String nomeModelo, Long id, Map<String, Object> entrada);

}
