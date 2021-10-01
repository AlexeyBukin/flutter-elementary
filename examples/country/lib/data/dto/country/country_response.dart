import 'package:country/data/dto/country/country_data.dart';
import 'package:json_annotation/json_annotation.dart';

part 'country_response.g.dart';

/// DTO for country.
@JsonSerializable()
class CountryResponse {
  final bool error;
  final String msg;
  final List<CountryData> data;

  CountryResponse({
    required this.error,
    required this.msg,
    required this.data,
  });

  factory CountryResponse.fromJson(Map<String, dynamic> json) =>
      _$CountryResponseFromJson(json);

  Map<String, dynamic> toJson() => _$CountryResponseToJson(this);
}
