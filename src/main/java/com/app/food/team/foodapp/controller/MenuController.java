package com.app.food.team.foodapp.controller;

import com.app.food.team.foodapp.dto.MenuConverterDto;
import com.app.food.team.foodapp.dto.ResponseDto;
import com.app.food.team.foodapp.model.Item;
import com.app.food.team.foodapp.model.Menu;
import com.app.food.team.foodapp.model.RecipeApiWrapper;
import com.app.food.team.foodapp.repository.ItemRepository;
import com.app.food.team.foodapp.repository.MenuRepository;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import static java.time.LocalDateTime.now;
import static org.springframework.http.HttpStatus.OK;

@Slf4j
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*") // replace this with cors config in SecurityConfiguration
@RequestMapping("${app.request-mapping}data/")
@AllArgsConstructor
public class MenuController {

    @Autowired
    private MenuRepository menuRepo;
    @Autowired
    private ItemRepository itemRepo;

    @PostMapping(path = "menu/new", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createNewMenu(@RequestBody List<RecipeApiWrapper> data) {
        log.info("[MenuController] ----> /data/menu/new");

        // MenuConvertDto unwraps the recipe objects and saves a set of them in a menu
        MenuConverterDto menuData = new MenuConverterDto(data);
        checkForPersistedMenuItems(menuData);
        Menu newMenu = menuData.getMenu();

        //declarations for ResponseDto builder variables
        String message = "";
        int internalId;

        //save new menu
        menuRepo.save(newMenu);
        message = "New menu saved!";
        internalId = newMenu.getInternalId();

        //response
        return ResponseEntity.ok(
                ResponseDto.builder().timeStamp(now()).status(OK).statusCode(OK.value())
                        .message(message)
                        .data(new HashMap<>(){{
                            put("internal id", internalId);
                        }})
                        .build()
        );
    }

    @PostMapping(path = "menu/update", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateMenu(@RequestParam int id,
                                     @RequestBody List<RecipeApiWrapper> data) {
        log.info("[MenuController] ----> /data/menu/update");

        //declarations for ResponseDto builder variables
        String message = "";

        //check for existing menu by id
        Optional<Menu> menuCheck = menuRepo.findById(id);
        Menu existingMenu = new Menu();

        //if present, unwrap new data and put it in existing menu
        if (menuCheck.isPresent()) {
            existingMenu = menuCheck.get();

            // MenuConvertDto unwraps the recipe objects and saves a set of them in a menu
            MenuConverterDto menuData = new MenuConverterDto(data);
            checkForPersistedMenuItems(menuData);
            existingMenu.setMenuItems(menuData.getMenuItems());

            //save menu
            menuRepo.save(existingMenu);
            message = "Menu updated";
        } else {
            message = "No menu with that id was found";
        }

        return ResponseEntity.ok(
                ResponseDto.builder().timeStamp(now()).status(OK).statusCode(OK.value())
                        .message(message)
                        .data(new HashMap<>(){{
                            put("internal id", id);
                        }})
                        .build()
        );
    }

    @GetMapping(path = "menu/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Menu> getAllMenus() {
        return menuRepo.findAll();
    }

//    @GetMapping(path = "menu/all", produces = MediaType.APPLICATION_JSON_VALUE)
//    public String getAllMenuMetadata() {
//        menuRepo.findAll()
//        return "";
//    }

    @GetMapping(path = "menu", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getMenuById(@RequestParam int id) {
        Optional<Menu> optExistingMenu = menuRepo.findById(id);
        String responseJson = "";
        if (optExistingMenu.isPresent()) {
            responseJson = new Gson().toJson(new MenuConverterDto(optExistingMenu.get()));
        } else {
            responseJson = "No menu with that id was found";
        }

        return responseJson;
    }



    // example arguments
    // @RequestHeader(value="User-Agent") String userAgent
    // @RequestParam(value = "ID", defaultValue = "") String id
    // returns recipe close to edamam format, some nested data displayed differently like tags for diet labels, etc
    @GetMapping(path = "menu/items", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<RecipeApiWrapper> getItemByInternalId(@RequestParam(value = "internalId") int internalId){
        log.info("[MenuController] ----> data/item");

        Optional<Menu> optionalMenu = menuRepo.findById(internalId);
        Menu menu = new Menu();
        if (optionalMenu.isPresent()) {
            menu = optionalMenu.get();
        }
        return new MenuConverterDto(menu).getWrappedMenuItemsForJSON();
    }


    //utility methods
    public List<Item> checkForPersistedMenuItems(MenuConverterDto menuData) {

        //check if recipes exist in database; fill in existing recipes where possible
        List<Item> menuDataItems = menuData.getMenuItems();
        for (int i = 0; i<menuDataItems.size(); i++) {
            String checkExternalId = menuDataItems.get(i).getExternalId();
            if (itemRepo.existsByExternalId(checkExternalId)) {
                menuDataItems.set(i,itemRepo.findByExternalId(checkExternalId));
            }
        }
        return menuDataItems;
    }
}
