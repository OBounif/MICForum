<!DOCTYPE html>
<html> 
<head>
    
        <title>FORUM | Administration</title>
        <meta charset="UTF-8"/>
	    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.12.1/css/all.css" crossorigin="anonymous">
        <link rel="stylesheet" href="../assets/css/admin/forumSetting.css"/>
	    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
        
        <c:import url="header.jsp"/>
        
        
        
        <div id="mic_body_container">
            <div id="mic_body_container_main">
                <header>
                    <p id="current_location">
                        <i class="fas fa-home" style="font-size: 15px;color: rgba(0,0,0,.7);"></i> 
                    /<a href="#">home</a>/<a href="#">user</a>/<a href="#">setting</a>
                    </p>
                </header>
                <div id="forum_setting_main" >
                     <div id="forum_setting_l_s">
                        <ul id="forum_setting_menu">
                            <li id="forum_setting_menu_head">
                                  <p>Paramètres Forum MIC</p>
                            </li>

                            <li class="forum_setting_list_item">
                                    <p>Ajouter Forum</p>                           
                            </li>
                            
                          
                            
                            <li class="forum_setting_list_item">
                                    <p>Chercher Forum</p>
                            </li>
                            
                           
                        </ul>
                     </div>
     
                    <div id="forum_setting_r_s">
                        <form id="forum_add" action="" method="get" style="display: none;">
                            <div id="" class="general_input">
                                <label for="forum_title">Forum title</label>
                                <input id="forum_title" type="text" class="genera_style_inp" name="forum_title" style="width:70%;"/>
                            </div>
                           
                            <div id="forum_father_div" class="general_input">
                                <label for="forum_father" style="align-self: center;">Forum Parent </label>
                                <select name="forum_father" id="forum_father" class="genera_style_inp">
                                    <optgroup label="News">
                                        <option value="volvo" >Volvo</option>
                                        <option value="saab">Saab</option>
                                        <option value="mercedes">Mercedes</option>
                                        <option value="audi">Audi</option>
                                    </optgroup>
                                  </select>
                            </div>

                            <div id="forum_description_div">
                                <label for="forum_description">Forum description </label><br/><br/>
                                <textarea id="forum_description" type="test" name="forum_description" class="genera_style_inp"></textarea>
                            </div>
                            
                            <div id="forum_radio_butt">
                                <input type="radio" id="public_choice" name="forum_visibility" value="public">
                                <label for="public_choice">Public</label>

                                <input type="radio" id="private_choice" name="forum_visibility" value="private">
                                <label for="private_choice">Private</label>
                            </div>
                            <div id="mod_button_div">
                                <input id="sub_butt" type="submit"/>
                            </div>
                        </form>
                    
                        <form id="forum_search" action="" method="get">
                            
                            <div id="" class="general_input">
                                <label for="forum_title">Forum title</label>
                                <input id="forum_title" type="text" class="genera_style_inp" name="forum_title" style="width:70%;"/>
                            </div>
                           
                            <div id="forum_search_result">
                                <ul id="forum_search_list">
                                    <li class="forum_search_item">
                                        <div class="forum_d_item">
                                            <div class="forum_d_item_logo">
                                                <img src="../assets/images/logos/forum_logo_read.png"/>
                                            </div>
                                            <div class="forum_d_item_info">
                                                <a href="#" class="forum_d_item_title">
                                                        News
                                                </a>
                                                <p class="forum_d_item_desc">
                                                    Vous trouverez sur ce forum tout ce qui a relation au nouveauté
                                                </p>
                                                <p class="forum_d_item_subf">
                                                    Sousforum : 
                                                    <a class="subf_link" href="#">test1</a>,
                                                    <a class="subf_link" href="#">test2</a>,
                                                    <a class="subf_link" href="#">test3</a> 
                                                </p>
                                            </div>   
                                        </div>
                                    </li>
                                </ul>

                            </div>

                            
                            
                           
                            <div id="mod_button_div">
                                <input id="sub_butt" type="submit" value="Chercher"/>
                            </div>
                        </form>
                        <div class="forum_d_item_operations" style="display: none;">
                            <input class="class_butt_op" type="submit" value="Supprimer"/>  
                            <input class="class_butt_op" type="submit" value="Rendre public"/>
                            <input class="class_butt_op" type="submit" value="Rendre privée"/>   
                        </div>
                    </div>
                </div>
                
               
            </div> 
        </div>
        
		<c:import url="footer.jsp"/>
    </body>
</html>
