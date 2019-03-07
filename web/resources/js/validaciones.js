/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

 function solonumeros(e){
            key=e.keyCode || e.which ;
            teclado=String.fromCharCode(key) ;
            numeros="0123456789";
            especiales="8-37-38-46";
            teclado_especial=false ;

            for(var i in especiales){
                if(key==especiales){
                teclado_especial=false;}
            }
            if(numeros.indexOf(teclado)==-1 && !teclado_especial){ return false;}
        }
    
      
        function direccion(e){
            key=e.keyCode || e.which ;
            teclado=String.fromCharCode(key) ;
            direccion="abcdefghijklmnñopqrstvwxyz_°";
            especiales="8-37-38-46";
            teclado_especial=false ;

            for(var i in especiales){
                if(key==especiales){
                teclado_especial=true;}
            }
   			  if(direccion.indexOf(teclado)==-1 && !teclado_especial){ return false;}
        }
  
        function sololetras(e){
            key=e.keyCode || e.which ;
            teclado=String.fromCharCode(key) ;
            letras="abcdefghijklmnñopqrstuvwxyz ABCDEFGHIJKLMNOPQRSTUVWXYZ ";
            especiales="08-37-38-46-32-39-127";
            teclado_especial=false ;
            for(var i in especiales){
                if(key==especiales){
                    teclado_especial=true} }

            if(letras.indexOf(teclado)==-1 && !teclado_especial){ return false; }
        }
    
   function validarEmail(mail) {  
  return /^\w+([\.\+\-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,4})+$/.test(mail); 
} 
    
