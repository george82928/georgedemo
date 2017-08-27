<!DOCTYPE html>
<html lang="en" ng-app="weatherApp">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Weather Demo</title>
    <link rel="stylesheet" type="text/css" href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" />
    <link rel="stylesheet" type="text/css" href="css/style.css" />
    <script type="text/javascript" src="webjars/jquery/1.11.1/jquery.min.js"></script>
    <script type="text/javascript" src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="webjars/angularjs/1.4.9/angular.min.js"></script>
    <script type="text/javascript" src="webjars/angularjs/1.4.9/angular-resource.min.js"></script>
    <script src="js/app.js"></script>
    <script src="js/weatherService.js"></script>
    <script src="js/weatherController.js"></script>
</head>

<body>
    <div ng-controller="WeatherController as weCtrl" class="container customPanel">
        <div class="form-group">
            <label for="weatherSelect">
                <h2>Please select a city</h2></label>
            <select name="weatherSelect" id="weatherSelect" ng-model="weCtrl.city" ng-change="weCtrl.citySelected()" class="form-control">
                <option ng-repeat="city in weCtrl.cities" value="{{city.name}}">{{city.name}}</option>
            </select>
        </div>
        <div ng-show="weCtrl.showError">
            <div class="alert alert-danger">{{weCtrl.errorMessage}}</div>
        </div>
        <div>
            <table class="table table-bordered table-hover customTable">
                <thead>
                    <tr class="info">
                        <th>Weather Information Key</th>
                        <th>Weather Information Value</th>
                    </tr>
                </thead>
                <tbody>
                    <tr class="info">
                        <td>City</td>
                        <td><span>{{weCtrl.weatherInfo.city}}</span></td>
                    </tr>
                    <tr class="info">
                        <td>Updated Time</td>
                        <td><span>{{weCtrl.weatherInfo.updatedTime}}</span></td>
                    </tr>
                    <tr class="info">
                        <td>Weather</td>
                        <td><span>{{weCtrl.weatherInfo.weather}}</span></td>
                    </tr>
                    <tr class="info">
                        <td>Temperature</td>
                        <td><span>{{weCtrl.weatherInfo.temperature}}</span></td>
                    </tr>
                    <tr class="info">
                        <td>Wind</td>
                        <td><span>{{weCtrl.weatherInfo.wind}}</span></td>
                    </tr>
                </tbody>
            </table>
        </div>
    </div>
</body>

</html>