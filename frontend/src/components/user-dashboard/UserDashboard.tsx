import './UserDashboard.scss';
import "bootstrap/dist/css/bootstrap.min.css";
import { Nav, Container } from 'react-bootstrap';
import { Link, Outlet } from 'react-router-dom';


const DashBoardNav = () => {
    return (
        <Container fluid className='user-dashboard'>
            <Nav fill variant="tabs" defaultActiveKey="/home" className='my-5 justify-content-center'>
                <Nav.Item>
                    <Nav.Link as={Link} to="todaysmeals" eventKey="link-1">Todays Meals</Nav.Link>
                </Nav.Item>
                <Nav.Item>
                    <Nav.Link as={Link} to="futuremeals" eventKey="link-2">Future Meals</Nav.Link>
                </Nav.Item>
                <Nav.Item>
                    <Nav.Link as={Link} to="pastmeals" eventKey="link-3">Past Meals</Nav.Link>
                </Nav.Item>
                <Nav.Item>
                    <Nav.Link as={Link} to="userprofile" eventKey="link-4">
                    Profile
                    </Nav.Link>
                </Nav.Item>
            </Nav>

            <Outlet />

        </Container>

    );



};

export default DashBoardNav