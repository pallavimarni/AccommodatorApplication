import React, { useState } from 'react';
import { Form, Button, Dropdown } from 'react-bootstrap';
import axios from 'axios';

// const RegistrationForm = () => {
//     const [selectedOption, setSelectedOption] = useState('option1');
//     const [validated, setValidated] = useState(false);
//     const [password, setPassword] = useState("");
//     const [reenteredPassword, setReenteredPassword] = useState("");
//     const [passwordsMatch, setPasswordsMatch] = useState(true);
//     const handleOptionChange = (event) => {
//         setSelectedOption(event.target.value);
//     };
//
//
//     const handleSubmit = (event) => {
//         const form = event.currentTarget;
//         if (form.checkValidity() === false) {
//             event.preventDefault();
//             event.stopPropagation();
//         }
//
//         setValidated(true);
//         axios.post(url,{
//             firstName: data.firstname,
//             lastName: data.lastname,
//             email: data.email,
//             password: data.password,
//             contactNo: data.contact,
//             offerLetter: data.offerletter,
//             type: data.type
//         })
//             .then(res=> {
//                 console.log(res.data)
//             })
//     };
//
//     const url="http://localhost:8080/student/create"
//     const [data, setData] =useState ({
//         firstname:"",lastname:"", contact:"" , email:"", pass:"", offerletter:""
//
//     });
//
//
//     function handle(e){
//         const newData={...data}
//         newData[e.target.id] = e.target.value
//         setData(newData)
//         console.log(newData)
//     };
const RegistrationForm = () => {
    const [validated, setValidated] = useState(false);
    const [selectedOption, setSelectedOption] = useState('option1');
    const handleOptionChange = (event) => {
       setSelectedOption(event.target.value);
   };
    const [data, setData] = useState({
        firstname: '',
        lastname: '',
        email: '',
        password: '',
        confirmpassword: '',
        contact: '',
        offerletter: '',
        type: '',
    });

    const handleOnChange = (e) => {
        const { id, value } = e.target;
        setData((prevState) => ({
            ...prevState,
            [id]: value,
        }));
    };

    const handleSubmit = (event) => {
        const form = event.currentTarget;
        event.preventDefault();

        if (!data.email.endsWith('@dal.ca')) {
            alert('Invalid email address.Enter dal email address.');
            return;
        }
        if(!data.contact.match(/^[0-9]{10}$/)){
            alert('Invalid contact number.Enter 10 digit number.');
            return;
        }

        if (form.checkValidity() === false || data.password !== data.confirmpassword) {
            event.stopPropagation();
            alert('Passwords do not match!');
        } else {
            axios
                .post('http://localhost:8080/student/create', {
                    firstName: data.firstname,
                    lastName: data.lastname,
                    email: data.email,
                    password: data.password,
                    contactNo: data.contact,
                    offerLetter: data.offerletter,
                })
                .then((response) => {
                    console.log(response.data);
                })
                .catch((error) => {
                    console.error('Error:', error);
                });
            setValidated(true);
            setData({
                firstname: '',
                lastname: '',
                email: '',
                password: '',
                confirmpassword: '',
                contact: '',
                offerletter: '',
                type: '',
            });
            alert('Successfully registered!');
        }
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
                    <Form.Control id = "firstname" value={data.firstname} type="text" placeholder="Enter First Name" onChange = {handleOnChange} required />

                    <Form.Label>Enter Last Name</Form.Label>
                    <Form.Control id = "lastname" value={data.lastname} type="text" placeholder="Enter Last Name" onChange = {handleOnChange}  required />

                    <Form.Label>Enter Email address</Form.Label>
                    <Form.Control id = "email" value={data.email} type="email" placeholder="Enter email" pattern=".+@dal.ca" onChange = {handleOnChange}  required />
                    <Form.Control.Feedback type="invalid">
                        Please provide a valid email.
                    </Form.Control.Feedback>

                    <Form.Label>Enter Contact No.</Form.Label>
                    <Form.Control id = "contact" value={data.contact} type="tel" placeholder="Enter Contact No." onChange = {handleOnChange}  required />
                    <Form.Control.Feedback type="invalid">
                        Please provide a valid contact.
                    </Form.Control.Feedback>

                    <Form.Label>Upload Offer Letter</Form.Label>
                    <Form.Control id = "offerletter" value={data.offerletter} type="file" placeholder="Upload Offer Letter" onChange = {handleOnChange}  required />


                    <Form.Label>Create password</Form.Label>
                    <Form.Control id="password" value={data.password} type="password" placeholder="Create Password" onChange = {handleOnChange}  required />
                    <Form.Control.Feedback type="invalid">
                        Please provide a valid password.
                    </Form.Control.Feedback>

                    <Form.Label>Re-enter Password</Form.Label>
                    <Form.Control id="confirmpassword" value={data.confirmpassword} type="password" placeholder="Re-enter Password" onChange = {handleOnChange}  required />
                    <Form.Control.Feedback type="invalid">
                        Please provide a valid password.
                    </Form.Control.Feedback>
                </Form.Group>
            )}

            {selectedOption === 'option2' && (
                <Form.Group controlId="formBasicUsername">

                    <Form.Label>Enter First Name</Form.Label>
                    <Form.Control id = "firstname" value={data.firstname} type="text" placeholder="Enter First Name" onChange = {handleOnChange}  required />

                    <Form.Label>Enter Last Name</Form.Label>
                    <Form.Control id = "lastname" value={data.lastname} type="text" placeholder="Enter Last Name" onChange = {handleOnChange}  required />

                    <Form.Label>Owner type? (Lease or Roommate)</Form.Label>
                    <select className="form-select" id="type" value={data.type} aria-label="Select type" onChange = {handleOnChange}  required>
                        <option selected>Select type</option>
                        <option value="1">Student</option>
                        <option value="2">Owner</option>
                    </select>
                    <Form.Control.Feedback type="invalid">
                        Please Select something.
                    </Form.Control.Feedback>

                    <Form.Label>Enter Email address</Form.Label>
                    <Form.Control id = "email" value={data.email} type="email" placeholder="Enter email" onChange = {handleOnChange}  required />
                    <Form.Control.Feedback type="invalid">
                        Please provide a valid email.
                    </Form.Control.Feedback>

                    <Form.Label>Enter Contact No.</Form.Label>
                    <Form.Control id = "contact" value={data.contact}type="tel" placeholder="Enter Contact No."  pattern="^[0-9]{10}$" onChange = {handleOnChange} required />
                    <Form.Control.Feedback type="invalid">
                        Please provide a valid contact.
                    </Form.Control.Feedback>

                    <Form.Label>Create password</Form.Label>
                    <Form.Control id="password" value={data.password} type="password" placeholder="Create Password" onBlur="{handlePasswordChange}" onChange = {handleOnChange}  required />
                    <Form.Control.Feedback type="invalid">
                        Please provide a valid password.
                    </Form.Control.Feedback>

                    <Form.Label>Re-enter Password</Form.Label>
                    <Form.Control type="password" placeholder="Re-enter Password" onKeyUp="{handleReenteredPasswordChange}" onChange = {handleOnChange} required />
                    <Form.Control.Feedback type="invalid">
                        Please provide a valid password.
                    </Form.Control.Feedback>
                </Form.Group>
            )}

            <br/>
            <div className="d-grid">
                {/*{!passwordsMatch && <p>Passwords do not match.</p>}*/}
                <button type="submit" className="btn btn-primary">
                    Submit
                </button>
            </div>
        </Form>

    );
};

export default RegistrationForm;
