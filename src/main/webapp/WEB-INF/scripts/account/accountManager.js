function deleteCheck(id, deleteName) {
    const inputText = document.getElementById("deleteUserId");
    const _deleteName = document.getElementById("_deleteName");
    inputText.value = id;
    _deleteName.innerHTML = deleteName;
} 

function turnSetting(id) {  
    console.log("pon")
    document.getElementById(id).src = '/Midterm/assets/icon/settingTurn.svg'
} 
function turnBackSetting(id) {  
    console.log("pon")
    document.getElementById(id).src = '/Midterm/assets/icon/setting.svg'
} 
 
function moveToPopup(userId, userName, userPassword, familyName, givenName, nameViewType, email, gender, nationality, birthday, isAdmin, isTeacher, tutorCoin, accountCreatDate) {

    const _userId = document.getElementById("_UserId");
    const _UserName = document.getElementById("_UserName");
    const _UserPassword = document.getElementById("_UserPassword");
    const _FamilyName = document.getElementById("_FamilyName");
    const _GivenName = document.getElementById("_GivenName");
    const _NameViewType = document.getElementById("_NameViewType");
    const _Email = document.getElementById("_Email");
    const _Gender = document.getElementById("_Gender");
    const _Nationality = document.getElementById("_Nationality");
    const _Birthday = document.getElementById("_Birthday");
    const _TutorCoin = document.getElementById("_TutorCoin");
    const _isAdmin = document.getElementById("_isAdmin");
    const _isTeacher = document.getElementById("_isTeacher");
    const _AccountCreatDate = document.getElementById("_AccountCreatDate");


    _userId.value = userId;
    _UserName.value = userName;
    _UserPassword.value = userPassword;
    _FamilyName.value = familyName;
    _GivenName.value = givenName;
    _NameViewType.value = nameViewType;
    _Email.value = email;
    _Gender.value = gender;
    _Nationality.value = nationality;
    _Birthday.value = birthday;

    if (isAdmin === "true") {
        _isAdmin.value = "1"
    } else {
        _isAdmin.value = "2"
    }

    if (isTeacher === "true") {
        _isTeacher.value = "1"
    } else {
        _isTeacher.value = "2"
    }

    _TutorCoin.value = tutorCoin;
    _AccountCreatDate.value = accountCreatDate;

}

function changeColorIn(id) {

    const tr = document.getElementById(id);
    tr.style.backgroundColor = "#cad5de";
}

function changeColorOut(id) {

    const tr = document.getElementById(id);
    tr.style.backgroundColor = "#fff";
}




