import React from "react";
import { Card } from "react-bootstrap";

export default function StockResult(props) {
  const style = {
    opacity: 0.9,
  };

  return props.stock.symbol != null ? (
    <Card className="m-5" style={style}>
      <div>Symbol: {props.stock.symbol}</div>
      <div>Price: {props.stock.price}</div>
      <div>{props.stock.message}</div>
    </Card>
  ) : (
    <Card className="m-5" style={style}>
      <h5 className="pt-2 pb-1">Please enter a symbol and price!</h5>
    </Card>
  );
}
