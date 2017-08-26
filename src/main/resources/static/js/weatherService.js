'use strict';

app.factory('WeatherService', ['$http', '$q', 'urls',
    function($http, $q, urls) {

        function getWeather(city) {
            return $http.get(urls.weather_service_api + "/" + city)
                .then(
                    function(response) {
                        return response.data;
                    },
                    function(errResponse) {
                        console.error('Error while loading weather data');
                        return $q.reject(errResponse);
                    }
                );
        }
        var factory = {
            getWeather: getWeather
        };
        return factory;
    }
]);