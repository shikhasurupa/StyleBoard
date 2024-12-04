import React from 'react'

import './Login.css'
import { useState } from 'react'
import { useNavigate } from 'react-router-dom'

const LoginRegister = () => {

    const [isLogin, setLogin] = useState(true);
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');
    const [password2, setPassword2] = useState('');
    const [errors, setErrors] = useState([]);
    const navigate = useNavigate();

    // error validation on submit
    const handleSubmit = (event) => {
        event.preventDefault();
        const errors = validate();
        setErrors(errors);
        if(Object.keys(errors).length == 0) {
            navigate('/feed'); // Navigate to the feed page
            console.log("Navigating to /feed");
        }
    }


    // handles switch from login to register and vice versa
    const handleSwitch = (login) => {
        resetForm();
        setLogin(login);
    };

    // resets values
    const resetForm = () => {
        setUsername('');
        setPassword('');
        setPassword2('');
        setErrors({});
    };

    //validations
    const validate = () => {
        const error = {};
    
        if (!username) {
            error.username = 'Enter your username';
        }
        if (!password) {
            error.password = 'Enter your password';
        } else if (!isLogin && password !== password2) {
            error.password2 = 'Passwords do not match';
        }
    
        return error;
    };

    //Login and Register forms    const navigate = useNavigate();

    return (
        <div className='container'>
            {isLogin? <>
            <div className='form'>
            <form onSubmit={handleSubmit}>
                <h2>Login</h2>
                    <input type="text" placeholder="Username" onChange={(e) => setUsername(e.target.value)}/>
                    {errors.username && <div className='error'>{errors.username}</div>}
                    <input type="password" placeholder="Password" onChange={(e) => setPassword(e.target.value)}/>
                    {errors.password && <div className='error'>{errors.password}</div>}
                    <button type="submit">Login</button>
                    <p>Don't have an account? <a href="#" onClick={() => handleSwitch(false)}>Click Here</a></p>
                </form>
            </div>
            </> : <>
            <div className='form'>
                <h2>Create an Account</h2>
                <form onSubmit={handleSubmit}>
                    <input type="text" placeholder="Username" onChange={(e) => setUsername(e.target.value)}/>
                    {errors.username && <div className='error'>{errors.username}</div>}
                    <input type="password" placeholder="Password" onChange={(e) => setPassword(e.target.value)}/>
                    {errors.password && <div className='error'>{errors.password}</div>}
                    <input type="password" placeholder="Confirm Password" onChange={(e) => setPassword2(e.target.value)}/>
                    {errors.password2 && <div className='error'>{errors.password2}</div>}
                    <button type="submit">Register</button>
                    <p>Have an account already? <a href="#" onClick={() => handleSwitch(true)}>Click Here</a></p>
                </form>
            </div>
            </>}
        </div>
    )
}

export default LoginRegister