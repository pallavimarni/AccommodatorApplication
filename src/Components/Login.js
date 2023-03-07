import React from 'react';
import axios from 'axios';


class Login extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            email: '',
            password: '',
            userType: 'Owner'
        };

        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
        this.handleUserTypeChange = this.handleUserTypeChange.bind(this);
    }

    handleChange(event) {
        const {name, value} = event.target;
        this.setState({[name]: value});
    }

    handleSubmit(event) {
        event.preventDefault();
        const {email, password, userType} = this.state;

        if (!email.endsWith('@dal.ca')) {
            console.error('Invalid email address.');
            return;
        }
        // const url = userType === 'Student' ? 'http://localhost:8080/student/login' : 'http://localhost:8080/owner/login';
        if (this.state.userType === 'Student') {
            axios.post('http://localhost:8080/student/login', {email, password})
                .then(response => {
                    if (response.status === 200) {
                        // authentication succeeded, grant access
                        window.location.href = '/home';
                    } else {
                        // authentication failed, display an error message
                        alert("Invalid email or password");
                        console.error('Authentication failed:', response.data.message);
                    }
                })
                .catch(error => {
                    alert("Invalid email or password");
                    console.error('An error occurred:', error);

                });
        } else {
            axios.post('http://localhost:8080/owner/login', {email, password})
                .then(response => {
                    if (response.status === 200) {
                        // authentication succeeded, grant access
                        window.location.href = '/home';
                    } else {
                        // authentication failed, display an error message
                        alert("Invalid email or password");
                        console.error('Authentication failed:', response.data.message);
                    }
                })
                .catch(error => {
                    alert("Invalid email or password");
                    console.error('An error occurred:', error);

                });
        }
    }

    handleUserTypeChange(event) {
        this.setState({ userType: event.target.value });
    }


    render()
    {
        return (
            <form onSubmit={this.handleSubmit}>
                <h3>Sign In</h3>
                <div className="mb-3">
                    <label>Email address</label>
                    <input
                        id="email"
                        name="email"
                        type="email"
                        className="form-control"
                        placeholder="Enter email" value={this.state.email} onChange={this.handleChange}
                        required
                    />
                </div>
                <div className="mb-3">
                    <label>Password</label>
                    <input
                        id="password"
                        name="password"
                        type="password"
                        className="form-control"
                        placeholder="Enter password"
                        value={this.state.password} onChange={this.handleChange}
                        required
                    />
                </div>
                <div className="mb-3">
                    <input id="Student" name="userType" type="radio" value="Student" checked={this.state.userType === 'Student'} onChange={this.handleUserTypeChange} />
                    <label>Student</label>
                    <input id="Owner" name="userType" type="radio" value="Owner" checked={this.state.userType === 'Owner'} onChange={this.handleUserTypeChange} />
                    <label>Owner</label>
                </div>
                <div className="mb-3">
                    <div className="custom-control custom-checkbox">
                        <input
                            type="checkbox"
                            className="custom-control-input"
                            id="customCheck1"
                        />
                        <label className="custom-control-label" htmlFor="customCheck1">
                            Remember me
                        </label>
                    </div>
                </div>
                <div className="d-grid">
                    <button type="submit" className="btn btn-primary">
                        Submit
                    </button>
                </div>

                <p className="forgot-password text-right">
                    Forgot <a href="Posting.js">password?</a>
                </p>
            </form>
        );
    }
};


export default Login;

