import './Feed.css';
import React from "react";
import Pin from './Pin';
import Data from './Data';
import Header from '../Header/Header';

//Main Feed
const Feed = () => {

  return (
    <><Header /><div className="feed-container">
      {Data && Data.map((Data) => <Pin
        key={Data.id}
        pinSize={Data.size}
        imgSrc={Data.imgSrc} />)}
    </div></>
  );
};

export default Feed;