const tBody = document.getElementById('tableBody');


window.onload = () => {
    var xh = new XMLHttpRequest();

    xh.open('get', 'accountManager');
    xh.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
    xh.send();

    xh.onload = function () {
        console.log(xh.status);
        console.log(xh.responseText);

        if ((xh.status) == 200) {
            console.info(xh.responseText);
            console.log((xh.responseText).length)
        }

        const jsonData = JSON.parse(xh.responseText);

        for (let i = 0; i < jsonData.length; i++) {
            let tr = document.createElement('tr');

            let id = document.createElement('td');
            id.innerText = jsonData[i].userId;
            let username = document.createElement('td');
            username.innerText = jsonData[i].userName;
            let email = document.createElement('td');
            email.innerText = jsonData[i].email;

            let isAdmin = document.createElement('td');
            let isAdminImg = document.createElement('img');
            if (jsonData[i].admin) {
                isAdminImg.src = 'images/icon/greenCheckmark.svg';
                isAdminImg.width = '16';
            } else {
                isAdminImg.src = 'images/icon/redCross.svg';
                isAdminImg.width = '16';
            }
            isAdmin.appendChild(isAdminImg);


            let isTeacher = document.createElement('td');
            let isTeacherImg = document.createElement('img');
            if (jsonData[i].teacher) {
                isTeacherImg.src = 'images/icon/greenCheckmark.svg';
                isTeacherImg.width = '16';
            } else {
                isTeacherImg.src = 'images/icon/redCross.svg';
                isTeacherImg.width = '16';
            }
            isTeacher.appendChild(isTeacherImg);

            let coin = document.createElement('td');
            coin.innerText = jsonData[i].tutorCoin;
            let editIcon = document.createElement('td');

            let editImg = document.createElement('img');
            editImg.src = 'images/icon/setting.svg'
            editImg.width = 16;
            editIcon.appendChild(editImg);

            let deleteIcon = document.createElement('td');
            let deleteImg = document.createElement('img');
            deleteImg.src = 'images/icon/DeleteButton.svg'
            deleteImg.width = 16;
            deleteIcon.appendChild(deleteImg);

            tr.appendChild(id);
            tr.appendChild(username);
            tr.appendChild(email);
            tr.appendChild(isAdmin);
            tr.appendChild(isTeacher);
            tr.appendChild(coin);
            tr.appendChild(editIcon);
            tr.appendChild(deleteIcon);


            tr.addEventListener('mouseover', () => {
                tr.style.backgroundColor = "#6c757d";
            })
            tr.addEventListener('mouseout', () => {
                tr.style.backgroundColor = "#FFF";
            })

            tBody.appendChild(tr);

        } 

    }

}



