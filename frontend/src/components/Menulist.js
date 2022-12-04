import React, {useContext} from 'react';
import { GlobalContext } from '../context/GlobalState';
import { MenuCard } from "./MenuCard";

export const Menulist = () => {

const { menulist } = useContext(GlobalContext);

  return (
    <div>

    <div>
        <h1>Menu List</h1>
    </div>


        <div>
        {menulist.map(recipe => (
            <MenuCard key={recipe.recipe.calories} 
                      recipe={recipe} 
                      type="menulist" 
            />
        ))}
        </div>


        </div>




  )
}
