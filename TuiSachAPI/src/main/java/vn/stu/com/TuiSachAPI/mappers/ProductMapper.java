package vn.stu.com.TuiSachAPI.mappers;

import org.springframework.stereotype.Service;
import vn.stu.com.TuiSachAPI.dtos.ProductDTO;
import vn.stu.com.TuiSachAPI.dtos.ProductDetailDTO;
import vn.stu.com.TuiSachAPI.entities.Product;
import vn.stu.com.TuiSachAPI.entities.ProductDetail;

@Service
public class ProductMapper {

    public ProductDTO toProductDTO(Product product) {
        return new ProductDTO(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getCategory().getId(),
                product.getDetails().stream().map(this::toProductDetailDTO).toList()
        );
    }


    public ProductDetailDTO toProductDetailDTO(ProductDetail productDetail) {
        return new ProductDetailDTO(
                productDetail.getId(),
                productDetail.getSize(),
                productDetail.getColor(),
                productDetail.getQuantity(),
                productDetail.getImage().getPath()
        );
    }

}
