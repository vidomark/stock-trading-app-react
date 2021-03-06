import "./App.css";
import Header from "./components/Header";
import InputField from "./components/InputField";
import StockResult from "./components/StockResult";
import { useState } from "react";

function App() {
  const [stock, setStock] = useState({});

  const setStockData = (data) => {
    setStock(data);
  };

  return (
    <div className="App">
      <Header />
      <InputField setStockData={setStockData} />
      <StockResult stock={stock} />
    </div>
  );
}

export default App;
