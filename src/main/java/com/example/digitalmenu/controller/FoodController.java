package com.example.digitalmenu.controller;
import com.example.digitalmenu.model.Food;
import com.example.digitalmenu.repository.FoodRepository;
import com.example.digitalmenu.dto.FoodRequestDTO;
import com.example.digitalmenu.dto.FoodResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("food")
@CrossOrigin(origins = "*")
public class FoodController {

    @Autowired
    private FoodRepository repository;

    @GetMapping
    public List<FoodResponseDTO> getAll(){
        List<FoodResponseDTO> foodList = repository.findAll().stream().map(FoodResponseDTO::new).toList();
        return foodList;
    }

    @PostMapping
    public void saveFood(@RequestBody FoodRequestDTO data){
        Food foodData = new Food(data);
        repository.save(foodData);
        return;
    }

    @GetMapping("food/{id}")
    public void findById(@PathVariable("id") Long id){
        repository.findById(id);
    }

//    @GetMapping("food/{title}"){
//        public Food getOneFood(@PathVariable("title") String title){
//            return repository.findByTitle(title);
//        }
//    }

}