<!DOCTYPE html>
<html> 
<head>
    
        <title>FORUM | Administration</title>
        <meta charset="UTF-8"/>
        <link rel="stylesheet" href="<c:url value="/assets/css/forum.css"/>"/>
        <c:if test = "${!empty sessionScope.USER_SESS }">
              <link rel="stylesheet" href="<c:url value="/assets/css/stylelog.css"/>" />
        </c:if>
	
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.12.1/css/all.css" crossorigin="anonymous">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
        <c:import url="header.jsp"/>
        
        <div id="mic_body_container">
                <div id="mic_body_container_main">
                    <header id="mic_main_header">
                        <p id="current_location">
                            <i class="fas fa-home" style="font-size: 15px;color: rgba(0,0,0,.7);"></i> 
                           /<a href="#">home</a>/<a href="#">  <c:out value="${FORUM_ATTR.forum_title}"/>  </a>
                        </p>
                    </header>

                    <div id="mic_main_body">
                        <div id="forum_info">
                            <header id="forum_info_header" class="head">
                                <h3 id="forum_title" class="head_title">Description</h3>
                            </header>

                            <div id="forum_info_main">
                                <p id="forum_desc">
                                    <c:out value="${FORUM_ATTR.forum_description}"/>
                                </p>
                                <div id="forum_options">
                                    <div id="forum_subscribe">
                                       <button> S'abonner <i class="fas fa-play" style="font-size: 12px;"></i></button>
                                    </div>
                                    <div id="forum_share">
                                        <button>Partager <i class="fas fa-share-alt" style="font-size: 12px;"></i></button>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div id="subforum">
                            <header id="subforum_header" class="head">
                                <h3 id="subforum_title" class="head_title">Sous Forums</h3>
                            </header>

                            <div id="subforum_main">
                            	<c:forEach items="${FORUM_ATTR.forum_subforums}" var="forum">
                              	  <div class="forum_d_item">
                                    <div class="forum_d_item_logo">
                                        <img src="assets/images/logos/forum_logo_read.png"/>
                                    </div>
                                    <div class="forum_d_item_info">
                                        <a href="#" class="forum_d_item_title">
                                                <c:out value="${forum.forum_title}"/>
                                        </a>
                                        <p class="forum_d_item_desc">
                                            	<c:out value="${forum.forum_description}"/>
                                        </p>
                                        <p class="forum_d_item_subf">
                                            Sousforum : 
                                            <c:forEach items="${forum.forum_subforums}" var="forum_s">
                                            <a class="subf_link" href="#"><c:out value="${forum_s.forum_title}"/></a>,
                                            </c:forEach>
                                        </p>
                                    </div>
                                    <div class="forum_d_item_stats">
                                        <div class="response_number">
                                            <c:out value="${forum.forum_comments_number}"/> <i class="far fa-comment"></i>
                                        </div>
                                        <div class="view_number">
                                            <c:out value="${forum.forum_view_number}"/> <i class="far fa-eye"></i>
                                        </div>
                                    </div>

                                </div>
                            	</c:forEach>
                            </div>
                        </div>

                      
                        <div id="forum_topics_container">
                            <header id="forum_topic_header" class="head">
                                <h3 id="forum_topics_title" class="head_title">Topics</h3>
                            </header>

                            <div id="forum_topics_main">
                            	<jsp:useBean id="dateNow" class="java.util.Date"/>
                            	<c:forEach items="${FORUM_ATTR.forum_topics}" var="topic">
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
		                                                Commencé Par <span class="topic_owner admin"><c:out value="${topic.topic_owner.user_name}"/>  </span>
		                                                il y a  <fmt:parseNumber
																    value="${(now.time - topic_dateOfreviv.time) / (1000*60*60*24) }"
																    integerOnly="true" /> jours
		                                             </p>
		                                        </div>   
		                                   </div>
		                                    <div class="topic_stats">
		                                        <div class="response_number">
		                                            <c:out value="${topic.topic_comments_number}"/> <i class="far fa-comment"></i>
		                                        </div>
		                                        <div class="view_number">
		                                             <c:out value="${topic.topic_view_number}"/> <i class="far fa-eye"></i>
		                                        </div>
		                                    </div>
		                                    <div class="topic_reviver">
		                                            <div class="reviver_picture">
		                                                <img src="<c:url value="assets/images/logos/" />"/>
		                                            </div>
		                                            <div class="reviver_info">
		                                                <a class="reviver_u_name" href="#">
		                                                    <c:out value="${topic.topic_owner.user_name}"/>
		                                                </a>
		                                                <p class="reviving_datetime">
		                                                   il y a  <fmt:parseNumber
																    value="${(now.time - topic_dateOfreviv.time) / (1000*60*60*24) }"
																    integerOnly="true" /> jours
		                                                </p>
		                                            </div>
		                                    </div>
		                                 </div>
								</c:forEach>
                        
                            </div>  
                        
                        	<div id="forum_topics_pages">
                                <c:forEach begin="1" end="${(PAGE_COUNT + 15 -1 ) / 15}" var="count">
	                                <div class="page">
	                                    <a class="page_link" href="<c:url value="/forums/${FORUM_ATTR.forum_title}/page-${count-1}"/>">${count}</a>	
	                                </div>
                                </c:forEach>
                            </div>
                        </div>
                    </div>
                </div> 
        </div>
        
        <c:import url="footer.jsp"/>
        
    </body>
</html>