import 'package:country/data/dto/country/country_data.dart';
import 'package:json_annotation/json_annotation.dart';

part 'country_response.g.dart';

/// Response for country api.
@JsonSerializable(genericArgumentFactories: true)
class CountryListResponse<T extends CountryData> {
  @JsonKey(name: 'error')
  final bool successful;
  final String msg;
  final Iterable<T> data;

  CountryListResponse({
    required this.successful,
    required this.msg,
    required this.data,
  });

  factory CountryListResponse.fromJson(
    Map<String, dynamic> json,
    T Function(Object? json) fromJson,
  ) =>
      _$CountryListResponseFromJson(
        json,
        fromJson,
      );

  Map<String, dynamic> toJson(
    T Function(Object? json) fromJson,
  ) =>
      _$CountryListResponseToJson(
        this,
        fromJson,
      );
}
