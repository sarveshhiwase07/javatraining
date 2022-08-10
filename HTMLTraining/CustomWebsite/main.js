const docshort = (ele) => document.getElementById(ele);

const emailEle = docshort('email');
const usernameEle = docshort('uname');
const passwordEle = docshort('psw');
const cityEle = docshort('city');
const mobileEle = docshort('mobile');

console.log('hello');
function validateUser(flag){
    // console.log(flag);
    // return false;
    const [username,password,email,city,mobile] = [usernameEle?.value,passwordEle?.value,emailEle?.value,cityEle?.value,mobileEle?.value];
    let errOutput = [];
    let isgood = true;
    if(username == '' || username === null){
        errOutput.push('Username Cannot be empty..');
        isgood = false;
    }
    if(password == '' || password === null){
        errOutput.push('Password Cannot be empty..');
        isgood = false;
    }
    if(flag == 'login') {
        setError(errOutput)
        return false;
    }
    if(email == ''){
        errOutput.push('Email Cannot be empty..');
        isgood = false;
    }
    if(city == ''){
        errOutput.push('City Cannot be empty..');
        isgood = false;
    }
    if(mobile == ''){
        errOutput.push('Mobile Number Cannot be empty..');
        isgood = false;
    }
    setError(errOutput)
    return isgood;
}

function setError(error){
    const errorEle = docshort('error');
    errorEle.textContent = error.join('\n');
}

function clearInput(){
     setError([]);
}
