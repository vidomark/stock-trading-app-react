# Strock trading app

The application is a mock trading app for practicing spring boot.

## Installation

1. Clone this repository: `git clone https://github.com/vidomark/pokedex-backend`
2. Open the project with an IDE and the configuration will be downloaded by gradle, then start the application.
3. To start the react app, open the frontend directory with VSCode and run `npm start`

## Usage

- On localhost:3000, write a symbol and a price to fetch the data from `https://run.mocky.io/v3/9e14e086-84c2-4f98-9e36-54928830c980` (mock stock data)

## About

The backend (spring boot) fetches the pokemon data from a 3rd party api (https://run.mocky.io/v3/9e14e086-84c2-4f98-9e36-54928830c980) and uses react to display the content.
On the main page there you can write a symbol and a price for the stock. Since it's a mock api, the fetched results will be the same all the time.
The project was to develop my first spring application and to practice working with the framework.
