package br.com.zup.service.impl;

import br.com.zup.model.Estrutura;
import br.com.zup.repository.EstruturaRepository;
import br.com.zup.service.EstruturaService;

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
public class EstruturaServiceImpl implements EstruturaService<Estrutura, Long> {

  @Autowired
  private EstruturaRepository estruturaRepository;

  /*
   * (non-Javadoc)
   * 
   * @see br.com.zup.service.DefaultService#criar(java.lang.Object)
   */
  @Override
  public Estrutura criar(Estrutura objeto) {

    return estruturaRepository.save(objeto);
  }

  /*
   * (non-Javadoc)
   * 
   * @see br.com.zup.service.DefaultService#deletar(java.lang.Object)
   */
  @Override
  public void deletar(Long id) {
    estruturaRepository.delete(id);
  }

  /*
   * (non-Javadoc)
   * 
   * @see br.com.zup.service.DefaultService#buscar(java.lang.Object)
   */
  @Override
  public Estrutura buscar(Long id) {
    return estruturaRepository.findOne(id);
  }

  /*
   * (non-Javadoc)
   * 
   * @see br.com.zup.service.DefaultService#listarTodos()
   */
  @Override
  public List<Estrutura> listarTodos() {
    return estruturaRepository.findAll();
  }

  /*
   * (non-Javadoc)
   * 
   * @see br.com.zup.service.DefaultService#atualizar(java.lang.Object)
   */
  @Override
  public void atualizar(Estrutura objeto) {
    estruturaRepository.save(objeto);

  }

}
