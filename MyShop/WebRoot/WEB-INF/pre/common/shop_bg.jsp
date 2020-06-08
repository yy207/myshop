<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div class="bg">
			<div class="mid">
				<div class="sale">
					卖家工作台
				</div>
				<div class="info">
					<div class="img">
						<c:if test="${sressionUserr.shop != null }">
							<img src="${pageContext.request.contextPath }/static/img/${shop.picPath}" width="35" height="35" />
						</c:if>
						
					</div>
					<div class="name">
						<c:if test="${sressionUserr.shop != null  }">shop.shopName</c:if>
					</div>
				</div>
			</div>
		</div>		