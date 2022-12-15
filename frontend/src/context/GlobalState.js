import React, {createContext, useReducer, useEffect} from 'react';
import AppReducer from "./AppReducer";
import doAxiosFetch from '../utils/doAxiosFetch';


const initialState = {
    menulist : localStorage.getItem('menulist') 
    ? JSON.parse(localStorage.getItem('menulist')) 
    : [],
    
}

export const GlobalContext = createContext(initialState);

export const GlobalProvider = (props) => {
    const [state, dispatch] = useReducer(AppReducer, initialState);

    
    useEffect(() => {

        localStorage.setItem('menulist', JSON.stringify(state.menulist));

        doAxiosFetch({
            method: "POST",
            url: "http://localhost:8081/api/v1/data/menu/new", 
            headers: {
                // 'Authorization': 'Bearer' + user.token ,
                'content-type': 'application/json',                
            }, 
            data: 
                state
            ,
            
    }).then((result) => { 
        console.log('Result: ' + JSON.stringify(result));

        console.log(state);

        const data = result.data;

        if(data === null || data['statusCode'] !== 200){                
            console.log("oops!")
        } else {
            console.log("We did it!!");
        }              
        console.log(`It's not working!`);   
    });
    }, [state]);



    const addRecipeToMenulist = (recipe) => {
        dispatch({type: "ADD_RECIPE_TO_MENULIST", payload: recipe});
    }

    const deleteRecipeFromMenulist = (calories) => {
        dispatch({type: "DELETE_RECIPE_FROM_MENULIST", payload: calories});
    }


    return (
        <GlobalContext.Provider
        value={{
            menulist: state.menulist,
            addRecipeToMenulist,
            deleteRecipeFromMenulist,
        }}
        >
            {props.children}
        </GlobalContext.Provider>
    )

}
