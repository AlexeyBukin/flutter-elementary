import 'package:country/data/dto/country/country_data.dart';
import 'package:country/domain/country/country.dart';
import 'package:country/utils/urls.dart';

/// Map Country from CountryData
Country mapCountry(CountryData data) {
  return Country(
    flag: AppUrls.getFlagByCode(data.iso2?.toLowerCase()),
    name: data.name,
  );
}
