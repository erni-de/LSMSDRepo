/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/javascript.js to edit this template
 */
var map = L.map('map').setView([51.505, -0.09], 3); // Set initial position (latitude, longitude) and zoom level

// Add OpenStreetMap tile layer
L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
    attribution: '&copy; <a class = "map" href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors'
}).addTo(map);


var markersLayerD = L.layerGroup().addTo(map);
var markersLayerA = L.layerGroup().addTo(map);

var greenIcon = L.icon({
    iconUrl: '../pics/gpsgreen.png',
    iconSize: [25, 25], // Size of the icon
    iconAnchor: [12.5, 24], // Anchor point (where the marker's "tip" is)
    popupAnchor: [1, -34] // Popup location
});

var blueIcon = L.icon({
    iconUrl: '../pics/gpsred.png',
    iconSize: [25, 25], // Size of the icon
    iconAnchor: [12.5, 24], // Anchor point (where the marker's "tip" is)
    popupAnchor: [1, -34] // Popup location
});

$(document).ready(function () {
    $('#Departure').on('click', function () {
        markersLayerD.clearLayers();
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
            success: function (data) {
                // Clear the previous suggestions
                $('#DepartureSuggestions').empty();

                // Iterate over the suggestions and display them
                data.forEach(function (place) {
                    L.marker([place.lat, place.lon], {icon: greenIcon}).addTo(markersLayerD)
                            .bindPopup(place.display_name)
                            .openPopup();
                    var suggestion = $('<div class="suggestion-item"></div>')
                            .text(place.display_name)
                            .on('click', function () {
                                markersLayerD.clearLayers();
                                // When a suggestion is clicked, populate the input and clear suggestions
                                $('#Departure').val(place.name);
                                L.marker([place.lat, place.lon], {icon: greenIcon}).addTo(markersLayerD)
                                        .bindPopup(place.display_name)
                                        .openPopup();
                                $('#DepartureSuggestions').empty();

                                // Optionally, you can do more with the place, e.g., show its coordinates
                                console.log('Selected place:', place);
                            });

                    // Append each suggestion to the suggestions container
                    $('#DepartureSuggestions').append(suggestion);
                });
            },
            error: function () {
                // Handle errors (e.g., no response)
                $('#DepartureSuggestions').empty();
                console.error('Error fetching data from Nominatim API');
            }
        });

    });

    $('#Arrival').on('click', function () {
        markersLayerA.clearLayers();
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
            success: function (data) {
                // Clear the previous suggestions

                $('#ArrivalSuggestions').empty();
                // Iterate over the suggestions and display them
                data.forEach(function (place) {

                    L.marker([place.lat, place.lon], {icon: blueIcon}).addTo(markersLayerA)
                            .bindPopup(place.display_name)
                            .openPopup();
                    var suggestion = $('<div class="suggestion-item"></div>')
                            .text(place.display_name)
                            .on('click', function () {
                                markersLayerA.clearLayers();
                                // When a suggestion is clicked, populate the input and clear suggestions
                                $('#Arrival').val(place.name);
                                L.marker([place.lat, place.lon], {icon: blueIcon}).addTo(markersLayerA)
                                        .bindPopup(place.display_name)
                                        .openPopup();
                                $('#ArrivalSuggestions').empty();
                                // Optionally, you can do more with the place, e.g., show its coordinates
                                console.log('Selected place:', place);
                            });

                    // Append each suggestion to the suggestions container
                    $('#ArrivalSuggestions').append(suggestion);
                });
            },
            error: function () {
                // Handle errors (e.g., no response)
                $('#ArrivalSuggestions').empty();
                console.error('Error fetching data from Nominatim API');
            }
        });
    });

});

