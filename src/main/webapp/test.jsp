<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>HTML5 Drag & Drop</title>
<link type="text/css" href="${webappRoot}/resources/css/style.css" rel="Stylesheet" />
<link type="text/css" href="${webappRoot}/resources/css/redmond/jquery-ui-1.8.20.custom.css" rel="Stylesheet" />	
<script type="text/javascript" src="${webappRoot}/resources/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="${webappRoot}/resources/js/jquery-ui-1.8.20.custom.min.js"></script>
<script type="text/javascript" src="${webappRoot}/resources/js/jquery.form.js"></script>
<script type="text/javascript" src="${webappRoot}/resources/js/utils.js"></script>
<style>
table {
	width: 60%;
	margin-left: 20%;
	margin-right: 20%;
}

table,td {
	border-color: #e6e6e6;
	border-style: solid;
}

td {
	font-family: Arial, Helvetica, sans-serif;
	font-size: 8pt;
}

.images {
	height: 75px;
	width: 75px;
	border: 0px;
	margin: 15px 15px 0 0;
}
</style>

<script>
$(function() {
	
	$("#uploadOneProblemForm").ajaxForm();
	
	$("#upload").button().click(function() {
		$("#uploadOneProblemForm").submit();
	});
	
});
	
	function addFile(files) {
//		$("<input style='visibility: hidden; positon:absolute;' type='file' name='problemImageFiles' value='' />").val(src)
//			.appendTo("#uploadOneProblemForm");
		//$("#uploadOneProblemForm").find("input[type='file']").attr("src", src);

		console.log(files);
		var fd = new FormData();
		for(var i = 0 ; i < files.length ; ++i) {
			var f = files.item(i);
			fd.append("problemImageFiles", f);
		}
		
		$.ajax({
			url: '${webappRoot}/header/uploadOneProblem',
			type: 'POST',
			data: fd,
			processData: false,
			contentType: false,
			success: function() {
				console.log("success!");
			}
		});
	}
	
	function imagesSelected(myFiles) {
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
					document.getElementById('thumbs').insertBefore(span, null);
				};
			})(f);
			imageReader.readAsDataURL(f);
		}
		addFile(myFiles);
	}

	function dropIt(e) {
		console.log(e.dataTransfer);
		imagesSelected(e.dataTransfer.files);
		e.stopPropagation();
		e.preventDefault();
	}
</script>
</head>
<body>
	
	<table>
		<tr bgcolor="#F2F2F2">
			<td>
				<p>Thumbnail palette(Drag & drop-only Image)</p>
			</td>
		</tr>
		<tr>
			<td align="left" height="105" ondragenter="return false"
				ondragover="return false" ondrop="dropIt(event)"><output
					id="thumbs"></output></td>
		</tr>
		<tr>
			<td>
				<button id="upload">업로드</button>
			</td>
		</tr>
	</table>
</body>
</html>