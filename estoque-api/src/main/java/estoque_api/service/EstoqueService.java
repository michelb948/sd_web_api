package estoque_api.service;

import estoque_api.model.Suplemento;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EstoqueService {

    private final List<Suplemento> produtos;

    public EstoqueService() {

        produtos = new ArrayList<>();

        produtos.add(
                new Suplemento(
                        1,
                        "Whey Protein",
                        120.0,
                        10,
                        "Growth"));

        produtos.add(
                new Suplemento(
                        2,
                        "Creatina",
                        80.0,
                        5,
                        "Max Titanium"));
    }

    public List<Suplemento> listar() {
        return produtos;
    }

    public Suplemento buscar(int id) {

        for (Suplemento p : produtos) {
            if (p.getId() == id) {
                return p;
            }
        }

        return null;
    }

    public boolean comprar(int id, int qtd) {

        Suplemento produto = buscar(id);

        if (produto == null) {
            return false;
        }

        if (produto.getQuantidade() < qtd) {
            return false;
        }

        produto.setQuantidade(
                produto.getQuantidade() - qtd);

        return true;
    }

    public void adicionar(Suplemento suplemento) {
        produtos.add(suplemento);
    }
}