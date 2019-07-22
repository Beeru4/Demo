<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<title>电子文档管理系统</title>
<style type="text/css">
	*{
		margin: 0;
	}
	.container {
		width: 80%;
		margin: 0 auto;
	}
	.content {
		border: 1px solid black;
	}
	.pager{
		width: 900px;
		margin: 0 auto;
		text-align: center;
	}
</style>
</head>
<body>
	<div class="container">
		<h1 style="color: red; text-align: center;">电子文档列表</h1>
		<div class="content">
			<form action="${pageContext.request.contextPath }/listEdocEntry" method="post">
				文档分类:&nbsp;
				<select name="categoryId">
				<c:forEach items="${edocCategorys }" var="category">
					<option value="${category.id }" <c:if test="${category.id == categoryId  }"> selected="selected"</c:if>>${category.name }</option>
				</c:forEach>
				</select>
				<input type="submit" value="查询">
			</form>
			<button style="text-align: right;" id="add">新增电子文档</button>
			<table border="1" width="900px" style="margin: 0 auto;">
				<tr style="background-color: orange;">
					<td>文档编号</td>
					<td>文档名称</td>
					<td>文档摘要</td>
					<td>上传人</td>
					<td>上传时间</td>
					<td>操作</td>
				</tr>
				<c:forEach items="${edocEntryPager.datas }" var="entry" varStatus="status">
					<tr <c:if test="${status.index % 2 != 0 }">style="background-color: #ccc;"</c:if>>
					<td>${entry.id }</td>
					<td>${entry.title}</td>
					<td>${entry.summary == '' ? "(暂未填写文档摘要)":entry.summary }</td>
					<td>${entry.uploaduser == '' ? "(暂未填写上传人)":entry.uploaduser  }</td>
					<td><fmt:formatDate value="${entry.createdate }" pattern="yyyy-MM-dd"/></td>
					<td>
						<a href="${pageContext.request.contextPath }/toModifyEdocEntry?id=${entry.id }">修改</a>
						<a href="javascript:void(0);" onclick="del(${entry.id })">删除</a>
					</td>
				</tr>
				</c:forEach>
			</table>
			<div class="pager">
				<span style="display: none;" id="basePath">${pageContext.request.contextPath }</span>
				<a href="${pageContext.request.contextPath }/listEdocEntry?currPageNo=1">首页</a> 
				<a href="${pageContext.request.contextPath }/listEdocEntry?currPageNo=${edocEntryPager.currPageNo - 1 <= 0 ? 1:edocEntryPager.currPageNo - 1 }">上一页</a>
				<a href="${pageContext.request.contextPath }/listEdocEntry?currPageNo=${edocEntryPager.currPageNo + 1 > edocEntryPager.totalPager ? edocEntryPager.currPageNo:edocEntryPager.currPageNo + 1 }">下一页</a>
				<a href="${pageContext.request.contextPath }/listEdocEntry?currPageNo=${edocEntryPager.totalPager}">末页</a>
				<span>第${edocEntryPager.currPageNo }页/</span> <span>共${edocEntryPager.totalPager }页</span>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.12.4.js"></script>
	<script type="text/javascript">
		function del(id){
			if(null != id && undefined != id){
				if(confirm("确定要删除该条数据吗?")){
					// 使用ajax删除
					$.ajax({
						url:$("#basePath").text().trim()+"/delEdocEntry",
						data:{edocEntryId:id},
						type:"POST",
						dataType:"json",
						async:false,
						success:function(data){
							console.log(data);
							if(data.code == 200){
								// 删除成功
								alert("删除成功!");
								// 刷新页面
								window.location.reload();
							}else{
								// 删除失败
								alert("删除失败!");
							}
						}
					})
				}
			}
		}
		$("#add").click(function(){
			window.location.href=$("#basePath").text().trim()+"/toAddEdocEntry";
		});
	</script>
</body>
</html>
