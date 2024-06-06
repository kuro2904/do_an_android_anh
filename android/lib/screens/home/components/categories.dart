import 'dart:convert';

import 'package:flutter/material.dart';
import 'package:flutter_svg/flutter_svg.dart';
import 'package:http/http.dart' as http;
import 'package:shop_app/constants.dart';

import '../../../models/category.dart';

class Categories extends StatefulWidget {
  const Categories({super.key});

  @override
  State<StatefulWidget> createState() => CategoriesState();
}

class CategoriesState extends State<Categories> {
  List<Category> categories = [];

  @override
  void initState() {
    fetchCategory();
    super.initState();
  }

  Future<void> fetchCategory() async {
    Uri url = Uri.parse(categoryString);
    var response = await http.get(url);
    if (response.statusCode == 200) {
      print(json.decode(response.body));
      parseCategory(response.body);
    } else {
      throw Exception("Cannot fetch API");
    }
  }

  parseCategory(String responseBody) {
    var parser = json.decode(responseBody);
    List<dynamic> data = parser['data'];
    print(data);

    List<Category> categoriesData = data.map((item) {
      return Category.fromJson(item as Map<String, dynamic>);
    }).toList();
    setState(() {
      categories = categoriesData;
    });
  }

  @override
  Widget build(BuildContext context) {
    return Padding(
      padding: const EdgeInsets.all(20),
      child: Row(
        mainAxisAlignment: MainAxisAlignment.spaceBetween,
        crossAxisAlignment: CrossAxisAlignment.start,
        children: List.generate(
          categories.length,
          (index) => CategoryCard(
            icon: "assets/icons/bag_ic.svg",
            text: categories[index].name,
            press: () {},
          ),
        ),
      ),
    );
  }
}

class CategoryCard extends StatelessWidget {
  const CategoryCard({
    Key? key,
    required this.icon,
    required this.text,
    required this.press,
  }) : super(key: key);

  final String icon, text;
  final GestureTapCallback press;

  @override
  Widget build(BuildContext context) {
    return GestureDetector(
      onTap: press,
      child: Column(
        children: [
          Container(
            padding: const EdgeInsets.all(16),
            height: 56,
            width: 56,
            decoration: BoxDecoration(
              color: const Color(0xFFFFECDF),
              borderRadius: BorderRadius.circular(10),
            ),
            child: SvgPicture.asset(icon),
          ),
          const SizedBox(height: 4),
          Text(text, textAlign: TextAlign.center)
        ],
      ),
    );
  }
}
