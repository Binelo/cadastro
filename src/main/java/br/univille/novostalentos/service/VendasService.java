package br.univille.novostalentos.service;

import java.util.List;

import br.univille.novostalentos.entity.Venda;

public interface VendasService {
    List<Venda> getAll();

    Venda save(Venda venda);

    Venda findById(long id);

    void delete(long id);
}
