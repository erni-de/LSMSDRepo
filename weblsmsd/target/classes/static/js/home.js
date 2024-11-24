/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/javascript.js to edit this template
 */

$(document).ready(function() {
            $('#Departure').on('click', function() {
                var searchQuery = $(this).val();
                // If the input is empty, clear the suggestions
                if (searchQuery.trim() === "") {
                    $('#DepartureSuggestions').empty();
                    return;
                }

                // Nominatim API URL with the search query
                var url = 'https://nominatim.openstreetmap.org/search?q=' + encodeURIComponent(searchQuery) + '&format=json&addressdetails=1&limit=5';

                // Make the AJAX request to the Nominatim API
                $.ajax({
                    url: url,
                    method: 'GET',
                    success: function(data) {
                        // Clear the previous suggestions
                        $('#DepartureSuggestions').empty();

                        // Iterate over the suggestions and display them
                        data.forEach(function(place) {
                            var suggestion = $('<div class="suggestion-item"></div>')
                                .text(place.display_name)
                                .on('click', function() {
                                    // When a suggestion is clicked, populate the input and clear suggestions
                                    $('#Departure').val(place.display_name);
                                    $('#DepartureSuggestions').empty();
                                    // Optionally, you can do more with the place, e.g., show its coordinates
                                    console.log('Selected place:', place);
                                });

                            // Append each suggestion to the suggestions container
                            $('#DepartureSuggestions').append(suggestion);
                        });
                    },
                    error: function() {
                        // Handle errors (e.g., no response)
                        $('#DepartureSuggestions').empty();
                        console.error('Error fetching data from Nominatim API');
                    }
                });
                
            });
            
            $('#Arrival').on('click', function() {
                var searchQuery = $(this).val();
                // If the input is empty, clear the suggestions
                if (searchQuery.trim() === "") {
                    $('#ArrivalSuggestions').empty();
                    return;
                }

                // Nominatim API URL with the search query
                var url = 'https://nominatim.openstreetmap.org/search?q=' + encodeURIComponent(searchQuery) + '&format=json&addressdetails=1&limit=5';

                // Make the AJAX request to the Nominatim API
                $.ajax({
                    url: url,
                    method: 'GET',
                    success: function(data) {
                        // Clear the previous suggestions
                        $('#ArrivalSuggestions').empty();

                        // Iterate over the suggestions and display them
                        data.forEach(function(place) {
                            var suggestion = $('<div class="suggestion-item"></div>')
                                .text(place.display_name)
                                .on('click', function() {
                                    // When a suggestion is clicked, populate the input and clear suggestions
                                    $('#Arrival').val(place.display_name);
                                    $('#ArrivalSuggestions').empty();
                                    // Optionally, you can do more with the place, e.g., show its coordinates
                                    console.log('Selected place:', place);
                                });

                            // Append each suggestion to the suggestions container
                            $('#ArrivalSuggestions').append(suggestion);
                        });
                    },
                    error: function() {
                        // Handle errors (e.g., no response)
                        $('#ArrivalSuggestions').empty();
                        console.error('Error fetching data from Nominatim API');
                    }
                });
            });
            
        });

