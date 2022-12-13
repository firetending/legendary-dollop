

const ExtraTools = (str: string) => {
    
}

export const capitalizeFirstCharacter = (str: String): String => {
    return str.charAt(0).toUpperCase() + str.slice(1);
}

export const isEmpty = (object: any): boolean => {
    return (
        object !== null
        && object !== undefined          
        && Object.keys(object).length === 0 
        && object.constructor === Object
    )
}

export default ExtraTools;
