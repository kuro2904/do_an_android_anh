package vn.stu.com.TuiSachAPI.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.stu.com.TuiSachAPI.dtos.ProductDTO;
import vn.stu.com.TuiSachAPI.dtos.ResponseDTO;
import vn.stu.com.TuiSachAPI.services.ProductService;

import java.util.List;

import static vn.stu.com.TuiSachAPI.constants.Constant.nullError;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<ResponseDTO<List<ProductDTO>>> getAllProducts() {
        return ResponseEntity.ok(service.findAllProducts());
    }

    @GetMapping("/{productId}")
    public ResponseEntity<ResponseDTO<ProductDTO>> getProductById(@PathVariable int productId) {
        ResponseDTO<ProductDTO> response = service.findById(productId);
        if (response.status() == 0) return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        else return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ResponseDTO<ProductDTO>> createProduct(@RequestBody ProductDTO dto) {
        if (dto.name() == null || dto.name().isEmpty())
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseDTO<>(null, 0, nullError("Product name")));
        if (dto.description() == null || dto.description().isEmpty())
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseDTO<>(null, 0, nullError("Product description")));
        if (dto.price() <= 0)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseDTO<>(null, 0, "Product price is not valid"));
        if(dto.details() == null || dto.details().isEmpty())
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseDTO<>(null, 0, nullError("Product details")));
        ResponseDTO<ProductDTO> responseDTO = service.createProduct(dto);
        if (responseDTO.status() == 0)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseDTO);
        else return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }
}
