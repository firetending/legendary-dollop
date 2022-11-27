import React, { Component } from 'react'
import Sidebar from '../sidebar'
import '../adminstyles.css'

state = {
    menus: [
        {
            id: 0,
            name: "Breakfast Menu",
            orders: 20
        },
        {
            id: 1,
            name: "Lunch Menu",
            orders: 23
        },
        {
            id: 2,
            name: "Dinner Menu",
            orders: 8
        },
        {
            id: 3,
            name: "Special Menu",
            orders: 12
        },
    ]
}


class AdminDashboardPage extends Component {

    render() {
        return (
            <div className='adminDashboardPage'>
                <Sidebar />
                <main>
                    <h1 className='title'>Dashboard</h1>
                    <h1 className='largetitle'>Hello, admin</h1>

                </main>
            </div>
        )
    }
}

export default AdminDashboardPage