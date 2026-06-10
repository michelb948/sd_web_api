package estoque_api.controller;

import estoque_api.dto.CompraRequest;
import estoque_api.model.Suplemento;
import estoque_api.service.EstoqueService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EstoqueController {

    @Autowired
    private EstoqueService estoque;

    @GetMapping("/produtos")
    public List<Suplemento> listar() {
        return estoque.listar();
    }

    @GetMapping("/produtos/{id}")
    public Suplemento buscar(@PathVariable int id) {
        return estoque.buscar(id);
    }

    @PostMapping("/produtos")
    public String adicionar(
            @RequestBody Suplemento suplemento) {

        estoque.adicionar(suplemento);

        return "Produto adicionado com sucesso";
    }

    @PostMapping("/comprar")
    public String comprar(
            @RequestBody CompraRequest request) {

        boolean sucesso =
                estoque.comprar(
                        request.getId(),
                        request.getQuantidade());

        if (sucesso) {
            return "Compra realizada";
        }

        return "Estoque insuficiente ou produto inexistente";
    }
}