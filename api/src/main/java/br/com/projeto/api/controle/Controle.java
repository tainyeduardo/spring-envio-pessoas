package br.com.projeto.api.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.projeto.api.modelo.Pessoa;
import br.com.projeto.api.repositorio.Repositorio;
import br.com.projeto.api.servico.Servico;

import java.util.List;
@RestController
public class Controle {

    @Autowired
    private Repositorio acao;

    @Autowired
    private Servico servico;

    @PostMapping("/api")
    public ResponseEntity<?> cadastrar(@RequestBody Pessoa obj){
        return servico.cadastrar(obj);
    }

    @GetMapping("/api")
    public ResponseEntity<?> selecionar(){
        return servico.selecionar();
    }

    @GetMapping("/api/{codigo}")
    public ResponseEntity<?> selecionarPeloCodigo(@PathVariable int codigo){
        return servico.selecionarPeloCodigo(codigo);
    }

    @PutMapping("/api")
    public ResponseEntity<?> editar(@RequestBody Pessoa obj){
        return servico.editar(obj);
    }

    @DeleteMapping("/api/{codigo}")
    public ResponseEntity<?> remover(@PathVariable int codigo){
        return servico.remover(codigo);
    }

    @GetMapping("/api/contador")
    public long contador(){
        return acao.count();
    }

    @GetMapping("/api/ordenarNomes")
    public List<Pessoa> ordernarNomes(){
        return acao.findByOrderByNome();
    }

    @GetMapping("/api/ordenarNomes2")
    public List<Pessoa> ordenarNomes2(){
        return acao.findByNomeOrderByIdade("Tainy"); 
    }

    @GetMapping("/api/nomeContem")
    public List<Pessoa> nomeContem(){
        return acao.findByNomeContaining("m");
    }

    @GetMapping("/api/iniciaCom")
    public List<Pessoa> iniciaCom(){
        return acao.findByNomeStartsWith("t");
    }

    @GetMapping("/api/somaIdades")
    public int somaIdades(){
        return acao.somaIdades();
    }

    @GetMapping("/api/idadeMaiorIgual")
    public List<Pessoa> idadeMaiorIgual(){
        return acao.idadeMaiorIgual(20);
    }

    @GetMapping("/status")
    public ResponseEntity<?> status(){
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/api/terminaCom")
    public List<Pessoa> terminaCom(){
        return acao.findByNomeEndsWith("o");
    }

    @GetMapping("/")
    public String mensagem(){
        return "Hello, World!";
    }

    @GetMapping("/boasVindas")
    public String boasVindas(){
        return "Seja bem vindo ";
    }

    @GetMapping("/boasVindas/{nome}")
    public String boasVindas(@PathVariable String nome){
        return "Seja bem vindo "+ nome;
    }

    @PostMapping("/pessoa")
    public Pessoa pessoa(@RequestBody Pessoa p){
        return p;
    }

}
