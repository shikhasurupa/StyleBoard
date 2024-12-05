import './App.css';
import LoginRegister from './Component/LoginRegister/LoginRegister';
import Feed from './Component/Feed/FeedScreen';
import CollectionScreen from './Component/Collection/CollectionScreen';
import Pin from './Component/Feed/Pin';
import Header from './Component/Header/Header'
import { Routes, Route} from 'react-router-dom'
import React, { useState } from "react";

function App() {
  const [selectedCategory, setSelectedCategory] = useState("");
  const [selectedImageSource, setSelectedImageSource] = useState([]);

  const handleCategoryChange = (category) => {
    setSelectedCategory(category);
  };

  const handleImageSave = (imgSrc) => {
    if (imgSrc) {
      if (imgSrc) {
        setSelectedImageSource((prevImages) => [...prevImages, imgSrc]);
      }
  }};

  return (
      <Routes>
        <Route path="/" element={<LoginRegister />} />
      
        <Route
          path="/feed"
          element={
            <>
              <Header onCategoryChange={handleCategoryChange} />
              <Feed
                selectedCategory={selectedCategory}
                onImageSave={handleImageSave}
              />
            </>
          }
        />
        <Route
          path="/collections"
          element={
            <>
              <Header onCategoryChange={handleCategoryChange} />
              <CollectionScreen selectedImageSource={selectedImageSource} />
            </>
          }
        />
        <Route
          path="/pins"
          element={
            <>
              <Header onCategoryChange={handleCategoryChange} />
              <Pin onImageSave={handleImageSave} />
            </>
          }
        />
      </Routes>
  );
}

export default App;
