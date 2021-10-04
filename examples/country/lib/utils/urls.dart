/// Util class with all app urls.
class AppUrls {
  static const countryCodes = '$_apiUrl/countries/codes';

  static const String _apiUrl = 'https://countriesnow.space/api/v0.1';

  static String getFlagByCode(String code) =>
      'https://flagcdn.com/w640/$code.jpg';
}
