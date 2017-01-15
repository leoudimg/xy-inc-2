package br.com.zup.service.impl;

import br.com.zup.dto.RegistroDto;
import br.com.zup.enumerator.TipoEnum;
import br.com.zup.model.Estrutura;
import br.com.zup.model.Modelo;
import br.com.zup.model.Registro;
import br.com.zup.model.RegistroTipoDecimal;
import br.com.zup.model.RegistroTipoString;
import br.com.zup.model.RegistroTipoText;
import br.com.zup.service.ModeloService;
import br.com.zup.service.RegistroService;
import br.com.zup.service.RegistroTipoDecimalService;
import br.com.zup.service.RegistroTipoStringService;
import br.com.zup.service.RegistroTipoTextService;
import br.com.zup.service.RestService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier(value = "restService")
public class RestServiceImpl implements RestService {

  @Autowired
  private ModeloService<Modelo, Long> modeloService;

  @Autowired
  private RegistroService<Registro, Long> registroService;

  @Autowired
  private RegistroTipoStringService<RegistroTipoString, Long> registroTipoStringService;

  @Autowired
  private RegistroTipoTextService<RegistroTipoText, Long> registroTipoTextService;

  @Autowired
  private RegistroTipoDecimalService<RegistroTipoDecimal, Long> registroTipoDecimalService;

  @Override
  public void inserirRegistro(String nomeModelo, Map<String, Object> entrada) {

    if (MapUtils.isNotEmpty(entrada) && StringUtils.isNotBlank(nomeModelo)) {

      Modelo modelo = new Modelo();
      modelo.setNome(nomeModelo);

      modelo = (Modelo) modeloService.pesquisarPorExemplo(modelo);

      if (modelo != null && CollectionUtils.isNotEmpty(modelo.getEstruturas())) {

        Registro registro = new Registro();
        registro.setModelo(modelo);

        registro = registroService.criar(registro);

        if (registro != null) {

          for (Estrutura estrutura : modelo.getEstruturas()) {

            if (TipoEnum.STRING.getId().equals(estrutura.getTipo().getId())) {

              RegistroTipoString registroTipoString = new RegistroTipoString();

              registroTipoString.setEstrutura(estrutura);
              registroTipoString.setRegistro(registro);
              registroTipoString.setValor((String) entrada.get(estrutura.getNome()));

              registroTipoStringService.criar(registroTipoString);

            } else if (TipoEnum.TEXT.getId().equals(estrutura.getTipo().getId())) {

              RegistroTipoText registroTipoText = new RegistroTipoText();

              registroTipoText.setEstrutura(estrutura);
              registroTipoText.setRegistro(registro);
              registroTipoText.setValor((String) entrada.get(estrutura.getNome()));

              registroTipoTextService.criar(registroTipoText);
            } else if (TipoEnum.DECIMAL.getId().equals(estrutura.getTipo().getId())) {

              RegistroTipoDecimal registroTipoDecimal = new RegistroTipoDecimal();

              registroTipoDecimal.setEstrutura(estrutura);
              registroTipoDecimal.setRegistro(registro);
              registroTipoDecimal.setValor((Double) entrada.get(estrutura.getNome()));

              registroTipoDecimalService.criar(registroTipoDecimal);
            }
          }

        }

      }
    }

  }

  /*
   * (non-Javadoc)
   * 
   * @see br.com.zup.service.RestService#buscarTodosRegistros(java.lang.String)
   */
  @Override
  public List<RegistroDto> buscarTodosRegistros(String nomeModelo) {

    List<RegistroDto> retorno = new ArrayList<RegistroDto>();

    if (StringUtils.isNotBlank(nomeModelo)) {

      Modelo modelo = new Modelo();

      modelo.setNome(nomeModelo);
      modelo = (Modelo) modeloService.pesquisarPorExemplo(modelo);

      if (modelo != null) {

        retorno = buscarRegistros(modelo.getRegistros());

      }

    }

    return retorno;
  }

