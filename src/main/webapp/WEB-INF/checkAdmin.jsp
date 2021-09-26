<c:if test="${!empty requestScope.ERRORS}" var="error"/>

<!DOCTYPE html>
<html> 
<head>
    
        <title>MIC FORUM</title>
        <meta charset="UTF-8"/>
        <link rel="stylesheet" href="<c:url value="/assets/css/checkAdmin.css"/>"/>
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
                            /<a href="<c:url value="/home"/>">home</a>/<a href="<c:url value="/users/${USER_SESS.user_name}"/>"><c:out value="${USER_SESS.user_name}"/></a>/<a href="#form_passw_check">checkAdmin</a>
                            </p>
                            <h1 id="forum_page_title">Security Check</h1>
                           
                        </header>
                        <form id="form_passw_check" action="<c:url value="/checkAdmin"/>" method="post">
                            <label for="password_conf">Confirmer votre mot de passe :</label>
                            <input id="pass_input" type="password" id="password_conf" placeholder="Confirmer votre mot de passe" name="password_conf" class="genera_style_inp"/>
                            <input id="send_butt" type="submit" value="Valider" class="sub_butt">
                        </form>
                        	
                        	<c:choose>
		                        <c:when test ="${error == \"true\"}">
		                       	 
		                       		 <div id="block_status" class="error" style="display:block">
										    <c:if test="${!empty ERRORS.password_conf}">
										    	<p id="x1" >
										    		<i class="fas fa-exclamation-circle"></i> <c:out value="${ERRORS.password_conf}"/>
										    	</p>
										    </c:if>
									 </div>
										
			                      </c:when>	
			                      <c:otherwise>
			                     	 <div id="block_status">
			                     	 </div>
								  </c:otherwise>
			                      
		                      </c:choose>
                </div>
        </div>
        
        <c:import url="footer.jsp"/>
        
        
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
        <script src="<c:url value="/assets/js/home/checkAdmin.js"/>"></script>
        <script src="<c:url value="/assets/js/home/generic.js"/>"></script>
    </body>
</html>