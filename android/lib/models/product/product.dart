import 'package:shop_app/models/product/product_detail.dart';

class Product {
  final int id;
  final String name;
  final String description;
  final double price;
  final int categoryId;
  final List<Detail> details;

  Product({
    required this.id,
    required this.name,
    required this.description,
    required this.price,
    required this.categoryId,
    required this.details,
  });

  factory Product.fromJson(Map<String, dynamic> json) {
    var detailsList = json['details'] as List;
    List<Detail> details = detailsList.map((i) => Detail.fromJson(i)).toList();

    return Product(
      id: json['id'],
      name: json['name'],
      description: json['description'],
      price: json['price'],
      categoryId: json['categoryId'],
      details: details,
    );
  }
}
