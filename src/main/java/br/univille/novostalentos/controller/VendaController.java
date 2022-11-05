package br.univille.novostalentos.controller;

import java.util.HashMap;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.univille.novostalentos.entity.ItemVenda;
import br.univille.novostalentos.entity.Venda;
import br.univille.novostalentos.service.ClienteService;
import br.univille.novostalentos.service.ProdutoService;
import br.univille.novostalentos.service.VendasService;

@Controller
@RequestMapping("/vendas")
public class VendaController {

    @Autowired
    private VendasService service;
    @Autowired
    private ClienteService clienteService;
    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public ModelAndView index() {
        var listaVendas = service.getAll();
        return new ModelAndView("venda/index",
                "listaVendas", listaVendas);
    }

    @GetMapping("/novo")
    public ModelAndView novo() {
        var novaVenda = new Venda();
        var listaClientes = clienteService.getAll();
        var listaProdutos = produtoService.getAll();
        HashMap<String, Object> dados = new HashMap<>();
        dados.put("venda", novaVenda);
        dados.put("listaClientes", listaClientes);
        dados.put("listaProdutos", listaProdutos);
        dados.put("novoItem", new ItemVenda());
        return new ModelAndView("venda/form", dados);
    }

    @PostMapping(params = "save")
    public ModelAndView save(@Valid Venda venda,
            BindingResult bindingResult) {
        service.save(venda);
        return new ModelAndView("redirect:/vendas");
    }

    @PostMapping(params = "incitem")
    public ModelAndView incluirItem(Venda venda,
            ItemVenda novoItem) {
        venda.getColItens().add(novoItem);

        var listaClientes = clienteService.getAll();
        var listaProdutos = produtoService.getAll();
        HashMap<String, Object> dados = new HashMap<>();
        dados.put("venda", venda);
        dados.put("listaClientes", listaClientes);
        dados.put("listaProdutos", listaProdutos);
        dados.put("novoItem", new ItemVenda());
        return new ModelAndView("venda/form", dados);
    }

    @PostMapping(params = "removeitem")
    public ModelAndView removerItem(@RequestParam("removeitem") int index,
            Venda venda) {
        venda.getColItens().remove(index);

        var listaClientes = clienteService.getAll();
        var listaProdutos = produtoService.getAll();
        HashMap<String, Object> dados = new HashMap<>();
        dados.put("venda", venda);
        dados.put("listaClientes", listaClientes);
        dados.put("listaProdutos", listaProdutos);
        dados.put("novoItem", new ItemVenda());
        return new ModelAndView("venda/form", dados);
    }

    @GetMapping("/alterar/{id}")
    public ModelAndView alterar(@PathVariable("id") long id) {
        var umaVenda = service.findById(id);
        var listaCLientes = clienteService.getAll();
        var listaProdutos = produtoService.getAll();
        
        HashMap<String, Object> dados = new HashMap<>();
        dados.put("venda", umaVenda);
        dados.put("listaProdutos", listaProdutos);
        dados.put("listaClientes", listaCLientes);
        dados.put("novoItem", new ItemVenda());
        return new ModelAndView("venda/form", dados);

    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") long id) {

        service.delete(id);

        return new ModelAndView("redirect:/vendas");
    }
}