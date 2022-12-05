package com.app.food.team.foodapp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "items")
@AllArgsConstructor @NoArgsConstructor
public class Item extends AbstractEntity {

    private String externalId; //parse from uri; api doc says field exists but doesn't respond with it
    private @NonNull @Getter @Setter @EqualsAndHashCode.Include String uri; //edamam path, have to parse id after #  http://www.edamam.com/ontologies/edamam.owl#recipe_b5e1c34c9042a35a534069f438ec86fc
    private @NonNull @Getter @Setter String label; //title
    @Column(length=3000)
    private @NonNull @Getter @Setter String image;
    //        "images": {
    //        "THUMBNAIL": {
    //        "url": "string",
    //        "width": 0,
    //        "height": 0
    //        },
    //        "SMALL": {
    //        "url": "string",
    //        "width": 0,
    //        "height": 0
    //        },
    //        "REGULAR": {
    //        "url": "string",
    //        "width": 0,
    //        "height": 0
    //        },
    //        "LARGE": {
    //        "url": "string",
    //        "width": 0,
    //        "height": 0
    //        }
    //        },
    //        "source": "string",
    //        "url": "string",
    //        "shareAs": "string",
    private @Getter @Setter int yield;

    @ManyToMany(cascade = CascadeType.PERSIST)
    private @NonNull @Getter @Setter TagDietLabel[] dietLabels;
//    @ManyToOne
//    private @NonNull @Getter @Setter Set<TagHealthLabel> healthLabels;
//    @ManyToOne
//    private @NonNull @Getter @Setter Set<TagCautionLabel> cautions;
//    @Column(length = 1000)
//    private @NonNull @Getter @Setter List<String> ingredientLines;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private @NonNull @Getter @Setter List<ItemIngredient> ingredients = new ArrayList<>();
    //        [
        //        {
        //        "text": "string",
        //        "quantity": 0,
        //        "measure": "string",
        //        "food": "string",
        //        "weight": 0,
        //        "foodId": "string"
        //        }
    //        ],
    private @Getter @Setter int calories;
    private @Getter @Setter int glycemicIndex;
//    private int totalCO2Emissions;
    //        "co2EmissionsClass": "A+",
    private @Getter @Setter float totalWeight;
//    @ManyToOne
//    private @NonNull @Getter @Setter Set<TagCuisineType> cuisineType;
//    @ManyToOne
//    private @NonNull @Getter @Setter Set<TagMealType> mealType;
//    @ManyToOne
//    private @NonNull @Getter @Setter Set<TagDishType> dishType;
    //        "instructions": [
    //        "string"
    //        ],
    private @NonNull @Getter @Setter List<String> tags;
    //        "externalId": "string",
    //        "totalNutrients": {},
    //        "totalDaily": {},
    //        "digest": [
    //        {
    //        "label": "string",
    //        "tag": "string",
    //        "schemaOrgTag": "string",
    //        "total": 0,
    //        "hasRDI": true,
    //        "daily": 0,
    //        "unit": "string",
    //        "sub": {}
    //        }
    //        ]

//this.externalId = uri.substring(uri.indexOf('#'),uri.length()-1);

    public boolean setExternalId() {
        this.externalId = this.uri.substring(this.uri.indexOf('#')+1);
        return true;
    }
    public String getExternalId() { return externalId;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Item item = (Item) o;

        return getUri().equals(item.getUri());
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + getUri().hashCode();
        return result;
    }

//    @Override
//    public String toString() {
//        return "Item{" +
//                "\nexternalId='" + externalId + '\'' +
//                ",\nuri='" + uri + '\'' +
//                ",\nlabel='" + label + '\'' +
//                ",\nimage='" + image + '\'' +
//                ",\nyield=" + yield +
//                ",\ndietLabels=" + dietLabels +
//                ",\nhealthLabels=" + healthLabels +
//                ",\ncautions=" + cautions +
//                ",\ningredientLines=" + ingredientLines +
//                ",\ningredients=" + ingredients +
//                ",\ncalories=" + calories +
//                ",\nglycemicIndex=" + glycemicIndex +
//                ",\ntotalWeight=" + totalWeight +
//                ",\ncuisineType=" + cuisineType +
//                ",\nmealType=" + mealType +
//                ",\ndishType=" + dishType +
//                ",\ntags=" + tags +
//                '}';
//    }
}


//  https://developer.edamam.com/edamam-docs-recipe-api#/
//    Returns the nutritional information for given recipe.
//
//        Response Class (Status 200)
//        ModelModel Schema
//        {
    //        "recipe": {
    //        "uri": "string",
    //        "label": "string",
    //        "image": "string",
    //        "images": {
        //        "THUMBNAIL": {
        //        "url": "string",
        //        "width": 0,
        //        "height": 0
        //        },
        //        "SMALL": {
        //        "url": "string",
        //        "width": 0,
        //        "height": 0
        //        },
        //        "REGULAR": {
        //        "url": "string",
        //        "width": 0,
        //        "height": 0
        //        },
        //        "LARGE": {
        //        "url": "string",
        //        "width": 0,
        //        "height": 0
        //        }
    //        },
    //        "source": "string",
    //        "url": "string",
    //        "shareAs": "string",
    //        "yield": 0,
    //        "dietLabels": [
        //        "string"
        //        ],
    //        "healthLabels": [
        //        "string"
        //        ],
    //        "cautions": [
        //        "string"
        //        ],
    //        "ingredientLines": [
        //        "string"
        //        ],
    //        "ingredients": [
        //        {
        //        "text": "string",
        //        "quantity": 0,
        //        "measure": "string",
        //        "food": "string",
        //        "weight": 0,
        //        "foodId": "string"
        //        }
    //        ],
    //        "calories": 0,
    //        "glycemicIndex": 0,
    //        "totalCO2Emissions": 0,
    //        "co2EmissionsClass": "A+",
    //        "totalWeight": 0,
    //        "cuisineType": [
        //        "string"
    //        ],
    //        "mealType": [
        //        "string"
    //        ],
    //        "dishType": [
        //        "string"
    //        ],
    //        "instructions": [
        //        "string"
    //        ],
    //        "tags": [
        //        "string"
    //        ],
    //        "externalId": "string",
    //        "totalNutrients": {},
    //        "totalDaily": {},
    //        "digest": [
        //        {
        //        "label": "string",
        //        "tag": "string",
        //        "schemaOrgTag": "string",
        //        "total": 0,
        //        "hasRDI": true,
        //        "daily": 0,
        //        "unit": "string",
        //        "sub": {}
        //        }
    //        ]
    //        },
    //        "_links": {
    //        "self": {
    //        "href": "string",
    //        "title": "string"
    //        },
    //        "next": {
    //        "href": "string",
    //        "title": "string"
    //        }
    //        }
