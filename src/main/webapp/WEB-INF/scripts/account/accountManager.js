const tBody = document.getElementById('tableBody');


window.onload = () => {
	var xh = new XMLHttpRequest();

	xh.open('get', 'accountManager');
	xh.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
	xh.send();

	xh.onload = function() {
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
			let editBtn = document.createElement('button');
			let editImg = document.createElement('img');
			editBtn.setAttribute('data-bs-toggle', 'modal');
			editBtn.setAttribute('data-bs-target', '#exampleModal');
			editBtn.className = "btn btn-outline-secondary";
			editImg.setAttribute('id', `edit${jsonData[i].userId}`)
			editImg.src = 'images/icon/setting.svg'
			editImg.width = 16;
			editBtn.addEventListener('mouseover', () => {
				let editImg = document.getElementById(`edit${jsonData[i].userId}`);
				editImg.src = 'images/icon/settingHover.svg'
			})
			editBtn.addEventListener('mouseout', () => {
				let editImg = document.getElementById(`edit${jsonData[i].userId}`);
				editImg.src = 'images/icon/setting.svg'
			})
			editBtn.addEventListener('click', () => {
				let deleteInfo = document.getElementById('deleteInfo');
				deleteInfo.setAttribute('data-deleteId', jsonData[i].userId);
				deleteInfo.innerHTML = `確定要刪除<span style="color:red;">${jsonData[i].userName}</span>的所有資料嗎`;
			})
			
			
			
			editBtn.appendChild(editImg);
			editIcon.appendChild(editBtn);

			let deleteIcon = document.createElement('td');
			let deleteBtn = document.createElement('button');
			let deleteImg = document.createElement('img');
			deleteBtn.setAttribute('data-bs-toggle', 'modal');
			deleteBtn.setAttribute('data-bs-target', '#deleteModal');
			deleteBtn.className = "btn btn-outline-secondary";
			deleteBtn.setAttribute('id', jsonData[i].userId) 

			deleteImg.src = 'images/icon/DeleteButtonDefault.svg'
			deleteImg.width = 16;
			deleteImg.setAttribute('id', `deleteImg${jsonData[i].userId}`)
			deleteBtn.addEventListener('mouseover', () => {
				let deleteImg = document.getElementById(`deleteImg${jsonData[i].userId}`);
				deleteImg.src = 'images/icon/DeleteButtonHover.svg'
			})
			deleteBtn.addEventListener('mouseout', () => {
				let deleteImg = document.getElementById(`deleteImg${jsonData[i].userId}`);
				deleteImg.src = 'images/icon/DeleteButtonDefault.svg'
			})
			deleteBtn.addEventListener('click', () => {
				let deleteInfo = document.getElementById('deleteInfo');
				deleteInfo.setAttribute('data-deleteId', jsonData[i].userId);
				deleteInfo.innerHTML = `確定要刪除<span style="color:red;">${jsonData[i].userName}</span>的所有資料嗎`;
			})
			deleteBtn.appendChild(deleteImg);
			deleteIcon.appendChild(deleteBtn);

			tr.appendChild(id);
			tr.appendChild(username);
			tr.appendChild(email);
			tr.appendChild(isAdmin);
			tr.appendChild(isTeacher);
			tr.appendChild(coin);
			tr.appendChild(editIcon);
			tr.appendChild(deleteIcon);


			tr.addEventListener('mouseover', () => {
				tr.style.backgroundColor = "#dee2e6";
			})
			tr.addEventListener('mouseout', () => {
				tr.style.backgroundColor = "#FFF";
			})

			tBody.appendChild(tr);

		}

	}

}


//------------------------------------------------------
let deleteCommit = document.getElementById('deleteCommit');
let deleteId = document.getElementById('deleteInfo').dataset;

deleteCommit.addEventListener('click', () => {
	console.log(deleteId.deleteid);

	let xhr = new XMLHttpRequest();
	xhr.open('delete', `accountManager/${deleteId.deleteid}`);
	xhr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
	xhr.send();
	xhr.onload = function() {
		console.log(xhr.status);
		console.log(xhr.responseText);
		
		if(xhr.responseText == 'true'){
			location.replace('loginPage');
		}else{
			alert('發生錯誤');
		}
		
		


	}

})







