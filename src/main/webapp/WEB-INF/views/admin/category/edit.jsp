<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>

<c:url var="categoryAPI" value="/api/admin/category" />
<c:url var="categoryUrl" value="/admin/category/list" />
<c:url var="editCategoryUrl" value="/admin/category/edit" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit</title>

</head>
<body>
	<section class="container">
		<c:if test="${not empty message}">
			<div class="alert alert-${alert}">${message}</div>
		</c:if>
		<form:form id="formSubmit" modelAttribute="model">
			<div class="form-group">
				<label for="inputCode">Category Code</label>
				<form:input path="code" type="text" name="code" class="form-control"
					id="inputCode" placeholder="Enter code" />
			</div>
			<div class="form-group">
				<label for="inputName">Category Name</label>
				<form:input path="name" type="text" name="name" class="form-control"
					id="inputName" placeholder="Enter name" />
			</div>
			<form:hidden path="id" id="id" />
			<c:if test="${not empty model.id}">
				<button id="btnUpdate" type="submit" class="btn btn-primary">Update</button>
			</c:if>
			<c:if test="${empty model.id}">
				<button id="btnAdd" type="submit" class="btn btn-primary">Add</button>
			</c:if>
		</form:form>
	</section>

	<script type="text/javascript">
		function handleCallAPI(e, method) {
			e.preventDefault();
			var formData = $("#formSubmit").serializeArray();

			var data = {};
			$.each(formData, function(index, item) {
				data[item.name] = item.value;
			})

			$
					.ajax({
						url : '${categoryAPI}',
						type : method,
						contentType : "application/json",
						data : JSON.stringify(data),
						dataType : "json",
						success : function(result) {
							if (method === "POST") {
								window.location.href = "${editCategoryURL}?id="
										+ result.id + "&message=insert_success";
							} else if (method === "PUT") {
								window.location.href = "${editCategoryURL}?id="
										+ result.id + "&message=update_success";
							}
						},
						error : function(err) {
							if (method === "POST") {
								window.location.href = "${categoryURL}?page=1&limit=2&message=error_system";
							} else if (method === "PUT") {
								window.location.href = "${editCategoryURL}?id="
										+ result.id + "&message=error_system";
							}
						}
					});

		}

		$("#btnAdd").click(function(e) {
			handleCallAPI(e, "POST");
		});
		$("#btnUpdate").click(function(e) {
			handleCallAPI(e, "PUT");
		});
	</script>
</body>
</html>