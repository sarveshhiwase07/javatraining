const loadingElement = document.querySelector('.loading');

function startPage(){
	loadingElement.style.display = "flex";
	setTimeout(() => {
		loadingElement.style.display = "none";
	},3000);
}

(startPage)();