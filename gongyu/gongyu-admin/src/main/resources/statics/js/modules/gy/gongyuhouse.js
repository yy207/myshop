$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'gy/gongyuhouse/list',
        datatype: "json",
        colModel: [			
			{ label: '房子名称', name: 'houseName', index: 'house_name', width: 80 }, 			
			{ label: '房子区域', name: 'houseArea', index: 'house_area', width: 80 }, 			
			{ label: '房子附近地铁', name: 'houseMetro', index: 'house_metro', width: 80 }, 
			{ label: '地体站站名', name: 'stationName', index: 'station_name', width: 80 },
			{ label: '房子顾问', name: 'houseCounselor', index: 'house_counselor', width: 80 }, 			
			{ label: '房子价格', name: 'housePrice', index: 'house_price', width: 80 }, 			
			{ label: '房子介绍', name: 'houseDesc', index: 'house_desc', width: 80 }, 			
			{ label: '房子图片', name: 'houseImg', index: 'house_img', width: 80 }, 			
			{ label: '房子户型', name: 'houseType', index: 'house_type', width: 80 },
			{ label: '房子添加时间', name: 'houseTime', index: 'house_time', width: 80 }
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
        	// 隐藏grid底部滚动条
        	$("#jqGrid").closest(".ui-jqgrid-bdiv").css({ "overflow-x" : "hidden" }); 
        }
    });
});

var vm = new Vue({
	el:'#rrapp',
	data:{
		showList: true,
		title: null,
		gongyuHouse: {},
		houseTypeList:[],
		houseAreaList:[],
		houseMetroList:[],
		stationList:[],
		counselorList:[],
		housePriceList:[]
	},
	created:function(){
		this.getHouseArea();
		this.getHouseType();
		this.getCounselor();
		this.getPrice();
	},
	methods: {
		// 价格
		getPrice:function(){
			var that=this;
			$.get(baseURL +'gy/gongyuhouse/listPrice',function(data){
				if(data.list){
					var list=data.list;
					that.housePriceList=list;
				}
			})
		},
		// 顾问
		getCounselor:function(){
			var that=this;
				$.get(baseURL +'gy/user/listCounselor',function(data){
					if(data.list){
						var list=data.list;
						that.counselorList=list;
					}
			})
		},
		// 地铁名字
		getMetroStation:function(areaId,metroId){
			var that=this;
			if(areaId&&metroId){
				$.get(baseURL +'gy/gongyuarea/listMetroStation?areaId='+ areaId +'&metroId='+ metroId,function(data){
					if(data.list){
						var list=data.list;
						that.stationList=list;
					}
			})
			}
			
				
		},
		// 区域下的地铁
		getAreaMetro:function(areaId){
			var that=this;
			if(areaId){
				$.get(baseURL +'gy/gongyuarea/listMetro?areaId='+ areaId,function(data){
					if(data.list){
						var list=data.list;
						that.houseMetroList=list;
					}
			})
			}
		},
		// 房子区域
		getHouseArea:function(){
			var that=this;
				$.get(baseURL +'gy/gongyuarea/listArea',function(data){
					if(data.list){
						var list=data.list;
						that.houseAreaList=list;
					}
			})
		},
		// 房子类型
		getHouseType:function(){
			var that=this;
				$.get(baseURL +'gy/gongyuhouse/listType',function(data){
					if(data.list){
						var list=data.list;
						that.houseTypeList=list;
					}
				})
		},
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.gongyuHouse = {};
		},
		update: function (event) {
			var houseId = getSelectedRow();
			if(houseId == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(houseId)
		},
		saveOrUpdate: function (event) {
			vm.gongyuHouse.houseArea=$('#areaId').find('option[value='+vm.gongyuHouse.areaId+']').text();
			vm.gongyuHouse.houseMetro=$('#metroId').find('option[value='+vm.gongyuHouse.metroId+']').text();
			vm.gongyuHouse.houseCounselor=$('#counselorId').find('option[value='+vm.gongyuHouse.counselorId+']').text();
			$('#btnSaveOrUpdate').button('loading').delay(1000).queue(function() {
                var url = vm.gongyuHouse.houseId == null ? "gy/gongyuhouse/save" : "gy/gongyuhouse/update";
                $.ajax({
                    type: "POST",
                    url: baseURL + url,
                    contentType: "application/json",
                    data: JSON.stringify(vm.gongyuHouse),
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
			var houseIds = getSelectedRows();
			if(houseIds == null){
				return ;
			}
			var lock = false;
            layer.confirm('确定要删除选中的记录？', {
                btn: ['确定','取消'] // 按钮
            }, function(){
               if(!lock) {
                    lock = true;
		            $.ajax({
                        type: "POST",
                        url: baseURL + "gy/gongyuhouse/delete",
                        contentType: "application/json",
                        data: JSON.stringify(houseIds),
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
		getInfo: function(houseId){
			$.get(baseURL + "gy/gongyuhouse/info/"+houseId, function(r){
				if(r.code=='0'){
					vm.getMetroStation(r.gongyuHouse.areaId,r.gongyuHouse.metroId);
	                vm.getAreaMetro(r.gongyuHouse.areaId);
	                setTimeout(function(){
	                	vm.gongyuHouse = r.gongyuHouse;
	                },200)
	                
				}
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