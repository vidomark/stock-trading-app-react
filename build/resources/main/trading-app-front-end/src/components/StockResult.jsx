import React from "react";
import { Card } from "react-bootstrap";

export default function StockResult(props) {
  return props.stock.symbol != null ? (
    <Card>Stock</Card>
  ) : (
    <Card className="mt-4">
      <h5 className="pt-2 pb-1">Please enter a symbol and price!</h5>
    </Card>
  );
}
