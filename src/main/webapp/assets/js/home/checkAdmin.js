$(document).ready(function()
{
    const $i_exclam = $("<i class=\"fas fa-exclamation-circle\"></i>");
    const $i_check = $("<i class=\"fas fa-check-circle\"></i>");


    const MIN_MEDT_LENGTH = 6;
    const FORM_PASS_CHECK = 0X01;

    var status=0x00;


    var $form_pass_conf = $("#form_passw_check");

    var $butt_send =$("#send_butt");

    var $pass_input = $("#pass_input");

    var $block_status =$("#block_status");


    $pass_input.change(function(){
        
        if($(this).val().length < MIN_MEDT_LENGTH)
        {
            if(status & FORM_PASS_CHECK)
                return;
                
            status |= FORM_PASS_CHECK;
            $(this).css({
                borderColor : "rgba(247, 30, 52, 0.5)"
            })
            log(FORM_PASS_CHECK,"Password doit contenir au minimum "+MIN_MEDT_LENGTH+" caractères.",true);
        }   
        else{
             if(status & FORM_PASS_CHECK)
                    {
                        status &= ~FORM_PASS_CHECK;
                    
                    } 
                    $(this).css({
                            borderColor : "rgba(6, 133, 17, 0.3)"
                        })
                        
                    $block_status.children("#x"+FORM_PASS_CHECK).remove();
                    refreshStatus()
            }
    });

    function log(id,str,error)
    {
        
        var $new_p = $("<p>",{
            id : "x"+id
        });

        if(error)
        {
            $new_p.text(str).prepend($i_exclam.clone());
            $block_status.addClass("error");
        }
        else
        {
            $new_p.text(str).prepend($i_check.clone());
            $block_status.addClass("success");
        }
    
        $block_status.append($new_p);    
        $block_status.show();
    }


    function refreshStatus()
    {
        if(!status)
        {
            if($block_status.css("display") == "block")
                $block_status.hide();    
        }
    }
});