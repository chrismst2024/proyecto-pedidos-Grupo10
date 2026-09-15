const formulario = document.getElementById("formProducto");

formulario.addEventListener("submit", async function(event) {

    event.preventDefault();

    const producto = {
        nombre: document.getElementById("nombre").value,
        descripcion: document.getElementById("descripcion").value,
        precio: parseFloat(document.getElementById("precio").value),
        stock: parseInt(document.getElementById("stock").value),
        categoria: document.getElementById("categoria").value,
        unidadMedida: document.getElementById("unidadMedida").value
    };

    const respuesta = await fetch("/api/productos", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(producto)
    });

    if (respuesta.ok) {
        alert("Producto registrado correctamente");
        formulario.reset();
    } else {
        alert("Error al registrar el producto");
    }
});