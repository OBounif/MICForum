<!DOCTYPE html>
<html> 
<head>
    
        <title>MIC FORUM</title>
        <meta charset="UTF-8"/>
        <link rel="stylesheet" href="<c:url value="/assets/css/style.css"/>" />
        <c:if test = "${!empty sessionScope.USER_SESS }">
                <link rel="stylesheet" href="<c:url value="/assets/css/stylelog.css"/>" />
        </c:if>
        
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.12.1/css/all.css" crossorigin="anonymous">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body> 
       	
       	<c:import url="header.jsp"/>
        
        <div id="forum_body_container">
                <div id="forum_body_container_main">
                    <header id="forum_main_header">
                        <p id="current_location">
                            <i class="fas fa-home" style="font-size: 15px;color: rgba(0,0,0,.7);"></i> 
                           /<a href="<c:url value="/#"/>">home</a>/
                        </p>
                        <h1 id="forum_main_title">Morrocan's It Community</h1>
                    </header>
                    <div id="user_options">
                        <button id="topic_creat_butt" class="creat_butt">Nouveau message</button>
                        <button id="poll_creat_butt" class="creat_butt">Nouveau sondage</button>
                    </div>
                    <div id="shoutbox" style="display : none">
                        <header id="shoutbox_header" class="head">
                            <h3 id="shoutbox_title" class="head_title">ShoutBox</h3>
                        </header>
                        <div id="shoutbox_body">
                            <div id="shoutbox_background_cover">
                                <img src="<c:url value="assets/images/banners/micLeet.png"/>"/>
                            </div>
                            <div id="user_messages">
                               
                                  <div class="umsg">
                                        <div class="umsg_uname">
                                            <div class="msg_ownpic">
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
                                    </div>
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
                                        <jsp:useBean id="dateNow" class="java.util.Date"/>
                                       	<c:forEach items="${TOPIC_ATTR}" var="topic">
	                                         <div class="l_f_topic">
	                                            <div class="topic_info">
	                                                <div class="topic_t">
	                                                    <div class="topic_context_icon">
	                                                           <p class="context_title"><c:out value="${topic.topic_logodec}"/></p>
	                                                    </div>
	                                                    <a class="topic_title" href="#">
	                                                        <c:out value="${topic.topic_title}"/>      
	                                                    </a>
	                                                </div>
	                                                <div class="topic_metadata">
	                                                    <p class="topic_sup_info">
	                                                        Commencé Par <span class="topic_owner admin"> <c:out value="${topic.topic_owner.user_name}"/></span>
	                                                        il y a 5 jours,dans <a class="forum_name" href="#"><c:out value="${topic.topic_forum.forum_title}"/></a>
	                                                     </p>
	                                                </div>   
	                                           </div>
	                                            <div class="topic_stats">
	                                                <div class="response_number">
	                                                    <c:out value="${topic.topic_comments_number}"/> <i class="far fa-comment"></i>
	                                                </div>
	                                                <div class="view_number">
	                                                    <c:out value="${topic.topic_view_number}"/> <i alt="view" class="far fa-eye"></i>
	                                                </div>
	                                            </div>
	                                            <div class="topic_reviver">
	                                                    <div class="reviver_picture">
	                                                        <img src="<c:url value ="/static/p_i/${topic.topic_reviver.user_pic_path}"/>" />
	                                                    </div>
	                                                    <div class="reviver_info">
	                                                        <a class="reviver_u_name mod" href="#">
	                                                            <c:out value="${topic.topic_reviver.user_name}"/>
	                                                        </a>
	                                                        <p class="reviving_datetime">
	                                                            il y a <fmt:parseNumber
																    value="${(now.time - topic.topic_dateOfreviv.time) / (1000*60*60*24) }"
																    integerOnly="true" /> heures
	                                                        </p>
	                                                    </div>
	                                            </div>
	                                         </div>
                                        </c:forEach>
                                    </div>
                                </div>


                                <div class="forum_l">
                                
                                <c:forEach items="${FORUM_ATTR}" var="cat">
                                
                                    <div class="forum_d">
                                        <header id="forum_d_cat_header" class="head">
                                            <h3 id="forum_d_cat_title" class="head_title">
                                            	   <c:out value="${cat.forum_title}"/>	
                                            </h3>
                                            <i class="fas fa-chevron-down" style="color: aliceblue;"></i>
                                        </header>

                                        <div class="forum_d_main">
                                           	<c:forEach items="${cat.forum_childrens}" var="forum">
                                        
                                            <div class="forum_d_item">
                                                <div class="forum_d_item_logo">
                                                    <img src="<c:url value="/assets/images/logos/forum_logo_read.png"/>"/>
                                                </div>
                                                <div class="forum_d_item_info">
                                                    <a href="#" class="forum_d_item_title">
                                                           <c:out value="${forum.forum_title}"/>
                                                    </a>
                                                    <p class="forum_d_item_desc">
                                                           <c:out value="${forum.forum_description}"/>
                                                    </p>
                                                    <p class="forum_d_item_subf">
                                                        <c:forEach items="${forum.forum_childrens}" var="forum_sub" varStatus="vs">
	                                                        Sousforum : 
	                                                        <a class="subf_link" href="#">  
	                                                             <c:out value="${forum.forum_title}"/>
	                                                        </a>
	                                                       	 <c:if test="${! vs.last}">
	                                                       	 	,
	                                                       	 </c:if>
	                                                    </c:forEach>
                                                    </p>
                                                </div>
                                                <div class="forum_d_item_stats">
                                                    <div class="response_number">
                                                        <c:out value="${forum.forum_comments_number}"/>
                                                        <i class="far fa-comment"></i>
                                                    </div>
                                                    <div class="view_number">
                                                        <c:out value="${forum.forum_view_number}"/> 
                                                        <i class="far fa-eye"></i>
                                                    </div>
                                                </div>
                                               
                                            </div>
                                       
                                       		</c:forEach>
                                        </div>
                                    </div>

								</c:forEach>
                                

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

		<c:import url="footer.jsp"/>

        <script src="assets/js/home/generic.js"></script>
    </body>
</html>