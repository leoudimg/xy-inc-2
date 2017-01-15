package br.com.zup.rest.controller;

import br.com.zup.dto.RegistroDto;
import br.com.zup.service.RestService;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Api Rest que processa todas as requisicoes aos Modelos.
 * 
 * @author Leonardo Henrique Lages Pereira 14/01/2017
 *
 */
@RestController
@RequestMapping(value = { "/api" })
public class ApiRestController {

  @Autowired
  @Qualifier(value = "restService")
  private RestService restService;

  /**
   * Processa a operacao POST.
   * 
   * @param modelo
   *          nome do modelo a ser processado
   * @param registro
   *          atributos a serem armazenados
   * @return retorna mensagem de sucesso
   */
  @RequestMapping(value = { "/{modelo}" }, method = RequestMethod.POST)
  public String processarPost(@PathVariable String modelo,
      @RequestBody Map<String, Object> registro) {

    restService.inserirRegistro(modelo, registro);

    return "Registro inserido com sucesso.";
  }

  /**
   * Processa a operacao GET.
   * 
   * @param modelo
   *          nome do modelo a ser processado
   * @return retorna a lista contendo todos registros do modelo
   */
  @RequestMapping(value = { "/{modelo}" }, method = RequestMethod.GET)
  public List<RegistroDto> processarGet(@PathVariable String modelo) {

    return restService.buscarTodosRegistros(modelo);
  }

  /**
   * Processa a operacao GET.
   * 
   * @param modelo
   *          nome do modelo a ser processado
   * @param id
   *          id do registro a ser pesquisado
   * 
   * @return retorna a lista contendo todos registros do modelo
   */
  @RequestMapping(value = { "/{modelo}/{id}" }, method = RequestMethod.GET)
  public RegistroDto processarGet(@PathVariable String modelo, @PathVariable Long id) {

    return restService.buscarRegistroPorId(modelo, id);
  }

  /**
   * Processa a operacao DELETE.
   * 
   * @param modelo
   *          nome do modelo a ser processado
   * @param id
   *          id do registro a ser excluido
   * 
   * @return retorna a lista contendo todos registros do modelo
   */
  @RequestMapping(value = { "/{modelo}/{id}" }, method = RequestMethod.DELETE)
  public String processarDelete(@PathVariable String modelo, @PathVariable Long id) {

    restService.deletarRegistroPorId(modelo, id);

    return "Registro excluido com sucesso";
  }

  /**
   * Processa a operacao PUT.
   * 
   * @param modelo
   *          nome do modelo a ser processado
   * @param id
   *          id do registro a ser excluido
   * 
   * @return retorna a lista contendo todos registros do modelo
   */
  @RequestMapping(value = { "/{modelo}/{id}" }, method = RequestMethod.PUT)
  public String processarPut(@PathVariable String modelo, @PathVariable Long id,
      @RequestBody Map<String, Object> registro) {

    restService.editarRegistroPorId(modelo, id, registro);

    return "Registro atualizado com sucesso";
  }

}
