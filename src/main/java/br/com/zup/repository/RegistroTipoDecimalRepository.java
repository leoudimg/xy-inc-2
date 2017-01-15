package br.com.zup.repository;

import br.com.zup.model.RegistroTipoDecimal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Interface de definicao de operacoes na camada Repository para o modelo
 * RegistroTipoDecimal.
 * 
 * @author Leonardo Henrique Lages Pereira 14/01/2017
 *
 */
@RepositoryRestResource
public interface RegistroTipoDecimalRepository extends JpaRepository<RegistroTipoDecimal, Long> {

}
