import 'package:json_annotation/json_annotation.dart';

part 'country_data.g.dart';

/// DTO for country.
@JsonSerializable()
class CountryData {
  final String name;
  @JsonKey(name: 'Iso2')
  final String? iso2;
  @JsonKey(name: 'Iso3')
  final String? iso3;

  CountryData({
    required this.iso2,
    required this.iso3,
    required this.name,
  });

  factory CountryData.fromJson(Map<String, dynamic> json) =>
      _$CountryDataFromJson(json);

  Map<String, dynamic> toJson() => _$CountryDataToJson(this);
}
