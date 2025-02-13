import React from "react";
import { Link } from "react-router-dom"; // Import Link from react-router-dom
import "../css/GetInvolved.css";

const GetInvolved = () => {
  return (
    <div className="getinvolved-container">
      <h1 className="getinvolved-title">Get Involved</h1>
      <p className="getinvolved-description">
        There are many ways you can contribute to our cause! Whether you want to
        volunteer your time or donate, every action helps.
      </p>
      <div className="getinvolved-options">
        <div className="option">
          <h3>Become a Volunteer</h3>
          <p>
            Sign up to become a volunteer and help us with various community
            projects.
          </p>
          {/* Button to Register page */}
          <Link to="/register">
            <button className="getinvolved-button">Sign Up to Volunteer</button>
          </Link>
        </div>
        <div className="option">
          <h3>Donate Now</h3>
          <p>
            Your donations allow us to fund our programs and make a real impact
            on those in need.
          </p>
          {/* Button to Register page */}
          <Link to="/register">
            <button className="getinvolved-button">Donate Now</button>
          </Link>
        </div>
      </div>
    </div>
  );
};

export default GetInvolved;
