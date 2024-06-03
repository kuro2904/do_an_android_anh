import 'package:flutter/foundation.dart';

class Category{
  late int id;
  late String name;

  Category(this.id, {required this.name});

  factory Category.fromJson(Map<String,dynamic> json){
    return Category(json['id'], name: json['name']);
  }

}