function generateColor(){
	let r = parseInt(Math.random()*255);
	let g = parseInt(Math.random()*255);
	let b = parseInt(Math.random()*255);
	return `rgb(${r},${g},${b})`
}
function linechart(id,view=[],tittle=[]){
    let colors = []
    for(let i = 0;i < view.length;i++){
    	colors.push(generateColor())
    }
    const data = {
        labels: tittle,
        datasets: [{
            label: 'Thống kê ',
            data: view,
            backgroundColor:colors,
            hoverOffset: 4,
            fill: false,
            borderColor: 'rgb(75, 192, 192)',
            tension: 0.1
        }] 
    };
    const config = {
        type:'bar',
        data: data,
    };
    let ctx = document.getElementById(id).getContext("2d")
    new Chart(ctx, config)
}