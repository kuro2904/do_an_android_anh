import 'dart:convert';

import 'package:flutter/material.dart';
import 'package:shop_app/components/product_card.dart';
import 'package:shop_app/constants.dart';
import '../../models/product/product.dart';
import '../details/details_screen.dart';
import 'package:http/http.dart' as http ;

class ProductsScreen extends StatefulWidget {
  const ProductsScreen({super.key});

  static String routeName = "/products";

  @override
  State<StatefulWidget> createState() => ProductScreenState();
}

class ProductScreenState extends State<ProductsScreen>{

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
      appBar: AppBar(
        title: const Text("Products"),
      ),
      body: SafeArea(
        child: Padding(
          padding: const EdgeInsets.symmetric(horizontal: 16),
          child: GridView.builder(
            itemCount: products.length,
            gridDelegate: const SliverGridDelegateWithMaxCrossAxisExtent(
              maxCrossAxisExtent: 200,
              childAspectRatio: 0.7,
              mainAxisSpacing: 20,
              crossAxisSpacing: 16,
            ),
            itemBuilder: (context, index) => ProductCard(
              product: products[index],
              onPress: () => Navigator.pushNamed(
                context,
                DetailsScreen.routeName,
                arguments:
                ProductDetailsArguments(product: products[index]),
              ),
            ),
          ),
        ),
      ),
    );
  }

}
