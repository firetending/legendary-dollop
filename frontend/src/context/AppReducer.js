export default function AppReducer(state, action) {
    switch(action.type) {
        case"ADD_RECIPE_TO_MENULIST" :
        return {
            ...state,
            menulist: [action.payload, ...state.menulist]
        }
        case"DELETE_RECIPE_FROM_MENULIST" :
        return {
            ...state,
            menulist: state.menulist.filter( 
                recipe => recipe.recipe.calories
                !== action.payload),
        } 

        default:
            return state;
    }
}