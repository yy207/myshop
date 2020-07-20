

var vm = new Vue({
	el:'#rrapp',
	data:{
		file:null
	},
    created: function(){
    	
    },
    //qny/test/uploading   file
	methods: {
		getFile(event) {
			  this.file = event.target.files[0];
			  this.shangchuan()
		},
		shangchuan:function(){
			var formData = new window.FormData();
	    	formData.append('file', this.file) // 'file' 这个名字要和后台获取文件的名字一样;

	    	console.log(formData);
	    	var options = {  // 设置axios的参数
	    	         url: baseURL+'qny/test/uploading',
	    	         data: formData,
	    	         method: 'post',
	    	         headers: { 
	    	          'Content-Type': 'multipart/form-data'
	    	         }
	    	    }
	    		
	    		  axios(options).then((res) => {			  
	    			  console.log(res)
		  })
		}
	}
});