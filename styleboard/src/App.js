import './App.css';
import LoginRegister from './Component/LoginRegister/LoginRegister';
import Feed from './Component/Feed/FeedScreen';
import Header from './Component/Header/Header'
import { Routes, Route} from 'react-router-dom'
import React, { useState } from "react";

function App() {
  const [selectedCategory, setSelectedCategory] = useState("");

  const handleCategoryChange = (category) => {
    setSelectedCategory(category);
  };

  return (
    <>
      <Header onCategoryChange={handleCategoryChange} />
      <Routes>
        <Route path="/" element={<LoginRegister />} />
        <Route path="/feed" element={<Feed selectedCategory={selectedCategory} />} />
      </Routes>
    </>
  );
}

export default App;
