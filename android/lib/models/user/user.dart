class User{
  late final int? id;
  late final String userName;
  late final String password;
  late final String role;
  late final String phoneNumber;

  User(this.id,{required this.userName, required this.password, required this.role, required this.phoneNumber});

  User.fromJson(Map<String,dynamic> json){
    id = json['id'];
    userName = json['userName'];
    password = json['password'];
    role = json['role'];
    phoneNumber = json['phoneNumber'];
  }

}