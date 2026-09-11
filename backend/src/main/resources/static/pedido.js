const formulario = document.getElementById("formPedido");

formulario.addEventListener("submit", async function(event) {

    event.preventDefault();

    const pedido = {
        cliente: document.getElementById("cliente").value,
        producto: document.getElementById("producto").value,
        cantidad: parseInt(document.getElementById("cantidad").value),
        precio: parseFloat(document.getElementById("precio").value),
        fecha: document.getElementById("fecha").value
    };

    const respuesta = await fetch("/api/pedidos", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(pedido)
    });

    if (respuesta.ok) {
        alert("Pedido registrado correctamente");
        formulario.reset();
    } else {
        alert("Error al registrar el pedido");
    }
});