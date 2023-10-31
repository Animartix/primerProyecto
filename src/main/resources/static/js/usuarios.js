// Call the dataTables jQuery plugin
$(document).ready(function() {
/*	alert('hola mona shosha');*/
	cargarUsuarios();
	
  $('#usuarios').DataTable();
});

async function cargarUsuarios(){
	
		const request = await fetch('api/usuarios', {
			method: 'GET',
			headers: {
				'Accept': 'application/json',
				'Content-Type': 'application/json'
			},
			
		});
		const usuarios = await request.json();
		
		let listadoHTML='';
	
	for(let usuario of usuarios){
		
		let botonEliminar= '<a href="#" onclick="eliminarUsuario('+ usuario.id + ')" class="btn btn-danger btn-circle btn-sm"> <i class="fas fa-trash"></i>'
		
		let usuarioHtml='<tr><td> ' + usuario.id + '</td><td>' + usuario.nombre +
		                '</td><td>' + usuario.apellido + '</td><td>' + usuario.email +
		                '</td><td>' + usuario.telefono + '</td><td>' + botonEliminar + 
		                '</td></tr>';
		                
		listadoHTML+=usuarioHtml;                
	}
	document.querySelector('#usuarios tbody').outerHTML=listadoHTML;
}
async function eliminarUsuario(id){
	//alert(id);
    if(!confirm('Desea eliminar el usuario?')){
//	if(!confirm('Desea eliminar el usuario '+ usuario.nombre + ' ' + usuario.apellido + '?')){
		return;
	}
	const request = await fetch('api/usuarios/' + id, {
		method: 'DELETE',
		headers: {
			'Accept': 'application/json',
			'Content-Type': 'application/json'
		},
	});
	location.reload();
}