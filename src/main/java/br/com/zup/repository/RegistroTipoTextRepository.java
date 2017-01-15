package br.com.zup.repository;

import br.com.zup.model.RegistroTipoText;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Interface de definicao de operacoes na camada Repository para o modelo
 * RegistroTipoText.
 * 
 * @author Leonardo Henrique Lages Pereira 14/01/2017
 *
 */
@RepositoryRestResource
public interface RegistroTipoTextRepository extends JpaRepository<RegistroTipoText, Long> {

}
