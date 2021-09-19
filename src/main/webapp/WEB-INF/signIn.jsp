<c:if test="${!empty requestScope.ERRORS}" var="error"/>
<!DOCTYPE html>
<html> 
<head>
        <title>MIC FORUM</title>
        <meta charset="UTF-8"/>
        
        <link rel="stylesheet" href="<c:url value="/assets/css/signIn.css"/>">
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
                        /<a href="<c:url value="/home"/>">home</a>/<a href="<c:url value="/#"/>">SignIn</a>
                        </p>
                    </header>
                    <div id="mic_main_body">
                        <div id="signin_h">
                            <h2>Se Connecter</h2>
                            <h3>Vous n'avez pas de compte ? <a href="<c:url value="/signUp"/>">S'inscrire</a></h2>
                        </div>
                        
                    
	                        <c:if test ="${error == \"true\"}">
	                       	 
	                       		 <div id="sign_in_status" class="error" >
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
									   	<c:if test="${!empty ERRORS.password}">
									   		<p id="x1" >
							    				<i class="fas fa-exclamation-circle"></i> <c:out value="${ERRORS.password}"/>
							    			</p>
									    </c:if>
									    <c:if test="${!empty ERRORS.password}">
									   		<p id="x1" >
							    				<i class="fas fa-exclamation-circle"></i> <c:out value="${ERRORS.password}"/>
							    			</p>
									    </c:if>
								 </div>
									
		                      </c:if>	   
	                   
	                      				
                        <div id="signin_b">
                            <form id="signin_f" action="<c:url value="/signIn"/>" method="post">
                                <p id="username">
                                    Username :<span style="color:rgba(255,0,0,.8);">*</span>
                                </p>
                                <input 
                                	type="text" 
                                	name="username"
                                	value="<c:out value="${USER_MODEL.user_name}"/>"
                                	/>
                               

                                <p id="password">
                                    Mot de passes : <span style="color:rgba(255,0,0,.8);">*</span>
                                </p>
                                
                                <input 
                                	type="password" 
                                	name="password" 
                                	value="<c:out value="${USER_MODEL.user_password}"/>"
                                	/>


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

		<c:import url="footer.jsp"/>
		
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js" type="text/javascript"></script>
        <script src="<c:url value="/assets/js/home/generic.js"/>" type="text/javascript"></script>
        <script src="<c:url value="/assets/js/home/signIn.js"/>" type="text/javascript"></script>
    </body>
</html>