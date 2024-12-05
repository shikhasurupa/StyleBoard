import './Collection.css'
import React from 'react'

const CollectionScreen = ({ selectedImageSource }) => {
  console.log('selectedImageSource:', selectedImageSource);

  return (
    <div className="collection-container">
      {selectedImageSource.length > 0 &&
        selectedImageSource.map((imgSrc, index) => (
          <img key={index} src={imgSrc} alt={`Saved ${index}`} />
        ))}
    </div>
  )
}

export default CollectionScreen
