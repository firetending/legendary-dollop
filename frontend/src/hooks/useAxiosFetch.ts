import { useState } from "react";
import axios, { AxiosRequestConfig } from "axios";
axios.defaults.baseURL = "http://localhost:8081/api/v1/";


const useAxiosFetch = (params: AxiosRequestConfig<any>) => {
    const [data, setData] = useState(null);
    const [error, setError] = useState("");
    const [loaded, setLoaded] = useState(false);    
  
    const doAxiosFetch = async (): Promise<void> => {
      await axios.request(params)        
        .then((response: any) => setData(response.data))
        .catch((error: any) => setError(error.message))
        .finally(() => setLoaded(true));
    };  
    
    return [data, error, loaded, doAxiosFetch] as const;
  };
export default useAxiosFetch;
  