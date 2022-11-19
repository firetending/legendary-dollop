import React from 'react';
import Axios from 'axios';
import { useState} from 'react';
import RecipeTile from './RecipeTile';
import './MenuCreationForm.css';



function MenuCreationForm() {

  const [query, setQuery] = useState("");
  const [recipes, setRecipes] = useState([]);
  const [healthLabels, sethealthLabels] = useState("dairy-free");

  var url = `https://api.edamam.com/search?q=${query}&
  app_id=${process.env.REACT_APP_YOUR_APP_ID}
  &app_key=&${process.env.REACT_APP_YOUR_APP_KEY}
  &health=${healthLabels}`;

  async function getRecipes(){
    var result = await Axios.get(url);
    setRecipes(result.data.hits);
    console.log(result.data);
  }

  const onSubmit = (e) => {
    e.preventDefault();
    getRecipes();
  }

  return (
    <div className="MenuCreationForm">
      <h1>🥞🍱🥗 Food Recipes 🍜🍤🍔</h1>
      <form className="MenuCreationForm__searchForm" onSubmit={onSubmit}>
        <input type="text"
        className="MenuCreationForm__input"
        placeholder='Enter ingredient'
        value={query}
        onChange={ (e)=> setQuery(e.target.value)}
        />
        <input className="MenuCreationForm__searchButton" type='submit' value="Search" />

        <div className="MenuCreationForm__healthLabels">
        <p>Please select :  </p>
        <select className="MenuCreationForm__healthLabels">
          <option onClick={() => sethealthLabels("dairy-free")}>Dairy free</option>
          <option onClick={() => sethealthLabels("gluten-free")}>Gluten free</option>
          <option onClick={() => sethealthLabels("vegan")}>Vegan</option>
          <option onClick={() => sethealthLabels("vegetarian")}>Vegetarian</option>
          <option onClick={() => sethealthLabels("pecatarian")}>Pecatarian</option>
        </select>
        </div>
        </form>


      <div className="MenuCreationForm__recipes">
        {recipes.map((recipe) => {
          return < RecipeTile recipe={recipe}/>;
        })}
      </div>

    </div>
  );
}

export default MenuCreationForm;