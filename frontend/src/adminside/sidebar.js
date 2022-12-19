import React, { Component } from 'react'
import { Nav } from "react-bootstrap";
import 'bootstrap/dist/css/bootstrap.min.css'
import './adminstyles.css'

class Sidebar extends Component {
    render() {
        return (
            <Nav className="navbar navbar-light flex-column" activeKey="/home" id="sidebar" >
                <Nav.Item>
                    <Nav.Link href="/home" style={{ color: 'white' }}>Dashboard</Nav.Link>
                </Nav.Item>
                <Nav.Item>
                    <Nav.Link href="/home" style={{ color: 'white' }}>Menus</Nav.Link>
                </Nav.Item>
                <Nav.Item>
                    <Nav.Link href="/home" style={{ color: 'white' }}>Administration</Nav.Link>
                </Nav.Item>
                <Nav.Item>
                    <Nav.Link href="/home" style={{ color: 'white' }}>Reports</Nav.Link>
                </Nav.Item>
                <Nav.Item>
                    <Nav.Link href="/home" style={{ color: 'white' }}>Order Log</Nav.Link>
                </Nav.Item>
            </Nav>
        )
    }
}

export default Sidebar