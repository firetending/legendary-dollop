import React, { Component } from 'react'
import Sidebar from '../sidebar'
import '../adminstyles.css'

const MenuScrollList = (props) => {
    const selectables = props.menuListData.map((menu, index) => {
        return (
            <p>
                <label>
                    <input type="radio" name="menuSelection" onClick={() => props.selectMenu(menu.id)} />
                    {menu.name} - {menu.orders} Orders
                </label>
            </p>
        )
    })

    return <div className='scrollList'><ul>{selectables}</ul></div>
}

const ItemList = (props) => {
    let reactLovesToBreak = props.menuData;
    if (reactLovesToBreak === null || reactLovesToBreak.length <= 0) {
        return <div className='itemList'><p>Click on a menu to see its orders.</p></div>
    } else {
        const items = reactLovesToBreak[0].items;
        const listedItems = items.map((item, index) => {
            return (
                <div className='menuItem'>
                    <p>{item.name} ({item.orders})</p>
                </div>
            )
        })

        return <div className='itemList'>{listedItems}</div>
    }
}

class AdminDashboardPage extends Component {

    //Generates an array of up to 15 food items with randomn numbers as names, each with their own amount of orders.
    fakeItems = () => {
        let itemAmount = Math.round(Math.random() * 15)
        let items = []
        while (itemAmount > 0) {
            items.push(
                {
                    name: `Item ${Math.round(Math.random() * 100)}`,
                    orders: Math.round(Math.random() * 15)
                }
            )
            itemAmount--
        }
        return items
    }

    state = {
        menus: [
            {
                id: 0,
                name: "Breakfast Menu",
                orders: 20,
                items: this.fakeItems()
            },
            {
                id: 1,
                name: "Lunch Menu",
                orders: 23,
                items: this.fakeItems()
            },
            {
                id: 2,
                name: "Dinner Menu",
                orders: 8,
                items: this.fakeItems()
            },
            {
                id: 3,
                name: "Special Menu",
                orders: 12,
                items: this.fakeItems()
            },
            {
                id: 4,
                name: "Desert Menu",
                orders: 34,
                items: this.fakeItems()
            },
        ],
        selectedMenu: []
    }

    //Selects a menu by id.
    selectMenu = (id) => {
        const { menus } = this.state;
        this.setState({
            selectedMenu: menus.filter((menu, i) => {
                return menu.id === id
            })
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
                    <div className='bottom'>
                        <MenuScrollList menuListData={menus} selectMenu={this.selectMenu} />
                        <ItemList menuData={selectedMenu} />
                    </div>
                </main>
            </div>
        )
    }
}

export default AdminDashboardPage