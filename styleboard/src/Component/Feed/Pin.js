import './Pin.css';
import React from "react";
import { useNavigate } from 'react-router-dom'

function Pin({pinSize, imgSrc}) {
    const navigate = useNavigate();
    return (
        <div className={`pin ${pinSize}`}>
            <img src={imgSrc}/>
            <div>
                <button className='save' onClick={() => navigate("/collection")}>
                    <img src="https://github.com/shikhasurupa/StyleBoard/blob/FeedScreen/styleboard/src/Images/OvelSaveButton.png?raw=true" />
                </button>
            </div>
        </div>
    );
}

export default Pin;