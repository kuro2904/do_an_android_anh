package vn.stu.com.TuiSachAPI.data;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import vn.stu.com.TuiSachAPI.entities.*;
import vn.stu.com.TuiSachAPI.repositories.*;

import java.util.List;

@Component
public class DataSeedRunner implements CommandLineRunner {

    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;

    private final ProductDetailRepository productDetailRepository;
    private final ProductRepository productRepository;

    public DataSeedRunner(RoleRepository roleRepository, UserRepository userRepository, CategoryRepository categoryRepository, ProductDetailRepository productDetailRepository, ProductRepository productRepository) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
        this.categoryRepository = categoryRepository;
        this.productDetailRepository = productDetailRepository;
        this.productRepository = productRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        // Create roles ( ADMIN and USER)
        Role adminRole = new Role();
        adminRole.setName("ROLE_ADMIN");
        Role user = new Role();
        user.setName("ROLE_USER");
        roleRepository.saveAll(List.of(adminRole,user));

        User admin = new User();
        admin.setUserName("admin");
        admin.setPassword("admin");
        admin.setPhoneNumber("1234567890");
        admin.setRole(adminRole);
        userRepository.saveAll(List.of(admin));

        User user1 = new User();
        user1.setUserName("user1");
        user1.setPassword("password1");
        user1.setPhoneNumber("123");
        user1.setRole(user);

        User user2 = new User();
        user2.setUserName("user2");
        user2.setPassword("password2");
        user2.setPhoneNumber("456");
        user2.setRole(user);

        userRepository.saveAll(List.of(user1,user2));


        Category category1 = new Category();
        category1.setName("category1");

        Category category2 = new Category();
        category2.setName("category2");

        Category category3 = new Category();
        category3.setName("category3");

        categoryRepository.saveAll(List.of(category1,category2,category3));

        Product product1 = new Product();
        product1.setName("product1");
        product1.setCategory(category1);
        product1.setPrice(3000);
        product1.setDescription("Product 1");

        ProductDetail productDetail1 = new ProductDetail();
        productDetail1.setQuantity(300);
        productDetail1.setSize("M");
        productDetail1.setColor("Trang");
        productDetail1.setProduct(product1);


        ProductDetail productDetail2 = new ProductDetail();
        productDetail2.setQuantity(300);
        productDetail2.setSize("L");
        productDetail2.setColor("Den");
        productDetail2.setProduct(product1);

        ProductDetail productDetail3 = new ProductDetail();
        productDetail3.setQuantity(300);
        productDetail3.setSize("XL");
        productDetail3.setColor("Tim");
        productDetail3.setProduct(product1);


        Product product2 = new Product();
        product2.setName("product2");
        product2.setCategory(category3);
        product2.setPrice(4000);
        product2.setDescription("product 2");

        ProductDetail productDetail5 = new ProductDetail();
        productDetail5.setQuantity(300);
        productDetail5.setSize("M");
        productDetail5.setColor("Trang");
        productDetail5.setProduct(product2);


        ProductDetail productDetail6 = new ProductDetail();
        productDetail6.setQuantity(300);
        productDetail6.setSize("L");
        productDetail6.setColor("Den");
        productDetail6.setProduct(product2);

        ProductDetail productDetail7 = new ProductDetail();
        productDetail7.setQuantity(300);
        productDetail7.setSize("XL");
        productDetail7.setColor("Tim");
        productDetail7.setProduct(product2);
        productRepository.saveAll(List.of(product1, product2));
        productDetailRepository.saveAll(List.of(productDetail1,productDetail2,productDetail3,productDetail5,productDetail6,productDetail7));

    }
}
