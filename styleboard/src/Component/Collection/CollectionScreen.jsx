import './Collection.css'
import React from 'react'
import Data from './CollectionData';

const CollectionScreen = () => {
  return (
    <div className="collection-container">
        {Data && Data.map((Data) =>
          <img src={Data.imgSrc}
        />)}
    </div>
  )
}

export default CollectionScreen
