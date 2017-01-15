package br.com.zup.controller;

import br.com.zup.facade.ControllerFacade;
import br.com.zup.model.Estrutura;
import br.com.zup.model.Modelo;
import br.com.zup.service.EstruturaService;
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
 * Controle referente a tela de estrutura.
 * 
 * @author Leonardo Henrique Lages Pereira 14/01/2017
 *
 */
@Controller
@RequestMapping(value = { "/estrutura" })
public class EstruturaController implements ControllerFacade<Estrutura, Long, String, Model> {

  @Autowired
  private ModeloService modeloService;

  @Autowired
  private EstruturaService estruturaService;

  @Autowired
  private TipoService tipoService;

  private static final String LISTA_ESTRUTURA = "listEstrutura";

  /*
   * (non-Javadoc)
   * 
   * @see br.com.zup.facade.ControllerFacade#index(java.lang.Object)
   */
  @Override
  @RequestMapping(value = { "index" })
  public String index(Model model) {

    model.addAttribute(LISTA_ESTRUTURA, estruturaService.listarTodos());

    return "estrutura/index";
  }

  /**
   * Carrega as estruturas de um determinado Modelo.
   * 
   * @param id
   *          id do modelo
   * @param model
   *          parametro de renderizacao da pagina
   * @return pagina a ser renderizada
   */
  @RequestMapping(value = { "index/{id}" })
  public String index(@PathVariable Long id, Model model) {

    Modelo modelo = (Modelo) modeloService.buscar(id);

    model.addAttribute("modelo", modelo);

    return "estrutura/index";
  }

  /*
   * (non-Javadoc)
   * 
   * @see br.com.zup.facade.ControllerFacade#cadastro()
   */
  @Override
  @RequestMapping(value = "cadastro")
  public String cadastro(Model model) {

    model.addAttribute("listTipos", tipoService.listarTodos());

    return "estrutura/cadastro";
  }

  @RequestMapping(value = "cadastro/{id}")
  public String cadastro(@PathVariable Long id, Model model) {

    model.addAttribute("modelo", modeloService.buscar(id));

    model.addAttribute("listTipos", tipoService.listarTodos());

    return "estrutura/cadastro";
  }

  /*
   * (non-Javadoc)
   * 
   * @see br.com.zup.facade.ControllerFacade#criar(java.lang.Object)
   */
  @Override
  @RequestMapping(value = "criar", method = RequestMethod.POST)
  public String criar(@ModelAttribute("estrutura") Estrutura estrutura) {
    estruturaService.criar(estrutura);
    return "redirect:index/" + estrutura.getModelo().getId();
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
    model.addAttribute("estrutura", estruturaService.buscar(id));
    return "estrutura/editar";
  }

  /*
   * (non-Javadoc)
   * 
   * @see br.com.zup.facade.ControllerFacade#atualizar(java.lang.Object)
   */
  @Override
  @RequestMapping(value = "atualizar", method = RequestMethod.POST)
  public String atualizar(@ModelAttribute("estrutura") Estrutura estrutura) {
    estruturaService.atualizar(estrutura);
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
    estruturaService.deletar(id);
    return "redirect:/estrutura/index";
  }
}
