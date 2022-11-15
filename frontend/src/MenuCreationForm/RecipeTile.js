import React from 'react'
import "./RecipeTile.css";

export default function RecipeTile({ recipe }) {
  return (
    // recipe["recipe"]["image"].match(/\.(jpeg|jpg|gif|png)$/) != null && (

    <div className="recipeTile">
        <img className="recipeTile__img" src={recipe["recipe"]["image"]} />
        <a href={recipe['recipe']['url']}>
            <p className="recipeTile__name"> {recipe["recipe"]["label"]}</p>
            </a>

    </div>

  );
}