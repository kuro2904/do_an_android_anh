import 'package:shop_app/models/product_detail.dart';

class Product {
  int? id;
  String name;
  String description;
  double price;
  int categoryId;
  List<ProductDetail> details;

  Product(this.id,
      {required this.name,
        required this.description,
        required this.price,
        required this.categoryId,
        required this.details});

  factory Product.fromJson(Map<String, dynamic> json) {
    var detailsFromJson = json['details'] as List;
    List<ProductDetail> detailList =
    detailsFromJson.map((i) => ProductDetail.fromJson(i)).toList();

    return Product(
      json['id'],
      name: json['name'],
      description: json['description'],
      price: json['price'],
      categoryId: json['categoryId'],
      details: detailList,
    );
  }

  Map<String, dynamic> toJson() {
    return {
      'id': id,
      'name': name,
      'description': description,
      'price': price,
      'categoryId': categoryId,
      'details': details.map((detail) => detail.toJson()).toList(),
    };
  }
}
