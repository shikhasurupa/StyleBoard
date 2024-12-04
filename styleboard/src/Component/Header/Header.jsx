import React from "react";
import logo from "./logo.png";
import "./Header.css"


//Header
const Header = () => {
    return (
        <div className = "header">
            <div className="logo-container">
                <img src={logo} alt="StyleBoard Logo" className="logo-image" />
            </div>
            <div className="links">
                <button className="link-button">Home</button>
                <button className="link-button">Collections</button>
                <button className="log-out-button"> Log Out</button>
            </div>
        </div>
    )
}
  
  export default Header;