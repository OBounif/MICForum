 <header id="forum_header_container">
                <div id="forum_header_container_main">              
                    <div id="f_h_c_leftSide">
                        <div id="f_h_c_leftSide_main">
                           
                           <c:choose>
	                           <c:when test="${empty sessionScope.USER_SESS}"> 
		                            <div id="log_reg_container">
		                                <button id="log_butt">
		                                    S'inscrire
		                                </button>
		                                <button id="reg_butt">
		                                    Se connecter
		                                </button>
		                            </div>
	                            </c:when>
	                            
	                            <c:otherwise>
		                               <div id="prof_upper_side">
				                                <div id="prof_image">
				                                    <img src="<c:url value="/static/p_i/${sessionScope.USER_SESS.user_pic_path}"/>"/>
				                                    <div id="prof_list" >
				                                        <ul>
				                                            <li><a href="#">Profile </a></li>
				                                            <li><a href="<c:url value="/user/userSetting" />">Paramètre</a></li>
				                                            <li><a href="<c:url value="/logout" />">Déconnexion </a></li>
				                                        </ul>
				                                    </div>
				                                </div>
				                                <div id="prof_text">
				                                    <h3 id="prof_uname"><c:out value="${sessionScope.USER_SESS.user_name}"/></h3>
				                                    <h4 id="prof_group_name">&lt;&lt;<c:out value="${sessionScope.USER_SESS.user_currRank.rank_text}"/> &gt;&gt;</h4>
				                                    <p id="prof_last_log">Last Login : <c:out value="${sessionScope.USER_SESS.user_currRank.lastlogon}"/> </p>
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
			                                    <a href="<c:url value="/logout"/>">
			                                    	<i class="fas fa-sign-out-alt"></i>
			                                    </a>
			                                </div>
			                           </div>
			                           
	                            </c:otherwise>
           
                            </c:choose>
                            
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
                    	
                        <li><a href="<c:url value="/home" />"><i class="fas fa-home" style="margin-right: 5px;"></i>HOME</a></li>
                        <li id="forum_l"><a href="#"><i class="fas fa-align-justify" style="margin-right: 5px;"></i>FORUM</a>
                            <div id="nav_list_main" >
                                <ul>
                                    <li><a href="<c:url value="/home"/>"> <i class="fas fa-comments"></i>Forums </a></li>
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