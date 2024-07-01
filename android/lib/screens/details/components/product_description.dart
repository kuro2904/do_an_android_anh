import 'package:flutter/material.dart';
import '../../../models/product/product.dart';

class ProductDescription extends StatefulWidget {
  const ProductDescription({
    Key? key,
    required this.product,
    required this.onVariantSelected, // Add this line
    required this.onQuantitySelected
  }) : super(key: key);

  final Product product;
  final ValueChanged<int> onVariantSelected; // Add this line
  final ValueChanged<int> onQuantitySelected;

  @override
  State<ProductDescription> createState() => _ProductDescriptionState();
}

class _ProductDescriptionState extends State<ProductDescription> {
  List<bool> isSelected = [];
  int? selectedIndex;
  int quantity = 1; // Add this line

  @override
  void initState() {
    super.initState();
    // Initialize isSelected with false for each variant
    isSelected = List.generate(widget.product.details.length, (index) => false);
  }

  @override
  Widget build(BuildContext context) {
    return SingleChildScrollView(
      child: Column(
        crossAxisAlignment: CrossAxisAlignment.start,
        children: [
          Padding(
            padding: const EdgeInsets.symmetric(horizontal: 20),
            child: Text(
              widget.product.name,
              style: Theme.of(context).textTheme.displayMedium,
            ),
          ),
          Padding(
            padding: const EdgeInsets.only(top: 20, left: 20, right: 64, bottom: 10),
            child: SizedBox(
              height: 200,
              child: PageView.builder(
                itemCount: widget.product.details.length,
                itemBuilder: (context, index) {
                  return Image.asset(
                      'assets/images/${widget.product.details[index].imagePath}');
                },
                scrollDirection: Axis.horizontal,
              ),
            ),
          ),
          Padding(
            padding: const EdgeInsets.all(10),
            child: Text(
              '${widget.product.price} VND',
              style: Theme.of(context).textTheme.titleLarge,
            ),
          ),
          Padding(
            padding: const EdgeInsets.all(10),
            child: Text(
              widget.product.description,
              style: Theme.of(context).textTheme.titleMedium,
            ),
          ),
          Padding(
            padding: const EdgeInsets.all(10),
            child: Text(
              'Available',
              style: Theme.of(context).textTheme.titleSmall,
            ),
          ),
          SizedBox(
            height: 80,
            child: ListView(
              padding: const EdgeInsets.all(10),
              scrollDirection: Axis.horizontal,
              children: [
                ToggleButtons(
                  borderColor: Colors.black,
                  borderRadius: BorderRadius.circular(10),
                  isSelected: isSelected,
                  onPressed: (int index) {
                    setState(() {
                      for (int buttonIndex = 0; buttonIndex < isSelected.length; buttonIndex++) {
                        if (buttonIndex == index) {
                          isSelected[buttonIndex] = !isSelected[buttonIndex];
                        } else {
                          isSelected[buttonIndex] = false;
                        }
                      }
                      selectedIndex = index;
                      widget.onVariantSelected(index); // Notify parent widget
                    });
                  },
                  children: widget.product.details.map((detail) {
                    return Padding(
                      padding: const EdgeInsets.symmetric(horizontal: 5),
                      child: Text(
                        '${detail.size} - ${detail.color}',
                        style: const TextStyle(fontSize: 20),
                      ),
                    );
                  }).toList(),
                )
              ],
            ),
          ),

          Padding(
            padding: const EdgeInsets.symmetric(horizontal: 20),
            child: Row(
              children: [
                Padding(
                  padding: const EdgeInsets.all(10),
                  child: Text(
                    'Quantity',
                    style: Theme.of(context).textTheme.titleSmall,
                  ),
                ),
                IconButton(
                  icon: const Icon(Icons.remove),
                  onPressed: () {
                    setState(() {
                      if (quantity > 1) {
                        quantity--;
                        widget.onQuantitySelected(quantity);
                      }
                    });
                  },
                ),
                Text(
                  '$quantity',
                  style: Theme.of(context).textTheme.titleLarge,
                ),
                IconButton(
                  icon: const Icon(Icons.add),
                  onPressed: () {
                    setState(() {
                      quantity++;
                      widget.onQuantitySelected(quantity);
                    });
                  },
                ),
              ],
            ),
          ),
          const SizedBox(height: 20),
        ],
      ),
    );
  }
}
