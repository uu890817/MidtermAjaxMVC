const username = document.getElementById('username');
const password = document.getElementById('password');
const loginBtn = document.getElementById('loginBtn');
const errorDiv = document.getElementById('errorDiv');


loginBtn.addEventListener('click', () => {
    console.info(username.value);
    console.info(password.value);

    var xh = new XMLHttpRequest();
    xh.open('post', 'login');
    xh.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
    let data = `username=${username.value}&password=${password.value}`;
    console.log(data);
    xh.send(data);

    xh.onload = function () {
        console.log(xh.status);
        console.log(xh.responseText);

        if ((xh.responseText) == 'Error' && (xh.status) == 200) {
            errorDiv.innerHTML = '帳號或密碼錯誤';
        }
        if ((xh.responseText) == 'OK' && (xh.status) == 200) {
            errorDiv.innerHTML = '登入成功';
            location.replace('loginPage');
        }

    }


})






















