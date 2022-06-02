

function myValidation(){
    let fName = document.getElementById('first_name');
    let sName = document.getElementById('second_name');
    let lName = document.getElementById('last_name');
    let salary = document.getElementById('salary');
    let email = document.getElementById('email');
    let jPlace = document.getElementById('job_place');
    let button = document.getElementById('submitButton');
    let emailError = document.getElementById('error_email');
    let salaryError = document.getElementById('error_salary');

    email.addEventListener("input", function (event) {
        if (validateEmail(email)) {
            emailError.textContent = '';
            button.removeAttribute('disabled');
        } else {
            emailError.textContent = 'You need to enter an e-mail address.';
            button.setAttribute('disabled', 'true');
        }
    });
    salary.addEventListener("input", function (event) {
        if (validateSalary(salary)) {
            salaryError.textContent = '';
            button.removeAttribute('disabled');
        } else {
            salaryError.textContent = 'You need to enter an salary.';
            button.setAttribute('disabled', 'true');
        }
    });
}

function validateSalary(s) {
    let reg = /^-?\d+\.?\d*$/;
    return reg.test(s.value);
}
function validateEmail(e) {
    let reg = /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    return reg.test(e.value);
}
