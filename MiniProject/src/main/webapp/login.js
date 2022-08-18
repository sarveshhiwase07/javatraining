const doc = (ele) => document.getElementById(ele);

function validate(){
	let isgood = true;
	const email = doc('email').value;
	const password = doc('password').value;
	let output = "";
	if(email == ""){
		output += "Email cannot be empty,";
		isgood = false;
	} 
	if(password == ""){
		output += "Password cannot be empty";
		isgood = false;
	}
	if(output != ""){
		const error = doc('error');
		error.innerHTML = output;
	}
	return isgood;
}