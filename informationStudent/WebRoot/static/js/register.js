  var username = document.querySelectorAll('.inpt');
  var span = document.querySelectorAll('span');
var button = document.querySelector('button');
  var img = document.querySelector('img');
  //判断用户名
  username[0].addEventListener('blur', function(){
	  if (window.XMLHttpRequest) {
			req = new XMLHttpRequest();
		} else {
			req = new ActiveXObject("Microsoft.XMLHTTP");
		}

req.open("POST","user?username="+ username[0].value+"",true);		
		req.onreadystatechange = function() {
			if (req.readyState == 4 && req.status == 200) {
				var result = req.responseText;
				if(result=="true")
				{		
					span[0].innerHTML = "用户名已存在";
					span[0].style.color="red";
				}
				else{
					span[0].innerHTML = "用户名可用";
					span[0].style.color="green";
				}
			}
		};
		
		req.send();
  });
  //短信验证码
        var time = 4;
        button.addEventListener('click', function() {
            button.disabled = true;
            img.style.display ='block';
            var timer = setInterval(function() {
            	
                if (time == 0) {
                    clearInterval(timer);
                    button.disabled = false;
                    button.innerHTML = '发送';
                    time = 4;
                } else {
                    button.disabled = true;
                    button.innerHTML = '再次发送还需' + time + '秒';
                    time--;
                }
            }, 1000)
        });
      //密码一致验证
        var pd1 = document.querySelector('.pd1');
        var pd2 = document.querySelector('.pd2');
        var sp2 = document.querySelector('.sp2');
        pd2.addEventListener('blur',function(){
        	console.log(pd1.value);
        	console.log(pd2.value);
        	if(pd1.value==pd2.value){
        		sp2.innerHTML='密码相同';
        		sp2.style.color="green";
        	}else{
        		sp2.innerHTML='密码不相同';
        		sp2.style.color="red";
        	}
        })
        function changeimg(img) {
    		img.src = "img?chang=" + Math.random();
    	}
       