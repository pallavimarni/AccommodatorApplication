import React from 'react';
import { Container, Row, Col, Card, Button } from 'react-bootstrap';
import axios from 'axios';

function DisplayStudentsAfterPref() {

    const posts = [
        { name: 'Pallavi ', contact: '1234567890' },

        { name: 'Mayank ', contact: '1234567890' },
        { name: 'Smit ', contact: '1234567890' },
        { name: 'Fenil ', contact: '1234567890' },
        { name: 'Shashwat ', contact: '1234567890' },
        { name: 'Tushar ', contact: '1234567890' }
    ];

    // const [posts, setPosts] = React.useState([]);
    //
    // React.useEffect(() => {
    //     axios.get('http://localhost:8080/posting/get/all', {
    //         name: posts.name,
    //         contact: posts.contact,
    //         email: posts.email
    //     })
    //         .then(response => {
    //             setPosts(response.data);
    //             console.log(response.data);
    //         })
    //         .catch(error => {
    //             console.error(error);
    //         });
    // }, []);

    function handleConnectClick(email) {
        console.log('Contact with owner on ', email);
    }
    return (
        <div className="auth-wrapper">

                            <h2 className="text-center text-uppercase text-BLACK mb-4">Latest Postings</h2>

                            <Container>
                                {posts.map((post, index) => {
                                    if (index % 3 === 0) {
                                        const cards = [];
                                        for (let i = index; i < index + 3 && i < posts.length; i++) {
                                            const post = posts[i];
                                            cards.push(
                                                <Col key={i}>
                                                    <Card>
                                                        <button className="favorite-button">
                                                            <i className="fa fa-heart"></i> Add to favorites
                                                        </button>

                                                        <Card.Body>
                                                            <Card.Title>{post.name}</Card.Title>
                                                            <Card.Text>{post.contact}</Card.Text>
                                                            <Button variant="primary" onClick={() => handleConnectClick(post.email)}>Connect with student</Button>
                                                        </Card.Body>
                                                    </Card>
                                                </Col>
                                            );
                                        }
                                        return (
                                            <Row key={index} className="my-3">
                                                {cards}
                                            </Row>
                                        );
                                    }
                                })}
                            </Container>
                        </div>

    );
}

export default DisplayStudentsAfterPref;