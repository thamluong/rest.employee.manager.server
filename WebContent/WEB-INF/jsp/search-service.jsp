<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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

					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>