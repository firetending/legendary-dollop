import React, { createContext, useReducer, useEffect } from 'react';
import AppReducer from "./AppReducer";

const initialState = {
    globalAppData: localStorage.getItem('globalAppData') !== null ?  JSON.parse(localStorage.getItem('globalAppData') !) : {},
   
}

export const GlobalContext = createContext(initialState);

export const GlobalProvider = ({ children }: {children: any}) => {
    const [state, dispatch] = useReducer(AppReducer, initialState);    

    useEffect(() => {
        localStorage.setItem('globalAppData', JSON.stringify(state.globalAppData));        
    }, [state]);

    const addRecipeToMenulist = (recipe: any) => {
        dispatch({ type: "ADD_RECIPE_TO_MENULIST", payload: recipe });
    }

    const deleteRecipeFromMenulist = (calories: any) => {
        dispatch({ type: "DELETE_RECIPE_FROM_MENULIST", payload: calories });
    }

    const setLoginData = (loginData: any) => {
        dispatch({ type: "SET_LOGIN_DATA", payload: loginData });
    }

    const resetLoginData = () => {
        dispatch({ type: "RESET_LOGIN_DATA" });
    }


    const context: any = {
        globalAppData: state.globalAppData,
        setLoginData,
        resetLoginData,
        addRecipeToMenulist,
        deleteRecipeFromMenulist
    };


    return (
        <GlobalContext.Provider value={ context }>
            { children }
        </GlobalContext.Provider>
    )

}
