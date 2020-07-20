$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'gy/gongyuhouseimg/list',
        datatype: "json",
        colModel: [			
			{ label: '房子名字', name: 'houseName', index: 'house_name', width: 80 }, 
			{ label: '类型', name: 'ident', index: 'ident', width: 80 }, 
			{ label: '房子图片', name: 'houseImger', index: 'house_imger', width: 80,formatter:function(row,rows,obj){
				if(row){
					if(obj.ident=='1'){
						return '<img width="60" height="60" src="'+row+'"/>';
					}else if(obj.ident=='2'){
						return '<video src="'+row+'" width="60" height="60"></video>'
					}
				}else{
					return '暂无图片';
				}
			}}			
        ],
		viewrecords: true,
        height: 500,
        rowNum: 10,
		rowList : [10,30,50],
        rownumbers: true, 
        rownumWidth: 25, 
        autowidth:true,
        multiselect: true,
        pager: "#jqGridPager",
        jsonReader : {
            root: "page.list",
            page: "page.currPage",
            total: "page.totalPage",
            records: "page.totalCount"
        },
        prmNames : {
            page:"page", 
            rows:"limit", 
            order: "order"
        },
        gridComplete:function(){
        	//隐藏grid底部滚动条
        	$("#jqGrid").closest(".ui-jqgrid-bdiv").css({ "overflow-x" : "hidden" }); 
        }
    });
});

var vm = new Vue({
	el:'#rrapp',
	data:{
		showList: true,
		title: null,
		file:null,
		srcimg:'',
		itype:'',
		gongyuHouseImg: {},
		houseImgList:[]
	},
	created:function(){
		this.gethouseImg();
	},
	methods: {
		getFile(event) {
			  this.file = event.target.files[0];
			  var itypeArr= (this.file.name).split('.');
			  var itype= itypeArr[itypeArr.length-1];
			  if(this.file.type.indexOf('image')!='-1'){// 上传图片
				  vm.itype=1;
				  this.shangchuan();
			  }else if(this.file.type.indexOf('video')!='-1'){// 上传视频
				  vm.itype=2;
				  this.shangchuan();
			  }else{
				  layer.msg('文件上传格式不对！')
			  }
		},
		shangchuan:function(){
			var formData = new window.FormData();
	    	formData.append('file', this.file) // 'file' 这个名字要和后台获取文件的名字一样;
	    	var options = {  // 设置axios的参数
	    	         url: baseURL+'qny/test/uploading',
	    	         data: formData,
	    	         method: 'post',
	    	         headers: { 
	    	          'Content-Type': 'multipart/form-data'
	    	         }
	    	    }
	    		  axios(options).then((res) => {	
	    			  if(res.data){
	    				  vm.srcimg=res.data.url;
	    				  vm.gongyuHouseImg.houseImger=res.data.url;
	    			  }
	    		  })
		},
		gethouseImg:function(){
			var that=this;
			$.get(baseURL +'gy/gongyuhouse/list',function(data){
				if(data.page.list){
					var list=data.page.list;
					that.houseImgList=list;
				}
			})
		},
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.gongyuHouseImg = {};
		},
		update: function (event) {
			var id = getSelectedRow();
			if(id == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            vm.getInfo(id)
		},
		saveOrUpdate: function (event) {
			vm.gongyuHouseImg.houseName=$('#houseId').find('option[value='+vm.gongyuHouseImg.houseId+']').text();
		    $('#btnSaveOrUpdate').button('loading').delay(1000).queue(function() {
                var url = vm.gongyuHouseImg.id == null ? "gy/gongyuhouseimg/save" : "gy/gongyuhouseimg/update";
                $.ajax({
                    type: "POST",
                    url: baseURL + url,
                    contentType: "application/json",
                    data: JSON.stringify(vm.gongyuHouseImg),
                    success: function(r){
                        if(r.code === 0){
                             layer.msg("操作成功", {icon: 1});
                             vm.reload();
                             $('#btnSaveOrUpdate').button('reset');
                             $('#btnSaveOrUpdate').dequeue();
                        }else{
                            layer.alert(r.msg);
                            $('#btnSaveOrUpdate').button('reset');
                            $('#btnSaveOrUpdate').dequeue();
                        }
                    }
                });
			});
		},
		del: function (event) {
			var ids = getSelectedRows();
			if(ids == null){
				return ;
			}
			var lock = false;
            layer.confirm('确定要删除选中的记录？', {
                btn: ['确定','取消'] //按钮
            }, function(){
               if(!lock) {
                    lock = true;
		            $.ajax({
                        type: "POST",
                        url: baseURL + "gy/gongyuhouseimg/delete",
                        contentType: "application/json",
                        data: JSON.stringify(ids),
                        success: function(r){
                            if(r.code == 0){
                                layer.msg("操作成功", {icon: 1});
                                $("#jqGrid").trigger("reloadGrid");
                            }else{
                                layer.alert(r.msg);
                            }
                        }
				    });
			    }
             }, function(){
             });
		},
		getInfo: function(id){
			$.get(baseURL + "gy/gongyuhouseimg/info/"+id, function(r){
                vm.gongyuHouseImg = r.gongyuHouseImg;
                vm.srcimg = r.gongyuHouseImg.houseImger;
            });
		},
		reload: function (event) {
			vm.showList = true;
			var page = $("#jqGrid").jqGrid('getGridParam','page');
			$("#jqGrid").jqGrid('setGridParam',{ 
                page:page
            }).trigger("reloadGrid");
		}
	}
});