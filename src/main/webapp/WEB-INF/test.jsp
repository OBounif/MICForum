<!DOCTYPE html>
<html> 
<head>
    
        <title>MIC FORUM</title>
        <meta charset="UTF-8"/>
        <link rel="stylesheet" href="assets/css/style.css"/>
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.12.1/css/all.css" crossorigin="anonymous">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

 <!--      <style>
            /*LOGGED USER*/

            #f_h_c_leftSide
            {
                height: 100%;
                width: 40%;
                
                display: flex;
                flex-direction: column;

            }
            #f_h_c_leftSide_main
            {   
                width: 100%;

                display: flex;
                flex-direction: column;
            }

            #prof_upper_side
            {
                margin-top: 40px;
                margin-bottom: 10px;
                padding-top: 10px;

                display: flex;

            }
            #prof_image,#prof_image img{
                height: 80px;
                width: 80px;

                border-radius: 10px;
                
                cursor: pointer;
            }

            #prof_image
            {
                box-shadow: 1px 1px 3px rgba(0, 0, 0, .4);
            }

            #prof_image:hover
            {
                box-shadow: 1px 1px 3px rgba(0, 0, 0, .6);
            }

            #prof_text
            {
                align-self: center;
                flex: 1;
            }

            #prof_uname,#prof_group_name
            {
                text-align: center;

                color :rgba(24, 31, 65,1);
            }

            #prof_uname
            {
                cursor: pointer;
            }



            #prof_group_name
            {
                font-size: 15px;
                opacity: .8;

                cursor: pointer;
            }

            #prof_last_log
            {
                position: relative;
                top: 10px;
                left: 10px;;
                font-size: 13px;

                opacity: .8;
            }

            #prof_lower_side
            {
                padding-right: 15px;
                display: flex;
                justify-content: space-between;
                
                font-size: 21px;
                color :rgba(24, 31, 65,0.8);
            }

            #prof_lower_side i{
                cursor: pointer;
            }
            #prof_lower_side i:hover{
                color :rgba(24, 31, 65,1);
            }


            #p_l_s_l
            {
                width: 80px;
                display: flex;
                justify-content: space-between;
            }

            /***********************/
        </style>-->
