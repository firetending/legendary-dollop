import React, { Component } from 'react'
import Sidebar from '../sidebar'
import '../adminstyles.css'

const MenuScrollList = (props) => {
    const selectables = props.menuData.map((menu, index) => {
        return (
            <p>
                <label><input type="radio" name="menuSelection" value={menu.id} />{menu.name} - {menu.orders} Orders</label>
            </p>
        )
    })

    return <div className='scrollList'><ul>{selectables}</ul></div>
}

const ItemList = (props) => {
    const items = props.menuData.map((item, index) => {
        return (
            <div className='menuItem'>
                <p>{item.name}</p>
            </div>
        )
    })

    return <div className='itemList'>{items}</div>
}

class AdminDashboardPage extends Component {

    fakeItems = () => {
        let itemAmount = Math.round(Math.random() * 15)
        let items = []
        while (itemAmount > 0) {
            items.push(
                {
                    name: `${Math.round(Math.random() * 100)}`,
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
        ]
    }

    render() {
        const { menus } = this.state

        return (
            <div className='adminDashboardPage'>
                <Sidebar />
                <main>
                    <div className='top'>
                        <h1 className='title'>Dashboard</h1>
                        <h1 className='largetitle'>Hello, admin</h1>
                    </div>
                    <div className='bottom'>
                        <MenuScrollList menuData={menus} />
                        <ItemList menuData={menus} />
                    </div>
                </main>
            </div>
        )
    }
}

export default AdminDashboardPage