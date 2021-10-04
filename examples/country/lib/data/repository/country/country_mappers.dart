import 'package:country/data/dto/country/country_code_data.dart';
import 'package:country/domain/country/country.dart';
import 'package:country/utils/urls.dart';

/// Map Country from CountryData
Country mapCountryCodeData(CountryCodeData data) {
  return Country(
    flag: AppUrls.getFlagByCode(data.code.toLowerCase()),
    name: data.name,
  );
}
