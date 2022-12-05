package com.app.food.team.foodapp.controller;

import com.app.food.team.foodapp.dto.MenuConverterDto;
import com.app.food.team.foodapp.dto.RecipeDto;
import com.app.food.team.foodapp.dto.ResponseDto;
import com.app.food.team.foodapp.model.Item;
import com.app.food.team.foodapp.model.Menu;
import com.app.food.team.foodapp.model.RecipeApiWrapper;
import com.app.food.team.foodapp.repository.MenuRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.Set;

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

    @PostMapping(path = "menu", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createItemIfNotExists(@RequestBody List<RecipeApiWrapper> data) {
        log.info("[ItemController] ----> /data/menu");

        // MenuConvertDto unwraps the recipe objects and saves a set of them in a menu
        MenuConverterDto menuData = new MenuConverterDto(data);
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

    // example arguments
    // @RequestHeader(value="User-Agent") String userAgent
    // @RequestParam(value = "ID", defaultValue = "") String id
    // returns recipe close to edamam format, some nested data displayed differently like tags for diet labels, etc
    @GetMapping(path = "menu/items", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<RecipeApiWrapper> getItemByInternalId(@RequestParam(value = "internalId") int internalId){
        log.info("[ItemController] ----> data/item");

        ;
        Optional<Menu> optionalMenu = menuRepo.findById(internalId);
        Menu menu = new Menu();
        if (optionalMenu.isPresent()) {
            menu = optionalMenu.get();
        }
        return new MenuConverterDto(menu).getWrappedMenuItems();
    }
}
