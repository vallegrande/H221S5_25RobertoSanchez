package pe.edu.vallegrande.HackatonIpApp.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import pe.edu.vallegrande.HackatonIpApp.service.IpService;
import reactor.core.publisher.Mono;


@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class IpController {

    private final IpService ipService;

    public IpController(IpService ipService) {
        this.ipService = ipService;
    }

    @GetMapping("/my-ip")
    public Mono<String> getMyIp() {
        return ipService.getMyIp();
    }

    @GetMapping("/ip-info/{ip}")
    public Mono<String> getIpInfo(@PathVariable String ip) {
        return ipService.getIpDetails(ip);
    }

}

