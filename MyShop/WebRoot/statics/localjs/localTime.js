/*时间函数*/
function name() {
	var d = new Date();
	var s = " " + d.getFullYear() + "-" + (d.getMonth() + 1) + "-"
			+ d.getDate() + " " + d.getHours() + ":" + d.getMinutes() + ":"
			+ d.getSeconds();
	$("#time").html("NOW:");
	$("#time").html($("#time").html()+s);
}
setInterval(name, 100);