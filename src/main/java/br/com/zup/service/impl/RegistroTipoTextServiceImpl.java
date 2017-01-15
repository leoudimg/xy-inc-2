package br.com.zup.service.impl;

import br.com.zup.model.RegistroTipoText;
import br.com.zup.repository.RegistroTipoTextRepository;
import br.com.zup.service.RegistroTipoTextService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

/**
 * Implementacao da camada Service, aqui devem ser implementadas as regras de
 * negocio.
 * 
 * @author Leonardo Henrique Lages Pereira 14/01/2017
 *
 */
@Service
public class RegistroTipoTextServiceImpl
    implements RegistroTipoTextService<RegistroTipoText, Long> {

  @Autowired
  private RegistroTipoTextRepository registroTipoTextRepository;

  /*
   * (non-Javadoc)
   * 
   * @see br.com.zup.service.DefaultService#criar(java.lang.Object)
   */
  @Override
  public RegistroTipoText criar(RegistroTipoText objeto) {

    return registroTipoTextRepository.save(objeto);
  }

  /*
   * (non-Javadoc)
   * 
   * @see br.com.zup.service.DefaultService#deletar(java.lang.Object)
   */
  @Override
  public void deletar(Long id) {
    registroTipoTextRepository.delete(id);
  }

  /*
   * (non-Javadoc)
   * 
   * @see br.com.zup.service.DefaultService#buscar(java.lang.Object)
   */
  @Override
  public RegistroTipoText buscar(Long id) {
    return registroTipoTextRepository.findOne(id);
  }

  /*
   * (non-Javadoc)
   * 
   * @see br.com.zup.service.DefaultService#listarTodos()
   */
  @Override
  public List<RegistroTipoText> listarTodos() {
    return registroTipoTextRepository.findAll();
  }

  /*
   * (non-Javadoc)
   * 
   * @see br.com.zup.service.DefaultService#atualizar(java.lang.Object)
   */
  @Override
  public void atualizar(RegistroTipoText objeto) {
    registroTipoTextRepository.save(objeto);

  }

  /*
   * (non-Javadoc)
   * 
   * @see
   * br.com.zup.service.RegistroTipoTextService#pesquisarPorExemplo(java.lang.
   * Object)
   */
  @Override
  public List<RegistroTipoText> pesquisarPorExemplo(RegistroTipoText exemplo) {
    Example<RegistroTipoText> example = Example.of(exemplo);
    return registroTipoTextRepository.findAll(example);
  }

}
