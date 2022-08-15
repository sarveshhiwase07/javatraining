const stateSelectElement = document.getElementById('states');
const citySelectElement = document.getElementById('cities');
const loadingElement = document.querySelector('.loading');

function getStates(){
	const url = "states.jsp";
	
	fetch(url)
	.then((response) => response.json()).catch((err) => console.log(err))
	.then((states) => {
		let options = ``;
		states.forEach((state) => {
			options += `<option value="${state.stateID}">${state.stateName} </option>`;
		})
		stateSelectElement.insertAdjacentHTML('beforeend',options);
	}
	).catch((err) => console.log(err));
}

function getCities()
{
	loadingElement.style.display = "flex";
	const url="cities.jsp?stateid=" + stateSelectElement.value;
	fetch(url)
	.then((response) => response.json()).catch((err) => console.log(err))
	.then((cities) => {
		let options = `<option value="0"> Select a city </option>`;
		cities.forEach((city) => {
			options += `<option value="${city.cityName}">${city.cityName} </option>`;
		})
		citySelectElement.innerHTML = options; 
		loadingElement.style.display = "none";
	}
	).catch((err) => console.log(err));
}

function startPage(){
	loadingElement.style.display = "flex";
	setTimeout(() => {
		getStates();
		loadingElement.style.display = "none";
	},3000);
}

(startPage)();

