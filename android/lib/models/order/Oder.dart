import 'OrderDetail.dart';

class Order {
  final String address;
  final String phone;
  final int userId;
  final double total;
  final List<OrderDetail> detail;

  Order(
      {
  required this.address,
      required this.phone,
      required this.userId,
      required this.total,
      required this.detail});
}
