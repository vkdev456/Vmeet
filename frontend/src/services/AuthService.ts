import api from "../api/axios";
import type { SignupRequest } from "../models/SignupRequest";

export const signup = async(request:SignupRequest)=>{

    const response = await api.post(
        "/auth/signup",
        request
    );

    return response.data;

};



