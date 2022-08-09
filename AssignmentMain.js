const doc = (ele) => document.getElementById(ele);
const emailEle = doc('email');
const passwordEle = doc('password');
const reenteredEle = doc('reentered');

emailEle.onkeyup = clearInput;
passwordEle.onkeyup = clearInput;
reenteredEle.onkeyup = clearInput;


function validateUser(){
    const email = emailEle.value;
    const password = passwordEle.value;
    const reEnteredPassword = reenteredEle.value;

    var isgood = true;
    if(email === ''){
        const emailerr = doc('emailErr');
        emailEle.classList.add('inputs');
        emailerr.innerHTML = 'Email Cannot be empty';
        isgood = false;
    }
    if(password === ''){
        const passwordErr = doc('passwordErr');
        passwordEle.classList.add('inputs');
        reenteredEle.classList.add('inputs');
        passwordErr.innerHTML = 'Password cannot be empty';
        isgood = false;
    }
    if(!isgood) return false;
    if(reEnteredPassword === ''){
        const reEnteredPasswordErr = doc('reenteredErr');
        reenteredEle.classList.add('inputs');
        reEnteredPasswordErr.innerHTML = 'Please Reenter the password';
        isgood = false;
    }

    if(password !== reEnteredPassword){
        const matchErr = doc('matchErr');
        passwordEle.classList.add('inputs');
        reenteredEle.classList.add('inputs');
        matchErr.innerHTML = 'Passwords do not match, please type correctly.';
        isgood = false;
    }

    return isgood;
}

function clearInput(e){
    const id = e.target.getAttribute("id");
    doc(id).classList.remove('inputs')
    const errid = id + "Err";
    doc(errid).innerHTML = '';
}