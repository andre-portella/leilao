$(document).ready(function() {
    // Função para atualizar a tabela de lances
    function updateBids() {
        $("form button").prop("disabled", true);
        $("form input[name='bid_value']").prop("disabled", true);

        $.ajax({
            url: "auction?product_id=" + productId + "&isAjax=true", // Parâmetro para identificar AJAX
            method: "GET",
            success: function(data) {
                $("#bids-list").html(data); // Atualiza a tabela

                setTimeout(function() {
                    $("form button").prop("disabled", false);
                    $("form input[name='bid_value']").prop("disabled", false);
                }, 2000);
            }
        });
    }

    // Atualiza a tabela a cada 10 segundos
    setInterval(updateBids, 10000);

    // Envio do formulário via AJAX
    $("form").on("submit", function(event) {
        event.preventDefault(); // Impede o envio tradicional

        let bidValue = parseFloat($("input[name='bid_value']").val());

        // Verifica se o valor do lance é válido
        if (isNaN(bidValue) || bidValue < parseFloat(minBid)) {
            $("#bid-message").text("Faça um lance acima de R$" + minBid.toFixed(2) + ".").css("color", "red").fadeIn().delay(2000).fadeOut();
            return; // Impede o envio do formulário
        }

        $.ajax({
            url: "auction",
            method: "POST",
            data: $(this).serialize(),
            success: function() {
                $("#bid-message").text("Lance aceito!").css("color", "green").fadeIn().delay(2000).fadeOut();
            }
        });
    });
});
