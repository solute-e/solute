<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<div class="row-fluid">
	<div class="span3">
		<tiles:insertAttribute name="body_side_l" />
	</div>
	<div class="span6">
		<div class="row-fluid s-body">
			<div class="span1">
				asd
			</div>
			<div class="span10">
				<div class="s-body-inner">
					<div class="row-fluid"> <!-- menu -->
						<tiles:insertAttribute name="body.menu" />
					</div>
					<div class="row-fluid s-main">
						<div>
							<%-- <tiles:insertAttribute name="body.main" /> --%>
						</div>
					</div>
				</div>
			</div>
			<div class="span1">
				asd
			</div>
		</div>
	</div>
	<div class="span3">
		<tiles:insertAttribute name="body_side_r" />
	</div>
</div>