</head>
<body> 
        <header id="forum_header_container">
                <div id="forum_header_container_main">              
                    <div id="f_h_c_leftSide">
                        <div id="f_h_c_leftSide_main">
                           <div id="prof_upper_side">
                                <div id="prof_image">
                                    <img src="./assets/images/logos/png.png"/>
                                    <div id="prof_list" >
                                        <ul>
                                            <li><a href="#">Profile </a></li>
                                            <li><a href="#">Paramètre</a></li>
                                            <li><a href="#">Déconnexion </a></li>
                                        </ul>
                                    </div>
                                </div>
                                <div id="prof_text">
                                    <h3 id="prof_uname">Fr3eX</h3>
                                    <h4 id="prof_group_name">&lt;&lt; Membre personnel &gt;&gt;</h4>
                                    <p id="prof_last_log">Last Login : </p>
                                </div>
                           </div>
                           <div id="prof_lower_side">
                                <div id="p_l_s_l">
                                    <i id="message_label" class="far fa-envelope">
                                        <div id="messages_list" >
                                            <ul>
                                                <li id="private_message_header_sec">
                                                    <p id="private_message_header">Messages</p>
                                                </li>
                                                <li>
                                                    <a href="#" class="priv_message"> 
                                                        <div class="priv_message_leftSide">
                                                            <img src="./assets/images/logos/png.png"/>
                                                        </div>
                                                        <div class="priv_message_rightSide">
                                                            <p class="priv_message_text">
                                                                hello OSSSSSSSSSSSSSSSmar !
                                                            </p>
                                                            <p class="priv_message_date">
                                                                2 m
                                                            </p>
                                                        </div>
                                                    </a>
                                                </li>
                                                
                                                <li>
                                                    <a href="#" class="priv_message"> 
                                                        <div class="priv_message_leftSide">
                                                            <img src="./assets/images/logos/png.png"/>
                                                        </div>
                                                        <div class="priv_message_rightSide">
                                                            <p class="priv_message_text">
                                                                hello OSSSSSSSSSSSSSSSmar !
                                                            </p>
                                                            <p class="priv_message_date">
                                                                2 m
                                                            </p>
                                                        </div>
                                                    </a>
                                                </li>
                                                <li>
                                                    <a href="#" class="priv_message"> 
                                                        <div class="priv_message_leftSide">
                                                            <img src="./assets/images/logos/png.png"/>
                                                        </div>
                                                        <div class="priv_message_rightSide">
                                                            <p class="priv_message_text">
                                                                hello OSSSSSSSSSSSSSSSmar !
                                                            </p>
                                                            <p class="priv_message_date">
                                                                2 m
                                                            </p>
                                                        </div>
                                                    </a>
                                                </li>
                                                <li>
                                                    <a href="#" class="priv_message"> 
                                                        <div class="priv_message_leftSide">
                                                            <img src="./assets/images/logos/png.png"/>
                                                        </div>
                                                        <div class="priv_message_rightSide">
                                                            <p class="priv_message_text">
                                                                hello OSSSSSSSSSSSSSSSmar !
                                                            </p>
                                                            <p class="priv_message_date">
                                                                2 m
                                                            </p>
                                                        </div>
                                                    </a>
                                                </li>
                                                <li>
                                                    <a href="#" class="priv_message"> 
                                                        <div class="priv_message_leftSide">
                                                            <img src="./assets/images/logos/png.png"/>
                                                        </div>
                                                        <div class="priv_message_rightSide">
                                                            <p class="priv_message_text">
                                                                hello OSSSSSSSSSSSSSSSmar !
                                                            </p>
                                                            <p class="priv_message_date">
                                                                2 m
                                                            </p>
                                                        </div>
                                                    </a>
                                                </li>
                                            </ul>
                                        </div>   
                                    </i>

                                    <i id="notification_label" class="far fa-bell">
                                        <div id="notifications_list"  >
                                            <ul>
                                                <li id="notification_header_sec">
                                                    <p id="notification_header_text">Notifications</p>
                                                </li>
                                                <li>
                                                    <a href="#" class="notif_list"> 
                                                        <div class="notif_leftSide">
                                                            <img src="./assets/images/logos/png.png"/>
                                                        </div>
                                                        <div class="notif_rightSide">
                                                            <p class="notif_text">
                                                                hello OSSSSSSSSSSSSSSSmar !
                                                            </p>
                                                            <p class="notif_date">
                                                                Il ya 2 heures
                                                            </p>
                                                        </div>
                                                    </a>

                                                </li>
                                          
                                            </ul>
                                        </div>      
                                    </i>
                                </div>
                                <div id="p_l_s_r">
                                    <i class="fas fa-sign-out-alt"></i>
                                </div>
                           </div>
                        </div>
                    </div>

                    <div id="f_h_c_rightSide">
                        <div id="f_h_c_rightSide_main">
                            <div id="big_banner">
                                <div id="big_banner_controls">
                                    <a id="exit"></a>
                                    <a id="hide"></a>
                                    <a id="restore"></a>
                                </div>
                                <div id="big_banner_body">
                                        <h2>Morrocan's It Community</h2>
                                        <h3>Programming~Networking~Hacking</h3>
                                </div>
                                <p id="bash_entry"><span id="u_m_n">Undefined@MIC:</span><span style="color: blue;">~</span>$gcc exploit.c -o exploit && ./exploit</p>
                            </div>
                        </div>
                    </div>
                </div>
        </header>

        
        <nav id="forum_nav_container">
            <div id="forum_nav_container_main">
               <div id="nav_list">
                    <ul>
                        <li><a href="#"><i class="fas fa-home" style="margin-right: 5px;"></i>HOME</a></li>
                        <li id="forum_l"><a href="#"><i class="fas fa-align-justify" style="margin-right: 5px;"></i>FORUM</a>
                            <div id="nav_list_main" >
                                <ul>
                                    <li><a href="#"> <i class="fas fa-comments"></i>Forums </a></li>
                                    <li><a href="#"><i class="fas fa-trophy"></i> Leader Board </a></li>
                                    <li><a href="#"><i class="fas fa-users"></i> Staff </a></li>
                                    <li><a href="#"> <i class="fas fa-signal"></i>Online members </a></li>
                                </ul>
                            </div>
                        </li>
                        <li><a href="#"><i class="fab fa-discord" style="margin-right: 5px;"></i>DISCORD</a></li>
                    </ul>
               </div>
               <div id="nav_search">
                
               </div>
            </div>
        </nav>
        
        <div id="forum_body_container">
                <div id="forum_body_container_main">
                    <header id="forum_main_header">
                        <p id="current_location">
                            <i class="fas fa-home" style="font-size: 15px;color: rgba(0,0,0,.7);"></i> 
                           /<a href="#">home</a>/
                        </p>
                        <h1 id="forum_main_title">Morrocan's It Community</h1>
                    </header>
                    
                    <div id="shoutbox">
                        <header id="shoutbox_header" class="head">
                            <h3 id="shoutbox_title" class="head_title">ShoutBox</h3>
                        </header>
                        <div id="shoutbox_body">
                            <div id="shoutbox_background_cover">
                                <img src="assets/images/banners/micLeet.png"/>
                            </div>
                            <div id="user_messages">
                                 <!--
                                  <div class="umsg">
                                        <div class="umsg_uname">
                                            <div class="msg_ownpic">
                                                <img class="box_admin" src="assets/images/logos/png.png"/>
                                            </div>
                                            <p class="msg_owner"><a href="#" class="admin">Test</a> :</p>
                                        </div>
                                        <p class="u_data">
                                            sssssssssssss
                                        </p>
                                    </div>
                                    <div class="umsg">
                                        <div class="umsg_uname">
                                            <div class="msg_ownpic">
                                                <img class="box_mod" src="assets/images/logos/png.png"/>
                                            </div>
                                            <p class="msg_owner"><a href="#" class="banned">Test</a> :</p>
                                        </div>
                                        <p class="u_data">
                                            ssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss
                                        </p>
                                    </div>
                                    <div class="umsg">
                                        <div class="umsg_uname">
                                            <div class="msg_ownpic">
                                                <img class="box_banned" src="assets/images/logos/png.png"/>
                                            </div>
                                            <p class="msg_owner"><a href="#" >Test</a> :</p>
                                        </div>
                                        <p class="u_data">
                                            ssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss
                                        </p>
                                    </div> -->
                            </div>
                            <div id="i_data">
                                <input id="user_data" type="text">
                                <button id="data_send_button">&gt;</button>
                            </div>
                        </div>
                    </div>

                    <div id="forum_main_body">
                        <div id="f_m_left_s">
                            <div id="f_m_left_s_main">
                                <div id="lastfeedbacks">
                                    <header id="lastfeedbacks_header" class="head">
                                        <h3 id="lastfeedbacks_title" class="head_title">Last Feedbacks</h3>
                                    </header>

                                    <div id="lastfeedbacks_main">
                                         <div class="l_f_topic">
                                            <div class="topic_info">
                                                <div class="topic_t">
                                                    <div class="topic_context_icon">
                                                           <p class="context_title">C/C++</p>
                                                    </div>
                                                    <a class="topic_title" href="#">
                                                        Creation site WebEssssssssssssssssscsssmerce      
                                                    </a>
                                                </div>
                                                <div class="topic_metadata">
                                                    <p class="topic_sup_info">
                                                        Commencé Par <span class="topic_owner admin">Bounif Omar</span>
                                                        il y a 5 jours,dans <a class="forum_name" href="#">Administration</a>
                                                     </p>
                                                </div>   
                                           </div>
                                            <div class="topic_stats">
                                                <div class="response_number">
                                                    200 <i class="far fa-comment"></i>
                                                </div>
                                                <div class="view_number">
                                                    200 <i class="far fa-eye"></i>
                                                </div>
                                            </div>
                                            <div class="topic_reviver">
                                                    <div class="reviver_picture">
                                                        <img src="assets/images/logos/png.png"/>
                                                    </div>
                                                    <div class="reviver_info">
                                                        <a class="reviver_u_name mod" href="#">
                                                            Fr3eX
                                                        </a>
                                                        <p class="reviving_datetime">
                                                            il y a 6 heures
                                                        </p>
                                                    </div>
                                            </div>
                                         </div>
                                         <div class="l_f_topic">
                                            <div class="topic_info">
                                                 <div class="topic_t">
                                                    <div class="topic_context_icon">
                                                           <p class="context_title">C/C++</p>
                                                    </div>
                                                    <a class="topic_title" href="#">
                                                        Creation site WebEcommerce      
                                                    </a>
                                                 </div>
                                                <div class="topic_metadata">
                                                    <p class="topic_sup_info">
                                                        Commencé Par <span class="topic_owner admin">Bounif Omar</span>
                                                        il y a 5 jours,dans <a class="forum_name" href="#">Administration</a>
                                                     </p>
                                                </div>   
                                           </div>
                                            <div class="topic_stats">
                                                <div class="response_number">
                                                    200 <i class="far fa-comment"></i>
                                                </div>
                                                <div class="view_number">
                                                    200 <i class="far fa-eye"></i>
                                                </div>
                                            </div>
                                            <div class="topic_reviver">
                                                    <div class="reviver_picture">
                                                        <img src="assets/images/logos/png.png"/>
                                                    </div>
                                                    <div class="reviver_info">
                                                        <a class="reviver_u_name mod" href="#">
                                                            Fr3eX
                                                        </a>
                                                        <p class="reviving_datetime">
                                                            il y a 6 heures
                                                        </p>
                                                    </div>
                                            </div>
                                         </div>
                                         <div class="l_f_topic">
                                            <div class="topic_info">
                                                 <div class="topic_t">
                                                    <div class="topic_context_icon">
                                                           <p class="context_title">C/C++</p>
                                                    </div>
                                                    <a class="topic_title" href="#">
                                                        Creation site WebEcommerce      
                                                    </a>
                                                 </div>
                                                <div class="topic_metadata">
                                                    <p class="topic_sup_info">
                                                        Commencé Par <span class="topic_owner admin">Bounif Omar</span>
                                                        il y a 5 jours,dans <a class="forum_name" href="#">Administration</a>
                                                     </p>
                                                </div>   
                                           </div>
                                            <div class="topic_stats">
                                                <div class="response_number">
                                                    200 <i class="far fa-comment"></i>
                                                </div>
                                                <div class="view_number">
                                                    200 <i class="far fa-eye"></i>
                                                </div>
                                            </div>
                                            <div class="topic_reviver">
                                                    <div class="reviver_picture">
                                                        <img src="assets/images/logos/png.png"/>
                                                    </div>
                                                    <div class="reviver_info">
                                                        <a class="reviver_u_name mod" href="#">
                                                            Fr3eX
                                                        </a>
                                                        <p class="reviving_datetime">
                                                            il y a 6 heures
                                                        </p>
                                                    </div>
                                            </div>
                                         </div>
                                         <div class="l_f_topic">
                                            <div class="topic_info">
                                                 <div class="topic_t">
                                                    <div class="topic_context_icon">
                                                           <p class="context_title">Python</p>
                                                    </div>
                                                    <a class="topic_title" href="#">
                                                        Creation site WebEcommerce      
                                                    </a>
                                                 </div>
                                                <div class="topic_metadata">
                                                    <p class="topic_sup_info">
                                                        Commencé Par <span class="topic_owner admin">Bounif Omar</span>
                                                        il y a 5 jours,dans <a class="forum_name" href="#">Administration</a>
                                                     </p>
                                                </div>   
                                           </div>
                                            <div class="topic_stats">
                                                <div class="response_number">
                                                    200 <i class="far fa-comment"></i>
                                                </div>
                                                <div class="view_number">
                                                    200 <i class="far fa-eye"></i>
                                                </div>
                                            </div>
                                            <div class="topic_reviver">
                                                    <div class="reviver_picture">
                                                        <img src="assets/images/logos/png.png"/>
                                                    </div>
                                                    <div class="reviver_info">
                                                        <a class="reviver_u_name mod" href="#">
                                                            Fr3eX
                                                        </a>
                                                        <p class="reviving_datetime">
                                                            il y a 6 heures
                                                        </p>
                                                    </div>
                                            </div>
                                         </div>
                                    </div>
                                </div>


                                <div class="forum_l">
                                    <div class="forum_d">
                                        <header id="forum_d_cat_header" class="head">
                                            <h3 id="forum_d_cat_title" class="head_title">Administration</h3>
                                            <i class="fas fa-chevron-down" style="color: aliceblue;"></i>
                                        </header>

                                        <div class="forum_d_main">
                                            <div class="forum_d_item">
                                                <div class="forum_d_item_logo">
                                                    <img src="assets/images/logos/forum_logo_read.png"/>
                                                </div>
                                                <div class="forum_d_item_info">
                                                    <a href="#" class="forum_d_item_title">
                                                            News
                                                    </a>
                                                    <p class="forum_d_item_desc">
                                                        Vous trouverez sur ce forum tout ce qui a relation au nouveauté
                                                    </p>
                                                    <p class="forum_d_item_subf">
                                                        Sousforum : 
                                                        <a class="subf_link" href="#">test1</a>,
                                                        <a class="subf_link" href="#">test2</a>,
                                                        <a class="subf_link" href="#">test3</a> 
                                                    </p>
                                                </div>
                                                <div class="forum_d_item_stats">
                                                    <div class="response_number">
                                                        200 <i class="far fa-comment"></i>
                                                    </div>
                                                    <div class="view_number">
                                                        200 <i class="far fa-eye"></i>
                                                    </div>
                                                </div>
                                               
                                            </div>

                                            <div class="forum_d_item">
                                                <div class="forum_d_item_logo">
                                                    <img src="assets/images/logos/forum_logo_read.png"/>
                                                </div>
                                                <div class="forum_d_item_info">
                                                    <a href="#" class="forum_d_item_title">
                                                            News
                                                    </a>
                                                    <p class="forum_d_item_desc">
                                                        Vous trouverez sur ce forum tout ce qui a relation au nouveauté
                                                    </p>
                                                    <p class="forum_d_item_subf">
                                                        Sousforum : 
                                                        <a class="subf_link" href="#">test1</a>,
                                                        <a class="subf_link" href="#">test2</a>,
                                                        <a class="subf_link" href="#">test3</a> 
                                                    </p>
                                                </div>
                                                <div class="forum_d_item_stats">
                                                    <div class="response_number">
                                                        200 <i class="far fa-comment"></i>
                                                    </div>
                                                    <div class="view_number">
                                                        200 <i class="far fa-eye"></i>
                                                    </div>
                                                </div>
                                               
                                            </div>

                                            <div class="forum_d_item">
                                                <div class="forum_d_item_logo">
                                                    <img src="assets/images/logos/forum_logo_read.png"/>
                                                </div>
                                                <div class="forum_d_item_info">
                                                    <a href="#" class="forum_d_item_title">
                                                            News
                                                    </a>
                                                    <p class="forum_d_item_desc">
                                                        Vous trouverez sur ce forum tout ce qui a relation au nouveauté
                                                    </p>
                                                    <p class="forum_d_item_subf">
                                                        Sousforum : 
                                                        <a class="subf_link" href="#">test1</a>,
                                                        <a class="subf_link" href="#">test2</a>,
                                                        <a class="subf_link" href="#">test3</a> 
                                                    </p>
                                                </div>
                                                <div class="forum_d_item_stats">
                                                    <div class="response_number">
                                                        200 <i class="far fa-comment"></i>
                                                    </div>
                                                    <div class="view_number">
                                                        200 <i class="far fa-eye"></i>
                                                    </div>
                                                </div>
                                               
                                            </div>
                                        </div>
                                    </div>


                                

                                </div>


                                
                            </div>
                        </div>
                        <div id="forum_m_right_s">
                            <div id="forum_m_right_s_main">
                                <div id="birthday_container">
                                    <header id="birthday_container_header" class="head">
                                        <h3 id="birthday_container_title" class="head_title">Anniversaires</h3>
                                    </header>
                                    <div id="birthday_container_main">
                                        <div class="b_c_user">
                                            <a href="#"><img class="box_norm_u" src="assets/images/logos/png.png"/></a>
                                        </div>
                                        <div class="b_c_user">
                                            <a href="#"><img src="assets/images/logos/png.png"/></a>
                                        </div>
                                        <div class="b_c_user">
                                            <a href="#"><img src="assets/images/logos/png.png"/></a>
                                        </div>
                                        <div class="b_c_user">
                                            <a href="#"><img src="assets/images/logos/png.png"/></a>
                                        </div>
                                        <div class="b_c_user">
                                            <a href="#"><img src="assets/images/logos/png.png"/></a>
                                        </div>
                                        <div class="b_c_user">
                                            <a href="#"><img src="assets/images/logos/png.png"/></a>
                                        </div>
                                        <div class="b_c_user">
                                            <a href="#"><img src="assets/images/logos/png.png"/></a>
                                        </div>
                                        <div class="b_c_user">
                                            <a href="#"><img src="assets/images/logos/png.png"/></a>
                                        </div>

                                    </div>
                                </div>
                                
                                <div id="mic_statistics_container">
                                    <header id="mic_statistics_header" class="head">
                                        <h3 id="mic_statistics_title" class="head_title">Statistique</h3>
                                    </header>
                                    
                                    <div id="mic_statistics_main">
                                        <ul id="last_registred_username">
                                            <li>Dernier membre :</li>
                                            <li id="l_r_username"><a href="#" class="admin">test</a></li>
                                        </ul>
                                        <ul id="number_of_members">
                                            <li>Nombre des membres :</li>
                                            <li id="n_o_m">2000</li>
                                        </ul>
                                        <ul id="number_of_topics">
                                            <li>Threads :</li>
                                            <li id="n_o_t">120</li>
                                        </ul>
                                        <ul id="number_of_forums">
                                            <li>Nombre de forum :</li>
                                            <li id="n_o_f">15</li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </div>            
                    </div>
                </div>
        </div>

        <div id="forum_footer_container">
            <div id="f_f_c_uS">
                <nav id="Theme_Lang">
                    <ul>
                        <li>
                            Thème
                        </li>
                        <li>Langues</li>
                    </ul>
                </nav>
    
                <nav id="footer_nav">
                    <ul>
                        <li><a href="#"><i class="fas fa-home" style="margin-right: 5px;"></i>Acceuil</a></li>
                        <li id="separator" style=" clear:both;border-right: 2px solid rgba(247,247,247,.7);"></li>
                        <li><a href="#">Nous Contacter</a></li>
                        <li><a href="#">Condition et règles</a></li>
                        <li><a href="#">Aide</a></li>
                    </ul>
                </nav>
            </div>
            <div id="f_f_c_lS">
                <p id="opensource">
                    Open source forum project you will find the source code here <a href="">Github</a>	
                </p>
            </div>
        </div>

        <script src="assets/js/home/generic.js"></script>
    </body>
</html>