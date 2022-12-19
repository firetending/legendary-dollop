import React, {useContext} from 'react';
import { GlobalContext } from '../../context/GlobalState';

export const MenuCard = ( {recipe}: any ) => {
  const { deleteRecipeFromMenuList } = useContext<any>(GlobalContext);

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
            onClick = { () => deleteRecipeFromMenuList(recipe.recipe.calories)}
        > Delete
        </button>
      </div>

    </div>

  )
}
