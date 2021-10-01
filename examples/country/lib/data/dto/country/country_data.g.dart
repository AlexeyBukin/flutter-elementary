// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'country_data.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

CountryData _$CountryDataFromJson(Map<String, dynamic> json) {
  return CountryData(
    iso2: json['Iso2'] as String?,
    iso3: json['Iso3'] as String?,
    name: json['name'] as String,
  );
}

Map<String, dynamic> _$CountryDataToJson(CountryData instance) =>
    <String, dynamic>{
      'name': instance.name,
      'Iso2': instance.iso2,
      'Iso3': instance.iso3,
    };
