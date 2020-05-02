getImage = function() {
	//1:获取file对象
	var upImage = document.getElementById('imgObj');
	var objImage = upImage.files[0];
	var reader = new FileReader();
	//2:解析对象，转成baae64对象的url
	reader.addEventListener("load", function() {
		var imgurl = reader.result;
		var imgId = document.getElementById('imgId');
		imgId.src = imgurl;
	}, false);

	if(objImage) {
		//在load中返回一个base64编码
		reader.readAsDataURL(objImage);
	}
}; 
function readURL(input) {
	 var reader = new FileReader();
    if (input.files && input.files[0]) {
       
        reader.onload = function (e) {
            $('#imgId').attr('src', e.target.result);
        }
        reader.readAsDataURL(input.files[0]);
    }
}
	