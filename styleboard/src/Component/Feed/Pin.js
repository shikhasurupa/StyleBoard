import './Pin.css';
import React from "react";

function Pin({pinSize, imgSrc}) {
    return (
        <div className={`pin ${pinSize}`}>
            <img
                className='mainPic' 
                src={imgSrc}
                alt=""
            />
        </div>
    );
}

export default Pin;