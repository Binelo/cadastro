package br.univille.novostalentos.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.novostalentos.entity.Venda;
import br.univille.novostalentos.repository.VendaRepository;
import br.univille.novostalentos.service.VendasService;

@Service
public class VendasServiceImpl implements VendasService {
    @Autowired
    private VendaRepository repositorio;

    @Override
    public Venda save(Venda venda) {
        return repositorio.save(venda);
    }

    @Override
    public Venda findById(long id) {
        var resultado = repositorio.findById(id);
        if (resultado.isPresent()) {
            return resultado.get();
        }
        return new Venda();
    }

    @Override
    public void delete(long id) {
        repositorio.deleteById(id);
    }

    @Override
    public List<Venda> getAll() {
        return repositorio.findAll();
    }

}
