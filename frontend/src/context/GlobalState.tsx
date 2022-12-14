import React, { createContext, useReducer, useEffect } from 'react';
import AppReducer from "./AppReducer";

const initialState: object = {
    globalAppData: localStorage.getItem('globalAppData') !== null ?  JSON.parse(localStorage.getItem('globalAppData') !) :
    {
        menulist: [],
        loginData: {}
    },
}

export const GlobalContext = createContext(initialState);

export const GlobalProvider = ({ children }: {children: any}) => {
    console.log('Global Provider');
    const [state, dispatch] = useReducer(AppReducer, initialState);    

    useEffect(() => {
        localStorage.setItem('globalAppData', JSON.stringify(state.globalAppData));        
    }, [state]);

    const addRecipeToMenuList = (recipe: any) => {
        dispatch({ type: "ADD_RECIPE_TO_MENULIST", payload: recipe });
    }

    const deleteRecipeFromMenuList = (calories: any) => {
        dispatch({ type: "DELETE_RECIPE_FROM_MENULIST", payload: calories });
    }

    const setLoginData = (loginData: any) => {
        dispatch({ type: "SET_LOGIN_DATA", payload: loginData });
    }

    const resetLoginData = () => {
        dispatch({ type: "RESET_LOGIN_DATA" });
    }

    const context = {
        globalAppData: state.globalAppData,
        addRecipeToMenuList,
        deleteRecipeFromMenuList,
        setLoginData,
        resetLoginData        
    };

    return (
        <GlobalContext.Provider value={ context }>
            { children }
        </GlobalContext.Provider>
    )
}
