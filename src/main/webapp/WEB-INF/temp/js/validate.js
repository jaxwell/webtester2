//(function (){
//
//	var elem = document.querySelector('form');
//	var button = document.querySelector('button');
//	var warningBlockArr = document.getElementsByClassName('alert alert-danger');
//
//	var emails = ['author@mail.com', 'foo@mail.com', 'tester@mail.com'];
//	var subm = [false,false,false];
//	var timer;
//
//	var regExpEmail = /^[\w-\._\+%]+@(?:[\w-]+\.)+[\w]{2,6}$/;
//	var regExpPass = /^[\w\_-]+$/;
//
//	var messageEmptyField = 'Поле, обязательное к заполнению не заполнено';
//	var messageWrongSimbol = 'Пароль содержит запрещенные символы (разрешенные - латинские буквы, цифры, подчеркивание, минус) вы ввели - ';
//	var messageShortPass = 'Пароль слишком короток (до 5 символов)';
//	var messageOnliNumber = 'Простой пароль (только числа)';
//	var messageOnliLetter = 'Простой пароль (только буквы)';
//	var messageWrongEmail = 'Ошибка в email-е. Формат - (XXX@XXX.XXX)';
//	var messageEmailNotFree = 'email уже занят - '
//
//	function validate(target){
//
//		var warningBlock = target.nextSibling.nextSibling;
//		var wrongSymbol = target.value.search(/[^\w\_-]/);
//		var numberAll = target.value.search(/^[0-9]+$/);
//		var letterAll = target.value.search(/^[a-zA-Z]+$/);
//
//		function showWarning(text, add){
//			if(add !== undefined){
//				warningBlock.innerHTML = text + add;
//			}else{
//				warningBlock.innerHTML = text;
//			}
//
//			warningBlock.setAttribute('style','display: block');
//			target.parentNode.className = 'form-group has-error';
//		}
//
//		function hideWarning(){
//			warningBlock.innerHTML = '';
//			warningBlock.setAttribute('style','display: none');
//			target.parentNode.className = 'form-group required';
//		}
//
//		function duplicate(val){
//			for(var i = 0; i < emails.length; i++){
//				if(val === emails[i]){
//					return true;
//				}
//				return false
//			}
//
//		}
//
//		if(target.id === 'inputEmail'){
//			subm[0] = false;
//			if(target.value === ''){
//				showWarning(messageEmptyField);
//				cheackSubmit();
//				return
//			}
//			if(target.value.search(regExpEmail) === (-1)){
//				console.log("ff")
//				showWarning(messageWrongEmail);
//
//			}else if(duplicate(target.value)){
//				showWarning(messageEmailNotFree);
//			}else{
//				hideWarning();
//				subm[0] = true;
//
//			}
//			cheackSubmit();
//		}
//
//		if(target.id === 'password'){
//			subm[1] = false;
//			if(target.value === ''){
//				showWarning(messageEmptyField);
//				cheackSubmit();
//				return
//			}
//			if(target.value.search(regExpPass) === (-1)){
//				if(wrongSymbol !== (-1)){
//					showWarning(messageWrongSimbol, target.value[wrongSymbol]);
//				}
//			}else if(target.value.length < 5){
//				showWarning(messageShortPass);
//			}else if(numberAll !== (-1)){
//				showWarning(messageOnliNumber);
//			}else if(letterAll !== (-1)){
//				showWarning(messageOnliLetter);
//			}else{
//				hideWarning();
//				subm[1] = true;
//			}
//			cheackSubmit();
//		}
//	}
//
//	function cheackSubmit(){
//
//		warningBlockArr[2].style.display = 'none';
//		if((subm[0] === true) && (subm[1] === true) && (subm[2] === false)){
//			warningBlockArr[2].style.display = 'block';
//		}
//		for(var i = 0; i< subm.length; i++){
//			if(subm[i] === false){
//				button.className = 'btn btn-primary disabled';
//				return
//			}
//		}
//		button.className = 'btn btn-primary';
//	}
//
//	elem.onkeydown = function(e){
//		if(e.keyCode === 13){
//			for(var i = 0; i< subm.length; i++){
//				if(subm[i] === false){
//					return false
//				}
//			}
//		}
//	}
//
//	elem.onclick = function(e){
//
//		if (e.target.type === 'checkbox'){
//			if(e.target.checked === true){
//				subm[2] = true;
//			}else{
//				subm[2] = false;
//			}
//			cheackSubmit();
//		}
//	}
//
//	elem.oninput = function(e) {
//		if (e.target.type !== 'checkbox' && e.target.id !== 'city'){
//			cheackSubmit();
//			clearTimeout(timer);
//			timer = setTimeout(function(){validate(e.target)},700);
//		}
//	}
//})();