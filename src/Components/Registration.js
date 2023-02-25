import React, { useState } from 'react';
import { Form, Button, Dropdown } from 'react-bootstrap';
import axios from 'axios';


const RegistrationForm = () => {
    const [selectedOption, setSelectedOption] = useState('option1');
    const [validated, setValidated] = useState(false);

    const handleOptionChange = (event) => {
        setSelectedOption(event.target.value);
    };

    const handleSubmit = (event) => {
        const form = event.currentTarget;
        if (form.checkValidity() === false) {
            event.preventDefault();
            event.stopPropagation();
        }

        setValidated(true);
        axios.post(url,{
        firstname: data.firstname
        })
        .then(res=> {
        console.log(res.data)
        })
    };

const url="http://localhost:3000"
const [data, setData] =useState ({
firstname:"",
})


function handle(e){
const newData={...data}
newData[e.target.id] = e.target.value
setData(newData)
console.log(newData)
}

    return (
        <Form noValidate validated={validated} onSubmit={handleSubmit}>

            <Form.Group>
                <h3>Sign Up</h3>

                <Form.Check
                    type="radio"
                    label="Student"
                    name="formHorizontalRadios"
                    id="formHorizontalRadios1"
                    value="option1"
                    checked={selectedOption === 'option1'}
                    onChange={handleOptionChange}
                />
                <Form.Check
                    type="radio"
                    label="Owner"
                    name="formHorizontalRadios"
                    id="formHorizontalRadios2"
                    value="option2"
                    checked={selectedOption === 'option2'}
                    onChange={handleOptionChange}
                />
            </Form.Group>

            {selectedOption === 'option1' && (
                <Form.Group controlId="Registration">
                    <Form.Label>Enter First Name</Form.Label>
                    <Form.Control id = "firstname" value={data.firstname} type="text" placeholder="Enter First Name" onChange = {(e)=> handle(e)} required />

                    <Form.Label>Enter Last Name</Form.Label>
                    <Form.Control type="text" placeholder="Enter Last Name" required />

                    <Form.Label>Enter Email address</Form.Label>
                    <Form.Control type="email" placeholder="Enter email" pattern=".+@dal.ca" required />
                    <Form.Control.Feedback type="invalid">
                        Please provide a valid email.
                    </Form.Control.Feedback>

                    <Form.Label>Enter Contact No.</Form.Label>
                    <Form.Control type="tel" placeholder="Enter Contact No." pattern="^[0-9]{10}$" required />
                    <Form.Control.Feedback type="invalid">
                        Please provide a valid contact.
                    </Form.Control.Feedback>

                    <Form.Label>Upload Offer Letter</Form.Label>
                    <Form.Control type="file" placeholder="Upload Offer Letter" required />

                    <Form.Label>Create password</Form.Label>
                    <Form.Control id="Password" type="password" placeholder="Create Password" required />
                    <Form.Control.Feedback type="invalid">
                        Please provide a valid password.
                    </Form.Control.Feedback>

                    <Form.Label>Re-enter Password</Form.Label>
                    <Form.Control id="ConfirmPassword" type="password" placeholder="Re-enter Password" onKeyUp="validate_password()" required />
                    <Form.Control.Feedback type="invalid">
                        Please provide a valid password.
                    </Form.Control.Feedback>
                </Form.Group>
            )}

            {selectedOption === 'option2' && (
                <Form.Group controlId="formBasicUsername">

                    <Form.Label>Enter First Name</Form.Label>
                    <Form.Control type="text" placeholder="Enter First Name" required />

                    <Form.Label>Enter Last Name</Form.Label>
                    <Form.Control type="text" placeholder="Enter Last Name" required />

                    <Form.Label>Owner type? (Lease or Roommate)</Form.Label>
                        <select className="form-select" aria-label="Select type" required>
                            <option selected>Select type</option>
                            <option value="1">Student</option>
                            <option value="2">Owner</option>
                        </select>
                    <Form.Control.Feedback type="invalid">
                        Please Select something.
                    </Form.Control.Feedback>


                    <Form.Label>Enter Email address</Form.Label>
                    <Form.Control type="email" placeholder="Enter email" required />
                    <Form.Control.Feedback type="invalid">
                        Please provide a valid email.
                    </Form.Control.Feedback>

                    <Form.Label>Enter Contact No.</Form.Label>
                    <Form.Control type="tel" placeholder="Enter Contact No."  pattern="^[0-9]{10}$" required />
                    <Form.Control.Feedback type="invalid">
                        Please provide a valid contact.
                    </Form.Control.Feedback>

                    <Form.Label>Create password</Form.Label>
                    <Form.Control type="password" placeholder="Create Password" required />
                    <Form.Control.Feedback type="invalid">
                        Please provide a valid password.
                    </Form.Control.Feedback>

                    <Form.Label>Re-enter Password</Form.Label>
                    <Form.Control type="password" placeholder="Re-enter Password" required />
                    <Form.Control.Feedback type="invalid">
                        Please provide a valid password.
                    </Form.Control.Feedback>
                </Form.Group>
            )}

<br/>
                <div className="d-grid">
                    <button type="submit" className="btn btn-primary">
                        Submit
                    </button>
                </div>
        </Form>

);
};

export default RegistrationForm;
