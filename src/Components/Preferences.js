import React, { useState } from 'react';
import Select from 'react-select';
import './Preferences.css';

const options = [{value: 'Dalhousie University', label: 'Dalhousie University'}, {
    value: 'Saint Marys University',
    label: 'Saint Marys University'
}, {
    value: 'Mount Saint Vincent University',
    label: 'Mount Saint Vincent University'
}, {
    value: 'University of Kings College',
    label: 'University of Kings College'
}, {
    value: 'NSCAD University (Nova Scotia College of Art and Design)',
    label: 'NSCAD University (Nova Scotia College of Art and Design)'
}, {
    value: 'Atlantic School of Theology',
    label: 'Atlantic School of Theology'
}, {
    value: 'Maritime Conservatory of Performing Arts',
    label: 'Maritime Conservatory of Performing Arts'
}, {
    value: 'Canadian College of Acupuncture and Traditional Chinese Medicine',
    label: 'Canadian College of Acupuncture and Traditional Chinese Medicine'
}, {value: 'Eastern College', label: 'Eastern College'}, {
    value: 'Centre for Arts and Technology - Halifax',
    label: 'Centre for Arts and Technology - Halifax'
}, {
    value: 'Academy of Cosmetology and Massage',
    label: 'Academy of Cosmetology and Massage'
}, {value: 'Robertson College', label: 'Robertson College'}, {
    value: 'Centre for Distance Education',
    label: 'Centre for Distance Education'
}];
const foodOptions = [{value: 'Vegetarian', label: 'Vegetarian'}, {
    value: 'Eggetarian',
    label: 'Eggetarian'
}, {value: 'Non-vegetarian', label: 'Non-vegetarian'},];
const smokingOptions = [{value: 'Yes', label: 'Yes'}, {value: 'No', label: 'No'},];
const drinkOptions = [{value: 'Yes', label: 'Yes'}, {value: 'No', label: 'No'},];

function Preferences() {
    const [selectedOption1, setSelectedOption1] = useState(null);
    const [selectedOption2, setSelectedOption2] = useState(null);
    const [selectedOption3, setSelectedOption3] = useState(null);
    const [selectedOption4, setSelectedOption4] = useState(null);
    const [multiSelectedOptions, setMultiSelectedOptions] = useState([]);
    const handleSingleSelectChange1 = (option) => {
        setSelectedOption1(option);
    };
    const handleSingleSelectChange2 = (option) => {
        setSelectedOption2(option);
    };
    const handleSingleSelectChange3 = (option) => {
        setSelectedOption3(option);
    };
    const handleSingleSelectChange4 = (option) => {
        setSelectedOption4(option);
    };
    const handleMultiSelectChange = (options) => {
        setMultiSelectedOptions(options);
    };
    return (
        <div className="auth-wrapper">
            <div className="form-container">
                <div className="auth-inner">
        <div className="form-container">
            <h2>Enter your preferences to find an ideal roomate</h2>
        <form className="form">
            <label htmlFor="single-select-input1">Select University:</label>
            <Select
            id="single-select-input1" options={options} value={selectedOption1} onChange={handleSingleSelectChange1}
            className="react-select-container" classNamePrefix="react-select"/>
            <label htmlFor="single-select-input2">Select
            Food Preference:
            </label>
            <Select id="single-select-input2" options={foodOptions} value={selectedOption2}
                                             onChange={handleSingleSelectChange2}
                    className="react-select-container"
                                             classNamePrefix="react-select"/>
            <label htmlFor="single-select-input3">Do
            you mind if your roommate smokes:</label>
            <Select id="single-select-input3" options={smokingOptions}
                                                              value={selectedOption3}
                                                              onChange={handleSingleSelectChange3}
                                                              className="react-select-container"
                                                              classNamePrefix="react-select"/> <label
            htmlFor="single-select-input4">Do you mind if your roommate drinks:</label> <Select
            id="single-select-input4" options={drinkOptions} value={selectedOption4}
            onChange={handleSingleSelectChange4} className="react-select-container" classNamePrefix="react-select"/>
            <label htmlFor="multi-select-input">Select multiple fruits:</label> <Select id="multi-select-input"
                                                                                        options={options} isMulti
                                                                                        value={multiSelectedOptions}
                                                                                        onChange={handleMultiSelectChange}
                                                                                        className="react-select-container"
                                                                                        classNamePrefix="react-select"/>
            <button className="submit-button">Submit</button>
        </form>
        </div>
                </div>
            </div>
    </div>);
}

export default Preferences;

