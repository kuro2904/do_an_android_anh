package vn.stu.com.TuiSachAPI.services.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vn.stu.com.TuiSachAPI.dtos.ProductDTO;
import vn.stu.com.TuiSachAPI.dtos.ResponseDTO;
import vn.stu.com.TuiSachAPI.entities.Category;
import vn.stu.com.TuiSachAPI.entities.Image;
import vn.stu.com.TuiSachAPI.entities.Product;
import vn.stu.com.TuiSachAPI.entities.ProductDetail;
import vn.stu.com.TuiSachAPI.mappers.ProductMapper;
import vn.stu.com.TuiSachAPI.repositories.CategoryRepository;
import vn.stu.com.TuiSachAPI.repositories.ImageRepository;
import vn.stu.com.TuiSachAPI.repositories.ProductDetailRepository;
import vn.stu.com.TuiSachAPI.repositories.ProductRepository;
import vn.stu.com.TuiSachAPI.services.ProductService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static vn.stu.com.TuiSachAPI.constants.Constant.createdSuccess;
import static vn.stu.com.TuiSachAPI.constants.Constant.notFoundError;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final ImageRepository imageRepository;
    private final ProductDetailRepository productDetailRepository;
    private final ProductMapper productMapper;

    public ProductServiceImpl(ProductRepository productRepository, CategoryRepository categoryRepository, ImageRepository imageRepository, ProductDetailRepository productDetailRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.imageRepository = imageRepository;
        this.productDetailRepository = productDetailRepository;
        this.productMapper = productMapper;
    }

    @Override
    public ResponseDTO<List<ProductDTO>> findAllProducts() {
        return new ResponseDTO<>(productRepository.findAll().stream().map(productMapper::toProductDTO).toList(), 1, "All products");
    }

    @Override
    public ResponseDTO<ProductDTO> createProduct(ProductDTO dto) {
        Optional<Category> categoryOpt = categoryRepository.findById(dto.categoryId());
        if (categoryOpt.isEmpty()) {
            return new ResponseDTO<>(null, 0, notFoundError("Category"));
        }

        Category category = categoryOpt.get();

        Product product = new Product();
        product.setCategory(category);
        product.setName(dto.name());
        product.setPrice(dto.price());
        product.setDescription(dto.description());

        List<ProductDetail> details = new ArrayList<>();

        dto.details().forEach(d -> {

            ProductDetail productDetail = new ProductDetail();
            productDetail.setProduct(product);
            productDetail.setColor(d.color());
            productDetail.setSize(d.size());
            productDetail.setQuantity(d.quantity());

            Image image = new Image();

            productDetail.setImage(image);

            details.add(productDetailRepository.save(productDetail));
            image.setPath(d.imagePath());
            image.setProductDetail(productDetail);
            imageRepository.save(image);
        });
        product.setDetails(details);
        return new ResponseDTO<>(productMapper.toProductDTO(productRepository.save(product)), 1, createdSuccess("Product"));
    }

    @Override
    public ResponseDTO<ProductDTO> findById(int productId) {
        Optional<Product> productOpt = productRepository.findById(productId);
        return productOpt.map(product -> new ResponseDTO<>(productMapper.toProductDTO(product), 1, "Product details"))
                .orElseGet(() -> new ResponseDTO<>(null, 0, notFoundError("Product")));
    }
}
