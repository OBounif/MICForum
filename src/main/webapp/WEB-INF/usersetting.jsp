<c:if test="${!empty requestScope.ERRORS}" var="error"/>
<jsp:useBean id="user_date" class="com.bounifomar.micforum.models.date.DateP" />
<jsp:setProperty name="user_date" property="date" value="${sessionScope.USER_SESS.user_birthdate}" />
<!DOCTYPE html>
<html> 
<head>
		<title>FORUM | Administration</title>
        <meta charset="UTF-8"/>
        <link rel="stylesheet" href="<c:url value="/assets/css/usersetting.css"/>"/>
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
                <header>
                    <p id="current_location">
                        <i class="fas fa-home" style="font-size: 15px;color: rgba(0,0,0,.7);"></i> 
                    /<a href="<c:url value="/home"/>">home</a>/<a href="<c:url value="/users/${USER_SESS.user_name}"/>"> <c:out value="${USER_SESS.user_name}"/> </a>/<a href="#">setting</a>
                    </p>
                </header>
                <div id="user_setting_main" >
                     <div id="user_setting_l_s">
                        <ul id="user_setting_menu">
                            <li id="user_setting_menu_head">
                                  <p>Paramètres</p>
                            </li>

                            <li id="general_inf" class="user_setting_list_item selected selected" >
                                    <p>Information Géneral</p>                           
                            </li>
                            
                            <li id="pass_ch" class="user_setting_list_item">
                                    <p>Mot depasse</p>
                            </li>

                        </ul>
                     </div>
                     <div id="user_setting_r_s" >
                           <div id="container">
                                <form id="passwd_ch" action="<c:url value="/user/change_password"/>" method="post" style="display: none;">
                                    <div id="" class="general_input">
                                        <label for="user_oldpass">Ancien mot de passe</label>
                                        <input id="user_oldpass" type="password" class="genera_style_inp" name="user_oldpass"/>
                                    </div>
                                    <div id="" class="general_input">
                                        <label for="user_newpass">Nouveau mot de passe</label>
                                        <input id="user_newpass" type="password" class="genera_style_inp" name="user_newpass"/>
                                    </div>
                                    <div id="" class="general_input">
                                        <label for="user_newpassconf">Confirmation nouveau mot de passe</label>
                                        <input id="user_newpassconf" type="password" class="genera_style_inp" name="user_newpassconf"/>
                                    </div>
                                    <div class="mod_button_div">
                                        <input id="butt_passw_sub" class="sub_butt" type="submit"/>
                                    </div>
                                </form>
                                <form id="general_info_ch" method="post" action="<c:url value="/user/userSetting"/>" enctype="multipart/form-data">
                                    <div id="user_pics">
                                        <div id="user_cover_pic_in">
                                            <img id="img_cover_pic" src="<c:url value="/static/p_i/${USER_SESS.user_coverpic_path}"/>"/><br/>
                                            <input type="file" accept="image/*"  name="user_coverpic" id="user_coverpic" style="display:none;"/>
                                            <label id="user_cover_pic_label" for="user_coverpic">Upload Cover Image</label>
                                        </div>  
                                        <div id="user_profile_pic_in">
                                            <img id="img_profile_pic" src="<c:url value="/static/p_i/${USER_SESS.user_pic_path}"/>"/>
                                            <input type="file" accept="image/*" name="user_profpic" id="user_profpic" style="display:none;"/>
                                            <label id="user_profile_pic_label" for="user_profpic">Upload Profile Image</label>
                                        </div>  
                                    </div>
                                    <div id="user_info">
                                        <div id="inp_g_group">
                                            <div id="inp_inner_grup">
                                                <div id="" class="general_input">
                                                    <label for="user_name">Username</label>
                                                    <input id="user_name" type="email" class="genera_style_inp" name="user_name" value="<c:out value="${USER_SESS.user_name}"/>" readonly/>
                                                </div>
                                                <div id="" class="general_input">
                                                    <label for="user_email">Email</label>
                                                    <input id="user_email" type="email" class="genera_style_inp" value="<c:out value="${USER_SESS.user_email}"/>"name="user_email" readonly/>
                                                </div>
                                                <div id="" class="general_input">
                                                    <label for="user_age">Age</label>
                                                    <input id="user_age" type="email" class="genera_style_inp" value="<c:out value="${USER_SESS.user_age}"/>" name="user_age" readonly/>
                                                </div>
                                                <div id="" class="general_input">
                                                    <label for="user_address">Adresse</label>
                                                    <input id="user_address" type="text" class="genera_style_inp" value="<c:out value="${USER_SESS.user_address}"/>" name="user_address"/>
                                                </div>
                                            </div>
                                            <div id="inp_inner_grup1">
                                                <div id="" class="general_input">
                                                    <label for="user_country">Pays</label>
                                                    <input id="user_country" type="text" class="genera_style_inp " value="<c:out value="${USER_SESS.user_country}"/>" name="user_country"/>
                                                </div>
                                                <div id="" class="general_input">
                                                    <label for="user_city">Ville</label>
                                                    <input id="user_city" type="text" class="genera_style_inp"  value="<c:out value="${USER_SESS.user_city}"/>"  name="user_city"/>
                                                </div>
                                                <div id="" class="general_input">
                                                    <label for="user_bithdate">Date de naissance</label>
                                                    <c:choose>
                                                    	<c:when test="${!empty USER_SESS.user_birthdate}">
                                                    	    <input id="user_bithdate" type="date"  class="genera_style_inp" value="${user_date.year}-${user_date.month}-${user_date.day}" name="user_birthdate"/>
                                                    	</c:when>
                                                    	<c:otherwise>
                                                    	    <input id="user_bithdate" type="date"  class="genera_style_inp" value="" name="user_birthdate"/>                                        	
                                                    	</c:otherwise>
                                                    </c:choose>
                                                </div>
                                                <div id="" class="general_input">
                                                    <label for="user_gender">Genre</label>
                                                    <select name="user_gender" class="genera_style_inp" >
                                                        <option value="m">
                                                            Masculin
                                                        </option>
                                                        <option value="f">
                                                            Feminin
                                                        </option>
                                                    </select>
                                                </div>
                                            </div>
                                        </div>
                                        <div id="user_signature_div">
                                            <label for="user_signature">Signature</label><br/><br/>
                                            <textarea id="user_signature" type="text" name="user_signature"  class="genera_style_inp"><c:out value="${USER_SESS.user_signature}"/></textarea>
                                        </div>
                                    <fieldset id="user_social_net" >
                                        <legend>Reseaux sociaux</legend>
                                            <div id="">
                                                <label for="user_facebook">Facebook</label>
                                                <input id="user_facebook" type="text" name="user_facebook" value="<c:out value="${USER_SESS.user_fburl}"/>" class="genera_style_inp "  />
                                            </div>
                                            <div id="">
                                                <label for="user_twitter">Twitter</label>
                                                <input id="user_twitter" type="text" name="user_twitter" value="<c:out value="${USER_SESS.user_twitterurl}"/>" class="genera_style_inp" />
                                            </div>
                                            <div id="">
                                                <label for="user_github">Github</label>
                                                <input id="user_github" type="text" name="user_github" value="<c:out value="${USER_SESS.user_githuburl}"/>" class="genera_style_inp" />
                                            </div>
                                        </fieldset>
                                    </div>
                                    <div class="mod_button_div">
                                        <input id="butt_general_inf_sub" class="sub_butt" type="submit"/>
                                    </div>
                                    
                                    
                                </form>
                                
                                <c:choose>
		                        <c:when test ="${error == \"true\"}">
		                       	 
		                       		 <div id="block_status" class="error" style="display:block">
										    <c:if test="${!empty ERRORS.user_coverpic}">
										    	<p id="x1" >
										    		<i class="fas fa-exclamation-circle"></i> <c:out value="${ERRORS.user_coverpic}"/>
										    	</p>
										    </c:if>
											<c:if test="${!empty ERRORS.user_profpic}">
												<p id="x2" >
									    			<i class="fas fa-exclamation-circle"></i> <c:out value="${ERRORS.user_profpic}"/>
									    		</p>
										    </c:if>
										   	<c:if test="${!empty ERRORS.user_address}">
										   		<p id="x16" >
								    				<i class="fas fa-exclamation-circle"></i> <c:out value="${ERRORS.user_address}"/>
								    			</p>
										    </c:if>
										    <c:if test="${!empty ERRORS.user_country}">
										   		<p id="x512" >
								    				<i class="fas fa-exclamation-circle"></i> <c:out value="${ERRORS.user_country}"/>
								    			</p>
										    </c:if>
										   	<c:if test="${!empty ERRORS.user_birthdate}">
										   		<p id="x512" >
								    				<i class="fas fa-exclamation-circle"></i> <c:out value="${ERRORS.user_country}"/>
								    			</p>
										    </c:if>
										    <c:if test="${!empty ERRORS.user_city}">
										   		<p id="x256" >
								    				<i class="fas fa-exclamation-circle"></i> <c:out value="${ERRORS.user_city}"/>
								    			</p>
										    </c:if>
										    <c:if test="${!empty ERRORS.user_signature}">
										   		<p id="x4" >
								    				<i class="fas fa-exclamation-circle"></i> <c:out value="${ERRORS.user_signature}"/>
								    			</p>
										    </c:if>
										    <c:if test="${!empty ERRORS.user_fburl}">
										   		<p id="x32" >
								    				<i class="fas fa-exclamation-circle"></i> <c:out value="${ERRORS.user_fburl}"/>
								    			</p>
										    </c:if>
										    <c:if test="${!empty ERRORS.user_twitterurl}">
										   		<p id="x64" >
								    				<i class="fas fa-exclamation-circle"></i> <c:out value="${ERRORS.user_twitterurl}"/>
								    			</p>
										    </c:if>
										    <c:if test="${!empty ERRORS.user_githuburl}">
										   		<p id="x128" >
								    				<i class="fas fa-exclamation-circle"></i> <c:out value="${ERRORS.user_githuburl}"/>
								    			</p>
										    </c:if>
										    <c:if test="${!empty ERRORS.user_oldpass}">
										   		<p id="x32" >
								    				<i class="fas fa-exclamation-circle"></i> <c:out value="${ERRORS.user_oldpass}"/>
								    			</p>
										    </c:if>
										      <c:if test="${!empty ERRORS.user_newpass}">
										   		<p id="x64" >
								    				<i class="fas fa-exclamation-circle"></i> <c:out value="${ERRORS.user_newpass}"/>
								    			</p>
										    </c:if>
										      <c:if test="${!empty ERRORS.user_newpassconf}">
										   		<p id="x128" >
								    				<i class="fas fa-exclamation-circle"></i> <c:out value="${ERRORS.user_newpassconf}"/>
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
                </div>
                
               
            </div> 
        </div>
        
        
      	<c:import url="footer.jsp"/>
        
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
        <script src="<c:url value="/assets/js/home/userSetting.js"/>"></script>
</body>
</html>