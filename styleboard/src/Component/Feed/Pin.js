import './Pin.css';
import React from "react";

function Pin({pinSize, imgSrc}) {
    return (
        <div className={`pin ${pinSize}`}>
            <img src={imgSrc}/>
        </div>
    );
}

export default Pin;