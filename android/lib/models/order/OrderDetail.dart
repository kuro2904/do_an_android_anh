import 'package:shop_app/models/product/product.dart';
import 'package:shop_app/models/product/product_detail.dart';

class OrderDetail{
  final Product product;
  final Detail detail;
  final int quantity;
  final double price;

  OrderDetail({required this.product, required this.detail, required this.quantity, required this.price});

}

List<OrderDetail> userOrderDetail = [];