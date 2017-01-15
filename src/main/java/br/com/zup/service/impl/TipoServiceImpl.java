package br.com.zup.service.impl;

import br.com.zup.model.Tipo;
import br.com.zup.repository.TipoRepository;
import br.com.zup.service.TipoService;

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
public class TipoServiceImpl implements TipoService<Tipo, Long> {

  @Autowired
  private TipoRepository tipoRepository;

  /*
   * (non-Javadoc)
   * 
   * @see br.com.zup.service.DefaultService#criar(java.lang.Object)
   */
  @Override
  public Tipo criar(Tipo objeto) {

    return tipoRepository.save(objeto);
  }

  /*
   * (non-Javadoc)
   * 
   * @see br.com.zup.service.DefaultService#deletar(java.lang.Object)
   */
  @Override
  public void deletar(Long id) {
    tipoRepository.delete(id);
  }

  /*
   * (non-Javadoc)
   * 
   * @see br.com.zup.service.DefaultService#buscar(java.lang.Object)
   */
  @Override
  public Tipo buscar(Long id) {
    return tipoRepository.findOne(id);
  }

  /*
   * (non-Javadoc)
   * 
   * @see br.com.zup.service.DefaultService#listarTodos()
   */
  @Override
  public List<Tipo> listarTodos() {
    return tipoRepository.findAll();
  }

  /*
   * (non-Javadoc)
   * 
   * @see br.com.zup.service.DefaultService#atualizar(java.lang.Object)
   */
  @Override
  public void atualizar(Tipo objeto) {
    tipoRepository.save(objeto);
  }

}
