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
    private final ImageRepository imageRepository;
    private final ProductDetailRepository productDetailRepository;
    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;
    private final OrderDetailRepository orderDetailRepository;

    public DataSeedRunner(RoleRepository roleRepository, UserRepository userRepository, CategoryRepository categoryRepository, ImageRepository imageRepository, ProductDetailRepository productDetailRepository, ProductRepository productRepository, OrderRepository orderRepository, OrderDetailRepository orderDetailRepository) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
        this.categoryRepository = categoryRepository;
        this.imageRepository = imageRepository;
        this.productDetailRepository = productDetailRepository;
        this.productRepository = productRepository;
        this.orderRepository = orderRepository;
        this.orderDetailRepository = orderDetailRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        // Create roles ( ADMIN and USER)
        Role adminRole = new Role();
        adminRole.setName("ROLE_ADMIN");
        Role user = new Role();
        user.setName("ROLE_USER");
        roleRepository.saveAll(List.of(adminRole, user));

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

        userRepository.saveAll(List.of(user1, user2));


        Category category1 = new Category();
        category1.setName("category1");

        Category category2 = new Category();
        category2.setName("category2");

        Category category3 = new Category();
        category3.setName("category3");

        categoryRepository.saveAll(List.of(category1, category2, category3));

        // Create images
        Image image1 = new Image();
        image1.setPath("image1.jpg");

        Image image2 = new Image();
        image2.setPath("image2.jpg");

        Image image3 = new Image();
        image3.setPath("image3.jpg");

        Image image4 = new Image();
        image4.setPath("image4.jpg");

        Image image5 = new Image();
        image5.setPath("image5.jpg");

        Image image6 = new Image();
        image6.setPath("image6.jpg");

        Image image7 = new Image();
        image7.setPath("image7.jpg");

        Image image8 = new Image();
        image8.setPath("image8.jpg");

        Image image9 = new Image();
        image9.setPath("image9.jpg");

        Image image10 = new Image();
        image10.setPath("image10.jpg");

// Create products
        Product product1 = new Product();
        product1.setName("product1");
        product1.setCategory(category1);
        product1.setPrice(3000);
        product1.setDescription("Product 1");

        Product product2 = new Product();
        product2.setName("product2");
        product2.setCategory(category3);
        product2.setPrice(4000);
        product2.setDescription("Product 2");

// Save products first
        productRepository.saveAll(List.of(product1, product2));

// Create product details
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

// Save product details
        productDetailRepository.saveAll(List.of(productDetail1, productDetail2, productDetail3, productDetail5, productDetail6, productDetail7));

// Set product details for images
        image1.setProductDetail(productDetail1);
        image2.setProductDetail(productDetail2);
        image3.setProductDetail(productDetail3);
        image4.setProductDetail(productDetail5);
        image5.setProductDetail(productDetail6);
        image6.setProductDetail(productDetail7);

// Save images
        imageRepository.saveAll(List.of(image1, image2, image3, image4, image5, image6, image7, image8, image9, image10));


        // Order

        Order order = new Order();
        order.setAddress("Addres1");
        order.setPhone("1234567890");
        order.setUser(user1);

        order = orderRepository.save(order);
        user1.getOrderList().add(order);
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setOrder(order);
        orderDetail.setQuantity(300);
        orderDetail.setPrice(4.2);
        orderDetail.setProduct(productDetail1);
        OrderDetail orderDetail2 = new OrderDetail();
        orderDetail2.setQuantity(300);
        orderDetail2.setPrice(4.2);
        orderDetail2.setProduct(productDetail2);
        orderDetail2.setOrder(order);


        order.getDetails().addAll(orderDetailRepository.saveAll(List.of(orderDetail, orderDetail2)));
        userRepository.save(user1);
        orderRepository.save(order);

    }
}
