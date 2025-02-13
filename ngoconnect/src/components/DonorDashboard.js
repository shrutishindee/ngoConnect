import React, { useEffect, useState } from "react";

const DonorDashboard = () => {
  const [user, setUser] = useState(null);

  useEffect(() => {
    // Retrieve user data from localStorage
    const userData = JSON.parse(localStorage.getItem("user"));
    if (userData) {
      setUser(userData); // Set user data to state
    } else {
      // If there's no user data, redirect to login page
      window.location.href = "/"; // Redirect to login page if user not found
    }
  }, []);

  const handleLogout = () => {
    // Clear the localStorage data
    localStorage.clear();

    // Redirect to the homepage after logout
    window.location.href = "/"; // Redirect to homepage
  };

  if (!user) {
    return <div>Loading...</div>;
  }

  // Remove "ROLE_" from the role string
  const role = user.role.replace("ROLE_", "");

  return (
    <div className="dashboard-container">
      <h2>Welcome, {user.name}</h2>
      <p>Role: {role}</p>
      {/* Additional dashboard content here */}
      <button onClick={handleLogout}>Logout</button>
    </div>
  );
};

export default DonorDashboard;
