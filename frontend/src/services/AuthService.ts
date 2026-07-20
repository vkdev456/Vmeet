import api from "../api/axios";
import type { SignupRequest } from "../models/SignupRequest";
import type { LoginRequest } from "../models/LoginRequest";

const signup = async(request:SignupRequest)=>{

    const response = await api.post(
        "/register",
        request
    );

    return response.data;

};

const login=async(request:LoginRequest)=>{

    const response=await api.post(
        "/login",
         request
    )
    return response;

}

export {login,signup};




