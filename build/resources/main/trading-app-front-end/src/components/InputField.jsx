import React, { useState } from "react";
import { InputGroup, Button, FormControl } from "react-bootstrap";
import axios from "axios";

export default function InputField(props) {
  const [stockSymbol, setStockSymbol] = useState("");
  const [stockPrice, setStockPrice] = useState(null);

  const fetchStockData = () => {
    const symbol = stockSymbol;
    const price = stockPrice;
    const url = `http://localhost:8080/?symbol=${symbol}&price=${price}`;
    axios.get(url).then((result) => setStock(result.data));
  };

  const setStock = (data) => {
    props.setStockData(data);
  };

  const style = {
    opacity: 0.9,
  };

  return (
    <div className="m-5">
      <label className="input-label">
        Enter a stock symbol (for example aapl)
      </label>
      <InputGroup className="mb-3">
        <InputGroup.Prepend>
          <InputGroup.Text id="inputGroup-sizing-default">
            Symbol
          </InputGroup.Text>
        </InputGroup.Prepend>

        <FormControl
          aria-label="Default"
          aria-describedby="inputGroup-sizing-default"
          style={style}
          onChange={(event) => {
            setStockSymbol(event.target.value);
          }}
        />
      </InputGroup>

      <label className="input-label">
        Enter the maximum price you are willing to pay
      </label>
      <InputGroup className="mb-3">
        <InputGroup.Prepend>
          <InputGroup.Text id="inputGroup-sizing-default">
            Price
          </InputGroup.Text>
        </InputGroup.Prepend>
        <FormControl
          aria-label="Default"
          aria-describedby="inputGroup-sizing-default"
          style={style}
          onChange={(event) => {
            setStockPrice(event.target.value);
          }}
        />
      </InputGroup>

      <Button onClick={fetchStockData}>Submit</Button>
    </div>
  );
}
