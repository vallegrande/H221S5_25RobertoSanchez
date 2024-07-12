package pe.edu.vallegrande.HackatonIpApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import pe.edu.vallegrande.HackatonIpApp.model.Consulta;
import pe.edu.vallegrande.HackatonIpApp.repository.ConsultaRepository;
import reactor.core.publisher.Mono;


import java.time.LocalDateTime;

@Service
public class IpService {

    private final WebClient webClient;
    private final ConsultaRepository consultaRepository;

    public IpService(WebClient.Builder webClientBuilder, ConsultaRepository consultaRepository) {
        this.webClient = webClientBuilder.baseUrl("https://api.ipify.org").build();
        this.consultaRepository = consultaRepository;
    }

    public Mono<String> getMyIp() {
        return webClient.get()
                .uri("?format=json")
                .retrieve()
                .bodyToMono(String.class);
    }

    public Mono<String> getIpDetails(String ip) {
        return WebClient.create("https://ipinfo.io")
                .get()
                .uri("/" + ip + "?token=0194073900d22b")
                .retrieve()
                .bodyToMono(String.class)
                .doOnSuccess(detalle -> {
                    Consulta consulta = new Consulta();
                    consulta.setIp(ip);
                    consulta.setDetalle(detalle);
                    consulta.setFechaConsulta(LocalDateTime.now());
                    consultaRepository.save(consulta);
                });
    }

  //  https://api.ipify.org/?format=json


}