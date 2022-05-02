package com.shoppingservice.shopping_service.controller.admin;

import com.shoppingservice.shopping_service.controller.RequestPojo.ResponseObject;
import com.shoppingservice.shopping_service.model.entity.Product;
import com.shoppingservice.shopping_service.service.IStorageService;
import com.shoppingservice.shopping_service.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("api/admin/product")
public class ProductImageAdminController {
    @Autowired
    private IStorageService storageService;
    @Autowired
    private ProductService productServices;

    @PostMapping("/create-with-img")
    public ResponseEntity<ResponseObject> createProduct(
            @RequestParam("name") String name,
            @RequestParam("price") String price,
            @RequestParam("category_id") String category_id,
            @RequestParam("description") String description,
            @RequestParam("image") MultipartFile file){
        try {
            String generatedFileName = storageService.storeFile(file);
            Product products = Product.builder()
                    .name(name)
                    .price(price)
                    .category_id(category_id)
                    .description(description)
                    .image(generatedFileName)
                    .build();

            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("ok", "Create pruduct successfully!",
                            productServices.createProduct(products))
            );
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                    new ResponseObject("failed", e.getMessage(), "")
            );
        }
    }

    //get image's url
    @GetMapping("/image/{fileName:.+}")
    public ResponseEntity<byte[]> readDetailFile(@PathVariable String fileName){
        try{
            byte[] bytes = storageService.readFileContent(fileName);
            return ResponseEntity
                    .ok()
                    .contentType(MediaType.IMAGE_JPEG)
                    .body(bytes);
        }catch (Exception exception){
            return ResponseEntity.noContent().build();
        }
    }
}
