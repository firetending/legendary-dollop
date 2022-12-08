import React, { Component } from 'react'
import Sidebar from '../sidebar'
import '../adminstyles.css'

// Displays every menu in a list and allows the user to select a menu.
const MenuScrollList = (props) => {
    const selectables = props.menuListData.map((menu) => {
        return (
            <p>
                <label>
                    <input type="radio" name="menuSelection" onClick={() => props.selectMenu(menu.id)} />
                    {menu.name} - {props.getTotalOrders(menu.items)} Orders
                </label>
            </p>
        )
    })

    selectables.unshift(
        <p>
            <label>
                <input type="radio" name="menuSelection" />
                All Menus - {props.getAllOrders(props.menuListData)} Orders
            </label>
        </p>
    )

    return <div className='scrollList'><ul>{selectables}</ul></div>
}

// Takes in an array of a single menu and then displays a list of all of its items and their orders.
const ItemList = (props) => {
    let reactLovesToBreak = props.menuData;
    if (reactLovesToBreak === null || reactLovesToBreak.length <= 0) {
        return <div className='itemList'><p>Click on a menu to see its orders.</p></div>
    } else {
        const items = reactLovesToBreak[0].items;
        const listedItems = items.map((item) => {
            return (
                <div className='menuItem'>
                    <label>{item.name} ({item.orders})</label>
                </div>
            )
        })

        return <div className='itemList'>{listedItems}</div>
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
                    description: 'Food Item',
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
        selectedMenu: []
    }

    //Selects a menu by id.
    selectMenu = (id) => {
        const { menus } = this.state;
        this.setState({
            selectedMenu: menus.filter((menu) => {
                return menu.id === id
            })
        })
    }

    selectAllMenus = () => {
        const { menus } = this.state;
        this.setState({
            selectedMenu: {
                id: -1,
                name: "All Menus",
                orders: 0,
                items: 'a'
            }
        })
    }

    render() {
        const { menus, selectedMenu } = this.state;

        return (
            <div className='adminDashboardPage'>
                <Sidebar />
                <main>
                    <div className='top'>
                        <h1 className='title'>Dashboard</h1>
                        <h1 className='largetitle'>Hello, admin</h1>
                    </div>
                    <h2>{this.getAllOrders(menus)} New Orders</h2>
                    <div className='bottom'>
                        <table>
                            <tr>
                                <th>Menus</th><a href=''>Manage Menus</a>
                                <th>Orders</th><a href=''>Order List</a>
                            </tr>
                            <tr>
                                <td className='scrollList'>
                                    <MenuScrollList menuListData={menus} selectMenu={this.selectMenu} getTotalOrders={this.getTotalOrders} getAllOrders={this.getAllOrders} />
                                </td>
                                <td className='scrollList'>
                                    <ItemList menuData={selectedMenu} />
                                </td>
                            </tr>
                        </table>
                    </div>
                </main>
            </div>
        )
    }
}

export default AdminDashboardPage