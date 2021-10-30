window.addEventListener('load', function() {
    var menux = document.querySelector('.menux');
    var ps = menux.querySelectorAll('p');
    var ul = menux.querySelectorAll('ul');
    //子功能合并
    var pflag = true;
    var popen = true;
    for (var i = 0; i < ps.length; i++) {
        ps[i].addEventListener('click', function() {
            if (pflag && popen) {
                pflag = false;
                for (var i = 0; i < ul.length; i++) {
                    ul[i].style.display = 'none';
                }
                this.nextElementSibling.style.display = 'block';
            } else {
                if (popen) {
                    open = false;
                    pflag = true;
                    this.nextElementSibling.style.display = 'none';
                } else {
                    pflag = true;
                    this.nextElementSibling.style.display = 'none';
                }
            }
        })
    }
    //右侧
    var iframe = document.querySelector('iframe');
    var as = menux.querySelectorAll('a');
    var menu_title = document.querySelector('.menu_title');
    for (var i = 0; i < as.length; i++) {
        as[i].addEventListener('click', function(e) {
            var src = this.getAttribute('url');
            var title = this.getAttribute('title');
            iframe.src = src;
            menu_title.innerHTML = title;
            
        })
    }
    //确定退出
    var loginout =document.querySelector('.loginout');
    loginout.addEventListener('click',function(){
     if( window.confirm("确定要退出吗？")){
     window.location.href="login";
  }
  });
    //新增
});