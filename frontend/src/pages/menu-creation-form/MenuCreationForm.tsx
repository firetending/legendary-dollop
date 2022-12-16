import React from 'react';
import Axios from 'axios';
import { useState } from 'react';
import { RecipeTile } from '../../components/recipe-tile/RecipeTile';
import doAxiosFetch from '../../utils/doAxiosFetch';
import './MenuCreationForm.css';


function MenuCreationForm() {
  console.log('Menu creation');
  const [query, setQuery] = useState("");
  const [recipes, setRecipes] = useState([]);
  const [healthLabel, sethealthLabel] = useState("dairy-free");

  const url = `https://api.edamam.com/search?q=${query}&
    app_id=${process.env.REACT_APP_YOUR_APP_ID}
    &app_key=&${process.env.REACT_APP_YOUR_APP_KEY}&health=${healthLabel}`;

  async function getRecipes(){

    await doAxiosFetch({
      method: "GET",
      url: url, 
      headers: {  }  

    }).then(async (result: any) => { 
      console.log('Result: ' + JSON.stringify(result));      
      await setRecipes(result.data.hits);
      console.log('Data: ' + recipes);
      
    }).then(() => console.log('Data: ' + recipes))
    .catch(() => setRecipes([]));
  }

  const onSubmit = (e: any) => {
    e.preventDefault();
    getRecipes();
    setQuery(e.target.value);
  }


  return (
    <div className="MenuCreationForm">
      <h1>Select Your Meal</h1>
      <br />
      <form className="MenuCreationForm__searchForm" onSubmit={onSubmit} >
        <input type="text"
        className="MenuCreationForm__input"
        placeholder='Enter ingredient'
        value={query}
        onChange={ (e)=> setQuery(e.target.value)}
        />


        <div className="MenuCreationForm__healthLabel">
        <label>Select Restrictions: </label>

        <select 
          className="MenuCreationForm__healthLabel"
          value={healthLabel}
          onChange= { (e) => sethealthLabel(e.target.value)
          }
        >
          <option value="dairy-free">Dairy free</option>
          <option value="gluten-free" >Gluten free</option>
          <option value="peanut-free" >Peanut Free</option>
          <option value="shellfish-free">Shellfish free</option>
          <option value="low-sugar" >Low sugar</option>
          <option value="vegan" >Vegan</option>
          <option value="vegetarian" >Vegetarian</option> 
        </select>

        
        </div> 

        <input className="MenuCreationForm__searchButton" type='submit' value="Search" />
        </form>



      <div className="MenuCreationForm__recipes">
        <ul>
        {
          recipes.map((recipe: any) => (
            <li key={recipe.id}>
            <RecipeTile  recipe={recipe}/>;
            </li>
          ))
        }
        </ul>
      </div>
    </div>
  );
}

export default MenuCreationForm;