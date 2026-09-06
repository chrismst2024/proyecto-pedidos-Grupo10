const formulario = document.getElementById("formCliente");

formulario.addEventListener("submit", async function(event) {

    event.preventDefault();

    const cliente = {
        nombre: document.getElementById("nombre").value,
        apellido: document.getElementById("apellido").value,
        documento: document.getElementById("documento").value,
        telefono: document.getElementById("telefono").value,
        correo: document.getElementById("correo").value,
        direccion: document.getElementById("direccion").value
    };

    const respuesta = await fetch("/api/clientes", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(cliente)
    });

    if (respuesta.ok) {
        alert("Cliente registrado correctamente");
        formulario.reset();
    } else {
        alert("Error al registrar el cliente");
    }
});