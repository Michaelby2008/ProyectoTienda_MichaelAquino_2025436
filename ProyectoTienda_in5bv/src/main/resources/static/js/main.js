// --- FUNCIONES DEL SIDEBAR ---

function openNav() {
    // Abre el menú
    document.getElementById("mySidenav").style.width = "250px";
    // Empuja el contenido hacia la derecha
    document.getElementById("main").style.marginLeft = "250px";
    // Oscurece un poco más el fondo para resaltar el menú
    document.body.style.backgroundColor = "#0a0a0a";
}

function closeNav() {
    // Cierra el menú
    document.getElementById("mySidenav").style.width = "0";
    // Devuelve el contenido a su sitio
    document.getElementById("main").style.marginLeft = "0";
    // Devuelve el fondo a su color Dark Mode original
    document.body.style.backgroundColor = "#121212";
}

// --- FUNCIONES DEL MODAL Y FORMULARIO DINÁMICO ---

function openModal() {
    document.getElementById("actionModal").style.display = "block";
    resetForm(); // Limpiamos y bloqueamos todo al abrir
}

function closeModal() {
    document.getElementById("actionModal").style.display = "none";
}

// Cierra el modal si se hace clic fuera
window.onclick = function(event) {
    var modal = document.getElementById("actionModal");
    if (event.target === modal) {
        closeModal();
    }
}

// Función para reiniciar el formulario al estado base (todo deshabilitado)
function resetForm() {
    document.getElementById('userForm').reset();
    document.getElementById('userId').disabled = true;
    document.getElementById('userName').disabled = true;
    document.getElementById('userLastname').disabled = true;
    document.getElementById('userAge').disabled = true;
    document.getElementById('submitBtn').style.display = 'none';
    document.getElementById('modalTitle').innerText = 'Menú de Acciones';
}

// Lógica principal: habilita/deshabilita inputs según la acción
function setMode(mode) {
    const idInput = document.getElementById('userId');
    const nameInput = document.getElementById('userName');
    const lastnameInput = document.getElementById('userLastname');
    const ageInput = document.getElementById('userAge');
    const submitBtn = document.getElementById('submitBtn');
    const form = document.getElementById('userForm');
    const title = document.getElementById('modalTitle');

    // Mostramos el botón de enviar
    submitBtn.style.display = 'block';

    if (mode === 'add') {
        title.innerText = "Agregar Nuevo Usuario";
        idInput.disabled = true;      // ID bloqueado (suele ser autoincrementable)
        nameInput.disabled = false;   // Nombre habilitado
        lastnameInput.disabled = false; // Apellido habilitado
        ageInput.disabled = false;    // Edad habilitada

        submitBtn.innerText = "Guardar Usuario";
        submitBtn.style.backgroundColor = "#217346"; // Verde
        form.action = "/usuarios/guardar"; // <--- Ajusta a la ruta de tu @PostMapping en SpringBoot

    } else if (mode === 'update') {
        title.innerText = "Actualizar Usuario Existente";
        idInput.disabled = false;     // ID habilitado (necesario para saber cuál actualizar)
        nameInput.disabled = false;   // Nombre habilitado
        lastnameInput.disabled = false; // Apellido habilitado
        ageInput.disabled = false;    // Edad habilitada

        submitBtn.innerText = "Guardar Cambios";
        submitBtn.style.backgroundColor = "#0078d4"; // Azul
        form.action = "/usuarios/actualizar"; // <--- Ajusta a la ruta de tu backend

    } else if (mode === 'delete') {
        title.innerText = "Eliminar Usuario";
        idInput.disabled = false;     // ID habilitado (solo necesitamos el ID para borrar)
        nameInput.disabled = true;    // Nombre bloqueado
        lastnameInput.disabled = true;  // Apellido bloqueado
        ageInput.disabled = true;     // Edad bloqueada

        submitBtn.innerText = "Confirmar Eliminación";
        submitBtn.style.backgroundColor = "#d83b01"; // Rojo
        form.action = "/usuarios/eliminar"; // <--- Ajusta a la ruta de tu backend
    }
}