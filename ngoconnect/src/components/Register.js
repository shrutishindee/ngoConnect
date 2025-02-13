// import React, { useState } from "react";
// import axios from "axios"; // Import axios
// import "../css/Register.css";

// const Register = () => {
//   const [name, setName] = useState("");
//   const [email, setEmail] = useState("");
//   const [contactNo, setContactNo] = useState("");
//   const [password, setPassword] = useState(""); // Add password field
//   const [userRole, setUserRole] = useState("donor");
//   const [volunteerAvailability, setVolunteerAvailability] = useState(""); // For volunteer
//   const [volunteerSkills, setVolunteerSkills] = useState(""); // For volunteer
//   const [errorMessage, setErrorMessage] = useState(""); // To display errors
//   const [successMessage, setSuccessMessage] = useState(""); // To display success messages

//   // List of available roles
//   const roles = ["donor", "volunteer", "admin"];

//   const handleSubmit = async (e) => {
//     e.preventDefault();

//     // Prepare user data based on the role
//     const userData = {
//       name,
//       email,
//       contactNumber: contactNo,
//       password, // Add password to the user data
//       role: userRole.toUpperCase(), // Convert to uppercase as per the backend
//       volunteerAvailability:
//         userRole === "volunteer" ? volunteerAvailability : null, // Include for volunteer
//       volunteerSkills: userRole === "volunteer" ? volunteerSkills : null, // Include for volunteer
//     };

//     try {
//       // Send POST request to backend
//       const response = await axios.post(
//         "http://localhost:8080/users/register",
//         {
//           method: "POST",
//           headers: { "Content-Type": "application/json" },
//           body: JSON.stringify(userData),
//         }
//       );

//       //   userData,
//       //   {
//       //     headers: { "Content-Type": "application/json" },
//       //   }
//       // );

//       // On success, show success message
//       setSuccessMessage("Registration successful!");
//       setErrorMessage(""); // Clear any error message
//       console.log(response.data); // Handle the response if needed
//     } catch (error) {
//       // On error, show the error message
//       setErrorMessage("Registration failed. Please try again.");
//       setSuccessMessage(""); // Clear any success message
//       console.error(error);
//     }
//   };

//   return (
//     <div className="register-container">
//       <h2 className="register-title">Register</h2>

//       {/* Show success or error message */}
//       {successMessage && (
//         <div className="success-message">{successMessage}</div>
//       )}
//       {errorMessage && <div className="error-message">{errorMessage}</div>}

//       <form onSubmit={handleSubmit} className="register-form">
//         <label>Name</label>
//         <input
//           type="text"
//           placeholder="Enter your name"
//           value={name}
//           onChange={(e) => setName(e.target.value)}
//           required
//         />
//         <label>Email</label>
//         <input
//           type="email"
//           placeholder="Enter your email"
//           value={email}
//           onChange={(e) => setEmail(e.target.value)}
//           required
//         />
//         <label>Contact No</label>
//         <input
//           type="tel"
//           placeholder="Enter your contact number"
//           value={contactNo}
//           onChange={(e) => setContactNo(e.target.value)}
//           required
//         />
//         <label>Password</label>
//         <input
//           type="password"
//           placeholder="Enter your password"
//           value={password}
//           onChange={(e) => setPassword(e.target.value)}
//           required
//         />
//         <label>User Role</label>
//         <select
//           value={userRole}
//           onChange={(e) => setUserRole(e.target.value)}
//           required
//         >
//           {roles.map((role) => (
//             <option key={role} value={role}>
//               {role.charAt(0).toUpperCase() + role.slice(1)}
//             </option>
//           ))}
//         </select>

//         {/* Show volunteer specific fields if role is volunteer */}
//         {userRole === "volunteer" && (
//           <>
//             <label>Volunteer Availability</label>
//             <select
//               value={volunteerAvailability}
//               onChange={(e) => setVolunteerAvailability(e.target.value)}
//               required
//             >
//               <option value="">Select Availability</option>
//               <option value="WEEKDAYS_ONLY">Weekdays Only</option>
//               <option value="WEEKENDS_ONLY">Weekends Only</option>
//               <option value="ANYTIME">Anytime</option>
//             </select>

