package br.com.zup.facade;

public interface ControllerFacade<T, K, E, I> {

  /**
   * Prepara os atributos necessarios para renderizar a tela de cadastro.
   * 
   * @param <I> prepara os atributos para renderizacao da pagina
   * @return pagina a ser renderizada
   */
  public E cadastro(I model);

  /**
   * Criar um modelo.
   * 
   * @return pagina a ser renderizada
   */
  public E criar(T obj);

  /**
   * Atualizar um modelo.
   * 
   * @return pagina a ser renderizada
   */
  public E atualizar(T obj);

  /**
   * Prepara os atributos necessarios para renderizar a tela de listagem de
   * dados.
   * 
   * @param <T> Tipo do modelo
   * 
   * @return pagina a ser renderizada
   */
  public E index(I model);

  /**
   * Prepara os atributos necessarios para renderizar a tela de edicao dos
   * dados.
   * 
   * @param <K> tipo da chave
   * @param <I> prepara os atributos para renderizacao da pagina
   * 
   * @return pagina a ser renderizada
   */
  public E editar(K id, I model);

  /**
   * Apagar o registro.
   * @param <K> tipo da chave
   * @return pagina a ser renderizada
   */
  public E deletar(K id);

}
