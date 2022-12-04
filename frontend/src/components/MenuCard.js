import React, {useContext} from 'react';
import { GlobalContext } from '../context/GlobalState';

export const MenuCard = ( {recipe} ) => {

  const { deleteRecipeFromMenulist } = useContext(GlobalContext);

  return (
    <div>

    <div>
    <img className="recipeTile__img" src={recipe["recipe"]["image"]} alt="food pictures"/>
        <a href={recipe['recipe']['url']}>
            <p className="recipeTile__name"> {recipe["recipe"]["label"]}</p>
        </a>
    </div>

    <div>
    <button
      className='btn'
        onClick = { () => deleteRecipeFromMenulist(recipe.recipe.calories)}
    > Delete
    </button>
    </div>

    </div>

  )
}
