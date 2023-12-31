<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>

<c:url var="categoryAPI" value="/api/admin/category" />
<c:url var="categoryUrl" value="/admin/category/list" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Category Management</title>
</head>
<body>
	<div class="container">
		<c:if test="${not empty message}">
			<div class="alert alert-${alert}">
						${message}
			</div>
		</c:if>
		<div class="d-flex justify-content-end pb-3">
			<a href="<c:url value='/admin/category/edit'/>" class="btn btn-success mr-2" data-toggle="tooltip" title="Add new category"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
			<button id="btnDelete" type="button" class="btn btn-danger" data-toggle="tooltip" title="Delete categories">
				<i class="fa fa-trash" aria-hidden="true"></i>
			</button>
		</div>
		<table class="table mb-5">
			<thead>
				<tr>
					<th scope="col">
						<div class="form-check">
							  <input class="form-check-input position-static" type="checkbox" id="checkAll">
						</div>
					</th>
					<th scope="col">Code</th>
					<th scope="col">Name</th>
					<th scope="col">Update By</th>
					<th scope="col">Update At</th>
					<th scope="col">Action</th>
				</tr>
			</thead>
			<tbody>
				<c:if test="${not empty model.listResult}">
					<c:forEach items="${model.listResult}" var="item">
						<tr>
							<th class="align-bottom" scope="row">
								<div class="form-check">
								  <input class="form-check-input position-static" type="checkbox" value="${item.id}" id="id_${item.id}">
								</div>
							</th>
							<td  class="align-bottom">${item.code}</td>
							<td  class="align-bottom">${item.name}</td>
							<td  class="align-bottom">${item.updatedBy}</td>
							<td  class="align-bottom">${item.updatedAt}</td>
							<td>
								<c:url var="editURL" value="/admin/category/edit">
									<c:param name="id" value="${item.id}" />
								</c:url>
								<a href="${editURL}" class="btn btn-info" data-toggle="tooltip" title="Update category">
								<i class="fas fa-edit"></i>
								</a>
							</td>
						</tr>
					</c:forEach>
				</c:if>
			</tbody>
		</table>

		<div class="row">
			<div class="col-12">
				<div id="pagination" class="text-center"></div>
			</div>
		</div>
		<form action="<c:url value='/admin/category/list'/>" id="formSubmit"
			method="GET">
			<input type="hidden" name="page" value="" id="page">
			<input type="hidden" name="limit" value="" id="limit">
		</form>
	</div>
	<script>
		var totalPages = ${model.totalPage};
		var currentPage = ${model.page};

		$(document).ready(function() {
			var pag = $('#pagination').simplePaginator({
				totalPages : totalPages,
				maxButtonsVisible : 3,
				currentPage : currentPage,
				pageChange : function(page) {
					if (currentPage != page) {
						$("#page").val(page);
						$('#limit').val(2);
						$("#formSubmit").submit();
					}
				}
			});
			$('#changeTotalPages').click(function() {
				pag.simplePaginator('setTotalPages', 10);
			})

			$('#changePage').click(function() {
				pag.simplePaginator('changePage', 3);
			})

			$('#hide').click(function() {
				pag.simplePaginator('hide');
			})
		});
		
		
		// handle delete category
		function handleCallAPI(e,method) {
			e.preventDefault();
			var formData = $("tbody input[type=checkbox]:checked").map(function(){
				return $(this).val();
			}).get();
			
			$.ajax({
				url : '${categoryAPI}',
				type : method,	
				contentType: "application/json",
				data : JSON.stringify(formData),
				dataType : "json",
				success : function(result) {
					window.location.href = "${categoryUrl}?page=1&limit=2&message=delete_success";
				},
				error : function(err) {
					window.location.href = "${categoryUrl}?page=1&limit=2&message=error_system";
				}
			});
			
		}
		$("#btnDelete").click(function(e) {
			handleCallAPI(e,"DELETE");
		});
		$("#checkAll").change(function(){
			if(this.checked){
				$("tbody input[type=checkbox]").map(function(){
					$(this).attr("checked", true);
				});
			}else{
				$("tbody input[type=checkbox]").map(function(){
					$(this).attr("checked", false);
				});
			}
		});
	</script>

</body>
</html>