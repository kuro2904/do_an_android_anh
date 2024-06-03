    package vn.stu.com.TuiSachAPI.entities;

    import jakarta.persistence.Entity;
    import jakarta.persistence.GeneratedValue;
    import jakarta.persistence.Id;
    import jakarta.persistence.OneToOne;

    @Entity
    public class Image {
        @Id
        @GeneratedValue
        private int id;
        private String path;
        @OneToOne
        private ProductDetail productDetail;

        public Image(int id, String path, ProductDetail productDetail) {
            this.id = id;
            this.path = path;
            this.productDetail = productDetail;
        }

        public Image() {

        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getPath() {
            return path;
        }

        public void setPath(String path) {
            this.path = path;
        }

        public ProductDetail getProductDetail() {
            return productDetail;
        }

        public void setProductDetail(ProductDetail productDetail) {
            this.productDetail = productDetail;
        }
    }
