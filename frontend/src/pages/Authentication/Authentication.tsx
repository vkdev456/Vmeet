import { use, useState } from "react";
import "./Authentication.css";

export default function Authentication() {

    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");
    const [message,setMessage]=useState();
    const [name,setName]=useState("");
    const [error,setError]=useState();
 
    
    const [from,setFrom]=useState(0);
    const [open,setOpen]=useState(false);
     
    const handleLogin = () => {

        console.log(email);
        console.log(password);

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

                <button  className="btn btn-primary w-100" onClick={handleLogin}>Login</button>
           </div>
           
        </div>

        // <div className="auth-container">

        //     <div className="auth-card">

        //         <h2 className="text-center mb-4">
        //             Login
        //         </h2>

        //         <div className="mb-2">

        //             <label className="form-label">
        //                 Email
        //             </label>

        //             <input
        //                 type="email"
        //                 className="form-control"
        //                 placeholder="Enter Email"
        //                 value={email}
        //                 // onChange={(e) => setEmail(e.target.value)}
        //             />

        //         </div>

        //         <div className="mb-4">

        //             <label className="form-label">
        //                 Password
        //             </label>

        //             <input
        //                 type="password"
        //                 className="form-control"
        //                 placeholder="Enter Password"
        //                 value={password}
        //                 // onChange={(e) => setPassword(e.target.value)}
        //             />

        //         </div>

        //         <button
        //             className="btn btn-primary w-100"
        //             onClick={handleLogin}
        //         >
        //             Login
        //         </button>

        //     </div>

        // </div>

    );

}