<html lang="en" xmlns:th="http://www.springframework.org/schema/mvc">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

	<script src="/js/jquery.1.10.2.min.js" type="text/javascript"></script>
	<script src="/js/jquery.autocomplete.min.js" type="text/javascript"></script>
	<link href="/css/card.css" rel="stylesheet">
	<script src="/js/autocomplete.js" type="text/javascript"></script>
</head>
<body>
	<div>
		<input type="text"  class = "ui fluid selection dropdown" id="autocomplete-search" value="">
	</div>
	
	<div class="ui card">
	  <div class="content">
	    <div class="header" id="name"></div>
	  </div>
	  <div class="content">
		<div class="meta" id="author"></div>
	      <div class="description" id="series">
	      </div>
	  </div>
	</div>

</body>
</html>