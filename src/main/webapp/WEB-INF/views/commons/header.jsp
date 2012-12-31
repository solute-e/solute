<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<style>
<!--
.uploadMenu {
	position: absolute;
	top: 4em;
	left: 90%;
	width: 150px;
	height: 100px;
}

.uploadFile {
	position: absolute;
	top: 4em;
	left: 1245px;
	width: 300px;
	height: 100px;
}

.images {
	height: 75px;
	width: 75px;
	border: 0px;
	margin: 15px 15px 0 0;
}
-->
</style>

<script type="text/javascript">
	function addFiles(files, name, fd) {
		if (files != undefined) {
			for ( var i in files) {
				var f = files[i];
				fd.append(name, f);
			}
		}
	}
	$(function() {

		$("#historyBtn").button({
			icons : {
				primary : "ui-icon-person"
			},
			text : false
		});

		$("#myPageBtn").button().click(function() {
			/* mypage 이동 */
			window.location.href = "${webappRoot}/main/mypage";
		});

		$("#uploadBtn").button({
			icons : {
				primary : "ui-icon-disk"
			},
			text : false
		}).click(function() {
			var enabled = jQuery.data(this, "enabled");
			var $uploadMenu = $('#uploadMenu').show();

			if (enabled == undefined || enabled == true) {
				$uploadMenu.show();
				enabled = false;
			} else if (enabled == false) {
				$uploadMenu.hide();
				enabled = true;
			}
			jQuery.data(this, "enabled", enabled);
		});

		$("#cartBtn").button({
			icons : {
				primary : "ui-icon-cart"
			},
			text : false
		});

		$("#addFriendBtn").button({
			icons : {
				primary : 'ui-icon-unlocked'
			},
			text : false
		});

		$("#browse").button({
			icons : {
				primary : 'ui-icon-circle-triangle-s'
			},
			text : false
		}).click(function() {
			$("#file").click().change(function() {
				var str = $(this).val();
				$("#file_text").val(str);
			});

		});

		$("#uploadMenu").hide();
		$("#uploadFullFile").click(function() {
			$("#uploadMenu").hide();
			$("#uploadFile").show();
		});
		$("#uploadOneProblem").click(function() {
			$("#uploadMenu").hide();
			$("#uploadProblem").dialog('open');
		});

		$("#uploadFile").hide();
		$("#uploadProblem").hide();

		$("#upload").button().click(function() {

		});

		$("#uploadProblem").dialog({
			autoOpen : false,
			modal : true,
			resizable : false,
			width : "1024px",
			title : "한 문제 올리기",
			open : function() {
				$(this).find('textarea').text('');
				$(this).find('input').val('');
				$(this).find('output').html('');
				$(this).find('pre').text('');
			}
		}).find('button[name="uploadBtn"]').button().click(
				function() {
					var $this = $(this);
					var $dlg = $("#uploadProblem");
					/* upload ajax */
					var fd = new FormData();

					fd.append("source", $dlg.find("input#source").val());
					fd.append("answer", $dlg.find("input#answer").val());
					addFiles($dlg.find("output#problemThumbs").data('images'), "problemImageFiles", fd);
					addFiles($dlg.find("output#solutionThumbs").data('images'), "solutionImageFiles", fd);
					fd.append("problem", $dlg.find("pre#problem").text());
					fd.append("solution", $dlg.find("pre#solution").text());

					var $tagText = $dlg.find("textarea#tagList").text();
					var tags = $tagText.split('\n');
					for ( var i in tags) {
						fd.append("tags", tags[i]);
					}

					$.ajax({
						url : "${webappRoot}/header/uploadOneProblem",
						type : "post",
						contentType : false,
						processData : false,
						data : fd,
						beforeSend : function() {
							$this.data('buttonLabel', $this.button('label'));
							$this.button('label', '처리중...').button('disable');
							$dlg.dialog('disable');
						},
						success : function() {
							$this.button('label', $this.data('buttonLabel'))
									.button('enable');
							$dlg.dialog('enable').dialog('close');
						},
						error : function() {
							msgbox("Error!", "잘못 처리되었습니다.\n다시 입력해주십시오.");
							$this.button('label', $this.data('buttonLabel'))
									.button('enable');
							$dlg.dialog('enable').dialog('close');
						}
					});
				});

		$("#uploadProblem")
				.find('button[name="inputBtn"]')
				.button()
				.click(
						function() {
							$("<div></div>")
									.html(
											"<label>원하는 Tag를 입력하십시오.</label><input type='text' size='25' value='' />")
									.dialog(
											{
												modal : true,
												resizable : false,
												title : "Tag 입력",
												width : "250px",
												close : function() {
													$(this).remove();
												},
												buttons : {
													"OK" : function() {
														var val = $(this)
																.find(
																		"input[type='text']")
																.val();
														var $textarea = $("#uploadProblem textarea#tagList");
														var $editingData = $textarea
																.data('editing');
														if ($editingData == undefined
																|| $editingData == false) {
															$textarea.data(
																	'editing',
																	true);
															$textarea.text(val);
														} else {
															$textarea
																	.text([
																			$textarea
																					.text(),
																			"\n",
																			val ]
																			.join(''));
														}

														$(this).dialog('close');
													}
												}
											});
						});

	});

	function imagesSelected(myFiles, id) {
		for ( var i = 0, f; f = myFiles[i]; i++) {

			if (!f.type.match('image.*')) {
				alert("이미지 파일만 드래그 가능(only image file)");
				continue;
			}

			var imageReader = new FileReader();
			imageReader.onload = (function(aFile) {
				return function(e) {
					var span = document.createElement('span');

					span.innerHTML = [ '<img class="images" src="', e.target.result,'" title="', aFile.name, '"/>' ]
							.join('');
					document.getElementById(id).insertBefore(span, null);
				};
			})(f);
			imageReader.readAsDataURL(f);

			$id = $("#" + id);
			$images = $id.data('images');
			if ($images == undefined) {
				$id.data('images', [ f ]);
			} else {
				$images.push(f);
			}
		}
	}

	function dropIt(e, id) {
		imagesSelected(e.dataTransfer.files, id);
		e.stopPropagation();
		e.preventDefault();
	}
