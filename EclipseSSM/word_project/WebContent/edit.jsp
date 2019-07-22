<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>编辑电子文档</title>
</head>
<body>
	<c:if test="${edocEntry.id != null }"><h1>更新电子文档</h1></c:if>
	<c:if test="${edocEntry.id == null }"><h1>增加电子文档</h1></c:if>
	<span style="display: none;" id="basePath">${pageContext.request.contextPath }</span>
	<c:if test="${edocEntry.id != null }"><form  method="post" action="${pageContext.request.contextPath }/doModifyEdocEntry"></c:if>
	<c:if test="${edocEntry.id == null }"><form  method="post" action="${pageContext.request.contextPath }/doAddEdocEntry"></c:if>
		<table border="1">
			<tr <c:if test="${edocEntry.id == null }">style="display: none;"</c:if>>
				<td>文档编号</td>
				<td><input  type="hidden" name="id" value="${edocEntry.id }" />${edocEntry.id }</td>
			</tr>
			<tr>
				<td>文档分类<span style="color:red;">(*)</span></td>
				<td>
					<select name="categoryId">
					<c:forEach items="${edocCategorys }" var="category">
						<option value="${category.id }" <c:if test="${category.id == edocEntry.categoryId  }"> selected="selected"</c:if>>${category.name }</option>
					</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td>文档名称<span style="color:red;">(*)</span></td>
				<td><input  type="text" name="title" value="${edocEntry.title }"/></td>
			</tr>
			<tr>
				<td>文档摘要</td>
				<td><textarea rows="" cols="" name="summary">${edocEntry.summary }</textarea></td>
			</tr>
			<tr>
				<td>上传人</td>
				<td><input  type="text" name="uploaduser" value="${edocEntry.uploaduser }"/></td>
			</tr>
			<tr>
				<td>上传时间<span style="color:red;">(*)</span></td>
				<td><input  type="text" name="createdate" value="<fmt:formatDate value="${edocEntry.createdate }" pattern="yyyy-MM-dd"/>"/>(yyyy-MM-dd)</td>
			</tr>
			<tr>
				<td>
					<input type="submit" value="提交"/>
					<input type="button" value="返回" id="back"/>
				</td>
			</tr>
		</table>
	</form>
</body>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.12.4.js"></script>
<script type="text/javascript">
	$(function(){
		$("form").submit(function(){
			var dateReg = /^\d{4}-\d{2}-\d{2}$/;
			if($('[name="title"]').val().trim() == ''){
				alert("文档名称不能为空!");
				return false;
			}else if($('[name="createdate"]').val().trim() == ''){
				alert("上传时间不能为空不能为空!");
				return false;
			}else if(!dateReg.test($('[name="createdate"]').val().trim())){
				alert("上传时间格式不正确!");
				return false;
			}
			return true;
		});
		
		// 返回
		$("#back").click(function(){
			window.location.href=$("#basePath").text().trim()+"/listEdocEntry";
		});
	})

</script>
</html>
