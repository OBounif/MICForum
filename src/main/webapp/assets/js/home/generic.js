$(document).ready(function(){
  
  	var $forum_l = $("#forum_l");
    var $nav_list = $("#nav_list_main");

    var $message_label = $("#message_label");
    var $nav_message = $("#messages_list");
    
    var $notification_label = $("#notification_label");
    var $nav_notification = $("#notifications_list");

    var $profile_pic = $("#prof_image");
    var $nav_profile = $("#prof_list");

    $forum_l.mouseenter(function(){
        $nav_list.toggle();
    });

    $forum_l.mouseleave(function(){
        $nav_list.toggle();
    });


    $message_label.mouseenter(function(){
        $nav_message.toggle();
    });

    $message_label.mouseleave(function(){
        $nav_message.toggle();
    });

    $notification_label.mouseenter(function(){
        $nav_notification.toggle();
    });

    $notification_label.mouseleave(function(){
        $nav_notification.toggle();
    });
    

    $profile_pic.mouseenter(function(){
        $nav_profile.toggle();
    });

    $profile_pic.mouseleave(function(){
        $nav_profile.toggle();
    });
    
    
});