import 'dart:convert';
import 'package:http/http.dart' as http;

class Category {
  final int id;
  final String name;

  Category(this.id, {required this.name});

  factory Category.fromJson(Map<String, dynamic> json) {
    return Category(
      json['id'],
      name: json['name'],
    );
  }
}