//             <label>Volunteer Skills</label>
//             <input
//               type="text"
//               placeholder="Enter your volunteer skills"
//               value={volunteerSkills}
//               onChange={(e) => setVolunteerSkills(e.target.value)}
//             />
//           </>
//         )}

//         <button type="submit" className="register-button">
//           Register
//         </button>
//       </form>
//     </div>
//   );
// };

// export default Register;

import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import "../css/Register.css";

const Register = () => {
  const [name, setName] = useState("");
  const [email, setEmail] = useState("");
  const [contactNo, setContactNo] = useState("");
  const [password, setPassword] = useState(""); // Add password field
  const [userRole, setUserRole] = useState("donor");
  const [volunteerAvailability, setVolunteerAvailability] = useState(""); // For volunteer
  const [volunteerSkills, setVolunteerSkills] = useState(""); // For volunteer
  const [errorMessage, setErrorMessage] = useState(""); // To display errors
  const [successMessage] = useState(""); // To display success messages
  const navigate = useNavigate();

  // List of available roles
  const roles = ["donor", "volunteer"];

  const handleSubmit = async (e) => {
    e.preventDefault();
    if (
      userRole === "volunteer" &&
      (!volunteerAvailability || !volunteerSkills)
    ) {
      setErrorMessage("Volunteer details are required");
      return;
    }
    setErrorMessage("");

    // Prepare user data based on the role
    const userData = {
      name,
      email,
      contactNumber: contactNo,
      password, // Add password to the user data
      role: `ROLE_${userRole.toUpperCase()}`, // Convert to uppercase as per the backend
      volunteerAvailability:
        userRole === "volunteer" ? volunteerAvailability : null, // Include for volunteer
      volunteerSkills: userRole === "volunteer" ? volunteerSkills : null, // Include for volunteer
    };

    try {
      // Send POST request to backend
      const response = await fetch("http://localhost:8080/users/register", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(userData),
      });

      if (response.ok) {
        alert("Registration Successful");
        navigate("/login");
      } else {
        const errorData = await response.json();
        setErrorMessage(errorData.message || "Registration Failed");
      }
    } catch (error) {
      setErrorMessage("Something went wrong. Please try again.");
    }
  };
  return (
    <div className="register-container">
      <h2 className="register-title">Register</h2>

      {/* Show success or error message */}
      {successMessage && (
        <div className="success-message">{successMessage}</div>
      )}
      {errorMessage && <div className="error-message">{errorMessage}</div>}

      <form onSubmit={handleSubmit} className="register-form">
        <label>Name</label>
        <input
          type="text"
          placeholder="Enter your name"
          value={name}
          onChange={(e) => setName(e.target.value)}
          required
        />
        <label>Email</label>
        <input
          type="email"
          placeholder="Enter your email"
          value={email}
          onChange={(e) => setEmail(e.target.value)}
          required
        />
        <label>Contact No</label>
        <input
          type="tel"
          placeholder="Enter your contact number"
          value={contactNo}
          onChange={(e) => setContactNo(e.target.value)}
          required
        />
        <label>Password</label>
        <input
          type="password"
          placeholder="Enter your password"
          value={password}
          onChange={(e) => setPassword(e.target.value)}
          required
        />
        <label>User Role</label>
        <select
          value={userRole}
          onChange={(e) => setUserRole(e.target.value)}
          required
        >
          {roles.map((role) => (
            <option key={role} value={role}>
              {role.charAt(0).toUpperCase() + role.slice(1)}
            </option>
          ))}
        </select>

        {/* Show volunteer specific fields if role is volunteer */}
        {userRole === "volunteer" && (
          <>
            <label>Volunteer Availability</label>
            <select
              value={volunteerAvailability}
              onChange={(e) => setVolunteerAvailability(e.target.value)}
              required
            >
              <option value="">Select Availability</option>
              <option value="WEEKDAYS_ONLY">Weekdays Only</option>
              <option value="WEEKENDS_ONLY">Weekends Only</option>
              <option value="ANYTIME">Anytime</option>
            </select>

            <label>Volunteer Skills</label>
            <input
              type="text"
              placeholder="Enter your volunteer skills"
              value={volunteerSkills}
              onChange={(e) => setVolunteerSkills(e.target.value)}
            />
          </>
        )}

        <button type="submit" className="register-button">
          Register
        </button>
      </form>
    </div>
  );
};

export default Register;
