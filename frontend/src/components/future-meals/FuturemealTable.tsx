import React from 'react';
import { Table, Button } from 'react-bootstrap';
import './FuturemealTable.scss';

const TableHeader = () => {
    return (
      
      <thead>
        <tr>
          <th>Date</th>
          <th>Meal</th>
          <th>Choice</th>
        </tr>
      </thead>
     
    )
  }

  const TableBody = (props: { characterData: any[]; removeCharacter: (arg0: any) => any; }) => {
    const rows = props.characterData.map((row,index) => {
        return (
            <tr key={index}>
                <td>{row.date}</td>
                <td>{row.name}</td>
                <td>{row.job}</td>
                <td >
                    <Button onClick={() => props.removeCharacter(index)}>Edit</Button>{' '}
                    <Button onClick={() => props.removeCharacter(index)}>Delete</Button>
                </td>

            </tr>
        )
    })
    return <tbody>{rows}</tbody>
  }

  const FuturemealTable = (props: { characterData: any; removeCharacter: any; }) => {
    const { characterData, removeCharacter } = props

    return (
      <div className='container future-meal'>
        <Table striped bordered hover >
            <TableHeader />
            <TableBody characterData={characterData} removeCharacter={removeCharacter} />
        </Table>
        </div>
    )

}   

export default FuturemealTable