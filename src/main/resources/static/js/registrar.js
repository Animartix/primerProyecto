$(document).ready(function() {
//	registrarUsuario();
});
/*$(document).ready(function() {
    $('#btnRegistrar').on('click', function(e) {
        e.preventDefault(); // Evita el comportamiento predeterminado del enlace

        registrarUsuario();
    });*/

async function registrarUsuario(){
	let datos={};
	datos.nombre=document.getElementById('txtNombre').value;
	datos.apellido=document.getElementById('txtApellido').value;
	datos.email=document.getElementById('txtEmail').value;
	datos.telefono=document.getElementById('txtTelefono').value;
	datos.password=document.getElementById('txtPassword').value;
	
	let repetirPassword=document.getElementById('txtRepetirPassword').value;
	if(repetirPassword!=datos.password){
		alert('la contraseña es incorrecta')
		return;
	}
	
	const request = await fetch('api/usuarios',{
		method: 'POST',
		headers: {
			'Accept': 'application/json',
			'Content-Type': 'application/json'
		},
		body: JSON.stringify(datos)
	});
//	const usuarios = await request.json();

	alert('Usuario Registrado con éxito');
	window.location.href='login.html';
}