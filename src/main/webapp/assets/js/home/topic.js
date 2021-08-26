$(document).ready(function(){

       
        var $message_container = $(".message_container");
        var $list_share = $(".list_share");
        var $list_ope = $(".list_op");
        var $ope = $(".ope");
        var $share = $(".share")

        $ope.mouseenter(function(){
            $(this).children(".list_op").slideDown();
        });

        $share.mouseenter(function(){
            $(this).children(".list_share").slideDown();
        });

        $list_share.mouseleave(function(){
            $(this).slideUp();
        });


        $list_ope.mouseleave(function(){
            console.log("dza")
            $(this).slideUp();
        });

        $message_container.mouseleave(function(){
            $(this).find(".list_op").slideUp();
            $(this).find(".list_share").slideUp();
        });
});