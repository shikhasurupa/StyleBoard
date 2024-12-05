import './Feed.css';
import React, {useState, useEffect} from "react";
import Pin from './Pin';
import Data from './Data';


// Main Feed
const Feed = ({ selectedCategory, onImageSave}) => {
  
  const [filteredData, setFilteredData] = useState([]);

  useEffect(() => {
    if (selectedCategory && selectedCategory !== "Filters") {
      const filtered = Data.filter(
        (item) => item.type.toLowerCase() === selectedCategory.toLowerCase()
      );
      setFilteredData(filtered);
    } else {
      setFilteredData(Data);
    }
  }, [selectedCategory]);

  return (
    <div className="feed-container">
      {filteredData.map((item) => (
          <Pin key={item.id} pinSize={item.size} imgSrc={item.imgSrc} onImageSave={onImageSave} />
        ))}
    </div>
  );
};

export default Feed;