package com.example.eshopapplication.web.rest;

import com.example.eshopapplication.model.Discount;
import com.example.eshopapplication.model.dto.DiscountDto;
import com.example.eshopapplication.service.DiscountService;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/discounts")
public class DiscountRestController {

    private final DiscountService discountService;

    public DiscountRestController(DiscountService discountService) {
        this.discountService = discountService;
    }

    @GetMapping
    public List<Discount> findAll() {
        return this.discountService.findAll();
    }

    @GetMapping("/pagination")
    public List<Discount> findAllWithPagination(Pageable pageable) {
        return this.discountService.findAllWithPagination(pageable).getContent();
    }

    /*
    *   https://localhost:9091/api/discounts/3 - PathVariable
    *   https://localhost:9091/api/discounts?id=3 - Request param
    * */

    @GetMapping("/{id}")
    public ResponseEntity<Discount> findById(@PathVariable Long id) {
        return this.discountService.findById(id)
                .map(discount -> ResponseEntity.ok().body(discount))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/add")
    public ResponseEntity<Discount> save(@RequestBody DiscountDto discountDto) {
        return this.discountService.save(discountDto)
                .map(discount -> ResponseEntity.ok().body(discount))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Discount> edit(@PathVariable Long id, @RequestBody DiscountDto discountDto) {
        return this.discountService.edit(id, discountDto)
                .map(discount -> ResponseEntity.ok().body(discount))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Discount> delete(@PathVariable Long id) {
        this.discountService.deleteById(id);
        if (this.discountService.findById(id).isEmpty())
            return ResponseEntity.ok().build();
        else
            return ResponseEntity.badRequest().build();
    }

    @PostMapping("/assign/{id}")
    public ResponseEntity<Discount> assignDiscount(@PathVariable Long id, @RequestParam String username) {
        return this.discountService.assignDiscount(username, id)
                .map(discount -> ResponseEntity.ok().body(discount))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }
}
