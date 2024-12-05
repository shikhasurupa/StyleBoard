import './Pin.css';
import React from "react";

const Pin = ({pinSize, imgSrc, onImageSave}) => {

    const handleImageSave = () => {
        onImageSave(imgSrc);
    }

    return (
        <div className={`pin ${pinSize}`}>
            <img src={imgSrc}/>
            <div>
                <button className='save' onClick={handleImageSave}>
                    <img src="https://github.com/shikhasurupa/StyleBoard/blob/main/styleboard/src/Images/OvelSaveButton.png?raw=true" />
                </button>
            </div>
        </div>
    );
}

export default Pin;