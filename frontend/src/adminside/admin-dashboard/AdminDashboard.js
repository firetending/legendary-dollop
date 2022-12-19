import React, { Component } from 'react'
import Sidebar from '../sidebar'
import { Image, Card, Container, Row, Col } from 'react-bootstrap'
import 'bootstrap/dist/css/bootstrap.min.css'

// Displays every menu in a list and allows the user to select a menu.
const MenuScrollList = (props) => {
    const selectables = props.menuListData.map((menu) => {
        return (
            <p>
                <label>
                    <input type="radio" name="menuSelection" onClick={() => props.selectMenu(menu.items)} />
                    {menu.name} - {props.getTotalOrders(menu.items)} Orders
                </label>
            </p>
        )
    })

    selectables.unshift(
        <p>
            <label>
                <input type="radio" name="menuSelection"
                    onClick={() => props.selectMenu(props.menuListData.map((menu) => {
                        return menu.items
                    }).flat(1))} />
                All Menus - {props.getAllOrders(props.menuListData)} Orders
            </label>
        </p>
    )

    return <div className='scrollList'><ul>{selectables}</ul></div>
}

// Takes in an array of a single menu and then displays a list of all of its items and their orders.
const ItemList = (props) => {
    if (props.items === null || props.items.length <= 0) {
        return (
            <Card>
                <Card.Title>Click on a menu to see its items.</Card.Title>
                <Card.Subtitle>Order counts on each individual item will be displayed here in a list.</Card.Subtitle>
            </Card>
        )
    } else {
        const listedItems = props.items.map((item) => {
            return (
                <Card border="light" style={{ width: '30rem' }} className='menuItem'>
                    <Card.Body>
                        <Container fluid style={{ padding: '0px' }}>
                            <Row>
                                <Col xs={3}><Image rounded thumbnail src={item.image} />
                                </Col>
                                <Col>
                                    <Card.Title>{item.name}</Card.Title>
                                    <Card.Subtitle>{item.orders} Orders</Card.Subtitle>
                                    <Card.Text>{item.description}</Card.Text>
                                </Col>
                            </Row>
                        </Container>
                    </Card.Body>
                </Card>
            )
        })

        return (
            <Row className='itemList'>{listedItems}</Row>
        )
    }
}

//Generates an array of up to 15 food items with randomn numbers as names, each with their own amount of orders.
class AdminDashboardPage extends Component {

    fakeItems = () => {
        let itemAmount = Math.round(Math.random() * 15)
        let items = []
        while (itemAmount > 0) {
            items.push(
                {
                    name: `Item ${Math.round(Math.random() * 100)}`,
                    description: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.',
                    image: 'https://picsum.photos/100',
                    orders: Math.round(Math.random() * 8)
                }
            )
            itemAmount--
        }
        return items
    }

    //Takes in an array of food items and returns the sum of all of their orders added together.
    getTotalOrders = (array) => {
        let totalOrders = 0
        for (let item of array) {
            totalOrders += item.orders
        }
        return totalOrders
    }

    //Takes in an array of menus and returns the sum of all their orders added together.
    getAllOrders = (array) => {
        let totalOrders = 0
        for (let menu of array) {
            totalOrders += this.getTotalOrders(menu.items)
        }
        return totalOrders
    }

    state = {
        menus: [
            {
                id: 0,
                name: "Breakfast Menu",
                orders: 0,
                items: this.fakeItems()
            },
            {
                id: 1,
                name: "Lunch Menu",
                orders: 0,
                items: this.fakeItems()
            },
            {
                id: 2,
                name: "Dinner Menu",
                orders: 0,
                items: this.fakeItems()
            },
            {
                id: 3,
                name: "Special Menu",
                orders: 0,
                items: this.fakeItems()
            },
            {
                id: 4,
                name: "Desert Menu",
                orders: 0,
                items: this.fakeItems()
            },
        ],
        selectedMenuItems: []
    }

    //Selects a menu by id.
    selectMenuItems = (items) => {
        const { selectedMenuItems } = this.state;
        this.setState({
            selectedMenuItems: items
        })
    }

    render() {
        const { menus, selectedMenuItems } = this.state;

        return (
            <Container fluid>
                <Row>
                    <Col md="auto" className='sidebar'>
                        <Sidebar />
                    </Col>
                    <Col className='main'>
                        <div className='top'>
                            <h1 className='title'>Dashboard</h1>
                            <h1 className='largetitle'>Hello, admin</h1>
                        </div>
                        <h2>{this.getAllOrders(menus)} New Orders</h2>
                        <div className='bottom'>
                            <Container>
                                <Row>
                                    <Col>
                                        <h2>Menus</h2><a href=''>Manage Menus</a>
                                    </Col>
                                    <Col>
                                        <h2>Orders</h2> <a href=''>Order Log</a>
                                    </Col>
                                </Row>
                                <Row>
                                    <Col md='auto'>
                                        <MenuScrollList menuListData={menus} selectMenu={this.selectMenuItems} getTotalOrders={this.getTotalOrders} getAllOrders={this.getAllOrders} />
                                    </Col>
                                    <Col>
                                        <ItemList items={selectedMenuItems} />
                                    </Col>
                                </Row>
                            </Container>
                        </div>
                    </Col>
                </Row>
            </Container>
        )
    }
}

export default AdminDashboardPage