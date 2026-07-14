import { useState } from "react";
import "./Authentication.css";
import  {signup} from "../../services/AuthService";
import type { SignupRequest } from "../../models/SignupRequest";

export default function Authentication() {

    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");

    const [name, setName]=useState("");
     
    const handleSignup = async() => {

      try{ 

        const request:SignupRequest={
            name,
            email,
            password
        };

        const reponse=await signup(request);
        console.log(reponse);

        }catch(error){
           console.error(error);
        }

    };

    return (

        <div className="authcontainer">
              
            <div className="signup">
              <h2 className="text-center ">Signup</h2>
              
                <div className="mb-2">
                    <label className="form-label">Email</label>
                    <input id='enteremail' type="email" className="form-control" placeholder="Enter Email"
                     onChange={(e)=>setEmail(e.target.value)}
                    /> 
                </div> 

                <div className="mb-2">
                    <label className="form-label">Name</label>
                    <input id='name' type="text" className="form-control" placeholder="Name"
                     onChange={(e)=>setName(e.target.value)}
                    /> 
                </div> 

                <div className="mb-4">
                    <label className="form-label">Password</label>
                    <input type="password"  className="form-control" placeholder="Enter Password" value={password}
                     onChange={(e) => setPassword(e.target.value)} 
                    />
                </div>

                <button  className="btn btn-primary w-100" onClick={handleSignup}>Login</button>
           </div>
           
        </div>

    );

}