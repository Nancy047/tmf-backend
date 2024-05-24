package com.example.tmf666.Controller;



import java.util.List;
import java.util.Optional;

import com.example.tmf666.Entity.ApiProductOrder;
import com.example.tmf666.Repo.ApiProductOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api-orders")
@CrossOrigin("*")
public class ApiProductOrderController {

    @Autowired
    private ApiProductOrderRepository apiProductOrderRepository;

    @PostMapping("createOrder")
    public ResponseEntity<ApiProductOrder> createOrder(@RequestBody ApiProductOrder order) {
        ApiProductOrder savedOrder = apiProductOrderRepository.save(order);
        return ResponseEntity.ok(savedOrder);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<ApiProductOrder> getApiProductOrderById(@PathVariable Long id) {
        Optional<ApiProductOrder> orderOptional = apiProductOrderRepository.findById(id);
        if (orderOptional.isPresent()) {
            return ResponseEntity.ok(orderOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/getAll")
    public ResponseEntity<List<ApiProductOrder>> getAllOrders() {
        List<ApiProductOrder> orders = apiProductOrderRepository.findAll();
        return ResponseEntity.ok(orders);
    }

}
