package com.example.workerrental.service;

import com.example.workerrental.model.Customer;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    // Logic xử lý nghiệp vụ, trả về thông tin khách hàng
    public Customer getCustomer() {
        // Logic lấy dữ liệu khách hàng, ví dụ ở đây là mock data
        return new Customer(1,
                "viet hung",
                "0823210088",
                "johndoe@example.com",
                "abc.xyz.hanoi" );
    }
}
