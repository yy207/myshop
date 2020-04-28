<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../common/top.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  
    <!--Begin 用户中心 Begin -->
	<div class="m_content">
		<%@ include file="../common/nav.jsp"%>  
		<div class="m_right">
            <p></p>
            <div class="mem_tit">收货地址</div>
			<div class="address"> 
            	<table border="0" class="add_t" align="center" style="width:98%; margin:10px auto;" cellspacing="0" cellpadding="0">
                  
              <tr>                                                                                                                                                    
                <td width="15%">收货人姓名</td>
                <td width="25%">地址</td>
                <td width="15%">电话</td>
                <td width="15%">是否为默认</td>
                <td width="20%">操作</td>
              </tr>
                  <c:forEach items="${addressList }" var="adr">
              	 <tr>
	                <td><font>${adr.name } </font></td>
	                <td>${adr.address }</td>
	                <td>${adr.phone }</td>
	                <td>
						 <c:if test="${adr.isDefault==0 }">否</c:if>
						 <c:if test="${adr.isDefault==1 }">是</c:if>
					</td> 
					<td>
						<a href="#" style="color:#ff4e00;">设为默认</a>&nbsp; &nbsp; &nbsp; &nbsp; 
						<a href="#" style="color:#ff4e00;">编辑</a>&nbsp; &nbsp; &nbsp; &nbsp; 
					</td>
	              </tr>
              </c:forEach>
              
                </table> 
            </div>

            <div class="mem_tit">
            	<a href="#"><img src="images/add_ad.gif" /></a>
            </div>
            <table border="0" class="add_tab" style="width:930px;"  cellspacing="0" cellpadding="0">
              <tr>
                <td width="135" align="right">配送地区</td>
                <td colspan="3" style="font-family:'宋体';">
                	<select class="jj" name="country" style="background-color:#f6f6f6;">
                      <option value="0" selected="selected">请选择...</option>
                      <option value="1">中国</option>
                      <option value="2">中国</option>
                      <option value="3">中国</option>
                      <option value="4">中国</option>
                    </select>
                	<select class="jj" name="province">
                      <option value="0" selected="selected">请选择...</option>
                      <option value="1">四川</option>
                      <option value="2">重庆</option>
                      <option value="3">北京</option>
                      <option value="4">云南</option>
                    </select>
                    <select class="jj" name="city">
                      <option value="0" selected="selected">请选择...</option>
                      <option value="1">成都</option>
                      <option value="2">宜宾</option>
                      <option value="3">南充</option>
                      <option value="4">绵阳</option>
                    </select>
                    <select class="jj" name="area">
                      <option value="0" selected="selected">请选择...</option>
                      <option value="1">武侯区</option>
                      <option value="2">成华区</option>
                      <option value="3">锦江区</option>
                      <option value="4">青羊区</option>
                    </select>
                    （必填）
                </td>
              </tr>
              <tr>
                <td align="right">收货人姓名</td>
                <td style="font-family:'宋体';"><input type="text" value="姓名" class="add_ipt" />（必填）</td>
                <td align="right">电子邮箱</td>
                <td style="font-family:'宋体';"><input type="text" value="12345678@qq.com" class="add_ipt" />（必填）</td>
              </tr>
              <tr>
                <td align="right">详细地址</td>
                <td style="font-family:'宋体';"><input type="text" value="世外桃源" class="add_ipt" />（必填）</td>
                <td align="right">邮政编码</td>
                <td style="font-family:'宋体';"><input type="text" value="610000" class="add_ipt" /></td>
              </tr>
              <tr>
                <td align="right">手机</td>
                <td style="font-family:'宋体';"><input type="text" value="1361234587" class="add_ipt" />（必填）</td>
                <td align="right">电话</td>
                <td style="font-family:'宋体';"><input type="text" value="028-12345678" class="add_ipt" /></td>
              </tr>
              <tr>
                <td align="right">标志建筑</td>
                <td style="font-family:'宋体';"><input type="text" value="世外桃源大酒店" class="add_ipt" /></td>
                <td align="right">最佳送货时间</td>
                <td style="font-family:'宋体';"><input type="text" value="" class="add_ipt" /></td>
              </tr>
            </table>
           	<p align="right">
            	<a href="#">删除</a>&nbsp; &nbsp; <a href="#" class="add_b">确认修改</a>
            </p> 
        </div>
    </div>
	<!--End 用户中心 End--> 


<%@ include file="../common/footer.jsp" %>
