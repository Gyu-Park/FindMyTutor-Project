/* Account Edit */
function onNameEditButtonClick(){
    if (document.getElementById('edit-name-first').className === "form-control-hide"
        || document.getElementById('edit-name-first').className === "form-control-hide success"
        || document.getElementById('edit-name-first').className === "form-control-hide error") {
        document.getElementById('edit-name-label').className = "show";
        document.getElementById('edit-name-first').className = "form-control-show";
        document.getElementById('edit-name-last').className = "form-control-show";
        document.getElementById('edit-name-button').className = "form-control-show";
        document.getElementById('name-edit-btn').innerText = "Cancel";
    } else if (document.getElementById('edit-name-first').className === "form-control-show"
        || document.getElementById('edit-name-first').className === "form-control-show success"
        || document.getElementById('edit-name-first').className === "form-control-show error" ){
        document.getElementById('edit-name-label').className = "hide";
        document.getElementById('edit-name-first').className = "form-control-hide";
        document.getElementById('edit-name-first').value = "";
        document.getElementById('edit-name-last').className = "form-control-hide";
        document.getElementById('edit-name-last').value = "";
        document.getElementById('edit-name-button').className = "form-control-hide";
        document.getElementById('name-edit-btn').innerText = "Edit";
    }
}

function onEmailEditButtonClick(){
    if (document.getElementById('edit-email').className === "form-control-hide"
        || document.getElementById('edit-email').className === "form-control-hide success"
        || document.getElementById('edit-email').className === "form-control-hide error") {
        document.getElementById('edit-email-label').className = "form-control-show";
        document.getElementById('edit-email').className = "form-control-show";
        document.getElementById('edit-email-button').className = "form-control-show";
        document.getElementById('email-edit-btn').innerText = "Cancel";
    } else if (document.getElementById('edit-email').className === "form-control-show"
        || document.getElementById('edit-email').className === "form-control-show success"
        || document.getElementById('edit-email').className === "form-control-show error") {
        document.getElementById('edit-email-label').className = "form-control-hide";
        document.getElementById('edit-email').className = "form-control-hide";
        document.getElementById('edit-email-button').className = "form-control-hide";
        document.getElementById('email-edit-btn').innerText = "Edit";
    }
}

function onPhoneEditButtonClick(){
	if (document.getElementById('edit-phone').className === "form-control-hide"
        || document.getElementById('edit-phone').className === "form-control-hide success"
        || document.getElementById('edit-phone').className === "form-control-hide error") {
		document.getElementById('edit-phone').className = "form-control-show";
  		document.getElementById('edit-phone-button').className = "form-control-show";
        document.getElementById('phone-edit-btn').innerText = "Cancel";
	} else if (document.getElementById('edit-phone').className === "form-control-show"
        || document.getElementById('edit-phone').className === "form-control-show success"
        || document.getElementById('edit-phone').className === "form-control-show error") {
		document.getElementById('edit-phone').className = "form-control-hide";
  		document.getElementById('edit-phone-button').className = "form-control-hide";
        document.getElementById('phone-edit-btn').innerText = "Edit";
	}
}

function onPasswordEditButtonClick(){
	if (document.getElementById('edit-password').className === "form-control-hide" 
		|| document.getElementById('edit-password').className === "form-control-hide success"
		|| document.getElementById('edit-password').className === "form-control-hide error") {
        document.getElementById('edit-password-label').className = "show";
		document.getElementById('edit-password').className = "form-control-show";
		document.getElementById('edit-repeat-password').className = "form-control-show";
  		document.getElementById('edit-password-button').className = "form-control-show";
        document.getElementById('password-edit-btn').innerText = "Cancel";
	} else if (document.getElementById('edit-password').className === "form-control-show"
		|| document.getElementById('edit-password').className === "form-control-show success"
		|| document.getElementById('edit-password').className === "form-control-show error") {
        document.getElementById('edit-password-label').className = "hide";
		document.getElementById('edit-password').className = "form-control-hide";
		document.getElementById('edit-repeat-password').className = "form-control-hide";
  		document.getElementById('edit-password-button').className = "form-control-hide";
        document.getElementById('password-edit-btn').innerText = "Edit";
	}
}

/* Validation for Edit Textboxes */
const firstName = document.querySelector('.edit-name-first');
const lastName = document.querySelector('.edit-name-last');

function checkNameInputs() {

	const firstNameValue = firstName.value.trim();
	const lastNameValue = lastName.value.trim();

	if(firstNameValue === '') {
		setErrorFor(firstName, 'Please enter your first name');
        return false;
     } else {
		setSuccessFor(firstName);
	}
	
	if(lastNameValue === '') {
		setErrorFor(lastName, 'Please enter your last name');
        return false;
	} else{
		setSuccessFor(lastName);
	}
    return true;
}

const email = document.querySelector('.edit-email');

function checkEmailInputs() {
    const emailValue = email.value.trim();

    if(emailValue === '') {
		setErrorFor(email, 'Please enter your email');
        return false;
    } else {
		setSuccessFor(email);
	}
    return true;
}

const phone = document.querySelector('.edit-phone');

function checkPhoneInputs() {
    const phoneValue = phone.value.trim();

    if(phoneValue === '') {
		setErrorFor(phone, 'Please enter your phone number');
        return false;
    } else {
		setSuccessFor(phone);
	}
    return true;
}

const password = document.querySelector('.edit-password');
const password2 = document.querySelector('.edit-repeat-password');

function checkPasswordInputs() {

	const passwordValue = password.value.trim();
	const password2Value = password2.value.trim();

	if(passwordValue === '') {
		setErrorFor(password, 'Password cannot be blank');
        return false;
	} else if(passwordValue.length < 8) {
        setErrorFor(password, 'Password must be at least 8 characters');
        return false;
    } else if(passwordValue.length > 20) {
        setErrorFor(password, 'Password must be less than 20 characters');
        return false;
    } else {
		setSuccessFor(password);
	}
	
	if(password2Value === '') {
		setErrorFor(password2, 'Password2 cannot be blank');
        return false;
	} else if(passwordValue !== password2Value) {
		setErrorFor(password2, 'Passwords does not match');
        return false;
	} else{
		setSuccessFor(password2);
	}
    return true;
}

function setErrorFor(input, message) {
	const formControl = input.parentElement;
	const small = formControl.querySelector('small');
	formControl.className = 'form-control-show error';
	small.innerText = message;
}

function setSuccessFor(input) {
	const formControl = input.parentElement;
	formControl.className = 'form-control-show success';
}