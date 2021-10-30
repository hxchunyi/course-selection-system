window.addEventListener('load', function() {
          
            var login = document.querySelector('#login');
            var title = document.querySelector('.title');
            var box = document.getElementsByClassName("box")[0];
      	  var input = document.querySelectorAll("input");
      	  var userRight = document.querySelector('#userRight');
      	  var loginRight = document.querySelector('#loginRight');
      	 
      	  var button =document.querySelectorAll("button");
      	  var flag =false;
      	  input[0].addEventListener('focus', function() {
	            box.style.display = 'none';
	        });
      	  //
      	  
      	  
      	  
      	  //判断验证码
      	 input[0].addEventListener('blur', function() {
      		if (window.XMLHttpRequest) {
    			req = new XMLHttpRequest();
    		} else {
    			req = new ActiveXObject("Microsoft.XMLHTTP");
    		}
    		var username = input[0].value;
    		req.open("POST", "user?username=" + username + "", true);
    		req.onreadystatechange = function() {
    			if (req.readyState == 4 && req.status == 200) {
    				var result = req.responseText;
    				if (result == "true") {
    					userRight.style.display = 'block';
    					userRight.style.color='green';
    					userRight.innerHTML  = "用户名正确";
    				} else{
    					userRight.style.display = 'block';
    				userRight.style.color='red';
    				userRight.innerHTML  = "用户名错误";
    				}
    		      };
    		  }
    		req.send();
	        });
      	 input[1].addEventListener('focus', function() {
	            box.style.display = 'block';
	        })
	       //登录
	        console.log(isSuccess);
	        	button[0].addEventListener('click', function() {
	        		if(isSuccess){
	        		if (window.XMLHttpRequest) {
	        			req = new XMLHttpRequest();
	        		} else {
	        			req = new ActiveXObject("Microsoft.XMLHTTP");
	        		}
	        		var username =input[0].value;
	        		var password =input[1].value;
	        		req.open("POST", "login?username=" + username + "&&password=" + password
	        				+ "", true);
	        		req.onreadystatechange = function() {
	        			if (req.readyState == 4 && req.status == 200) {
	        				var result = req.responseText;
	        				if (result == "false") {
	        					loginRight.style.display='block';
	        				} else
	        					window.location.href="index";
	        			}
	        		};

	        		req.send();
	        		}
	        		else{
	        			alert("验证未成功");
	        		}	
	        	});
      	 //移动登录框
      	 input[1].addEventListener('focus', function() {
      		 loginRight.style.display = 'none';
      	 });
            title.addEventListener('mousedown',

                function move(e) {
                    var x = e.pageX - this.offsetLeft;
                    var y = e.pageY - this.offsetTop;

                    function move1(e) {
                        login.style.marginLeft = e.pageX - x + 'px';
                        login.style.marginTop = e.pageY - y + 'px';
                    }
                    login.addEventListener('mousemove', move1);
                    document.addEventListener('mouseup', function() {
                        login.removeEventListener('mousemove', move1);
                    });
                });
            //
        });