  /*
   * (non-Javadoc)
   * 
   * @see br.com.zup.service.RestService#buscarRegistroPorId(java.lang.String,
   * java.lang.Long)
   */
  @Override
  public RegistroDto buscarRegistroPorId(String nomeModelo, Long id) {

    if (StringUtils.isNotBlank(nomeModelo) && id != null) {

      Modelo modelo = new Modelo();

      modelo.setNome(nomeModelo);
      modelo = (Modelo) modeloService.pesquisarPorExemplo(modelo);

      if (modelo != null && CollectionUtils.isNotEmpty(modelo.getRegistros())) {

        Iterator<Registro> it = modelo.getRegistros().iterator();

        while (it.hasNext()) {

          Registro registro = it.next();

          if (!id.equals(registro.getId())) {

            it.remove();

          }
        }

        List<RegistroDto> lista = buscarRegistros(modelo.getRegistros());

        if (CollectionUtils.isNotEmpty(lista)) {
          return lista.get(0);
        }
      }

    }

    return null;
  }

  private List<RegistroDto> buscarRegistros(List<Registro> registros) {

    List<RegistroDto> retorno = new ArrayList<RegistroDto>();

    if (CollectionUtils.isNotEmpty(registros)) {

      for (Registro registro : registros) {

        RegistroDto registroDto = new RegistroDto();

        registroDto.setId(registro.getId());

        Map<String, Object> mapa = new HashMap<String, Object>();

        RegistroTipoDecimal registroDecimal = new RegistroTipoDecimal();
        registroDecimal.setRegistro(registro);

        List<RegistroTipoDecimal> liDecimals = registroTipoDecimalService
            .pesquisarPorExemplo(registroDecimal);

        if (CollectionUtils.isNotEmpty(liDecimals)) {

          for (RegistroTipoDecimal registroTipoDecimal : liDecimals) {
            mapa.put(registroTipoDecimal.getEstrutura().getNome(), registroTipoDecimal.getValor());
          }
        }

        RegistroTipoText registroText = new RegistroTipoText();
        registroText.setRegistro(registro);

        List<RegistroTipoText> liTexts = registroTipoTextService.pesquisarPorExemplo(registroText);

        if (CollectionUtils.isNotEmpty(liTexts)) {

          for (RegistroTipoText registroTipoText : liTexts) {
            mapa.put(registroTipoText.getEstrutura().getNome(), registroTipoText.getValor());
          }
        }

        RegistroTipoString registroString = new RegistroTipoString();
        registroString.setRegistro(registro);

        List<RegistroTipoString> liStrings = registroTipoStringService
            .pesquisarPorExemplo(registroString);

        if (CollectionUtils.isNotEmpty(liStrings)) {
          for (RegistroTipoString registroTipoString : liStrings) {
            mapa.put(registroTipoString.getEstrutura().getNome(), registroTipoString.getValor());
          }

        }

        registroDto.setAtributos(mapa);

        retorno.add(registroDto);
      }
    }

    return retorno;

  }

