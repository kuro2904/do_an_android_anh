package vn.stu.com.TuiSachAPI.dtos;

public record ResponseDTO<T>(T data,int status,String message ) { }
