/// Util class with all app urls.
class AppUrls {
  static const all = '$_apiUrl/countries/iso';

  static const String _apiUrl = 'https://countriesnow.space/api/v0.1';

  static const defaultFlag =
      'https://world-geography-games.com/img/home-africa1.png';

  static String getFlagByCode(String? code) =>
      code != null ? 'https://flagcdn.com/w640/$code.jpg' : defaultFlag;
}
