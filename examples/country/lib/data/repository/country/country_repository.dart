import 'package:country/data/api/country/country_client.dart';
import 'package:country/data/repository/country/country_exceptions.dart';
import 'package:country/data/repository/country/country_mappers.dart';
import 'package:country/domain/country/country.dart';

/// Country repository
class CountryRepository {
  final CountryClient _client;

  CountryRepository(this._client);

  /// Return all countries
  Future<Iterable<Country>> getAllCountries() async {
    final response = await _client.getAll();

    if (!response.successful) throw GetAllCountriesException(response.msg);

    return response.data.map(mapCountryCodeData);
  }
}
