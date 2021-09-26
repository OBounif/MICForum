<!DOCTYPE html>
<html> 
<head>
    
        <title>MIC FORUM</title>
        <meta charset="UTF-8"/>
        <link rel="stylesheet" href="<c:url value="/assets/css/error.css"/>"/>
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
                <div id="img_bg">
                    <img src="<c:url value="/assets/images/error.png"/>"/>
                    <p style="align-self: center;">
                        Erreur 404 ... .Page non trouvée
                    </p>
                </div>

            </div>
        </div>
		<c:import url="footer.jsp"/>
		
        <script src="<c:url value="/assets/js/home/generic.js"/>"></script>
    </body>
</html>