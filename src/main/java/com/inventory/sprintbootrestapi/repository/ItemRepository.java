package com.inventory.sprintbootrestapi.repository;
import com.inventory.sprintbootrestapi.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item,Long> {

}
