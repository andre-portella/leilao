$(document).ready(function() {
    // Função para atualizar a tabela de lances
    function updateBids() {
        $("form button").prop("disabled", true);
        $("#bid_value").prop("disabled", true);

        $.ajax({
            url: "auction?product_id=" + productId,
            method: "GET",
            headers: {
                'X-Requested-With': 'XMLHttpRequest' // Cabeçalho para indicar que é uma requisição AJAX
            },
            success: function(response) {
                $("#bids-list").html(response); // Atualiza a tabela

                setTimeout(function() {
                    $("form button").prop("disabled", false);
                    $("#bid_value").prop("disabled", false);
                }, 2000);
            },
            error: function(xhr, status, error) {
               console.error("[ERRO]: ", error)
            }
        });
    }

    // Atualiza a tabela a cada 30 segundos
    setInterval(updateBids, 30000);

    // Envio do formulário via AJAX
    $("form").on("submit", function(event) {
        event.preventDefault(); // Impede o envio tradicional

        let bidValue = parseFloat($("#bid_value").val());

        // Verifica se o valor do lance é válido
        if (isNaN(bidValue) || bidValue < parseFloat(minBid)) {
            $("#bid-message").text("Faça um lance acima de R$ " + minBid.toFixed(2) + ".").css("color", "red").fadeIn().delay(2000).fadeOut();
            return; // Impede o envio do formulário
        }

        $.ajax({
            url: "auction",
            method: "POST",
            data: $(this).serialize(),
            success: function(response) {
                $("#bid-message").text("Lance aceito!").css("color", "green").fadeIn().delay(2000).fadeOut();
            },
            error: function(xhr, status, error) {
                $("#bid-message").text("[ERRO] lance não registrado.").css("color", "red").fadeIn().delay(2000).fadeOut();
            }
        });
    });
});
