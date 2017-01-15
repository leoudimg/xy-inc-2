package br.com.zup.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Classe principal da aplicacao.
 * 
 * @author Leonardo Henrique Lages Pereira 13/01/2017
 *
 */
@SpringBootApplication(scanBasePackages = "br.com.zup")
@EntityScan(basePackages = "br.com.zup.model")
@EnableJpaRepositories(basePackages = "br.com.zup.repository")
public class XyInc2Application extends SpringBootServletInitializer {

  /**
   * Metodo principal.
   * 
   * @param args
   *          argumentos da aplicacao
   */
  public static void main(String[] args) {
    SpringApplication.run(XyInc2Application.class, args);
  }

  /**
   * Realiza as configuracoes da aplicacao.
   */
  @Override
  protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
    return application.sources(XyInc2Application.class);
  }
}
