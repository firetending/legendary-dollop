import axios, { AxiosRequestConfig } from "axios";

let data: any = null;
let headers: any = null; 
let error: any = null; 
let loaded: any = false; 

const setData = (dataInput: any) => {
  data = dataInput;
}
const setHeaders = (headersInput: any) => {
  headers = headersInput;
}
const setError = (errorInput: any) => {
  error = errorInput;
}
const setLoaded = (loadedInput: any) => {
  loaded = loadedInput;
}

const resetResponse = () => {
  setData(null);
  setHeaders(null);
  setError(null);
  setLoaded(false);
}


const doAxiosFetch = async(params: AxiosRequestConfig<any>): Promise<Object> => { 
  resetResponse();
  await axios.request(params)        
      .then((response: any) => { 
        setData(response.data);
        setHeaders(response.headers);
      })
      .catch((error: any) => setError(error))
      .finally(() => setLoaded(true));  
  
  return new Promise((resolve, reject) => {
    if(loaded) resolve({
      'data': data, 
      'headers': headers, 
      'error': error, 
      'loaded': loaded      
    });
  });  
};

export default doAxiosFetch;
