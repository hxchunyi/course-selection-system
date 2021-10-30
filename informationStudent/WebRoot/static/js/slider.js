
var box = document.getElementsByClassName("box")[0];
var ball = document.getElementsByClassName("ball")[0];
var bgColor = document.getElementsByClassName("bgColor")[0];
var tips = document.getElementsByClassName("tips")[0];
var login = document.querySelector(".login");
// ���óɹ�״̬		
var isSuccess = false; //Ĭ��Ϊfalse ���ɹ�
ball.onmousedown = function(e) {
        var e = e || window.event;

        // ��ȡ���������¼�Դ���Ͻǵ�λ��
        var posx = e.offsetX;
        // ÿ����갴��ʱ ���������ʽ
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
            // ���û�н����ɹ��򷵻�ԭ��
            if (!isSuccess) {
                bgColor.style.width = 0 + "px";
                ball.style.left = 0 + "px";
                ball.style.transition = "left 0.6s linear";
                bgColor.style.transition = "width 0.6s linear";
            }
            // ���̧��ʱ,�Ƴ�����ƶ��¼������̧���¼�
            document.onmouseup = null;
            document.onmousemove = null;
        }
    }
    // ����һ����������ɹ��ķ���
function success() {
    isSuccess = true;
    // ��ȡͼ��
    tips.innerHTML = "�����ɹ�";
    bgColor.style.backgroundColor = "lightgreen";

    //�����ɹ�ʱ���Ƴ���갴���¼�
    ball.onmousedown = null;
}
