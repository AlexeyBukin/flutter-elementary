// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'country_response.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

CountryResponse _$CountryResponseFromJson(Map<String, dynamic> json) {
  return CountryResponse(
    error: json['error'] as bool,
    msg: json['msg'] as String,
    data: (json['data'] as List<dynamic>)
        .map((e) => CountryData.fromJson(e as Map<String, dynamic>))
        .toList(),
  );
}

Map<String, dynamic> _$CountryResponseToJson(CountryResponse instance) =>
    <String, dynamic>{
      'error': instance.error,
      'msg': instance.msg,
      'data': instance.data,
    };
