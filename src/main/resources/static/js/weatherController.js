'use strict';

app.controller('WeatherController', ['WeatherService', '$http', '$scope', function(WeatherService, $http, $scope) {
    var self = this;
    self.weatherInfo = {};
    self.errorMessage = {};
    self.showError = false;
    $http.get('js/cities.json')
        .success(function(data) {
            self.cities = data;
        }).error(function(err) {
            self.errorMessage = err.message;
            self.showError = true;
        });

    function getDisplayedHour(hour) {
        var result = null;
        if (hour > 12) {
            result = hour - 12;
        } else {
            result = hour;
        }
        return result;
    }

    function getMeridiem(hour) {
        var result = null;
        if (hour < 12) {
            result = 'AM';
        } else if (hour > 12) {
            result = 'PM';
        } else {
            result = '';
        }
        return result;
    }

    function getDayOfTheWeek(day) {
        var result = null;
        switch (day) {
            case 0:
                result = 'Sunday';
                break;
            case 1:
                result = 'Monday';
                break;
            case 2:
                result = 'Tuesday';
                break;
            case 3:
                result = 'Wednesday';
                break;
            case 4:
                result = 'Thursday';
                break;
            case 5:
                result = 'Friday';
                break;
            case 6:
                result = 'Saturday';
                break;
        }
        return result;
    }

    function getUpdatedTime(unix_timestamp) {
        var date = new Date(unix_timestamp * 1000);
        var hour = date.getHours();
        var meridiem = getMeridiem(hour);
        var dayOfTheWeek = getDayOfTheWeek(date.getDay());
        var minutes = "0" + date.getMinutes();
        var displayedHour = getDisplayedHour(hour);
        return dayOfTheWeek + " " + displayedHour + ":" + minutes.substr(-2) + " " + meridiem;
    }

    self.citySelected = function() {
        try {
            self.weatherInfo = WeatherService.getWeather(self.city).then(function(data) {
                self.weatherInfo = data;
                self.weatherInfo.updatedTime = getUpdatedTime(data.updatedTime);
            }, function(err) {
                self.errorMessage = err.data.message;
                self.showError = true;
            });
        } catch (err) {
            console.log(err);
            self.errorMessage = err.message;
            self.showError = true;
        }
    };
}]);