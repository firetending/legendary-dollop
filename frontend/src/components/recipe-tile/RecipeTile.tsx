import React, { useContext } from 'react';
import { GlobalContext } from '../../context/GlobalState';
import { isEmpty, capitalizeFirstCharacter } from "../../utils/extraTools";
import "./RecipeTile.css";


export const RecipeTile = ({ recipe }: any) => {
  const { addRecipeToMenuList, deleteRecipeFromMenuList, globalAppData } = useContext<any>(GlobalContext);  
  let storedRecipe = !isEmpty(globalAppData.menulist)?
    globalAppData.menulist.find( (o: any) => o.recipe.calories === recipe.recipe.calories)
    : null;
  
  const menulistDisabled = storedRecipe ? true : false;
  
  return (
    // recipe["recipe"]["image"].match(/\.(jpeg|jpg|gif|png)$/) != null && (
    <div>
      <div className="recipeTile">
        <div>
          <img className="recipeTile__img" src={recipe["recipe"]["image"]} alt="food pictures"/>
          <a href={recipe['recipe']['url']}>
              <p className="recipeTile__name"> {recipe["recipe"]["label"]}</p>
          </a>
        </div>
        {/* <div>
        <ul className='recipeTile__ingredientLines'> 
        {ingredients.map((ingredient) => ( 
        <li> {ingredient} </li>
        ))}
          </ul>
          </div> */}
        <br />

        <div>
          <button
          className='btn'
          disabled = {menulistDisabled}
          onClick = { () => addRecipeToMenuList(recipe)}
          > Add to Meun List
          </button>
        </div> 
      </div>
    </div>
  );
}


