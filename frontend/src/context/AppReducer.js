export default function AppReducer(state, action) {
    switch(action.type) {
        case"ADD_RECIPE_TO_MENULIST" :
        return {
            ...state,
            menulist: [action.payload, ...state.menulist]
        }
        

        default:
            return state;
    }
}