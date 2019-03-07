
var documUsuario = document.getElementById('documUsuario');
var errorDiv = document.getElementById('error');
if (typeof documUsuarioO !== 'undefined') {
  documUsuario.addEventListener('blur',validacionCampos);
}


function validacionCampos(){
	if (this.value === '') {
		errorDiv.style.diplay = 'block';
		errorDiv.style.border = '1px solid red';
                errorDiv.innerHTML = 'Campo obligatorio';
	}
}