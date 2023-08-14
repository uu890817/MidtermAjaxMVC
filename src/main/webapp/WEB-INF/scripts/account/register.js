function toNext() {
    const pUserName = document.querySelector("#pUserName");
    const pEmail = document.querySelector("#pEmail");
    const pUserPassword = document.querySelector("#pUserPassword");

    let text = "";

    if (pUserName.innerHTML !== "OK") {
        text += pUserName.innerHTML;
        text += "\n";
    }
    if (pEmail.innerHTML !== "OK") {
        text += pEmail.innerHTML;
        text += "\n";
    }
    if (pUserPassword.innerHTML !== "OK") {
        text += pUserPassword.innerHTML;
        text += "\n";
    }
    if (text !== "") { 
        alert(text);
        return;
    }

    document.querySelector(".Account").hidden = true;
    document.querySelector(".UserInfo").hidden = false;
}




function toBack() {
    document.querySelector(".Account").hidden = false;
    document.querySelector(".UserInfo").hidden = true;
}

const UserInfo = document.getElementById("UserInfo");
function submitForm() {
    const pFamilyName = document.querySelector("#pFamilyName");
    const pGivenName = document.querySelector("#pGivenName");
    const pNationality = document.querySelector("#pNationality");
    const pBirthday = document.querySelector("#pBirthday");

    let text = "";

    if (pFamilyName.innerHTML !== "OK") {
        text += pFamilyName.innerHTML;
        text += "\n";
    }
    if (pGivenName.innerHTML !== "OK") {
        text += pGivenName.innerHTML;
        text += "\n";
    }
    if (pNationality.innerHTML !== "OK") {
        text += pNationality.innerHTML;
        text += "\n";
    }
    if (pBirthday.innerHTML !== "OK") {
        text += pBirthday.innerHTML;
        text += "\n";
    }
    if (text !== "") {
        alert(text);
        return;
    }

    var form = document.getElementById('regForm');
    form.submit();
}







// 表1--------------------------------------------------------

const pUserName = document.querySelector("#pUserName");
const pEmail = document.querySelector("#pEmail");
const pUserPassword = document.querySelector("#pUserPassword");
const pUserPasswordCheck = document.querySelector("#pUserPasswordCheck");


const userName = document.querySelector("#userName");
userName.addEventListener("input", (e) => {
    console.log((userName.value).length);
    if ((userName.value).length <= 5) {
        console.log(123456)
        pUserName.innerHTML = "使用者名稱過短";
    } else {
        pUserName.innerHTML = "OK";
    }
})

const email = document.querySelector("#email");
email.addEventListener("input", (e) => {
    console.log((userName.value).length);
    const emailRegex = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
    if (emailRegex.test(email.value)) {
        pEmail.innerHTML = "OK"
    } else {
        pEmail.innerHTML = "請輸入正確的信箱格式"
    }
})

const userPassword = document.querySelector("#userPassword");
const userPasswordCheck = document.querySelector("#userPasswordCheck");
userPassword.addEventListener("input", (e) => {
    if ((userPassword.value) !== (userPasswordCheck.value)) {
        console.log(123456)
        pUserPassword.innerHTML = "兩次輸入的密碼不同";
    } else {
        pUserPassword.innerHTML = "OK";
    }
})

userPasswordCheck.addEventListener("input", (e) => {
    if ((userPassword.value) !== (userPasswordCheck.value)) {
        console.log(123456)
        pUserPassword.innerHTML = "兩次輸入的密碼不同";
    } else {
        pUserPassword.innerHTML = "OK";
    }
})

// 表2 -----------------------------------------------------------
const pFamilyName = document.querySelector("#pFamilyName");
const pGivenName = document.querySelector("#pGivenName");
const pNationality = document.querySelector("#pNationality");
const pBirthday = document.querySelector("#pBirthday");

const familyName = document.querySelector("#familyName");
const givenName = document.querySelector("#givenName");
const nationality = document.querySelector("#nationality");
const birthday = document.querySelector("#birthday");


familyName.addEventListener("input", (e) => {
    console.log((familyName.value).length);
    if ((familyName.value).length == 0) {
        pFamilyName.innerHTML = "姓氏不得為空";
    } else {
        pFamilyName.innerHTML = "OK";
    }
})
givenName.addEventListener("input", (e) => {
    console.log((givenName.value).length);
    if ((givenName.value).length == 0) {
        pGivenName.innerHTML = "姓氏不得為空";
    } else {
        pGivenName.innerHTML = "OK";
    }
})
nationality.addEventListener("input", (e) => {
    console.log((nationality.value).length);
    if ((nationality.value).length == 0) {
        pNationality.innerHTML = "姓氏不得為空";
    } else {
        pNationality.innerHTML = "OK";
    }
})
birthday.addEventListener("input", (e) => {
    console.log((birthday.value).length);
    if ((birthday.value).length == 0) {
        pBirthday.innerHTML = "姓氏不得為空";
    } else {
        pBirthday.innerHTML = "OK";
    }
})


document.querySelector("#regForm").addEventListener("keydown", (e) => {
    if (e.key === "Enter") {
        console.log(111);
        e.preventDefault();
    }
})