const formulario = document.getElementById("formCliente");

if (formulario) {

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

}


async function listarClientes() {

    const respuesta = await fetch("/api/clientes");

    if (!respuesta.ok) {
        alert("Error al consultar los clientes");
        return;
    }

    const clientes = await respuesta.json();

    const tabla = document.getElementById("tablaClientes");

    if (!tabla) {
        return;
    }

    tabla.innerHTML = "";

    clientes.forEach(cliente => {

        const fila = document.createElement("tr");

        fila.innerHTML = `
            <td>${cliente.id}</td>
            <td>${cliente.nombre}</td>
            <td>${cliente.apellido}</td>
            <td>${cliente.documento}</td>
            <td>${cliente.telefono}</td>
            <td>${cliente.correo}</td>
            <td>${cliente.direccion}</td>
        `;

        tabla.appendChild(fila);
    });
}


if (document.getElementById("tablaClientes")) {
    listarClientes();
}