/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/javascript.js to edit this template
 */

var map = L.map('map').setView([51.505, -0.09], 3); // Set initial position (latitude, longitude) and zoom level

    // Add OpenStreetMap tile layer
    L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
      attribution: '&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors'
    }).addTo(map);

    // Optional: Add a marker to the map
    L.marker([51.505, -0.09]).addTo(map)
      .bindPopup('This is a marker on the map!')
      .openPopup();
