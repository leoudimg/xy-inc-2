package br.com.zup.service.impl;

import br.com.zup.model.Registro;
import br.com.zup.repository.RegistroRepository;
import br.com.zup.service.RegistroService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Implementacao da camada Service, aqui devem ser implementadas as regras de
 * negocio.
 * 
 * @author Leonardo Henrique Lages Pereira 14/01/2017
 *
 */
@Service
public class RegistroServiceImpl implements RegistroService<Registro, Long> {

  @Autowired
  private RegistroRepository registroRepository;

  /*
   * (non-Javadoc)
   * 
   * @see br.com.zup.service.DefaultService#criar(java.lang.Object)
   */
  @Override
  public Registro criar(Registro objeto) {

    return registroRepository.save(objeto);
  }

  /*
   * (non-Javadoc)
   * 
   * @see br.com.zup.service.DefaultService#deletar(java.lang.Object)
   */
  @Override
  public void deletar(Long id) {
    registroRepository.delete(id);
  }

  @Override
  public Registro buscar(Long id) {
    return registroRepository.findOne(id);
  }

  /*
   * (non-Javadoc)
   * 
   * @see br.com.zup.service.DefaultService#listarTodos()
   */
  @Override
  public List<Registro> listarTodos() {
    return registroRepository.findAll();
  }

  @Override
  public void atualizar(Registro objeto) {
    registroRepository.save(objeto);

  }

}
