package br.com.zup.repository;

import br.com.zup.model.Estrutura;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Interface de definicao de operacoes na camada Repository para o modelo
 * Estrutura.
 * 
 * @author Leonardo Henrique Lages Pereira 14/01/2017
 *
 */
@RepositoryRestResource
public interface EstruturaRepository extends JpaRepository<Estrutura, Long> {

}
