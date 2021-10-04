import 'package:country/data/dto/country/country_data.dart';
import 'package:json_annotation/json_annotation.dart';

part 'country_code_data.g.dart';

///DTO from country code data
@JsonSerializable()
class CountryCodeData extends CountryData {
  final String name;
  final String code;

  CountryCodeData({
    required this.name,
    required this.code,
  });

  factory CountryCodeData.fromJson(Map<String, dynamic> json) =>
      _$CountryCodeDataFromJson(json);

  Map<String, dynamic> toJson() => _$CountryCodeDataToJson(this);
}
