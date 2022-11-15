import React, { Component } from 'react'
import Sidebar from '../sidebar'

class MenuManagementPage extends Component {
    render() {
        return (
            <div className="menuManagementPage">
                <Sidebar />
                <main>
                    <h1>Menu Management Page</h1>
                    <div className="menuList">

                    </div>
                </main>
            </div>
        )
    }
}

export default MenuManagementPage