import "./App.css";
import Header from "./components/Header";
import InputField from "./components/InputField";
import StockResult from "./components/StockResult";
import { useState } from "react";
import backgroundImg from "./resources/backround.jpg";
import FullHeight from "react-full-height";

function App() {
  const [stock, setStock] = useState({});

  const setStockData = (data) => {
    setStock(data);
  };

  return (
    <FullHeight
      className="App"
      style={{ backgroundImage: `url(${backgroundImg})` }}
    >
      <Header />
      <InputField setStockData={setStockData} />
      <StockResult stock={stock} />
    </FullHeight>
  );
}

export default App;
