import React, { Component } from 'react'
import './adminstyles.css'

class Sidebar extends Component {
    render() {
        return (
            <div className="sidebar">
                <table>
                    {/**Will be replaced with links after the pages are created.**/}
                    <tr>Dashboard</tr>
                    <tr>Menus</tr>
                    <tr>Administration</tr>
                    <tr>Reports</tr>
                    <tr>Order Log</tr>
                </table>
            </div>
        )
    }
}

export default Sidebar