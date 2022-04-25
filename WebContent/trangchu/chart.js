function generateColor(){
	let r = parseInt(Math.random()*255);
	let g = parseInt(Math.random()*255);
	let b = parseInt(Math.random()*255);
	return `rgb(${r},${g},${b})`
}
function videochart(id,view=[],tittle=[]){
    let colors = []
    for(let i = 0;i < view.length;i++){
    	colors.push(generateColor())
    }
    const data = {
        labels: tittle,
        datasets: [{
            label: 'Thống kê lượt xem của từng video',
            data: view,
            backgroundColor:colors,
            hoverOffset: 4
        }]
    };
    const config = {
        type:'doughnut',
        data: data,
    };
    let ctx = document.getElementById(id).getContext("2d")
    new Chart(ctx, config)
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
            borderWidth: 1
        }]
    };
    const config = {
        type:'bar',
        data: data,
        options: {
            scales: {
              y: {
                beginAtZero: true
              }
            }
          },
    };
    let ctx = document.getElementById(id).getContext("2d")
    new Chart(ctx, config)
}