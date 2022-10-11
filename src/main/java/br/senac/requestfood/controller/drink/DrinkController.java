package br.senac.requestfood.controller.drink;

import java.io.IOException;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import br.senac.requestfood.dto.drink.DrinkDTO;
import br.senac.requestfood.dto.drink.DrinkImageDTO;
import br.senac.requestfood.projection.drink.DrinkProjection;
import br.senac.requestfood.service.drink.DrinkService;
import br.senac.requestfood.util.ImageUtil;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/drink")
public class DrinkController {

    private final DrinkService service;

    public DrinkController(DrinkService drinkService) {
        this.service = drinkService;
    }

    @PostMapping()
    public ResponseEntity<DrinkDTO> addDrink(@RequestBody DrinkDTO drinkDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(drinkDto));
    }
    
    @PostMapping("/image/{id}")
	public ResponseEntity<String> addDrinkImage(@RequestParam("image") MultipartFile file, @PathVariable(value = "id") Long id) throws IOException{
		service.saveImage(ImageUtil.compressBytes(file.getBytes()), id);
		return ResponseEntity.status(HttpStatus.OK).body("Establishment image registered successfully");
	}
    
    @GetMapping("/getImage/{id}")
	public ResponseEntity<DrinkImageDTO> getDrinkImage(@PathVariable Long id) throws IOException {
		return ResponseEntity.status(HttpStatus.OK).body(service.findByIdImage(id));
	}

    @PutMapping("/{id}")
    public ResponseEntity<String> updatedDrink(@RequestBody DrinkDTO drinkDTO, @PathVariable(value = "id") Long id) {
        service.update(drinkDTO, id);
        return ResponseEntity.status(HttpStatus.OK).body("Drink updated successfully");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletedDrink(@PathVariable(value = "id") Long id) {
        service.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("Drink deleted successfully");
    }

    @GetMapping()
    public ResponseEntity<List<DrinkProjection>> getAllDrink() {
    	return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<DrinkProjection> getDrink(@PathVariable(value = "id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(service.findById(id));
    }
	
}
