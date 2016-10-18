<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Staffs List</title>

<script type="text/javascript" charset="UTF-8"
	src="//code.jquery.com/jquery-1.12.3.min.js"></script>
<script type="text/javascript" charset="UTF-8"
	src="//cdn.datatables.net/1.10.12/js/jquery.dataTables.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="//cdn.datatables.net/1.10.12/css/jquery.dataTables.min.css">
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script type="text/javascript"
	src="<c:url value="/resources/js/index.js" />"></script>
<link href="<c:url value="/resources/css/index.css" />" rel="stylesheet">


</head>
<body>
	<div class='container'>
		<div align="center"
			style="font-family: vffree14; color: #006600; font-size: 80px">
			Staffs Client-side <br>
		</div>

		<div class="select-to-display">
			<div id='header_bar' align='center'>
				<br> <br>
				<form method="get" id="form_select">
					Department <select class="department">
						<option value="" selected>All</option>
						<c:forEach var="department" items="${departments}"
							varStatus="status">
							<option value='${department.id}'>${department.name}</option>
						</c:forEach>
					</select> Position <select class="position">
						<option value="0" selected>All</option>
						<option value="1">Director</option>
						<option value="2">Leader and Manager</option>
						<option value="3">Formal staff</option>
					</select> Certificate <select class="cert">
						<c:forEach var="cert" items="${certs}" varStatus="status">
							<%-- <c:if test="${cert.name != 'multiple'}"> --%>
							<option value='${cert.id}'>${cert.name}</option>
							<%-- </c:if> --%>
						</c:forEach>
						<option value="-1">Any certificate</option>
					</select> Salary <select class="salary">
						<option value=""></option>
						<c:forEach var="month" items="${months}" varStatus="status">
							<option value='${month}'>${month}</option>
						</c:forEach>
					</select> <input id='login' type="submit" value="Search" name="commit"
						style="font-weight: bold;" />
				</form>
			</div>

			<div id='table_div'>
				<table id='table' class='table'>
					<thead>
						<tr class='table_head' style='text-weight: bold;'>
							<th></th>
							<th style="display: none;">ID</th>
							<th>Department</th>
							<th>Staff</th>
							<th>Position</th>
							<th>Certificate</th>
							<th style="display: none;" class='hidden_column'>Salary</th>
						</tr>
					</thead>
					<tbody class='table_body'>
						<c:forEach var='staff' items='${staffs}' varStatus='status'>
							<tr>
								<td>${status.index +1}</td>
								<td class='id' style="display: none;">${staff.id}</td>
								<td>${staff.dept.name}</td>
								<td data-toggle="modal" data-target="#myModal_1" class="detail"
									style='cursor: pointer;'
									title="click name here to view info staff">${staff.name}</td>
								<td>${staff.position.position}</td>
								<td class='info' title="${staff.listStaffCert.cert_name.info}">${staff.listStaffCert.cert_name.name}</td>
								<td class='hidden_column' style="display: none;">${staff.salary.month1}</td>

							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>

		<div class="modal fade" id="myModal_1" role="dialog">
			<div class="modal-dialog modal-sm">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h2 class="modal-title"></h2>
					</div>
					<div class="modal-body" style="background: #d9edf7;"></div>
					<div class="modal-footer" style="background: #d9edf7;"></div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>