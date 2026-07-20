import { useState } from "react";
import "./Authentication.css";
import  {signup} from "../../services/AuthService";
import type { SignupRequest } from "../../models/SignupRequest";

export default function Authentication() {

    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");

    const [name, setName]=useState("");
     
    const handleSignup = async() => {

      try{ 

        const request:SignupRequest={
            name,
            username,
            password
        };

        const response=await signup(request);
        console.log(response);
        

        }catch(error){
           console.error(error);
        }

    };

    return (

        <div className="authcontainer">
              
            <div className="signup">
                <h2 className="text-center ">Signup</h2>
              
                <div className="mb-2">
                    <label className="form-label">Username</label>
                    <input id='username' type="text" className="form-control" placeholder="Enter username"
                     value={username}
                     onChange={(e)=>setUsername(e.target.value)}
                    /> 
                </div> 

                <div className="mb-2">
                    <label className="form-label">Name</label>
                    <input id='name' type="text" className="form-control" placeholder="Name"
                     value={name}
                     onChange={(e)=>setName(e.target.value)}
                    /> 
                </div> 

                <div className="mb-4">
                    <label className="form-label">Password</label>
                    <input type="password"  className="form-control" placeholder="Enter Password" value={password}
                     onChange={(e) => setPassword(e.target.value)} 
                    />
                </div>

                <button  className="btn btn-primary w-100" onClick={handleSignup}>Signup</button>
           </div>
           
        </div>

    );

}