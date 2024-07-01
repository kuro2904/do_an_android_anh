import 'dart:math';

import 'package:flutter/material.dart';
import 'package:shop_app/screens/cart/cart_screen.dart';

import '../../models/product/product.dart';
import 'components/product_description.dart';
import 'components/top_rounded_container.dart';

class DetailsScreen extends StatefulWidget {
  static String routeName = "/details";

  const DetailsScreen({super.key});

  @override
  State<DetailsScreen> createState() => _DetailsScreenState();
}

class _DetailsScreenState extends State<DetailsScreen> {
  int? selectedVariantIndex;
  int selectedQuantity = 1;

  @override
  Widget build(BuildContext context) {
    final ProductDetailsArguments args =
    ModalRoute.of(context)!.settings.arguments as ProductDetailsArguments;
    final product = args.product;

    return Scaffold(
      extendBody: true,
      extendBodyBehindAppBar: true,
      backgroundColor: const Color(0xFFF5F6F9),
      appBar: AppBar(
        backgroundColor: Colors.transparent,
        elevation: 0,
      ),
      body: ListView(
        children: [
          // ProductImages(product: product),
          TopRoundedContainer(
            color: Colors.white,
            child: Column(
              children: [
                ProductDescription(
                  product: product,
                  onVariantSelected: (int index) {
                    setState(() {
                      selectedVariantIndex = index;
                    });
                  },
                  onQuantitySelected: (int quantity){
                    setState(() {
                      selectedQuantity = quantity;
                    });
                  },
                ),
              ],
            ),
          ),
        ],
      ),
      bottomNavigationBar: TopRoundedContainer(
        color: Colors.white,
        child: SafeArea(
          child: Padding(
            padding: const EdgeInsets.symmetric(horizontal: 20, vertical: 12),
            child: ElevatedButton(
              onPressed: selectedVariantIndex != null ? () {
                addToCard(product, selectedVariantIndex!, selectedQuantity);
                Navigator.pushNamed(context, CartScreen.routeName);
              } : null,
              child: const Text("Add To Cart"),
            ),
          ),
        ),
      ),
    );
  }

  void addToCard(Product product, int variantIndex, int quantity) {
    final selectedVariant = product.details[variantIndex];
    print("Selected Product: ${product.name} and Item: ${selectedVariant.id} quantity: $quantity");

  }
}



class ProductDetailsArguments {
  final Product product;

  ProductDetailsArguments({required this.product});
}
