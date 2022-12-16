import React, {useContext} from 'react';
import { GlobalContext } from '../../context/GlobalState';
import { MenuCard } from "../../components/menu-card/MenuCard";
import { isEmpty } from '../../utils/extraTools';
import "./Menulist.css";

export const Menulist = () => {
  const { globalAppData } = useContext<any>(GlobalContext);

  return (!isEmpty(globalAppData) && !isEmpty(globalAppData.menulist))? (    
    <div className='Menulist'>
      
        <>
        <div>
            <h1>Menu List</h1>
        </div>
        <div>
          { 
            globalAppData.menulist.map((recipe: any) => (
              <MenuCard key={recipe.recipe.calories} 
                        recipe={recipe} 
                          
              />
            ))
          }
        </div>
        </>
      
    </div>
  )
  :
  (<>Nothing to see here</>)
}
