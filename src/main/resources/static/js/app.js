var app = angular.module('weatherApp',['ngResource']);

app.factory('urls', ['$location', function($location) {
	var base = $location.absUrl();
	var weather_service_api = base + "weather";
	return {
		base: $location.absUrl(),
		weather_service_api: weather_service_api
	};
}]);
