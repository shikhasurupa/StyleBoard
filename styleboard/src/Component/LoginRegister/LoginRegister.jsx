import React from 'react'

import './Login.css'
import { useState } from 'react'
import { useNavigate } from 'react-router-dom'

const LoginRegister = () => {

    const [isLogin, setLogin] = useState("true");
    const navigate = useNavigate();

    return (
        <div className='container'>
            {isLogin? <>
            <div className='form'>
                <h2>Login</h2>
                <input type="text" placeholder="Username" />
                <input type="password" placeholder="Password"/>
                <button onClick={() => navigate("/feed")}>Login</button>
                <p>Don't have an account? <a href='#' onClick={()=>setLogin(false)}>Click Here</a></p>
            </div>
            </> : <>
            <div className='form'>
                <h2>Create an Account</h2>
                <input type="text" placeholder="Username" />
                <input type="password" placeholder="Password"/>
                <input type="password" placeholder="Confirm Password"/>
                <button onClick={() => navigate("/feed")}>Register</button>
                <p>Have an account already? <a href='#' onClick={()=>setLogin(true)}>Click Here</a></p>
            </div>
            </>}
            
        </div>
    )
}

export default LoginRegister