package br.com.zup.service.impl;

import br.com.zup.model.RegistroTipoDecimal;
import br.com.zup.repository.RegistroTipoDecimalRepository;
import br.com.zup.service.RegistroTipoDecimalService;

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
public class RegistroTipoDecimalServiceImpl
    implements RegistroTipoDecimalService<RegistroTipoDecimal, Long> {

  @Autowired
  private RegistroTipoDecimalRepository registroTipoDecimalRepository;

  /*
   * (non-Javadoc)
   * 
   * @see br.com.zup.service.DefaultService#criar(java.lang.Object)
   */
  @Override
  public RegistroTipoDecimal criar(RegistroTipoDecimal objeto) {

    return registroTipoDecimalRepository.save(objeto);
  }

  /*
   * (non-Javadoc)
   * 
   * @see br.com.zup.service.DefaultService#deletar(java.lang.Object)
   */
  @Override
  public void deletar(Long id) {
    registroTipoDecimalRepository.delete(id);
  }

  @Override
  public RegistroTipoDecimal buscar(Long id) {
    return registroTipoDecimalRepository.findOne(id);
  }

  /*
   * (non-Javadoc)
   * 
   * @see br.com.zup.service.DefaultService#listarTodos()
   */
  @Override
  public List<RegistroTipoDecimal> listarTodos() {
    return registroTipoDecimalRepository.findAll();
  }

  /*
   * (non-Javadoc)
   * 
   * @see br.com.zup.service.DefaultService#atualizar(java.lang.Object)
   */
  @Override
  public void atualizar(RegistroTipoDecimal objeto) {
    registroTipoDecimalRepository.save(objeto);

  }

  /*
   * (non-Javadoc)
   * 
   * @see
   * br.com.zup.service.RegistroTipoDecimalService#pesquisarPorExemplo(java.lang
   * .Object)
   */
  @Override
  public List<RegistroTipoDecimal> pesquisarPorExemplo(RegistroTipoDecimal exemplo) {
    Example<RegistroTipoDecimal> example = Example.of(exemplo);
    return registroTipoDecimalRepository.findAll(example);
  }

}
