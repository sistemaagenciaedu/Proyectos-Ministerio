function mostrarFormulario(){
    var formulario=document.getElementById("form-creador")
    formulario.setAttribute("style","display:flex !important")
}
function noverFomulario(){
    var formulario=document.getElementById("form-creador")
    formulario.removeAttribute("style","display:flex !important")
}

function cargarDatos(index){
var idtabla=document.getElementById("id"+index).innerText
var nombretabla=document.getElementById("nombre"+index).innerText
var idform=document.getElementById("id")
var nombreform=document.getElementById("nombre")
idform.value=idtabla
nombreform.value=nombretabla
    console.log(idtabla)
    console.log(nombretabla)
    var formulario=document.getElementById("form-creador")
    formulario.setAttribute("style","display:flex !important")

}
