import React from "react";
import { Form, Button } from "react-bootstrap";

export default function InputField() {
  return (
    <div>
      <Form>
        <Form.Group controlId="">
          <Form.Label>Enter a stock symbol (for example aapl)</Form.Label>
          <Form.Control type="text" placeholder="Enter stock" />
        </Form.Group>

        <Form.Group controlId="">
          <Form.Label>
            Enter the maximum price you are willing to pay
          </Form.Label>
          <Form.Control type="password" placeholder="Price" />
        </Form.Group>
        <Button variant="primary" type="submit">
          Submit
        </Button>
      </Form>
    </div>
  );
}
