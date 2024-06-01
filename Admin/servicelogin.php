<?php
// Kiểm tra dữ liệu POST có tồn tại và không rỗng
if (isset($_POST['usernameOrPhoneNumber']) && isset($_POST['password']) && !empty($_POST['usernameOrPhoneNumber']) && !empty($_POST['password'])) {
    // Dữ liệu cần gửi đi
    $data = array(
        'usernameOrPhoneNumber' => $_POST['usernameOrPhoneNumber'], //?? cmm sai chinh ta
        'password' => $_POST['password']
    );

    // Địa chỉ URL của API đăng nhập
    $login_url = 'http://localhost:8080/api/v1/auth/login';

    // Khởi tạo một cURL handle
    $ch = curl_init();
    
    // Kiểm tra xem cURL handle có được khởi tạo thành công hay không
    if ($ch === false) {
        // Xử lý lỗi nếu không thể khởi tạo cURL handle
        echo 'Error: Could not initialize cURL';
    } else {
        // Thiết lập các tùy chọn cho yêu cầu POST
        curl_setopt($ch, CURLOPT_URL, $login_url);
        curl_setopt($ch, CURLOPT_POST, 1);
        curl_setopt($ch, CURLOPT_POSTFIELDS, json_encode($data));
        curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
        curl_setopt($ch, CURLOPT_HTTPHEADER, array('Content-Type: application/json'));

        // Thực thi yêu cầu và lấy kết quả trả về
        $response = curl_exec($ch);
        echo $response;
        // // Xử lý kết quả
        // if ($response === false) {
        //     // Xử lý lỗi nếu có
        //     echo 'Error: ' . curl_error($ch);
        // } else {
        //     // Xử lý kết quả thành công
        //     // Ví dụ: chuyển hướng đến trang chính sau khi đăng nhập thành công
        //     // Điều này phụ thuộc vào cách API trả về kết quả
        //     $httpcode = curl_getinfo($ch, CURLINFO_HTTP_CODE);
        //     if ($httpcode == 200) {
        //         header("Location: main.php");
        //         exit();
        //     } else {
        //         echo 'Error: API response code ' . $httpcode;
        //         echo 'Response: ' . $response;
        //     }
        // }
        // Đóng cURL handle
        curl_close($ch);
    }
} else {
    echo 'Error: Username and password are required';
}
?>