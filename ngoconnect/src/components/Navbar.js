import React from "react";
import { Link } from "react-router-dom";
import "../css/Navbar.css";

const Navbar = () => {
  return (
    <nav className="navbar">
      <ul className="navbar-links">
        <li className="navbar-item">
          <a href="/">Home</a>
        </li>
        <li className="navbar-item">
          <a href="/about">About Us</a>
        </li>
        <li className="navbar-item">
          <Link to="/projects">Projects</Link>
        </li>
        <li className="navbar-item">
          <Link to="/events">Events</Link>
        </li>
        <li className="navbar-item">
          <a href="/get-involved">Get Involved</a>
        </li>
        <li className="navbar-item">
          <a href="/login">Login</a>
        </li>
        <li className="navbar-item">
          <a href="/register">Register</a>
        </li>
      </ul>
    </nav>
  );
};

export default Navbar;
