package com.jornada.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jornada.models.Viagem;
import com.jornada.services.ViagemService;

@CrossOrigin(origins = "http://localhost:3000/")

@RestController
@RequestMapping("/viagens")
public class ViagemController {

    @Autowired
    private ViagemService vs;

    @PostMapping("/cadastrar")
    public Viagem cadastrarViagem(@RequestBody Viagem viagem) {

        return vs.salvarViagem(viagem);
    }

    @GetMapping("/listar")
    public List<Viagem> listarViagens() {

        return vs.listarViagens();
    }

    @GetMapping("/obter/{id}")
    public ResponseEntity<Viagem> obterViagemPorId(@PathVariable Long id) {
        Viagem viagem = vs.obterViagemPorId(id);

        return new ResponseEntity<>(viagem, HttpStatus.OK);
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<Viagem> editarViagem(@PathVariable Long id, @RequestBody Viagem viagemAtualizada) {
        Viagem viagem = vs.obterViagemPorId(id);

        if (viagem != null) {
            // Atualizar os campos necessários da viagem com os dados da viagemAtualizada
            viagem.setDestino(viagemAtualizada.getDestino());
            viagem.setPassageiro(viagemAtualizada.getPassageiro());
            viagem.setDataIda(viagemAtualizada.getDataIda());
            viagem.setDataVolta(viagemAtualizada.getDataVolta());

            // Agora, salve a viagem atualizada
            vs.salvarViagem(viagem);

            return ResponseEntity.ok(viagem);
        } else {
            // Se a viagem não for encontrada, retorne um ResponseEntity com status 404 (Not Found)
            return ResponseEntity.notFound().build();
        }
    }


    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<Void> excluirViagem(@PathVariable Long id) {
        vs.excluirViagem(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
