<!DOCTYPE html>
<html> 
<head>
    
        <title>FORUM | Administration</title>
        <meta charset="UTF-8"/>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
        <link rel="stylesheet" href="assets/css/addTopic.css"/>
        <script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
        <script src="assets/js/tinymce/tinymce.min.js"></script> 
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
                           /<a href="#">home</a>/<a href="#">Administration</a>
                        </p>
                    </header>

                    <div id="mic_main_body">
                        <div id="topic_info">
                            <div class="input-group mb-3">
                                <label class="input-group-text" for="inputGroupSelect01">Topic Context</label>
                                <select class="form-select" id="inputGroupSelect01">
                                    <optgroup label="Languages">
                                        <option value="c/c++">C/C++</option>
                                        <option value="php">PHP</option>
                                        <option value="java">Java</option>
                                        <option value="javascript">JavaScript</option>
                                        <option value="python">Python</option>
                                        <option value="assembler">Assembler</option>
                                    </optgroup>
                                    <optgroup label="Others">
                                        <option value="networking">Networking</option>
                                        <option value="sp">SP</option>
                                        <option value="linuxos">LinuxOS</option>
                                        <option value="macos">MacOS</option>
                                        <option value="windowsos">WindowsOS</option>
                                    </optgroup>
                                </select>
                            </div>
                            <div class="input-group mb-3">
                                <span class="input-group-text" id="basic-addon1">Topic title</span>
                                <input type="text" class="form-control" placeholder="Entrer le titre du sujet" aria-label="Username" aria-describedby="basic-addon1">
                              </div>
                        </div>

                        <div id="reply_container">
                            <!-- dev own texteditor for later
                                <div id="repl_header">
                                <div id="text_operation">
                                  
                                </div>
                                </div>-->
                            <div id="reply_body">
                                <textarea name="message" id="reply_text" placeholder="Ecriver votre message ici"></textarea>    
                            </div>
                            <div id="reply_footer">
                                <button id="message_send_button">Poster</button>
                            </div>
                        </div>

                        

                    </div>
                </div> 
        </div>
        
        <c:import url="footer.jsp"/>
        
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
        <script src="assets/js/home/topic.js"></script>
        <script src="assets/js/home/generic.js"></script>
        <script>
            tinymce.init({
              selector: '#reply_text',
              branding:false,
              resize: false,
              statusbar: false,
              plugins: 'image',
              file_picker_callback: function (cb, value, meta) {
                var input = document.createElement('input');
                input.setAttribute('type', 'file');
                input.setAttribute('accept', 'image/*');

                /*
                Note: In modern browsers input[type="file"] is functional without
                even adding it to the DOM, but that might not be the case in some older
                or quirky browsers like IE, so you might want to add it to the DOM
                just in case, and visually hide it. And do not forget do remove it
                once you do not need it anymore.
                */

                input.onchange = function () {
                var file = this.files[0];

                var reader = new FileReader();
                reader.onload = function () {
                    /*
                    Note: Now we need to register the blob in TinyMCEs image blob
                    registry. In the next release this part hopefully won't be
                    necessary, as we are looking to handle it internally.
                    */
                    var id = 'blobid' + (new Date()).getTime();
                    var blobCache =  tinymce.activeEditor.editorUpload.blobCache;
                    var base64 = reader.result.split(',')[1];
                    var blobInfo = blobCache.create(id, file, base64);
                    blobCache.add(blobInfo);

                    /* call the callback and populate the Title field with the file name */
                    cb(blobInfo.blobUri(), { title: file.name });
                };
                reader.readAsDataURL(file);
                };

                input.click();
            }
           });
          </script>
    
       
    </body>
</html>