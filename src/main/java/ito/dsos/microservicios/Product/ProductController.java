package ito.dsos.microservicios.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/products")
public class ProductController {

    private ProductRepository repository;

    @Autowired
    public ProductController(ProductRepository productRepository){
        this.repository = productRepository;
    }

    @GetMapping("/product")
    public List<ProductEntity> all(){
        return repository.findAll();
    }

    @PostMapping("/product")
    public ResponseEntity<ProductEntity> post(@ModelAttribute ProductEntity product){
        ProductEntity productEntity = repository.save(product);
        if(product == null)
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(productEntity, HttpStatus.CREATED);
    }

    @Transactional
    @PutMapping("product/{id}")
    public ResponseEntity<ProductEntity> put(@PathVariable String id,
                                             @ModelAttribute ProductEntity product){
        ProductEntity productEntity = repository.findById(Long.parseLong(id))
                .orElseThrow(() -> new IllegalStateException("El producto no existe"));
        productEntity.setName(product.getName());
        productEntity.setPrice(product.getPrice());
        repository.save(productEntity);
        return new ResponseEntity<>(productEntity, HttpStatus.OK);
    }

    @PatchMapping("/product/{id}")
    public ResponseEntity<ProductEntity> patchPrice(@RequestBody Double price,
                                                    @PathVariable String id){
        ProductEntity productEntity = repository.findById(Long.parseLong(id))
                .orElseThrow(() -> new IllegalStateException("El producto no existe"));
        productEntity.setPrice(price);
        repository.save(productEntity);
        return new ResponseEntity<>(productEntity, HttpStatus.OK);
    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity<ProductEntity> delete(@PathVariable String id){
        repository.deleteById(Long.parseLong(id));
        return new ResponseEntity<>(null, HttpStatus.OK);
    }


}

