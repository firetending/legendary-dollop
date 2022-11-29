import React from 'react'

export const MenuCard = ( {recipe }) => {
  return (
    <div>
    <img className="recipeTile__img" src={recipe["recipe"]["image"]} alt="food pictures"/>
        <a href={recipe['recipe']['url']}>
            <p className="recipeTile__name"> {recipe["recipe"]["label"]}</p>
        </a>
    </div>

  )
}
