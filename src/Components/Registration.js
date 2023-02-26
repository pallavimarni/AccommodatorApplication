import React, { useState } from 'react';
import { Form, Button, Dropdown } from 'react-bootstrap';
import axios from 'axios';

const RegistrationForm = () => {
    const [selectedOption, setSelectedOption] = useState('option1');
    const [validated, setValidated] = useState(false);
    const [password, setPassword] = useState("");
    const [reenteredPassword, setReenteredPassword] = useState("");
    const [passwordsMatch, setPasswordsMatch] = useState(true);
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
            firstName: data.firstname,
            lastName: data.lastname,
            email: data.email,
            password: data.password,
            contactNo: data.contact,
            offerLetter: data.offerletter,
            type: data.type
        })
            .then(res=> {
                console.log(res.data)
            })
    };

    const url="http://localhost:8080/student/create"
    const [data, setData] =useState ({
        firstname:"",lastname:"", contact:"" , email:"", pass:"", offerletter:""

    });


    function handle(e){
        const newData={...data}
        newData[e.target.id] = e.target.value
        setData(newData)
        console.log(newData)
    };

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
                    <Form.Control id = "lastname" value={data.lastname} type="text" placeholder="Enter Last Name" onChange = {(e)=> handle(e)} required />

                    <Form.Label>Enter Email address</Form.Label>
                    <Form.Control id = "email" value={data.email} type="email" placeholder="Enter email" pattern=".+@dal.ca" onChange = {(e)=> handle(e)} required />
                    <Form.Control.Feedback type="invalid">
                        Please provide a valid email.
                    </Form.Control.Feedback>

                    <Form.Label>Enter Contact No.</Form.Label>
                    <Form.Control id = "contact" value={data.contact} type="tel" placeholder="Enter Contact No." pattern="^[0-9]{10}$" onChange = {(e)=> handle(e)} required />
                    <Form.Control.Feedback type="invalid">
                        Please provide a valid contact.
                    </Form.Control.Feedback>

                    <Form.Label>Upload Offer Letter</Form.Label>
                    <Form.Control id = "offerletter" value={data.offerletter} type="file" placeholder="Upload Offer Letter" onChange = {(e)=> handle(e)} required />


                    <Form.Label>Create password</Form.Label>
                    <Form.Control id="password" value={data.password} type="password" placeholder="Create Password" onChange = {(e)=> handle(e)} required />
                    <Form.Control.Feedback type="invalid">
                        Please provide a valid password.
                    </Form.Control.Feedback>

                    <Form.Label>Re-enter Password</Form.Label>
                    <Form.Control id="ConfirmPassword" type="password" placeholder="Re-enter Password" onKeyUp="validate_password()" onChange = {(e)=> handle(e)} required />
                    <Form.Control.Feedback type="invalid">
                        Please provide a valid password.
                    </Form.Control.Feedback>
                </Form.Group>
            )}

            {selectedOption === 'option2' && (
                <Form.Group controlId="formBasicUsername">

                    <Form.Label>Enter First Name</Form.Label>
                    <Form.Control id = "firstname" value={data.firstname} type="text" placeholder="Enter First Name" onChange = {(e)=> handle(e)} required />

                    <Form.Label>Enter Last Name</Form.Label>
                    <Form.Control id = "lastname" value={data.lastname} type="text" placeholder="Enter Last Name" onChange = {(e)=> handle(e)} required />

                    <Form.Label>Owner type? (Lease or Roommate)</Form.Label>
                    <select className="form-select" id="type" value={data.type} aria-label="Select type" onChange = {(e)=> handle(e)} required>
                        <option selected>Select type</option>
                        <option value="1">Student</option>
                        <option value="2">Owner</option>
                    </select>
                    <Form.Control.Feedback type="invalid">
                        Please Select something.
                    </Form.Control.Feedback>

                    <Form.Label>Enter Email address</Form.Label>
                    <Form.Control id = "email" value={data.email} type="email" placeholder="Enter email" onChange = {(e)=> handle(e)} required />
                    <Form.Control.Feedback type="invalid">
                        Please provide a valid email.
                    </Form.Control.Feedback>

                    <Form.Label>Enter Contact No.</Form.Label>
                    <Form.Control id = "contact" value={data.contact}type="tel" placeholder="Enter Contact No."  pattern="^[0-9]{10}$" onChange = {(e)=> handle(e)} required />
                    <Form.Control.Feedback type="invalid">
                        Please provide a valid contact.
                    </Form.Control.Feedback>

                    <Form.Label>Create password</Form.Label>
                    <Form.Control id="password" value={data.password} type="password" placeholder="Create Password" onBlur="{handlePasswordChange}" onChange = {(e)=> handle(e)} required />
                    <Form.Control.Feedback type="invalid">
                        Please provide a valid password.
                    </Form.Control.Feedback>

                    <Form.Label>Re-enter Password</Form.Label>
                    <Form.Control type="password" placeholder="Re-enter Password" onKeyUp="{handleReenteredPasswordChange}" onChange = {(e)=> handle(e)}required />
                    <Form.Control.Feedback type="invalid">
                        Please provide a valid password.
                    </Form.Control.Feedback>
                </Form.Group>
            )}

            <br/>
            <div className="d-grid">
                {!passwordsMatch && <p>Passwords do not match.</p>}
                <button type="submit" disabled={!passwordsMatch} className="btn btn-primary">
                    Submit
                </button>
            </div>
        </Form>

    );
};

export default RegistrationForm;
