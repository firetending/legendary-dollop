import React, {useContext} from 'react';
import { GlobalContext } from '../context/GlobalState';
import "./RecipeTile.css";


export const RecipeTile = ({ recipe }) => {

  const { addRecipeToMenulist, menulist } = useContext(GlobalContext);

  // let storedRecipe = menulist.find( o => o.id === recipe.id);

  // const menulistDisabled = storedRecipe ? true : false;

  
  return (
    // recipe["recipe"]["image"].match(/\.(jpeg|jpg|gif|png)$/) != null && (
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
          // disabled = {menulistDisabled}
          onClick = { () => addRecipeToMenulist(recipe)}
          > Add to Meun List
          </button>
        </div>
            


 
   
    </div>
  );
}


