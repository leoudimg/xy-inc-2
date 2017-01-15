package br.com.zup.service.impl;

import br.com.zup.model.Modelo;
import br.com.zup.repository.ModeloRepository;
import br.com.zup.service.ModeloService;

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
public class ModeloServiceImpl implements ModeloService<Modelo, Long> {

  @Autowired
  private ModeloRepository modeloRepository;

  /*
   * (non-Javadoc)
   * 
   * @see br.com.zup.service.DefaultService#criar(java.lang.Object)
   */
  @Override
  public Modelo criar(Modelo objeto) {

    return modeloRepository.save(objeto);
  }

  /*
   * (non-Javadoc)
   * 
   * @see br.com.zup.service.DefaultService#deletar(java.lang.Object)
   */
  @Override
  public void deletar(Long id) {
    modeloRepository.delete(id);
  }

  @Override
  public Modelo buscar(Long id) {
    return modeloRepository.findOne(id);
  }

  /*
   * (non-Javadoc)
   * 
   * @see br.com.zup.service.DefaultService#listarTodos()
   */
  @Override
  public List<Modelo> listarTodos() {
    return modeloRepository.findAll();
  }

  @Override
  public void atualizar(Modelo objeto) {
    modeloRepository.save(objeto);

  }

  /*
   * (non-Javadoc)
   * 
   * @see br.com.zup.service.ModeloService#pesquisarPorExemplo(java.lang.Object)
   */
  @Override
  public Modelo pesquisarPorExemplo(Modelo exemplo) {
    Example<Modelo> example = Example.of(exemplo);
    return modeloRepository.findOne(example);
  }

}
