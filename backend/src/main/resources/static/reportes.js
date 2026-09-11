document.addEventListener("DOMContentLoaded", () => {
    fetch('/api/reportes/resumen')
        .then(response => response.json())
        .then(data => {
            document.getElementById('txtClientes').textContent = data.totalClientes;
            document.getElementById('txtProductos').textContent = data.totalProductos;
            document.getElementById('txtInventario').textContent = `$ ${data.valorInventario.toFixed(2)}`;
        })
        .catch(error => console.error('Error al cargar resumen:', error));

    fetch('/api/reportes/productos-por-categoria')
        .then(response => response.json())
        .then(data => {
            const lista = document.getElementById('listaCategorias');
            lista.innerHTML = '';
            data.forEach(item => {
                const li = document.createElement('li');
                li.className = 'list-group-item d-flex justify-content-between align-items-center';
                li.innerHTML = `${item.nombre} <span class="badge bg-primary rounded-pill">${item.valor}</span>`;
                lista.appendChild(li);
            });
        })
        .catch(error => console.error('Error al cargar categorias:', error));
});