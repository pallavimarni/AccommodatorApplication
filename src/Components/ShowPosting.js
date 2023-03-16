import React from 'react';
import { Container, Row, Col, Card, Button } from 'react-bootstrap';
import { HeartFill } from 'react-bootstrap-icons';

function ShowPosting(props) {

    /*const { posts } = props;*/
    const posts=[
        {
            id: 1,
            image: "https://img.staticmb.com/mbcontent//images/uploads/2022/12/Most-Beautiful-House-in-the-World.jpg",
            title: "Cozy apartment in downtown",
            description: "A lovely apartment with a great view of the city",
            rent: "$1000/month",
            address: "123 Main St",
            pincode: "12345",
            category: "Apartment",
            email: "my880578@dal.ca"
        },
        {
            id: 2,
            image: "https://img.staticmb.com/mbcontent//images/uploads/2022/12/Most-Beautiful-House-in-the-World.jpg",
            title: "Cozy apartment in downtown",
            description: "A lovely apartment with a great view of the city",
            rent: "$1000/month",
            address: "123 Main St",
            pincode: "12345",
            category: "Apartment"
        },
        {
            id: 2,
            image: "https://img.staticmb.com/mbcontent//images/uploads/2022/12/Most-Beautiful-House-in-the-World.jpg",
            title: "Cozy apartment in downtown",
            description: "A lovely apartment with a great view of the city",
            rent: "$1000/month",
            address: "123 Main St",
            pincode: "12345",
            category: "Apartment"
        },
        {
            id: 2,
            image: "https://img.staticmb.com/mbcontent//images/uploads/2022/12/Most-Beautiful-House-in-the-World.jpg",
            title: "Cozy apartment in downtown",
            description: "A lovely apartment with a great view of the city",
            rent: "$1000/month",
            address: "123 Main St",
            pincode: "12345",
            category: "Apartment"
        },{
            id: 2,
            image: "https://img.staticmb.com/mbcontent//images/uploads/2022/12/Most-Beautiful-House-in-the-World.jpg",
            title: "Cozy apartment in downtown",
            description: "A lovely apartment with a great view of the city",
            rent: "$1000/month",
            address: "123 Main St",
            pincode: "12345",
            category: "Apartment"
        },{
            id: 2,
            image: "https://img.staticmb.com/mbcontent//images/uploads/2022/12/Most-Beautiful-House-in-the-World.jpg",
            title: "Cozy apartment in downtown",
            description: "A lovely apartment with a great view of the city",
            rent: "$1000/month",
            address: "123 Main St",
            pincode: "12345",
            category: "Apartment"
        }
    ];

    return (
        <div className="auth-wrapper">
            <div className="mt-5">
            <div className="row">
                <div className="col-md-3">
                    <div className="card p-3">
                        <h2 className="text-center text-uppercase text-BLACK mb-4">Filter Properties</h2>
                        <form>
                            <div className="form-group">
                                <label htmlFor="rent">Rent:</label>
                                <input type="range" min="1" max="10000" className="form-control-range" id="rent" name="rent" onInput={(event) => {document.getElementById("rent-value").innerHTML = event.target.value}} />
                                <div className="d-flex justify-content-between">
                                    <small>$1</small>
                                    <small>$10,000</small>
                                </div>
                                <div id="rent-value"></div>
                            </div>
                            <div className="form-group">
                                <label htmlFor="category">Category:</label>
                                <select className="form-control" id="category" name="category">
                                    <option value="">Select Lease/ Roommate</option>
                                    <option value="Lease">Lease</option>
                                    <option value="Roommate">Roommate</option>
                                </select>
                            </div>
                            <div className="form-group">
                                <label htmlFor="zip">Preffered zip code:</label>
                                <input type="text" className="form-control" id="zip" name="zip" />
                            </div>
                            <button type="submit" className="btn btn-primary">Filter</button>
                        </form>

                    </div>
                </div>
                <div className="col-md-9">
                    <div className="card p-3">
                        <h2 className="text-center text-uppercase text-BLACK mb-4">Latest Postings</h2>

                        <Container>
                            {posts.map((post, index) => (
                                index % 3 === 0 && (
                                    <Row key={index} className="my-3">
                                        <Col>
                                            <Card>

                                                <Card.Img variant="top" src={post.image} />
                                                <Card.Body>

                                                    <Card.Title>{post.title}</Card.Title>
                                                    <Card.Text>{post.description}</Card.Text>
                                                    <Card.Text>Rent: {post.rent}</Card.Text>
                                                    <Card.Text>Address: {post.address}, {post.pincode}</Card.Text>
                                                    <Card.Text>Category: {post.category}</Card.Text>
                                                    <Button variant="primary" onClick={() => handleConnectClick(post.email)}>Connect with owner</Button>
                                                </Card.Body>
                                            </Card>
                                        </Col>
                                        {posts[index + 1] && (
                                            <Col>
                                                <Card>
                                                    <Card.Img variant="top" src={posts[index + 1].image} />
                                                    <Card.Body>
                                                        <Card.Title>{posts[index + 1].title}</Card.Title>
                                                        <Card.Text>{posts[index + 1].description}</Card.Text>
                                                        <Card.Text>Rent: {posts[index + 1].rent}</Card.Text>
                                                        <Card.Text>Address: {posts[index + 1].address}, {posts[index + 1].pincode}</Card.Text>
                                                        <Card.Text>Category: {posts[index + 1].category}</Card.Text>
                                                        <Button variant="primary" onClick={() => handleConnectClick(post.email)}>Connect with owner</Button>
                                                    </Card.Body>
                                                </Card>
                                            </Col>
                                        )}
                                        {posts[index + 2] && (
                                            <Col>
                                                <Card>
                                                    <Card.Img variant="top" src={posts[index + 2].image} />
                                                    <Card.Body>
                                                        <Card.Title>{posts[index + 2].title}</Card.Title>
                                                        <Card.Text>{posts[index + 2].description}</Card.Text>
                                                        <Card.Text>Rent: {posts[index + 2].rent}</Card.Text>
                                                        <Card.Text>Address: {posts[index + 2].address}, {posts[index + 2].pincode}</Card.Text>
                                                        <Card.Text>Category: {posts[index + 2].category}</Card.Text>
                                                        <Button variant="primary" onClick={() => handleConnectClick(post.email)}>Connect with owner</Button>
                                                    </Card.Body>
                                                </Card>
                                            </Col>
                                        )}
                                    </Row>
                                )
                            ))}
                        </Container>
                    </div>
                </div>
            </div>
        </div>
        </div>
    );
                }

export default ShowPosting;


