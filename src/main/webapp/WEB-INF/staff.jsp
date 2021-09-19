<!DOCTYPE html>

<html> 
<head>
    
        <title>MIC FORUM</title>
        <meta charset="UTF-8"/>
        <link rel="stylesheet" href="assets/css/staff.css"/>
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
                    <header id="mic_main_header">
                        <p id="current_location">
                            <i class="fas fa-home" style="font-size: 15px;color: rgba(0,0,0,.7);"></i> 
                           /<a href="#">home</a>/<a href="#">staff</a>
                        </p>
                    </header>
                    
                    <div class="staff">
                        <header class="staff_header">
                            <h3 class="staff_title">Administrateurs</h3>
                        </header>

                        <div class="staff_main">
                            <div class="staff_user">
                                <a href="#"><img src="assets/images/logos/png.png"/></a>
                            </div>
                            <div class="staff_user">
                                <a href="#"><img src="assets/images/logos/png.png"/></a>
                            </div>
                            <div class="staff_user">
                                <a href="#"><img src="assets/images/logos/png.png"/></a>
                            </div>
                            <div class="staff_user">
                                <a href="#"><img src="assets/images/logos/png.png"/></a>
                            </div>

                        </div>
                  
                    </div>

                    <div class="staff">
                        <header class="staff_header">
                            <h3 class="staff_title">Moderateurs</h3>
                        </header>

                        <div class="staff_main">
                            <div class="staff_user">
                                <a href="#"><img src="assets/images/logos/png.png"/></a>
                            </div>
                            <div class="staff_user">
                                <a href="#"><img src="assets/images/logos/png.png"/></a>
                            </div>
                            <div class="staff_user">
                                <a href="#"><img src="assets/images/logos/png.png"/></a>
                            </div>
                            <div class="staff_user">
                                <a href="#"><img src="assets/images/logos/png.png"/></a>
                            </div>
                            
                        </div>
                  
                    </div>
                    
                    <div class="staff">
                        <header class="staff_header">
                            <h3 class="staff_title">Testeurs</h3>
                        </header>

                        <div class="staff_main">
                            <div class="staff_user">
                                <a href="#"><img src="assets/images/logos/png.png"/></a>
                            </div>
                            <div class="staff_user">
                                <a href="#"><img src="assets/images/logos/png.png"/></a>
                            </div>
                            <div class="staff_user">
                                <a href="#"><img src="assets/images/logos/png.png"/></a>
                            </div>
                            <div class="staff_user">
                                <a href="#"><img src="assets/images/logos/png.png"/></a>
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