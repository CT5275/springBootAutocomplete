$(document).ready(function() {
		$('#autocomplete-search').autocomplete({
			serviceUrl: 'http://localhost:8080/getBooks',
			paramName: "author",
			delimiter: ",",
		    formatResult: function (suggestion, currentValue) {         
	      		return suggestion.name;
		    },
		    transformResult: function(response) {
		        return {
		            suggestions: $.map($.parseJSON(response), function(book) {
		                return { name: book.name, author: book.author, series:book.series };
		            })
		        };
		    },
		    onSelect: function (suggestion) {
		        $("#author").text(suggestion.author);
		        $("#name").text(suggestion.name);
		        $("#series").text(suggestion.series);
		    }
		});
	});