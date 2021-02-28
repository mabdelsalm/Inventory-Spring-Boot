package com.inventory.sprintbootrestapi.jtest;

import com.inventory.sprintbootrestapi.controller.ItemController;
import com.inventory.sprintbootrestapi.model.Item;
import com.inventory.sprintbootrestapi.repository.ItemRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import static org.assertj.core.api.Assertions.assertThat;
@RunWith(JUnitPlatform.class)
@ExtendWith(MockitoExtension.class)
public class ItemsApiTest {
    @Autowired
    private MockMvc mockMvc;

    @InjectMocks
    private ItemController itemController;

    @Mock
    ItemRepository itemRepository;

    @Test
    public void addItem() throws Exception {
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));


        Item item = new Item("Test Item",1,"test-inventory-code");

        ResponseEntity<Item> responseEntity = itemController.createItem(item);

        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(201);

    }

    @Test
    public void getItem() throws Exception {
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

        long itemNo = 1;

        ResponseEntity<Item> responseEntity = itemController.getItemByNo(1);

        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);

    }

}
