// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'country_response.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

CountryListResponse<T> _$CountryListResponseFromJson<T extends CountryData>(
  Map<String, dynamic> json,
  T Function(Object? json) fromJsonT,
) {
  return CountryListResponse<T>(
    successful: json['error'] as bool,
    msg: json['msg'] as String,
    data: (json['data'] as List<dynamic>).map(fromJsonT),
  );
}

Map<String, dynamic> _$CountryListResponseToJson<T extends CountryData>(
  CountryListResponse<T> instance,
  Object? Function(T value) toJsonT,
) =>
    <String, dynamic>{
      'error': instance.successful,
      'msg': instance.msg,
      'data': instance.data.map(toJsonT).toList(),
    };
