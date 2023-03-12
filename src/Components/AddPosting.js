import React from 'react';
import axios from 'axios';

class AddPost extends React.Component {
    ownerId = localStorage.getItem('ownerId');
    constructor(props) {
        super(props);
        this.state = {
            image: [],
            description: '',
            Rent: '',
            address: '',
            city: '',
            province: '',
            error: '',
        };

        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    validateImages(files) {
        const validExtensions = ['.jpg', '.jpeg', '.png'];
        for (let i = 0; i < files.length; i++) {
            const extension = files[i].name.split('.').pop().toLowerCase();
            if (!validExtensions.includes('.' + extension)) {
                return false;
            }
        }
        return true;
    }

    handleChange(event) {
        const {name, value, files} = event.target;
        if (name === 'image') {
            if (!this.validateImages(files)) {
                this.setState({error: 'Invalid file type. Please select images with .jpg, .jpeg, or .png extensions.'});
            } else {
                this.setState({image: files, error: ''});
            }
        } else {
            this.setState({[name]: value});
        }
    }

    handleSubmit(event) {
        event.preventDefault();
        const {image, description, Rent, address, city, province} = this.state;

        // Get the current date
        const currentDate = new Date();
        const formattedDate = `${currentDate.getFullYear()}-${currentDate.getMonth() + 1}-${currentDate.getDate()}`;

        // Fetch owner ID from the database
        axios
            .get('http://localhost:8080/owner/login', {params: {email: localStorage.getItem('email')}})
            .then((response) => {
                if (response.status === 200) {
                    const ownerId = response.data.ownerId;

                    // Create a new post with the owner ID and date
                    const formData = new FormData();
                    for (let i = 0; i < image.length; i++) {
                        formData.append('image', image[i]);
                    }
                    formData.append('description', description);
                    formData.append('Rent', Rent);
                    formData.append('address', address);
                    formData.append('city', city);
                    formData.append('province', province);
                    formData.append('date', formattedDate);
                    formData.append('ownerId', ownerId);

                    axios
                        .post('http://localhost:8080/Posting', formData, {
                            headers: {
                                'Content-Type': 'multipart/form-data',
                            },
                        })
                        .then((response) => {
                            if (response.status === 200) {
                                // Post creation succeeded, redirect to the homepage
                                window.location.href = '/home';
                            } else {
                                // Post creation failed, display an error message
                                console.error('Post creation failed:', response.data.message);
                            }
                        })
                        .catch((error) => {
                            console.error('An error occurred:', error);
                        });
                } else {
                    console.error('Owner not found:', response.data.message);
                }
            })
            .catch((error) => {
                console.error('An error occurred:', error);
            });
    }

    render() {
        const { error } = this.state;
        return (
             <div className="auth-wrapper">
                <div className="form-container">
                    <div className="auth-inner">
                        <h2 className="text-center mb-3">
                            Add a Post
                        </h2>
                        <form onSubmit={this.handleSubmit}>
                            <div className="form-group">
                                <label htmlFor="image">
                                    Images
                                </label>
                                <input
                                    type="file"
                                    className="form-control-file"
                                    id="image"
                                    name="image"
                                    onChange={this.handleChange}
                                    multiple
                                    required
                                />
                            </div>
                            <div className="form-group">
                                <label htmlFor="description">
                                    Description
                                </label>
                                <textarea
                                    className="form-control"
                                    id="description"
                                    name="description"
                                    onChange={this.handleChange}
                                    required
                                />
                            </div>
                            <div className="form-group">
                                <label htmlFor="Rent">
                                    Rent
                                </label>
                                <input
                                    type="number"
                                    className="form-control"
                                    id="Rent"
                                    name="rent"
                                    onChange={this.handleChange}
                                    required
                                />
                            </div>
                            <div className="form-group">
                                <label htmlFor="address">
                                    Address
                                </label>
                                <input
                                    type="text"
                                    className="form-control"
                                    id="address"
                                    name="address"
                                    onChange={this.handleChange}
                                    required
                                />
                            </div>
                            <div className="form-group">
                                <label htmlFor="city">
                                    City
                                </label>
                                <input
                                    type="text"
                                    className="form-control"
                                    id="city"
                                    name="city"
                                    onChange={this.handleChange}
                                    required
                                />
                            </div>
                            <div className="form-group">
                                <label htmlFor="province">
                                    Province
                                </label>
                                <input
                                    type="text"
                                    className="form-control"
                                    id="province"
                                    name="province"
                                    onChange={this.handleChange}
                                    required
                                />
                            </div>
                            {error && <div className="alert alert-danger">{error}</div>}
                            <div className="form-group mt-3">
                                <button type="submit" className="btn btn-primary btn-block">
                                    Submit
                                </button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        );
    }

}
    export default AddPost;