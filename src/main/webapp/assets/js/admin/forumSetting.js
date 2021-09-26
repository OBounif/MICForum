$(document).ready(function(){
    
    const $i_exclam = $("<i class=\"fas fa-exclamation-circle\"></i>");
    const $i_check = $("<i class=\"fas fa-check-circle\"></i>");

    const MAX_BIGT_LENGTH = 255;
    const MAX_MEDT_LENGTH = 30;
    

    const MIN_MEDT_LENGTH = 6;



    var status = 0x00;

    const FORUM_TITLE = 0x01;
    const FORUM_DESCRIPTION = 0X02;

    var $forum_add = $("#forum_add");
    var $forum_search = $("#forum_search");
    
    var $forum_add_button = $("#forum_add_butt");
    var $forum_search_button = $("#forum_search_butt");

    var $block_status = $("#block_status");

    var $forum_add_item = $("#forum_add_item");
    var $search_forum_item = $("#search_forum_item");

    
    var $forum_title_search = $("#forum_title_search");
    var $forum_title_input = $("#forum_title");
    var $forum_description_input = $("#forum_description");
    
    $forum_add_item.click(function(){
        if($forum_add.css("display") == "none")
        {
            $search_forum_item.removeClass("selected");
            $forum_search.css("display",'none');

            $forum_add_item.addClass("selected");
            $forum_add.css("display","block");

            $block_status.find("p").remove();
            $block_status.removeClass("error");

            status = 0x00;
            $forum_add.trigger("reset");
            $forum_add_item.removeClass("error success");
        }
    });


    $search_forum_item.click(function(){
        
        if($forum_search.css("display") == "none")
        {
            $forum_add_item.removeClass("selected");
            $forum_add.css("display",'none');

            $search_forum_item.addClass("selected");
            $forum_search.css("display","block");

            $block_status.find("p").remove();
            $block_status.removeClass("error");
           
            status = 0x00;
            /*
                Or forum_add.reset();
             */
            $forum_add.trigger("reset");
            $forum_add.find(".genera_style_inp").css({
                borderColor : "rgba(219, 219, 219,1)"
            })
        }
    });


     $forum_description_input.change(function(){
        
        if($(this).val().length > MAX_BIGT_LENGTH)
        {
            status |= FORUM_DESCRIPTION;
            $(this).css({
                borderColor : "rgba(247, 30, 52, 0.5)"
            })
            log(FORUM_DESCRIPTION,"Forum title ne doit pas dépasser "+MAX_BIGT_LENGTH+" caractères.",true);
        }   
        else{
             if(status & FORUM_TITLE)
                    {
                        status &= ~FORUM_DESCRIPTION;
                    
                    } 
                    $(this).css({
                            borderColor : "rgba(6, 133, 17, 0.3)"
                        })
                        
                    $block_status.children("#x"+FORUM_DESCRIPTION).remove();
                    refreshStatus()
            }
    })  

    var handler = function(){
        
        if($(this).val().length > MAX_MEDT_LENGTH)
        {
            status |= FORUM_TITLE;
            $(this).css({
                borderColor : "rgba(247, 30, 52, 0.5)"
            })
            log(FORUM_TITLE,"Forum title ne doit pas dépasser "+MAX_MEDT_LENGTH+" caractères.",true);
        }   
        else{

                if($(this).val().length < MIN_MEDT_LENGTH)
                {
                    status |= FORUM_TITLE;
                    $(this).css({
                        borderColor : "rgba(247, 30, 52, 0.5)"
                    })
                    log(FORUM_TITLE,"Forum title doit contenire au minimum "+MIN_MEDT_LENGTH+" caractères.",true);
                }
                else
                {
                    if(status & FORUM_TITLE)
                    {
                        status &= ~FORUM_TITLE;
                    
                    } 
                    $(this).css({
                            borderColor : "rgba(6, 133, 17, 0.3)"
                        })
                        
                    $block_status.children("#x"+FORUM_TITLE).remove();
                    refreshStatus()
                }
        }

     }

     $forum_title_input.change(handler) ;
     $forum_title_search.change(handler) ;
  
     
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

    $forum_add_button.click(function(e){
        e.preventDefault();

        if(!status)
            $forum_add.submit();
    })

    $forum_search_button.click(function(e){
        e.preventDefault();

        if(!status)
            $forum_search.submit();
    })

    
});


