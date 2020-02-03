<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="layoutin.jsp" />
	<div id="homepage">
	  <div id="row-1" class="">
		<div id="col-1">
		  <div id="map">
			<h1><span class="blue">Hospital</span> Map</h1>
			<div id="map-container">

			</div>
		  </div>
		  <div id="entity-info">
			<h1><span class="purple">Entity</span> Info</h1>
		  </div>
		</div>
		<div id="entities">
		  <h1><span class="green">Active</span> Entities <small>(X)</small></h1>
		  <div class="entity-container">

		  </div>
		</div>
	  </div>

	</div>
<jsp:include page="layoutout.jsp" />
