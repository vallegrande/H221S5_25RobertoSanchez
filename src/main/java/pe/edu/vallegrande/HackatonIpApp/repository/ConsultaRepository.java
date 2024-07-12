package pe.edu.vallegrande.HackatonIpApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.vallegrande.HackatonIpApp.model.Consulta;

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {
}
