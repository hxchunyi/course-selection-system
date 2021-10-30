
var box = document.getElementsByClassName("box")[0];
var ball = document.getElementsByClassName("ball")[0];
var bgColor = document.getElementsByClassName("bgColor")[0];
var tips = document.getElementsByClassName("tips")[0];
var login = document.querySelector(".login");
// 设置成功状态		
var isSuccess = false; //默认为false 不成功
ball.onmousedown = function(e) {
        var e = e || window.event;

        // 获取鼠标相对于事件源左上角的位置
        var posx = e.offsetX;
        // 每次鼠标按下时 清除动画样式
        ball.style.transition = "";
        bgColor.style.transition = "";
        document.onmousemove = function(e) {
            var e = e || login.event;
            console.log(e.pageX);

            var x = e.pageX - 760 - box.offsetLeft - posx;
            console.log(x);
            var max = box.clientWidth - ball.clientWidth;
            if (x < 0) {
                x = x + 288;
            }
            if (x >= max) {
                x = max;

            }
            bgColor.style.width = x + "px";
            console.log(ball.style.left);
            ball.style.left = x + "px";
            bgColor.style.backgroundColor = "#6ff";
            if (x == max) {
                success();
            }
        }
        document.onmouseup = function() {
            // 如果没有解锁成功则返回原点
            if (!isSuccess) {
                bgColor.style.width = 0 + "px";
                ball.style.left = 0 + "px";
                ball.style.transition = "left 0.6s linear";
                bgColor.style.transition = "width 0.6s linear";
            }
            // 鼠标抬起时,移除鼠标移动事件和鼠标抬起事件
            document.onmouseup = null;
            document.onmousemove = null;
        }
    }
    // 定义一个滑块解锁成功的方法
function success() {
    isSuccess = true;
    // 获取图标
    tips.innerHTML = "解锁成功";
    bgColor.style.backgroundColor = "lightgreen";

    //滑动成功时，移除鼠标按下事件
    ball.onmousedown = null;
}
