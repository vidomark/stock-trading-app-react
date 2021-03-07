import React from "react";
import { Navbar } from "react-bootstrap";

export default function Header() {
  const style = {
    opacity: 0.8,
  };

  return (
    <Navbar bg="light" expand="lg" style={style}>
      <Navbar.Brand href="">Stock Trader App</Navbar.Brand>
      <Navbar.Toggle aria-controls="basic-navbar-nav" />
    </Navbar>
  );
}
