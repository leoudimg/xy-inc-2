package br.com.zup.controller;

import br.com.zup.facade.ControllerFacade;
import br.com.zup.model.Modelo;
import br.com.zup.service.ModeloService;
import br.com.zup.service.TipoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Controle referente a tela de modelo.
 * 
 * @author Leonardo Henrique Lages Pereira 14/01/2017
 *
 */
@Controller
@RequestMapping(value = { "", "/modelo" })
public class ModeloController implements ControllerFacade<Modelo, Long, String, Model> {

  @Autowired
  private ModeloService modeloService;

  @Autowired
  private TipoService tipoService;

  private static final String LISTA_MODELOS = "listModelo";

  /*
   * (non-Javadoc)
   * 
   * @see br.com.zup.facade.ControllerFacade#index(java.lang.Object)
   */
  @Override
  @RequestMapping(value = { "/", "index" })
  public String index(Model model) {

    model.addAttribute(LISTA_MODELOS, modeloService.listarTodos());

    return "modelo/index";
  }

  /*
   * (non-Javadoc)
   * 
   * @see br.com.zup.facade.ControllerFacade#cadastro()
   */
  @Override
  @RequestMapping(value = "cadastro")
  public String cadastro(Model model) {
    return "modelo/cadastro";
  }

  /*
   * (non-Javadoc)
   * 
   * @see br.com.zup.facade.ControllerFacade#criar(java.lang.Object)
   */
  @Override
  @RequestMapping(value = "criar", method = RequestMethod.POST)
  public String criar(@ModelAttribute("modelo") Modelo modelo) {
    modeloService.criar(modelo);
    return "redirect:index";
  }

  /*
   * (non-Javadoc)
   * 
   * @see br.com.zup.facade.ControllerFacade#editar(java.lang.Object,
   * java.lang.Object)
   */
  @Override
  @RequestMapping(value = "editar/{id}")
  public String editar(@PathVariable Long id, Model model) {
    model.addAttribute("modelo", modeloService.buscar(id));
    return "modelo/editar";
  }

  /*
   * (non-Javadoc)
   * 
   * @see br.com.zup.facade.ControllerFacade#atualizar(java.lang.Object)
   */
  @Override
  @RequestMapping(value = "atualizar", method = RequestMethod.POST)
  public String atualizar(@ModelAttribute("modelo")Modelo modelo) {
    modeloService.atualizar(modelo);
    return "redirect:index";
  }

  /*
   * (non-Javadoc)
   * 
   * @see br.com.zup.facade.ControllerFacade#deletar(java.lang.Object)
   */
  @Override
  @RequestMapping(value = "deletar/{id}")
  public String deletar(@PathVariable Long id) {
    modeloService.deletar(id);
    return "redirect:/modelo/index";
  }

}
