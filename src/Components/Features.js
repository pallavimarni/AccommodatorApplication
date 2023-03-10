import React from 'react';
import { Card, Button } from 'react-bootstrap';
const FeaturesData = [
    {
        id: 1,
        title: 'Roommate Finder',
        image: 'card-image-1.jpg',
        description: 'Content for Card 1',
        buttonLabel: 'Button 1',
        buttonLink: 'https://example.com/button-1',
    },
    {
        id: 2,
        title: 'Add Posting',
        image: 'card-image-2.jpg',
        description: 'Content for Card 2',
        buttonLabel: 'Button 2',
        buttonLink: 'https://example.com/button-2',
    },
    {
        id: 3,
        title: 'See Posting',
        image: 'card-image-3.jpg',
        description: 'Content for Card 3',
        buttonLabel: 'Button 3',
        buttonLink: 'https://example.com/button-3',
    },
    {
        id: 4,
        title: 'Map',
        image: 'card-image-4.jpg',
        description: 'Content for Card 4',
        buttonLabel: 'Button 4',
        buttonLink: 'https://example.com/button-4',
    },
    {
        id: 5,
        title: 'See Favourites',
        image: 'card-image-5.jpg',
        description: 'Content for Card 5',
        buttonLabel: 'Button 5',
        buttonLink: 'https://example.com/button-5',
    },
    /*{
        id: 6,
        title: 'Card 6',
        image: 'card-image-6.jpg',
        description: 'Content for Card 6',
        buttonLabel: 'Button 6',
        buttonLink: 'https://example.com/button-6',
    },*/
];
function Features() {
    return (<div className="auth-wrapper">
        <div className="container">
            <div className="row">
                {FeaturesData.map((card) => (
                    <div className="col-md-4 mb-4" key={card.id}>
                        <Card>
                            <Card.Img variant="top" src={card.image} />
                            <Card.Body>
                                <Card.Title>{card.title}</Card.Title>
                                <Card.Text>{card.description}</Card.Text>
                                <Button variant="primary" href={card.buttonLink}>
                                    {card.buttonLabel}
                                </Button>
                            </Card.Body>
                        </Card>
                    </div>
                ))}
            </div>
        </div>
    </div>);
}
export default Features;
