<!DOCTYPE html>
<html> 
<head>
    
        <title>FORUM | Administration</title>
        <meta charset="UTF-8"/>
        <link rel="stylesheet" href="assets/css/profile.css"/>
		<c:if test = "${!empty sessionScope.USER_SESS }">
              <link rel="stylesheet" href="<c:url value="/assets/css/stylelog.css"/>" />
        </c:if>
        
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.12.1/css/all.css" crossorigin="anonymous">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
        <div id="mic_body_container">
            <div id="mic_body_container_main">
                <header id="profile_header">
                    <div id="profile_h_main">
                        
                        <div id="profile_m3">
                            <div id="user_cover_pic">
                                <a href="#"><img  src="assets/images/banners/micLeet.png"/></a>
                            </div>
                            <div id="test_container">
                                <div id="user_pic_n">
                                    <div id="profile_pic">
                                    <a href="#"><img src="assets/images/logos/png.png"/></a>
                                    </div>
                                    <div id="profile_uname_mname">
                                        <div id="user_log_status" title="Online"></div>
                                        
                                        <p id="username">Fr3eX</p>
                                        <p id="user_group_memeber">&lt;&lt;Membre de l'equipe&gt;&gt;</p>
                                    </div>
                                </div>
                                <div id="profile_s_a_f">
                                    <div id="send_message_container">
                                        <button id="u_s_m">
                                            <i class="fas fa-comment"></i>
                                            Envoyer message
                                        </button>
                                    </div>
                                    <div id="user_add_friend">
                                        <button id="u_a_f">
                                            <i class="fas fa-user-plus"></i>
                                            Ajouter en amis
                                        </button>
                                    </div>
                                    <div id="user_follow">
                                        <button id="u_f">
                                            <i class="fas fa-heart"></i>
                                            Suivre
                                        </button>
                                    </div>
                                </div>
                            </div>
                        </div>
                       
                        <div id="profile_f">    
                            <div id="profile_f_main">
                               
                                    <ul id="user_message_number">
                                        <li class="text">Nombre de messages</li>
                                        <li id="message_number">300</li>
                                    </ul>
                                    <ul id="user_reg_date">
                                        <li class="text">Nombre de messages</li>
                                        <li id="u_r_date">300</li>
                                    </ul>
                                    <ul id="user_reg_date">
                                        <li class="text">Nombre de messages</li>
                                        <li id="u_r_date">300</li>
                                    </ul>
                               
                            </div>
                        </div>
                    </div>
                </header>
                <div id="profile_body">
                    <div id="profile_l_s">
                        <div id="profile_l_s_main">
                            <div id="user_friend_list_container">
                                <header id="user_friend_list_header">
                                    <h3 id="f_l_title">Amis</h3>
                                </header>
                                <div id="user_friend_list_body">
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
                                    <div class="b_c_user">
                                        <a href="#"><img src="assets/images/logos/png.png"/></a>
                                    </div>
                                </div>
                                
                            </div>

                            <div id="user_info">
                                <header id="user_info_header">
                                    <h3 id="u_i_title">Information</h3>
                                </header>
                                <div id="user_info_body">
                                    <ul id="user_city">
                                        <li class="utext">
                                            Ville :
                                        </li>
                                        <li id="city">
                                            Casablanca
                                        </li>
                                    </ul>
                                    <ul class="user_country">
                                        <li class="utext">
                                            Pays :
                                        </li>
                                        <li id="country">
                                            Maroc
                                        </li>
                                    </ul>
                                    <ul user_age>
                                        <li class="utext">
                                            Age :
                                        </li>
                                        <li id="age">
                                            18
                                        </li>
                                    </ul>
                                    <ul user="user_gender">
                                        <li class="utext">
                                            Genre :
                                        </li>
                                        <li id="gender">
                                            masculin
                                        </li>
                                    </ul>
                                </div>  
                            </div>

                            <div id="user_rank">
                                <header id="user_rank_header">
                                    <h3 id="u_r_title">Rang</h3>
                                </header>
                                <div id="user_rank_body">
                                    <div class="rank administrator">
                                        <p class="rank_def">
                                            Administrateur
                                        </p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div id="profile_r_s">
                        <div id="profile_r_s_main">
                            <header id="profile_r_s_header">
                            
                                <nav id="profile_r_s_nav">
                                    <ul id="profile_r_s_n_list">
                                        <li class="text" id="last_messages">Dernier Messages</li>
                                        <li class="text" id="last_activities">Derniere Activité</li>
                                    
                                    </ul>
                                </nav>
                            
                            </header>

                            <div id="profile_r_s_body">
                                <div id="last_messages_container" >
                                    <div class="r_s_topic">
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
                                                    Commencé Par <span class="topic_owner">Bounif Omar</span>
                                                    il y a 5 jours
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
                                                    <a class="reviver_u_name" href="#">
                                                        Fr3eX
                                                    </a>
                                                    <p class="reviving_datetime">
                                                        il y a 6 heures
                                                    </p>
                                                </div>
                                        </div>
                                     </div>
                                     <div class="r_s_topic">
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
                                                    Commencé Par <span class="topic_owner">Bounif Omar</span>
                                                    il y a 5 jours
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
                                                    <a class="reviver_u_name" href="#">
                                                        Fr3eX
                                                    </a>
                                                    <p class="reviving_datetime">
                                                        il y a 6 heures
                                                    </p>
                                                </div>
                                        </div>
                                     </div>
                                     <div class="r_s_topic">
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
                                                    Commencé Par <span class="topic_owner">Bounif Omar</span>
                                                    il y a 5 jours
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
                                                    <a class="reviver_u_name" href="#">
                                                        Fr3eX
                                                    </a>
                                                    <p class="reviving_datetime">
                                                        il y a 6 heures
                                                    </p>
                                                </div>
                                        </div>
                                     </div>
                                     <div class="r_s_topic">
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
                                                    Commencé Par <span class="topic_owner">Bounif Omar</span>
                                                    il y a 5 jours
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
                                                    <a class="reviver_u_name" href="#">
                                                        Fr3eX
                                                    </a>
                                                    <p class="reviving_datetime">
                                                        il y a 6 heures
                                                    </p>
                                                </div>
                                        </div>
                                     </div>
                                </div>
                                <div id="last_activities_container" style="display: none;">

                                </div>
                                
                            
                            </div>
                        </div>
                    </div>
                </div>
            </div> 
        </div>
</body>
</html>