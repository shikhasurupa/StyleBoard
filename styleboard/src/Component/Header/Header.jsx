import React from "react";
import logo from "./logo.png";
import "./Header.css";

// Header
const Header = () => {
  const handleCategoryChange = (event) => {
    const selectedCategory = event.target.value;
    if (selectedCategory) {
      console.log(`Selected category: ${selectedCategory}`);
    }
  };

  return (
    <div className="header">
      <div className="logo-container">
        <img src={logo} alt="StyleBoard Logo" className="logo-image" />
      </div>
      <div className="links">
        <select
            className="dropdown-select"
            onChange={handleCategoryChange}
            defaultValue="">
            <option value="" disabled>Filters</option>
            <option value="Women">Women</option>
            <option value="Men">Men</option>
            <option value="Kids">Kids</option>
        </select>
        <button className="link-button">Home</button>
        <button className="link-button">Collections</button>
        <button className="log-out-button">Log Out</button>
      </div>
    </div>
  );
};

export default Header;
