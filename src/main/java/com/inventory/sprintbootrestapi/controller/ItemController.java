package com.inventory.sprintbootrestapi.controller;

import com.inventory.sprintbootrestapi.model.Item;
import com.inventory.sprintbootrestapi.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ItemController {

    @Autowired
    private ItemRepository itemRepository;

    @CrossOrigin("*")
    @GetMapping("/items")
    public ResponseEntity<List<Item>> getAllItems() {
        try {
            //get items
            List<Item> items = new ArrayList<Item>();

            itemRepository.findAll().forEach(items::add);
            if (items.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(items, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @CrossOrigin("*")
    @GetMapping("/items/{id}")
    public ResponseEntity<Item> getItemByNo(@PathVariable("id") long id) {
        Optional<Item> item = itemRepository.findById(id);

        if (item.isPresent()) {
            return new ResponseEntity<Item>(item.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @CrossOrigin("*")
    @PostMapping("/items")
    public ResponseEntity<Item> createItem(@RequestBody Item item) {
        try {
            if(item!=null){
                Item saveResult = itemRepository
                        .save(item);
                return new ResponseEntity<>(saveResult, HttpStatus.CREATED);
            }else{
                return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
            }

        } catch (Exception e) {
            System.out.println(e.getStackTrace());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @CrossOrigin("*")
    @PutMapping("/items/deposit/{id}")
    public ResponseEntity<Item> depositItem(@PathVariable("id") long id, long amount) {

        if(amount<=0){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        Optional<Item> item = itemRepository.findById(id);

        if (item.isPresent()) {
            Item _item = item.get();
            _item.setAmount(_item.getAmount()+amount);

            return new ResponseEntity<>(itemRepository.save(_item), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @CrossOrigin("*")
    @PutMapping("/items/withdraw/{id}")
    public ResponseEntity<Item> withdrawItem(@PathVariable("id") long id, long amount) {

        if(amount<=0){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        Optional<Item> item = itemRepository.findById(id);

        if (item.isPresent()) {
            Item _item = item.get();
            _item.setAmount(_item.getAmount()-amount);

            return new ResponseEntity<>(itemRepository.save(_item), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @CrossOrigin("*")
    @PutMapping("/items/{id}")
    public ResponseEntity<Item> updateItem(@PathVariable("id") long id, @RequestBody Item item) {
        Optional<Item> itemData = itemRepository.findById(id);

        if (itemData.isPresent()) {
            Item _item = itemData.get();
            _item.setName(item.getName());
            _item.setAmount(item.getAmount());
            _item.setInventoryCode(item.getInventoryCode());
            return new ResponseEntity<>(itemRepository.save(_item), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @CrossOrigin("*")
    @DeleteMapping("/items/{id}")
    public ResponseEntity<HttpStatus> deleteItem(@PathVariable("id") long id) {
        try {
            itemRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
