class GetAllCountriesException implements Exception {
  final String description;

  GetAllCountriesException(this.description);

  @override
  String toString() {
    return 'Error while getting countries: $description';
  }
}
