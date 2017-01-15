package br.com.zup.service.impl;

import br.com.zup.model.RegistroTipoString;
import br.com.zup.repository.RegistroTipoStringRepository;
import br.com.zup.service.RegistroTipoStringService;

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
public class RegistroTipoStringServiceImpl
    implements RegistroTipoStringService<RegistroTipoString, Long> {

  @Autowired
  private RegistroTipoStringRepository registroTipoStringRepository;

  /*
   * (non-Javadoc)
   * 
   * @see br.com.zup.service.DefaultService#criar(java.lang.Object)
   */
  @Override
  public RegistroTipoString criar(RegistroTipoString objeto) {

    return registroTipoStringRepository.save(objeto);
  }

  /*
   * (non-Javadoc)
   * 
   * @see br.com.zup.service.DefaultService#deletar(java.lang.Object)
   */
  @Override
  public void deletar(Long id) {
    registroTipoStringRepository.delete(id);
  }

  @Override
  public RegistroTipoString buscar(Long id) {
    return registroTipoStringRepository.findOne(id);
  }

  /*
   * (non-Javadoc)
   * 
   * @see br.com.zup.service.DefaultService#listarTodos()
   */
  @Override
  public List<RegistroTipoString> listarTodos() {
    return registroTipoStringRepository.findAll();
  }

  /*
   * (non-Javadoc)
   * 
   * @see br.com.zup.service.DefaultService#atualizar(java.lang.Object)
   */
  @Override
  public void atualizar(RegistroTipoString objeto) {
    registroTipoStringRepository.save(objeto);

  }

  /*
   * (non-Javadoc)
   * 
   * @see
   * br.com.zup.service.RegistroTipoStringService#pesquisarPorExemplo(java.lang.
   * Object)
   */
  @Override
  public List<RegistroTipoString> pesquisarPorExemplo(RegistroTipoString exemplo) {
    Example<RegistroTipoString> example = Example.of(exemplo);
    return registroTipoStringRepository.findAll(example);
  }

}
