$(document).ready(function(){
    
    const MAX_IMAGE_SIZE = 2097152; // 2MB 

    const MAX_BIGT_LENGTH = 255;
    const MAX_MEDT_LENGTH = 30;


    const MIN_PASS_LENGTH = 6;

    const validImageTypes = ['image/gif', 'image/jpeg', 'image/png'];

    const $i_exclam = $("<i class=\"fas fa-exclamation-circle\"></i>");
    const $i_check = $("<i class=\"fas fa-check-circle\"></i>");

    var $block_status = $("#block_status");

    var $general_inf_item = $("#general_inf");
    var $passw_ch_item = $("#pass_ch");


    var $general_inf = $("#general_info_ch");
    var $passw_ch = $("#passwd_ch");

    var $user_cover_pic=$("#user_coverpic");
    var $user_prof_pic=$("#user_profpic");


    var $pass_form = $("#passwd_ch");
    var $general_form = $("#general_info_ch");

    var $butt_passw_sub = $("#butt_passw_sub");
    var $butt_general_inf_sub =$("#butt_general_inf_sub");


    var $sig_input = $("#user_signature");
    var $addr_input = $("#user_address");
    var $userfb_input = $("#user_facebook");
    var $usertwitter_input = $("#user_twitter");
    var $usergithub_input = $("#user_github");
    
    var $old_pass_input = $("#user_oldpass");
    var $new_pass_input = $("#user_newpass");
    var $new_pass_conf_input = $("#user_newpassconf");


    var $user_city = $("#user_city");
    var $user_country=$("#user_country");
    

    const COVER_IMG = 0x01;
    const PROF_IMG = 0x02;
    const SIG_IMG = 0x04;
    const GENERIC_FIELD = 0x08;



    var status= 0x00;

    $general_inf_item.click(function(){
        if($general_inf.css("display") == "none")
        {
            $passw_ch_item.removeClass("selected");
            $passw_ch.css("display",'none');

            $general_inf_item.addClass("selected");
            $general_inf.css("display","block");

            $block_status.find("p").remove();
            $block_status.removeClass("error");
            status = 0x00;
        }
    });

    $passw_ch_item.click(function(){
        
        if($passw_ch.css("display") == "none")
        {
            $general_inf_item.removeClass("selected");
            $general_inf.css("display",'none');

            $passw_ch_item.addClass("selected");
            $passw_ch.css("display","flex");

            $block_status.find("p").remove();
            $block_status.removeClass("error");
            status = 0x00;
        }
    });


    $user_cover_pic.change(function(e) {

        var image, file;
        if ((file = this.files[0])) {
            
            if(!validImageTypes.includes(file.type))
            {
                status |= COVER_IMG;
                log(COVER_IMG,"Charger seulment des images",true);
                return;
            } 
            else{

                if(status & COVER_IMG)
                    status &= ~COVER_IMG;
                
                    $block_status.children("#x"+COVER_IMG).remove();
                    refreshStatus()
            }

            if(file.size > MAX_IMAGE_SIZE)
            {
                status |= COVER_IMG;
                log(COVER_IMG,"La taille de l'image ne doit pas dépasser 2MB",true);
                return;
            } 
            else{

                if(status & COVER_IMG)
                    status &= ~COVER_IMG;
                
                    $block_status.children("#x"+COVER_IMG).remove();
                    refreshStatus()
            }
            
            image = new Image();
            image.onload = function() {
                    src = this.src;
                    $("#img_cover_pic").attr("src",src);
                    e.preventDefault();
                }
            };
            image.src = URL.createObjectURL(file);
    });
    
    $user_prof_pic.change(function(e) {

    var image, file;
    if ((file = this.files[0])) {

        if(!validImageTypes.includes(file.type))
        {
                status |= PROF_IMG;
                log(PROF_IMG,"Charger seulment des images",true);
                return;
        }
        else{
            
            if(status & PROF_IMG)
                status &= ~PROF_IMG;
            
                $block_status.children("#x"+PROF_IMG).remove();
                refreshStatus()
        }

        if(file.size > MAX_IMAGE_SIZE)
            {
                status |= PROF_IMG;
                log(PROF_IMG,"La taille de l'image ne doit pas dépasser 2MB",true);
                return;
            } 
            else{

                if(status & PROF_IMG)
                    status &= ~PROF_IMG;
                
                    $block_status.children("#x"+PROF_IMG).remove();
                    refreshStatus()
            }

        image = new Image();
        image.onload = function() {
                console.log(this);
                src = this.src;
                $("#img_profile_pic").attr("src",src);
                e.preventDefault();
            }
        };

        image.src = URL.createObjectURL(file);
});

    $addr_input.change(function() {
        generic_func_over($(this),"Address",16,MAX_BIGT_LENGTH) //2⁴ bit order
    });
    $userfb_input.change(function(){
        generic_func_over($(this),"Facebook url",32,MAX_BIGT_LENGTH); // 2^5
    });
    $usertwitter_input.change(function(){
        generic_func_over($(this),"Twitter url",64,MAX_BIGT_LENGTH); //2⁶
    });
    $usergithub_input.change(function(){
        generic_func_over($(this),"Github url",128,MAX_BIGT_LENGTH); // 2⁷ 
    });

    $sig_input.change(function(){
            generic_func_over($(this),"Signature",SIG_IMG,MAX_BIGT_LENGTH); // 2^4
    });
    $user_city.change(function(){
        generic_func_over($(this),"Ville",256,MAX_MEDT_LENGTH); // 2^8
    });
    $user_country.change(function(){
        generic_func_over($(this),"Pays",512,MAX_MEDT_LENGTH); // 2^9
    });

    function log(id,str,error)
    {    
                var $new_p = $("<p>",{
                    id : "x"+id
                });

                if($("#"+$new_p.attr("id")).length)
                    $("#"+$new_p.attr("id")).remove();

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

    

    $butt_general_inf_sub.click(function(e){
        e.preventDefault();

        if(!status)
            $general_form.submit();
    });

    

    function refreshStatus()
    {
        if(!status)
        {
            if($block_status.css("display") == "block")
                $block_status.hide();    
        }
    }


    generic_func_over = function($object,field,GENERIC_FIELD,comparedTo)
    {
        if($object.val().length > comparedTo)
        {
            status |= GENERIC_FIELD;
            $object.css({
                borderColor : "rgba(247, 30, 52, 0.5)"
            })
            log(GENERIC_FIELD,field+" ne doit pas dépasser "+comparedTo+" caractères.",true);
        }   
        else{

            if(status & GENERIC_FIELD)
            {
                status &= ~GENERIC_FIELD;
               
            } 
            $object.css({
                    borderColor : "rgba(6, 133, 17, 0.3)"
                })
                
            $block_status.children("#x"+GENERIC_FIELD).remove();
            refreshStatus()
        }
    };

    generic_func_under = function($object,field,GENERIC_FIELD,comparedTo)
    {
        if($object.val().length < comparedTo)
        {
            status |= GENERIC_FIELD;
            $object.css({
                borderColor : "rgba(247, 30, 52, 0.5)"
            })
            log(GENERIC_FIELD,field+" doit contenir au moins "+comparedTo+" caractères.",true);
        }   
        else{

            if(status & GENERIC_FIELD)
            {
                status &= ~GENERIC_FIELD;
               
            } 
            $object.css({
                    borderColor : "rgba(6, 133, 17, 0.3)"
                })
                
            $block_status.children("#x"+GENERIC_FIELD).remove();
            refreshStatus()
        }
    };

    $old_pass_input.change(function(){
        generic_func_under($(this),"Ancien mot de pass",32,MIN_PASS_LENGTH);
    });

    $new_pass_input.change(function(){
        generic_func_under($(this),"Ancien mot de pass",64,MIN_PASS_LENGTH);
    });
    $new_pass_conf_input.change(function(){
        generic_func_under($(this),"Ancien mot de pass",128,MIN_PASS_LENGTH);
    });
    
     $new_pass_conf_input.change(function(){
        generic_func_under($(this),"Champ de confirmation",128,MIN_PASS_LENGTH);
        
        if( ( status & 128 ) || $new_pass_input.val() == '')
            return;

        if($(this).val() != $new_pass_input.val())
        {
            status |= 128;
            $(this).css({
                borderColor : "rgba(247, 30, 52, 0.5)"
            })
            log(128,"Les mots de passe ne correspondent pas",true);
        }
        else{
            if(status & 128)
            {
                status &= ~128;
               
            } 
            $(this).css({
                    borderColor : "rgba(6, 133, 17, 0.3)"
                })
                
            $block_status.children("#x"+128).remove();
            refreshStatus()
        }
    });
    
    
    $butt_passw_sub.click(function(e){
        e.preventDefault();
        if(status)
            return;

        if($old_pass_input.val().length == 0)
            log(32,"Ancien mot de passe ne peut pas être vide.",true);

        if($new_pass_input.val().length == 0)
            log(64,"Nouveau mot de passe ne peut pas être vide.",true);

        if($new_pass_conf_input.val().length == 0)
            log(128,"Champ de confirmation ne peut pas être vide.",true);

        
        if($block_status.find("p").length > 0)
            return;

        
        $passw_ch.submit();
    });

});



