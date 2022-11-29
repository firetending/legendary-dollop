import { useState, useEffect } from "react";
import axios, { AxiosRequestConfig } from "axios";
import doAxiosFetch from './doAxiosFetch';
//axios.defaults.baseURL = "http://";


const useAxiosFetch = (params: AxiosRequestConfig<any>) => {
    const [data, setData] = useState(null);
    const [headers, setHeaders] = useState(null);
    const [error, setError] = useState(null);
    const [loaded, setLoaded] = useState(false);  
    
    useEffect(() => {
      doFetch(params).then((result: any) => {
        setData(result.data);
        setHeaders(result.headers)
        setError(result.error);
        setLoaded(result.loaded);
      });
    }, [])

    const doFetch = (params: AxiosRequestConfig<any>) => doAxiosFetch(params)
      .then((result: any) => {
        setData(result.data);
        setHeaders(result.headers)
        setError(result.error);
        setLoaded(result.loaded);
      }); 

    return [ data, headers, error, loaded, doFetch ];
  };
export default useAxiosFetch;
 
 