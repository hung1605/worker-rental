package com.example.workerrental.service.impl;

import com.example.workerrental.converter.CustomerConverter;
import com.example.workerrental.dto.CustomerDTO;
import com.example.workerrental.repository.CustomerRepository;
import com.example.workerrental.repository.entity.CustomerEntity;
import com.example.workerrental.service.CustomerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {
    // Logic xử lý nghiệp vụ, trả về thông tin khách hàng

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private CustomerConverter customerConverter;

    @Override
    public CustomerDTO getCustomerById(Long id) {
        // Lấy đối tượng CustomerEntity từ DB theo id
        Optional<CustomerEntity> optionalCustomer = customerRepository.findById(id);
        if(optionalCustomer.isPresent()){
            CustomerEntity customerEntity = optionalCustomer.get();
            // Chuyển đổi từ entity sang DTO (giả sử có phương thức convertToDTO)
            return customerConverter.convertToDTO(customerEntity);
        }
        // Nếu không tìm thấy khách hàng, có thể ném exception hoặc xử lý theo yêu cầu
        throw new RuntimeException("Customer not found with id: " + id);
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        // Lấy tất cả các CustomerEntity từ DB
        List<CustomerEntity> customerEntities = customerRepository.findAll();
        // Chuyển đổi từng entity thành DTO
        return customerEntities.stream()
                .map(customerEntity ->  customerConverter.convertToDTO(customerEntity))
                .toList();
    }

    @Override
    public CustomerDTO createCustomer(CustomerDTO customerDTO) {
        // Chuyển đổi DTO thành Entity
        CustomerEntity entity = customerConverter.converterToEntity(customerDTO);
        // Lưu entity vào DB
        CustomerEntity savedEntity = customerRepository.save(entity);
        // Chuyển đổi entity đã lưu thành DTO và trả về
        return customerConverter.convertToDTO(savedEntity);
    }

    @Override
    public CustomerDTO updateCustomer(Long id, CustomerDTO customerDTO) {
        Optional<CustomerEntity> optionalCustomer = customerRepository.findById(id);
        if (optionalCustomer.isPresent()) {
            CustomerEntity customerEntity = optionalCustomer.get();
            // Update the customer entity's fields

            BeanUtils.copyProperties(customerDTO, customerEntity);

            CustomerEntity updatedEntity = customerRepository.save(customerEntity);

            // Trả về DTO của customer đã được cập nhật
            return customerConverter.convertToDTO(updatedEntity);
        } else {
            throw new RuntimeException("Customer not found with id: " + id);
        }
    }

    @Override
    public Boolean deleteCustomer(Long id) {
        Optional<CustomerEntity> optionalCustomer = customerRepository.findById(id);
        if (optionalCustomer.isPresent()) {
            // Xóa customer
            customerRepository.deleteById(id);
            return true;
        } else {
            return false; // Trả về false nếu không tìm thấy khách hàng với id
        }
    }
}
