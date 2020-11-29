package br.com.pmanoelm.Loja.LojaDeArtigosGerais.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.pmanoelm.Loja.LojaDeArtigosGerais.Model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
