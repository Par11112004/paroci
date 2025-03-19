const apiKey = "YOUR_API_KEY"; // Replace with your OpenWeatherMap API key

function getWeather() {
    const city = document.getElementById('city').value;
    if (!city) {
        alert("Please enter a city name!");
        return;
    }

    const apiUrl = `https://api.openweathermap.org/data/2.5/weather?q=${city}&units=metric&appid=${apiKey}`;

    fetch(apiUrl)
        .then(response => response.json())
        .then(data => {
            if (data.cod === '404') {
                alert("City not found");
            } else {
                document.getElementById('city-name').innerText = `${data.name}, ${data.sys.country}`;
                document.getElementById('temperature').innerText = `Temperature: ${data.main.temp} °C`;
                document.getElementById('description').innerText = `Condition: ${data.weather[0].description}`;
                document.getElementById('humidity').innerText = `Humidity: ${data.main.humidity}%`;
                document.getElementById('windspeed').innerText = `Wind Speed: ${data.wind.speed} m/s`;
            }
        })
        .catch(error => {
            console.error('Error:', error);
        });
}
