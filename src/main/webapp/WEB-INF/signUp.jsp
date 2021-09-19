<c:if test="${!empty requestScope.ERRORS}" var="error"/>

<!DOCTYPE html>
<html> 
<head>
    
        <title>MIC FORUM</title>
        <meta charset="UTF-8"/>
        <link rel="stylesheet" href="assets/css/signUp.css"/>
        
	    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.12.1/css/all.css" crossorigin="anonymous">
	    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
        <c:import url="header.jsp"/>
        <div id="mic_body_container">
                <div id="mic_body_container_main">
                    <header>
                        <p id="current_location">
                            <i class="fas fa-home" style="font-size: 15px;color: rgba(0,0,0,.7);"></i> 
                        /<a href="<c:url value="/home"/>">home</a>/<a href="<c:url value="/#"/>">S'inscrire</a>
                        </p>
                    </header>
                    <div id="mic_main_body">
                        <div id="signup_h">
                            <h2>S'inscrire</h2>
                            <h3>Utilisateur existant ? <a href="#">Se connecter</a></h3>
                        </div>
                        
	                   <c:choose>
		                        <c:when test ="${error == \"true\"}">
		                       	 
		                       		 <div id="sign_up_status" class="error" style="display:block">
										    <c:if test="${!empty RESULT}">
										    	<p id="x1" >
										    		<i class="fas fa-exclamation-circle"></i> <c:out value="${RESULT}"/>
										    	</p>
										    </c:if>
											<c:if test="${!empty ERRORS.username}">
												<p id="x1" >
									    			<i class="fas fa-exclamation-circle"></i> <c:out value="${ERRORS.username}"/>
									    		</p>
										    </c:if>
										   	<c:if test="${!empty ERRORS.email}">
										   		<p id="x2" >
								    				<i class="fas fa-exclamation-circle"></i> <c:out value="${ERRORS.email}"/>
								    			</p>
										    </c:if>
										    <c:if test="${!empty ERRORS.password}">
										   		<p id="x4" >
								    				<i class="fas fa-exclamation-circle"></i> <c:out value="${ERRORS.password}"/>
								    			</p>
										    </c:if>
									 </div>
										
			                      </c:when>	
			                      <c:otherwise>
			                     	 <div id="sign_up_status">
			                     	 </div>
								  </c:otherwise>
			                      
		                      </c:choose>
                      
                        <div id="signup_b">
                            <form id="signup_f" action="<c:url value="/signUp"/>" method="post">
                                <p>
                                    Username :<span style="color:rgba(255,0,0,.8);">*</span>
                                </p>
                                <input  id="username" type="text" name="username"/>
                                <p>
                                    Email : <span style="color:rgba(255,0,0,.8);">*</span>
                                </p>
                                <input  id="email" type="email" name="email"/>

                                <p >
                                    Mot de passe : <span style="color:rgba(255,0,0,.8);">*</span>
                                </p>
                                <input id="password" type="password" name="password"/>

                                <p >
                                    Confirmer votre mot de passe :<span style="color:rgba(255,0,0,.8);">*</span>
                                </p>
                                <input id="password_conf" type="password" name="password_conf"/>

                              <div id="checkbox_cont">
                                
                                <p id="mic_f_rules">
                                    <input name="rules" type="checkbox" value="false">  J'accept les règles d'utilisation 
                                </p>
                                <p id="new_email_send">
                                    <input name="pub" type="checkbox" value="false">  Envoyer les nouveautée du forum sur mail
                                </p>
                              </div>
                              
                             	 <input id="submit_butt" type="submit" value="S'inscrire"/>
                             	 
                            </form>
                        </div>
                    
                    </div>
                </div>
        </div>
		
		<c:import url="footer.jsp"/>
		
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
        <script src="assets/js/home/signUp.js"></script>
        <script src="assets/js/home/generic.js"></script>
    </body>
</html>