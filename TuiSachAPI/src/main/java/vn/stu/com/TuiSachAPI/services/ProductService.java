package vn.stu.com.TuiSachAPI.services;

import vn.stu.com.TuiSachAPI.dtos.ProductDTO;
import vn.stu.com.TuiSachAPI.dtos.ResponseDTO;

import java.util.List;

public interface ProductService {
    ResponseDTO<List<ProductDTO>> findAllProducts();

    ResponseDTO<ProductDTO> createProduct(ProductDTO dto);

    ResponseDTO<ProductDTO> findById(int productId);
}
