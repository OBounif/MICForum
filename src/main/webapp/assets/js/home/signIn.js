$(document).ready(function(){

    const $i_exclam = $("<i class=\"fas fa-exclamation-circle\"></i>");
    const $i_check = $("<i class=\"fas fa-check-circle\"></i>");
    var $sign_status = $("#sign_in_status");

    //window.location.replace("http://www.w3schools.com");
    
    log(1,"Password confirmation should not be empty",false);

    
    function log(id,str,error)
    {
        
        var $new_p = $("<p>",{
            id : "x"+id
        });

        if(error)
        {
            $new_p.text(str).prepend($i_exclam.clone());
            $sign_status.addClass("error");
        }
        else
        {
            $new_p.text(str).prepend($i_check.clone());
            $sign_status.addClass("success");
        }
    
        $sign_status.append($new_p);    
        $sign_status.show();
    }



});