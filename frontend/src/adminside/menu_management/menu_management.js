import React, { Component } from 'react'
import Sidebar from '../sidebar'

const MenuList = (props) => {
    const rows = props.menuData.map((row, index) => {
        return (
            <td className="menu">
                <label>
                    {row.name}
                    <button>See Schedule</button>
                </label>
                <br></br>
                <label>
                    {row.description}
                    <button>Edit</button>
                    <button onClick={() => props.removeMenu(row.id)}>Delete</button>
                </label>
            </td>
        )
    })

    return <tbody>{rows}</tbody>
}

class MenuManagementPage extends Component {
    state = {
        menus: [
            {
                name: "Breakfast",
                description: "The daily menu for breakfast food.",
                id: 0
            },
            {
                name: "Lunch",
                description: "The lunch menu.",
                id: 1
            },
            {
                name: "Dinner",
                description: "The menu for dinnertime food.",
                id: 2
            },
            {
                name: "Desert",
                description: "A special menu for sweets and desert.",
                id: 3
            }
        ]
    }

    removeMenu = (id) => {
        const { menus } = this.state

        this.setState({
            menus: menus.filter((menu, i) => {
                return i !== id
            })
        })
    }

    render() {
        const { menus } = this.state

        return (
            <div className="menuManagementPage">
                <Sidebar />
                <main>
                    <h1>Menu Management Page</h1>
                    <div className="menuList">
                        <table>
                            <MenuList menuData={menus} removeMenu={this.removeMenu} />
                        </table>
                    </div>
                </main>
            </div>
        )
    }
}

export default MenuManagementPage