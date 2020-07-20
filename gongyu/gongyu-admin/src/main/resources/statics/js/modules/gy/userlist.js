$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'gy/tbuser/list',
        datatype: "json",
        colModel: [			
			{ label: '序号', name: 'userId', index: 'user_id', width: 50, key: true },
			{ label: '用户头像', name: 'userImg', index: 'user_img', width: 80,formatter:function(row,rows,obj){
				if(row){
					return '<img width="60" height="60" src="'+row+'"/>';
				}else{
					return '暂无图片';
				}
			}}, 			
			{ label: '用户名', name: 'username', index: 'username', width: 80 }, 			
			{ label: '手机号', name: 'mobile', index: 'mobile', width: 80 }, 			
			{ label: '申请顾问', name: 'sqStatus', index: 'sq_status', width: 50,formatter:function(obj){
				if(obj=='1'){
					return '<span class="label label-default">未申请</span>';
				}else if(obj=='2'){
					return '<span class="label label-warning">申请中</span>';
				}else if(obj=='3'){
					return '<span class="label label-success">已申请</span>';
				}
				} }, 			
			{ label: '职位', name: 'position', index: 'position', width: 55,formatter:function(obj){
				if(obj=='1'){
					return '<span class="label label-default">用户</span>';
				}else if(obj=='2'){
					return '<span class="label label-primary">租聘顾问</span>';
				}} }, 			
			{ label: '微信账号', name: 'wechatUsername', index: 'wechat_username', width: 80 }, 			
			{ label: '微信二维码', name: 'wechatImg', index: 'wechat_img', width: 80,formatter:function(row,rows,obj){
				if(row){
					return '<img width="60" height="60" src="'+row+'"/>';
				}else{
					return '暂无图片';
				}
			}}, 			
			{ label: '顾问姓名', name: 'gwName', index: 'gw_name', width: 80 }, 			
			{ label: '身份证号', name: 'identityCardNum', index: 'identity_card_num', width: 80 }, 			
			{ label: '身份证图片正面', name: 'identityCardImgFront', index: 'identity_card_img_front', width: 80 ,formatter:function(row,rows,obj){
				if(row){
					return '<img width="60" height="60" src="'+row+'"/>';
				}else{
					return '暂无图片';
				}
			}}, 			
			{ label: '身份证图片反面', name: 'identityCardImgReverse', index: 'identity_card_img_reverse', width: 80,formatter:function(row,rows,obj){
				if(row){
					return '<img width="60" height="60" src="'+row+'"/>';
				}else{
					return '暂无图片';
				}
			} }, 			
			{ label: '主管区域', name: 'directorOfRegional', index: 'director_of_regional', width: 80 }, 			
			{ label: '补贴金额', name: 'subsidyMoney', index: 'subsidy_money', width: 80 }, 			
			{ label: '分期内容', name: 'installment', index: 'installment', width: 80 }, 			
			{ label: '顾问的保证金', name: 'guaranteeMoney', index: 'guarantee_money', width: 80 }, 			
			{ label: '状态', name: 'status', index: 'status', width:  40,formatter:function(obj){
				if(obj=='1'){
					return '<span class="label label-success">正常</span>';
				}else if(obj=='2'){
					return '<span class="label label-danger">禁用</span>';
				}} },
			{ label: '创建时间', name: 'createTime', index: 'create_time', width: 80 }			
        ],
		viewrecords: true,
        height: 385,
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
		q:{
			mobile: null
        },
		showList: true,
		title: null,
		tbUser: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.tbUser = {};
		},
		update: function (event) {
			var userId = getSelectedRow();
			if(userId == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(userId)
		},
		saveOrUpdate: function (event) {
		    $('#btnSaveOrUpdate').button('loading').delay(1000).queue(function() {
                var url = vm.tbUser.userId == null ? "gy/tbuser/save" : "gy/tbuser/update";
                $.ajax({
                    type: "POST",
                    url: baseURL + url,
                    contentType: "application/json",
                    data: JSON.stringify(vm.tbUser),
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
			var userIds = getSelectedRows();
			if(userIds == null){
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
                        url: baseURL + "gy/tbuser/delete",
                        contentType: "application/json",
                        data: JSON.stringify(userIds),
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
		getInfo: function(userId){
			$.get(baseURL + "gy/tbuser/info/"+userId, function(r){
                vm.tbUser = r.tbUser;
            });
		},
		reload: function (event) {
			vm.showList = true;
			var page = $("#jqGrid").jqGrid('getGridParam','page');
			$("#jqGrid").jqGrid('setGridParam',{ 
				postData:{'mobile': vm.q.mobile},
                page:page
            }).trigger("reloadGrid");
		}
	}
});