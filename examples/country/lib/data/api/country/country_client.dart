import 'package:country/data/dto/country/country_code_data.dart';
import 'package:country/data/dto/country/country_response.dart';
import 'package:country/utils/urls.dart';
import 'package:dio/dio.dart';
import 'package:retrofit/retrofit.dart';

part 'country_client.g.dart';

@RestApi()
abstract class CountryClient {
  factory CountryClient(Dio dio, {String baseUrl}) = _CountryClient;

  /// Get list of countries with codes.
  @GET(AppUrls.countryCodes)
  Future<CountryListResponse<CountryCodeData>> getAll();
}
