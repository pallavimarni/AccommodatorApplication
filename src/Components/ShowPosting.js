import React from 'react';
import { Container, Row, Col, Card, Button } from 'react-bootstrap';
/*ShowPosting component takes a posts array as a prop, which contains objects
representing each post with id, title, author, and content properties.
    The map function is used to iterate over the posts array and generate a Card component for each post.
    The href attribute of the Button component is set to a dynamic link that includes the post ID,
    so clicking the "Read More" button will take the user to the individual post page.*/
/*https://stackoverflow.com/questions/68322423/how-to-create-a-dynamic-grid-in-react-js - For reference*/
function ShowPosting(props) {
    const { posts } = props;

    return (
        <div>
            <Container>
                <Row>
                    {posts.map((post) => (
                        <Col key={post.id} className="my-3">
                            <Card>
                                <Card.Body>
                                    <Card.Title>{post.title}</Card.Title>
                                    <Card.Subtitle className="mb-2 text-muted">{post.author}</Card.Subtitle>
                                    <Card.Text>{post.content}</Card.Text>
                                    <Button variant="primary" href={`/post/${post.id}`}>
                                        Read More
                                    </Button>
                                </Card.Body>
                            </Card>
                        </Col>
                    ))}
                </Row>
            </Container>
        </div>
    );
}
export default ShowPosting;