</script>

<%-- Hidden Field --%>
<input type="file" id="file" value=""
	style="visibility: hidden; position: absolute; top: -50; left: -50;" />

<%-- Main Contacts --%>
<div align="center">
	<div style="width: 100%; background-color: blue;">
		<div id="menuButtons" align="right">
			<table border="1" style="border-style: none; border-color: white;">
				<tr>
					<td style="border-style: solid;">
						<table style="border-style: none; border-width: 0;">
							<tr>
								<td>
									<button id="historyBtn" style="height: 2.2em;"></button>
								</td>
								<td>
									<button id="myPageBtn">
										<font color="#888888">${user.email}</font>
									</button>
								</td>
							</tr>
						</table>
					</td>
					<td style="border-style: solid;">
						<button id="uploadBtn" style="height: 2.2em;"></button> <%-- 문제업로드 버튼 --%>
					</td>
					<td style="border-style: solid;">
						<button id="cartBtn" style="height: 2.2em;"></button> <%-- 바구니 버튼 --%>
					</td>
					<td style="border-style: solid;">
						<button id="addFriendBtn" style="height: 2.2em;"></button> <%-- 친구 추가 버튼 --%>
					</td>
				</tr>
			</table>
		</div>
	</div>

	<div class="uploadMenu">
		<div id="uploadMenu" class="ui-widget-content ui-corner-all"
			align="left">
			<ul style="margin-left: -30px;">
				<li style="list-style-type: none;"><a id="uploadFullFile"
					href="#">파일로 통째 올리기</a></li>
				<li style="list-style-type: none;"><a id="uploadOneProblem"
					href="#">한 문제 올리기</a></li>
			</ul>
		</div>
	</div>

	<div class="uploadFile">
		<div id="uploadFile" class="ui-widget-content ui-corner-all">
			<h3 style="margin-top: 2px; margin-left: 2px; margin-right: 2px;"
				class="ui-widget-header ui-corner-all">파일로 통째 올리기</h3>
			<table style="border: 0 0 0 0;">
				<tr>
					<td style="padding: 0 0 0 0"><input type="text" id="file_text"
						size="35" /></td>
					<td style="padding: 0 0 0 0">
						<button id="browse" style="height: 23px;"></button>
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<button id="upload">Upload</button>
					</td>
				</tr>
			</table>
		</div>
	</div>

	<div id="uploadProblem">
		<table>
			<tr>
				<td>
					<table border="1"
						style="border: none; border-top: solid blue; border-left: solid blue; border-right: solid blue; border-bottom: solid blue;">
						<tr>
							<td style="border: none;"><input id="source" type="text"
								size="60px" /></td>
							<td style="border: none;"><input id="answer" type="text"
								size="60px" /></td>
						</tr>
						<tr>
							<td height="560px" style="background-color: white; border: none;">
								<pre id="problem" width="100%"
									style="border: solid; border-width: 1px; height: 345px; word-break: break-all; white-space: pre-line;"
									contenteditable="true"></pre>
								<table
									style="border-color: #e6e6e6; border-style: solid; width: 100%;">
									<tr bgcolor="#F2F2F2">
										<td>
											<p>Image List(Drag &amp; drop-only Image)</p>
										</td>
									</tr>
									<tr>
										<td align="left" height="115px" ondragenter="return false"
											ondragover="return false"
											ondrop="dropIt(event, 'problemThumbs')"><output
												id="problemThumbs"></output></td>
									</tr>
								</table>
							</td>
							<td height="560px" style="background-color: white; border: none;"
								bordercolor="black"><pre id="solution" width="100%"
									style="border: solid; border-width: 1px; height: 345px; word-break: break-all; white-space: pre-line;"
									contenteditable="true"></pre>
								<table
									style="border-color: #e6e6e6; border-style: solid; width: 100%;">
									<tr bgcolor="#F2F2F2">
										<td>
											<p>Image List(Drag &amp; drop-only Image)</p>
										</td>
									</tr>
									<tr>
										<td align="left" height="115px" ondragenter="return false"
											ondragover="return false"
											ondrop="dropIt(event, 'solutionThumbs')"><output
												id="solutionThumbs"></output></td>
									</tr>
								</table></td>
						</tr>
					</table>
				</td>
				<td>
					<table>
						<tr>
							<td><textarea id="tagList" rows="34" contenteditable="false"
									style="resize: none;" readonly="readonly">
								</textarea></td>
						</tr>
						<tr>
							<td>
								<button name="inputBtn">입력</button>
							</td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<button name="uploadBtn">업로드</button>
				</td>
			</tr>
		</table>
	</div>
</div>