//        }




//example
//{
//        "recipe": {
//        "uri": "http://www.edamam.com/ontologies/edamam.owl#recipe_b5e1c34c9042a35a534069f438ec86fc",
//        "label": "Popeye Tso's Chicken (General Tso's Chicken Made with Popeye's Chicken Nuggets) Recipe",
//        "image": "https://edamam-product-images.s3.amazonaws.com/web-img/0c5/0c5ba5e925e8de4a16deaa1864cb1812.jpg?X-Amz-Security-Token=IQoJb3JpZ2luX2VjECAaCXVzLWVhc3QtMSJHMEUCIQDLW6bd12bucpnAQ1ofmP1V2Jn%2Bd8JHjNnRRYLeDNNCLQIgV9fun4sNOchue3AF2Ajd9KQe3y39GnhVfk4oKbwSp88qzAQIORAAGgwxODcwMTcxNTA5ODYiDPo%2BEzrLzhV2DGEvPiqpBMeQTDrjE4ZmZ%2B%2F%2Fpza3EPaA8PwbyRxSuTaEdo1Yd0Vke4qApf02wPk4tj9Q0Dys7PKlxJGuZCt0Ykyc1ZA6EAKkwpxBZK7csuBerF93n9Hb9511%2FgG5x1dwoo19mQK1hL11BE0yUFLLzNoMgi5T15xA6u1Oe0AE3E08eKM798PBoexgq764dGOCtWNQcmS8LbTztcnoe4o6puwt7Tjc7AH9hzDU8AH20utr%2BVx%2FKnvJ4f%2F59GTKDeUnyfSQjoMj%2BadrQycNEDNpaaGGKfUdD0vTo21usuptihQLkmaziUAXhSEFZdPYKq5qer9D7FVWQR%2BNaEPrw2sTtYLWT%2BYgt3tg%2FMQMGAevSYZDEqerQuzPdFq8vDMA4DPoI2lVYtSdxbjF%2FXkLHJCBR%2Fnopqs8ObzXu8zmEZiWXWRumHfBebDA%2FF5OHh8f2OFcA1x%2BIHcghgyQOvpnmFfOZqiwI%2FM2v%2BmTZnnkTe0KFgzvwYA1bJRyjFAYlSAQlPKhdVhX5lHpVHhrY8oKEI1eYqHoHLbNPHxz8E0mLRjsFj3g3eSSYgV8bK6dYZSOwulom0%2BQC5KHGd86tzpaMN%2BCVF46WO0pWfu0dGJnnrWwp7cN8y14Nd4j40Zl35nJMb913G4szpHRlfko4uh38AXINXHQEqdHyEJ38Oi%2FKeXAwnh%2FbTXDJKxKuLHGf%2FEYegnIJsTMMA%2F%2BdAfDc%2BSyHzl%2BBzZrOmvqnfa9TCskeT1QFyUwoO6PnAY6qQF0zZyVHpcgvw4Bt6TuSVe43R%2BZO4VJUGL8kh5H5lo7khtY3kZLBz9DU1TotNaW2jDd1NGnz4ayOgMgiMpueVD5xGG1upzYXh4J7CyQhP2zOOGJzA%2Fe3liJinYDtwdMgCFvBVMuks4LBfi2nCgO1DDU3XBqPgL13%2F8IjffL4XBM9QiTJa8zLMZUyZA%2FCcihwnpWpBXK9nyAI%2Fv4Mb5%2FDPlvAntZGdzDz4pd&X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Date=20221127T235330Z&X-Amz-SignedHeaders=host&X-Amz-Expires=3600&X-Amz-Credential=ASIASXCYXIIFKGEQRWPM%2F20221127%2Fus-east-1%2Fs3%2Faws4_request&X-Amz-Signature=cb32cfa005bdec943471314225c3aa153ceabcf83cb15686b190745aa725546e",
//        "images": {
//        "THUMBNAIL": {
//        "url": "https://edamam-product-images.s3.amazonaws.com/web-img/0c5/0c5ba5e925e8de4a16deaa1864cb1812-s.jpg?X-Amz-Security-Token=IQoJb3JpZ2luX2VjECAaCXVzLWVhc3QtMSJHMEUCIQDLW6bd12bucpnAQ1ofmP1V2Jn%2Bd8JHjNnRRYLeDNNCLQIgV9fun4sNOchue3AF2Ajd9KQe3y39GnhVfk4oKbwSp88qzAQIORAAGgwxODcwMTcxNTA5ODYiDPo%2BEzrLzhV2DGEvPiqpBMeQTDrjE4ZmZ%2B%2F%2Fpza3EPaA8PwbyRxSuTaEdo1Yd0Vke4qApf02wPk4tj9Q0Dys7PKlxJGuZCt0Ykyc1ZA6EAKkwpxBZK7csuBerF93n9Hb9511%2FgG5x1dwoo19mQK1hL11BE0yUFLLzNoMgi5T15xA6u1Oe0AE3E08eKM798PBoexgq764dGOCtWNQcmS8LbTztcnoe4o6puwt7Tjc7AH9hzDU8AH20utr%2BVx%2FKnvJ4f%2F59GTKDeUnyfSQjoMj%2BadrQycNEDNpaaGGKfUdD0vTo21usuptihQLkmaziUAXhSEFZdPYKq5qer9D7FVWQR%2BNaEPrw2sTtYLWT%2BYgt3tg%2FMQMGAevSYZDEqerQuzPdFq8vDMA4DPoI2lVYtSdxbjF%2FXkLHJCBR%2Fnopqs8ObzXu8zmEZiWXWRumHfBebDA%2FF5OHh8f2OFcA1x%2BIHcghgyQOvpnmFfOZqiwI%2FM2v%2BmTZnnkTe0KFgzvwYA1bJRyjFAYlSAQlPKhdVhX5lHpVHhrY8oKEI1eYqHoHLbNPHxz8E0mLRjsFj3g3eSSYgV8bK6dYZSOwulom0%2BQC5KHGd86tzpaMN%2BCVF46WO0pWfu0dGJnnrWwp7cN8y14Nd4j40Zl35nJMb913G4szpHRlfko4uh38AXINXHQEqdHyEJ38Oi%2FKeXAwnh%2FbTXDJKxKuLHGf%2FEYegnIJsTMMA%2F%2BdAfDc%2BSyHzl%2BBzZrOmvqnfa9TCskeT1QFyUwoO6PnAY6qQF0zZyVHpcgvw4Bt6TuSVe43R%2BZO4VJUGL8kh5H5lo7khtY3kZLBz9DU1TotNaW2jDd1NGnz4ayOgMgiMpueVD5xGG1upzYXh4J7CyQhP2zOOGJzA%2Fe3liJinYDtwdMgCFvBVMuks4LBfi2nCgO1DDU3XBqPgL13%2F8IjffL4XBM9QiTJa8zLMZUyZA%2FCcihwnpWpBXK9nyAI%2Fv4Mb5%2FDPlvAntZGdzDz4pd&X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Date=20221127T235330Z&X-Amz-SignedHeaders=host&X-Amz-Expires=3600&X-Amz-Credential=ASIASXCYXIIFKGEQRWPM%2F20221127%2Fus-east-1%2Fs3%2Faws4_request&X-Amz-Signature=eed138fe4e441a8f5e4963364cfb9d18c1723f5a56b3a49640dbd1b232686701",
//        "width": 100,
//        "height": 100
//        },
//        "SMALL": {
//        "url": "https://edamam-product-images.s3.amazonaws.com/web-img/0c5/0c5ba5e925e8de4a16deaa1864cb1812-m.jpg?X-Amz-Security-Token=IQoJb3JpZ2luX2VjECAaCXVzLWVhc3QtMSJHMEUCIQDLW6bd12bucpnAQ1ofmP1V2Jn%2Bd8JHjNnRRYLeDNNCLQIgV9fun4sNOchue3AF2Ajd9KQe3y39GnhVfk4oKbwSp88qzAQIORAAGgwxODcwMTcxNTA5ODYiDPo%2BEzrLzhV2DGEvPiqpBMeQTDrjE4ZmZ%2B%2F%2Fpza3EPaA8PwbyRxSuTaEdo1Yd0Vke4qApf02wPk4tj9Q0Dys7PKlxJGuZCt0Ykyc1ZA6EAKkwpxBZK7csuBerF93n9Hb9511%2FgG5x1dwoo19mQK1hL11BE0yUFLLzNoMgi5T15xA6u1Oe0AE3E08eKM798PBoexgq764dGOCtWNQcmS8LbTztcnoe4o6puwt7Tjc7AH9hzDU8AH20utr%2BVx%2FKnvJ4f%2F59GTKDeUnyfSQjoMj%2BadrQycNEDNpaaGGKfUdD0vTo21usuptihQLkmaziUAXhSEFZdPYKq5qer9D7FVWQR%2BNaEPrw2sTtYLWT%2BYgt3tg%2FMQMGAevSYZDEqerQuzPdFq8vDMA4DPoI2lVYtSdxbjF%2FXkLHJCBR%2Fnopqs8ObzXu8zmEZiWXWRumHfBebDA%2FF5OHh8f2OFcA1x%2BIHcghgyQOvpnmFfOZqiwI%2FM2v%2BmTZnnkTe0KFgzvwYA1bJRyjFAYlSAQlPKhdVhX5lHpVHhrY8oKEI1eYqHoHLbNPHxz8E0mLRjsFj3g3eSSYgV8bK6dYZSOwulom0%2BQC5KHGd86tzpaMN%2BCVF46WO0pWfu0dGJnnrWwp7cN8y14Nd4j40Zl35nJMb913G4szpHRlfko4uh38AXINXHQEqdHyEJ38Oi%2FKeXAwnh%2FbTXDJKxKuLHGf%2FEYegnIJsTMMA%2F%2BdAfDc%2BSyHzl%2BBzZrOmvqnfa9TCskeT1QFyUwoO6PnAY6qQF0zZyVHpcgvw4Bt6TuSVe43R%2BZO4VJUGL8kh5H5lo7khtY3kZLBz9DU1TotNaW2jDd1NGnz4ayOgMgiMpueVD5xGG1upzYXh4J7CyQhP2zOOGJzA%2Fe3liJinYDtwdMgCFvBVMuks4LBfi2nCgO1DDU3XBqPgL13%2F8IjffL4XBM9QiTJa8zLMZUyZA%2FCcihwnpWpBXK9nyAI%2Fv4Mb5%2FDPlvAntZGdzDz4pd&X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Date=20221127T235330Z&X-Amz-SignedHeaders=host&X-Amz-Expires=3599&X-Amz-Credential=ASIASXCYXIIFKGEQRWPM%2F20221127%2Fus-east-1%2Fs3%2Faws4_request&X-Amz-Signature=b585325607cf0676549c49128d875afa5e0ce05fd110b0bf31b49b97b5dfca22",
//        "width": 200,
//        "height": 200
//        },
//        "REGULAR": {
//        "url": "https://edamam-product-images.s3.amazonaws.com/web-img/0c5/0c5ba5e925e8de4a16deaa1864cb1812.jpg?X-Amz-Security-Token=IQoJb3JpZ2luX2VjECAaCXVzLWVhc3QtMSJHMEUCIQDLW6bd12bucpnAQ1ofmP1V2Jn%2Bd8JHjNnRRYLeDNNCLQIgV9fun4sNOchue3AF2Ajd9KQe3y39GnhVfk4oKbwSp88qzAQIORAAGgwxODcwMTcxNTA5ODYiDPo%2BEzrLzhV2DGEvPiqpBMeQTDrjE4ZmZ%2B%2F%2Fpza3EPaA8PwbyRxSuTaEdo1Yd0Vke4qApf02wPk4tj9Q0Dys7PKlxJGuZCt0Ykyc1ZA6EAKkwpxBZK7csuBerF93n9Hb9511%2FgG5x1dwoo19mQK1hL11BE0yUFLLzNoMgi5T15xA6u1Oe0AE3E08eKM798PBoexgq764dGOCtWNQcmS8LbTztcnoe4o6puwt7Tjc7AH9hzDU8AH20utr%2BVx%2FKnvJ4f%2F59GTKDeUnyfSQjoMj%2BadrQycNEDNpaaGGKfUdD0vTo21usuptihQLkmaziUAXhSEFZdPYKq5qer9D7FVWQR%2BNaEPrw2sTtYLWT%2BYgt3tg%2FMQMGAevSYZDEqerQuzPdFq8vDMA4DPoI2lVYtSdxbjF%2FXkLHJCBR%2Fnopqs8ObzXu8zmEZiWXWRumHfBebDA%2FF5OHh8f2OFcA1x%2BIHcghgyQOvpnmFfOZqiwI%2FM2v%2BmTZnnkTe0KFgzvwYA1bJRyjFAYlSAQlPKhdVhX5lHpVHhrY8oKEI1eYqHoHLbNPHxz8E0mLRjsFj3g3eSSYgV8bK6dYZSOwulom0%2BQC5KHGd86tzpaMN%2BCVF46WO0pWfu0dGJnnrWwp7cN8y14Nd4j40Zl35nJMb913G4szpHRlfko4uh38AXINXHQEqdHyEJ38Oi%2FKeXAwnh%2FbTXDJKxKuLHGf%2FEYegnIJsTMMA%2F%2BdAfDc%2BSyHzl%2BBzZrOmvqnfa9TCskeT1QFyUwoO6PnAY6qQF0zZyVHpcgvw4Bt6TuSVe43R%2BZO4VJUGL8kh5H5lo7khtY3kZLBz9DU1TotNaW2jDd1NGnz4ayOgMgiMpueVD5xGG1upzYXh4J7CyQhP2zOOGJzA%2Fe3liJinYDtwdMgCFvBVMuks4LBfi2nCgO1DDU3XBqPgL13%2F8IjffL4XBM9QiTJa8zLMZUyZA%2FCcihwnpWpBXK9nyAI%2Fv4Mb5%2FDPlvAntZGdzDz4pd&X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Date=20221127T235330Z&X-Amz-SignedHeaders=host&X-Amz-Expires=3600&X-Amz-Credential=ASIASXCYXIIFKGEQRWPM%2F20221127%2Fus-east-1%2Fs3%2Faws4_request&X-Amz-Signature=cb32cfa005bdec943471314225c3aa153ceabcf83cb15686b190745aa725546e",
//        "width": 300,
//        "height": 300
//        }
//        },
//        "source": "Serious Eats",
//        "url": "http://www.seriouseats.com/recipes/2011/10/popeye-tsos-chicken-general-tsos-chicken-made-with-popeyes-chicken-nuggets-recipe.html",
//        "shareAs": "http://www.edamam.com/recipe/popeye-tso-s-chicken-general-tso-s-chicken-made-with-popeye-s-chicken-nuggets-recipe-b5e1c34c9042a35a534069f438ec86fc/-",
//        "yield": 4,
//        "dietLabels": [
//        "Balanced",
//        "High-Fiber"
//        ],
//        "healthLabels": [
//        "Dairy-Free",
//        "Egg-Free",
//        "Peanut-Free",
//        "Tree-Nut-Free",
//        "Fish-Free",
//        "Pork-Free",
//        "Crustacean-Free",
//        "Celery-Free",
//        "Mustard-Free",
//        "Lupine-Free",
//        "Mollusk-Free",
//        "Alcohol-Free",
//        "Kosher"
//        ],
//        "cautions": [
//        "Gluten",
//        "Wheat",
//        "Sulfites"
//        ],
//        "ingredientLines": [
//        "1/4 cup low sodium chicken stock",
//        "1 tablespoon soy sauce",
//        "1 tablespoon rice wine vinegar",
//        "2 tablespoons hoisin sauce",
//        "1 teaspoon Chinese chili paste",
//        "2 teaspoons sesame oil",
//        "3 tablespoons sugar",
//        "2 teaspoons cornstarch",
//        "2 tablespons vegetable oil",
//        "2 cloves minced garlic (about 2 teaspoons",
//        "1 teapsoon minced fresh ginger",
//        "A half dozen dried red whole chilis",
//        "18 to 24 pieces Popeye's Chicken Nuggets, or 3 order Popeye's Popcorn Shrimp",
//        "3 scallion greens, sliced"
//        ],
//        "ingredients": [
//        {
//        "text": "1/4 cup low sodium chicken stock",
//        "quantity": 0.25,
//        "measure": "cup",
//        "food": "low sodium chicken stock",
//        "weight": 60,
//        "foodCategory": "canned soup",
//        "foodId": "food_axg87lea13vni7a0lc9adauqgcs9",
//        "image": "https://www.edamam.com/food-img/2eb/2eb3c708f58f5fa1543022650ff0ae8d.png"
//        },
//        {
//        "text": "1 tablespoon soy sauce",
//        "quantity": 1,
//        "measure": "tablespoon",
//        "food": "soy sauce",
//        "weight": 16,
//        "foodCategory": "plant-based protein",
//        "foodId": "food_a5g9yevb1iactoaiimbvjbkrxueh",
//        "image": "https://www.edamam.com/food-img/f56/f562e461eb0618f367f538b836c17b82.jpg"
//        },
//        {
//        "text": "1 tablespoon rice wine vinegar",
//        "quantity": 1,
//        "measure": "tablespoon",
//        "food": "rice wine vinegar",
//        "weight": 14.9,
//        "foodCategory": "Condiments and sauces",
//        "foodId": "food_axlcd4tack2d20bveizm4ayu0h2w",
//        "image": "https://www.edamam.com/food-img/5f6/5f69b84c399d778c4728e9ab4f8065a2.jpg"
//        },
//        {
//        "text": "2 tablespoons hoisin sauce",
//        "quantity": 2,
//        "measure": "tablespoon",
//        "food": "hoisin sauce",
//        "weight": 32,
//        "foodCategory": "canned soup",
//        "foodId": "food_a50yq9jao6jvt5a4oxygsbmfbeuy",
//        "image": "https://www.edamam.com/food-img/c52/c529c507459e9133ad8689cec193f713.jpg"
//        },
//        {
//        "text": "1 teaspoon Chinese chili paste",
//        "quantity": 1,
//        "measure": "teaspoon",
//        "food": "chili paste",
//        "weight": 5.104166666925555,
//        "foodCategory": "canned soup",
//        "foodId": "food_ayjzfd9bhvwqorb6m5iq3bekq7cj",
//        "image": "https://www.edamam.com/food-img/12f/12f4b9a8e738f35b7dd787a5360e4a45.jpg"
//        },
//        {
//        "text": "2 teaspoons sesame oil",
//        "quantity": 2,
//        "measure": "teaspoon",
//        "food": "sesame oil",
//        "weight": 9,
//        "foodCategory": "Oils",
//        "foodId": "food_b2id9opa0l5afvbw2do5xa1fnz4q",
//        "image": "https://www.edamam.com/food-img/b87/b874ddcfb6770adc7a155355a902ffb8.jpg"
//        },
//        {
//        "text": "3 tablespoons sugar",
//        "quantity": 3,
//        "measure": "tablespoon",
//        "food": "sugar",
//        "weight": 37.4999999993661,
//        "foodCategory": "sugars",
//        "foodId": "food_axi2ijobrk819yb0adceobnhm1c2",
//        "image": "https://www.edamam.com/food-img/ecb/ecb3f5aaed96d0188c21b8369be07765.jpg"
//        },
//        {
//        "text": "2 teaspoons cornstarch",
//        "quantity": 2,
//        "measure": "teaspoon",
//        "food": "cornstarch",
//        "weight": 5.33333333360384,
//        "foodCategory": null,
//        "foodId": "food_bevnfkfbvjm45pbbgj9nsb3ypntm",
//        "image": "https://www.edamam.com/food-img/f9b/f9b74d9495b40c0aea955c37a1fc39dc.jpg"
//        },
//        {
//        "text": "2 tablespons vegetable oil",
//        "quantity": 2,
//        "measure": "<unit>",
//        "food": "vegetable",
//        "weight": 575.7575757575758,
//        "foodCategory": "vegetables",
//        "foodId": "food_bitqzx8b319psvbib2dufarphbxy",
//        "image": "https://www.edamam.com/food-img/f3f/f3fa6996eba331be219778406f67a5a3.jpg"
//        },
//        {
//        "text": "2 cloves minced garlic (about 2 teaspoons",
//        "quantity": 2,
//        "measure": "clove",
//        "food": "garlic",
//        "weight": 6,
//        "foodCategory": "vegetables",
//        "foodId": "food_avtcmx6bgjv1jvay6s6stan8dnyp",
//        "image": "https://www.edamam.com/food-img/6ee/6ee142951f48aaf94f4312409f8d133d.jpg"
//        },
//        {
//        "text": "1 teapsoon minced fresh ginger",
//        "quantity": 1,
//        "measure": "<unit>",
//        "food": "fresh ginger",
//        "weight": 60,
//        "foodCategory": "vegetables",
//        "foodId": "food_bi2ki2xb5zmmvbaiwf7ztbgktzp6",
//        "image": "https://www.edamam.com/food-img/b9c/b9c06ef451ef29513880af0a53ebbaa6.jpg"
//        },
//        {
//        "text": "A half dozen dried red whole chilis",
//        "quantity": 6,
//        "measure": "<unit>",
//        "food": "chilis",
//        "weight": 36.599999999999994,
//        "foodCategory": "vegetables",
//        "foodId": "food_akybxs9atrgwona5nz3jgbo3vor5",
//        "image": "https://www.edamam.com/food-img/e3d/e3d161d6cfe5ef287053aed5461738ba.jpg"
//        },
//        {
//        "text": "18 to 24 pieces Popeye's Chicken Nuggets, or 3 order Popeye's Popcorn Shrimp",
//        "quantity": 21,
//        "measure": "piece",
//        "food": "Chicken Nuggets",
//        "weight": 420,
//        "foodCategory": "frozen poultry",
//        "foodId": "food_bdxovpmabzq0y1b37dux7abl5muq",
//        "image": "https://www.edamam.com/food-img/853/853b7c281a7108739b5b987fe290e60e.jpg"
//        },
//        {
//        "text": "3 scallion greens, sliced",
//        "quantity": 3,
//        "measure": "<unit>",
//        "food": "scallion",
//        "weight": 45,
//        "foodCategory": "vegetables",
//        "foodId": "food_bknlkyzbuzo27pb11whr4bttkuy6",
//        "image": "https://www.edamam.com/food-img/b89/b89986ed6aa466285bdd99bac34b3c46.jpg"
//        }
//        ],
//        "calories": 1931.0363295440866,
//        "totalWeight": 1323.1950757574714,
//        "totalTime": 5,
//        "cuisineType": [
//        "chinese"
//        ],
//        "mealType": [
//        "lunch/dinner"
//        ],
//        "dishType": [
//        "main course"
//        ],
//        "totalNutrients": {
//        "ENERC_KCAL": {
//        "label": "Energy",
//        "quantity": 1931.0363295440866,
//        "unit": "kcal"
//        },
//        "FAT": {
//        "label": "Fat",
//        "quantity": 79.05377106060774,
//        "unit": "g"
//        },
//        "FASAT": {
//        "label": "Saturated",
//        "quantity": 16.44797975757599,
//        "unit": "g"
//        },
//        "FATRN": {
//        "label": "Trans",
//        "quantity": 0.34440000000000004,
//        "unit": "g"
//        },
//        "FAMS": {
//        "label": "Monounsaturated",
//        "quantity": 23.974984306819287,
//        "unit": "g"
//        },
//        "FAPU": {
//        "label": "Polyunsaturated",
//        "quantity": 31.899672719697232,
//        "unit": "g"
//        },
//        "CHOCDF": {
//        "label": "Carbs",
//        "quantity": 222.34300128750203,
//        "unit": "g"
//        },
//        "CHOCDF.net": {
//        "label": "Carbohydrates (net)",
//        "quantity": 191.4147690905281,
//        "unit": "g"
//        },
//        "FIBTG": {
//        "label": "Fiber",
//        "quantity": 30.928232196973948,
//        "unit": "g"
//        },
//        "SUGAR": {
//        "label": "Sugars",
//        "quantity": 55.29059624937398,
//        "unit": "g"
//        },
//        "SUGAR.added": {
//        "label": "Sugars, added",
//        "quantity": 37.42499999936737,
//        "unit": "g"
//        },
//        "PROCNT": {
//        "label": "Protein",
//        "quantity": 86.04007143939697,
//        "unit": "g"
//        },
//        "CHOLE": {
//        "label": "Cholesterol",
//        "quantity": 143.76000000000002,
//        "unit": "mg"
//        },
//        "NA": {
//        "label": "Sodium",
//        "quantity": 3965.9951022728096,
//        "unit": "mg"
//        },
//        "CA": {
//        "label": "Calcium",
//        "quantity": 380.18043560608294,
//        "unit": "mg"
//        },
//        "MG": {
//        "label": "Magnesium",
//        "quantity": 350.57531818185737,
//        "unit": "mg"
//        },
//        "K": {
//        "label": "Potassium",
//        "quantity": 3098.971560607516,
//        "unit": "mg"
//        },
//        "FE": {
//        "label": "Iron",
//        "quantity": 13.67346446969922,
//        "unit": "mg"
//        },
//        "ZN": {
//        "label": "Zinc",
//        "quantity": 6.602865340909579,
//        "unit": "mg"
//        },
//        "P": {
//        "label": "Phosphorus",
//        "quantity": 1353.9929696970464,
//        "unit": "mg"
//        },
//        "VITA_RAE": {
//        "label": "Vitamin A",
//        "quantity": 1570.5002007576354,
//        "unit": "µg"
//        },
//        "VITC": {
//        "label": "Vitamin C",
//        "quantity": 91.30343787886554,
//        "unit": "mg"
//        },
//        "THIA": {
//        "label": "Thiamin (B1)",
//        "quantity": 1.226208659090935,
//        "unit": "mg"
//        },
//        "RIBF": {
//        "label": "Riboflavin (B2)",
//        "quantity": 0.938598689394052,
//        "unit": "mg"
//        },
//        "NIA": {
//        "label": "Niacin (B3)",
//        "quantity": 38.368861848486404,
//        "unit": "mg"
//        },
//        "VITB6A": {
//        "label": "Vitamin B6",
//        "quantity": 2.3819731060609683,
//        "unit": "mg"
//        },
//        "FOLDFE": {
//        "label": "Folate equivalent (total)",
//        "quantity": 242.1291553030588,
//        "unit": "µg"
//        },
//        "FOLFD": {
//        "label": "Folate (food)",
//        "quantity": 242.1291553030588,
//        "unit": "µg"
//        },
//        "FOLAC": {
//        "label": "Folic acid",
//        "quantity": 0,
//        "unit": "µg"
//        },
//        "VITB12": {
//        "label": "Vitamin B12",
//        "quantity": 1.026,
//        "unit": "µg"
//        },
//        "VITD": {
//        "label": "Vitamin D",
//        "quantity": 0,
//        "unit": "µg"
//        },
//        "TOCPHA": {
//        "label": "Vitamin E",
//        "quantity": 5.850815000000931,
//        "unit": "mg"
//        },
//        "VITK1": {
//        "label": "Vitamin K",
//        "quantity": 141.35677916668402,
//        "unit": "µg"
//        },
//        "Sugar.alcohol": {
//        "label": "Sugar alcohol",
//        "quantity": 0,
//        "unit": "g"
//        },
//        "WATER": {
//        "label": "Water",
//        "quantity": 917.3796923487508,
//        "unit": "g"
//        }
//        },
//        "totalDaily": {
//        "ENERC_KCAL": {
//        "label": "Energy",
//        "quantity": 96.55181647720433,
//        "unit": "%"
//        },
//        "FAT": {
//        "label": "Fat",
//        "quantity": 121.62118624708883,
//        "unit": "%"
//        },
//        "FASAT": {
//        "label": "Saturated",
//        "quantity": 82.23989878787995,
//        "unit": "%"
//        },
//        "CHOCDF": {
//        "label": "Carbs",
//        "quantity": 74.11433376250068,
//        "unit": "%"
//        },
//        "FIBTG": {
//        "label": "Fiber",
//        "quantity": 123.7129287878958,
//        "unit": "%"
//        },
//        "PROCNT": {
//        "label": "Protein",
//        "quantity": 172.08014287879394,
//        "unit": "%"
//        },
//        "CHOLE": {
//        "label": "Cholesterol",
//        "quantity": 47.92000000000001,
//        "unit": "%"
//        },
//        "NA": {
//        "label": "Sodium",
//        "quantity": 165.24979592803373,
//        "unit": "%"
//        },
//        "CA": {
//        "label": "Calcium",
//        "quantity": 38.01804356060829,
//        "unit": "%"
//        },
//        "MG": {
//        "label": "Magnesium",
//        "quantity": 83.47031385282318,
//        "unit": "%"
//        },
//        "K": {
//        "label": "Potassium",
//        "quantity": 65.93556511930885,
//        "unit": "%"
//        },
//        "FE": {
//        "label": "Iron",
//        "quantity": 75.963691498329,
//        "unit": "%"
//        },
//        "ZN": {
//        "label": "Zinc",
//        "quantity": 60.02604855372345,
//        "unit": "%"
//        },
//        "P": {
//        "label": "Phosphorus",
//        "quantity": 193.42756709957808,
//        "unit": "%"
//        },
//        "VITA_RAE": {
//        "label": "Vitamin A",
//        "quantity": 174.50002230640393,
//        "unit": "%"
//        },
//        "VITC": {
//        "label": "Vitamin C",
//        "quantity": 101.4482643098506,
//        "unit": "%"
//        },
//        "THIA": {
//        "label": "Thiamin (B1)",
//        "quantity": 102.18405492424458,
//        "unit": "%"
//        },
//        "RIBF": {
//        "label": "Riboflavin (B2)",
//        "quantity": 72.19989918415784,
//        "unit": "%"
//        },
//        "NIA": {
//        "label": "Niacin (B3)",
//        "quantity": 239.80538655304002,
//        "unit": "%"
//        },
//        "VITB6A": {
//        "label": "Vitamin B6",
//        "quantity": 183.22870046622833,
//        "unit": "%"
//        },
//        "FOLDFE": {
//        "label": "Folate equivalent (total)",
//        "quantity": 60.5322888257647,
//        "unit": "%"
//        },
//        "VITB12": {
//        "label": "Vitamin B12",
//        "quantity": 42.75000000000001,
//        "unit": "%"
//        },
//        "VITD": {
//        "label": "Vitamin D",
//        "quantity": 0,
//        "unit": "%"
//        },
//        "TOCPHA": {
//        "label": "Vitamin E",
//        "quantity": 39.00543333333954,
//        "unit": "%"
//        },
//        "VITK1": {
//        "label": "Vitamin K",
//        "quantity": 117.79731597223669,
//        "unit": "%"
//        }
//        },
//        "digest": [
//        {
//        "label": "Fat",
//        "tag": "FAT",
//        "schemaOrgTag": "fatContent",
//        "total": 79.05377106060774,
//        "hasRDI": true,
//        "daily": 121.62118624708883,
//        "unit": "g",
//        "sub": [
//        {
//        "label": "Saturated",
//        "tag": "FASAT",
//        "schemaOrgTag": "saturatedFatContent",
//        "total": 16.44797975757599,
//        "hasRDI": true,
//        "daily": 82.23989878787995,
//        "unit": "g"
//        },
//        {
//        "label": "Trans",
//        "tag": "FATRN",
//        "schemaOrgTag": "transFatContent",
//        "total": 0.34440000000000004,
//        "hasRDI": false,
//        "daily": 0,
//        "unit": "g"
//        },
//        {
//        "label": "Monounsaturated",
//        "tag": "FAMS",
//        "schemaOrgTag": null,
//        "total": 23.974984306819287,
//        "hasRDI": false,
//        "daily": 0,
//        "unit": "g"
//        },
//        {
//        "label": "Polyunsaturated",
//        "tag": "FAPU",
//        "schemaOrgTag": null,
//        "total": 31.899672719697232,
//        "hasRDI": false,
//        "daily": 0,
//        "unit": "g"
//        }
//        ]
//        },
//        {
//        "label": "Carbs",
//        "tag": "CHOCDF",
//        "schemaOrgTag": "carbohydrateContent",
//        "total": 222.34300128750203,
//        "hasRDI": true,
//        "daily": 74.11433376250068,
//        "unit": "g",
//        "sub": [
//        {
//        "label": "Carbs (net)",
//        "tag": "CHOCDF.net",
//        "schemaOrgTag": null,
//        "total": 191.4147690905281,
//        "hasRDI": false,
//        "daily": 0,
//        "unit": "g"
//        },
//        {
//        "label": "Fiber",
//        "tag": "FIBTG",
//        "schemaOrgTag": "fiberContent",
//        "total": 30.928232196973948,
//        "hasRDI": true,
//        "daily": 123.7129287878958,
//        "unit": "g"
//        },
//        {
//        "label": "Sugars",
//        "tag": "SUGAR",
//        "schemaOrgTag": "sugarContent",
//        "total": 55.29059624937398,
//        "hasRDI": false,
//        "daily": 0,
//        "unit": "g"
//        },
//        {
//        "label": "Sugars, added",
//        "tag": "SUGAR.added",
//        "schemaOrgTag": null,
//        "total": 37.42499999936737,
//        "hasRDI": false,
//        "daily": 0,
//        "unit": "g"
//        }
//        ]
//        },
//        {
//        "label": "Protein",
//        "tag": "PROCNT",
//        "schemaOrgTag": "proteinContent",
//        "total": 86.04007143939697,
//        "hasRDI": true,
//        "daily": 172.08014287879394,
//        "unit": "g"
//        },
//        {
//        "label": "Cholesterol",
//        "tag": "CHOLE",
//        "schemaOrgTag": "cholesterolContent",
//        "total": 143.76000000000002,
//        "hasRDI": true,
//        "daily": 47.92000000000001,
//        "unit": "mg"
//        },
//        {
//        "label": "Sodium",
//        "tag": "NA",
//        "schemaOrgTag": "sodiumContent",
//        "total": 3965.9951022728096,
//        "hasRDI": true,
//        "daily": 165.24979592803373,
//        "unit": "mg"
//        },
//        {
//        "label": "Calcium",
//        "tag": "CA",
//        "schemaOrgTag": null,
//        "total": 380.18043560608294,
//        "hasRDI": true,
//        "daily": 38.01804356060829,
//        "unit": "mg"
//        },
//        {
//        "label": "Magnesium",
//        "tag": "MG",
//        "schemaOrgTag": null,
//        "total": 350.57531818185737,
//        "hasRDI": true,
//        "daily": 83.47031385282318,
//        "unit": "mg"
//        },
//        {
//        "label": "Potassium",
//        "tag": "K",
//        "schemaOrgTag": null,
//        "total": 3098.971560607516,
//        "hasRDI": true,
//        "daily": 65.93556511930885,
//        "unit": "mg"
//        },
//        {
//        "label": "Iron",
//        "tag": "FE",
//        "schemaOrgTag": null,
//        "total": 13.67346446969922,
//        "hasRDI": true,
//        "daily": 75.963691498329,
//        "unit": "mg"
//        },
//        {
//        "label": "Zinc",
//        "tag": "ZN",
//        "schemaOrgTag": null,
//        "total": 6.602865340909579,
//        "hasRDI": true,
//        "daily": 60.02604855372345,
//        "unit": "mg"
//        },
//        {
//        "label": "Phosphorus",
//        "tag": "P",
//        "schemaOrgTag": null,
//        "total": 1353.9929696970464,
//        "hasRDI": true,
//        "daily": 193.42756709957808,
//        "unit": "mg"
//        },
//        {
//        "label": "Vitamin A",
//        "tag": "VITA_RAE",
//        "schemaOrgTag": null,
//        "total": 1570.5002007576354,
//        "hasRDI": true,
//        "daily": 174.50002230640393,
//        "unit": "µg"
//        },
//        {
//        "label": "Vitamin C",
//        "tag": "VITC",
//        "schemaOrgTag": null,
//        "total": 91.30343787886554,
//        "hasRDI": true,
//        "daily": 101.4482643098506,
//        "unit": "mg"
//        },
//        {
//        "label": "Thiamin (B1)",
//        "tag": "THIA",
//        "schemaOrgTag": null,
//        "total": 1.226208659090935,
//        "hasRDI": true,
//        "daily": 102.18405492424458,
//        "unit": "mg"
//        },
//        {
//        "label": "Riboflavin (B2)",
//        "tag": "RIBF",
//        "schemaOrgTag": null,
//        "total": 0.938598689394052,
//        "hasRDI": true,
//        "daily": 72.19989918415784,
//        "unit": "mg"
//        },
//        {
//        "label": "Niacin (B3)",
//        "tag": "NIA",
//        "schemaOrgTag": null,
//        "total": 38.368861848486404,
//        "hasRDI": true,
//        "daily": 239.80538655304002,
//        "unit": "mg"
//        },
//        {
//        "label": "Vitamin B6",
//        "tag": "VITB6A",
//        "schemaOrgTag": null,
//        "total": 2.3819731060609683,
//        "hasRDI": true,
//        "daily": 183.22870046622833,
//        "unit": "mg"
//        },
//        {
//        "label": "Folate equivalent (total)",
//        "tag": "FOLDFE",
//        "schemaOrgTag": null,
//        "total": 242.1291553030588,
//        "hasRDI": true,
//        "daily": 60.5322888257647,
//        "unit": "µg"
//        },
//        {
//        "label": "Folate (food)",
//        "tag": "FOLFD",
//        "schemaOrgTag": null,
//        "total": 242.1291553030588,
//        "hasRDI": false,
//        "daily": 0,
//        "unit": "µg"
//        },
//        {
//        "label": "Folic acid",
//        "tag": "FOLAC",
//        "schemaOrgTag": null,
//        "total": 0,
//        "hasRDI": false,
//        "daily": 0,
//        "unit": "µg"
//        },
//        {
//        "label": "Vitamin B12",
//        "tag": "VITB12",
//        "schemaOrgTag": null,
//        "total": 1.026,
//        "hasRDI": true,
//        "daily": 42.75000000000001,
//        "unit": "µg"
//        },
//        {
//        "label": "Vitamin D",
//        "tag": "VITD",
//        "schemaOrgTag": null,
//        "total": 0,
//        "hasRDI": true,
//        "daily": 0,
//        "unit": "µg"
//        },
//        {
//        "label": "Vitamin E",
//        "tag": "TOCPHA",
//        "schemaOrgTag": null,
//        "total": 5.850815000000931,
//        "hasRDI": true,
//        "daily": 39.00543333333954,
//        "unit": "mg"
//        },
//        {
//        "label": "Vitamin K",
//        "tag": "VITK1",
//        "schemaOrgTag": null,
//        "total": 141.35677916668402,
//        "hasRDI": true,
//        "daily": 117.79731597223669,
//        "unit": "µg"
//        },
//        {
//        "label": "Sugar alcohols",
//        "tag": "Sugar.alcohol",
//        "schemaOrgTag": null,
//        "total": 0,
//        "hasRDI": false,
//        "daily": 0,
//        "unit": "g"
//        },
//        {
//        "label": "Water",
//        "tag": "WATER",
//        "schemaOrgTag": null,
//        "total": 917.3796923487508,
//        "hasRDI": false,
//        "daily": 0,
//        "unit": "g"
//        }
//        ]
//        },
//        "_links": {
//        "self": {
//        "title": "Self",
//        "href": "https://api.edamam.com/api/recipes/v2/recipe_b5e1c34c9042a35a534069f438ec86fc/b5e1c34c9042a35a534069f438ec86fc?type=public&app_id=5af3ae0a&app_key=1bf2959a73a85fa063cd713ec55636c5"
//        }
//        }
//        }