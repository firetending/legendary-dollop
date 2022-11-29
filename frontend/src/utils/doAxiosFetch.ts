import { useState, useEffect } from "react";
import axios, { AxiosRequestConfig } from "axios";

let data: any = null;
let headers: any = null; 
let error: any = null; 
let loaded: any = false; 

const doAxiosFetch = async(params: AxiosRequestConfig<any>): Promise<Object> => { 
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
      'loaded': loaded, 
      'doAxiosFetch': doAxiosFetch
    });
  });
  
};

export default doAxiosFetch;
