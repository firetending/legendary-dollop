import React, { Component } from 'react'
import Sidebar from '../sidebar'
import '../adminstyles.css'

const DietaryRestrictionList = (props) => {
    const rows = props.dietTagData.map((row, index) => {
        return (
            <li>
                <label>{row.name}<input type='checkbox' name={props.menuId} id={row.id} className='dietTag'
                    onChange={() => props.updateDietTags(props.menuId)}
                /></label>
            </li>
        )
    })

    return <ul>{rows}</ul>
}

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
                    <div className='dietTagList'>
                        <DietaryRestrictionList dietTagData={props.dietTagData} menuId={row.id} updateDietTags={props.updateDietTags} />
                    </div>
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
                id: 0,
                dietTagIds: []
            },
            {
                name: "Lunch",
                description: "The lunch menu.",
                id: 1,
                dietTagIds: []
            },
            {
                name: "Dinner",
                description: "The menu for dinnertime food.",
                id: 2,
                dietTagIds: []
            },
            {
                name: "Desert",
                description: "A special menu for sweets and desert.",
                id: 3,
                dietTagIds: []
            }
        ],
        dietTags: [
            {
                name: "Vegetarian",
                id: 0
            },
            {
                name: "Vegan",
                id: 1
            },
            {
                name: "Diabetic",
                id: 2
            },
            {
                name: "Lactose Intolerant",
                id: 3
            },
            {
                name: "Kosher",
                id: 4
            },
            {
                name: "Halal",
                id: 5
            },
            {
                name: "Gluten Free",
                id: 6
            }
        ]
    }

    removeMenu = (id) => {
        const { menus, dietTags } = this.state
        this.setState({
            menus: menus.filter((menu, i) => {
                return menu.id !== id
            })
        })
    }

    updateDietTags = (menuId) => {
        console.log(document.getElementsByName(menuId))
    }

    render() {
        const { menus, dietTags } = this.state

        return (
            <div className="menuManagementPage">
                <Sidebar />
                <main>
                    <h1 className='title'>Menu Management</h1>
                    <div className="menuList">
                        <table>
                            <MenuList menuData={menus} dietTagData={dietTags} removeMenu={this.removeMenu} updateDietTags={this.updateDietTags} />
                        </table>
                    </div>
                </main>
            </div>
        )
    }
}

export default MenuManagementPage