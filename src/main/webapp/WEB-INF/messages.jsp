<!DOCTYPE html>

<html> 
<head>
    
        <title>FORUM | Administration</title>
        <meta charset="UTF-8"/>
        <link rel="stylesheet" href="assets/css/messages.css"/>
		<c:if test = "${!empty sessionScope.USER_SESS }">
            <link rel="stylesheet" href="<c:url value="/assets/css/stylelog.css"/>" />
        </c:if>
        
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.12.1/css/all.css" crossorigin="anonymous">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body> 
        <header id="forum_header_container">
                <div id="forum_header_container_main">              
                    <div id="f_h_c_leftSide">
                        <div id="f_h_c_leftSide_main">
                            <div id="log_reg_container">
                                <button id="log_butt">
                                    S'inscrire
                                </button>
                                <button id="reg_butt">
                                    Se connecter
                                </button>
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
                        <li><a href="#"><i class="fas fa-align-justify" style="margin-right: 5px;"></i>FORUM</a></li>
                        <li><a href="#"><i class="fab fa-discord" style="margin-right: 5px;"></i>DISCORD</a></li>
                    </ul>
               </div>
               <div id="nav_search">
                
               </div>
            </div>
        </nav>
        
        <div id="mic_body_container">
                <div id="mic_body_container_main">
                    <div id="messages_body_container">
                        <div id="m_l_s">
                            <header id="m_l_s_header">
                                <h3 id="m_l_s_header_title">Messages</h3>
                                <input id="m_l_s_header_searchinpute" type="text" placeholder="Recherche ..."/>
                            </header>
                            <div id="m_l_s_list">
                                <div class="m_l_s_users">
                                    <div class="user_pic">
                                        <a href="#"><img src="assets/images/logos/png.png"/></a>
                                    </div>
                                    <div class="user_info">
                                        <p class="_username">Fr3eX</p>
                                        <p class="_lastmessage">testeblalalalallallala ...</p>
                                    </div>
                                </div>
                                <div class="m_l_s_users">
                                    <div class="user_pic">
                                        <a href="#"><img src="assets/images/logos/png.png"/></a>
                                    </div>
                                    <div class="user_info">
                                        <p class="_username">Fr3eX</p>
                                        <p class="_lastmessage">testeblalalalallallala ...</p>
                                    </div>
                                </div>
                                <div class="m_l_s_users">
                                    <div class="user_pic">
                                        <a href="#"><img src="assets/images/logos/png.png"/></a>
                                    </div>
                                    <div class="user_info">
                                        <p class="_username">Fr3eX</p>
                                        <p class="_lastmessage">testeblalalalallallala ...</p>
                                    </div>
                                </div>
                                <div class="m_l_s_users">
                                    <div class="user_pic">
                                        <a href="#"><img src="assets/images/logos/png.png"/></a>
                                    </div>
                                    <div class="user_info">
                                        <p class="_username">Fr3eX</p>
                                        <p class="_lastmessage">testeblalalalallallala ...</p>
                                    </div>
                                </div>
                                <div class="m_l_s_users">
                                    <div class="user_pic">
                                        <a href="#"><img src="assets/images/logos/png.png"/></a>
                                    </div>
                                    <div class="user_info">
                                        <p class="_username">Fr3eX</p>
                                        <p class="_lastmessage">testeblalalalallallala ...</p>
                                    </div>
                                </div>
                                <div class="m_l_s_users">
                                    <div class="user_pic">
                                        <a href="#"><img src="assets/images/logos/png.png"/></a>
                                    </div>
                                    <div class="user_info">
                                        <p class="_username">Fr3eX</p>
                                        <p class="_lastmessage">testeblalalalallallala ...</p>
                                    </div>
                                </div>
                                <div class="m_l_s_users">
                                    <div class="user_pic">
                                        <a href="#"><img src="assets/images/logos/png.png"/></a>
                                    </div>
                                    <div class="user_info">
                                        <p class="_username">Fr3eX</p>
                                        <p class="_lastmessage">testeblalalalallallala ...</p>
                                    </div>
                                </div>
                                <div class="m_l_s_users">
                                    <div class="user_pic">
                                        <a href="#"><img src="assets/images/logos/png.png"/></a>
                                    </div>
                                    <div class="user_info">
                                        <p class="_username">Fr3eX</p>
                                        <p class="_lastmessage">testeblalalalallallala ...</p>
                                    </div>
                                </div>
                                <div class="m_l_s_users">
                                    <div class="user_pic">
                                        <a href="#"><img src="assets/images/logos/png.png"/></a>
                                    </div>
                                    <div class="user_info">
                                        <p class="_username">Fr3eX</p>
                                        <p class="_lastmessage">testeblalalalallallala ...</p>
                                    </div>
                                </div>
                                <div class="m_l_s_users">
                                    <div class="user_pic">
                                        <a href="#"><img src="assets/images/logos/png.png"/></a>
                                    </div>
                                    <div class="user_info">
                                        <p class="_username">Fr3eX</p>
                                        <p class="_lastmessage">testeblalalalallallala ...</p>
                                    </div>
                                </div>
                                <div class="m_l_s_users">
                                    <div class="user_pic">
                                        <a href="#"><img src="assets/images/logos/png.png"/></a>
                                    </div>
                                    <div class="user_info">
                                        <p class="_username">Fr3eX</p>
                                        <p class="_lastmessage">testeblalalalallallala ...</p>
                                    </div>
                                </div>
                                <div class="m_l_s_users">
                                    <div class="user_pic">
                                        <a href="#"><img src="assets/images/logos/png.png"/></a>
                                    </div>
                                    <div class="user_info">
                                        <p class="_username">Fr3eX</p>
                                        <p class="_lastmessage">testeblalalalallallala ...</p>
                                    </div>
                                </div>
                                <div class="m_l_s_users">
                                    <div class="user_pic">
                                        <a href="#"><img src="assets/images/logos/png.png"/></a>
                                    </div>
                                    <div class="user_info">
                                        <p class="_username">Fr3eX</p>
                                        <p class="_lastmessage">testeblalalalallallala ...</p>
                                    </div>
                                </div>
                                <div class="m_l_s_users">
                                    <div class="user_pic">
                                        <a href="#"><img src="assets/images/logos/png.png"/></a>
                                    </div>
                                    <div class="user_info">
                                        <p class="_username">Fr3eX</p>
                                        <p class="_lastmessage">testeblalalalallallala ...</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div id="m_m_s">
                            <div id="__messages">
                                <div class="bloc_ms">
                                    <p class="for_ms">dazdazdazdddddddddddddddddddddddddddddddddddddddadadazdazdazdazdddddddddddddddddddddddddddddddddddddddadadazdazdazdazdddddddddddddddddddddddddddddddddddddddadadazdazdazdazdddddddddddddddddddddddddddddddddddddddadadaz</p>
                                    <p class="message_date">12/15/2020 15:00:00</p>
                                </div>
                                <div class="bloc_ms">
                                    <p class="for_ms">dazdazdazdddddddddddddddddddddddddddddddddddddddadadazdazdazdazdddddddddddddddddddddddddddddddddddddddadadazdazdazdazdddddddddddddddddddddddddddddddddddddddadadazdazdazdazdddddddddddddddddddddddddddddddddddddddadadaz</p>
                                    <p class="message_date">12/15/2020 15:00:00</p>
                                </div>
                                <div class="bloc_ms">
                                    <p class="for_ms">dazdazdazdddddddddddddddddddddddddddddddddddddddadadazdazdazdazdddddddddddddddddddddddddddddddddddddddadadazdazdazdazdddddddddddddddddddddddddddddddddddddddadadazdazdazdazdddddddddddddddddddddddddddddddddddddddadadaz</p>
                                    <p class="message_date">12/15/2020 15:00:00</p>
                                </div>
                                <div class="bloc_ms">
                                    <p class="for_ms">dazdazdazdddddddddddddddddddddddddddddddddddddddadadazdazdazdazdddddddddddddddddddddddddddddddddddddddadadazdazdazdazdddddddddddddddddddddddddddddddddddddddadadazdazdazdazdddddddddddddddddddddddddddddddddddddddadadaz</p>
                                    <p class="message_date">12/15/2020 15:00:00</p>
                                </div>
                                <div class="bloc_ms">
                                 <p class="own_ms">dazdazdazdddddddddddddddddddddddddddddddddddddddadadazdazdazdazdddddddddddddddddddddddddddddddddddddddadadazdazdazdazdddddddddddddddddddddddddddddddddddddddadadazdazdazdazdddddddddddddddddddddddddddddddddddddddadadaz</p>
                                 <p class="message_date">12/15/2020 15:00:00</p>
                                </div>
                                <div class="bloc_ms">
                                 <p class="for_ms">dazdazdazdadadaz</p>
                                 <p class="message_date">12/15/2020 15:00:00</p>
                                </div>
                                <div class="bloc_ms">
                                    <p class="own_ms">dazdazdazdadadaz</p>
                                    <p class="message_date">12/15/2020 15:00:00</p>
                                </div>
                            </div>
                            <div id="u_input">
                                <input id="text_user_input" type="text" placeholder="Entrer votre message"/>
                                <div id="send_div">&gt;</div>
                            </div>
                        </div>
                        <div id="m_r_s">
                               <div class="m_r_s_main">
                                    <div class="user_pic_rc">
                                        <a href="#"><img src="assets/images/logos/png.png"/></a>
                                    </div >
                                    <div class="user_name">
                                        Fr3eX
                                    </div>
                                    <div class="user_o_data">
                                        <ul id="user_messages_container">
                                            <li>Messages :</li>
                                            <li>200</li>
                                        </ul>
                                        <ul id="user_reg_date">
                                            <li>Inscrit : </li>
                                            <li>17/02/2020</li>
                                        </ul>
                                        <ul class="user_subscribers_container">
                                            <li>Abonnés :</li>
                                            <li>+99</li>
                                        </ul>
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
    </body>
</html>