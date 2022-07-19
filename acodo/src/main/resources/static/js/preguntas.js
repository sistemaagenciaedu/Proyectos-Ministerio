function noVerOpciones(){
    var divOpciones=document.getElementById("opciones-campos")
    divOpciones.setAttribute("style","display:none !important")
    var formcreador=document.getElementById("form-creador")
    formcreador.setAttribute("style","display:none !important")
}

noVerOpciones()
function tipoPregunta(){
    var tipo=document.getElementById("tipo").value
if(tipo==="OPCIONES"){
    var divOpciones=document.getElementById("opciones-campos")
    divOpciones.removeAttribute("style","display:none !important")
}else{
    var divOpciones=document.getElementById("opciones-campos")
    divOpciones.setAttribute("style","display:none !important")
}
}
function mostrarcreador(){
    var formcreador=document.getElementById("form-creador")
    formcreador.removeAttribute("style","display:none !important")
}
