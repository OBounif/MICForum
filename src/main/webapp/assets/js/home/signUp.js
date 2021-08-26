$(document).ready(function(){

        const USERNAME=0x01;    
        const EMAIL=0x02;
        const PASSWORD=0x04;
        const PASSWORD_CONF=0x08;

       
        var status = 0x00,status_init = 0x00;

        const MIN_NAME_LENGTH = 5;
        const MIN_PASSWORD_LENGTH = 6; 

        const $i_exclam = $("<i class=\"fas fa-exclamation-circle\"></i>");
        const $i_check = $("<i class=\"fas fa-check-circle\"></i>");
        var $sign_status = $("#sign_up_status");


        var $form = $("#signup_f");
        var $username = $("#username");
        var $email = $("#email");
        var $password = $("#password");
        var $password_conf = $("#password_conf");
        var $rules = $("input[name=rules]");
        var $submit = $("#submit_butt");

  
        


        $username.keyup(function(){

            if($(this).val().length < MIN_NAME_LENGTH)
            {   
                if(status & USERNAME)
                     return;
                else
                {
                    $(this).css({
                        borderColor : "rgba(255,0,0,.5)"
                    });
                    log(USERNAME,"Username must contains at least "+MIN_NAME_LENGTH+" characters",true);
                    status |= USERNAME;
                }
            }
            else
            {
                $(this).css({
                    borderColor : "rgba(14, 97, 14, 0.5)"
                });

                if(status & USERNAME)
                {
                    status &= ~USERNAME;
                    status_init &= ~USERNAME;

                    $sign_status.children("#x"+USERNAME).remove();
                    refreshStatus()
                }
            }
            
        });

        $password.keyup(function(){

            if($(this).val().length < MIN_PASSWORD_LENGTH)
            {   
                if(status & PASSWORD)
                     return;
                else
                {
                    $(this).css({
                        borderColor : "rgba(255,0,0,.5)"
                    });
                    log(PASSWORD,"PASSWORD must contains at least "+MIN_PASSWORD_LENGTH+" characters",true);
                    status |= PASSWORD;
                }
            }
            else
            {
                $(this).css({
                    borderColor : "rgba(14, 97, 14, 0.5)"
                });

                if(status & PASSWORD)
                {
                    status &= ~PASSWORD;
                    status_init &= ~PASSWORD;

                    $sign_status.children("#x"+PASSWORD).remove();
                    refreshStatus()
                }
            }

        });

        $password_conf.keyup(function(){

            if($password.val() == "")
                return;

            if( $(this).val().length < MIN_PASSWORD_LENGTH || $(this).val() != $password.val())
            {
                if(status & PASSWORD_CONF)
                  return;
                else
                {
                    $(this).css({
                        borderColor : "rgba(255,0,0,.5)"
                    });
                    log(PASSWORD_CONF,"Password does not matches",true);
                    status |= PASSWORD_CONF;
                }
            }
            else
            {
                $(this).css({
                    borderColor : "rgba(14, 97, 14, 0.5)"
                });

                if(status & PASSWORD_CONF)
                {
                    status &= ~PASSWORD_CONF;
                    status_init &= ~PASSWORD_CONF;

                    $sign_status.children("#x"+PASSWORD_CONF).remove();
                    refreshStatus()
                }
            }
        });

        $email.keyup(function(){
                if(!validateEmail($email))
                {
                    if(status & EMAIL)
                        return;
                    else
                    {
                        $(this).css({
                            borderColor : "rgba(255,0,0,.5)"
                        });
                        log(EMAIL,"Email format not valid",true);
                        status |= EMAIL;
                    }
                }
                else
                {
                    $(this).css({
                        borderColor : "rgba(14, 97, 14, 0.5)"
                    });
    
                    if(status & EMAIL)
                    {
                        status &= ~EMAIL;
                        status_init &= ~EMAIL;


                        $sign_status.children("#x"+EMAIL).remove();
                        refreshStatus()
                    }
                }
        });

        $submit.click(function(event){
            event.preventDefault();


            verify(USERNAME,$username);
            verify(EMAIL,$email);
            verify(PASSWORD,$password);
            verify(PASSWORD_CONF,$password_conf);

            
            if(!status && !status_init)
                $form.submit();
        
        });









        function verify(CONSTANTE,$field)
        {
            if($field.val() == "")
            {
                $field.css({
                    borderColor : "rgba(255,0,0,.5)"
                });
                switch (CONSTANTE) {
                    case USERNAME:
                        log(USERNAME,"Username should not be empty",true);
                        break;
                
                    case PASSWORD_CONF:
                        log(PASSWORD_CONF,"Password confirmation should not be empty",true);
                        break;
                    case PASSWORD :
                        log(PASSWORD,"Password should not be empty",true);
                        break;
                    case EMAIL:
                        log(EMAIL,"Email should not be empty",true);
                        break
                }
                status_init |= CONSTANTE;
            }
        }

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

        function refreshStatus()
        {
            if(!status && !status_init)
            {
                if($sign_status.css("display") == "block")
                    $sign_status.hide();    
            }
        }


        function validateEmail($mail)
        {
             const test = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
             return test.test($mail.val());
        }
});