package br.newton.av1.service;

import br.newton.av1.model.NoticiaEntity;
import br.newton.av1.model.ReleaseEntity;
import br.newton.av1.repository.NoticiaRepository;
import br.newton.av1.repository.ReleaseRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@Service
public class Av1Service {

    @Autowired
    private NoticiaRepository noticiaRepository;

    @Autowired
    private ReleaseRepository releaseRepository;

    public String consultaNoticias(){
        String dados = "";
        String apiUrl = "https://servicodados.ibge.gov.br/api/v3/noticias/?tipo=noticia";

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(apiUrl, String.class);
        if(responseEntity.getStatusCode().is2xxSuccessful()){
            dados = responseEntity.getBody();
            salvaNoticias(dados);
        }else {
            dados = "Falha ao obter Noticias. Código de status: " + responseEntity.getStatusCode();
        }

        return dados;
    }

    public String consultaReleases(){
        String dados = "";
        String apiUrl = "https://servicodados.ibge.gov.br/api/v3/noticias/?tipo=release";

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(apiUrl, String.class);
        if(responseEntity.getStatusCode().is2xxSuccessful()){
            dados = responseEntity.getBody();
            salvaReleases(dados);
        }else {
            dados = "Falha ao obter Releases. Código de status: " + responseEntity.getStatusCode();
        }

        return dados;
    }

    public String consultaNoticiasEReleases(){
        String dados = "";
        String apiUrl = "https://servicodados.ibge.gov.br/api/v3/noticias";

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(apiUrl, String.class);
        if(responseEntity.getStatusCode().is2xxSuccessful()){
            dados = responseEntity.getBody();
        }else {
            dados = "Falha ao obter Noticias e Releases. Código de status: " + responseEntity.getStatusCode();
        }

        return dados;
    }

    private void salvaNoticias(String data){
        NoticiaEntity noticia = new NoticiaEntity(null, data);
        noticiaRepository.save(noticia);
    }

    private void salvaReleases(String data){
        ReleaseEntity release = new ReleaseEntity(null, data);
        releaseRepository.save(release);
    }
}
