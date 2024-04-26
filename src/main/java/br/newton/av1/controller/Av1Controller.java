package br.newton.av1.controller;

import br.newton.av1.service.Av1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class Av1Controller {

    @Autowired
    private Av1Service av1Service;

    @GetMapping("/noticias")
    public String getNoticias(){
        return av1Service.consultaNoticias();
    }

    @GetMapping("/releases")
    public String getReleases(){
        return av1Service.consultaReleases();
    }

    @GetMapping("/noticiasereleases")
    public String getNoticiasEReleases(){
        return av1Service.consultaNoticiasEReleases();
    }
}
