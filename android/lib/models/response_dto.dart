class Response {
  String? data;
  late String message;

  Response({this.data, required this.message});

  Response.fromJson(Map<String, dynamic> json) {
    data = json['data'] is String ? json['data'] : null;
    message = json['message'];
  }
}