  /*
   * (non-Javadoc)
   * 
   * @see br.com.zup.service.RestService#deletarRegistroPorId(java.lang.String,
   * java.lang.Long)
   */
  @Override
  public void deletarRegistroPorId(String nomeModelo, Long id) {

    if (StringUtils.isNotBlank(nomeModelo) && id != null) {

      Modelo modelo = new Modelo();

      modelo.setNome(nomeModelo);
      modelo = (Modelo) modeloService.pesquisarPorExemplo(modelo);

      if (modelo != null && CollectionUtils.isNotEmpty(modelo.getRegistros())) {

        for (Registro registro : modelo.getRegistros()) {

          if (id.equals(registro.getId())) {
            RegistroTipoDecimal registroDecimal = new RegistroTipoDecimal();
            registroDecimal.setRegistro(registro);

            List<RegistroTipoDecimal> liDecimals = registroTipoDecimalService
                .pesquisarPorExemplo(registroDecimal);

            if (CollectionUtils.isNotEmpty(liDecimals)) {

              for (RegistroTipoDecimal registroTipoDecimal : liDecimals) {
                registroTipoDecimalService.deletar(registroTipoDecimal.getId());
              }
            }

            RegistroTipoText registroText = new RegistroTipoText();
            registroText.setRegistro(registro);

            List<RegistroTipoText> liTexts = registroTipoTextService
                .pesquisarPorExemplo(registroText);

            if (CollectionUtils.isNotEmpty(liTexts)) {

              for (RegistroTipoText registroTipoText : liTexts) {
                registroTipoTextService.deletar(registroTipoText.getId());
              }
            }

            RegistroTipoString registroString = new RegistroTipoString();
            registroString.setRegistro(registro);

            List<RegistroTipoString> liStrings = registroTipoStringService
                .pesquisarPorExemplo(registroString);

            if (CollectionUtils.isNotEmpty(liStrings)) {
              for (RegistroTipoString registroTipoString : liStrings) {
                registroTipoStringService.deletar(registroTipoString.getId());
              }

            }

            registroService.deletar(id);
            break;
          }
        }
      }
    }
  }

  /*
   * (non-Javadoc)
   * 
   * @see br.com.zup.service.RestService#editarRegistroPorId(java.lang.String,
   * java.lang.Long, java.util.Map)
   */
  @Override
  public void editarRegistroPorId(String nomeModelo, Long id, Map<String, Object> entrada) {

    if (StringUtils.isNotBlank(nomeModelo) && id != null) {

      Modelo modelo = new Modelo();

      modelo.setNome(nomeModelo);
      modelo = (Modelo) modeloService.pesquisarPorExemplo(modelo);

      if (modelo != null && CollectionUtils.isNotEmpty(modelo.getRegistros())) {

        for (Registro registro : modelo.getRegistros()) {

          if (id.equals(registro.getId())) {
            RegistroTipoDecimal registroDecimal = new RegistroTipoDecimal();
            registroDecimal.setRegistro(registro);

            List<RegistroTipoDecimal> liDecimals = registroTipoDecimalService
                .pesquisarPorExemplo(registroDecimal);

            if (CollectionUtils.isNotEmpty(liDecimals)) {

              for (RegistroTipoDecimal registroTipoDecimal : liDecimals) {

                for (Entry entry : entrada.entrySet()) {

                  if (registroTipoDecimal.getEstrutura().getNome().equals(entry.getKey())) {

                    registroTipoDecimal.setValor((Double) entry.getValue());
                    registroTipoDecimalService.atualizar(registroTipoDecimal);
                  }
                }
              }
            }

            RegistroTipoText registroText = new RegistroTipoText();
            registroText.setRegistro(registro);

            List<RegistroTipoText> liTexts = registroTipoTextService
                .pesquisarPorExemplo(registroText);

            if (CollectionUtils.isNotEmpty(liTexts)) {

              for (RegistroTipoText registroTipoText : liTexts) {

                for (Entry entry : entrada.entrySet()) {

                  if (registroTipoText.getEstrutura().getNome().equals(entry.getKey())) {

                    registroTipoText.setValor((String) entry.getValue());
                    registroTipoTextService.atualizar(registroTipoText);
                  }
                }
              }
            }

            RegistroTipoString registroString = new RegistroTipoString();
            registroString.setRegistro(registro);

            List<RegistroTipoString> liStrings = registroTipoStringService
                .pesquisarPorExemplo(registroString);

            if (CollectionUtils.isNotEmpty(liStrings)) {

              for (RegistroTipoString registroTipoString : liStrings) {

                for (Entry entry : entrada.entrySet()) {

                  if (registroTipoString.getEstrutura().getNome().equals(entry.getKey())) {

                    registroTipoString.setValor((String) entry.getValue());
                    registroTipoStringService.atualizar(registroTipoString);
                  }
                }
              }

            }

            registroService.deletar(id);
            break;
          }
        }
      }
    }
  }
}
