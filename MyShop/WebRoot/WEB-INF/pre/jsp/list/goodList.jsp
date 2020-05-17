<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../common/header.jsp"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<div class="col-md-12 col-sm-12 col-xs-12">
	<form id="demo-form2" action="goodlist" method="post"
		data-parsley-validate="" class="form-horizontal form-label-left"
		novalidate="">
		<input type="hidden" id="currentIndex" name="currentIndex"
			value="${pages.currentIndex }">

		<div class="control-label col-md-1 col-sm-1 col-xs-12">
			<select name="pageSize">
				<option value="5"
					<c:if test="${pages.pageSize == 5 }">selected</c:if>>5</option>
				<option value="10"
					<c:if test="${pages.pageSize == 10 }">selected</c:if>>10</option>
				<option value="15"
					<c:if test="${pages.pageSize == 15 }">selected</c:if>>15</option>
			</select> 按条件筛选
		</div>

		<div class="form-group col-md-3 col-sm-3 col-xs-12">
			<label class="control-label col-md-3 col-sm-3 col-xs-12"
				for="shopName"><font style="vertical-align: inherit;">名称</font>
			</label>
			<div class="col-md-6 col-sm-6 col-xs-12">
				<input type="text" id="name" name="name" value="${name }"
					class="form-control col-md-7 col-xs-12">
			</div>
		</div>
		<div class="form-group col-md-2 col-sm-2 col-xs-12">
			<input type="button" class="btn btn-primary btn-reset" value="取消">
			</button>
			<button type="submit" class="btn btn-success">查询</button>
		</div>
		<div class="ln_solid"></div>
	</form>
</div>
<div class="col-md-12 col-sm-12 col-xs-12">
	<div class="x_panel">
		<div class="x_title">
			<ul class="nav navbar-right panel_toolbox">
				<li><a class="collapse-link"><i class="fa fa-chevron-up"></i>
				</a>
				</li>
				<!-- <li><a class="close-link"><i class="fa fa-close"></i> </a></li> -->
			</ul>
			<div class="clearfix"></div>
		</div>

		<div class="x_content">
			<!-- <style>
				div[class='x_content']{ 
				padding:40px; 
				}
			</style> -->
			<div class="table-responsive">
				<table class="table table-striped jambo_table bulk_action">
					<thead>
						<tr class="headings">
							<th class="column-title">商店名称</th>
							<th class="column-title">商品名称</th>
							<th class="column-title">商品价格(￥)</th>
							<th class="column-title">具体描述</th>
							<th class="column-title">库存</th>
							<th class="column-title">当前状态</th>
							<th class="column-title">创建时间</th>
							<th class="column-title no-link last"><span class="nobr">操作</span>
							</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="s" items="${goodList }" varStatus="state">
							<tr class="even pointer">
								<td class=" ">${s.shop.name }</td>
								<td class=" ">${fn:substring(s.name,0,25) }</td>
								<td class=" ">${s.price }</td>
								<td class=" ">${fn:substring(s.describe ,0,25) }</td>
								<td class=" ">${s.repertory }</td>
								<td class=" last "><c:if test="${s.state == 1 }">
										待审核
									</c:if> <c:if test="${s.state == 2 }">
										审核通过
									</c:if> <c:if test="${s.state == 3 }">
										审核失败
									</c:if> <c:if test="${s.state == 4 }">
										已上架
									</c:if> <c:if test="${s.state == 5 }">
										已下架
									</c:if></td>
								<td class="a-right">${s.createTime }</td>
								<td>
									<div class="btn-group">
										<button type="button" class="btn btn-dark">操作</button>
										<button type="button" class="btn btn-dark dropdown-toggle"
											data-toggle="dropdown" aria-expanded="false">
											<span class="caret"></span>
										</button>
										<ul class="dropdown-menu" role="menu" style="min-width:100px;">
											<li><a href="#">查看详细信息</a></li>
											<li><a href="#">修改商品信息</a></li>
											<li><a href="#">编辑商品状态</a></li>
											<li><a href="#">删除商品</a></li>
										</ul>
									</div></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<p style="font-size:25px;">
					<c:out value="${msg }"></c:out>
				</p>
			</div>
			<div class="col-sm-4">
				<c:if test="${pages.pageCount > 1}"> 
					【当前第${pages.currentIndex}页/共${pages.pageCount} 页】
				</c:if>
			</div>
			<div class="col-sm-8">
				<div class="dataTables_paginate paging_simple_numbers"
					id="datatable-responsive_paginate">
					<ul class="pagination">
						<c:if test="${pages.currentIndex > 1}">
							<button class="btn btn-dark paginate_button previous ">
								<a href="javascript:page_nav(document.forms[0],1);"
									aria-controls="datatable-responsive" data-dt-idx="0"
									tabindex="0">首页</a>
							</button>
							<button class="btn btn-dark  paginate_button ">
								<a
									href="javascript:page_nav(document.forms[0],${pages.currentIndex-1});"
									aria-controls="datatable-responsive" data-dt-idx="1"
									tabindex="0">上一页</a>
							</button>
						</c:if>

						<c:if test="${pages.currentIndex < pages.pageCount }">
							<button class="btn btn-dark  paginate_button ">
								<a
									href="javascript:page_nav(document.forms[0],${pages.currentIndex+1 });"
									aria-controls="datatable-responsive" data-dt-idx="1"
									tabindex="0">下一页</a>
							</button>
							<button class="btn btn-dark  paginate_button next">
								<a
									href="javascript:page_nav(document.forms[0],${pages.pageCount});"
									aria-controls="datatable-responsive" data-dt-idx="7"
									tabindex="0">最后一页</a>
							</button>
						</c:if>
						<!-- <button class="btn btn-dark  paginate_button "><a href="#"
								aria-controls="datatable-responsive" data-dt-idx="1"
								tabindex="0">1</a>
							</button> -->
					</ul>
				</div>
			</div>
		</div>
	</div>
</div>
</div>
</div>
<%@ include file="../common/footer.jsp"%>
