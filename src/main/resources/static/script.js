(function () {
    $("#tabclientes").on("click", ".js-delete", function () {
        let botaoClicado = $(this);
        $("#btnsim").attr("data-id", botaoClicado.attr("data-id"));
        $("#modalcliente").modal("show");

    });

    $("#btnsim").on("click", function () {
        let botaoSim = $(this);
        let id = botaoSim.attr("data-id");
        $.ajax({
            url: "/clientes/delete/" + id,
            method: "GET",
            success: function () {
                window.location.href = "/clientes";
            }
        });
    })
})();
(function () {
    $("#tabcidades").on("click", ".js-delete", function () {
        let botaoClicado = $(this);
        $("#btnsim").attr("data-id", botaoClicado.attr("data-id"));
        $("#modalcidade").modal("show");

    });

    $("#btnsim").on("click", function () {
        let botaoSim = $(this);
        let id = botaoSim.attr("data-id");
        $.ajax({
            url: "/cidades/delete/" + id,
            method: "GET",
            success: function () {
                window.location.href = "/cidades";
            }
        });
    })
})();
(function () {
    $("#tabprodutos").on("click", ".js-delete", function () {
        let botaoClicado = $(this);
        $("#btnsim").attr("data-id", botaoClicado.attr("data-id"));
        $("#modalproduto").modal("show");

    });

    $("#btnsim").on("click", function () {
        let botaoSim = $(this);
        let id = botaoSim.attr("data-id");
        $.ajax({
            url: "/produtos/delete/" + id,
            method: "GET",
            success: function () {
                window.location.href = "/produtos";
            }
        });
    })
})();
//
(function () {
    $("#tabvendas").on("click", ".js-delete", function () {
        let botaoClicado = $(this);
        $("#btnsim").attr("data-id", botaoClicado.attr("data-id"));
        $("#modalvenda").modal("show");

    });

    $("#btnsim").on("click", function () {
        let botaoSim = $(this);
        let id = botaoSim.attr("data-id");
        $.ajax({
            url: "/vendas/delete/" + id,
            method: "GET",
            success: function () {
                window.location.href = "/vendas";
            }
        });
    })
})();
