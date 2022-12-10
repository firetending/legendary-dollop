import React, { Component } from 'react'
import { Nav } from "react-bootstrap";
import 'bootstrap/dist/css/bootstrap.min.css'
import './adminstyles.css'

class Sidebar extends Component {
    render() {
        return (
            <Nav className="navbar navbar-light flex-column" activeKey="/home" id="sidebar" >
                <Nav.Item>
                    <Nav.Link href="/home">Dashboard</Nav.Link>
                </Nav.Item>
                <Nav.Item>
                    <Nav.Link href="/home">Menus</Nav.Link>
                </Nav.Item>
                <Nav.Item>
                    <Nav.Link href="/home">Administration</Nav.Link>
                </Nav.Item>
                <Nav.Item>
                    <Nav.Link href="/home">Reports</Nav.Link>
                </Nav.Item>
                <Nav.Item>
                    <Nav.Link href="/home">Order Log</Nav.Link>
                </Nav.Item>
            </Nav>
        )
    }
}

export default Sidebar