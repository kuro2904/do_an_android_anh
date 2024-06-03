class ProductDetail {
  int? id;
  String size;
  String color;
  int quantity;
  String imagePath;

  ProductDetail(
      this.id, {
        required this.size,
        required this.color,
        required this.quantity,
        required this.imagePath
      });

  factory ProductDetail.fromJson(Map<String, dynamic> json) {
    return ProductDetail(
      json['id'] as int?,
      size: json['size'] as String,
      color: json['color'] as String,
      quantity: json['quantity'] as int,
      imagePath: json['imagePath'] as String
    );
  }

  Map<String, dynamic> toJson() {
    return {
      'id': id,
      'size': size,
      'color': color,
      'quantity': quantity,
      'imagePath': imagePath
    };
  }
}
