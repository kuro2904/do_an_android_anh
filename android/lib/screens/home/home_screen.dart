import 'dart:async';
import 'dart:convert';

import 'package:flutter/material.dart';
import 'package:http/http.dart' as http;
import '../../constants.dart';
import '../../models/product/product.dart';
import 'components/categories.dart';
import 'components/discount_banner.dart';
import 'components/home_header.dart';
import 'components/popular_product.dart';
import 'components/special_offers.dart';

class HomeScreen extends StatefulWidget {
  static String routeName = "/home";

  const HomeScreen({super.key});
  @override
  State<StatefulWidget> createState() => HomeScreenState();
}


class HomeScreenState extends State<HomeScreen>{
  List<Product> products = [];

  @override
  void initState() {
    fetchFutureProducts();
    super.initState();
  }

  Future<void> fetchFutureProducts() async{
    Uri url = Uri.parse(productString);

    var response = await http.get(url);

    if(response.statusCode == 200){
      parseProduct(response.body);
    }
    throw Exception("Cannot Fetch Products");
  }

  parseProduct(String responseBody){
    var parser = json.decode(responseBody);
    List<dynamic> data = parser['data'];

    List<Product> productData = data.map((item) {
      return Product.fromJson(item as Map<String, dynamic>);
    }).toList();
    print(productData);
    setState(() {
      products = productData;
    });
  }


  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: SafeArea(
        child: SingleChildScrollView(
          padding: const EdgeInsets.symmetric(vertical: 16),
          child: Column(
            children: [
              const HomeHeader(),
              const DiscountBanner(),
              const Categories(),
              const SpecialOffers(),
              const SizedBox(height: 20),
              PopularProducts(products: products),
              const SizedBox(height: 20),
            ],
          ),
        ),
      ),
    );
  }

}