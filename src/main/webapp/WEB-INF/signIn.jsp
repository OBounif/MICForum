<!DOCTYPE html>
<html> 
<head>
    
        <title>MIC FORUM</title>
        <meta charset="UTF-8"/>
        <link rel="stylesheet" href="assets/css/signIn.css"/>

        
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
        
        <div id="mic_body_container">
                <div id="mic_body_container_main">
                    <header>
                        <p id="current_location">
                            <i class="fas fa-home" style="font-size: 15px;color: rgba(0,0,0,.7);"></i> 
                        /<a href="#">home</a>/<a href="#">SignIn</a>
                        </p>
                    </header>
                    <div id="mic_main_body">
                        <div id="signin_h">
                            <h2>Se Connecter</h2>
                            <h3>Vous n'avez pas de compte ? <a href="#">S'inscrire</a></h2>
                        </div>
                        <div id="sign_in_status" >
                        </div>
                        <div id="signin_b">
                            <form id="signin_f" action="" method="">
                                <p id="username">
                                    Username :<span style="color:rgba(255,0,0,.8);">*</span>
                                </p>
                                <input type="text" name="username"/>
                               

                                <p id="password">
                                    Mot de passes : <span style="color:rgba(255,0,0,.8);">*</span>
                                </p>
                                <input type="password" name="password"/>


                              <div id="checkbox_cont">
                                
                              
                                <p id="remember_me">
                                    <input type="checkbox" value="false"> Se souvenir de moi
                                </p>
                              </div>
                              
                              <input id="submit_butt" type="submit" value="S'inscrire"/>
                  
                            </form>
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


        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
        <script src="assets/js/home/signIn.js"></script>
        <script src="assets/js/home/generic.js"></script>
    </body>
</html>