import './Pin.css';
import React from "react";

function Pin({pinSize, imgSrc}) {
    return (
        <div className={`pin ${pinSize}`}>
            <img src={imgSrc}/>
            <div>
                <button className='save'>
                    <img src="https://github.com/shikhasurupa/StyleBoard/blob/FeedScreen/styleboard/src/Images/OvelSaveButton.png?raw=true" />
                </button>
            </div>
        </div>
    );
}

export default Pin;