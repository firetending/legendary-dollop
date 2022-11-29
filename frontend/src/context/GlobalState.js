import React, {createContext, useReducer, useEffect} from 'react';
import AppReducer from "./AppReducer";


const initialState = {
    menulist : localStorage.getItem('menulist') 
    ? JSON.parse(localStorage.getItem('menulist')) 
    : []
}

export const GlobalContext = createContext(initialState);

export const GlobalProvider = (props) => {
    const [state, dispatch] = useReducer(AppReducer, initialState);

    useEffect(() => {
        localStorage.setItem('menulist', JSON.stringify(state.menulist));
    }, [state]);

    const addRecipeToMenulist = (recipe) => {
        dispatch({type: "ADD_RECIPE_TO_MENULIST", payload: recipe});
    }

    return (
        <GlobalContext.Provider
        value={{
            menulist: state.menulist,
            addRecipeToMenulist
        }}
        >
            {props.children}
        </GlobalContext.Provider>
    )

}
