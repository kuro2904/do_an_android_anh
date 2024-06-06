class Detail {
  final int id;
  final String size;
  final String color;
  final int quantity;
  final String imagePath;

  Detail({
    required this.id,
    required this.size,
    required this.color,
    required this.quantity,
    required this.imagePath,
  });

  factory Detail.fromJson(Map<String, dynamic> json) {
    return Detail(
      id: json['id'],
      size: json['size'],
      color: json['color'],
      quantity: json['quantity'],
      imagePath: json['imagePath'],
    );
  }
}
