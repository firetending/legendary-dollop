package com.app.food.team.foodapp.controller;

import com.app.food.team.foodapp.dto.ResponseDto;
import com.app.food.team.foodapp.model.menurecipemodel.Item;
import com.app.food.team.foodapp.model.menurecipemodel.RecipeApiWrapper;
import com.app.food.team.foodapp.repository.menureciperepository.ItemRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Optional;

import static java.time.LocalDateTime.now;
import static org.springframework.http.HttpStatus.OK;

@Slf4j
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*") // replace this with cors config in SecurityConfiguration
@RequestMapping("${app.request-mapping}data/")
@AllArgsConstructor
public class ItemController {

    @Autowired
    private ItemRepository itemRepo;

    @PostMapping(path = "item", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createItemIfNotExists(@RequestBody RecipeApiWrapper recipeApiObj) {
        log.info("[ItemController] ----> /data/item");

        // parse inner json into Item object {"recipe":{recipe Json}
        Item newItem = recipeApiObj.getRecipe();
        // parse externalId from uri
        newItem.setExternalId();

        //declarations for ResponseDto builder variables
        String message = "";
        String externalId = newItem.getExternalId();
        String label = newItem.getLabel();
        int internalId;

        //save item or respond that it exists
        if (!itemRepo.existsByExternalId(externalId)) {
            itemRepo.save(newItem);
            message = "Item saved!";
            internalId = newItem.getInternalId();
        } else {
            message = "Item already exists, no action needed";
            internalId = itemRepo.findByExternalId(externalId).getInternalId();
        }

        //response
        return ResponseEntity.ok(
                ResponseDto.builder().timeStamp(now()).status(OK).statusCode(OK.value())
                        .message(message)
                        .data(new HashMap<>(){{
                            put("internal id", internalId);
                            put("externalId", externalId);
                            put("label", label);;
                        }})
                        .build()
        );
    }

    // example arguments
    // @RequestHeader(value="User-Agent") String userAgent
    // @RequestParam(value = "ID", defaultValue = "") String id
    // returns recipe close to edamam format, some nested data displayed differently like tags for diet labels, etc
    @GetMapping(path = "item", produces = MediaType.APPLICATION_JSON_VALUE)
    public RecipeApiWrapper getItemByInternalId(@RequestParam(value = "internalId") int internalId){
        log.info("[ItemController] ----> data/item");

        RecipeApiWrapper wrappedRecipe = new RecipeApiWrapper();
        Optional<Item> item = itemRepo.findById(internalId);
        item.ifPresent(wrappedRecipe::setRecipe);
        return wrappedRecipe;
    }
}
