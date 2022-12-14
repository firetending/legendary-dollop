const AppReducer = (state: any, action: any) => {  
    
    const init = (st: any) => {
        st.globalAppData.menulist = st.globalAppData.menulist || [];
        st.globalAppData.loginData = st.globalAppData.loginData || {};
    }

    let actionMap: Map<string, any> = new Map<string, any>([         
        
        ["ADD_RECIPE_TO_MENULIST", (st: any, act: any) => {  
            console.log('DeleteAdd recipe to menu');
            console.log('state: ' + JSON.stringify(st));
            console.log('act: ' + JSON.stringify(act));
            init(st);           
            return {
                ...st,
                globalAppData: { 
                    ...st.globalAppData, 
                    menulist: [...st.globalAppData.menulist, act.payload] 
                }
            };
        }],              

        ["DELETE_RECIPE_FROM_MENULIST", (st: any, act: any) => { 
            console.log('Delete recipe from menu');
            console.log('state: ' + JSON.stringify(st));
            console.log('act: ' + JSON.stringify(act));
            init(st);
            return {
                ...st,
                globalAppData: {
                    ...st.globalAppData,
                    menulist: st.globalAppData.menulist.filter( 
                        (recipe: any) => recipe.recipe.calories !== act.payload
                    ),
                }
            };
        }],

        ["SET_LOGIN_DATA", (st: any, act: any) => { 
            console.log('Setting login data');
            console.log('state: ' + JSON.stringify(st));
            console.log('act: ' + JSON.stringify(act));
            init(st);
            return {
                ...st,
                globalAppData: {
                    ...st.globalAppData,
                    loginData: act.payload
                } 
            };            
        }],

        ["RESET_LOGIN_DATA", (st: any, act: any) => { 
            console.log('Resetting login data');
            console.log('state: ' + JSON.stringify(st));
            console.log('act: ' + JSON.stringify(act));
            return {
                ...st,
                globalAppData: {
                    ...st.globalAppData,
                    loginData: {}
                }
            };
        }]   
    ]);
    
    if( actionMap instanceof Map && actionMap.has(action.type) ){
        const actionMethod = actionMap.get(action.type);
        return actionMethod(state, action);
    } else {
        return state;
    }
}

export default AppReducer;